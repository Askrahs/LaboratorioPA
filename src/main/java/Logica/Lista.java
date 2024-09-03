package Logica;

public class Lista {
    private String nombre;
    private String rutaImagen;
    private Boolean  esPrivada;
    //Solo si es publica
    private Genero genero;
    //Solo si es privada
    private Usuario duenio;

    public Lista( String nombre, String rutaImagen, Boolean estado, Genero genero, Usuario duenio) {
        this.nombre = nombre;
        this.rutaImagen = rutaImagen;
        this.esPrivada = estado;
        this.genero = genero;
        this.duenio = duenio;
    } 
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public Boolean getPrivada() {
        return esPrivada;
    }

    public void setPrivada(Boolean privada) {
        this.esPrivada = privada;
    }
}
