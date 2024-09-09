package Logica;

import Excepciones.*;
import Logica.ManejadorUsuario;
import Persistencia.ControllerPersistencia;
import java.util.Collection;
import java.util.List;

public class ControllerUsuario implements IControllerUsuario {
    ControllerPersistencia cPersist = new ControllerPersistencia();
    
    @Override
    public void registrarCliente(String nickname, String nombre, String apellido, String Email, String imagen, String fechaNac, Collection<Usuario> siguiendo, Collection<Usuario> seguidores) throws UsuarioYaExisteException {
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        mu.AltaCliente(nickname, nombre, apellido, Email, imagen, fechaNac, siguiendo, seguidores);
    }

    @Override
    public void registrarArtista(String nickname, String nombre, String apellido, String Email, String imagen, String fechaNac, Collection<Usuario> siguiendo, Collection<Usuario> seguidores, String biografia, String website) throws UsuarioYaExisteException {
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        mu.AltaArtista(nickname, nombre, apellido, imagen, fechaNac, Email, siguiendo, seguidores, biografia, website);
    }

    @Override
    public void ListarUsuarios(String nickname) throws NoHayUsuariosEnElSistemaException {
        throw new NoHayUsuariosEnElSistemaException("No hay usuarios en el sistema.");
    }

    @Override
    public void EliminarUsuario(String nickname) throws UsuarioNoExisteException {
        throw new UsuarioNoExisteException("El usuario " + nickname + " no existe");
    }

    @Override
    public void ModificarUsuario(String nickname) throws UsuarioNoExisteException {
        throw new UsuarioNoExisteException("El usuario " + nickname + " no existe.");
    }

    @Override
    public void SeguirUsuario(String nickname1, String nickname2) throws UsuariosNoExisten {
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        //Verificar que existan
        Usuario seguidor = mu.obtenerUsuario(nickname1); 
        Usuario seguido = mu.obtenerUsuario(nickname2);
        if (seguidor == null || seguido == null) {
            throw new UsuariosNoExisten("Uno de los usuarios no existe.");
        }
        mu.SeguirUsuario(nickname1, nickname2);
    }

    @Override
    public void DejarDeSeguirUsuario(String nickname1, String nickname2) throws UsuariosNoExisten {
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        //Verificar que existan
        Usuario seguidor = mu.obtenerUsuario(nickname1); 
        Usuario seguido = mu.obtenerUsuario(nickname2);
        if (seguidor == null || seguido == null) {
            throw new UsuariosNoExisten("Uno de los usuarios no existe.");
        }
        mu.DejarDeSeguirUsuario(nickname1, nickname2);
    }
    
    @Override
    public List<String> obtenerArtistas(){
            return cPersist.obtenerArtistas();
    }
}
