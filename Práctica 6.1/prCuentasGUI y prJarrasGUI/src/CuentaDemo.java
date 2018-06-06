import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import prCuentasGUI.Cuenta;
import prCuentasGUI.CtrCuenta;
import prCuentasGUI.PanelCuenta1;
import prCuentasGUI.PanelCuenta2;
import prCuentasGUI.PanelCuenta3;
import prCuentasGUI.VistaCuenta;

public class CuentaDemo {
	public static void main(String[] args) {
		
		// Creamos la vista.
		VistaCuenta vistaCuenta = new PanelCuenta1();
		// VistaCuenta vistaCuenta = new PanelCuenta2();
		// VistaCuenta vistaCuenta = new PanelCuenta3();
		
		// Creamos el modelo.
		Cuenta cuenta = new Cuenta(0);
		
		// Creamos el controlador.
		ActionListener ctrCuenta = new CtrCuenta(vistaCuenta, cuenta);
		
		// Registramos el Controlador en la vista.
		vistaCuenta.controlador(ctrCuenta);

		// Mostramos la vista en una ventana.
		JFrame ventana = new JFrame("Control de cuentas");

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane((JPanel) vistaCuenta);
		ventana.pack();
		ventana.setVisible(true);
	}
}
