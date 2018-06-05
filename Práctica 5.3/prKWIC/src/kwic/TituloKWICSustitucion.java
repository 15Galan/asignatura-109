package kwic;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TituloKWICSustitucion extends TituloKWIC{

    private String titulo_nuevo;

    public TituloKWICSustitucion(String frase, String palabra){
        super(frase);

        sustituye(frase, palabra);
    }

    private String sustituye(String frase, String palabra){
        try(Scanner sc = new Scanner(frase)){
            PrintWriter titulo_sust = new PrintWriter(frase);

            while(sc.hasNext()){
                String actual = sc.next();

                if(actual.equalsIgnoreCase(palabra)){
                    titulo_sust.append(". . . ");

                }else{
                    titulo_sust.append(actual + " ");
                }
            }

            titulo_nuevo = titulo_sust.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return titulo_nuevo;
    }
}
