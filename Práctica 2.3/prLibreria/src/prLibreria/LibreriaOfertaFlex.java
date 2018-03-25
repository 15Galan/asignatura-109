package prLibreria;

public class LibreriaOfertaFlex extends Libreria {

    private OfertaFlex oferta;  // Referencia a la oferta.

    public LibreriaOfertaFlex(OfertaFlex oferta){
        this(CAP_INICIAL, oferta);
    }

    public LibreriaOfertaFlex(int tam, OfertaFlex oferta){
        super(tam); // Llamada al constructor de Libreria

        this.oferta = oferta;
    }

    public void setOferta(OfertaFlex oferta){
        this.oferta = oferta;   // Cambiar la oferta por otra.
    }

    public OfertaFlex getOferta(){
        return oferta;
    }

    public void addLibro(String autor, String titulo, double precio){
        Libro libro = new Libro(autor, titulo, precio);

        if(oferta.getDescuento(libro) != 0){

            libro = new LibroOferta(autor, titulo, precio, oferta.getDescuento(libro));
        }

        anyadirLibro(libro);
    }

    @Override
    public String toString() {

        System.out.println(oferta.toString());

        return super.toString();
    }
}
