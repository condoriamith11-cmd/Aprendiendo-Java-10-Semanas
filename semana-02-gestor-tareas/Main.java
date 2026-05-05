import servicio.GestorTarea;
import modelo.Tarea;
import java.util.Scanner;

public class Main {
    static GestorTarea gestor = new GestorTarea();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int opcion,id;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: agregartareas();
                break;
                case 2: gestor.listar();
                    break;
                case 3: gestor.listarPendientes();
                    break;
                case 4: gestor.listarCompletas();
                break;
                case 5: System.out.println("Ingrese el ID de la tarea");
                        id = scanner.nextInt();
                        gestor.completar(id);
                    break;
                case 6: System.out.println("Ingrese el ID de la tarea");
                        id = scanner.nextInt();
                        gestor.eliminar(id);
                    break;
                case 7: System.out.println("Ingrese el ID de la tarea");
                        id = scanner.nextInt();
                        gestor.buscar(id);
                    break;
                case 8: gestor.totalTareas();
                    break;
                case 9: gestor.totalPendientes();
                    break;
                case 10: gestor.totalCompletadas();
                    break;
                case 11: gestor.mostrarEstadisticas();
                    break;
                case 12: System.out.println("Adios!");
                    break;
                default: System.out.println("Opcion invalida");
            }
        }while(opcion != 11);   
    }
    static void mostrarMenu () {
        System.out.println ( " \n === AGENDA === " ) ;
        System.out.println ( " 1. Agregar tareas " ) ;
        System.out.println ( " 2. Listar tareas " ) ;
        System.out.println ( " 3. Listar tareas pendientes " ) ;
        System.out.println ( " 4. Listar tareas completas " ) ;
        System.out.println ( " 5. Completar trea por ID " ) ;
        System.out.println ( " 6. Eliminar tarea por ID " ) ;
        System.out.println ( " 7. Buscar por ID " ) ;
        System.out.println ( " 8. Numero de tareas " ) ;
        System.out.println ( " 9. Numero de tareas pendientes " ) ;
        System.out.println ( " 10. Numeros de tareas completadas " ) ;
        System.out.println ( " 11. Estadisticas " ) ;
        System.out.println ( " 12. Salir " ) ;
        System.out.print ( " Opcion : " ) ;
    }
    static void agregartareas() {
        int n;
        String titulo, descripcion;
        System.out.println("Cuantas tareas ingresara");
        n = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < n; i++) {
            System.out.print("Ingrese titulo: \n");
            titulo = scanner.nextLine();

            System.out.print("Ingrese Descripcion: ");
            descripcion = scanner.nextLine();

            gestor.agregar(titulo,descripcion);
        }
    }

}
