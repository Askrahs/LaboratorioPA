package Logica;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

//El mapeo consiste en artistas y los titulos de los albums
public class ManejadorAlbum {
    private Map<Artista, List<String>> albumsArtista;
    private static ManejadorAlbum instancia = null;

    private ManejadorAlbum() {
        albumsArtista = new HashMap<>();
    }

    public static ManejadorAlbum getInstance(){
        if (instancia == null)
            instancia = new ManejadorAlbum();
        return instancia;
    }
    
    //computeIfAbsent es para que si el artista ya esta en el mapa se usa la existente o si no se crea una nueva
    public void addAlbum(Album alb) {
        albumsArtista.computeIfAbsent(alb.getArtista(), k -> new ArrayList<>()).add(alb.getTitulo());
    }
    
    public Boolean existeAlbum(Artista a, String titulo) {
        List<String> titulos = albumsArtista.get(a);
        return titulos != null && titulos.contains(titulo);
    }
}