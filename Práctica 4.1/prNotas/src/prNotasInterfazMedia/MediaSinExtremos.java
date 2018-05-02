package prNotasInterfazMedia;

import prNotas.Alumno;
import prNotas.AlumnoException;

import java.util.Arrays;

public class MediaSinExtremos implements CalculoMedia{

    private double min;
    private double max;

    public MediaSinExtremos(double minimo, double maximo){

        min = minimo;
        max = maximo;
    }

    @Override
    public double calcular(Alumno[] alumnos) throws AlumnoException {
        Alumno[] auxiliar = new Alumno[alumnos.length];     // Array auxiliar con alumnos de notas entre «min» y «max».
        int j = 0;  // Contador del array «auxiliar» que indicara la siguiente posicion libre.

        for(Alumno al : alumnos){
            try {
                double nota = al.getCalificacion();     // Asi solo se calcula la nota una vez por cada alumno (iteracion).

                if (min <= nota && nota <= max) {
                    auxiliar[j] = al;
                    j++;
                }

            }catch(ArrayIndexOutOfBoundsException e){
                throw new AlumnoException("Error en la nota del alumno «" + al + "».");
            }
        }

        auxiliar = Arrays.copyOf(auxiliar, j);    // Se eliminan las posiciones nulas del array.

        return new MediaAritmetica().calcular(auxiliar);    // Se crea un objeto «MediaAritmetica» y se invoca a su «calcular()».
    }
}
