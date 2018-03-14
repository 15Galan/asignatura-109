package prLibreria;

import java.util.*;

public class Libreria {

    private static final int CAP_INICIAL = 16;
    private Libro[] libros;
    private int numLibs;

    public Libreria(){
        this(CAP_INICIAL);  // «this» llama al mismo constructor pero que tiene un argumento (public Libreria (int)).
    }

    public Libreria(int tam){
        libros = new Libro[tam];
        numLibs = 0;
    }

    public void addLibro(String autor, String titulo, double precio){
        Libro libro = new Libro(autor, titulo, precio);
        anyadirLibro(libro);
    }

    public void remLibro(String autor, String titulo){
        int id = buscarLibro(autor, titulo);    // Se crea fuera para no llamar al metodo 2 veces donde «id».

        if(id != -1){
            eliminarLibro(id);
        }
    }

    public double getPrecioBase(String autor, String titulo){
        int id = buscarLibro(autor, titulo);    // Se crea fuera para no llamar al metodo 2 veces donde «id».
        double precio = 0;                      // Si se pide el precio de un libro que no esta, debe devolverse 0.0€.

        if(id != -1){
            precio = libros[id].getPrecioBase();
        }

        return precio;
    }

    public double getPrecioFinal(String autor, String titulo){
        int id = buscarLibro(autor, titulo);
        double precio = 0;      // Si se pide el precio de un libro que no esta, debe devolverse 0.0€.

        if(id != -1){
            precio = libros[id].getPrecioFinal();
        }

        return precio;
    }

    @Override
    public String toString(){
        String lista = "";  // Se crea un String al que se le iran cocatenando los libros.

        for(int i = 0; i < numLibs; i++){   // Recorre el array y va añadiendo los libros al String anterior.
            lista += libros[i];

            if(i != numLibs-1){
                lista += ", " + '\n';   // Los separa por comas y un salto de linea, salvo el ultimo (evita una coma suelta).
            }
        }

        return "[" + lista + "]";
    }

    private void anyadirLibro(Libro libro){
        int id = buscarLibro(libro.getAutor(), libro.getTitulo());  // Posicion del ultimo libro.

        if(numLibs == libros.length){   // El array esta lleno.

            libros = Arrays.copyOf(libros, libros.length * 2);
        }

        if(id == -1){                   // El libro no esta en el array.
            libros[numLibs] = libro;    // El array empieza en 0, por lo que «numLibs» indica la ultima posicion libre.
            numLibs++;

        }else{                          // El libro esta en el array.
            libros[id] = libro;
        }
    }

    private void eliminarLibro(int id){

        libros[id] = libros[numLibs-1]; // Para eliminar un libro se sustituye por el ultimo.
        libros[numLibs-1] = null;       // Luego, se libera la ultima posicion ocupada del array.

        numLibs--;
    }

    private int buscarLibro(String autor, String titulo){
        int i = 0, encontrado = -1;     // «encontrado» cambiara solo cuando se encuentre el libro.

        while(i < numLibs && encontrado == -1){     // Debe detenerse si encuentra el libro o ya no hay mas que evaluar.
            if(autor.equalsIgnoreCase(libros[i].getAutor()) && titulo.equalsIgnoreCase(libros[i].getTitulo())){
                encontrado = i;
            }else{
                i++;
            }
        }

        return encontrado;
    }
}
