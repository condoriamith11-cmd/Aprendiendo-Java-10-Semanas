package sevicio;

import modelo.Tarea;
import java.util.ArrayList;

public class GestorTarea {
    private ArrayList<Tarea> tareas;
    private int proximoId;
    public GestorTarea() {
        tareas = new ArrayList<>();
        proximoId = 1;
    }
    public void agregar(String titulo, String descripcion) {
        Tarea nueva = new Tarea(proximoId, tarea, descripcion);
        tareas.add(nuevo);
        proximoId++;
        System.out.println("Contacto agregado con ID: "+ nuev.getId());
    }   
    public void listar() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas");
            return;
        }
        for (Tareas t : tareas) {
            t.mostrarInfo();
        }
    }
    public listarPendientes() {
        
    }
}