import prCuentaPalabrasSimpleFicheros.ContadorPalabras;

public class PruebaContadorPalabras {

    public static void main(String[] args) {

        String [] datos = {"Esta es la primera frase del ejemplo",
                "y esta es la segunda frase"};

        ContadorPalabras contador = new ContadorPalabras(5);

        contador.incluyeTodas(datos, "[ ]");

        System.out.println(contador.toString());
    }
}
