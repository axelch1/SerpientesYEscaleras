package Aplicacion;

import Controlador.Controlador;
import Controlador.Ivista;
import VistaGrafica.VistaGrafica;

public class Main {

	public static void main(String[] args) {
		Ivista vista = new VistaGrafica();
		Controlador controlador = new Controlador(vista);

	}

}
