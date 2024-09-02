package Logica;
import Presentacion.AltaUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Excepciones.*;
import Logica.ManejadorUsuario;
import java.util.Collection;

public class ControllerUsuario implements IControllerUsuario {

    @Override
    public void registrarCliente(String nickname, String nombre, String apellido, String Email,String imagen,String fechaNac, Collection<Usuario> siguiendo, Collection<Usuario> seguidores) throws UsuarioYaExisteException {
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        if (mu.obtenerUsuario(nickname) != null){
        throw new UsuarioYaExisteException("El usuario "+nickname+" ya existe."); 
        }else{
        mu.AltaCliente(nickname, nombre, apellido, Email, imagen, fechaNac, siguiendo, seguidores);
        }
    }
    
    @Override
    public void registrarArtista(String nickname, String nombre, String apellido, String Email,String imagen,String fechaNac, Collection<Usuario> siguiendo, Collection<Usuario> seguidores, String biografia, String website) throws UsuarioYaExisteException {
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        if (mu.obtenerUsuario(nickname) != null){
        throw new UsuarioYaExisteException("El usuario "+nickname+" ya existe."); 
        }else{
        mu.AltaArtista(nickname, nombre, apellido, imagen, fechaNac, Email, siguiendo, seguidores, biografia, website);
        }
    }

    @Override
    public void ListarUsuarios(String nickname) throws NoHayUsuariosEnElSistemaException {
        throw new NoHayUsuariosEnElSistemaException("No hay usuarios en el sistema."); 
    }

    @Override
    public void EliminarUsuario(String nickname) throws UsuarioNoExisteException {
        throw new UsuarioNoExisteException("El usuario "+nickname+" no existe"); 
    }

    @Override
    public void ModificarUsuario(String nickname) throws UsuarioNoExisteException {
        throw new UsuarioNoExisteException("El usuario "+nickname+" no existe"); 
    }  
}
    
    




