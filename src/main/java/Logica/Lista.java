package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Lista")
public class Lista implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name="Nombre")
    private String nombre;
    @Column(name="rutaImagen")
    private String rutaImagen;
    @Column(name="Privada")
    private Boolean  esPrivada;
    //Solo si es publica
    @OneToOne
    @JoinColumn(name="Genero")
    private Genero genero;
    //Solo si es privada
    @OneToOne
    @JoinColumn(name="Duenio")
    private Usuario duenio;
    @OneToMany
    @JoinColumn(name="Temas")
    private List<Tema> temas;

    public Lista() {
    }

    
    
    public Lista( String nombre, String rutaImagen, Boolean estado, Genero genero, Usuario duenio) {
        this.nombre = nombre;
        this.rutaImagen = rutaImagen;
        this.esPrivada = estado;
        this.genero = genero;
        this.duenio = duenio;
        this.temas = new ArrayList<>();
    }      

    
    public void addTema(Tema tema) {
        temas.add(tema);
    }

    public void removeTema(Tema tema) {
        temas.remove(tema);
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

    public Boolean getEsPrivada() {
        return esPrivada;
    }

    public void setEsPrivada(Boolean esPrivada) {
        this.esPrivada = esPrivada;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Usuario getDuenio() {
        return duenio;
    }

    public void setDuenio(Usuario duenio) {
        this.duenio = duenio;
    }

    public List<Tema> getTemas() {
        return temas;
    }

    public void setTemas(List<Tema> temas) {
        this.temas = temas;
    }
    
    
    
}
