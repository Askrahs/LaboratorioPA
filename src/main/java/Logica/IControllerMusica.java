package Logica;
import Excepciones.*;
import LogicaDTO.*;
import java.util.List;
import java.util.Set;
import javax.swing.tree.DefaultMutableTreeNode;

public interface IControllerMusica { 
    public abstract void altaAlbum(DTOAlbum album, Set<DTOTema> temas) throws AlbumYaExisteException, UsuarioNoExisteException;   
    public abstract void AltaGenero (String refe, String nombregen, String nombrepadre) throws GenroYaExiste;
    public abstract void altaListaReproduccion(String nombre, String genero, String duenio, String ruta, boolean espirvada) throws ListaYaExisteException;
    //public abstract void AgregarTemaLista(String nombreusuario,String nombrelista, String nombretema)throws UsuariosNoExisten, ListaNoexisteException,NoesDueñodelaLista, TemaNoExiste;
    public abstract void ModificoPadre(String nombrenodo, String nombrepadrenuevo);
    public abstract DefaultMutableTreeNode DameTodoslosgeneros();
    public abstract void EliminoGenero(String nombregen, String refe);
    public abstract List<String> obtenerAlbumsPorGenero(String generoSeleccionado);
    public abstract List<String> obtenerAlbumsPorArtista(String artistaSeleccionado);
    public abstract DTOAlbum consultaAlbumPorTitulo(String albumSeleccionado);
    public abstract boolean existeAlbum(String nicknameArtista, String titulo);
    public  abstract List <DTOGenero> Datageneros();
    public  abstract void AñadotemalistaAlbum(String nombreAlbum, String nombreLista, String nombreTema, String NombreUsuario);
    public abstract void aniadoTemaListaPublica(String nombreLista, String nombreTema);
    public abstract List <DTOTema> TemasdeListas(String nombrelista);
    public abstract List<DTOLista> Obtengolistas()throws NoExisteLista;
    public abstract List<DTOLista> Obtengolistassinduenio()throws NoExisteLista;
    public abstract void aniadoTemaListaConduenio(String nombreUsuario,String nombrelista,String nombreteam);
    public abstract List<DTOLista> Obtengolistasconduenio()throws NoExisteLista;
    public abstract List<DTOAlbum> ObtengoAlbums();
    public abstract List<DTOTema> ObtengoTemasdeAlbum(String nombreAlbum);
    public abstract void EliminotemaLista(String nombrelista, String nombretema);
    public abstract void EliminoTemaListaConduenio(String nombreUsuario,String nombrelista,String nombreteam);
    public abstract List<String> obtenerListaPorGenero(String generoSeleccionado);
    public abstract List<String> obtenerListaPorCliente(String artistaSeleccionado);
    public abstract DTOLista consultaListaPorTitulo(String listaSeleccionado);
    public abstract DTOTema consultaTemaPorTitulo(String temaSeleccionada);
    public abstract Set<Genero> cargarSetGeneros(Set<String> generos);
    public abstract List<DTOTema> obtenerTemitas();
    public abstract List<DTOLista> obtenerListitas();
    public abstract List<DTOAlbum> obtenerAlbums();
    public abstract void publicarLista(String nombreUsuario, String nombreLista) throws UsuarioNoExisteException, ListaNoexisteException, OperacionNoPermitidaException, ListaYaEsPublicaException;
    public abstract List<DTOLista> ObtengolistasPUBLICAS()throws NoExisteLista;
    public abstract DTOLista consultaListaPorTituloyGenero(String listaSeleccionada, String genero);
    public abstract List<DTOTema> obtenerTemitasfavCliente(String nicknames);
    public abstract List<DTOLista> obtenerListitasfavCliente(String nicknames);
    public abstract List<DTOAlbum> obtenerAlbumsfavCliente(String nicknames);
}

