package prCuentaPalabrasSimpleFicheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ContadorPalabras {

    private PalabraEnTexto[] palabras;
    private int numPalabras;    // Cantidad de palabras en el array / ultima posicion libre del array.
    protected static final int TAM_INICIAL = 10;

    public ContadorPalabras(){
        this(TAM_INICIAL);
    }

    public ContadorPalabras(int tam){
        palabras = new PalabraEnTexto[tam];
        numPalabras = 0;
    }

    private int esta(String palabra){   // Mejorar con un «while».
        int esta = -1;

        PalabraEnTexto auxiliar = new PalabraEnTexto(palabra);  // Un «String» no puede compararse en el array.

        for(int i = 0; i < numPalabras; i++){   // El array puede tener posiciones vacias.
            if(auxiliar.equals(palabras[i])){
                esta = i;
            }
        }

        return esta;
    }

    protected void incluye(String palabra){
        int posicion = esta(palabra);   // Se establece el valor para no repetirlo continuamente.

        if(posicion != -1){
            palabras[posicion].incrementa();

        }else{
            PalabraEnTexto nueva = new PalabraEnTexto(palabra);     // Al recibir un «String», se crea una PalabraEnTexto.

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
}
