package kwic;

public class TituloKWIC implements Comparable<TituloKWIC>{

    private String frase;

    public TituloKWIC(String titulo) {
        frase = titulo;
    }

    @Override
    public boolean equals(Object obj) {
        boolean res = obj instanceof TituloKWIC;
        TituloKWIC titulo = res ? (TituloKWIC)obj : null;

        return res && titulo.frase.equalsIgnoreCase(frase);
    }

    @Override
    public int hashCode() {
        return frase.toLowerCase().hashCode();
    }

    @Override
    public int compareTo(TituloKWIC titulo) {
        return frase.compareToIgnoreCase(titulo.frase);
    }

    @Override
    public String toString(){
        return frase;
    }
}
