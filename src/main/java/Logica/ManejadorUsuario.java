package Logica;
import Logica.Artista;
import Logica.Usuario;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ManejadorUsuario {  
    private Map<String, Usuario> usuarioNick; 
    private static ManejadorUsuario instancia = null;

    private ManejadorUsuario() {
        usuarioNick = new HashMap<String, Usuario>();
    }

    public static ManejadorUsuario getinstance() {
        if (instancia == null)
            instancia = new ManejadorUsuario();
        return instancia;
    }

    public void addUsuario(Usuario usu) {
        String nick = usu.getNickname();
        usuarioNick.put(nick, usu);
    }

    public Usuario obtenerUsuario(String nickname) {
        return ((Usuario) usuarioNick.get(nickname));
    }

    public Usuario[] getUsuarios() {
        if (usuarioNick.isEmpty())
            return null;
        else {
            Collection<Usuario> usrs = usuarioNick.values();
            Object[] o = usrs.toArray();
            Usuario[] usuarios = new Usuario[o.length];
            for (int i = 0; i < o.length; i++) {
                usuarios[i] = (Usuario) o[i];
            }
            return usuarios;
        }
    }

    public Artista obtenerArtista(String nickname){         
        Usuario usr  = obtenerUsuario(nickname);
        if (usr instanceof Artista){
            Artista art = (Artista) usr;
               return art;
            }else{
               return null;
            }
        }
    
     public Cliente obtenerCliente(String nickname){
         Usuario usr = obtenerUsuario(nickname);
         if(usr instanceof Cliente){
             Cliente cli = (Cliente) usr;
             return cli;
         }else{
             return null;
         }
     }
    
    public  Usuario AltaCliente(String nickname, String nombre, String apellido, String email,String imagen,String fechaNac, Collection<Usuario> siguiendo, Collection<Usuario> seguidores){
    Usuario u = new Usuario(nickname, nombre, apellido, email, imagen, fechaNac, siguiendo, seguidores);
    return u;
    }
    
    public  Artista AltaArtista(String nickname, String nombre, String apellido,String imagen,String fechaNac, String email, Collection<Usuario> siguiendo, Collection<Usuario> seguidores, String biografia, String website){
    Artista a = new Artista(nickname,nombre,apellido, imagen, fechaNac, email, siguiendo, seguidores, biografia,website);
    return a;   
    }   
    
    
    
}
