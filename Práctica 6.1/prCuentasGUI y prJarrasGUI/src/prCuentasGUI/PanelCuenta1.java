package prCuentasGUI;



import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class PanelCuenta1 extends JPanel implements VistaCuenta {
	private JTextField cantidadJTF;
	private JLabel saldoJL;
	private JLabel mensajeJL;
	private JButton ingresarJB;
	private JButton extraerJB;
	private JButton saldoJB;

	public PanelCuenta1() {
		// Definicion de componentes basicos
		cantidadJTF = new JTextField(10);
		saldoJL = new JLabel(" ");
		mensajeJL = new JLabel(" ");
		ingresarJB = new JButton("Ingresar");
		extraerJB = new JButton("Extraer");
		saldoJB = new JButton("Saldo");
		// Panel central
		JPanel panelC = new JPanel();
		panelC.setLayout(new GridLayout(2, 2));
		panelC.add(new JLabel("Cantidad"));
		panelC.add(cantidadJTF);
		panelC.add(new JLabel("Saldo"));
		panelC.add(saldoJL);
		// Panel derecho
		JPanel panelD = new JPanel();
		panelD.setLayout(new GridLayout(3, 1));
		panelD.add(ingresarJB);
		panelD.add(extraerJB);
		panelD.add(saldoJB);
		// Confección del panel principal de contenidos
		setLayout(new BorderLayout());
		add(panelC, BorderLayout.CENTER);
		add(panelD, BorderLayout.EAST);
		add(mensajeJL, BorderLayout.SOUTH);
	}

	public void controlador(ActionListener ctr) {
		ingresarJB.addActionListener(ctr);
		ingresarJB.setActionCommand(INGRESO);
		extraerJB.addActionListener(ctr);
		extraerJB.setActionCommand(GASTO);
		saldoJB.addActionListener(ctr);
		saldoJB.setActionCommand(SALDO);
	}

	public double obtenerCantidad() {
		return Double.parseDouble(cantidadJTF.getText());
	}

	public void saldo(double cantidad) {
		saldoJL.setText(String.format("%12.2f", cantidad));
	}

	public void mensaje(String msg) {
		mensajeJL.setText(msg);
	}
	
	public void borrar() {
		cantidadJTF.setText("");
	}

}


