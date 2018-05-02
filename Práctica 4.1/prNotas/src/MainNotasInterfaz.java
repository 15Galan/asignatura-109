import prNotas.AlumnoException;
import prNotasInterfazMedia.*;
import prNotas.Alumno;

import java.io.FileNotFoundException;

public class MainNotasInterfaz {

    static String[] als = { "25653443S;Garcia Gomez, Juan;8.1",
                            "23322443K;Lopez Turo, Manuel;4.3",
                            "24433522M;Merlo Martinez, Juana;5.3",
                            "53553421D;Santana Medina, Petra;-7.1",
                            "55343442L,Godoy Molina, Marina;6.3",
                            "342424f2J;Fernandez Vara, Pedro;2.k",
                            "42424312G;Lopez Gama, Luisa;7.1" };

    public static void main(String[] args) throws FileNotFoundException {
        Asignatura algebra = new Asignatura("Algebra", als);
        try {
            Alumno al1 = new Alumno("23322443k", "Lopez Turo, Manuel");
            Alumno al2 = new Alumno("342424f2J", "Fernandez Vara, Pedro");
            System.out.println("Calificacion de " + al1 + ": " + algebra.getCalificacion(al1));
            System.out.println("Calificacion de " + al2 + ": " + algebra.getCalificacion(al2));

        } catch (AlumnoException e) {
            System.err.println(e.getMessage());
        }

        try {
            CalculoMedia m1 = new MediaAritmetica();
            CalculoMedia m2 = new MediaArmonica();

            double min = 5.0;
            double max = 9.0;

            CalculoMedia m3 = new MediaSinExtremos(min,max);

            System.out.println("Media aritmetica " + algebra.getMedia(m1));
            System.out.println("Media armonica " + algebra.getMedia(m2));
            System.out.println("Media de valores en ["+min+","+max+"] " + algebra.getMedia(m3));

        } catch (AlumnoException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Alumnos...");

        for (Alumno alumno : algebra.getAlumnos()) {
            System.out.println(alumno + ": " + alumno.getCalificacion());
        }

        System.out.println("Errores...");

        for (String malo : algebra.getErrores()) {
            System.out.println(malo);
        }

        System.out.println(algebra);
    }
}