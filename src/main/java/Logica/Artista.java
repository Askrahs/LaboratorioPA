package Logica;

import java.util.Collection;
import javax.persistence.Entity;

@Entity
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
}


