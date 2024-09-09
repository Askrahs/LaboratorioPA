package Persistencia;

import Logica.Album;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
}