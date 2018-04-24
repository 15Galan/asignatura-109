import prNotas.Alumno;
import prNotas.AlumnoException;
import prNotas.Asignatura;

public class PruebaAsignatura {

    static String[] alumnos = {
            "12455666F;Lopez Perez, Pedro;6.7",
            "33678999D;Merlo Gomez, Isabel;5.8",
            "23555875G;Martinez Herrera, Lucia;9.1"};

    public static void main(String[] args){

        Asignatura asignatura = new Asignatura("POO", alumnos);

        try {
            System.out.println(asignatura.toString());
            System.out.println("Media de la asignatura:  " + asignatura.getMedia());

            System.out.println("\nAlumnos...");

            for(Alumno alumno : asignatura.getAlumnos()) {
                System.out.println(alumno);
            }

            System.out.println("\nCalificacion de «" + asignatura.getAlumnos()[0].toString() + "»: " + asignatura.getCalificacion(asignatura.getAlumnos()[0]));
            // Como «asignatura.getAlumnos()» devuelve un array de «Alumno», puede especificarse una posicion concreta del array en la declaracion.

            System.out.println("\nCalificacion de «" + asignatura.getCalificacion(new Alumno("12455666F", "Lopez Lopez, Pedro",6.7)));

        }catch (AlumnoException e) {
            System.err.println(e.getMessage());
        }
    }
}
