package prNotasInterfazMedia;

import prNotas.Alumno;
import prNotas.AlumnoException;

public interface CalculoMedia {

    double calcular(Alumno[] alumnos) throws AlumnoException;
}
