package Logica;
import Presentacion.AltaUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Excepciones.*;
import Logica.ManejadorUsuario;
import java.util.Collection;
import javax.swing.JOptionPane;

public class ControllerUsuario implements IControllerUsuario {

    @Override
    public void registrarCliente(String nickname, String nombre, String apellido, String Email,String imagen,String fechaNac, Collection<Usuario> siguiendo, Collection<Usuario> seguidores) throws UsuarioYaExisteException {
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        if (mu.obtenerUsuario(nickname) != null){
        throw new UsuarioYaExisteException("El usuario "+nickname+" ya existe."); 
        }else{
        mu.addUsuario(mu.AltaCliente(nickname, nombre, apellido, Email, imagen, fechaNac, siguiendo, seguidores));
        }
    }
    
    @Override
    public void registrarArtista(String nickname, String nombre, String apellido, String Email,String imagen,String fechaNac, Collection<Usuario> siguiendo, Collection<Usuario> seguidores, String biografia, String website) throws UsuarioYaExisteException {
        ManejadorUsuario mu = ManejadorUsuario.getinstance();
        if (mu.obtenerUsuario(nickname) != null){
        throw new UsuarioYaExisteException("El usuario "+nickname+" ya existe."); 
        }else{
        mu.addUsuario(mu.AltaArtista(nickname, nombre, apellido, Email, imagen, fechaNac, siguiendo, seguidores, biografia,website));
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
    
    
    @Override
    public List<Lista> Listaspordefecto() throws NoHayListasenSistema{
       //JOptionPane.showMessageDialog(null,"llegue2");
        ManejadordeListas manli = ManejadordeListas.getInstance();
         List<Lista> listasdefecto = manli.Listasdefault();
          if(listasdefecto!=null){
              //JOptionPane.showMessageDialog(null,"llegue3");
              return  listasdefecto;
          }else{
              throw new NoHayListasenSistema("No hay Listas en el sistema"); 
              
          }
    }
    
    
    public void Agregar_Tema_Lista(String nombreusuario, String nombretema, String nombrelista){
         ManejadorUsuario usr = ManejadorUsuario.getinstance();
         if(nombreusuario==null){//Lista del Administrador por defecto
             ManejadordeListas listman = ManejadordeListas.getInstance();
             ManejadordeTema mantem = ManejadordeTema.getinstance();
             Tema  tem = mantem.obtenerTema(nombretema);
             if(tem!=null){
                 Lista list = (Lista) listman.Obtengolista(nombrelista);
                  if(list!=null){
                 listman.pongotema(list,tem);
             }
             }
         }else{//Lista personal de cliente
         Cliente usercli = usr.obtenerCliente(nombreusuario);
         if(usercli!=null){
             ManejadordeListas listman = ManejadordeListas.getInstance();
             Lista list = (Lista) listman.Obtengolista(nombrelista);
             if(listman.esdueño(usercli, list)==true){
                 ManejadordeTema mantem = ManejadordeTema.getinstance();
             Tema  tem = mantem.obtenerTema(nombretema);
                 if(listman.espublica(list)==true){
                     listman.pongotema(list, tem);
                 }
             }
         }
         }
         //Falta implementar album 
        // List <Lista> listas = usr.Obtengolista();
       //  for(int i=0; i<listas.size();i++){
        //     Lista list = listas.get(i);
        //     if(list.getNombre().equalsIgnoreCase(nombrelista)){
        //         if(list.isPublica()==true){
        //             usr.añadotema(nombretema);
        //         }
       //      }
       //  }
     }
    }

    
    




