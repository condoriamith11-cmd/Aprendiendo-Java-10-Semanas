import servicio.AgendaContactos;
import modelo.Contacto;
import exception.*;
import java.util.Scanner;

public class Main {
    static AgendaContactos agenda = new AgendaContactos();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do{
            mostrarMenu();
            opcion = leerOpcion();
            switch (opcion) {
                case 1: agregarContacto();
                    break;
                case 2: listarContacto();
                    break;
                case 3: listarContactoConEmail();
                    break;
                case 4: buscarContactoId();
                    break;
                case 5: buscarContactoNombre();
                    break;
                case 6: eliminarContacto();
                    break;
                case 7: System.out.println("Adios!");
                    break;
                default: System.out.println("Opcion Invalida.");
                    break;
            }
        }while(opcion != 7);
        sc.close();
    }

    static int leerOpcion(){
        try{
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e){
            return -1; // Retorna -1 si no es un numero
        }
    }
    static void mostrarMenu(){
        System.out.println("\n=== AGENDA ===");
        System.out.println("1. Agregar contacto");
        System.out.println("2. Listar Todos");
        System.out.println("3. Listar contactos con Email");
        System.out.println("4. Buscar por ID");
        System.out.println("5- Buscar por Nombre");
        System.out.println("6. Eliminar");
        System.out.println("7. Salir");
        System.out.println("Opcion: ");
    }

    static void agregarContacto(){
        try{
            System.out.println("ID: ");
            String id = sc.nextLine();
            System.out.println("Nombre: ");
            String nombre = sc.nextLine();
            System.out.println("Telefono: ");
            String tel = sc.nextLine();
            System.out.println("Email: ");
            String email = sc.nextLine();

            agenda. agregar(new Contacto(id, nombre, tel, email));
            System.out.println("Contacto Guardado. ");
        } catch(ContactoExistenteException e) {
            System.out.println("Error: " + e.getMessage());
        } catch(DatoInvalidoException e) {
            System.out.println("Dato invalido en '" + e.getCampo() + "': " + e.getMessage());
        }
    }

    static void listarContacto(){
        var lista = agenda.listarTodos();
        if(lista.isEmpty()){
            System.out.println("No hay contactos.");
            return;
        }
        System.out.println("\n=== CONTACTOS (" + lista.size() + ") ===");
        for (var c: lista)
            System.out.println(c);
    }
    static void listarContactoConEmail(){
    var lista = agenda.listarTodos();
    if(lista.isEmpty()){
        System.out.println("No hay contactos.");
        return;
    }
    System.out.println("\n=== CONTACTOS CON EMAIL (" + agenda.totalConEmail() + ") ===");
    for(var c : lista){
        if(c.getEmail() != null && !c.getEmail().trim().isEmpty()){
            System.out.println(c);
        }
    }
}
    static void buscarContactoId() {
        System.out.print("ID a buscar: ");
        String id = sc.nextLine();
        try{
            System.out.println(agenda.buscarPorId(id));
        } catch(ContactoNoEncontradoException e){
            System.out.println(e.getMessage());
        }
    }
    static void buscarContactoNombre() {
        System.out.print("Nombre a buscar: ");
        String nombre = sc.nextLine();
        try{
            System.out.println(agenda.buscarPorNombre(nombre));
        } catch(ContactoNoEncontradoException e){
            System.out.println(e.getMessage());
        }
    }
    static void eliminarContacto(){
        System.out.println("ID a eliminar: ");
        String id = sc.nextLine();
        try {
            agenda.eliminar(id);
            System.out.println("Contacto eliminado.");
        } catch (ContactoNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }
}
