package LogicaDTO;

import java.io.Serializable;

public class DTOTema implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id;
    private String nombre;
    private String duracion;
    private String enlace;
    private String archivo;
    private int posicion;
    private String album;
    private String artista;
    private double puntaje;

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

   // DTOTema(tema.getId(), tema.getNombre(), tema.getDuracion(),tema.getEnlace(), puntaje);
    public DTOTema(int id, String nombre, String duracion, String enlace, int posicion,double puntaje) {
        this.id=id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.enlace = enlace;
        this.posicion = posicion;
        this.archivo = archivo;
        this.puntaje = puntaje;
    }
    
        public DTOTema(int id, String nombre, String duracion, String enlace, String archivo, int posicion) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.enlace = enlace;
        this.posicion = posicion;
        this.archivo = archivo;
    }
        
    public DTOTema(String nombre, String duracion, String enlace, int posicion) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.enlace = enlace;
        this.posicion = posicion;
    }

    public DTOTema(String nombre, String duracion, String enlace, String album, String artista) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.enlace = enlace;
        this.album = album;
        this.artista = artista;
    }

    public DTOTema() {

    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }   
    
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Duración: " + duracion + ", Enlace: " + enlace + ", Posición: " + posicion;
    }
    
}
