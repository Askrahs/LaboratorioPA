package Persistencia;

import Logica.Artista;
import Logica.Cliente;
import Logica.Usuario;
import LogicaDTO.DTOArtista;
import LogicaDTO.DTOCliente;
import LogicaDTO.DTOLista;
import java.util.ArrayList;
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
    
public List<Artista> findAllArtistaData() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Artista> query = em.createQuery("SELECT a FROM Artista a", Artista.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    
    public List<DTOCliente> findAllClientesData(){
       EntityManager em = getEntityManager();
        try {
            TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c", Cliente.class);
             List<Cliente> artistas = query.getResultList();
            List<DTOCliente> dtocliente = new ArrayList<>();
            for (Cliente cli : artistas){
             //   dtocliente.add(new DTOCliente(cli.getNickname(),cli.getNombre(),cli.getApellido(),cli.getRutaImagen(),cli.getEmail()));
            }
            return dtocliente;
           
        } finally {
            em.close();
        }
    }
    
    public List<String> findArtistasBorrados() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<String> query = em.createQuery("SELECT a.nickname FROM Artista a WHERE a.activo = false", String.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public void darDeBajaArtista(Artista a) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            a = em.merge(a);
            for (Usuario seguidor : a.getSeguidores()) {
                seguidor.getSiguiendo().remove(a);
            }
            a.getSeguidores().clear();
            
            em.merge(a);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
        
}