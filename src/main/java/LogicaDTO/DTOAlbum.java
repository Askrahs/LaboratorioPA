package LogicaDTO;

import java.util.Set;

public class DTOAlbum {   
    private String titulo;
    private int anio;
    private String rutaImagen;
    private String artista;
    private Set<String> generos;
    private Set<DTOTema> temas;   

    
    public DTOAlbum(String titulo, int anio) {
        this.titulo = titulo;
        this.anio = anio;
     
    }
    
    
    public DTOAlbum(String titulo, int anio, String rutaImagen, String artista, Set<String> generos) {
        this.titulo = titulo;
        this.anio = anio;
        this.rutaImagen = rutaImagen;
        this.artista = artista;
        this.generos = generos;
    }
    
    public DTOAlbum(String titulo, int anio, String rutaImagen, String artista) {
        this.titulo = titulo;
        this.anio = anio;
        this.rutaImagen = rutaImagen;
        this.artista = artista;
    }
    
    public DTOAlbum(String titulo, int anio, String rutaImagen, String artista, Set<String> generos, Set<DTOTema> temas) {
        this.titulo = titulo;
        this.anio = anio;
        this.rutaImagen = rutaImagen;
        this.artista = artista;
        this.generos = generos;
        this.temas = temas;
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

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public Set<String> getGeneros() {
        return generos;
    }

    public void setGeneros(Set<String> generos) {
        this.generos = generos;
    }

    public Set<DTOTema> getTemas() {
        return temas;
    }

    public void setTemas(Set<DTOTema> temas) {
        this.temas = temas;
    }
    
    
}