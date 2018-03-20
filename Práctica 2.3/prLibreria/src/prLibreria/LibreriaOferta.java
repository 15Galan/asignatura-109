package prLibreria;

public class LibreriaOferta extends Libreria {

    private double porcDescuento;       // Descuento propio de esta clase.
    private String[] autoresOferta;     // Array propio de esta clase.

    public LibreriaOferta(double descuento, String[] autores){
        this(CAP_INICIAL, descuento, autores);
    }

    public LibreriaOferta(int tam, double descuento, String[] autores){
        super(tam);

        porcDescuento = descuento;
        autoresOferta = autores;
    }

    public String[] getOferta(){
        return autoresOferta;
    }

    public double getDescuento(){
        return porcDescuento;
    }

    @Override
    public void addLibro(String autor, String titulo, double precio){
        if(oferta(autor)){
            anyadirLibro(new LibroOferta(autor, titulo, precio, porcDescuento));

        }else{
            anyadirLibro(new Libro(autor, titulo, precio));
        }
    }

    private boolean oferta(String autor){
        int i = 0;

        while(i < autoresOferta.length && !autor.equalsIgnoreCase(autoresOferta[i])){
            i++;
        }

        return i < autoresOferta.length;    // Sera «true» si esta de oferta (porque el bucle se detendra sin llegar al final).
    }

    @Override
    public String toString(){

        System.out.println(porcDescuento+"%"+autoresOferta);    // Igual que una Libreria, pero primero muestra las ofertas.

        return super.toString();
    }
}
