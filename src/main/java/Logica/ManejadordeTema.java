package Logica;

import LogicaDTO.DTOTema;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ManejadordeTema {

    private static ManejadordeTema instancia = null;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;

    // Constructor privado para el patrón Singleton
    public ManejadordeTema() {
        emf = Persistence.createEntityManagerFactory("EspotifyBD");
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    // Método para obtener la instancia del manejador (Singleton)
    public static ManejadordeTema getInstance() {
        if (instancia == null) {
            instancia = new ManejadordeTema();
        }
        return instancia;
    }

    
    
    public Tema obtenerTema(String nomTema) {
        Tema temaBuscado = em.find(Tema.class, nomTema);
        return temaBuscado;
    }
}