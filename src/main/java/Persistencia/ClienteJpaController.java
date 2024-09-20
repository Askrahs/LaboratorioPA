package Persistencia;

import Logica.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ClienteJpaController {

    private EntityManagerFactory emf = null;

    public ClienteJpaController() {
        this.emf = Persistence.createEntityManagerFactory("EspotifyBD");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<String> findAllClienteNicknames() {
        EntityManager em = getEntityManager();
        try {
            // Consulta solo para devolver los nicknames de los artistas
            TypedQuery<String> query = em.createQuery("SELECT c.nickname FROM Cliente c", String.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    public List<Tema> findTemasFavoritosDeCliente(String nickname) {
    EntityManager em = getEntityManager();
    try {
        TypedQuery<Tema> query = em.createQuery(
            "SELECT t FROM Cliente c JOIN c.temasFavoritos t WHERE c.nickname = :nickname", Tema.class);
        query.setParameter("nickname", nickname);
        return query.getResultList();
    } finally {
        em.close();
    }
    }
    
    public List<Lista> findListasFavoritasDeCliente(String nickname) {
    EntityManager em = getEntityManager();
    try {
        TypedQuery<Lista> query = em.createQuery(
            "SELECT l FROM Cliente c JOIN c.listasFavoritas l WHERE c.nickname = :nickname", Lista.class);
        query.setParameter("nickname", nickname);
        return query.getResultList();
    } finally {
        em.close();
    }
    }

    public List<Album> findAlbumsFavoritosDeCliente(String nickname) {
    EntityManager em = getEntityManager();
    try {
        TypedQuery<Album> query = em.createQuery(
            "SELECT a FROM Cliente c JOIN c.albumsFavoritos a WHERE c.nickname = :nickname", Album.class);
        query.setParameter("nickname", nickname);
        return query.getResultList();
    } finally {
        em.close();
    }
    }

    
    
}