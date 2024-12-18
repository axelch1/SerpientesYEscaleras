package VistaConsola;

import Controlador.Controlador;
import Controlador.Ivista;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class VistaConsola extends JFrame implements Ivista {
    private JTextArea textArea1;
    private JPanel panel1;
    private JTextField textField1;
    private Controlador Controlador;
    private EstadoConsola estado;

    public VistaConsola() {
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
            case COMIENZO:
                procesarEntradaComienzo(entrada);
                break;
            case INICIO:
                procesarEntradaInicio(entrada);
                break;
            case JUEGO:
                procesarEntradaJuego(entrada);
                break;
            case ESPERANDO:
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

    private void procesarEntradaComienzo(String entrada) {
        if (Objects.equals(entrada, "ranking")) {
            Controlador.mostrarRanking();
        }
        else {
            agregarJugador(entrada);
            estado = EstadoConsola.ESPERANDO;
        }
    }

    private void procesarEntradaInicio(String entrada) {
        if (Objects.equals(entrada, "iniciar")) {
            estado = EstadoConsola.ESPERANDO;
            this.comenzar();
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
    public void comenzar() {
        Controlador.comenzar();
    }

    @Override
    public void mostrarMenuInicio() {
        textArea1.setText(null);
        estado = EstadoConsola.COMIENZO;
        println("Serpientes y Escaleras");
        println("");
        println("Ingrese -ranking- para ver el ranking");
        println("Ingresa tu nombre para agregarte a la lista de jugadores");
    }

    @Override
    public void mostrarMenuJuego() {
        textArea1.setText(null);
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
    public void mostrarJugadores(ArrayList<String> listaJugadores) {
        println("JUGADORES:");
        for (String jugador : listaJugadores) {
            println(jugador);
        }
        if (listaJugadores.size() >= 2) {
            estado = EstadoConsola.INICIO;
            println("Ingrese -iniciar- para comenzar a jugar");
        }
    }

    @Override
    public void mostrarJugador(String name) {
        println("");
        println("Turno de " + name);
    }

    @Override
    public void habilitarJugador() {
        estado = EstadoConsola.JUEGO;
        println("Ingrese -tirar- para tirar el dado");
    }

    @Override
    public void cambioPosicion(int pos, int num) {
        println("Esta en la posicion " + pos);
    }

    @Override
    public void agregarJugador(String nombre) {
        Controlador.agregarJugador(nombre);
    }

    @Override
    public void jugarTurno() {
        estado = EstadoConsola.ESPERANDO;
        Controlador.jugarTurno();
    }

    @Override
    public void mostrarDado(int cara) {
        println("");
        println("El dado muestra: " + cara);
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
    public void mostrar6() {
        println("Sacaste 6 vuelve a tirar!");
    }



    @Override
    public void setControlador(Controlador ctrl) {
        this.Controlador = ctrl;
    }

    @Override
    public void mostrarMaximoJugadores() {
        println("ya se ha alcanzado el maximo de jugadores");
    }

    @Override
    public void mostrarRanking(String ranking) {
        println("");
        println("Ranking de jugadores:\n");
        println("----------------------\n");
        println(ranking);
    }

}
