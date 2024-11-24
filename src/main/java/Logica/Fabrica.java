package Logica;

import Persistencia.ControllerPersistencia;

public class Fabrica {
    private static Fabrica instancia;
    private IControllerMusica controllerMusica;
    private IControllerUsuario controllerUsuario;

    // Constructor privado para el Singleton
    private Fabrica() {}

    // Método para obtener la instancia única de Fabrica
    public static synchronized Fabrica getInstance() {
        if (instancia == null) {
            instancia = new Fabrica();
        }
        return instancia;
    }

    // Método para obtener una instancia de IControllerMusica
    public IControllerMusica getIControllerMusica() {
        if (controllerMusica == null) {
            ControllerPersistencia cPersist = new ControllerPersistencia();
            // Crear ControllerUsuario con cPersist (necesario para ControllerMusica)
            controllerUsuario = new ControllerUsuario(cPersist, (ControllerMusica) controllerMusica);
            // Crear ControllerMusica pasándole ambos controladores
            controllerMusica = new ControllerMusica(cPersist, (ControllerUsuario) controllerUsuario);
        }
        return controllerMusica;
    }

    // Método para obtener una instancia de IControllerUsuario
    public IControllerUsuario getIControllerUsuario() {
        if (controllerUsuario == null) {
            ControllerPersistencia cPersist = new ControllerPersistencia();
            // Crear ControllerUsuario con cPersist y controllerMusica (necesario para ControllerUsuario)
            controllerUsuario = new ControllerUsuario(cPersist, (ControllerMusica) controllerMusica);
        }
        return controllerUsuario;
    }
}
