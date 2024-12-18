package Modelo;

import ar.edu.unlu.rmimvc.observer.IObservableRemoto;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IJuego extends IObservableRemoto {
    /*
    static Juego getInstance() {
        return Juego.instancia;
    }
    */

    //Juego

    void agregarJugador(String nombre) throws RemoteException;

    void comenzar() throws RemoteException;

    void jugarTurno() throws RemoteException;

    Jugador getJugadorActual() throws RemoteException;

    ArrayList<String> getJugadores() throws RemoteException;

    Dado getDado() throws RemoteException;

    int getNumero() throws RemoteException;


}
