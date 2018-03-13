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
        //  else{
        //      throw new RuntimeException("El libro solicitado no esta en la libreria (precio base).");
        //  }

        return precio;
    }

    public double getPrecioFinal(String autor, String titulo){
        int id = buscarLibro(autor, titulo);
        double precio = 0;      // Si se pide el precio de un libro que no esta, debe devolverse 0.0€.

        if(id != -1){
            precio = libros[id].getPrecioFinal();
        }
        //  else{
        //      throw new RuntimeException("El libro solicitado no esta en la libreria (precio final).");
        //  }

        return precio;
    }

    @Override
    public String toString(){
        return Arrays.toString(libros); // Metodo por defecto para mostrar un array (cuyo argumento es el array a mostrar).
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
        int veces = numLibs - id;   // Cantidad de libros desde el que se elimina hasta el ultimo.
                                    // Establece el numero de ciclos del bucle while.
        do{
            libros[id] = libros[++id];  // «++id»: actualiza el valor a «id+1» y luego lo usa.
                                        // «id++»: usa el valor «id» y luego lo actualiza a «id+1».
            veces--;
        }while(veces != 0);

        numLibs--;
    }

    private int buscarLibro(String autor, String titulo){
        int i = 0, encontrado = -1;     // «encontrado» cambiara solo cuando si se encuentra el libro.

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
