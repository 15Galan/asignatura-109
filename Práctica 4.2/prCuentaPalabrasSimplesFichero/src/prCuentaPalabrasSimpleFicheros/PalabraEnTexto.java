package prCuentaPalabrasSimpleFicheros;

public class PalabraEnTexto {

    private String palabra;
    private int veces = 0;

    public PalabraEnTexto(String palabra){

        this.palabra = palabra.toUpperCase();
        veces++;
    }

    public void incrementa(){
        veces++;
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
        return palabra + ": " + veces;
    }
}
