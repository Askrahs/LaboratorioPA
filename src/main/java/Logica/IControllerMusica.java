package Logica;
import Excepciones.*;
import LogicaDTO.DTOAlbum;
import LogicaDTO.DTOGenero;
import LogicaDTO.DTOLista;
import LogicaDTO.DTOTema;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;

public interface IControllerMusica {
    public abstract void altaAlbum(String nicknameArtista, String titulo, List<Genero> generos, int anio,String refetema, String rutaImagen) throws AlbumYaExisteException, UsuarioNoExisteException;   
    public abstract void AltaGenero (String refe, String nombregen, String nombrepadre) throws GenroYaExiste;
    public void altaListaReproduccion(String nombre, String genero, String duenio, String ruta) throws ListaYaExisteException;
    public abstract void publicarLista(String nombreUsuario, String nombreLista) throws UsuarioNoExisteException, ListaNoexisteException, OperacionNoPermitidaException;
    public void ingresarTema(String referencia, String nombre, String duracion) throws temaYaexiste;
    public abstract List<DTOAlbum> cargarSegunArtista(String nickname);
    public abstract List<DTOAlbum> cargarSegunGenero(String genero);    
    public abstract void ModificoPadre(String nombrenodo, String nombrepadrenuevo);
    public abstract DefaultMutableTreeNode DameTodoslosgeneros();
   public abstract void EliminoGenero(String nombregen, String refe);
   public abstract List<DTOLista> Obtengolistas()throws NoExisteLista;
   public  abstract List<DTOTema> Obtengotemas()throws TemaNoExiste;
    public abstract void AgregarTemaLista(String nombreusuario,String nombrelista, String nombretema)throws UsuariosNoExisten, ListaNoexisteException,NoesDueñodelaLista, TemaNoExiste;
   public  List <DTOGenero> Datageneros();
}
