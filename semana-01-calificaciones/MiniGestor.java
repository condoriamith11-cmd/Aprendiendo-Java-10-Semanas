import java.util.InputMismatchException;
import java.util.Scanner;
public class MiniGestor {

    static Scanner scanner = new Scanner(System.in);
    static String[] nombres = new String[5]; //Modificado para ingresar 5 nombres
    static double[] promedios = new double[5]; //Promedio de cada estudiante
    static int totalEstudiantes = 0; 
    public static void main(String[] args) {
        int opcion;
        do{
            mostrarMenu();
            opcion = leerEntero("Opcion: ");
            switch (opcion) {
                case 1: agregarEstudiante();break;
                case 2: listarEstudiantes(); break;
                case 3: mostrarPromedios(); break;
                case 4: mostrarEstadisticas(); break;
                case 5: System.out.println("Adios!"); break;                
                default: System.out.println("Opcion invalida");
            }
        }while (opcion != 4);
    }
    public static void mostrarMenu() {
        System.out.println("\n=== MINI GESTOR ===");
        System.out.println("1. Agregar estudiantes");
        System.out.println("2. Listar estudiantes");
        System.out.println("3. Promedios de cada estudiante");
        System.out.println("4. Estadisticas");
        System.out.println("5. Salir");      
    }
    public static void agregarEstudiante(){
        if (totalEstudiantes >= nombres.length) {  //Limitar 5 estudiantes
            System.out.println("Capacidad maxima alcanzada");
            return;
        }
        scanner.nextLine(); //limpiar buffer
        System.out.println("Nombre ");
        nombres[totalEstudiantes] = scanner.nextLine();
        double[] notas = new double[3]; // Almacenar 3 notas
        for(int i = 0; i < 3; i++){
            notas[i] = leerNota("Nota " + (i+1) + ": "); 
        }
        promedios[totalEstudiantes] = calcPromedio(notas); // Calcula promedios
        totalEstudiantes++;
        System.out.println("Estudiante agregado!");
    }
    public static void listarEstudiantes(){
        if (totalEstudiantes == 0) {
            System.out.println("No hay estudiantes");
            return;
        }
        System.out.printf("%-15s %8s %12s%n", "NOMBRE","PROMEDIO","ESTADO");
        System.out.println("-".repeat(37));
        for(int i = 0; i < totalEstudiantes; i++){
            String est=estaAprobado(promedios[i])?"APROBADO" : "REPROBADO"; // Muestra si el estudiante esta aprobado o reprobado
            System.out.printf("%-15s %8.2s %12s%n",nombres[i], promedios[i], est);
        }
    }
    public static void mostrarPromedios() {
        if (totalEstudiantes == 0) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }   
        System.out.printf("%-15s %10s%n", "NOMBRE", "PROMEDIO");
        System.out.println("-".repeat(27));
        for (int i = 0; i < totalEstudiantes; i++) {
            System.out.printf("%-15s %10.2f%n", nombres[i], promedios[i]);
        }
    }
    public static void mostrarEstadisticas(){
        if ( totalEstudiantes == 0) {
             System.out.println ( " No hay datos " ) ;
             return ;
            }
        double max = promedios [0] , min = promedios [0];
        double suma = 0;
        int aprob = 0;
        for ( int i = 0; i < totalEstudiantes ; i ++) {
            suma += promedios [ i ];
            if ( promedios [ i ] > max ) max = promedios [ i ];
            if ( promedios [ i ] < min ) min = promedios [ i ];
            if ( estaAprobado ( promedios [ i ]) ) aprob ++;
        }
        System.out.printf ( " Promedio general : %.2f %n", suma / totalEstudiantes ) ;
        System.out.printf ( " Nota mas alta : %.2f %n " , max ) ; //Muestra la nota mas alta
        System.out.printf ( " Nota mas baja : %.2f %n " , min ) ; //Muestra la nota mas baja
        System.out.printf ( " Aprobados : %d/ %d %n " , aprob , totalEstudiantes ) ; 
        System.out.printf("Reprobados: %d/%d%n", totalEstudiantes - aprob, totalEstudiantes);
    }
    public static double calcPromedio(double[] notas){
        double s = 0;
        for (double n : notas) s += n;
        return s / notas.length;
    }
    public static boolean estaAprobado ( double prom ) {
        return prom >= 51;
    }

    public static double leerNota ( String msg ) {
        double nota ;
        do {
            nota = leerDouble ( msg ) ;
            if ( nota < 0 || nota > 100)
                System.out.println ( " Nota debe ser 0 -100 " ) ;
        } while ( nota < 0 || nota > 100) ;
        return nota ;
    }

    public static int leerEntero ( String msg ) {
        while ( true ) {
            try {
                System.out.print ( msg ) ;
                int v = scanner.nextInt () ;
                return v ;
            } catch ( InputMismatchException e ) {
                System.out.println ( " Ingresa un numero " ) ;
                scanner.nextLine () ;
            }
        }
    }

    public static double leerDouble ( String msg ) {
        while ( true ) {
            try {
                System.out.print ( msg ) ;
                double v = scanner.nextDouble () ;
                return v ;
            } catch ( InputMismatchException e ) {
                System.out.println ( " Ingresa un numero " ) ;
                scanner.nextLine () ;
            }
        }
    }
    
}







