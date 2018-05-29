package prCuentaPalabrasSimpleFicheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ContadorPalabras {

    private PalabraEnTexto[] palabras;
    private int numPalabras;    // Cantidad de palabras en el array y ultima posicion libre.
    protected static final int TAM_INICIAL = 10;

    public ContadorPalabras(){
        this(TAM_INICIAL);
    }

    public ContadorPalabras(int tam){
        palabras = new PalabraEnTexto[tam];
        numPalabras = 0;
    }

    private int esta(String palabra){
        int esta = -1, i = 0;

        PalabraEnTexto auxiliar = new PalabraEnTexto(palabra);  // Un «String» no puede compararse en el array.

        while(esta == -1 && i < numPalabras){
            if(auxiliar.equals(palabras[i])){
                esta = i;
            }

            i++;
        }

        return esta;
    }

    protected void incluye(String palabra){
        int posicion = esta(palabra);   // Se establece el valor para no repetirlo continuamente.

        if(posicion != -1){
            palabras[posicion].incrementa();    // Aumenta las «veces» que aparece la palabra.

        }else{
            PalabraEnTexto nueva = new PalabraEnTexto(palabra);

            if(numPalabras == palabras.length){     // ¿El array esta lleno?
                palabras = Arrays.copyOf(palabras, palabras.length*2);
            }

            palabras[numPalabras] = nueva;
            numPalabras++;
        }
    }

    private void incluyeTodas(String linea, String delimitadores){
        try(Scanner sc = new Scanner(linea)){   // Un «Scanner» abierto en un «try» se cierra automaticamente al final.

            sc.useDelimiter(delimitadores);

            while(sc.hasNext()){
                incluye(sc.next());
            }
        }
    }

    public void incluyeTodas(String[] lineas, String delimitadores){
        for(String linea : lineas){
            incluyeTodas(linea, delimitadores);
        }
    }

    public void incluyeTodasFichero(String fichero, String delimitadores) throws FileNotFoundException{
        try(Scanner sc = new Scanner(new File(fichero))){
            leerFichero(sc, delimitadores);
        }
    }

    private void leerFichero(Scanner sc, String delimitadores){
        while(sc.hasNextLine()){                            // Se usa «hasNextLine()» porque se quieren obtener lineas.
            incluyeTodas(sc.nextLine(), delimitadores);     // El metodo «incluyeTodas()» trabaja con una linea.
        }
    }

    public PalabraEnTexto encuentra(String palabra) throws NoSuchElementException {
        boolean encontrada = false;
        int i = 0;

        PalabraEnTexto auxiliar = new PalabraEnTexto(palabra);  // La clase «PalabraEnTexto» no tiene «getPalabra()».

        while (i < numPalabras && !encontrada) {
            if (palabras[i].equals(auxiliar)) {
                encontrada = true;
            }

            i++;
        }

        if (!encontrada) {
            throw new NoSuchElementException("Palabra «" + palabra + "» no encontrada.");
        }

        return palabras[--i];
    }

    @Override
    public String toString(){
        StringBuilder mensaje = new StringBuilder();

        mensaje.append("[");

        for(int i = 0; i < numPalabras; i++){
            if(i+1 < numPalabras){
                mensaje.append(palabras[i] + ", ");

            }else{
                mensaje.append(palabras[i]);
            }
        }

        mensaje.append("]");

        return mensaje.toString();
    }

    public void presentaPalabras(String fichero) throws FileNotFoundException{
        try(PrintWriter pw = new PrintWriter(fichero)){
            presentaPalabras(pw);
        }
    }

    public void presentaPalabras(PrintWriter flujo){
        for(PalabraEnTexto palabra : palabras){
            if(palabra != null) {
                flujo.println(palabra);
            }
        }
    }
}
