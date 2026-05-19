package exception;

//Extender Exception la hace "checked" (obligatorio manejarla)

public class ContactoNoEncontradoException extends Exception{
    public ContactoNoEncontradoException(String mensaje){
        super(mensaje); //El mensaje queda en e.getMessage()
    }    
}
