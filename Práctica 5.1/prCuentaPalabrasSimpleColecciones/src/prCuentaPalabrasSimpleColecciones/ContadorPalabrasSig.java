package prCuentaPalabrasSimpleColecciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ContadorPalabrasSig extends ContadorPalabras {

    private Set<String> noSignificativas;

    public ContadorPalabrasSig(Collection<String> noSignificativas) {
        this.noSignificativas = new TreeSet<>();

        for(String palabra : noSignificativas) {
            this.noSignificativas.add(palabra);
        }
    }

    public ContadorPalabrasSig(String fichero, String delimitadores) throws FileNotFoundException {
        noSignificativas = new TreeSet<>();

        try {
            leerFicheroNoSig(fichero, delimitadores);

        } catch (FileNotFoundException e) {
            System.err.println("No se encontró el fichero '" + fichero + "'.");
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
           noSignificativas.add(sc.next());
        }
    }

    @Override
    protected void incluye(String palabra) {
        if(!noSignificativas.contains(palabra.toUpperCase())){
            super.incluye(palabra);
        }
    }
}