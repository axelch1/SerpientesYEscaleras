package Aplicacion;

import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import VistaGrafica.VistaGrafica;
import ar.edu.unlu.rmimvc.RMIMVCException;
import ar.edu.unlu.rmimvc.cliente.Cliente;
import Controlador.Controlador;
import Controlador.Ivista;
import VistaConsola.VistaConsola;

public class AppCliente {

    public static void main(String[] args) {

        /*
        ArrayList<String> ips = Util.getIpDisponibles();
        String ip = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la IP en la que escuchará peticiones el cliente", "IP del cliente",
                JOptionPane.QUESTION_MESSAGE,
                null,
                ips.toArray(),
                null
        );

        */
        String port = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione el puerto en el que escuchará peticiones el cliente", "Puerto del cliente",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                9999
        );

        /*
        String ipServidor = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la IP en la corre el servidor", "IP del servidor",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null
        );

        ipServidor = "127.0.0.1";

        String portServidor = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione el puerto en el que corre el servidor", "Puerto del servidor",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                8888
        );

         */

        //valores harcodeados menos puerto cliente
        String ip = "127.0.0.1";
        String  ipServidor = "127.0.0.1";
        String portServidor = "8888";

        //codigo para seleccionar tipo de vista

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
            vista = new VistaConsola();
        } else {
            System.out.println("No se seleccionó ninguna opción.");
        }

        Controlador controlador = new Controlador(vista);

       // Ivista vista = new VistaConsola();
       // Controlador controlador = new Controlador(vista);

        Cliente c = new Cliente(ip, Integer.parseInt(port), ipServidor, Integer.parseInt(portServidor));

        try {
            c.iniciar(controlador);

        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RMIMVCException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
