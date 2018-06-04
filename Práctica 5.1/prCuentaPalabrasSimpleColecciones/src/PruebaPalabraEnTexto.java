import prCuentaPalabrasSimpleColecciones.PalabraEnTexto;

public class PruebaPalabraEnTexto {

    public static void main(String[] args) {

        PalabraEnTexto palabra1 = new PalabraEnTexto("gorra");
        PalabraEnTexto palabra2 = new PalabraEnTexto("Sombrero");

        palabra1.incrementa();
        palabra1.incrementa();
        palabra1.incrementa();
        System.out.println("Palabra 1:  " + palabra1);

        palabra2.incrementa();
        palabra2.incrementa();
        System.out.println("Palabra 2:  " + palabra2);

        if(palabra1.compareTo(palabra2) > 0) {
            System.out.println(palabra1 + " > " + palabra2);

        }else{
            System.out.println(palabra1 + " < " + palabra2);
        }

        System.out.println();

        PalabraEnTexto palabra3 = new PalabraEnTexto("perro");
        PalabraEnTexto palabra4 = new PalabraEnTexto("PERRO");

        palabra3.incrementa();
        palabra3.incrementa();
        palabra3.incrementa();
        System.out.println("Palabra 3:  " + palabra3);

        palabra4.incrementa();
        palabra4.incrementa();
        System.out.println("Palabra 4:  " + palabra4);

        if(palabra3.compareTo(palabra4) > 0) {
            System.out.println(palabra3 + " > " + palabra4);

        }else{
            System.out.println(palabra3 + " < " + palabra4);
        }
    }
}
