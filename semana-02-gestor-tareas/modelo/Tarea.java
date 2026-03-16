package modelo;

public class Tarea {
    private int id;
    private String titulo;
    private String descripcion;
    private String estado;
    public Tarea (int id, String titulo, String descripcion)
    {
        this.id = id;
        setTitulo(titulo);
        setDescripcion(descripcion);
    }
    // Getters
    public int getId(){return id;}
    public String getNombre(){ return nombre }
    public String getDescripcion() {return descripcion; }
    // Setters con validaciones 
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        }
    }
    public void setDescripcion(String descripcion) {
        if(descripcion != null && !descripcion.length() >= 5)
            this.descripcion = descripcion;
    }
    public void completar() {
        if(!estado.equals("Completada")) 
            estado = "Completada";
            System.out.println("Tarea completada!!!");
        else 
            System.out.println("La tarea ya esta completada...");
    }
    public void mostrarInfo() {
        System.out.println("ID: %d | Nombre: %s | Tel: %s%n", id, nombre, telefono);
    }
    public void estaCompletada() {
        if(estado.equals("Comletada"))
            return true;
        else 
            return false;
    }
}
