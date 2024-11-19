package VistaConsola;

import Controlador.Controlador;
import Controlador.Ivista;
import Modelo.Dado;
import Modelo.Jugador;

import javax.swing.*;
import java.util.Objects;

public class Consola extends JFrame implements Ivista {
    private JTextArea textArea1;
    private JPanel panel1;
    private JTextField textField1;
    private Controlador Controlador;
    private EstadoConsola estado;
    private int nj = 0;

    public Consola() {
        setTitle("SyE Consola");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setContentPane(panel1);
        setVisible(true);

        textField1.addActionListener(e -> {
            // Obtener el texto escrito
            String texto = textField1.getText();
            // Procesar entrada
            procesarEntrada(texto);
            // Limpiar el JTextField
            textField1.setText("");
        });
    }

    private void print(String string) {
        textArea1.append(string);
    }

    private void println(String string) {
        print(string + "\n");
    }

    private void procesarEntrada (String entrada) {
        switch (estado) {
            case INICIO:
                procesarEntradaInicio(entrada);
                break;
            case JUEGO:
                procesarEntradaJuego(entrada);
                break;
            case FIN:
                procesarEntradaFin(entrada);
                break;
        }
    }

    private void procesarEntradaJuego(String entrada) {
        if (Objects.equals(entrada, "tirar")) {
            this.jugarTurno();
        }
    }

    private void procesarEntradaInicio(String entrada) {
        if (Objects.equals(entrada, "iniciar")) {
            if (nj >= 2) {
                estado = EstadoConsola.JUEGO;
                textArea1.setText(null);
                this.comenzar();
                nj = 0;
            }
            else {
                println("debe haber al menos 2 jugadores para iniciar");
            }
        }
        else {
            if (nj < 4) {
                agregarJugador(entrada);
            }
            else {
                println("ya se ha alcanzado el maximo de jugadores");
                println("ingrese -iniciar- para comenzar");
            }
        }
    }

    private void procesarEntradaFin(String entrada){
        if (Objects.equals(entrada, "nuevo")){
            this.mostrarMenuInicio();
        }
        if (Objects.equals(entrada, "salir")){
            System.exit(1);
            this.mostrarMenuInicio();
        }
    }

    @Override
    public void mostrarMenuInicio() {
        textArea1.setText(null);
        estado = EstadoConsola.INICIO;
        println("Serpientes y Escaleras");
        println("");
        println("Ingrese nombre de jugador:");
        println("Ingrese -iniciar- para comenzar a jugar");
    }

    @Override
    public void mostrarMenuJuego() {
        println("¡Juego iniciado!");
        println("");
        println("SERPIENTES      ESCALERAS");
        println("  43-17            2-23");
        println("  50-5             6-45");
        println("  56-8            20-45");
        println("  73-15           52-72");
        println("  84-58           57-96");
        println("  87-49           71-92");
        println("  90-40                ");
    }

    @Override
    public void mostrarMenuFin(String name) {
        textArea1.setText(null);
        estado = EstadoConsola.FIN;
        println("");
        println("El ganador es " + name + "!");
        println("ingrese -nuevo- para jugar otra vez");
        println("ingrese -salir- para dejar de jugar");
    }

    @Override
    public void mostrarJugador(String name) {
        println("");
        println("Turno de " + name);
    }

    @Override
    public void cambioPosicion(int pos, int num) {
        println("Ahora estas en la posicion " + pos);
    }

    @Override
    public void agregarJugador(String nombre) {
        Controlador.agregarJugador(nombre);
        nj++;
        println("");
        println(nombre + " agregado!");
    }

    @Override
    public void jugarTurno() {
        Controlador.jugarTurno();
    }

    @Override
    public void mostrarDado(int cara) {
        println("El dado muestra: " + cara);
        if (cara == 6) println("Sacaste 6 vuelve a tirar!");
    }

    @Override
    public void mostrarSerpiente() {
        println("¡Has caído en una serpiente! Retrocedes posiciones.");

    }

    @Override
    public void mostrarEscalera() {
        println("¡Has subido por una escalera! Avanzas posiciones.");

    }

    @Override
    public void comenzar() {
        Controlador.comenzar();
    }

    @Override
    public void setControlador(Controlador ctrl) {
        this.Controlador = ctrl;
    }
}
