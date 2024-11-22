package Persistencia;

import Logica.Album;
import LogicaDTO.DTOAlbum;
import Logica.Tema;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

public class AlbumJpaController {

    private EntityManagerFactory emf = null;

    public AlbumJpaController() {
        this.emf = Persistence.createEntityManagerFactory("EspotifyBD");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Album album) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            em.persist(album);

            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Album findAlbum(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Album.class, id);
        } finally {
            em.close();
        }
    }

    public void edit(Album album) throws EntityNotFoundException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            em.merge(album);

            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void delete(Long id) throws EntityNotFoundException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            Album album;
            try {
                album = em.getReference(Album.class, id);
                album.getId();
            } catch (EntityNotFoundException enfe) {
                throw new EntityNotFoundException("El álbum con ID " + id + " no existe.");
            }

            em.remove(album);

            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<String> findAlbumPorGenero(String generoSeleccionado) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<String> query = em.createQuery(
                "SELECT a.titulo FROM Album a JOIN a.generos g WHERE g.nombre = :genero", String.class);
            query.setParameter("genero", generoSeleccionado);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<String> findAlbumPorArtista(String artistaSeleccionado) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<String> query = em.createQuery(
                "SELECT a.titulo FROM Album a WHERE a.artista.nickname = :artista", String.class);
            query.setParameter("artista", artistaSeleccionado);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Album findAlbumPorTitulo(String albumSeleccionado) {
        EntityManager em = getEntityManager();
            try {
                TypedQuery<Album> query = em.createQuery(
                    "SELECT a FROM Album a WHERE a.titulo = :titulo", Album.class);
                query.setParameter("titulo", albumSeleccionado);
                return query.getSingleResult();
                
            } catch (NoResultException e) {
                return null;               
            } finally {
                em.close();
            }
    }

    public boolean artistaYaTieneAlbum(String nicknameArtista, String titulo) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(a) FROM Album a WHERE a.titulo = :titulo AND a.artista.nickname = :nickname", Long.class);
            query.setParameter("titulo", titulo);
            query.setParameter("nickname", nicknameArtista);

            Long count = query.getSingleResult();
            return count > 0; //Si es > 0 significa que existe un album con ese titulo de ese artista
        } finally {
            em.close();
        }
    }
    
    public Album BuscoAlbumParaTemaLista(String nombreAlbum){
        EntityManager em = getEntityManager();
        TypedQuery<Album> query = em.createQuery( "SELECT a from Album a where a.titulo = :titulo", Album.class);
            
            query.setParameter("titulo", nombreAlbum);
            Album alb = null;
            try{        
            alb = query.getSingleResult();
            }catch(Exception e){
                 //System.out.println("No se encontró ninguna lista con el nombre proporcionado.");
            }
              
                    return alb;
    }
    
    public List<Album> todosLosAlbums(){
        EntityManager em = getEntityManager();
    try {
        // Crear la consulta JPQL con JOIN FETCH para cargar los datos asociados
        String jpql = "SELECT DISTINCT a FROM Album a " +
                      "JOIN FETCH a.artista ar " +       // Cargar al artista
                      "LEFT JOIN FETCH a.generos g " +   // Cargar los géneros
                      "LEFT JOIN FETCH a.temas t";       // Cargar los temas
        
        // Ejecutar la consulta y devolver la lista de álbumes
        List<Album> albums = em.createQuery(jpql, Album.class).getResultList();
        return albums;

    } finally {
        em.close(); // Asegurarse de cerrar el EntityManager
    }
    }
    
    public Album findAlbumPorDatos(String artista, String nombreA) {
        EntityManager em = getEntityManager();
            try {
                TypedQuery<Album> query = em.createQuery(
                    "SELECT a FROM Album a WHERE a.artista.nickname = :artista AND a.titulo = :titulo", Album.class);
                query.setParameter("titulo", nombreA);
                //query.setParameter("rutaImagen", rutaImagen);
                query.setParameter("artista", artista);
                //query.setParameter("anio", anio);
                return query.getSingleResult();
            } catch (NoResultException e) {
                return null;
            } finally {
                em.close();
            }
    }   
    
   public DTOAlbum buscoalbumporArtista(String nombrealbum, String nombreartista) {
    try {
        EntityManager em = getEntityManager();
        Album album = em.createQuery(
            "SELECT al FROM Album al JOIN al.artista ar " +
            "WHERE al.titulo = :nombrealbum AND ar.nickname = :nombreartista", Album.class)
            .setParameter("nombrealbum", nombrealbum)
            .setParameter("nombreartista", nombreartista)
            .getSingleResult();
        String Artista = album.getArtista().getNickname();
        // Transformar el álbum encontrado en un DTOAlbum y devolverlo
        DTOAlbum dtoAlbum = new DTOAlbum(album.getTitulo(),album.getAnio(),album.getRutaImagen(),Artista);
        

        return dtoAlbum;
    } catch (NoResultException e) {
        System.out.println("No se encontró ningún álbum con el nombre y artista especificados.");
        return null;
    }
    }

    public boolean albumEsDeXGenero(String albumTitulo, String artistaNickname, String generoNombre) {
       EntityManager em = getEntityManager();
        try {
            // Crear la consulta JPQL para verificar si el álbum está relacionado con el género
            String jpql = "SELECT COUNT(a) FROM Album a " +
                          "JOIN a.generos g " +
                          "WHERE a.titulo = :tituloAlbum " +
                          "AND a.artista.nickname = :nicknameArtista " +
                          "AND g.nombre = :nombreGenero";

            // Ejecutar la consulta
            Long count = (Long) em.createQuery(jpql)
                            .setParameter("tituloAlbum", albumTitulo)
                            .setParameter("nicknameArtista", artistaNickname)
                            .setParameter("nombreGenero", generoNombre)
                            .getSingleResult();

            // Si el conteo es mayor a 0, entonces existe esa relación
            return count > 0;

        } finally {
            em.close(); // Asegurarse de cerrar el EntityManager
        }
    }

   public List<Tema> temasDelAlbum(String titulo) {
        EntityManager em = getEntityManager();
        try {
            String jpql = "SELECT t FROM Tema t " +
                          "JOIN t.album a " +
                          "WHERE a.titulo = :tituloAlbum " +
                          "ORDER BY t.posicion ASC";

            return em.createQuery(jpql, Tema.class)
                    .setParameter("tituloAlbum", titulo)
                    .getResultList();

        } finally {
            em.close();
        }
    }

    public Set<Integer> obtenerTodosLosIDAlbumsDelArtista(String nickname) {
        EntityManager em = getEntityManager();
        try {
            return new HashSet<>(em.createQuery(
                "SELECT a.id FROM Album a WHERE a.artista.nickname = :nickname", Integer.class)
                .setParameter("nickname", nickname)
                .getResultList());
        } finally {
            em.close();
        }
    }

    public void darDeBajaAlbumsCliente(Set<Integer> albumIds) {
        if (albumIds == null || albumIds.isEmpty()) {
            return; // No hay nada que borrar
        }
       EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();

            // Eliminar registros de la tabla cliente_album_favorito basados solo en album_id
            String sql = "DELETE FROM cliente_album_favorito WHERE album_id IN :albumIds";
            Query query = em.createNativeQuery(sql);
            query.setParameter("albumIds", albumIds);

            query.executeUpdate();

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e; // Relanzar la excepción
        } finally {
            em.close();
        }
    }
}