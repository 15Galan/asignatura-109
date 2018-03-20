package prLibreria;

public class Libro {

    private static double porcIVA = 10.0;
    private String autor;
    private String titulo;
    private double precioBase;

    public Libro(String autor, String titulo, double precio){
        this.autor = autor;
        this.titulo = titulo;
        precioBase = precio;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo(){
        return titulo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public double getPrecioFinal(){
        return precioBase + (precioBase * porcIVA) / 100;
    }

    @Override
    public String toString(){
        return "("+autor+"; "+titulo+"; "+precioBase+"; "+porcIVA+"%; "+getPrecioFinal()+")";
    }

    public static double getIVA(){
       return porcIVA;
    }

    public static double setIVA(double iva){
        porcIVA = iva;

        return porcIVA;
    }
}
