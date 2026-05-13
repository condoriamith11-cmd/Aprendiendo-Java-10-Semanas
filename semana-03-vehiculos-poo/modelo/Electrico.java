package modelo;

public interface Electrico{
    void cargarBateria();
    int getNivelBateria();
    boolean necesitaCarga();  // true cuando bateria < 20%
}
