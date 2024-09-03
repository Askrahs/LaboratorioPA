package Logica;
import Excepciones.*;
import java.util.List;
import LogicaDTO.DTOAlbum;

public class ControllerMusica implements IControllerMusica {
    public ControllerMusica() {}
    
   @Override
    public void AltaGenero (String nombregen, String nombrepadre) throws GenroYaExiste{
        ManejadorGenero mg= ManejadorGenero.getInstance();
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
     
     @Override
     //A la espera de la otra parte del codigo
    public void altaListaReproduccion(String nombre, String genero, String duenio, String ruta) throws ListaYaExisteException{
        ManejadorLista ml = ManejadorLista.getInstance();
        //( String nombre, String rutaImagen, Boolean estado, Genero genero, Usuario duenio)
        if(genero == null){
            //Es privada
            //Cliente client = obtenerCliente(duenio);
            //Lista listaNueva = new Lista(nombre,ruta, false, null, user);
        }else{ 
            //Es publica
            //Genero genre = obtenerGenero(genero);
           // Lista listaNueva = new Lista(nombre,ruta, true, genre, null);
        }
        //ml.addLista(listaNueva);
    }
    
    public List<DTOAlbum> cargarSegunArtista(String nickname){
        ManejadorAlbum malb = ManejadorAlbum.getInstance();
        List<Album> albums = malb.obtenerAlbumsArtista(nickname);
        return null;
    }
    public List<DTOAlbum> cargarSegunGenero(String genero){
        ManejadorAlbum malb = ManejadorAlbum.getInstance();
        ManejadorGenero mgen = ManejadorGenero.getInstance();
        Genero g = mgen.ObtenerGenero(genero);
        List<Album> albums = malb.obtenerAlbumsGenero(genero);
        return null;

     @Override
    public void ingresarTema(String nombre, int duracion) throws temaYaexiste {
    ManejadordeTema te = ManejadordeTema.getinstance();
        if (te.obtenerTema(nombre) == null) {
            te.addTema(te.AltaTema(nombre, duracion));
            System.out.println("Tema agregado: " + nombre);
        } else {
            throw new temaYaexiste("El tema ya existe: " + nombre);
        }
    }
    
    @Override
    public void publicarLista(String nombreUsuario, String nombreLista) throws UsuarioNoExisteException, ListaNoexisteException, OperacionNoPermitidaException {
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
    }
}
