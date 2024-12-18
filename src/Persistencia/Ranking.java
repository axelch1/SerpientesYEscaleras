package Persistencia;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ranking implements Serializable {
    private static final long serialVersionUID = 1L;

    // Clase interna para representar una entrada del ranking
    private static class Entrada implements Serializable {
        private static final long serialVersionUID = 1L;
        private final String nombre;
        private final int movimientos;

        public Entrada(String nombre, int movimientos) {
            this.nombre = nombre;
            this.movimientos = movimientos;
        }

        public String getNombre() {
            return nombre;
        }

        public int getMovimientos() {
            return movimientos;
        }

        @Override
        public String toString() {
            return String.format("%-15s %d", nombre, movimientos);
        }
    }

    private final List<Entrada> ranking;

    public Ranking() {
        this.ranking = new ArrayList<>();
    }


    public void actualizarRanking(String nombre, int movimientos) {
        // Añadir la nueva entrada al ranking
        ranking.add(new Entrada(nombre, movimientos));

        // Ordenar las entradas por movimientos (ascendente)
        ranking.sort(Comparator.comparingInt(Entrada::getMovimientos));

        // Mantener solo las 5 mejores entradas
        if (ranking.size() > 5) {
            ranking.subList(5, ranking.size()).clear();
        }
    }

    public String obtenerRanking() {
        StringBuilder sb = new StringBuilder();
        for (Entrada entrada : ranking) {
            sb.append(entrada).append("\n");
        }
        return sb.toString();
    }

    public static Ranking cargarRanking() {
        File archivo = new File("ranking.ser");
        if (archivo.exists()) {
            // Deserializar el ranking desde el archivo
            return (Ranking) Serializador.deserializar("ranking.ser");
        } else {
            // Si no existe, crear un nuevo ranking
            return new Ranking();
        }
    }
}