package Persistencia;

import Logica.Album;
import Logica.Tema;
import java.util.List;

public class ControllerPersistencia {
    AlbumJpaController albJpa = new AlbumJpaController();
    ArtistaJpaController artJpa = new ArtistaJpaController();
    TemaJpaController temJpa = new TemaJpaController();

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
    
    public List<Album> Todoslosalbums(){
        return albJpa.todosLosAlbums();
    }
    
    public List<Tema> ObtengotemaPorAlbum(String NombreAlbum){
        return temJpa.obtenerTemaPorNombredeAlbum(NombreAlbum);
    }

}
