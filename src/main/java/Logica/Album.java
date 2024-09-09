package Logica;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Basic;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.GenerationType;

@Entity
public class Album implements Serializable{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Basic
    private String titulo;
    private int anio;
    private String rutaImagen;
    
    @ManyToOne
    private Artista artista;

    @ManyToMany
    @JoinTable(name = "Album_Genero",joinColumns = @JoinColumn(name = "album_id"),inverseJoinColumns = @JoinColumn(name = "genero_id"))
    private Set<Genero> generos;
    
    @OneToMany (mappedBy="album", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Tema> temas;   
    
    public Album(){}
    public Album(Artista artista, String nombre, Set<Genero> generos, int anio, Set<Tema> temas, String rutaImagen) {
        this.artista = artista;
        this.titulo = nombre;
        this.generos = generos;
        this.anio = anio;
        this.temas = temas;
        this.rutaImagen = rutaImagen;
    } 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Set<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(Set<Genero> generos) {
        this.generos = generos;
    }

    public Set<Tema> getTemas() {
        return temas;
    }

    public void setTemas(Set<Tema> temas) {
        this.temas = temas;
    }
    
    private void addTemaSet(Tema tema){
        temas.add(tema);
        tema.setAlbum(this);
    }
}