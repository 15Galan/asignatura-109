import javax.swing.JFrame;
import javax.swing.JPanel;
import prJarrasGUI.*;

public class AplicacionJarras {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VistaJarras panelJarras = new PanelJarras();
		ControladorJarras ctrlJ = new ControladorJarras(panelJarras);
		
		panelJarras.controlador(ctrlJ);
		
		JFrame ventana = new JFrame("Jarras");

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane((JPanel)panelJarras);
		ventana.pack();
		ventana.setVisible(true);
	}

}

