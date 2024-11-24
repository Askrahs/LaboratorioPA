package Logica;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class RegistroAcceso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incremento
    private Long id;

    private String ipUsuario;

    private String urlAcceso;

    private String browserUsuario;

    private String soUsuario;

    private String fechaAcceso;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIpUsuario() {
        return ipUsuario;
    }

    public void setIpUsuario(String ipUsuario) {
        this.ipUsuario = ipUsuario;
    }

    public String getUrlAcceso() {
        return urlAcceso;
    }

    public void setUrlAcceso(String urlAcceso) {
        this.urlAcceso = urlAcceso;
    }

    public String getBrowserUsuario() {
        return browserUsuario;
    }

    public void setBrowserUsuario(String browserUsuario) {
        this.browserUsuario = browserUsuario;
    }

    public String getSoUsuario() {
        return soUsuario;
    }

    public void setSoUsuario(String soUsuario) {
        this.soUsuario = soUsuario;
    }

    public String getFechaAcceso() {
        return fechaAcceso;
    }

    public void setFechaAcceso(String fechaAcceso) {
        this.fechaAcceso = fechaAcceso;
    }
}
