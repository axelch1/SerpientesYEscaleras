package Modelo;

import java.util.HashMap;
import java.util.Map;

public class Tablero {

    private final Map<Integer, Integer> serpientes = new HashMap<>();
    private final Map<Integer, Integer> escaleras = new HashMap<>();

    public Tablero() {
        // Inicializar posiciones de serpientes y escaleras
        serpientes.put(43, 17);
        serpientes.put(50, 5);
        serpientes.put(56, 8);
        serpientes.put(73, 15);
        serpientes.put(84, 58);
        serpientes.put(87, 49);
        serpientes.put(98, 40);

        escaleras.put(2, 23);
        escaleras.put(6, 45);
        escaleras.put(20, 59);
        escaleras.put(52, 72);
        escaleras.put(57, 96);
        escaleras.put(71, 92);
    }

    public boolean esSerpiente(int pos) {
        return serpientes.containsKey(pos);
    }

    public int posSerpiente(int pos) {
        return serpientes.getOrDefault(pos, pos); // Devuelve la posición actual si no es serpiente
    }

    public boolean esEscalera(int pos) {
        return escaleras.containsKey(pos);
    }

    public int posEscalera(int pos) {
        return escaleras.getOrDefault(pos, pos); // Devuelve la posición actual si no es escalera
    }
}
