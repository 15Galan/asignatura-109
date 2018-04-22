package prNotas;

public class Alumno {

    private String nombre;
    private String dni;
    private double nota;

    public Alumno(String DNI, String nombre, double nota) throws AlumnoException {

        dni = DNI;
        this.nombre = nombre;

        if(nota < 0){
            throw new AlumnoException("Nota negativa.");
        }

        this.nota = nota;
    }

    public Alumno(String DNI, String nombre){

        dni = DNI;
        this.nombre = nombre;
        nota = 0;
    }

    public String getNombre(){
        return nombre;
    }

    public String getDni(){
        return dni;
    }

    public double getCalificacion(){
        return nota;
    }

    @Override
    public String toString(){

        return nombre + "   " + dni;    // Un alumno esta definido por su nombre y su DNI, no se muestra su nota.
    }

    @Override
    public boolean equals(Object obj){
        boolean res = obj instanceof Alumno;    // ¿Este Objeto es un Alumno?
        Alumno al = res ? (Alumno)obj : null;   // Si «res es true» crea el objeto auxiliar de Alumno para comparar.

        return res && al.nombre.equalsIgnoreCase(nombre) && al.dni.equalsIgnoreCase(dni);   // Definicion de igualdad.
    }

    @Override
    public int hashCode(){
        return nombre.hashCode() + dni.toLowerCase().hashCode();    // El DNI debe operarse en minuscula.
    }
}
