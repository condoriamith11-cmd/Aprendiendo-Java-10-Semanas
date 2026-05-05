package servicio;

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
        Tarea nueva = new Tarea(proximoId, titulo, descripcion);
        tareas.add(nueva);
        proximoId++;
        System.out.println("Tarea agregada con ID: "+ nueva.getId());
    }   
    public void listar() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas");
            return;
        }
        for (Tarea t : tareas) {
            t.mostrarInfo();
        }
    }
    public void listarPendientes() {
        if (tareas.isEmpty()) {
        System.out.println("No hay tareas registradas");
        return;
        }
        for (Tarea t : tareas) {
            if (!t.estaCompletada()) {
                t.mostrarInfo();
            }
        }   
    }
    public void listarCompletas() {
        if (tareas.isEmpty()) {
        System.out.println("No hay tareas registradas");
        return;
        }
        for (Tarea t : tareas) {
            if (t.estaCompletada()) {
                t.mostrarInfo();
            }
        }   
    }
    public void completar(int id){
        if (tareas.isEmpty()) {
        System.out.println("No hay tareas registradas");
        return;
        }
        for (Tarea t : tareas) {
            if (t.getId() == id ) {
                t.completar();
                return;
            }
        }   
        System.out.println("Tarea no encontrada");
    }
    public void eliminar(int id){
        if (tareas.isEmpty()) {
        System.out.println("No hay tareas registradas");
        return;
        }
        for (int i = 0; i < tareas.size(); i++)  {
            if (tareas.get(i).getId() == id ) {
                tareas.remove(i);
                System.out.println("La tarea se elimino con exito");
            }
            System.out.println("Tarea no encontrada");
        }   
    }
    public Tarea buscar (int id){
        if (tareas.isEmpty()) {
        System.out.println("No hay tareas registradas");
        return null;
        }
        for (Tarea t : tareas) {
            if (t.getId() == id ) {
                return t;
            }
        }
        return null;   
    }
    public void totalTareas() {
        int n;
        if (tareas.isEmpty()) {
        System.out.println("No hay tareas registradas");
        return;
        }
        n = tareas.size();
        System.out.println("Se encontraron "+ n + " tareas");
    }   
    public void totalPendientes() {
        int c = 0;
        if (tareas.isEmpty()) {
        System.out.println("No hay tareas registradas");
        return;
        }
        for(Tarea t : tareas) {
            if(!t.estaCompletada())
                c++;
        }
        System.out.println("Se encontraron "+ c +" tareas pendientes");
    }
    public void totalCompletadas() {
        int c = 0;
        if (tareas.isEmpty()) {
        System.out.println("No hay tareas registradas");
        return;
        }
        for(Tarea t : tareas) {
            if(t.estaCompletada())
                c++;
        }
        System.out.println("Se encontraron "+ c +" tareas completas");
    }
    public void mostrarEstadisticas() {
    if (tareas.isEmpty()) {
        System.out.println("No hay tareas registradas");
        return;
    }

    int total = tareas.size();
    int pendientes = 0;
    int completadas = 0;

    for (Tarea t : tareas) {
        if (t.estaCompletada()) {
            completadas++;
        } else {
            pendientes++;
        }
    }

    double porcentaje = (completadas * 100.0) / total;

    System.out.println("===== ESTADISTICAS =====");
    System.out.println("Total tareas: " + total);
    System.out.println("Pendientes: " + pendientes);
    System.out.println("Completadas: " + completadas);
    System.out.printf("Porcentaje completadas: %.2f%%\n", porcentaje);
}
}