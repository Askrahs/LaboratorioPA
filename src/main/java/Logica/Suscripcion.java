package Logica;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Suscripcion implements Serializable {

    public enum EstadoSuscripcion {
        VIGENTE, PENDIENTE, VENCIDA, CANCELADA
    }

    public enum TipoSuscripcion {
        SEMANAL, MENSUAL, ANUAL
    }

    @Id
    private String clienteNickname; // La PK es el nickname del cliente

    @Enumerated(EnumType.STRING)
    private EstadoSuscripcion estado;

    @Enumerated(EnumType.STRING)
    private TipoSuscripcion tipo;

    private String fecha;

    @OneToOne
    @JoinColumn(name = "clienteNickname", referencedColumnName = "nickname")
    @MapsId // Vinculamos el PK de Suscripcion con el FK de Cliente
    private Cliente cliente;

    public Suscripcion() {}

    public Suscripcion(EstadoSuscripcion estado, TipoSuscripcion tipo, String fecha, Cliente cliente) {
        this.estado = estado;
        this.tipo = tipo;
        this.fecha = fecha;
        this.cliente = cliente;
        this.clienteNickname = cliente.getNickname(); // Usamos el nickname del cliente
    }

    // Getters y setters
    public String getClienteNickname() {
        return clienteNickname;
    }

    public EstadoSuscripcion getEstado() {
        return estado;
    }

    public void setEstado(EstadoSuscripcion estado) {
        this.estado = estado;
    }

    public TipoSuscripcion getTipo() {
        return tipo;
    }

    public void setTipo(TipoSuscripcion tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        this.clienteNickname = cliente.getNickname(); // Sincronizamos el PK con el nickname del cliente
    }

    // Crear una nueva suscripción ejemplo
//    Suscripcion nuevaSuscripcion = new Suscripcion(
//            EstadoSuscripcion.VIGENTE, // El estado de la suscripción
//            TipoSuscripcion.MENSUAL, // El tipo de suscripción
//            "2024-10-01", // La fecha de la suscripción
//            cliente // Pasas el cliente (el nickname se obtiene automáticamente)
//    );
}
