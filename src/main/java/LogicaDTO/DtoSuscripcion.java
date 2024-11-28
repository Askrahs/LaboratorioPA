package LogicaDTO;

public class DtoSuscripcion {
    
    private String Estado;
    private String Tipo;
    private String ClienteNickname;
    private String Fecha;
    //sin el atributo cliente.
    
    public DtoSuscripcion(){}

    public DtoSuscripcion(String Estado, String Tipo, String ClienteNickname, String Fecha) {
        this.Estado = Estado;
        this.Tipo = Tipo;
        this.ClienteNickname = ClienteNickname;
        this.Fecha = Fecha;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getClienteNickname() {
        return ClienteNickname;
    }

    public void setClienteNickname(String ClienteNickname) {
        this.ClienteNickname = ClienteNickname;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    
}
