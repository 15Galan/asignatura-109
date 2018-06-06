package prCuentasGUI;


import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class PanelCuenta2 extends JPanel implements VistaCuenta {
	private JTextField cantidadJTF;
	private JLabel saldoJL;
	private JLabel mensajeJL;
	private JButton ingresarJB;
	private JButton extraerJB;

	public PanelCuenta2() {
		cantidadJTF = new JTextField(10);
		cantidadJTF.setHorizontalAlignment(JTextField.RIGHT);
		saldoJL = new JLabel(" ");
		saldoJL.setHorizontalAlignment(SwingConstants.CENTER);
		mensajeJL = new JLabel(" ");
		ingresarJB = new JButton("Ingresar");
		extraerJB = new JButton("Extraer");

		JPanel acciones = new JPanel();
		acciones.setLayout(new GridLayout(1,3));
		acciones.add(ingresarJB);
		acciones.add(extraerJB);
		
		JPanel izq = new JPanel();
		izq.setLayout(new GridLayout(2,1));
		izq.add(cantidadJTF);
		izq.add(acciones);
		
		JPanel dch = new JPanel();
		dch.setLayout(new BorderLayout());
		dch.add(saldoJL, BorderLayout.CENTER);
		dch.add(mensajeJL, BorderLayout.SOUTH);
		
		setLayout(new GridLayout(1, 2));
		add(izq);
		add(dch);
	}

	public void controlador(ActionListener ctr) {
		ingresarJB.addActionListener(ctr);
		ingresarJB.setActionCommand(INGRESO);
		extraerJB.addActionListener(ctr);
		extraerJB.setActionCommand(GASTO);
		cantidadJTF.addActionListener(ctr);
		cantidadJTF.setActionCommand(INGRESO);
	}

	public double obtenerCantidad() {
		return Double.parseDouble(cantidadJTF.getText());
	}

	public void saldo(double cantidad) {
		saldoJL.setText(String.format("Saldo: %12.2f", cantidad));
	}

	public void mensaje(String msg) {
		mensajeJL.setText(msg);
	}
	
	public void borrar() {
		cantidadJTF.setText("");
	}

}
