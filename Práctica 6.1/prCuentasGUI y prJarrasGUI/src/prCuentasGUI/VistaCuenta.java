package prCuentasGUI;

import java.awt.event.*;

// Interfaz para la vista.
public interface VistaCuenta {
	String INGRESO = "INGRESO";
	String GASTO = "GASTO";
	String SALDO = "SALDO";

	/**
	 * Obtener la cantidad para ingresar/extraer.
	 * @return cantidad a ingresar/extraer (double).
	 */
	double obtenerCantidad();

	/**
	 * Establecer el saldo de la cuenta.
	 * Recibe el saldo de la cuenta (double).
	 * @param saldo
	 */
	void saldo(double saldo);

	/**
	 * Mostrar un mensaje de información.
	 * Recibe el mensaje a mostrar (String).
	 * @param msg
	 */
	void mensaje(String msg);

	/**
	 * Elimina el contenido del campo
     * de mensaje de la interfaz.
	 */
	void borrar();

	void controlador(ActionListener ctr);
}
