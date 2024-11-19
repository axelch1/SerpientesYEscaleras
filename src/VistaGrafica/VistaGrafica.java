package VistaGrafica;

import Controlador.Controlador;
import Controlador.Ivista;

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

	public void mostrarPieza(int nj) {
		this.VentanaJuego.mostrarPieza(nj);

	}
	
	@Override
	public void comenzar() {
		Controlador.comenzar();
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
	public void mostrarMenuFin(String name) {
		this.VentanaJuego.setVisible(false);
		this.VentanaJuego.reiniciar();
		this.VentanaFin.MostrarGanador(name);
		this.VentanaFin.setVisible(true);
		
		
	}

	@Override
	public void mostrarJugador(String name) {
		this.VentanaJuego.mostrarJugador(name);
		
	}

	@Override
	public void cambioPosicion(int pos, int num) {
		this.VentanaJuego.cambioPosicion(pos, num);

		
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

	@Override
	public void agregarJugador(String nombre) {
		Controlador.agregarJugador(nombre);
	}

	@Override
	public void jugarTurno() {
		Controlador.jugarTurno();
	}

	@Override
	public void mostrarDado(int cara) {
		this.VentanaJuego.mostrarDado(cara);

	}

}
