/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extras;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author juansorondo
 */
public class Archivo {

    public static void guardar(String nombre, String linea) {
        try {
            Path file = Paths.get("salida/" + nombre);
            List<String> texto = new LinkedList<String>();
            texto.add(linea);
            Files.write(file, texto, Charset.forName("UTF-8"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
