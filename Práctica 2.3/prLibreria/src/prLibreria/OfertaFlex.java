package prLibreria;

public interface OfertaFlex {

    /**
     * Calcula y devuelve el porcentaje de descuento que se debe aplicar a un determinado libro
     * recibido como parametro. En caso de que no se deba aplicar ningun descuento, devolvera el
     * valor cero.
     *
     * @param libro
     * @return descuento
     */

    double getDescuento(Libro libro);
}
