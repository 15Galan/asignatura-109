package prNotasInterfazMedia;

import prNotas.Alumno;
import prNotas.AlumnoException;

public class MediaAritmetica implements CalculoMedia{

    public MediaAritmetica() {

    }

    @Override
    public double calcular(Alumno[] alumnos) throws AlumnoException {
        double sumatoria = 0;
        int N = 0;

        if(alumnos.length == 0){
            throw new AlumnoException("No hay alumnos almacenados.");
        }

        for(Alumno al : alumnos) {  // Se comprueba la existencia de excepciones en cada iteracion del bucle.
            try {
                sumatoria += al.getCalificacion();
                N++;

            } catch (ArrayIndexOutOfBoundsException e) {
                throw new AlumnoException("Error en la nota del alumno «" + al + "».");
            }
        }

        return sumatoria/N;
    }
}
