package prNotas;

import java.util.*;

public class Asignatura {

    private String nombre;
    private String[] errores;
    private Alumno[] alumnos;

    public Asignatura(String nombre, String[] datos){

        this.nombre = nombre;
        errores = new String[datos.length];
        alumnos = new Alumno[datos.length];

        int id = 0;     // Indice del array «alumnos».
        int ie = 0;     // Indice del array «errores».

        for(String dato : datos) {
            try (Scanner sc = new Scanner(dato)){   // Scanner dentro del «try» para cerrarlo automaticamente al acabar.

                sc.useDelimiter("[;]");         // Separador manual (especial).
                sc.useLocale(Locale.ENGLISH);   // Tener en cuenta los separadores ingleses predefinidos.

                Alumno al = new Alumno(sc.next(), sc.next(), sc.nextDouble());

                alumnos[id] = al;
                id++;

            }catch(InputMismatchException e) {   // El tercer dato (nota) de la linea no es numerico.
                errores[ie] = "Calificacion no numerica:   «" + dato + "»";
                ie++;

            }catch(NoSuchElementException e){  // La linea que lee el escaner no tiene los 3 elementos necesarios.
                errores[ie] = "Datos insuficientes:   «" + dato + "»";
                ie++;

            }catch (AlumnoException e){     // La nota es negativa, por lo que la clase Alumno produciria una excepcion.
                errores[ie] = "Calificacion negativa:   «" + dato + "»";
                ie++;
            }
        }

        alumnos = Arrays.copyOf(alumnos, id);   // Se eliminan las posiciones nulas del array «alumnos».
        errores = Arrays.copyOf(errores, ie);   // Se eliminan las posiciones nulas del array «errores».
    }

    public double getCalificacion(Alumno al) throws AlumnoException{
        int i = 0;

        while(!al.equals(alumnos[i]) && i < alumnos.length - 1){    // Buscar el alumno en el array «alumnos».
            i++;
        }

        if(i == alumnos.length - 1){    // Si no esta el alumno se produce una excepcion.
            throw new AlumnoException("El alumno «" + al + "» no se encuentra.");
        }

        return alumnos[i].getCalificacion();    // Se devuelve la nota del alumno almacenado, es decir, del array.
    }

    public Alumno[] getAlumnos(){
        return alumnos;
    }

    public String[] getErrores(){
        return errores;
    }

    public double getMedia() throws AlumnoException {
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

    @Override
    public String toString(){
        StringBuilder mensaje = new StringBuilder(nombre);
        mensaje.append("{");
     // mensaje.append('\n' + "Alumnos -> ");
        mensaje.append(Arrays.toString(alumnos));
     // mensaje.append('\n' + "Errores -> ");
        mensaje.append(Arrays.toString(errores));
        mensaje.append("}");

        return mensaje.toString();
    }
}
