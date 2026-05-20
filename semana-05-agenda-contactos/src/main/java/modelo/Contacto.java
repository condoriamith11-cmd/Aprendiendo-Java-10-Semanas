package modelo;

import exception.DatoInvalidoException;

public class Contacto {
    private String id;
    private String nombre;
    private String telefono;
    private String email;

    public Contacto(String id, String nombre, String telefono, String email){
        setId(id);
        setNombre(nombre);
        setTelefono(telefono);
        setEmail(email);
    }
    
    public String getId(){
        return id;
    }
    public String getNombre(){
        return nombre;  
    }
    public String getTelefono(){
        return telefono;
    }
    public String getEmail(){
        return email;
    }
    public void setId(String id){
        if(id == null || id.trim().isEmpty()){
            throw new DatoInvalidoException("id", "no puede estar vacio");
        }
        this.id = id.trim();
    }

    public void setNombre(String nombre){
        if(nombre == null || nombre.trim().isEmpty()){
            throw new DatoInvalidoException("nombre", "no puede estar vacio");
        }
        this.nombre = nombre.trim();
    }

    public void setTelefono(String telefono){
        if(telefono == null || telefono.length() < 7){
            throw new DatoInvalidoException("telefono", "debe tener al menos 7 digitos");
        }
        this.telefono = telefono;
    }

    public void setEmail(String email){
    if(email == null || email.trim().isEmpty()){
        throw new DatoInvalidoException("email", "no puede estar vacio");
    }

    if(!email.contains("@")){
        throw new DatoInvalidoException("email", "debe contener @");
    }

    this.email = email.trim();
    }

    public String toString(){
    return String.format("[%s] %s - Tel: %s - Email: %s", id, nombre, telefono, email);
    }
}
