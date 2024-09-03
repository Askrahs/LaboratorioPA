package Excepciones;

public class OperacionNoPermitidaException extends Exception{
    public OperacionNoPermitidaException (String string){
        super(string);
    }
}