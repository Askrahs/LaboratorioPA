package Logica;
import java.util.List;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Album implements Serializable{
    private Artista artista;
    @Id private String titulo;
    private List<Genero> generos;
    private int anio;
    private List<Tema> temas;
    private String rutaImagen;
    
    public Album(Artista artista, String nombre, List<Genero> generos, int anio, List<Tema> temas, String rutaImagen) {
        this.artista = artista;
        this.titulo = nombre;
        this.generos = generos;
        this.anio = anio;
        this.temas = temas;
        this.rutaImagen = rutaImagen;
    } 
    
    //Getters
    public Artista getArtista(){
        return this.artista;
    }
    public String getTitulo(){
        return this.titulo;
    }
    public List<Genero> getGeneros(){
        return this.generos;
    }
    public int getAnio(){
        return this.anio;
    }
    public List<Tema> getTemas(){
        return this.temas;
    }
    public String getRutaImagen(){
        return this.rutaImagen;
    }
}