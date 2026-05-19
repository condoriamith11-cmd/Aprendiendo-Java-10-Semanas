package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import modelo.Contacto;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ManejadorJSON {
    
    //GsonBuilder con prettyPrinting hace el JSON legible
    private static final Gson gson = new Gson Builder().setPrettyPrinting().create();

    // Guardar lista en archivo JSON
    public static void guardar(ArrayList<Contacto> lista, String rutaArchivo){
        try (FileWriter writer = new FileWriter(rutaArchivo)){
            gson.toJson(lista, writer);
        }catch(IOException e){
            System.out.println("Error al  guardar datos: " + e.getMessage());
        }
    }

    //Cargar lista desde archivo JSON
    public static ArrayList<Contacto> cargar(String rutaArchivo){
        File archivo = new File(rutaArchivo);

        // Si el archivo no existe, retorna lista vacia
        if(!archivo.exists()){
            return new ArrayList<>();
        }
        try(FileReader reader = new FileReader(archivo)){
            Type tipo = new TypeToken<ArrayList<Contacto>>(){}.getType();
            ArrayList<Contacto> lista = gson.fromJson(reader, tipo);
            
            // fromJson puede retornar null si el archivo esta vacio
            return lista != null ? lista : new ArrayList<>();
        } catch(IOException e){
            System.out.println("Error al cargar datos: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // metodo backup
    public static void hacerBackup(String rutaOriginal, String rutaBackup){
        File original = new File(rutaOriginal);
        if(!original.exists()) return; 

        try (FileReader reader = new FileReader(original); FileWriter writer = new FileWriter(rutaBackup)){
            int caracter;
            while((caracter = reader.read()) != -1){
                writer.write(caracter);
                } 
            }catch (IOException e){
                System.out.println("No se pudo hacer backup: " + e.getMessage());
        }
    }

    //Metodo guardar con backup integrado

    public static void guardarConBackup(ArrayList<Contacto> lista, String rutaArchivo, String rutaBackup){
        hacerBackup(rutaArchivo, rutaBackup); // Primero el backup
        guardar(lista, rutaArchivo);
    }
}
