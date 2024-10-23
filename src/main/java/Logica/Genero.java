package Logica;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="Genero")
public class Genero implements Serializable{
   
    // Nombre en minúsculas para seguir la convención de Java
    @Id
    @Column(name="Nombre", unique = true, nullable = false)
    private String nombre;
    
    @Column(name="Padre")
    private String nombrepapa;
    
    @ManyToMany(mappedBy = "generos") 
    private Set<Album> albums;

    public Genero(){}
    
     public Genero( String nombree, String nompadre){
       
        this.nombre = nombree;
        this.nombrepapa=nompadre;
    }
   
 
    public String getNombre() {
        return nombre;
    }
    public String getNombrepapa() {
        return nombrepapa;
    }    

    public Set<Album> getAlbums() {
        return albums;
    }
    
}