package prNotas;

public class Alumno {

    private String nombre;
    private String dni;
    private double nota;

    public Alumno(String nombre, String DNI, double nota) throws AlumnoException {

        this.nombre = nombre;
        dni = DNI;

        if(nota < 0){
            throw new AlumnoException("Nota negativa.");
        }

        this.nota = nota;
    }

    public Alumno(String nombre, String DNI){

        this.nombre = nombre;
        dni = DNI;
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

        return "DNI: " + dni + "    Nombre: " + nombre + "  Nota: " + nota + ".";
    }

    @Override
    public boolean equals(Object obj){
        boolean res = obj instanceof Alumno;    // ¿Este Objeto es un Alumno?
        Alumno al = res ? (Alumno)obj : null;   // Si «res es true» crea el objeto ausiliar de Alumno para comparar.

        return res && al.nombre.equalsIgnoreCase(nombre) && al.dni.equalsIgnoreCase(dni);   // ¿Cuando son iguales?
    }

    @Override
    public int hashCode(){
        return nombre.hashCode() + dni.toLowerCase().hashCode();    // El DNI debe operarse en minuscula.
    }
}
