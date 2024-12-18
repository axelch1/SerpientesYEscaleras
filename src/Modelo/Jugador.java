package Modelo;

import java.io.Serializable;

public class Jugador implements Serializable {

	private String nombre;
	private int numero;
	private int posicion;
	private int movimientos;
	
	public Jugador(String Nombre, int Numero) {
		this.nombre = Nombre;
		this.numero = Numero;
		this.posicion = 1;
		this.movimientos = 0;
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

    public int getMovimientos() {
        return movimientos;
    }

	public void sumarMovimiento() {
		movimientos++;
	}

}
