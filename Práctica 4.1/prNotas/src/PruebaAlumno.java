import prNotas.Alumno;
import prNotas.AlumnoException;

public class PruebaAlumno {

    public static void main(String[] args) {

        try {
            Alumno a1 = new Alumno("Gonzalez Perez, Juan", "22456784F", 5.5);
            Alumno a2 = new Alumno("Gonzalez Perez, Juan", "33456777S", 3.4);

            System.out.println(a1);
            System.out.println(a2);

            a2 = new Alumno("Gonzalez Perez, Juan", "33456777S", -3.4);

            System.out.println(a2);

        }catch(AlumnoException e){
            System.err.println(e.getMessage());
        }
    }
}
