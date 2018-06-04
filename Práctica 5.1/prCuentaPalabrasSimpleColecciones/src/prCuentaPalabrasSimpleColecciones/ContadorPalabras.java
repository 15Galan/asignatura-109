package prCuentaPalabrasSimpleColecciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class ContadorPalabras {

    private Set<PalabraEnTexto> palabras;

    public ContadorPalabras() {
        palabras = new TreeSet();
    }

    protected void incluye(String palabra) {
        try {
            PalabraEnTexto encontrada = encuentra(palabra);
            encontrada.incrementa();

        } catch (NoSuchElementException e) {
            palabras.add(new PalabraEnTexto(palabra));
        }
    }

    private void incluyeTodas(String linea, String delimitadores) {
        try (Scanner sc = new Scanner(linea)) {   // Un «Scanner» abierto en un «try» se cierra automaticamente al final.

            sc.useDelimiter(delimitadores);

            while (sc.hasNext()) {
                incluye(sc.next());
            }
        }
    }

    public void incluyeTodas(String[] lineas, String delimitadores) {
        for (String linea : lineas) {
            incluyeTodas(linea, delimitadores);
        }
    }

    public void incluyeTodasFichero(String fichero, String delimitadores) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File(fichero))) {
            leerFichero(sc, delimitadores);
        }
    }

    private void leerFichero(Scanner sc, String delimitadores){
        while(sc.hasNextLine()){                            // Se usa «hasNextLine()» porque se quieren obtener lineas.
            incluyeTodas(sc.nextLine(), delimitadores);     // El metodo «incluyeTodas()» trabaja con una linea.
        }
    }

    public PalabraEnTexto encuentra(String palabra) {
        PalabraEnTexto auxiliar = new PalabraEnTexto(palabra);
        PalabraEnTexto encontrada = null;

        Iterator<PalabraEnTexto> iterador = palabras.iterator();

        boolean seguir = true;

        while (iterador.hasNext() && seguir) {
            encontrada = iterador.next();
            seguir = encontrada.compareTo(auxiliar) < 0;
        }

        if (encontrada == null || !encontrada.equals(auxiliar)) {
            throw new NoSuchElementException("Palabra '" + palabra + "' no encontrada.");
        }

        return encontrada;
    }

    public void presentaPalabras(String fichero) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(fichero)) {
            presentaPalabras(pw);
            pw.toString();
        }

    }

    public void presentaPalabras(PrintWriter flujo) {
        for (PalabraEnTexto palabra : palabras) {
            flujo.println(palabra);
        }
    }

    @Override
    public String toString() {
        StringBuilder mensaje = new StringBuilder("[");
        int nPalabras = 0;

        for (PalabraEnTexto palabra : palabras) {
            mensaje.append(palabra);

            if (nPalabras != palabras.size()-1) {
                mensaje.append(", ");
            }

            nPalabras++;
        }

        mensaje.append("]");

        return mensaje.toString();
    }
}
