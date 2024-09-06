package Logica;

import Excepciones.*;
import java.util.List;
import LogicaDTO.*;
import Excepciones.GenroYaExiste;
import LogicaDTO.DTOLista;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

public class ControllerMusica implements IControllerMusica {
    public ControllerMusica() {}
        
    
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
     public void altaAlbum(String nicknameArtista, String titulo, List<Genero> generos, int anio, String refetema, String rutaImagen) throws AlbumYaExisteException, UsuarioNoExisteException{       
        ManejadorUsuario mart = ManejadorUsuario.getinstance();
        ManejadordeTema mantem = ManejadordeTema.getinstance();
        Tema tem = mantem.obtenerTema(refetema);
        
        Artista art = mart.obtenerArtista(nicknameArtista);
        if (art == null){
            throw new UsuarioNoExisteException("El Artista " + nicknameArtista + " no esta registrado");
        }
        ManejadorAlbum malb = ManejadorAlbum.getInstance();
        if(malb.existeAlbum(art,titulo)){
           throw new AlbumYaExisteException("El Artista " + nicknameArtista + " ya tiene un álbum con el titulo: " + titulo);
        }else{
            Album alb = new Album(art, titulo, generos, anio,tem ,rutaImagen);
            malb.AddTema(alb, tem);
            malb.addAlbum(alb);
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
    
    public List<DTOAlbum> cargarSegunArtista(String nickname){
        ManejadorAlbum malb = ManejadorAlbum.getInstance();
        List<Album> albums = malb.obtenerAlbumsArtista(nickname);
        return null;
    }
    public List<DTOAlbum> cargarSegunGenero(String genero){
        ManejadorAlbum malb = ManejadorAlbum.getInstance();
        ManejadorGenero mgen = ManejadorGenero.getInstance();
        //Genero g = mgen.ObtenerGenero(genero);
        List<Album> albums = malb.obtenerAlbumsGenero(genero);
        return null;
    }

    @Override
    public void ingresarTema(String referencia, String nombre, String duracion) throws temaYaexiste {
    ManejadordeTema te = ManejadordeTema.getinstance();

        if (te.obtenerTema(referencia) == null) {
            te.addTema(te.AltaTema(referencia, nombre, duracion));
            System.out.println("Tema agregado: " + nombre);
        } else {
            JOptionPane.showMessageDialog(null, "El tema ya existe");
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
    
