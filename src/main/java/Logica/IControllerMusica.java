package Logica;
import Excepciones.*;
import LogicaDTO.DTOAlbum;
import java.util.List;

public interface IControllerMusica {
    public abstract void altaAlbum(String nicknameArtista, String titulo, List<Genero> generos, int anio, List<Tema> temas, String rutaImagen) throws AlbumYaExisteException, UsuarioNoExisteException;   
    public abstract void AltaGenero (String nombregen, String nombrepadre) throws GenroYaExiste;
    public void altaListaReproduccion(String nombre, String genero, String duenio, String ruta) throws ListaYaExisteException;
    public abstract void publicarLista(String nombreUsuario, String nombreLista) throws UsuarioNoExisteException, ListaNoexisteException, OperacionNoPermitidaException;
    public abstract void ingresarTema(String nombre, int duracion) throws temaYaexiste;
    public abstract List<DTOAlbum> cargarSegunArtista(String nickname);
    public abstract List<DTOAlbum> cargarSegunGenero(String genero);
}
