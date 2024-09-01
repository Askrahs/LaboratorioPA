package Logica;
import Excepciones.*;
import java.util.List;
import Excepciones.GenroYaExiste;

public class ControllerMusica implements IControllerMusica {
    public ControllerMusica() {}
    
   @Override
    public void AltaGenero (String nombregen, String nombrepadre) throws GenroYaExiste{
        ManejadordeGenero mg= ManejadordeGenero.getInstance();
        if(mg.Existegenero(nombregen)!=true){//chequeo si el genero existe
        
            mg.AltaGenero(nombregen, nombrepadre);
            Genero geg = mg.ObtenerGenero(nombregen);
            Genero G2 = mg.ObtenerGenero(nombrepadre);//pido la ubicacion del genero del padre
             geg.añadopapa(G2);//lo añado            
        }else{
            if(mg.Existegenero(nombregen)==true){          
                Genero ge = mg.ObtenerGenero(nombregen);
                List<Genero> listapapa = ge.getGeneroPapa();           
                if(ge.Existpapa(listapapa,nombrepadre)!=true){//chequeo si el genero que va a ser mi padre ya lo tengo asignado
                    if(mg.Existegenero(nombrepadre)!=true){                      
                        mg.AltaGeneroPadre(nombrepadre);//doy de alta el genero del padre ya que despues de fijarme no existia
                        Genero G2 = mg.ObtenerGenero(nombrepadre);//pido la ubicacion del genero del padre
                        ge.añadopapa(G2);//lo añado ya despues de haberlo creado                   
                    }else{
                        if(mg.Existegenero(nombrepadre)==true){
                         Genero G2 = mg.ObtenerGenero(nombrepadre);//pido la ubicacion del genero del padre
                         ge.añadopapa(G2);//lo añado
                         }                          
                    }
                }
                   throw new GenroYaExiste("El Genero padre"+nombrepadre+"Ya lo tiene como padre");
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
