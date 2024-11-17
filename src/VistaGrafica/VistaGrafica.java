package VistaGrafica;

import Controlador.Controlador;
import Controlador.Ivista;
import Modelo.Dado;
import Modelo.Jugador;
import Modelo.Updates;

public class VistaGrafica implements Ivista{
	private VentanaInicio VentanaInicio;
	private VentanaJuego VentanaJuego;
	private VentanaFin VentanaFin;
	private Controlador Controlador;
	
	
	public VistaGrafica() {
		this.VentanaInicio = new VentanaInicio(this);
		this.VentanaJuego = new VentanaJuego(this);
		this.VentanaFin = new VentanaFin(this);
	}
	

	
	@Override
	public void comenzar() {
		this.mostrarMenuInicio();
	}

	@Override
	public void mostrarMenuInicio() {
		this.VentanaInicio.setVisible(true);
		this.VentanaJuego.setVisible(false);
		this.VentanaFin.setVisible(false);
		
	}

	@Override
	public void mostrarMenuJuego() {
		this.VentanaInicio.setVisible(false);
		this.VentanaJuego.setVisible(true);
	}

	@Override
	public void mostrarMenuFin(Jugador jugador) {
		this.VentanaJuego.setVisible(false);
		this.VentanaJuego.reiniciar();
		this.VentanaFin.MostrarGanador(jugador);
		this.VentanaFin.setVisible(true);
		
		
	}

	@Override
	public void mostrarJugador(Jugador jugador) {
		this.VentanaJuego.mostrarJugador(jugador);
		
	}

	@Override
	public void cambioPosicion(Jugador jugador) {
		this.VentanaJuego.cambioPosicion(jugador);

		
	}

	@Override
	public void mostrarSerpiente() {
		this.VentanaJuego.mostrarSerpiente();
		
	}

	@Override
	public void mostrarEscalera() {
		this.VentanaJuego.mostrarEscalera();
		
	}


	@Override
	public void setControlador(Controlador ctrl) {
		this.Controlador = ctrl;
	}

	public void agregarJugador(String nombre) {
		Controlador.agregarJugador(nombre);
	}
	
	public void Comenzar() {
		Controlador.comenzar();
		
	}
	
	public void jugarTurno() {
		Controlador.jugarTurno();
	}



	@Override
	public void mostrarDado(Dado dado) {
		this.VentanaJuego.mostrarDado(dado);
		
	}



	@Override
	public void mostrarPieza(int nj) {
		this.VentanaJuego.mostrarPieza(nj);
	}
	

}
