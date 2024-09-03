package Logica;

import java.util.ArrayList;
import java.util.List;

public class Lista {
    private String nombre;
    private boolean esPublica;
    private Usuario propietario;
    private List<Tema> temas;

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

    public void setPropietario(Usuario propietario) {
        this.propietario = propietario;
    }

    public List<Tema> getTemas() {
        return temas;
    }

    public void addTema(Tema tema) {
        temas.add(tema);
    }

    public void removeTema(Tema tema) {
        temas.remove(tema);
    }
}
