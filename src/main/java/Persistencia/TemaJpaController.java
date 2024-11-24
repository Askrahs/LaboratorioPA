package Persistencia;

import Logica.Album;
import Logica.ControllerUsuario;
import Logica.IControllerUsuario;
import Logica.Tema;
import Persistencia.exceptions.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

public class TemaJpaController {

    private EntityManagerFactory emf = null;
    private IControllerUsuario ctrlU;

    public TemaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public TemaJpaController(){
        emf = Persistence.createEntityManagerFactory("EspotifyBD");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tema tema) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(tema);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw ex;
        } finally {
            em.close();
        }
    }

    public void edit(Tema tema) throws NonexistentEntityException, Exception {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            tema = em.merge(tema);
            tx.commit();
        } catch (Exception ex) {
            if (findTema(tema.getId()) == null) {
                throw new NonexistentEntityException("The tema with id " + tema.getId() + " no longer exists.");
            }
            throw ex;
        } finally {
            em.close();
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Tema tema;
            try {
                tema = em.getReference(Tema.class, id);
                tema.getId(); // Esto lanza una excepción si el tema no existe
            } catch (Exception e) {
                throw new NonexistentEntityException("The tema with id " + id + " no longer exists.");
            }
            em.remove(tema);
            tx.commit();
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            em.close();
        }
    }

    public Tema findTema(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tema.class, id);
        } finally {
            em.close();
        }
    }

    public List<Tema> findTemaEntities() {
        return findTemaEntities(true, -1, -1);
    }

    public List<Tema> findTemaEntities(int maxResults, int firstResult) {
        return findTemaEntities(false, maxResults, firstResult);
    }

    private List<Tema> findTemaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT t FROM Tema t");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public int getTemaCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT COUNT(t) FROM Tema t");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    
     public Tema findTemaPorNombre(String nombreTema) {
        EntityManager em = getEntityManager();
            try {
                TypedQuery<Tema> query = em.createQuery(
                    "SELECT t FROM Tema t WHERE t.nombre = :nombre", Tema.class);
                query.setParameter("nombre", nombreTema);
                return query.getSingleResult();
            } catch (NoResultException e) {
                return null;
            } finally {
                em.close();
            }
    }
     public List<Tema> obtenerTemaPorNombredeAlbum(String nombreAlbum){
        EntityManager em = getEntityManager();
        List <Tema> temas = em.createQuery("SELECT t from Tema t where t.album.titulo = :nombreAlbum",Tema.class).setParameter("nombreAlbum",nombreAlbum).getResultList();
        return temas;
     }
     
    public List<Tema> obtenerTodosLosTemas() {
        EntityManager em = getEntityManager();
            try {
                TypedQuery<Tema> query = em.createQuery(
                    "SELECT t FROM Tema t", Tema.class);
                return query.getResultList();
            } catch (NoResultException e) {
                return null;
            } finally {
                em.close();
            }
    }
    
    public Tema findTemaPorDatos(String nombreTema, String duracion, String enlace, int posicion) {
        EntityManager em = getEntityManager();
            try {
                TypedQuery<Tema> query = em.createQuery(
                    "SELECT t FROM Tema t WHERE t.nombre = :nombre AND t.duracion = :duracion AND t.enlace = :enlace AND t.posicion = :posicion", Tema.class);
                query.setParameter("nombre", nombreTema);
                query.setParameter("duracion", duracion);
                query.setParameter("enlace", enlace);
                query.setParameter("posicion", posicion);
                return query.getSingleResult();
            } catch (NoResultException e) {
                return null;
            } finally {
                em.close();
            }
    }

    public Tema findTemaPorTitulo(String temaSeleccionado) {
        EntityManager em = getEntityManager();
            try {
                TypedQuery<Tema> query = em.createQuery(
                    "SELECT t FROM Tema t WHERE t.nombre = :nombre", Tema.class);
                query.setParameter("nombre", temaSeleccionado);
                return query.getSingleResult();
            } catch (NoResultException e) {
                return null;
            } finally {
                em.close();
            }
    }

    public void darDeBajaTemasCliente(Set<Integer> albumIds) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();

            // Obtener IDs de los temas asociados a los álbumes
            String temasQuery = "SELECT t.id FROM Tema t WHERE t.album.id IN :albumIds";
            List<Integer> temaIds = em.createQuery(temasQuery, Integer.class)
                                      .setParameter("albumIds", albumIds)
                                      .getResultList();

            if (!temaIds.isEmpty()) {
                // Eliminar vínculos en la tabla cliente_tema_favorito
                String deleteQuery = "DELETE FROM cliente_tema_favorito WHERE tema_id IN :temaIds";
                em.createNativeQuery(deleteQuery)
                  .setParameter("temaIds", temaIds)
                  .executeUpdate();
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public boolean temaValido(Tema t) {
        EntityManager em = getEntityManager();
        try {
            // Consulta para obtener el artista del álbum al que pertenece el tema
            String query = "SELECT a.artista.nickname FROM Tema t JOIN t.album a WHERE t.id = :temaId";
            String nicknameArtista = em.createQuery(query, String.class)
                                       .setParameter("temaId", t.getId())
                                       .getSingleResult();

            // Verificar si el artista está activo
            return ctrlU.artistaActivo(nicknameArtista);
        } catch (NoResultException e) {
            // Si el tema no tiene álbum o no se encuentra el artista
            return false;
        } finally {
            em.close();
        }
    }
    
    
    public boolean sumoRepro(Tema t){
    EntityManager em = getEntityManager();
    try {
        JOptionPane.showMessageDialog(null,"LLEGUE A EL REPRODU");
        em.getTransaction().begin();
        // Recupera el tema desde la base de datos
        Tema temaActualizado = em.find(Tema.class, t.getId());
        if (temaActualizado != null) {
            // Incrementa el contador de descargas
            temaActualizado.setReproduccion(temaActualizado.getReproduccion() + 1);
            em.merge(temaActualizado); // Asegura que los cambios sean persistidos
            em.getTransaction().commit();
            return true; // Operación exitosa
        } else {
            em.getTransaction().rollback();
            return false; // Tema no encontrado
        }
    } catch (Exception e) {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        e.printStackTrace();
        return false; // Error durante la operación
    } finally {
        em.close();
    }
    }
    
    public boolean sumoDescarga(Tema t) {
    EntityManager em = getEntityManager();
    try {
        em.getTransaction().begin();
        // Recupera el tema desde la base de datos
        Tema temaActualizado = em.find(Tema.class, t.getId());
        if (temaActualizado != null) {
            // Incrementa el contador de descargas
            temaActualizado.setDescarga(temaActualizado.getDescarga() + 1);
            em.merge(temaActualizado); // Asegura que los cambios sean persistidos
            em.getTransaction().commit();
            return true; // Operación exitosa
        } else {
            em.getTransaction().rollback();
            return false; // Tema no encontrado
        }
    } catch (Exception e) {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        e.printStackTrace();
        return false; // Error durante la operación
    } finally {
        em.close();
    }
}

    public int CantidadListasConTema(int temaId) {
         EntityManager em = getEntityManager();
    // Implementación ejemplo: contar cuántas listas incluyen el tema con ID temaId
    return em.createQuery(
            "SELECT COUNT(l) FROM Lista l JOIN l.temas t WHERE t.id = :temaId", Long.class)
            .setParameter("temaId", temaId)
            .getSingleResult()
            .intValue();
}
    
    
    public int CantidadFavoritosConTema(int temaId) {
        EntityManager em = getEntityManager();
    // Contar cuántos clientes tienen este tema como favorito
    return em.createQuery(
            "SELECT COUNT(c) FROM Cliente c JOIN c.temasFavoritos t WHERE t.id = :temaId", Long.class)
            .setParameter("temaId", temaId)
            .getSingleResult()
            .intValue();

    }
}