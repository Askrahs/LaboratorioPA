package Logica;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable{
    @Id protected String nickname;
    protected String nombre;
    protected String apellido;
    protected String email;
    protected String imagen;
    protected String fechaNac;
    protected Collection<Usuario> siguiendo; //one to many
    protected Collection<Usuario> seguidores; //one to many 
    
    //DTFecha fechaNacimiento;
    //Atributo imagen
    
    public Usuario(){ }

    public Usuario(String nickname, String nombre, String apellido, String email, String imagen, String fechaNac, Collection<Usuario> siguiendo, Collection<Usuario> seguidores) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.imagen = imagen;
        this.fechaNac = fechaNac;
        this.siguiendo = siguiendo;
        this.seguidores = seguidores;
    }

    public Collection<Usuario> getSiguiendo() {
        return siguiendo;
    }

    public void setSiguiendo(Collection<Usuario> siguiendo) {
        this.siguiendo = siguiendo;
    }

    public Collection<Usuario> getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(Collection<Usuario> seguidores) {
        this.seguidores = seguidores;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }
   
}
