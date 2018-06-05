import kwic.TituloKWIC;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class PruebaTituloKWIC {

    public static void main (String [] args) throws FileNotFoundException {

        TituloKWIC[] titulos = new TituloKWIC[100];
        int numTitulos = 0;

        try(Scanner sc = new Scanner(new File("frases.txt"))){
            while(sc.hasNextLine()){
                titulos[numTitulos] = new TituloKWIC(sc.nextLine());
                numTitulos++;
            }

            titulos = Arrays.copyOf(titulos, numTitulos);
        }

        TituloKWIC menor = titulos[0], mayor = titulos[0];

        for(TituloKWIC actual : titulos){
            if(actual.compareTo(menor) < 0) {
                menor = actual;
            }

            if(actual.compareTo(mayor) > 0){
                mayor = actual;
            }
        }

        System.out.println("Menor:  " + menor);
        System.out.println("Mayor:  " + mayor);
    }
}
