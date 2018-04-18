package prDatos;

public class DatosException extends RuntimeException{

    public DatosException(){
        super();
    }

    public DatosException(String mensaje){
        super(mensaje);
    }
}
