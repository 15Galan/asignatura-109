import prCuentaPalabrasSimpleFicheros.PalabraEnTexto;

public class PruebaPalabraEnTexto {

    public static void main(String[] args) {

        PalabraEnTexto palabra1 = new PalabraEnTexto("gorra");
        PalabraEnTexto palabra2 = new PalabraEnTexto("Gorra");

        System.out.println("Palabra 1:  " + palabra1);
        System.out.println("Palabra 2:  " + palabra2);

        System.out.println("¿Las palabras son iguales?  " + palabra1.equals(palabra2));
    }
}
