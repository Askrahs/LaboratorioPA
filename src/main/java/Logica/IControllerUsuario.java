package Logica;
import Excepciones.*;
import java.util.Collection;

public interface IControllerUsuario {
    public abstract void registrarCliente(String nickname, String nombre, String apellido, String Email, String imagen, String fechaNac, Collection<Usuario> siguiendo, Collection<Usuario> seguidores) throws UsuarioYaExisteException; // 
    public abstract void registrarArtista(String nickname, String nombre, String apellido, String Email, String imagen,String fechaNac, Collection<Usuario> siguiendo, Collection<Usuario> seguidores, String biografia, String website) throws UsuarioYaExisteException; // 
    public abstract void ListarUsuarios(String nickname) throws NoHayUsuariosEnElSistemaException; //DataUsuario ???
    public abstract void EliminarUsuario(String nickname) throws UsuarioNoExisteException; 
    public abstract void ModificarUsuario(String nickname) throws UsuarioNoExisteException; 
}
