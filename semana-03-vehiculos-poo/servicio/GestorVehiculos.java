package servicio;
import java.util.ArrayList;

import modelo.*;

public class GestorVehiculos {
    private ArrayList<Vehiculo> vehiculos;
    
    public GestorVehiculos(){
        this.vehiculos = new ArrayList<>();
    }

    public void agregar (Vehiculo v){
        vehiculos.add(v);
        System.out.println("Agregado: " + v.getInfo());
    }

    public void listarTodos(){
        System.out.println("\n=== Toda la flota ===");
        if (vehiculos.isEmpty()){
            System.out.println("   Sin vehiculos Registrados");
            return;
        }
        for(Vehiculo v : vehiculos){
            System.out.println("   " + v.getInfo());
        }
    }
    public void listarPorTipo (String tipo){
        System.out.println("\n=== Tipo: " + tipo + " ===");
        for(Vehiculo v : vehiculos){
            boolean mostrar  = false;
            if (tipo.equalsIgnoreCase("auto") && v instanceof Auto && !(v instanceof AutoElectrico))
                mostrar = true;
            if (tipo.equalsIgnoreCase("moto") && v instanceof Moto && !(v instanceof MotoElectrica))
                mostrar = true; 
            if (tipo.equalsIgnoreCase("camion") && v instanceof Camion)
                mostrar = true;
            if (tipo.equalsIgnoreCase("electrico") && v instanceof Electrico)
                mostrar = true;
            if (mostrar)
                System.out.println("   " + v.getInfo());
        }
    }
    public void listarElectricos(){
        System.out.println("\n=== Vehiculos electricos ===");
        boolean hayAlguno = false;
        for(Vehiculo v : vehiculos){
            if(v instanceof Electrico){
                Electrico e = (Electrico) v;
                System.out.println("   " + v.getInfo() + " | Bateria: " + e.getNivelBateria() + "%");;
                hayAlguno = true;
            }
        }
        if (!hayAlguno)
            System.out.println("  Sin vehiculos electricos");
    }

    public void cargarElectricosNecesarios(){
        System.out.println("\n=== Verificando baterias ===");
        for (Vehiculo v : vehiculos){
            if(v instanceof Electrico){
                Electrico e = (Electrico) v;
                if(e.necesitaCarga()){
                    System.out.println("   " + v.getInfo() + " -> ");
                    e.cargarBateria();
                }
            }
        }
    }
    public void demostrarPolimorfiasmo(){
        System.out.println("\n=== acelerar() en toda la flota ===");
        for (Vehiculo v : vehiculos){
            v.acelerar(); // cada tipo ejecuta su propia version
        }
    }
    public void mostrarEstadisticas(){
        int total = vehiculos.size();
        int electricos = 0;
        int necesitaCarga = 0;
        for(Vehiculo v: vehiculos){
            if (v instanceof Electrico){
                electricos ++;
                if(((Electrico) v). necesitaCarga())
                    necesitaCarga++;
            }
        }
        System.out.println("\n=== Estadisticas ===");
        System.out.println(" Total vehiculos : " + total);
        System.out.println(" Electricos      : " + electricos);
        System.out.println(" Necesitan carga : " + necesitaCarga);
    }
    public int getTotalVehiculos(){
        return vehiculos.size();
    }
}
