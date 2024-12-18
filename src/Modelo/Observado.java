package Modelo;

public interface Observado {
    void agregarObservador(Observador observador);
    void notificarObservadores();
}

