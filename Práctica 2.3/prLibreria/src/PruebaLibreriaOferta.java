import prLibreria.*;

public class PruebaLibreriaOferta {

    public static void main(String[] args) {

        String[] autores = {"George Orwell", "Isaac Asimov"};
        LibreriaOferta libreria = new LibreriaOferta(20, autores);

        libreria.addLibro("george orwell", "1984", 8.20);
        libreria.addLibro("Philip K. Dick", "¿Sueñan los androides con ovejas eléctricas?", 3.50);
        libreria.addLibro("Isaac Asimov", "Fundación e Imperio", 9.40);
        libreria.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
        libreria.addLibro("Aldous Huxley", "Un Mundo Feliz", 6.50);
        libreria.addLibro("Isaac Asimov", "La Fundación", 7.30);
        libreria.addLibro("William Gibson", "Neuromante", 8.30);
        libreria.addLibro("Isaac Asimov", "Segunda Fundación", 8.10);
        libreria.addLibro("Isaac Newton", "arithmetica universalis", 7.50);
        libreria.addLibro("George Orwell", "1984", 6.20);
        libreria.addLibro("Isaac Newton", "Arithmetica Universalis", 10.50);

        System.out.println(libreria);
        System.out.println();

        libreria.remLibro("George Orwell", "1984");
        libreria.remLibro("Aldous Huxley", "Un Mundo Feliz");
        libreria.remLibro("Isaac Newton", "Arithmetica Universalis");
        libreria.remLibro("James Gosling", "The Java Language Specification");

        System.out.println(libreria);
        System.out.println();

        System.out.println("getPrecioFinal(George Orwell, 1984):    " + libreria.getPrecioFinal("George Orwell", "1984"));
        System.out.println("getPrecioFinal(Philip K. Dick, ¿Sueñan los androides con ovejas eléctricas?):   " + libreria.getPrecioFinal("Philip K. Dick", "¿Sueñan los androides con ovejas eléctricas?"));
        System.out.println("getPrecioFinal(isaac asimov, fundación e imperio):  " + libreria.getPrecioFinal("isaac asimov", "fundación e imperio"));
        System.out.println("getPrecioFinal(Ray Bradbury, Fahrenheit 451):   " + libreria.getPrecioFinal("Ray Bradbury", "Fahrenheit 451"));
        System.out.println("getPrecioFinal(Alex Huxley, Un Mundo Feliz):    " + libreria.getPrecioFinal("Alex Huxley", "Un Mundo Feliz"));
        System.out.println("getPrecioFinal(Isaac Asimov, La Fundación): " + libreria.getPrecioFinal("Isaac Asimov", "La Fundación"));
        System.out.println("getPrecioFinal(william gibson, neuromante): " + libreria.getPrecioFinal("william gibson", "neuromante"));
        System.out.println("getPrecioFinal(Isaac Asimov, Segunda Fundación):    " + libreria.getPrecioFinal("Isaac Asimov", "Segunda Fundación"));
        System.out.println("getPrecioFinal(Isaac Newton, Arithmetica Universalis):  " + libreria.getPrecioFinal("Isaac Newton", "Arithmetica Universalis"));
    }
}