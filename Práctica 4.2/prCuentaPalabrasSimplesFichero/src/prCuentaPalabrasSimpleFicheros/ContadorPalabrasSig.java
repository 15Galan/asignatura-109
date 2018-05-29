package prCuentaPalabrasSimpleFicheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ContadorPalabrasSig extends ContadorPalabras{

    private String[] noSignificativas;
    static final private int TAM = 10;
    private int numPalNoSig;

    public ContadorPalabrasSig(String[] noSignificativas){
        this(TAM, noSignificativas);
    }

    public ContadorPalabrasSig(int tam, String[] noSignificativas){
        this.noSignificativas = new String[tam];

        for(int i = 0; i < noSignificativas.length; i++){
            this.noSignificativas[i] = noSignificativas[i].toUpperCase();
        }

        numPalNoSig = noSignificativas.length;
    }

    public ContadorPalabrasSig(String ficheroNoSignificativas, String delimitadores) throws FileNotFoundException {
        this(TAM, ficheroNoSignificativas, delimitadores);
    }

    public ContadorPalabrasSig(int tam, String ficheroNoSignificativas, String delimitadores) throws FileNotFoundException {
        noSignificativas = new String[tam];
        numPalNoSig = 0;
        leerFicheroNoSig(ficheroNoSignificativas, delimitadores);

        while(numPalNoSig < noSignificativas.length && noSignificativas[numPalNoSig] == null){
            numPalNoSig++;
        }
    }

    private void leerFicheroNoSig(String fichero, String delimitadores) throws FileNotFoundException {
        try(Scanner sc = new Scanner(new File(fichero))){
            while(sc.hasNext()) {
                leerPalabrasNoSignificativas(sc, delimitadores);
            }

        }catch(FileNotFoundException e){
            throw new FileNotFoundException("ERROR: «" + fichero + "» no encontrado.");
        }
    }

    private void leerPalabrasNoSignificativas(Scanner sc, String delimitadores){
        while(sc.hasNext()){
            String palabra = sc.next().toUpperCase();

            if(numPalNoSig == noSignificativas.length){
                noSignificativas = Arrays.copyOf(noSignificativas, noSignificativas.length*2);
            }

            noSignificativas[numPalNoSig] = palabra;
            numPalNoSig++;
        }

        noSignificativas = Arrays.copyOf(noSignificativas, numPalNoSig);
    }

    @Override
    protected void incluye(String palabra) {
        boolean significativa = true;
        int i = 0;

        while(significativa && i < numPalNoSig){
            if(noSignificativas[i].equals(palabra.toUpperCase())){  // «equals» por ser «Strings».
                significativa = false;
            }

            i++;
        }

        if(significativa){
            super.incluye(palabra);
        }
    }
}
