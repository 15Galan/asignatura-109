import prCuentaPalabrasSimpleColecciones.ContadorPalabras;

import java.io.FileNotFoundException;

public class PruebaContadorPalabras {

    public static void main(String[] args) {

        // Desde array.
        String [] datos = {"Esta es la primera frase del ejemplo",
                           "y esta es la segunda frase"};

        ContadorPalabras contador = new ContadorPalabras();

        contador.incluyeTodas(datos, "[ ]");

        System.out.println("Desde array:    " + contador.toString());


        // Desde fichero.
        contador = new ContadorPalabras();

        try {
            contador.incluyeTodasFichero("datosPCP.txt", "[ .,:;\\-\\!\\¿\\¡\\?]+");

            System.out.println("Desde fichero:  " + contador.toString());

            contador.presentaPalabras("datosPCP_salida.txt");

        } catch (FileNotFoundException e) {
            System.err.println("No se encontró el fichero.");
        }
    }
}
