package Logica;

import java.util.List;

public class Album {
    //Atributos
    private Artista artista;
    private String titulo;
    private List<Genero> generos;
    private int anio;
    private List<Tema> temas;
    private String rutaImagen;
    
    //Constructor
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