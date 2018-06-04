package prIndicePalabras;

import java.io.PrintWriter;
import java.util.*;

public class IndicePosicionesEnLineas extends IndiceAbstracto {

    private Map<String, Map<Integer, Set<Integer>>> indice;

    public IndicePosicionesEnLineas(){
        indice = new TreeMap<>();
    }

    @Override
    public void resolver(String delimitadores) {
        int l = 1;

        for(String linea : frases){
            try(Scanner sc = new Scanner(linea)){
                sc.useDelimiter(delimitadores);

                int c = 1;

                while(sc.hasNext()){
                    String palabra = sc.next().toLowerCase();
                    Map<Integer, Set<Integer>> mapa = indice.get(palabra);

                    if(mapa == null){
                        mapa = new TreeMap<>();
                        indice.put(palabra, mapa);
                    }

                    Set<Integer> conjunto = mapa.get(l);

                    if(conjunto == null){
                        conjunto = new TreeSet<>();
                        mapa.put(l, conjunto);
                    }

                    conjunto.add(c);
                    c++;
                }

                l++;
            }
        }
    }

    @Override
    public void presentarIndice(PrintWriter pw) {
        for(String palabra : indice.keySet()){
            pw.println(palabra);

            for(int i : indice.get(palabra).keySet()){
                pw.println("\t" + i + " " + indice.get(palabra).keySet());
            }
        }
    }
}
