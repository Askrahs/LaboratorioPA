package Persistencia;

import Logica.Lista;
import LogicaDTO.DTOLista;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

public class ListaJpaController {

    private EntityManagerFactory emf = null;

    public ListaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("EspotifyBD");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Lista list) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            em.persist(list);

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

    public Lista findLista(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Lista.class, id);
        } finally {
            em.close();
        }
    }

    public void edit(Lista list) throws EntityNotFoundException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            em.merge(list);

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

            Lista list;
            try {
                list = em.getReference(Lista.class, id);
                list.getId();
            } catch (EntityNotFoundException enfe) {
                throw new EntityNotFoundException("La lista con ID " + id + " no existe.");
            }

            em.remove(list);

            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
public List<DTOLista> obtenerListaPorGeneroDATALISTA(String generoSeleccionado) {
       
    EntityManager em = getEntityManager();
        try {
            TypedQuery<Lista> query = em.createQuery(
                "SELECT l FROM Lista l JOIN l.genero g WHERE g.nombre = :nombre", Lista.class);
            query.setParameter("nombre", generoSeleccionado);
            List<Lista> listas = query.getResultList();
            
            
            List<DTOLista> dtoLista = new ArrayList<>();
            for (Lista lis : listas){
                dtoLista.add(new DTOLista(lis.getNombre(),lis.getRutaImagen()));
            }
            return dtoLista;
        } finally {
            em.close();
        }
    
    }
    public List<String> findListaPorGenero(String generoSeleccionado) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<String> query = em.createQuery(
                "SELECT l.nombre FROM Lista l JOIN l.genero g WHERE g.nombre = :nombre", String.class);
            query.setParameter("nombre", generoSeleccionado);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<DTOLista> findListaPorClienteDATA(String clienteSeleccionado) {
  
        EntityManager em = getEntityManager();
        em.clear();
        try {
           TypedQuery<Lista> query = em.createQuery(
               "SELECT l FROM Lista l WHERE  l.esPrivada = 0 and l.duenio.nickname = :nombre", Lista.class);
           query.setParameter("nombre", clienteSeleccionado);
           List<Lista> listas = query.getResultList();
           List<DTOLista> DTOlistas = new ArrayList<>();
           
           
           
            for (Lista lis : listas){
               
                DTOlistas.add(new DTOLista(lis.getNombre(),lis.getRutaImagen(), lis.getDuenio().getNickname()));
                
            }
           
            
            return DTOlistas;
           
        } finally {
            em.close();
        }
    }
    
    public List<String> findListaPorCliente(String clienteSeleccionado) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<String> query = em.createQuery(
                "SELECT l.nombre FROM Lista l WHERE l.duenio.nickname = :nombre", String.class);
            query.setParameter("nombre", clienteSeleccionado);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Lista findListaPorCliente2(String clienteSeleccionado) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Lista> query = em.createQuery(
                "SELECT l.nombre FROM Lista l WHERE l.duenio.nickname = :nombre", Lista.class);
            query.setParameter("nombre", clienteSeleccionado);
            return query.getSingleResult();
        } finally {
            em.close();
        }
    }
    
    public Lista findListaPorTitulo(String listaSeleccionado) {
        EntityManager em = getEntityManager();
            try {
                TypedQuery<Lista> query = em.createQuery(
                    "SELECT l FROM Lista l WHERE l.nombre = :nombre", Lista.class);
                query.setParameter("nombre", listaSeleccionado);
                return query.getSingleResult();
            } catch (NoResultException e) {
                return null;
            } finally {
                em.close();
            }
    }
     public Lista findListaPorTituloyGenero(String listaSeleccionado, String genero) {
        EntityManager em = getEntityManager();
            try {
                TypedQuery<Lista> query = em.createQuery(
                    "SELECT l FROM Lista l WHERE l.nombre = :nombre AND l.genero.nombre = :genero", Lista.class);
                query.setParameter("nombre", listaSeleccionado);
                query.setParameter("genero", genero);
                return query.getSingleResult();
            } catch (NoResultException e) {
                return null;
            } finally {
                em.close();
            }
    }
    public List<Lista> findListas() {
        EntityManager em = getEntityManager();
            try {
                TypedQuery<Lista> query = em.createQuery(
                    "SELECT l FROM Lista l", Lista.class);
                return query.getResultList();
            } catch (NoResultException e) {
                return null;
            } finally {
                em.close();
            }
    }
    
    public Lista findListaPorDatos(String nombrelista, boolean privada) {
        EntityManager em = getEntityManager();
            try {
                TypedQuery<Lista> query = em.createQuery(
                    "SELECT l FROM Lista l WHERE l.nombre = :nombre AND l.esPrivada = :privada", Lista.class);
                query.setParameter("nombre", nombrelista);
                query.setParameter("privada", privada);
                return query.getSingleResult();
            } catch (NoResultException e) {
                return null;
            } finally {
                em.close();
            }
    }
    
    public List<String> findListaPorClientePriv(String clienteSeleccionado) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<String> query = em.createQuery(
                "SELECT l.nombre FROM Lista l WHERE l.duenio.nickname = :nombre AND l.esPrivada = :priv", String.class);
            query.setParameter("nombre", clienteSeleccionado);
            query.setParameter("priv", true);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
}