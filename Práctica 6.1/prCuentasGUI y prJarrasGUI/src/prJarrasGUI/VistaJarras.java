package prJarrasGUI;

import java.awt.event.ActionListener;


public interface VistaJarras {
	public static final String INICIAR = "INICIAR";

	public static final String LLENAR_A = "LLENAR_A";

	public static final String LLENAR_B = "LLENAR_B";

	public static final String VACIAR_A = "VACIAR_A";

	public static final String VACIAR_B = "VACIAR_B";

	public static final String VOLCAR_A_EN_B = "VOLCAR_A_EN_B";

	public static final String VOLCAR_B_EN_A = "VOLCAR_B_EN_A";

	public static final String FINALIZAR = "FINALIZAR";

	/**
	 * Se pasa el controlador.
	 */
	public void controlador(ActionListener ctr);

	/**
	 * Se obtiene la capcidad inicial de la jarra A.
	 * 
	 * @return capacidad inicial de la jarra A.
	 */
	public int capacidadInicialA();

	/**
	 * Obtenemos la capacidad inicial de la jarra B
	 * 
	 * @return int con la capacidad inicial de la jarra B.
	 */
	public int capacidadInicialB();

	/**
	 * Mostramos un mensaje de error.
	 * 
	 * @param mensaje
	 *            String con el mensaje a mostrar.
	 */
	public void error(String mensaje);

	/**
	 * Mostramos un mensaje de informacion.
	 * 
	 * @param mensaje
	 *            String con el mensaje a mostrar.
	 */
	public void ok(String mensaje);

	/**
	 * Habilitamos o deshabilitamos las componentes necesarias ya sea en el
	 * inicio de la aplicacion o durante su funcionamiento
	 * 
	 * @param b
	 *            true si queremos habilitar las componentes necesarias durante
	 *            el inicio de la aplicacion. false cuando ya esta inicializado
	 *            el modelo de la aplicacion.
	 */
	public void habilitarInicio(boolean b);

	/**
	 * Establecemos la capacidad de la jarra A.
	 * 
	 * @param c
	 *            int con la capacidad de la jarra A
	 */
	public void capacidadA(int c);

	/**
	 * Estalecemos la capacidad de la jarra B.
	 * 
	 * @param c
	 *            int con la capacidad de la jarra B.
	 */
	public void capacidadB(int c);

	/**
	 * Establecemos el contenido de la jarra A.
	 * 
	 * @param c
	 *            int con el contenido de la jarra A.
	 */
	public void contenidoA(int c);

	/**
	 * Establecemos el contenido de la jarra B.
	 * 
	 * @param c
	 *            int con el contenido de la jarra B.
	 */
	public void contenidoB(int c);

	/**
	 * Agregamos un mensaje al historico.
	 * 
	 * @param mensaje
	 *            String con el mensaje a agregarr.
	 */
	public void agregarAHistorico(String mensaje);

	/**
	 * Limpiamos el historico.
	 */
	public void limpiar();
}