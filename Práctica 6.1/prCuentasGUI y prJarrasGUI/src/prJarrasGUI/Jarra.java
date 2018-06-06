package prJarrasGUI;

public class Jarra {
	/**
	 * Contenido de liquido (en litros) de la jarra.
	 */
	private int contenido;

	/**
	 * Capacidad de la jarra (en litros).
	 */
	private final int capacidad;

	/**
	 * Creamos una jarra a partir de su capacidad.
	 * 
	 * @param capacidadInicial
	 *            capacidad que va a tener la jarra.
	 */
	public Jarra(int capacidadInicial) {
		if (capacidadInicial <= 0) {
			throw new RuntimeException("Capacidad negativa o nula");
		}
		capacidad = capacidadInicial;
		contenido = 0;
	}

	/**
	 * Devolvemos la capacidad de la jarra.
	 * 
	 * @return int con la capacidad de la jarra.
	 */
	public int getCapacidad() {
		return capacidad;
	}

	/**
	 * Devolvemos la cantidad de l�quido que hay en la jarra.
	 * 
	 * @return int con la cantidad de l�quido que hay en la jarra.
	 */
	public int getContenido() {
		return contenido;
	}

	/**
	 * Llenamos por completo la jarra.
	 */
	public void llenar() {
		contenido = capacidad;
	}

	/**
	 * Vaciamos por completo la jarra.
	 */
	public void vaciar() {
		contenido = 0;
	}

	/**
	 * Metodo para volcar el contenido de una jarra en otra hasta que 
	 * se llene o se vacie la otra
	 * @param j Jarra de la que se extrae el agua
	 */
	public void llenarDesde(Jarra j) {		
		int maximoAPasar = Math.min(capacidad - contenido, j.contenido);
		contenido += maximoAPasar;
		j.contenido -= maximoAPasar;
	}

	/**
	 * Representamos una jarra indicando contenido y capacidad.
	 */
	@Override
	public String toString() {
		return "J(" + capacidad + ", " + contenido + ")";
	}
}
