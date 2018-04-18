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
            System.out.println(asignatura.getMedia());
            System.out.println(asignatura.getCalificacion(new Alumno("Lopez Perez, Pedro","12455666F", 6.7)));

        }catch (AlumnoException e) {
            System.err.println(e.getMessage());
        }
    }
}
