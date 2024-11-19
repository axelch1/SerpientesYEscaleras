package Aplicacion;

import Controlador.Controlador;
import Controlador.Ivista;
import VistaConsola.Consola;
import VistaGrafica.VistaGrafica;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		String[] opciones = {"Vista Gráfica", "Vista Consola"};
		Ivista vista = null;

		// Mostrar el cuadro de diálogo y obtener la selección
		int seleccion = JOptionPane.showOptionDialog(
				null, // Componente padre (null para centrar en pantalla)
				"Selecciona el tipo de vista:", // Mensaje
				"Tipo de Vista", // Título
				JOptionPane.DEFAULT_OPTION, // Tipo de opciones
				JOptionPane.QUESTION_MESSAGE, // Icono
				null, // Icono personalizado (null usa el predeterminado)
				opciones, // Opciones
				opciones[0] // Opción predeterminada
		);

		// Procesar la selección
		if (seleccion == 0) {
			System.out.println("Seleccionaste Vista Gráfica");
			vista = new VistaGrafica();
		} else if (seleccion == 1) {
			System.out.println("Seleccionaste Vista Consola");
			vista = new Consola();
		} else {
			System.out.println("No se seleccionó ninguna opción.");
		}

		Controlador controlador = new Controlador(vista);

	}

}
