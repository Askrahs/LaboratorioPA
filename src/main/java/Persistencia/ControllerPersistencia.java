package Persistencia;

import Logica.Album;
import Logica.Lista;
import Logica.Tema;
import java.util.List;

public class ControllerPersistencia {
    AlbumJpaController albJpa = new AlbumJpaController();
    ArtistaJpaController artJpa = new ArtistaJpaController();
    TemaJpaController temJpa = new TemaJpaController();
    ListaJpaController listJpa = new ListaJpaController();
    ClienteJpaController cliJpa = new ClienteJpaController();

    public void altaAlbum(Album album) throws Exception {
        albJpa.create(album);
    }

    public void editarAlbum(Album album) throws Exception {
        albJpa.edit(album);
    }

    public void eliminarAlbum(Long albumId) throws Exception {
        albJpa.delete(albumId);
    }

    public Album buscarAlbum(Long albumId) {
        return albJpa.findAlbum(albumId);
    }
    
    public List<String> obtenerArtistas(){
        return artJpa.findAllArtistaNicknames();
    }

    public List<String> obtenerAlbumsPorGenero(String generoSeleccionado) {
        return albJpa.findAlbumPorGenero(generoSeleccionado);
    }

    public List<String> obtenerAlbumsPorArtista(String artistaSeleccionado) {
        return albJpa.findAlbumPorArtista(artistaSeleccionado);
    }

    public Album consultaAlbumPorTitulo(String albumSeleccionado) {
        return albJpa.findAlbumPorTitulo(albumSeleccionado);
    }

    public boolean existeAlbum(String nicknameArtista, String titulo) {
        return albJpa.artistaYaTieneAlbum(nicknameArtista, titulo);
    }

    public Tema findTemaPorNombre(String nombrelista){
        return temJpa.findTemaPorNombre(nombrelista);
   }
    public Album BuscoAlbumtemalis(String nombreAlbum){
        return albJpa.BuscoAlbumParaTemaLista(nombreAlbum);
    }
    
    public List<Album> todosLosAlbums(){
        return albJpa.todosLosAlbums();
    }
    
    public List<Tema> ObtengotemaPorAlbum(String NombreAlbum){
        return temJpa.obtenerTemaPorNombredeAlbum(NombreAlbum);
    }

    public List<Tema> findTemitas() {
        return temJpa.obtenerTodosLosTemas();
    }

    public List<String> obtenerClientes(){
        return cliJpa.findAllClienteNicknames();
    }
    
    public void altaLista(Lista list) throws Exception {
        listJpa.create(list);
    }

    public void editarLista(Lista list) throws Exception {
        listJpa.edit(list);
    }

    public void eliminarLista(Long listId) throws Exception {
        listJpa.delete(listId);
    }

    public Lista buscarLista(Long listId) {
        return listJpa.findLista(listId);
    }
    
    public List<String> obtenerListaPorGenero(String generoSeleccionado) {
        return listJpa.findListaPorGenero(generoSeleccionado);
    }

    public List<String> obtenerListaPorCliente(String clienteSeleccionado) {
        return listJpa.findListaPorCliente(clienteSeleccionado);
    }
    
    public Lista obtenerListaPorCliente2(String clienteSeleccionado) {
        return listJpa.findListaPorCliente2(clienteSeleccionado);
    }
    
    public Lista consultaListaPorTitulo(String listaSeleccionado) {
        return listJpa.findListaPorTitulo(listaSeleccionado);
    }
    
    public Lista consultaListaPorTituloyGenero(String listaSeleccionado, String genero) {
        return listJpa.findListaPorTituloyGenero(listaSeleccionado, genero);
    }   
    
    public List<Lista> findListas(){
        return listJpa.findListas();
    }
    public Tema findTemaPorDatos(String nombreTema, String duracion, String enlace, int posicion){
        return temJpa.findTemaPorDatos(nombreTema, duracion, enlace, posicion);
    }
    
    public Lista findListaPorDatos(String nombrelista,boolean privada){
        return listJpa.findListaPorDatos(nombrelista, privada);
    }
    
    
    public Album findAlbumPorDatos(String artista, String nombreA) {
        return albJpa.findAlbumPorDatos(artista, nombreA);
    }
    
    public Tema findTemaPorTitulo(String temaSeleccionado){
        return temJpa.findTemaPorTitulo(temaSeleccionado);
    }
    
    public List<Tema> obtenerTemasFavoritosDeCliente(String nicknameCliente) {
        return cliJpa.findTemasFavoritosDeCliente(nicknameCliente);
    }

    public List<Lista> obtenerListasFavoritasDeCliente(String nicknameCliente) {
        return cliJpa.findListasFavoritasDeCliente(nicknameCliente);
    }

    public List<Album> obtenerAlbumsFavoritosDeCliente(String nicknameCliente) {
        return cliJpa.findAlbumsFavoritosDeCliente(nicknameCliente);
    }
    public List<Album> obtenerTodosLosAlbumsCompletos(){
        return albJpa.todosLosAlbums();
    }

    public boolean albumEsDeXGenero(String albumTitulo, String artistaNickname, String generoNombre) {
        return albJpa.albumEsDeXGenero(albumTitulo, artistaNickname, generoNombre);
    }
}
