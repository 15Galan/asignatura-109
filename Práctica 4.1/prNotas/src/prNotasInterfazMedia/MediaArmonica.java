package prNotasInterfazMedia;

import prNotas.Alumno;
import prNotas.AlumnoException;

public class MediaArmonica implements CalculoMedia{

    public MediaArmonica(){

    }

    @Override
    public double calcular(Alumno[] alumnos) throws AlumnoException {
        double sumatoria = 0;
        int k = 0;  // Alumnos cuya nota es superior a 0.

        if(alumnos.length == 0){
            throw new AlumnoException("No hay alumnos almacenados.");
        }

        for(Alumno al : alumnos) {  // Se comprueba la existencia de excepciones en cada iteracion del bucle.
            try {
                double nota = al.getCalificacion();

                if(nota > 0){
                    sumatoria += 1/nota;
                    k++;
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                throw new AlumnoException("Error en la nota del alumno «" + al + "».");
            }
        }

        if(k == 0){     // Excepcion especifica de este apartado (debe comprobarse al acaba el bucle).
            throw new AlumnoException("No hay alumnos con notas mayores a 0.");
        }

        return k/sumatoria;
    }
}
