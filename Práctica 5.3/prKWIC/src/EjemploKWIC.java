import java.io.*;
import kwic.*;

public class EjemploKWIC {
	public static void main(String[] args) {
		try {
			KWIC k = new KWIC();
			k.palabrasNoSignificativas("noClaves.txt");
			k.generaIndice("frases.txt");
			
			System.out.println("Presenta indice sin aplicar sustitucion de palabras");
			System.out.println("---------------------------------------------------");
			PrintWriter pw = new PrintWriter(System.out, true);
			k.presentaIndice(pw);
			
			k.presentaIndice("salida.txt");
			
			TituloKWICSustitucion ksust = new TituloKWICSustitucion();
			ksust.palabrasNoSignificativas("noClaves.txt");
			ksust.generaIndice("frases.txt");

			System.out.println("\n\nPresenta indice aplicando sustitucion de palabras");
			System.out.println("-------------------------------------------------");
			ksust.presentaIndice(pw);
					
			ksust.presentaIndice("salida-sust.txt");
	
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
