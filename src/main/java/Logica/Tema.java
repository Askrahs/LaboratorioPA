package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Tema implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //ID autoincremental
    private int id;
    
    @Basic
    private String nombre;
    private String duracion;
    private String enlace;
    private int posicion;
    
    @ManyToOne
    private Album album;

    public Tema(){}

    public Tema(String nombre, String duracion, String enlace, int posicion, Album a) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.posicion = posicion;
        this.enlace = enlace;
        this.album = a;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
    
    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
}