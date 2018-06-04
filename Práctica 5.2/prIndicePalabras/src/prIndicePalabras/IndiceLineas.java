package prIndicePalabras;

import java.io.PrintWriter;
import java.util.*;

public class IndiceLineas extends IndiceAbstracto {

    private Map<String, Set<Integer>> indice;

    public IndiceLineas(){
        indice = new TreeMap<>();
    }

    @Override
    public void resolver(String delimitadores) {
        int l = 1;

        for(String linea : frases){
            try(Scanner sc = new Scanner(linea)){
                sc.useDelimiter(delimitadores);

                while(sc.hasNext()){
                    String palabra = sc.next().toLowerCase();
                    Set<Integer> conjunto = indice.get(palabra);

                    if(conjunto == null){
                        conjunto = new TreeSet<>();
                        indice.put(palabra, conjunto);
                    }

                    conjunto.add(l);
                }
            }

            l++;
        }


    }

    @Override
    public void presentarIndice(PrintWriter pw) {
        for(String palabra : indice.keySet()){
            pw.println(palabra + "   " + indice.get(palabra));
        }
    }
}
