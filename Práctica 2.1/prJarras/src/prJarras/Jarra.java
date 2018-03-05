package prJarras;

public class Jarra {
    private final int capacidad;                                                                                        // Variable constante.
    private int contenido;

    public Jarra(){
        capacidad = 0;
        contenido = 0;
    }

    public Jarra(int capacidad){
        this.capacidad = capacidad;
        contenido = 0;
    }

    public int capacidad(){
        return capacidad;
    }

    public int contenido(){
        return contenido;
    }

    public void llenar(){
        contenido = capacidad;
    }

    public void vaciar(){
        contenido = 0;
    }

    public void llenarDesde(Jarra jarra){
        int libre = capacidad - contenido;                                                                              // Mantener el valor constante para no alterar el computo.

        if(libre >= jarra.contenido){
            contenido += jarra.contenido;
            jarra.contenido = 0;

        }else{
            contenido = capacidad;
            jarra.contenido -= libre;
        }
    }

    @Override                                                                                                           // Sobreescribir el método «toString» especificamente para esta clase.
    public String toString() {                                                                                              // Se traduce como «forma de mostrar por pantalla este objeto» (en este caso, una «Jarra»).
        return "Jarra(" + contenido + "/" + capacidad + ")";
    }
}
