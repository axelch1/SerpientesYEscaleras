package Modelo;

public class Jugador {
	
	private String nombre;
	private int numero;
	private int posicion;
	
	public Jugador(String Nombre, int Numero) {
		this.nombre = Nombre;
		this.numero = Numero;
		posicion = 1;
	}
	
	public String getNombre () {
		return nombre;
		
	}
	public int getPosicion() {
		return posicion;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void cambiarPosicion(int nPosicion) {
		posicion = nPosicion;
	}
	
}
