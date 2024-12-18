package Modelo;

import ar.edu.unlu.rmimvc.observer.ObservableRemoto;

import java.rmi.RemoteException;
import java.util.ArrayList;


public class Juego extends ObservableRemoto implements IJuego {

	private Dado dado = new Dado();
	private Tablero tablero = new Tablero();
	private final static int INICIANDO = 0;
	private final static int JUGANDO = 1;
	private int estado = INICIANDO;
	private ArrayList<Jugador> jugadores = new ArrayList<>();
	private ArrayList<Observador> observers = new ArrayList<>();
	private ArrayList<Updates> cambios = new ArrayList<>();
	private int numero = 1;
	private int jugadorActual;
	

	//Singleton
	private static Juego instancia;

	public static Juego getInstance() {
		if (instancia == null) {
			instancia = new Juego();
		}
		return instancia;
	}

	private Juego() {
		super();
	}


	//Observers
	/*
	@Override
	public void agregarObservador(Observador observador) {

		observers.add(observador);
	}

	 */
	
	private void agregarCambio(Updates update) {
		cambios.add(update);
	}

	//notificar Observers sin RMI
	/*
	@Override
	public void notificarObservadores() {
		for (Observador o : observers) {
			for (Updates c : cambios) {
				o.actualizar(c);
			}
		}
		cambios.clear();
	}
	 */

	private void notificar() throws RemoteException {
		for (Updates c : cambios) {
			notificarObservadores(c);
		}
		cambios.clear();
	}
	
	//Juego
	@Override
	public void agregarJugador(String nombre) throws RemoteException{
		if (estado == INICIANDO) {
			jugadores.add(new Jugador(nombre, numero));
			numero++;
		}
		agregarCambio(Updates.MOSTRAR_JUGADOR);
		this.notificar();
	}
		
	@Override
	public void comenzar() throws RemoteException {
		if (jugadores.size() >= 2) {
			agregarCambio(Updates.COMIENZO_DEL_JUEGO);
			agregarCambio(Updates.CAMBIO_JUGADOR);
			for(Jugador j : jugadores) {
				j.cambiarPosicion(1);
			}
			agregarCambio(Updates.CAMBIO_POSICION);
			jugadorActual = 0;
			estado = JUGANDO;
			this.notificar();
		}
	}
	
	private void cambiarJugador() {
		jugadorActual++;
		if (jugadorActual == jugadores.size())
			jugadorActual = 0;
	}


	@Override
	public void jugarTurno() throws RemoteException {
		
		int pos;
		dado.tirardado();
		pos = jugadores.get(jugadorActual).getPosicion() + dado.getCara();
		if (pos>100) {
			pos = 100 - (pos-100);
		}
		jugadores.get(jugadorActual).cambiarPosicion(pos);
		jugadores.get(jugadorActual).sumarMovimiento();
		agregarCambio(Updates.CAMBIO_DADO);
		agregarCambio(Updates.CAMBIO_POSICION);
		this.notificar();

		if (tablero.esEscalera(pos)) {
			pos = tablero.posEscalera(pos);
			jugadores.get(jugadorActual).cambiarPosicion(pos);
			agregarCambio(Updates.ESCALERA);
			agregarCambio(Updates.CAMBIO_POSICION);
			this.notificar();
		}
		if (tablero.esSerpiente(pos)) {
			pos = tablero.posSerpiente(pos);
			jugadores.get(jugadorActual).cambiarPosicion(pos);
			agregarCambio(Updates.SERPIENTE);
			agregarCambio(Updates.CAMBIO_POSICION);
			this.notificar();
		}
		
		if (pos == 100) {
			numero = 1;
			estado = INICIANDO;
			agregarCambio(Updates.FIN_DEL_JUEGO);
			this.notificar();
			jugadores.clear();
		}

		if (dado.getCara() == 6) {
			agregarCambio(Updates.SACO_6);
			this.notificar();
		}
		
		if (dado.getCara() != 6 && pos != 100) {
		cambiarJugador();
		agregarCambio(Updates.CAMBIO_JUGADOR);
		this.notificar();
		}
	}

	
	@Override
	public Jugador getJugadorActual() throws RemoteException{
		return jugadores.get(jugadorActual);
	}

	@Override
	public ArrayList<String> getJugadores() throws RemoteException{
		ArrayList<String> listaJugadores = new ArrayList<>();
		for (Jugador jugador : jugadores) {
			listaJugadores.add(jugador.getNombre());
		}
		return listaJugadores;
	}

	@Override
	public Dado getDado() throws RemoteException{
		return dado;
	}

	@Override
	public int getNumero() throws RemoteException{
		return numero;
	}
	

}
