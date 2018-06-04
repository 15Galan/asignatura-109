package prIndicePalabras;

import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class IndiceContador extends IndiceAbstracto {

    private Map<String, Integer> indice;

    public IndiceContador(){
        indice = new TreeMap<>();
    }

    @Override
    public void resolver(String delimitadores) {
        for(String linea : frases){
            try(Scanner sc = new Scanner(linea)){
                sc.useDelimiter(delimitadores);

                while(sc.hasNext()){
                    String palabra = sc.next().toLowerCase();
                    int i = indice.getOrDefault(palabra, 0);

                    indice.put(palabra, i+1);
                }
            }
        }
    }

    @Override
    public void presentarIndice(PrintWriter pw) {
        for(String palabra : indice.keySet()){
            pw.println(palabra + "   " + indice.get(palabra));
        }
    }
}
