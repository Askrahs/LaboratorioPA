package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Lista")
public class Lista implements Serializable {
    @Id
    private Long id;
    
    private String nombre;
    private String rutaImagen;
    private Boolean  esPrivada;
    //Solo si es publica
    private Genero genero;
    //Solo si es privada
    private Usuario duenio;
    private List<Tema> temas;

    public Lista(){}
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
}
