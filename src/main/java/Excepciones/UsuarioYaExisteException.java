package Excepciones;

public class UsuarioYaExisteException extends Exception {
    public UsuarioYaExisteException(String string) {
        super(string);
    }
}
