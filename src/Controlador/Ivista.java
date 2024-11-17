package Controlador;

import Modelo.Dado;
import Modelo.Jugador;

public interface Ivista {
	void mostrarMenuInicio();
	void mostrarMenuJuego();
	void mostrarMenuFin(Jugador jugador);
	void mostrarJugador(Jugador jugador);
	void cambioPosicion(Jugador jugador);
	void mostrarDado(Dado dado);
	void mostrarPieza(int nj);
	void mostrarSerpiente();
	void mostrarEscalera();
	void comenzar();
	void setControlador(Controlador ctrl);
}
