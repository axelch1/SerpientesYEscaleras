package Controlador;

import Modelo.Dado;
import Modelo.Jugador;

public interface Ivista {
	void mostrarMenuInicio();
	void mostrarMenuJuego();
	void mostrarMenuFin(String name);
	void mostrarJugador(String name);
	void cambioPosicion(int pos, int num);

    void agregarJugador(String nombre);

	void jugarTurno();

	void mostrarDado(int cara);
	void mostrarSerpiente();
	void mostrarEscalera();
	void comenzar();
	void setControlador(Controlador ctrl);
}
