package Logica;
import Excepciones.*;
import LogicaDTO.DTOAlbum;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;

public interface IControllerMusica {
    public abstract void altaAlbum(String nicknameArtista, String titulo, List<Genero> generos, int anio, List<Tema> temas, String rutaImagen) throws AlbumYaExisteException, UsuarioNoExisteException;   
    public abstract void AltaGenero (String refe, String nombregen, String nombrepadre) throws GenroYaExiste;
    public void altaListaReproduccion(String nombre, String genero, String duenio, String ruta) throws ListaYaExisteException;
    public abstract void publicarLista(String nombreUsuario, String nombreLista) throws UsuarioNoExisteException, ListaNoexisteException, OperacionNoPermitidaException;
    public abstract void ingresarTema(String nombre, int duracion) throws temaYaexiste;
    public abstract List<DTOAlbum> cargarSegunArtista(String nickname);
    public abstract List<DTOAlbum> cargarSegunGenero(String genero);    
    public abstract void ModificoPadre(String nombrenodo, String nombrepadrenuevo);
    public abstract DefaultMutableTreeNode DameTodoslosgeneros();
   public abstract void EliminoGenero(String nombregen, String refe);
}
