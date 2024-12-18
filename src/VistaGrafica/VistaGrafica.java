package VistaGrafica;

import Controlador.Controlador;
import Controlador.Ivista;

import java.util.ArrayList;

public class VistaGrafica implements Ivista{

	private VentanaInicio VentanaInicio;
	private  VentanaRanking VentanaRanking;
	private VentanaJuego VentanaJuego;
	private VentanaFin VentanaFin;
	private Controlador Controlador;
	
	
	public VistaGrafica() {
		this.VentanaInicio = new VentanaInicio(this);
		this.VentanaRanking = new VentanaRanking(this);
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
		this.VentanaInicio.reiniciarBotones();
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
	public void mostrarJugadores(ArrayList<String> listaJugadores) {
		this.VentanaInicio.mostrarJugadores(listaJugadores);
	}

	@Override
	public void mostrarJugador(String name) {
		this.VentanaJuego.mostrarJugador(name);

	}

	@Override
	public void habilitarJugador() {
		this.VentanaJuego.habilitarJugador();
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
	public void mostrar6(){
		this.VentanaJuego.mostrar6();
	}

	@Override
	public void setControlador(Controlador ctrl) {
		this.Controlador = ctrl;
	}

	@Override
	public void mostrarMaximoJugadores() {
		this.VentanaInicio.mostrarMaximoJugadores();
	}

	@Override
	public void mostrarRanking(String ranking) {
		this.VentanaRanking.setVisible(true);
		this.VentanaInicio.setVisible(false);
		this.VentanaRanking.setRanking(ranking);
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

	public void getRanking(){
		Controlador.mostrarRanking();
	}

	public void volverMenuInicio() {
		this.VentanaRanking.setVisible(false);
		this.VentanaInicio.setVisible(true);
	}
}
