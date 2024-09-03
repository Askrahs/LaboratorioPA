package Logica;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ManejadorLista {
    private static ManejadorLista instancia = null;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction t;
    
    public ManejadorLista(){
        emf = Persistence.createEntityManagerFactory("EspotifyBD");
        em = emf.createEntityManager();
        t = em.getTransaction(); //se usa para las consultas y commits/rollbacks
    }
    
    public static ManejadorLista getInstance(){
        if (instancia == null)
            instancia = new ManejadorLista();
        return instancia;
    }
    
        public void addLista(Lista lista) {
         try {
            t.begin();
            em.persist(lista);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
    }
}
