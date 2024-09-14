package Logica;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario implements Serializable{
    @Id protected String nickname;
    protected String nombre;
    protected String apellido;
    protected String email;
    
    @Lob
    protected String rutaImagen;
    protected String fechaNac;
    
    @ManyToMany
    @JoinTable(
        name = "Usuario_Siguiendo", // Nombre de la tabla relacion
        joinColumns = @JoinColumn(name = "usuario_id"), // Columna que se relaciona con este usuario
        inverseJoinColumns = @JoinColumn(name = "siguiendo_id") // Columna que se relaciona con el usuario que es seguido
    )
    protected Collection<Usuario> siguiendo; 
    @ManyToMany(mappedBy = "siguiendo")
    protected Collection<Usuario> seguidores; 
    
    
    
    public Usuario(){ }

    public Usuario(String nickname, String nombre, String apellido, String email, String imagen, String fechaNac, Collection<Usuario> siguiendo, Collection<Usuario> seguidores) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.rutaImagen = imagen;
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

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }
   
}
