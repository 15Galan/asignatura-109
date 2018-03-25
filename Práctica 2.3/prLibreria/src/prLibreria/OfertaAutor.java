package prLibreria;

import java.util.Arrays;

public class OfertaAutor implements OfertaFlex {

    private double porcDescuento;   // Porcentaje
    private String[] autoresOferta;

    public OfertaAutor(double descuento, String[] autores){

        porcDescuento = descuento;
        autoresOferta = autores;
    }

    @Override
    public double getDescuento(Libro libro) {
        double porcentaje = 0;
        int i = 0;

        while(i < autoresOferta.length && !libro.getAutor().equalsIgnoreCase(autoresOferta[i])){
            i++;
        }

        if(i < autoresOferta.length){
            porcentaje = porcDescuento;
        }

        return porcentaje;
    }

    @Override
    public String toString(){
        return porcDescuento+"% "+Arrays.toString(autoresOferta);
    }
}
