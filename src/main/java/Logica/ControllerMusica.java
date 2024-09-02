package Logica;
import Excepciones.*;
import java.util.List;
import Excepciones.GenroYaExiste;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

public class ControllerMusica implements IControllerMusica {
   
    
    public ControllerMusica() {}
    
    
    
    @Override
       public  void ModificoPadre(String nombrenodo, String nombrepadrenuevo){
           ManejadordeGenero man = ManejadordeGenero.getInstance();
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
    ManejadordeGenero mg = ManejadordeGenero.getInstance();
    return mg.ObtengoNodoRaiz();
    }
   
    @Override
    public void EliminoGenero(String nombregen){
        ManejadordeGenero mg= ManejadordeGenero.getInstance();
        if(mg.EncuentroGenerobool(nombregen)!=true){
            mg.remuevoGenero(nombregen);
        }
        try {
            throw new GenroYaExiste("El Genero " + nombregen + " no esta registrado");
        } catch (GenroYaExiste ex) {
            Logger.getLogger(ControllerMusica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
   @Override
    public void AltaGenero (String refe, String nombregen, String nombrepadre) throws GenroYaExiste{
       
        ManejadordeGenero mg= ManejadordeGenero.getInstance();
        
        if(mg.EncuentroGenerobool(nombregen)==true){//chequeo si el genero existe
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
            if(mg.EncuentroGenerobool(nombrepadre)==true){//Verifico si el genero padre existe
                 DefaultMutableTreeNode Generoall = mg.ObtengoNodoRaiz();
                mg.AñadoGenero(refe, nombregen,Generoall);//Creo el genero padre
           DefaultMutableTreeNode Generoexis = mg.EncuentroGenero(nombregen);
           DefaultMutableTreeNode Generopapa = mg.EncuentroGenero(nombrepadre);
           if(mg.eshijode(Generoexis,Generopapa)!=true){//verifico si es el hijo
           mg.lepongopadre(Generoexis,Generopapa);
            JOptionPane.showConfirmDialog(null, "Se Añado al padre Correctamente");           
        }     
    }else{
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
    } 
    
    @Override
     public void altaAlbum(String nicknameArtista, String titulo, List<Genero> generos, int anio, List<Tema> temas, String rutaImagen) throws AlbumYaExisteException, UsuarioNoExisteException{       
        ManejadorUsuario mart = ManejadorUsuario.getinstance();
        Artista art = mart.obtenerArtista(nicknameArtista);
        if (art == null){
            throw new UsuarioNoExisteException("El Artista " + nicknameArtista + " no esta registrado");
        }
        ManejadorAlbum malb = ManejadorAlbum.getInstance();
        if(malb.existeAlbum(art,titulo)){
           throw new AlbumYaExisteException("El Artista " + nicknameArtista + " ya tiene un álbum con el titulo: " + titulo);
        }else{
            Album alb = new Album(art, titulo, generos, anio, temas,rutaImagen);
            malb.addAlbum(alb);
        }                        
    }
    
//    @Override
//    public void altaTema(String nombre,int duracion){
//     if (!ManejadordeTema.temaExiste(nombre)) {
//            Tema nuevoTema = new Tema(nombre, duracion);
//            listaTemas.add(nuevoTema);
//            System.out.println("Tema agregado: " + nombre);
//        } else {
//            System.out.println("El tema ya existe: " + nombre);
//        }
//    }
}
