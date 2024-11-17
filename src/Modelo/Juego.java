package Modelo;

import java.util.ArrayList;


public class Juego {
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
	private static Juego instancia = new Juego();
	
	public static Juego getInstance() {
		return instancia;
	}
	
	
	//Observers
	public void agregarObservador(Observador observador) {
		observers.add(observador);
	}
	
	private void agregarCambio(Updates update) {
		cambios.add(update);
		for (Observador o : observers)
			o.actualizar(update);
	}

	private void notificarObservers() {
		for (Observador o : observers)
			for (Updates c : cambios)
				o.actualizar(c);
		cambios.clear();
	}
	
	//Juego
	public void agregarJugador(String nombre) {
		if (estado == INICIANDO) {
			jugadores.add(new Jugador(nombre, numero));
			numero++;
		}
	}
		
	public void comenzar() {
		if (jugadores.size() >= 2) {
			agregarCambio(Updates.COMIENZO_DEL_JUEGO);
			agregarCambio(Updates.CAMBIO_JUGADOR);
			for(Jugador j : jugadores) {
				j.cambiarPosicion(1);
				agregarCambio(Updates.CAMBIO_POSICION);
			}
			jugadorActual = 0;
			estado = JUGANDO;
			notificarObservers();
		}
	}
	
	private void cambiarJugador() {
		jugadorActual++;
		if (jugadorActual == jugadores.size())
			jugadorActual = 0;
	}
	
	
	public void jugarTurno() {
		
		int pos;
		dado.tirardado();
		pos = jugadores.get(jugadorActual).getPosicion() + dado.getCara();
		if (pos>100) {
			pos = 100 - (pos-100);
		}
		jugadores.get(jugadorActual).cambiarPosicion(pos);
		agregarCambio(Updates.CAMBIO_DADO);
		agregarCambio(Updates.CAMBIO_POSICION);
		notificarObservers();
		if (tablero.esEscalera(pos)) {
			pos = tablero.posEscalera(pos);
			jugadores.get(jugadorActual).cambiarPosicion(pos);
			agregarCambio(Updates.ESCALERA);
		}
		if (tablero.esSerpiente(pos)) {
			pos = tablero.posSerpiente(pos);
			jugadores.get(jugadorActual).cambiarPosicion(pos);
			agregarCambio(Updates.SERPIENTE);
		}
		agregarCambio(Updates.CAMBIO_POSICION);
		notificarObservers();
		
		if (pos == 100) {
			numero = 1;
			estado = INICIANDO;
			agregarCambio(Updates.FIN_DEL_JUEGO);
			notificarObservers();
			jugadores.clear();
		}
		
		if (dado.getCara() != 6 && pos != 100) {
		cambiarJugador();
		agregarCambio(Updates.CAMBIO_JUGADOR);
		notificarObservers();
		}
	}
	
	public Jugador getJugadorActual() {
		return jugadores.get(jugadorActual);
	}
	
	public Dado getDado() {
		return dado;
	}
	

}
