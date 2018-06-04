import java.util.Collection;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.io.*;

import prCuentaPalabrasSimpleColecciones.*;

public class Main {

	public static void main(String [] args) {

		String [] datos = {	
			"Guerra tenía una jarra y Parra tenía una perra, ",
			"pero la perra de Parra rompió la jarra de Guerra.",
			"Guerra pegó con la porra a la perra de Parra. ",
			"¡Oiga usted buen hombre de Parra! ",
			"Por qué ha pegado con la porra a la perra de Parra.",
			"Porque si la perra de Parra no hubiera roto la jarra de Guerra,",
			"Guerra no hubiera pegado con la porra a la perra de Parra."};
		
		String delimitadores = "[ .,:;\\-\\!\\¡\\¿\\?]+";
		
		System.out.println("Creamos un contador de palabras.");

		ContadorPalabras contador = new ContadorPalabras();



		// Incluimos todas las palabras que hay en datos teniendo en cuenta los delimitadores.

		contador.incluyeTodas(datos, delimitadores);
		System.out.println(contador + "\n");
		
		try {
			System.out.println(contador.encuentra("parra"));
			System.out.println(contador.encuentra("Gorra"));

		} catch (NoSuchElementException e) {
            System.err.println(e.getMessage()+"\n");
		}



		//Repetimos la salida con entrada desde fichero.

		System.out.println("Repetimos la ejecución tomando la entrada desde fichero.");

		contador = new ContadorPalabras();

		// Incluimos todas las palabras que hay en «datos.txt» teniendo en cuenta los separadores.
		try{
			contador.incluyeTodasFichero("datos.txt", delimitadores);
			System.out.println(contador + "\n");
			
		    // Métodos para presentar por pantalla.
			System.out.println("Salida a pantalla: ");
			PrintWriter pw = new PrintWriter(System.out, true);
			contador.presentaPalabras(pw);
			
			// Salida a fichero.
			System.out.println("\nSalida a fichero: salida.txt\n");
			contador.presentaPalabras("salida.txt");
			                                          
		}catch (IOException e){
			System.out.println("ERROR:"+ e.getMessage());
		}

        System.out.println("\n\n\n\n");
		


		// Creamos un contador de palabras significativas.

		String [] noSig = {"A", "CON", "DE", "LA", "NO", "SI", "UNA", "Y"};
		Collection<String> palNS = new HashSet<String>();

		for (String p : noSig){
		    palNS.add(p);
		}
		
		System.out.println("Creamos un fichero de palabras significativas: ");

		ContadorPalabrasSig contadorSig = new ContadorPalabrasSig(palNS);
		contadorSig.incluyeTodas(datos, delimitadores);

		System.out.println(contadorSig + "\n");
		
		//Repetimos la salida con entrada desde fichero.
		System.out.println("Repetimos la ejecución tomando las entradas desde fichero");
				
		// Incluimos todas las palabras que hay en «datos.txt» y las no significativas de «fichNoSig».
		try{
			contadorSig = new ContadorPalabrasSig("fichNoSig.txt", delimitadores);
			contadorSig.incluyeTodasFichero("datos.txt", delimitadores);

			System.out.println(contadorSig + "\n");
					
			// Métodos para presentar por pantalla.
			System.out.println("Salida a pantalla:");

			PrintWriter pw = new PrintWriter(System.out, true);
			contadorSig.presentaPalabras(pw);
					
			// Salida a fichero.
			System.out.println("\nSalida a fichero: salidaSig.txt");

			contadorSig.presentaPalabras("salidaSig.txt");
					                                          
		}catch (IOException e){
			System.out.println("ERROR:"+ e.getMessage());
		}
	}
}