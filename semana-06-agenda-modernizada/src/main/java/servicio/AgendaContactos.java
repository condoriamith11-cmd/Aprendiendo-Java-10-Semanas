package servicio;
import exception.*;
import modelo.Contacto;
import util.ManejadorJSON;
import java.util.ArrayList;

public class AgendaContactos {
    private static final String ARCHIVO = "data/contactos.json";
    private static final String BACKUP = "data/contactos.backup.json";

    private ArrayList<Contacto> contactos;
    public AgendaContactos(){
        // Al crear la agenda,cargar los datos existentes
        contactos = ManejadorJSON.cargar(ARCHIVO);
        System.out.println("Agenda cargada con " + contactos.size() + " contactos.");
    }
    
    private void persistir(){
        //Despues de cada cambio, guardar con backup
        ManejadorJSON.guardarConBackup(contactos, ARCHIVO, BACKUP);
    }

    public void agregar(Contacto c) throws ContactoExistenteException{
        for (Contacto existente : contactos){
            if(existente.getId().equals(c.getId())){
                throw new ContactoExistenteException(c.getId());
            }
        }
        contactos.add(c);
        persistir(); // Guardar inmediatamente
    }
    public Contacto buscarPorId(String id)throws ContactoNoEncontradoException {
        for(Contacto c : contactos){
            if(c.getId().equals(id))
                return  c;
        }
        throw new ContactoNoEncontradoException("No existe contacto con ID: " + id);
    }
    public Contacto buscarPorNombre(String nombre)throws ContactoNoEncontradoException {
    for(Contacto c : contactos){
        if(c.getNombre().equalsIgnoreCase(nombre))
            return c;
    }
    throw new ContactoNoEncontradoException("No existe contacto con nombre: " + nombre);
}
    public void eliminar(String id) throws ContactoNoEncontradoException{
        Contacto c = buscarPorId(id);
        contactos.remove(c);
        persistir();
    }

    public ArrayList<Contacto> listarTodos(){
        return new ArrayList<>(contactos); // Copia defensiva
    }

    public int total(){
        return contactos.size();
    }
    
    public int totalConEmail(){
    int contador = 0;
    for(Contacto c : contactos){
        if(c.getEmail() != null && !c.getEmail().trim().isEmpty()){
            contador++;
        }
    }
    return contador;
}
}
