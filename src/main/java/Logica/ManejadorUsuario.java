package Logica;

import Logica.Artista;
import Logica.Usuario;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ManejadorUsuario {

    private Map<String, Usuario> usuarioNick;
    private static ManejadorUsuario instancia = null;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction t;

    private ManejadorUsuario() {
        usuarioNick = new HashMap<String, Usuario>(); //Lista de usuarios por pk nicj
        emf = Persistence.createEntityManagerFactory("EspotifyBD");
        em = emf.createEntityManager();
        t = em.getTransaction(); //se usa para las consultas y commits/rollbacks
    }

    public static ManejadorUsuario getinstance() {
        if (instancia == null) {
            instancia = new ManejadorUsuario();
        }
        return instancia;
    }

    public void addUsuario(Usuario usu) {
        String nick = usu.getNickname();
        usuarioNick.put(nick, usu);
    }

    public Usuario obtenerUsuario(String nickname) {
        Usuario usuario = em.find(Usuario.class, nickname);
        return usuario;
    }

    public Usuario[] getUsuarios() {
        if (usuarioNick.isEmpty()) {
            return null;
        } else {
            Collection<Usuario> usrs = usuarioNick.values();
            Object[] o = usrs.toArray();
            Usuario[] usuarios = new Usuario[o.length];
            for (int i = 0; i < o.length; i++) {
                usuarios[i] = (Usuario) o[i];
            }
            return usuarios;
        }
    }

    public Artista obtenerArtista(String nickname) {
        Usuario usr = obtenerUsuario(nickname);
        if (usr instanceof Artista) {
            Artista art = (Artista) usr;
            return art;
        } else {
            return null;
        }
    }

    
    
    public void AltaCliente(String nickname, String nombre, String apellido, String email, String imagen, String fechaNac, Collection<Usuario> siguiendo, Collection<Usuario> seguidores) {
        Cliente u = new Cliente(nickname, nombre, apellido, email, imagen, fechaNac, siguiendo, seguidores);
        try {
            t.begin();
            em.persist(u);
            t.commit();
        } catch (Exception e) {
            //si sale mal rollback
            t.rollback();
        }
    }

    public void AltaArtista(String nickname, String nombre, String apellido, String imagen, String fechaNac, String email, Collection<Usuario> siguiendo, Collection<Usuario> seguidores, String biografia, String website) {
        Artista a = new Artista(nickname, nombre, apellido, imagen, fechaNac, email, siguiendo, seguidores, biografia, website);
        try {
            t.begin();
            em.persist(a);
            t.commit();
        } catch (Exception e) {
            //si sale mal rollback
            t.rollback();
        }
    }

    public void SeguirUsuario(String nickname1, String nickname2) {
        Usuario seguidor = em.find(Usuario.class, nickname1);
        Usuario seguido = em.find(Usuario.class, nickname2);
        if (seguidor != null && seguido != null) { //Si  existen en la bd
            seguidor.getSiguiendo().add(seguido); //el que sigue
            seguido.getSeguidores().add(seguidor); //el seguido
            try {
                t.begin();
                em.merge(seguidor);
                em.merge(seguido);
                t.commit();
            } catch (Exception e) {
                t.rollback();
            }
        }
    }
    
    public void DejarDeSeguirUsuario(String nickname1, String nickname2) {
        Usuario seguidor = em.find(Usuario.class, nickname1);
        Usuario seguido = em.find(Usuario.class, nickname2);
        if (seguidor != null && seguido != null) { //Si  existen en la bd
            seguidor.getSiguiendo().remove(seguido); //el que sigue
            seguido.getSeguidores().remove(seguidor); //el seguido
            try {
                t.begin();
                em.merge(seguidor);
                em.merge(seguido);
                t.commit();
            } catch (Exception e) {
                //si sale mal rollback
                t.rollback();
            }
        }
    }
    
    
    
}
