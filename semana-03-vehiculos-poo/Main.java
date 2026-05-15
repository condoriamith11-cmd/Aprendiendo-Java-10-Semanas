import modelo.*;
import servicio.GestorVehiculos;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GestorVehiculos gestor = new GestorVehiculos();
        // DEMOSTRACION DE POLIMORFISMO 
        // Un solo ArrayList<Vehiculo> almacena objetos
        // de distintos tipos.
        // Cada objeto ejecuta su propia version de acelerar()

        ArrayList<Vehiculo> flota = new ArrayList<>();

        flota.add(new Auto("Toyota", "Corolla", 2024, 4));
        flota.add(new Moto("Honda", "CB500", 2023, false));
        flota.add(new Camion("Volvo", "FH16", 2022, 24.0));
        flota.add(new AutoElectrico("Tesla", "Model 3", 2024, 4, 80));
        flota.add(new MotoElectrica("NIU", "MQi+", 2023, 60));

 
        System.out.println(" DEMOSTRACION DE POLIMORFISMO ");
        System.out.println("------------------------------");

        for (Vehiculo v : flota) {
            System.out.println(v.getInfo());

            // Polimorfismo:
            // aunque v es Vehiculo,
            // Java ejecuta el acelerar()
            // correspondiente al objeto real
            v.acelerar();
        }

        gestor.agregar(new Auto("Toyota", "Corolla", 2024, 4));
        gestor.agregar(new Moto("Honda", "CB500", 2023, false));
        gestor.agregar(new Camion("Volvo", "FH16", 2022, 24.0));
        gestor.agregar(new AutoElectrico("Tesla", "Model 3", 2024, 4, 15));
        gestor.agregar(new MotoElectrica("NIU", "MQi+", 2023, 10));

        int opcion;
        do {

            System.out.println("\nGESTION DE VEHICULOS ");
            System.out.println("-------------------------");
            System.out.println("1. Agregar vehiculo");
            System.out.println("2. Listar todos");
            System.out.println("3. Filtrar por tipo");
            System.out.println("4. Ver electricos y baterias");
            System.out.println("5. Cargar baterias bajas");
            System.out.println("6. Demostrar polimorfismo");
            System.out.println("7. Estadisticas");
            System.out.println("8. Salir");
            System.out.print("Opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:

                    System.out.println("\nTIPOS:");
                    System.out.println("1. Auto");
                    System.out.println("2. Moto");
                    System.out.println("3. Camion");
                    System.out.println("4. Auto Electrico");
                    System.out.println("5. Moto Electrica");

                    System.out.print("Seleccione tipo: ");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Marca: ");
                    String marca = sc.nextLine();

                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();

                    System.out.print("Anio: ");
                    int anio = sc.nextInt();

                    switch (tipo) {

                        case 1:

                            System.out.print("Numero de puertas: ");
                            int puertas = sc.nextInt();
                            gestor.agregar(new Auto(marca, modelo, anio, puertas));
                            break;

                        case 2:

                            System.out.print("Tiene sidecar? (true/false): ");
                            boolean sidecar = sc.nextBoolean();

                            gestor.agregar(new Moto(marca, modelo, anio, sidecar));
                            break;

                        case 3:

                            System.out.print("Capacidad toneladas: ");
                            double ton = sc.nextDouble();
                            gestor.agregar(new Camion(marca, modelo, anio, ton));
                            break;

                        case 4:

                            System.out.print("Numero de puertas: ");
                            int p = sc.nextInt();
                            System.out.print("Nivel bateria: ");
                            int bat = sc.nextInt();

                            gestor.agregar(new AutoElectrico(marca, modelo, anio, p, bat));
                            break;

                        case 5:

                            System.out.print("Nivel bateria: ");
                            int bateria = sc.nextInt();

                            gestor.agregar(new MotoElectrica(marca, modelo, anio, bateria));
                            break;

                        default:
                            System.out.println("Tipo invalido");
                    }
                    break;

                case 2:
                    gestor.listarTodos();
                    break;

                case 3:

                    System.out.println("\nFILTROS:");
                    System.out.println("auto");
                    System.out.println("moto");
                    System.out.println("camion");
                    System.out.println("electrico");

                    System.out.print("Ingrese tipo: ");
                    String filtro = sc.nextLine();

                    gestor.listarPorTipo(filtro);

                    break;

                case 4:
                    gestor.listarElectricos();
                    break;

                case 5:
                    gestor.cargarElectricosNecesarios();
                    break;

                case 6:
                    gestor.demostrarPolimorfismo();
                    break;

                case 7:
                    gestor.mostrarEstadisticas();
                    break;

                case 8:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 8);

        sc.close();
    }
}