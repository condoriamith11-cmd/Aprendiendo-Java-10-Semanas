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
        this.estado = "Pendiente";
    }
    // Getters
    public int getId(){return id;}
    public String getTitulo(){ return titulo; }
    public String getDescripcion() {return descripcion; }
    // Setters con validaciones 
    public void setTitulo(String titulo) {
        if (titulo != null && !titulo.trim().isEmpty()) {
            this.titulo = titulo;
        }
    }
    public void setDescripcion(String descripcion) {
        if(descripcion != null && descripcion.length() >= 5)
            this.descripcion = descripcion;
    }
    public void completar() {
        if(!estado.equals("Completada")) {
            estado = "Completada";
            System.out.println("Tarea completada!!!");
        }else{
        System.out.println("La tarea ya esta completada...");
        }
    }
    public void mostrarInfo() {
        System.out.printf("ID: %d | Estado: %s%nTitulo: %s%nDescripcion: %s%n", id, estado, titulo, descripcion);
    }
    public boolean estaCompletada() {
        if(estado.equals("Completada"))
            return true;
        else 
            return false;
    }
}
