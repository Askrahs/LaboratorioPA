package LogicaDTO;

import java.util.List;

public class DTOAlbum {
    private String nombre;
    private String anio; 
    private List<String> generos; 
    private String rutaImagen; 
    private List<DTOTema> temas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public List<String> getGeneros() {
        return generos;
    }

    public void setGeneros(List<String> generos) {
        this.generos = generos;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public List<DTOTema> getTemas() {
        return temas;
    }

    public void setTemas(List<DTOTema> temas) {
        this.temas = temas;
    }
    
}
