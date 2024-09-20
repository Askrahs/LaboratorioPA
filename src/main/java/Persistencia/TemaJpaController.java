package Persistencia;

import Logica.Album;
import Logica.Tema;
import Persistencia.exceptions.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class TemaJpaController {

    private EntityManagerFactory emf = null;

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
}