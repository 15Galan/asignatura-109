import kwic.KWIC;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PruebaKWIC {
    public static void main(String[] args) {
        KWIC kwic = new KWIC();

        try {
            kwic.palabrasNoSignificativas("noClaves.txt");
            kwic.generaIndice("frases.txt");
            kwic.presentaIndice("salida.txt");

        }catch(FileNotFoundException e){
            System.err.println("No se encontró el archivo «noClaves.txt».");
        }

        kwic.presentaIndice(new PrintWriter(System.out, true));
    }
}
