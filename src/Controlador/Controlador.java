package Controlador;

import Modelo.Juego;
import Modelo.Observador;
import Modelo.Updates;

public class Controlador implements Observador {
	private Juego game = Juego.getInstance();
	private Ivista vista;
	
	//constructor
	public Controlador (Ivista vista) {
		this.vista = vista;
		this.game.agregarObservador(this);
		vista.mostrarMenuInicio();
		vista.setControlador(this);
		vista.comenzar();
	}
	
	
	@Override
	public void actualizar(Updates update) {
		switch(update) {
			case CAMBIO_JUGADOR:
				vista.mostrarJugador(game.getJugadorActual());
				break;
			case CAMBIO_DADO:
				vista.mostrarDado(game.getDado());
			case CAMBIO_POSICION:
				vista.cambioPosicion(game.getJugadorActual());
				break;
			case ESCALERA:
				vista.mostrarEscalera();
				break;
			case SERPIENTE:
				vista.mostrarSerpiente();
				break;
			case FIN_DEL_JUEGO:
				vista.mostrarMenuFin(game.getJugadorActual());
				break;
			case COMIENZO_DEL_JUEGO:
				vista.mostrarMenuJuego();
				break;
			default:
				break;
		}
	}
	
	public void agregarJugador(String nombre) {
		game.agregarJugador(nombre);
	}
	
	
	public void comenzar() {
		game.comenzar();
	}
	
	public void jugarTurno() {
		game.jugarTurno();
	}
	

}
