package Logica;

import Excepciones.*;
import java.util.ArrayList;
import Persistencia.ControllerPersistencia;
import java.util.Collection;
import java.util.List;

public class ControllerUsuario implements IControllerUsuario {
    ControllerPersistencia cPersist = new ControllerPersistencia();
    
    @Override
    public void registrarCliente(String nickname, String nombre, String apellido, String Email, String imagen, String fechaNac, Collection<Usuario> siguiendo, Collection<Usuario> seguidores) throws UsuarioYaExisteException, EmailYaExiste {
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        //Controles
        Usuario u = mu.obtenerUsuario(nickname);
        if (u == null) {
            Boolean a = mu.EmailUsado(Email);
            if (a == false) {
                mu.AltaCliente(nickname, nombre, apellido, Email, imagen, fechaNac, siguiendo, seguidores);
            } else {
                throw new EmailYaExiste("El Email ingresado ya existe");
            }
        } else {
            throw new UsuarioYaExisteException("El usuario ingresado ya existe");
        }
    }

    @Override
    public void registrarArtista(String nickname, String nombre, String apellido, String Email, String imagen, String fechaNac, Collection<Usuario> siguiendo, Collection<Usuario> seguidores, String biografia, String website) throws UsuarioYaExisteException, EmailYaExiste {
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        //Controles
        Usuario u = mu.obtenerUsuario(nickname);
        if (u == null) {
            Boolean a = mu.EmailUsado(Email);
            if (a == false) {
                mu.AltaArtista(nickname, nombre, apellido, Email, imagen, fechaNac, siguiendo, seguidores, biografia, website);
            } else {
                throw new EmailYaExiste("El Email ingresado ya existe");
            }
        } else {
            throw new UsuarioYaExisteException("El usuario ingresado ya existe");
        }
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
        Cliente seguidor = mu.obtenerCliente(nickname1);
        Usuario seguido = mu.obtenerUsuario(nickname2);
        if (seguidor == null) {
            throw new UsuariosNoExisten("El cliente ingresado no existe.");
        } else if (seguido == null) {
            throw new UsuariosNoExisten("El usuario ingresado a seguir no existe.");
        }
        mu.SeguirUsuario(nickname1, nickname2);
    }

    @Override
    public void DejarDeSeguirUsuario(String nickname1, String nickname2) throws UsuariosNoExisten {
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        //Verificar que existan
        Cliente seguidor = mu.obtenerCliente(nickname1);
        Usuario seguido = mu.obtenerUsuario(nickname2);
        if (seguidor == null) {
            throw new UsuariosNoExisten("El cliente no existe.");
        } else if (seguido == null) {
            throw new UsuariosNoExisten("El usuario ingresado no existe.");
        }
        mu.DejarDeSeguirUsuario(nickname1, nickname2);
    }

    @Override
    public List<String> ObtenerNicknamesClientes() throws NoHayUsuariosEnElSistemaException {
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        List<String> nicknames = null;
        nicknames = mu.ObtenerNicknamesClientes(); //METODO MANEJADOR
        if (nicknames != null) {
            return nicknames;
        } else {
            throw new NoHayUsuariosEnElSistemaException("No hay usuarios en el sistema."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }

    @Override
    public Cliente ObtenerCliente(String nickname) throws UsuarioNoExisteException {
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Cliente c = null;
        c = mu.obtenerCliente(nickname);
        if (c == null) {
            throw new UsuarioNoExisteException("El usuario seleccionado no existe...");
        }
        return c;
    }

    @Override
    public List<String> ObtenerSeguidoresCliente(String nickname) throws SinSeguidores {
        List<String> nickSeguidores = new ArrayList<>();
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Cliente cliente = mu.obtenerCliente(nickname);
        Collection<Usuario> seguidores = cliente.getSeguidores();
        for (Usuario u : seguidores) {
            nickSeguidores.add(u.getNickname());
        }
        if (nickSeguidores == null) {
            throw new SinSeguidores("Cliente sin seguidores");
        }
        return nickSeguidores;
    }

    @Override
    public List<String> ObtenerSiguiendoCliente(String nickname) throws NoSigueANadie {
        List<String> nickSiguiendo = new ArrayList<>();
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Cliente cliente = mu.obtenerCliente(nickname);
        Collection<Usuario> siguiendo = cliente.getSiguiendo();
        for (Usuario u : siguiendo) {
            nickSiguiendo.add(u.getNickname());
        }
        if (nickSiguiendo == null) {
            throw new NoSigueANadie("Este Cliente no sigue a ningun Usuario.");
        }
        return nickSiguiendo;
    }

    @Override
    public List<String> obtenerArtistas(){
            return cPersist.obtenerArtistas();
    }

}