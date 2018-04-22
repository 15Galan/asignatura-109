import prNotas.Alumno;
import prNotas.AlumnoException;
import prNotas.Asignatura;

public class PruebaAsignatura {

    static String[] alumnos = {
            "Lopez Perez, Pedro;12455666F;6.7",
            "Merlo Gomez, Isabel;33678999D;5.8",
            "Martinez Herrera, Lucia;23555875G;9.1"};

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

            System.out.println("\nCalificacion de «" + asignatura.getCalificacion(new Alumno("Lopez Lopez, Pedro","12455666F", 6.7)));

        }catch (AlumnoException e) {
            System.err.println(e.getMessage());
        }
    }
}
