package Logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

//El mapeo consiste en artistas y los titulos de los albums
public class ManejadorAlbum {
    private static ManejadorAlbum instancia = null;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction t;

    private ManejadorAlbum() {
        emf = Persistence.createEntityManagerFactory("EspotifyBD");
        em = emf.createEntityManager();
        t = em.getTransaction(); //se usa para las consultas y commits/rollbacks
    }

    public static ManejadorAlbum getInstance(){
        if (instancia == null)
            instancia = new ManejadorAlbum();
        return instancia;
    }   

}