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

    @Override
    public double getPrecioFinal(){
        double precio = getPrecioBase() - (getPrecioBase()*porcDescuento) / 100;    // Un descuento se aplica antes que el IVA.

        return precio + precio * getIVA() / 100;    // No puede usarse «super.getPrecioFinal()» porque el precio sería incorrecto.
    }

    @Override
    public String toString() {  // (Autor, Titulo, Precio base, IVA (%), Precio con IVA, Descuento (%), Precio final).
        return "("+getAutor()+"; "+getTitulo()+"; "+getPrecioBase()+"; "+getIVA()+"%; "+super.getPrecioFinal()+"; "+getDescuento()+"; "+getPrecioFinal()+")";
    }
}
