package Logica;

import LogicaDTO.DTOAlbum;
import LogicaDTO.DTOLista;
import LogicaDTO.DTOTema;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

public class ManejadorLista {

    private static ManejadorLista instancia = null;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction t;

    public ManejadorLista() {
        emf = Persistence.createEntityManagerFactory("EspotifyBD");
        em = emf.createEntityManager();
        t = em.getTransaction(); //se usa para las consultas y commits/rollbacks
    }

    public static ManejadorLista getInstance() {
        if (instancia == null) {
            instancia = new ManejadorLista();
        }
        return instancia;
    }

   public void addLista(Lista lista) {
    EntityTransaction transaction = em.getTransaction();
    try {
        transaction.begin();
        em.persist(lista);
        transaction.commit();
    } catch (Exception e) {
        if (transaction.isActive()) {
            transaction.rollback();  // Asegura el rollback solo si la transacción está activa
        }
        e.printStackTrace();  // Para ver cualquier error que pueda estar ocurriendo
    } finally {
        if (em.isOpen()) {
            em.clear();  // Limpia el contexto para evitar retener un estado intermedio no deseado
        }
    }
}

    public Lista ExisteLista(String nombrelista) {

        TypedQuery<Lista> query = em.createQuery("SELECT l from Lista l where l.nombre = :nombre", Lista.class);

        query.setParameter("nombre", nombrelista);
        Lista lis;
        try {
            lis = query.getSingleResult();
        } catch (Exception e) {
            //  System.out.println("No se encontró ninguna lista con el nombre proporcionado.");
            return null;
        }

        // JOptionPane.showMessageDialog(null,"El nobre de la lista es: "+lis.getNombre());
        return lis;
    }

    public boolean esdueño(String nombrelista, String nombreusuario) {

        Lista lis;
        lis = ExisteLista(nombrelista);

        if (lis.getDuenio().getNombre().equalsIgnoreCase(nombreusuario)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean espublica(String nombre) {
        Lista lis;
        lis = ExisteLista(nombre);
        if (lis.getEsPrivada() != true) {
            return true;
        } else {
            return false;
        }
    }

    public void aniadotemalista(String nombrelista, Tema tem) {
        Lista lis = this.ExisteLista(nombrelista);
        lis.addTema(tem);
        t.begin();
        em.merge(lis);
        t.commit();
        
    }

    public List<Lista> todaslistas() {
        //JOptionPane.showMessageDialog(null,"llegue3");
        List<Lista> listas = em.createQuery("select l from Lista l", Lista.class).getResultList();
        return listas;

    }

    public List<Lista> todaslistassinduenio() {
        List<Lista> listas = em.createQuery("select l from Lista l where l.duenio = null", Lista.class).getResultList();
        return listas;
    }

    public List<Lista> todaslistaspublica() {
        List<Lista> listas = em.createQuery("select l from Lista l where l.esPrivada = false", Lista.class).getResultList();
        return listas;
    }

    public List<Lista> todaslistasconduenio() {
        List<Lista> listas = em.createQuery("select l from Lista l where l.duenio is not null", Lista.class).getResultList();
        return listas;
    }

    //(nombre, genero, duenio,ruta,privada)
    public void creolista(String nombre, String genero, String duenio, String ruta, boolean privada) {
        ManejadorGenero mang = ManejadorGenero.getInstance();
        ManejadorUsuario manu = ManejadorUsuario.getinstance();
        Genero g = mang.Existegenbasedatoss(genero);
        Usuario u = manu.obtenerUsuario(duenio);
        Lista L = new Lista(nombre, ruta, privada, g, u);
        addLista(L);
    }

    public List<DTOTema> temasdelalistadto(String nombrelista) {
        // Busca la lista por su nombre
        Lista lis = this.ExisteLista(nombrelista);

        // Si la lista no existe, devuelve null
        if (lis == null) {
            return null;
        }

        // Realiza la consulta para obtener los temas relacionados a la lista
        List<Tema> temas = em.createQuery(
                "SELECT t FROM Lista l JOIN l.temas t WHERE l.nombre = :nombrelista", Tema.class)
                .setParameter("nombrelista", nombrelista)
                .getResultList();

        // Crea una lista para almacenar los DTOTema
        List<DTOTema> temasDTO = new ArrayList<>();

        String nombreartista;
        String nombrealbum;
        // Convierte cada tema a DTOTema
        for (Tema tema : temas) {
            nombrealbum = tema.getAlbum().getTitulo();
            nombreartista = tema.getAlbum().getArtista().getNickname();

            DTOTema dto = new DTOTema(tema.getNombre(), tema.getDuracion(), tema.getEnlace(), nombrealbum, nombreartista);//String nombre, String duracion, String enlace, int posicion
            temasDTO.add(dto);
        }

        // Retorna la lista de DTOTema
        return temasDTO;
    }

    public List<Tema> temasdelalista(String nombrelista) {
        Lista lis = this.ExisteLista(nombrelista);
        List<Tema> temos = lis.getTemas();
        return temos;
    }

    public void Eliminotemalista(String nombreLista, Tema tem) {
        Tema temardo = em.find(Tema.class, tem.getId());  // Pido el tema buscandolo por ID
        if (temardo != null) {
            Lista lis = this.ExisteLista(nombreLista);
            lis.removeTema(temardo);  // Remover el tema de la lista
            t.begin();
            em.merge(lis);  // Actualizar la lista
            t.commit();
        }
    }

    public void publicolista(boolean Privada, Lista lista) {
        lista.setEsPrivada(Privada);
        try {
            t.begin();
            em.merge(lista);
            t.commit();
        } catch (Exception e) {
            //si sale mal rollback
            t.rollback();
        }
    }

    public List<DTOLista> buscarListas(String query) {

        List<DTOLista> DTOl = new ArrayList<>();
        String dueño = null;
        String genero = null;

        List<Lista> listas = em.createQuery("SELECT l FROM Lista l LEFT JOIN l.genero g WHERE l.nombre LIKE :query OR g.nombre LIKE :query ", Lista.class)
                .setParameter("query", "%" + query + "%").getResultList();

        for (Lista l : listas) {
            //controles por si son listas publicas o por defecto.
            if (l.getDuenio() != null) {
                dueño = l.getDuenio().getNickname();
            }
            if (l.getGenero() != null) {
                genero = l.getGenero().toString();
            }

            DTOLista listadto = new DTOLista(l.getNombre(), l.getRutaImagen(), l.getEsPrivada(), genero, dueño);
            DTOl.add(listadto);
        }
        return DTOl;
    }

    public List<DTOAlbum> buscarAlbums(String query) {
        List<DTOAlbum> DTOa = new ArrayList<>();

        List<Album> albums = em.createQuery("SELECT a FROM Album a WHERE a.titulo LIKE :query", Album.class)
                .setParameter("query", "%" + query + "%")
                .getResultList();

        for (Album a : albums) {
            Set<Genero> g = a.getGeneros();
            Set<String> generos = new HashSet<>();
            for (Genero genero : g) {
                if (g != null) {
                    generos.add(genero.getNombre());
                }
            }

            DTOAlbum albumdto = new DTOAlbum(a.getTitulo(), a.getAnio(), a.getRutaImagen(), a.getArtista().getNickname(), generos, null);
            DTOa.add(albumdto);
        }
        return DTOa;
    }

    public List<DTOTema> buscarTemas(String query) {
        List<DTOTema> DTOt = new ArrayList<>();

        List<Tema> temas = em.createQuery("SELECT t FROM Tema t WHERE t.nombre LIKE :query", Tema.class)
                .setParameter("query", "%" + query + "%")
                .getResultList();

        for (Tema t : temas) {
            DTOTema temadto = new DTOTema(t.getNombre(), t.getDuracion(), t.getEnlace(), 0);
            DTOt.add(temadto);
        }

        return DTOt;
    }

    public String obtengoAlbumDelTema(String nombreTema) {
        Tema tema = em.createQuery("SELECT t FROM Tema t WHERE t.nombre = :nombreTema", Tema.class)
                .setParameter("nombreTema", nombreTema)
                .getSingleResult();
        return tema.getAlbum().getTitulo();
    }

}
