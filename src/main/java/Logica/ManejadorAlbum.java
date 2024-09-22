package Logica;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

public class ManejadorAlbum {
    
    private static ManejadorAlbum instancia = null;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction t;

    // Constructor privado para el patrón Singleton
    public ManejadorAlbum() {
        emf = Persistence.createEntityManagerFactory("EspotifyBD");
        em = emf.createEntityManager();
        t = em.getTransaction(); // Para manejar las transacciones
    }

    // Método estático para obtener la única instancia del manejador
    public static ManejadorAlbum getInstance(){
        if (instancia == null)
            instancia = new ManejadorAlbum();
        return instancia;
    }

    // Método para agregar un nuevo álbum
    public void addAlbum(Album album) {
        try {
            t.begin();
            em.persist(album);  // Persistir el álbum en la base de datos
            t.commit();
        } catch (Exception e) {
            t.rollback();  // Si hay un error, revertir la transacción
            e.printStackTrace();
            throw new RuntimeException("Error al agregar el álbum: " + album.getTitulo(), e);
        }
    }

    // Método para obtener un álbum por su título (asumiendo que el título es único)
    public Album obtenerAlbumPorTitulo(String titulo) {
        try {
            return em.createQuery("SELECT a FROM Album a WHERE a.titulo = :titulo", Album.class)
                     .setParameter("titulo", titulo)
                     .getSingleResult();
        } catch (NoResultException e) {
            return null;  // Retornar null si no se encuentra el álbum
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener el álbum: " + titulo, e);
        }
    }

    // Método para obtener un álbum por su ID
    public Album obtenerAlbumPorId(int id) {
        return em.find(Album.class, id);  // Usar em.find si el ID es la clave primaria
    }

    // Método para listar todos los álbumes
    public List<Album> getAlbums() {
        try {
            return em.createQuery("SELECT a FROM Album a", Album.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener la lista de álbumes.", e);
        }
    }

    // Método para eliminar un álbum por su título
    public void eliminarAlbumPorTitulo(String titulo) {
        try {
            t.begin();
            Album album = obtenerAlbumPorTitulo(titulo);
            if (album != null) {
                em.remove(album);  // Eliminar el álbum de la base de datos
                t.commit();
            } else {
                throw new RuntimeException("El álbum con título '" + titulo + "' no existe.");
            }
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar el álbum: " + titulo, e);
        }
    }

    // Método para actualizar un álbum existente
    public void actualizarAlbum(Album album) {
        try {
            t.begin();
            em.merge(album);  // Actualizar el álbum en la base de datos
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
            throw new RuntimeException("Error al actualizar el álbum: " + album.getTitulo(), e);
        }
    }
}