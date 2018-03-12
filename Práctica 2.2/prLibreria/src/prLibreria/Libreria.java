package prLibreria;

import java.util.*;

public class Libreria {

    private static final int CAP_INICIAL = 16;
    private Libro[] libros;
    private int numLibs;

    public Libreria(){
        this(CAP_INICIAL);  // «this» llama al mismo constructor pero que tiene un argumento (prLibreria.Libreria(int)).
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
        int id = buscarLibro(autor, titulo);

        if(id != -1){
            eliminarLibro(id);
        }
    }

    public double getPrecioBase(String autor, String titulo){
        int id = buscarLibro(autor, titulo);
        double precio;

        if(id != 1){
            precio = libros[id].getPrecioBase();

        }else{
            throw new RuntimeException("El libro solicitado no esta en la libreria (precio base).");
        }

        return precio;
    }

    public double getPrecioFinal(String autor, String titulo){
        int id = buscarLibro(autor, titulo);
        double precio;

        if(id != 1){
            precio = libros[id].getPrecioFinal();

        }else{
            throw new RuntimeException("El libro solicitado no esta en la libreria (precio final).");
        }

        return precio;
    }

    @Override
    public String toString(){
        return Arrays.toString(libros);
    }

    private void anyadirLibro(Libro libro){
        int id = buscarLibro(libro.getAutor(), libro.getTitulo());  // Posicion del ultimo libro.

        if(numLibs == libros.length){   // El array esta lleno.
            //   prLibreria.Libro[] librosExtra = Arrays.copyOf(libros, libros.length * 2);
            libros = Arrays.copyOf(libros, libros.length * 2);
        }

        if(id == -1){                   // El libro no esta en el array.
            libros[numLibs] = libro;
            numLibs++;

        }else{                          // El libro esta en el array.
            libros[id] = libro;
        }
    }

    private void eliminarLibro(int id){
        int resto = numLibs - id;

        //libros[id] = null;

        do{
            libros[id] = libros[id++];
        }while(id <= resto);
    }

    private int buscarLibro(String autor, String titulo){
        int i = 0, encontrado = -1;

        while(i < numLibs && encontrado == -1){
            if(autor.equalsIgnoreCase(libros[i].getAutor()) && titulo.equalsIgnoreCase(libros[i].getTitulo())){
                encontrado = i;
            }else{
                i++;
            }
        }

        return encontrado;
    }
}
