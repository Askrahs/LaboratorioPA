package Logica;
import Excepciones.*;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;

public interface IControllerMusica {
    //public abstract void altaTema(String nombre,int duracion);
    public abstract void altaAlbum(String nicknameArtista, String titulo, List<Genero> generos, int anio, List<Tema> temas, String rutaImagen) throws AlbumYaExisteException, UsuarioNoExisteException;   
    public void AltaGenero (String refe, String nombregen, String nombrepadre) throws GenroYaExiste;
    public  void ModificoPadre(String nombrenodo, String nombrepadrenuevo);
    public DefaultMutableTreeNode DameTodoslosgeneros();
    public void EliminoGenero(String nombregen);
}
