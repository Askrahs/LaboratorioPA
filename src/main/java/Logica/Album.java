package Logica;
import java.util.List;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Album implements Serializable{
    private Artista artista;
    @Id private String titulo;
    private List<Genero> generos;
    private int anio;
    @OneToOne
   @JoinTable(
        name = "Album_Tema", // Nombre de la tabla relacion
        joinColumns = @JoinColumn(name = "album_id"), // Columna que se relaciona con este album
        inverseJoinColumns = @JoinColumn(name = "tema_id") // Columna que se relaciona con el tema
    )
    private Tema temas;
    private String rutaImagen;

    public Album() {
    }

    public void setTemas(Tema temas) {
        this.temas = temas;
    }
    
    
    
    
    public Album(Artista artista, String nombre, List<Genero> generos, int anio, Tema tema, String rutaImagen) {
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
    public Tema getTemas(){
        return this.temas;
    }
    public String getRutaImagen(){
        return this.rutaImagen;
    }
    
}