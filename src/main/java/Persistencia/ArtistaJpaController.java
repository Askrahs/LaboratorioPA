package Persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ArtistaJpaController {

    private EntityManagerFactory emf = null;

    public ArtistaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("EspotifyBD");  // Nombre de tu unidad de persistencia
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<String> findAllArtistaNicknames() {
        EntityManager em = getEntityManager();
        try {
            // Consulta solo para devolver los nicknames de los artistas
            TypedQuery<String> query = em.createQuery("SELECT a.nickname FROM Artista a", String.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}