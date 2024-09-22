
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Lista")
public class Lista implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Nombre en minúsculas para seguir la convención de Java

    @Column(name="Nombre", unique = true)
    private String nombre;

    @Column(name="rutaImagen")
    private String rutaImagen;

    @Column(name="Privada")
    private Boolean esPrivada;

    // Solo si es publica
    @OneToOne
    @JoinColumn(name="Genero")
    private Genero genero;

    // Solo si es privada
    @ManyToOne
    @JoinColumn(name="Duenio")
    private Usuario duenio;

    @OneToMany
    @JoinTable(name = "Lista_Temas", joinColumns = @JoinColumn(name = "Lista_id"), inverseJoinColumns = @JoinColumn(name = "Tema_Id"))
    private List<Tema> temas = new ArrayList<>();  // Inicialización de la lista

    // Constructor vacío
    public Lista() {}

    // Constructor con todos los parámetros
    public Lista(String nombre, String rutaImagen, Boolean estado, Genero genero, Usuario duenio) {
        this.nombre = nombre;
        this.rutaImagen = rutaImagen;
        this.esPrivada = estado;
        this.genero = genero;
        this.duenio = duenio;
        this.temas = new ArrayList<>();  // Inicialización correcta de la lista
    }

    // Constructor con menos parámetros
    public Lista(String nombre, String rutaImagen) {
        this.nombre = nombre;
        this.rutaImagen = rutaImagen;
        this.temas = new ArrayList<>();  // Inicialización correcta de la lista
    }

    // Método para agregar un tema a la lista
    public void addTema(Tema tema) {
        temas.add(tema);
    }

    // Método para eliminar un tema de la lista
    public void removeTema(Tema tema) {
        temas.remove(tema);
    }

    // Método para eliminar el dueño
    public void removeDuenio() {
        this.duenio = null;
    }

    // Getters y setters
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

    // Método getId
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
