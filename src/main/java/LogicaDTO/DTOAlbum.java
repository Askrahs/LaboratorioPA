package LogicaDTO;

import java.io.Serializable;
import java.util.Set;

public class DTOAlbum implements Serializable{   
    private static final long serialVersionUID = 1L;
    private String titulo;
    private int anio;
    private String rutaImagen;
    private String artista;
    private Set<String> generos;
    private Set<DTOTema> temas;
    
    public DTOAlbum(String titulo, int anio, String rutaImagen, String artista, Set<String> generos, Set<DTOTema> temas) {
        this.titulo = titulo;
        this.anio = anio;
        this.rutaImagen = rutaImagen;
        this.artista = artista;
        this.generos = generos;
        this.temas = temas;
    }
    
    public DTOAlbum(String titulo, int anio, String rutaImagen, String artista){
        this.titulo = titulo;
        this.anio = anio;
        this.rutaImagen = rutaImagen;
        this.artista = artista;
    }


    public DTOAlbum() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    
     @Override
    public String toString() {
        return "DTOAlbum{" +
                "titulo='" + titulo + '\'' +
                ", anio=" + anio +
                ", rutaImagen='" + rutaImagen + '\'' +
                ", artista='" + artista + '\'' +
                ", generos=" + generos +
                ", temas=" + temas +
                '}';
    }
}
