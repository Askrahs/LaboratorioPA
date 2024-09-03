package Logica;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

 //@Entity
public class Lista {
  //   @Id
  //   @Column(name="Nombre")
    private String nombre;
  //   @Column(name="Publica")
    private boolean esPublica;
   //  @OneToOne
   //  @JoinColumn (name="Nombre_Propietario")
    private final Usuario propietario;
   //  @OneToMany(mappedBy="Temas_id")
    private final List<Tema> temas;
    
   
    public Lista(String nombre, boolean esPublica, Usuario propietario) {
        this.nombre = nombre;
        this.esPublica = esPublica;
        this.propietario = propietario;
        this.temas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isPublica() {
        return esPublica;
    }

    public void setPublica(boolean esPublica) {
        this.esPublica = esPublica;
    }

    public Usuario getPropietario() {
        return propietario;
    }
    
    public void añadotema(Tema tem){
        temas.add(tem);
    }

    void pongotema(Tema tem) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}