package Persistencia;

import java.io.*;

public class Serializador {

    public static void serializar(String archivo, Object objeto) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(objeto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Object deserializar(String archivo) {
        Object objeto = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            objeto = ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return objeto;
    }
}