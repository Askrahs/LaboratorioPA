package Logica;

import java.util.Collection;


public class Artista extends Usuario{
    private String biografia;
    private String webSite;
    
    public  Artista(){
    
    }

    public Artista(String nickname, String nombre, String apellido, String email, String imagen, String fechaNac, Collection<Usuario> siguiendo, Collection<Usuario> seguidores, String biografia, String webSite) {
        super(nickname, nombre, apellido, email, imagen, fechaNac, siguiendo, seguidores);
        this.biografia = biografia;
        this.webSite = webSite;
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

    

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
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

    
    
}


