
package Logica;

import Excepciones.*;
import java.util.List;
import LogicaDTO.*;
import Excepciones.GenroYaExiste;
import Logica.Album;
import Logica.Genero;
import Logica.ManejadorUsuario;
import Logica.Tema;
import java.util.ArrayList;
import Persistencia.ControllerPersistencia;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;


public class ControllerMusica implements IControllerMusica {
    ControllerPersistencia cPersist = new ControllerPersistencia();
    public ControllerMusica() {}       
    

    
    @Override
    public void AltaGenero (String refe, String nombregen, String nombrepadre) throws GenroYaExiste{    
        ManejadorGenero mg= ManejadorGenero.getInstance();        
        if(mg.EncuentroGenerobool(nombregen)==true){//chequeo si el genero existe
           // JOptionPane.showMessageDialog(null,"llegue1");
           if(nombrepadre.isEmpty()){
               DefaultMutableTreeNode Generoall = mg.ObtengoNodoRaiz();
                mg.AñadoGenero(refe, nombregen,Generoall);
               Generoall=null;                 
           }else{
            if(mg.EncuentroGenerobool(nombrepadre)==true){//Si no existe genero padre lo creo, poniendo por default al padre como el nodo Generos              
                DefaultMutableTreeNode Generoall = mg.ObtengoNodoRaiz();
                mg.AñadoGenero(refe, nombregen,Generoall);//Creo el genero padre
            }
            DefaultMutableTreeNode nodopadre = mg.EncuentroGenero(nombrepadre);//Creo una variable DefaultMutableTreeNode que va a señar al nodo padre del nodo nuevo que quiero crear
            mg.AñadoGenero(refe, nombregen,nodopadre);//Creo el nuevo genero y lo añado al arbol;
            JOptionPane.showMessageDialog(null, "Se Creo el genero Correctamente"); 
           }
        }else{
            if(nombrepadre == null){
            //JOptionPane.showMessageDialog(null,"llegue2");
            if(mg.EncuentroGenerobool(nombrepadre)==true){//Verifico si el genero padre existe
                //JOptionPane.showMessageDialog(null,"llegue3");
                 DefaultMutableTreeNode Generoall = mg.ObtengoNodoRaiz();
                mg.AñadoGenero(refe, nombregen,Generoall);//Creo el genero padre
                DefaultMutableTreeNode Generoexis = mg.EncuentroGenero(nombregen);
                DefaultMutableTreeNode Generopapa = mg.EncuentroGenero(nombrepadre);
                if(mg.eshijode(Generoexis,Generopapa)!=true){//verifico si es el hijo
                mg.lepongopadre(Generoexis,Generopapa);
                 JOptionPane.showConfirmDialog(null, "Se Añado al padre Correctamente");           
                }     
            }else{
                //JOptionPane.showMessageDialog(null,"llegue4");
                DefaultMutableTreeNode Generoexis = mg.EncuentroGenero(nombregen);
                DefaultMutableTreeNode Generopapa = mg.EncuentroGenero(nombrepadre);
                if(mg.eshijode(Generoexis,Generopapa)!=true){//verifico si es el hijo
                mg.lepongopadre(Generoexis,Generopapa);
                JOptionPane.showConfirmDialog(null, "Se Añado al padre Correctamente");
                }else{
                    JOptionPane.showConfirmDialog(null, "Este nodo ya es hijo");   
                }
            }
            }
            throw new GenroYaExiste("El genero ya existe");
        }
}
    
    @Override
       public  void ModificoPadre(String nombrenodo, String nombrepadrenuevo){
           ManejadorGenero man = ManejadorGenero.getInstance();
           JOptionPane.showMessageDialog(null, "llegue0");
           if(man.EncuentroGenerobool(nombrepadrenuevo)!=true){
               JOptionPane.showMessageDialog(null, "llegue1");
               if(man.EncuentroGenerobool(nombrenodo)!=true){
                   JOptionPane.showMessageDialog(null, "llegue2");
                   DefaultMutableTreeNode nod = man.EncuentroGenero(nombrenodo);
                   DefaultMutableTreeNode nodpapi = man.EncuentroGenero(nombrepadrenuevo);
                   man.lepongopadre(nod, nodpapi);
               }
           }else{
               try {
                   throw new GenroYaExiste("El Genero " + nombrepadrenuevo + " no esta ingresado");
               } catch (GenroYaExiste ex) {
                   Logger.getLogger(ControllerMusica.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
        }   
       
    @Override
    public DefaultMutableTreeNode DameTodoslosgeneros(){
        ManejadorGenero mg = ManejadorGenero.getInstance();
        mg.obtengoarbolbasedatos();           
        return mg.ObtengoNodoRaiz();
    }
   
    @Override
    public void EliminoGenero(String nombregen, String refe){
        ManejadorGenero mg= ManejadorGenero.getInstance();
        if(mg.EncuentroGenerobool(nombregen)!=true){
            mg.remuevoGenero(nombregen, refe);
        }else{
            try {
              throw new GenroYaExiste("El Genero " + nombregen + " no esta registrado");
          } catch (GenroYaExiste ex) {
             Logger.getLogger(ControllerMusica.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
    }   
    
    @Override
    
    @Override
     public void altaAlbum(DTOAlbum albumDTO, Set<DTOTema> temas) throws AlbumYaExisteException, UsuarioNoExisteException{       
        ManejadorUsuario mart = ManejadorUsuario.getinstance();
        Artista art = mart.obtenerArtista(albumDTO.getArtista());
        Set<Genero> generosAlb;
        generosAlb = cargarSetGeneros(albumDTO.getGeneros());
        if (art == null){
            throw new UsuarioNoExisteException("El Artista " + albumDTO.getArtista() + " no esta registrado");
        } 
        Set<Tema> temasAlb = new HashSet<>();
        Album alb = new Album(art, albumDTO.getTitulo(), generosAlb, albumDTO.getAnio(), null, albumDTO.getRutaImagen());
        for(DTOTema dtoTema : temas){
            Tema nuevoTema = new Tema(dtoTema.getNombre(), dtoTema.getDuracion(), dtoTema.getEnlace(), dtoTema.getPosicion(), alb);
            temasAlb.add(nuevoTema);
        }
        alb.setTemas(temasAlb);
        try {
            cPersist.altaAlbum(alb);
        } catch (Exception ex) {
            Logger.getLogger(Logica.ControllerMusica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }         
    
     @Override
     //A la espera de la otra parte del codigo
    public void altaListaReproduccion(String nombre, String genero, String duenio, String ruta) throws ListaYaExisteException{
        JOptionPane.showMessageDialog(null,"llegue2");
        ManejadorLista ml = ManejadorLista.getInstance();
        ManejadorGenero mangen =ManejadorGenero.getInstance();
        ManejadorUsuario usrman = ManejadorUsuario.getinstance();
        //( String nombre, String rutaImagen, Boolean estado, Genero genero, Usuario duenio)
        if(ml.ExisteLista(nombre)==null){//si existe lista
            JOptionPane.showMessageDialog(null,"llegue3");
            if(genero==null){
           
                if(usrman.obtenerUsuario(duenio)!=null){//si usuario existe
                    JOptionPane.showMessageDialog(null,"llegue5");
                    ml.creolista(nombre, genero, duenio);
                //JOptionPane.showMessageDialog(null,"llegue4");
            }
            }else{
                Genero gen = mangen.Existegenbasedatoss(genero);
                 if(gen!=null){ //si es false existe
                     JOptionPane.showMessageDialog(null,"llegue6");
                     ml.creolista(nombre, genero, duenio);
                 }else{
                    JOptionPane.showMessageDialog(null,"Genero no existe"); 
                 }
             }
            }else{
        JOptionPane.showMessageDialog(null,"Lista ya existe");
        }
    } 

    @Override
    public void publicarLista(String nombreUsuario, String nombreLista) throws UsuarioNoExisteException, ListaNoexisteException, OperacionNoPermitidaException {
            /*
        // Obtener el usuario
        ManejadorUsuario manejadorU = ManejadorUsuario.getinstance();
        Cliente cliU = (Cliente) manejadorU.obtenerUsuario(nombreUsuario);
        
        if (cliU == null) {
            throw new UsuarioNoExisteException("El usuario " + nombreUsuario + " no existe.");
        }

        // Obtener la lista de reproducción
        Lista lista = cliU.buscarListaPorNombre(nombreLista);
        if (lista == null) {
            throw new ListaNoexisteException("La lista " + nombreLista + " no existe.");
        }
        
        // Hacer la lista pública
        lista.setPublica(false);
        //Manejar con exception
        System.out.println("La lista " + nombreLista + " ha sido publicada.");
*/
    } 

    public Set<Genero> cargarSetGeneros(Set<String> generos) {
        ManejadorGenero mg = ManejadorGenero.getInstance();  
        Set<Genero> setGeneros = new HashSet<>();
       for(String nombreGenero : generos){
           Genero genero = mg.obtenerGeneroPorNombre(nombreGenero);
           if(genero != null){
               setGeneros.add(genero);
           }
       }
       return setGeneros; 
    } 
    
    
        public void AgregarTemaLista(String nombreusuario,String nombrelista, String nombretema)throws UsuariosNoExisten, ListaNoexisteException,NoesDueñodelaLista, TemaNoExiste{
            //Chequeo si existe el usuraio
            ManejadorUsuario manusr =ManejadorUsuario.getinstance();
            if(manusr.obtenerUsuario(nombreusuario)!=null){
                //chequeo si existe la lista y si es el dueño 
                ManejadorLista manlis = ManejadorLista.getInstance();
                if(manlis.ExisteLista(nombrelista)!=null){
                    if(manlis.esdueño(nombrelista, nombreusuario)==true){
                    //Chequeo si existe el tema
                    ManejadordeTema mantem = ManejadordeTema.getinstance();
                    if(mantem.obtenerTema(nombretema)!=null){
                        manlis.aniadotemalista(nombrelista, nombretema);
                }else{
                     throw new TemaNoExiste ("El tema que eligio no existe en el sistem");   
                    }
            }else{
                     throw new NoesDueñodelaLista ("El usuario"+nombreusuario+"no es dueño de la lista");   
                    }
            }else{
                throw new ListaNoexisteException("La lista " + nombrelista + " no existe en el sistema.");    
                }
            }else{
                throw new UsuariosNoExisten("El Usuario:"+nombreusuario+" no existe en el sistema");
            }
                   
        }
     
    @Override
        public List<DTOLista> Obtengolistas()throws NoExisteLista{
            //JOptionPane.showMessageDialog(null,"llegue2");
            ManejadorLista man= ManejadorLista.getInstance();
            Lista losta;
            List <Lista> lista;
            lista = man.todaslistas();          
            List <DTOLista> dtolista = new ArrayList<>();
            //JOptionPane.showMessageDialog(null,"llegue4");
            for (int i = 0; i<lista.size();i++){
                losta = lista.get(i);
                DTOLista datolista = new DTOLista(losta.getNombre());
                dtolista.add(datolista);
            }     
             return dtolista;          
        }
        
        
        @Override
        public  List <DTOTema> Obtengotemas()throws TemaNoExiste{
          ManejadordeTema mant = ManejadordeTema.getinstance();     
          Tema tems;
          List <Tema> Temas = mant.getTemas();
          List <DTOTema> dtotemas = new ArrayList<>();
          
          for (int i=0; i<Temas.size();i++){
              tems = Temas.get(i);
              DTOTema datotemas = new DTOTema (tems.getReferencia());
              dtotemas.add(datotemas);
          }
          return dtotemas;            
        }    
    }
   
    public List<String> obtenerAlbumsPorGenero(String generoSeleccionado){
        return cPersist.obtenerAlbumsPorGenero(generoSeleccionado);
    }   

    public List<String> obtenerAlbumsPorArtista(String artistaSeleccionado){   
        return cPersist.obtenerAlbumsPorArtista(artistaSeleccionado);
    }
    
    public  DTOAlbum consultaAlbumPorTitulo(String albumSeleccionado){
        Album a = cPersist.consultaAlbumPorTitulo(albumSeleccionado);
        Set<String> generosString = new HashSet<>();
        Set<DTOTema> tDTO = new HashSet<>();
        for(Genero gen : a.getGeneros()){
            generosString.add(gen.getNombre());
        }
        for(Tema tem : a.getTemas()){
            //DTOTema(String nombre, String duracion, String enlace, int posicion)
            DTOTema nuevoTDTO = new DTOTema(tem.getNombre(), tem.getDuracion(), tem.getEnlace(), tem.getPosicion());
            tDTO.add(nuevoTDTO);
        }       
        DTOAlbum aDTO = new DTOAlbum(a.getTitulo(), a.getAnio(), a.getRutaImagen(), a.getArtista().getNickname(), generosString, tDTO);
        return aDTO;
    }

    public  List <DTOGenero> Datageneros(){
        ManejadorGenero mang = ManejadorGenero.getInstance();
        List <Genero> gen = mang.obtengoListaGenero();
        Genero genunoauno;
            List <DTOGenero> dtogeneros = new ArrayList<>();
            //JOptionPane.showMessageDialog(null,"llegue4");
            for (int i = 0; i<gen.size();i++){
                genunoauno = gen.get(i);
                DTOGenero dagenero = new DTOGenero(genunoauno.getRef(),genunoauno.getNombre(),genunoauno.getNombrepapa());
                dtogeneros.add(dagenero);
            }
             return dtogeneros;   
    } 
}
