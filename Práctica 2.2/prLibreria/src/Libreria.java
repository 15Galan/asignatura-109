public class Libreria {

    private static final int CAP_INICIAL = 16;
    private Libro[] libros;
    private int numLibs;

    public Libreria(){
        this(CAP_INICIAL);  //
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
        buscarLibro(autor, titulo);

    }

    private static void anyadirLibro(Libro libro){

    }

    private void eliminarLibro(int id){
        int i = id, resto = numLibs - id;

        do{

        }while(i < resto);
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
