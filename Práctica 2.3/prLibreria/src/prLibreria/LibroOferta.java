package prLibreria;

public class LibroOferta extends Libro{

    private double porcDescuento;   // Variable propia de los libros en oferta (el descuento).

    public LibroOferta(String autor, String titulo, double precio, double descuento){

        super(autor, titulo, precio);   // Ejecuta el constructor de Libro que tiene 3 argumentos.
        porcDescuento = descuento;      // Para ser un LibroOferta requiere un descuento.
    }

    public double getDescuento(){
        return porcDescuento;
    }

    private double getPrecioDescuento(){
        return getPrecioBase() - (getPrecioBase()*porcDescuento) / 100;
    }

    @Override
    public double getPrecioFinal(){
        return getPrecioDescuento() + getPrecioDescuento() * getIVA() / 100;
    }

    @Override
    public String toString() {  // (Autor, Titulo, Precio base, Descuento (%), Precio con decuento, IVA (%), Precio final).
        return "("+getAutor()+"; "+getTitulo()+"; "+getPrecioBase()+"; "+getDescuento()+"%; "+getPrecioDescuento()+"; "+getIVA()+"; "+getPrecioFinal()+")";
    }
}
