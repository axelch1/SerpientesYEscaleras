package Controlador;

import java.util.ArrayList;

public interface Ivista {
	void mostrarMenuInicio();
	void mostrarMenuJuego();
	void mostrarMenuFin(String name);
	void mostrarJugadores(ArrayList<String> listaJugadores);
	void mostrarJugador(String name);
	void habilitarJugador();
	void cambioPosicion(int pos, int num);

    void agregarJugador(String nombre);

	void jugarTurno();

	void mostrarDado(int cara);
	void mostrarSerpiente();
	void mostrarEscalera();
	void mostrar6();
	void comenzar();
	void setControlador(Controlador ctrl);

	void mostrarMaximoJugadores();

	void mostrarRanking(String ranking);
}
