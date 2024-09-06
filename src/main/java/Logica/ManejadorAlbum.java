package Logica;
import LogicaDTO.DTOAlbum;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

//El mapeo consiste en artistas y los titulos de los albums
public class ManejadorAlbum {
    private Map<Artista, List<String>> albumsArtista;
    private static ManejadorAlbum instancia = null;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction t;

    private ManejadorAlbum() {
        albumsArtista = new HashMap<>();
        emf = Persistence.createEntityManagerFactory("EspotifyBD");
        em = emf.createEntityManager();
        t = em.getTransaction(); //se usa para las consultas y commits/rollbacks
    }

    public static ManejadorAlbum getInstance(){
        if (instancia == null)
            instancia = new ManejadorAlbum();
        return instancia;
    }
    
    
    public void AddTema (Album b, Tema tem){
        b.setTemas(tem);
         try{
                t.begin();
               em.merge(b);
                t.commit();
         }catch(Exception e){}
    }   
    
    //computeIfAbsent es para que si el artista ya esta en el mapa se usa la existente o si no se crea una nueva
    public void addAlbum(Album alb) {
        albumsArtista.computeIfAbsent(alb.getArtista(), k -> new ArrayList<>()).add(alb.getTitulo());
         try {
            t.begin();
            em.persist(alb);
            t.commit();
        } catch (Exception e) {
            //si sale mal rollback
            t.rollback();
        }
    }
    
    public Boolean existeAlbum(Artista a, String titulo) {
        List<String> titulos = albumsArtista.get(a);
        return titulos != null && titulos.contains(titulo);
    }

    public List<Album> obtenerAlbumsArtista(String nickname) {
        
        return null;
    }

    List<Album> obtenerAlbumsGenero(String genero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public Album AlbumBaseDatos(String nombreAlbum){
            t.begin();
            Album al = em.find(Album.class,nombreAlbum);
            t.commit();
            return al;
    }
}