package prCuentaPalabrasSimpleColecciones;

public class PalabraEnTexto implements Comparable<PalabraEnTexto>{

    private String palabra;
    private int nVeces;

    public PalabraEnTexto(String palabra){
        this.palabra = palabra.toUpperCase();
        nVeces = 1;
    }

    public void incrementa(){
        nVeces++;
    }

    @Override
    public boolean equals(Object obj){
        boolean res = obj instanceof PalabraEnTexto;                // ¿Este Objeto es una PalabraEnTexto?
        PalabraEnTexto palabra = res ? (PalabraEnTexto)obj : null;  // Si «res es true» crea el objeto auxiliar de PalabraEnTexto para comparar.

        return res && palabra.palabra.equals(this.palabra);     // Dos PalabraEnTexto son iguales si es la misma palabra.
    }

    @Override
    public int hashCode(){
        return palabra.hashCode();
    }

    @Override
    public String toString(){
        return palabra + ": " + nVeces;
    }

    @Override
    public int compareTo(PalabraEnTexto p) {
        return palabra.compareTo(p.palabra);    // El tipo String ya tiene un «compareTo()».
    }
}
