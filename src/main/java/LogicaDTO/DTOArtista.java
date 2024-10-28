package LogicaDTO;

import java.io.Serializable;

public class DTOArtista implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nickname;
    private String nombre; 
    private String apellido; 
    private String email; 
    private String biografia; 
    private String website;
    private String imagen;
    private String fechaNac;
    
    public DTOArtista(String nickname, String nombre, String apellido, String email, String biografia, String website, String imagen, String fechaNac) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.biografia = biografia;
        this.website = website;
        this.imagen = imagen;
        this.fechaNac = fechaNac;
    }

    public String getNickname() {
        return nickname;
    }
    
    public String getfechaNac() {
        return fechaNac;
    }
    
    public String getImagen() {
        return imagen;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getBiografia() {
        return biografia;
    }

    public String getWebsite() {
        return website;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
