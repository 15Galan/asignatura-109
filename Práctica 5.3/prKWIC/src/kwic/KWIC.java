package kwic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class KWIC {

    private SortedMap<String, SortedSet<TituloKWIC>> indice;
    private List<String> palabrasNoSig;     // Se guardan en mayusculas.

    public KWIC(){
        indice = new TreeMap<>();
        palabrasNoSig = new ArrayList<>();
    }

    public void palabrasNoSignificativas(String fichero) throws FileNotFoundException {
        try(Scanner sc = new Scanner(new File(fichero))){
            palabrasNoSignificativas(sc);
        }
    }

    private void palabrasNoSignificativas(Scanner sc){
        while(sc.hasNext()) {
            palabrasNoSig.add(sc.next().toUpperCase());
        }
    }

    public void generaIndice(String fichero) throws FileNotFoundException{
        try(Scanner scT = new Scanner(new File(fichero))){
            generaIndice(scT);
        }
    }

    private void generaIndice(Scanner scT) {
        while(scT.hasNextLine()){
            anyadir(scT.nextLine());
        }
    }

    protected void anyadir(String titulo) {
        TituloKWIC titulokwic = new TituloKWIC(titulo);

        try(Scanner scP = new Scanner(titulo)){
            while(scP.hasNext()){
                anyadir(scP.next().toUpperCase(), titulokwic);
            }
        }
    }

    protected void anyadir(String palabra, TituloKWIC titulo){
        if(!palabrasNoSig.contains(palabra)) {
            if (indice.containsKey(palabra)) {
                indice.get(palabra).add(titulo);

            } else {
                SortedSet<TituloKWIC> set = new TreeSet<>();
                set.add(titulo);
                indice.put(palabra, set);
            }
        }
    }

    public void presentaIndice(String fichero) throws FileNotFoundException {
        try(PrintWriter pw = new PrintWriter(fichero)) {
            presentaIndice(pw);
        }
    }

    public void presentaIndice(PrintWriter pw) {
       for(String palabra : indice.keySet()){
           pw.println(palabra);

           for(TituloKWIC titulo : indice.get(palabra)){
               pw.println("\t" + titulo);
           }
       }
    }
}