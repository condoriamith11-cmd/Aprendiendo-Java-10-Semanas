package exception;

public class DatoInvalidoException extends RuntimeException {

    //Extiende RuntimeException: es "unchecked"
    //No obliga al que llama a usar try-catch
    private String campo;

    public DatoInvalidoException(String campo, String motivo){
        super("Dato invalido en '" + campo + "': " + motivo);
        this.campo = campo;
    }
    
    public String getCampo(){
        return campo;
    }
    
}
