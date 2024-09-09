package Logica;
import Excepciones.*;
import LogicaDTO.*;
import java.util.List;
import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;

public interface IControllerMusica { 
    public abstract void altaAlbum(DTOAlbum album, Set<DTOTema> temas) throws AlbumYaExisteException, UsuarioNoExisteException;   
    public abstract void AltaGenero (String refe, String nombregen, String nombrepadre) throws GenroYaExiste;
    public abstract void altaListaReproduccion(String nombre, String genero, String duenio, String ruta) throws ListaYaExisteException;
    public abstract void publicarLista(String nombreUsuario, String nombreLista) throws UsuarioNoExisteException, ListaNoexisteException, OperacionNoPermitidaException;
    public void ingresarTema(String referencia, String nombre, String duracion) throws temaYaexiste;
    public abstract void ModificoPadre(String nombrenodo, String nombrepadrenuevo);
    public abstract DefaultMutableTreeNode DameTodoslosgeneros();
    public abstract void EliminoGenero(String nombregen, String refe);
    public abstract List<DTOLista> Obtengolistas()throws NoExisteLista;
    public  abstract List<DTOTema> Obtengotemas()throws TemaNoExiste;
    public abstract void AgregarTemaLista(String nombreusuario,String nombrelista, String nombretema)throws UsuariosNoExisten, ListaNoexisteException,NoesDueñodelaLista, TemaNoExiste;
    public  List <DTOGenero> Datageneros();
    public abstract void ingresarTema(String nombre, int duracion) throws temaYaexiste;
    public abstract void ModificoPadre(String nombrenodo, String nombrepadrenuevo);
    public abstract DefaultMutableTreeNode DameTodoslosgeneros();
    public abstract void EliminoGenero(String nombregen, String refe);
    public abstract List<String> obtenerAlbumsPorGenero(String generoSeleccionado);
    public abstract List<String> obtenerAlbumsPorArtista(String artistaSeleccionado);
    public abstract DTOAlbum consultaAlbumPorTitulo(String albumSeleccionado);
}
