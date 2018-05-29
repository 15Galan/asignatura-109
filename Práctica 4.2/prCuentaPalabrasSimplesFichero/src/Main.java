import java.io.*;
import java.util.NoSuchElementException;
import prCuentaPalabrasSimpleFicheros.*;

public class Main {

	public static void main(String [] args) throws FileNotFoundException {

		String [] datos = { "Guerra tenía una jarra y Parra tenía una perra, ",
			                "pero la perra de Parra rompió la jarra de Guerra.",
                            "Guerra pegó con la porra a la perra de Parra. ",
                            "¿Oiga usted buen hombre de Parra! ",
                            "Por qué ha pegado con la porra a la perra de Parra.",
                            "Porque si la perra de Parra no hubiera roto la jarra de Guerra,",
                            "Guerra no hubiera pegado con la porra a la perra de Parra."};
		
		String delimitadores = "[ .,:;\\-\\!\\¿\\¡\\?]+";   // " .,:;-!¡¿?" una o varias apariciones
		 
		String [] noSig = {"CON", "LA", "A", "DE", "NO", "SI", "Y", "UNA"};

		ContadorPalabras contador = null, contadorSig = null;   // Si no se incluye un argumento numerico, se crea por defecto.

        try {
			int n = Integer.parseInt(args[0]);

			System.out.println("Con argumento " + n);

			contador = new ContadorPalabras(n);
			contadorSig = new ContadorPalabrasSig(n, noSig);

		} catch (RuntimeException e) {
			System.out.println("Por defecto...");

			contador = new ContadorPalabras();
			contadorSig = new ContadorPalabrasSig(noSig);
		}



        // Incluimos todas las palabras que hay en
        // «datos» teniendo en cuenta los delimitadores.

		contador.incluyeTodas(datos, delimitadores);
		contadorSig.incluyeTodas(datos, delimitadores);
		
		System.out.println(contador);
		System.out.println(contadorSig);
		
		try {
			System.out.println(contador.encuentra("parra"));
			System.out.println(contador.encuentra("Gorra"));

		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
		}



		//Repetimos la salida con E/S desde ficheros.
		
		System.out.println("\nRepetimos la ejecución tomando la E/S desde fichero.");
		
		ContadorPalabras contadorSigFich = null;  // Si no se incluye un argumento numerico, se crea por defecto.

		try {
			int n = Integer.parseInt(args[0]);

			System.out.println("Con argumento " + n);

			contador = new ContadorPalabras(n);
			contadorSigFich= new ContadorPalabrasSig(n, "fichNoSig.txt", delimitadores);

		} catch (RuntimeException e) {
			System.out.println("Por defecto...");

			contador = new ContadorPalabras();
            contadorSigFich= new ContadorPalabrasSig("fichNoSig.txt", delimitadores);

        } catch (IOException e) {
			System.err.println("ERROR:	" + e.getMessage());
		}


		// Incluimos todas las palabras que hay en datos teniendo en cuenta los separadores.
		
		try{
			contador.incluyeTodasFichero("datos.txt", delimitadores);
			contadorSigFich.incluyeTodasFichero("datos.txt", delimitadores);

			System.out.println(contador);
			System.out.println(contadorSigFich + "\n");

		    // Metodos para presentar por pantalla.
			PrintWriter pw = new PrintWriter(System.out, true);
			contador.presentaPalabras(pw);

			// Salida a fichero.
			contador.presentaPalabras("salida.txt");
			System.out.println();

			// Métodos para presentar por pantalla para No Significativas.
			contadorSigFich.presentaPalabras(pw);

			// Salida a fichero.
			contadorSigFich.presentaPalabras("salidaNoSig.txt");

		}catch (IOException e){
			System.out.println("ERROR:	"+ e.getMessage());
		}
	}
}
