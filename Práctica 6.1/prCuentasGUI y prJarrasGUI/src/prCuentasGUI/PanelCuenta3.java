package prCuentasGUI;


import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class PanelCuenta3 extends JPanel implements ActionListener, VistaCuenta {
	private JTextField cantidadJTF;
	private JButton ingresarJB;
	private JButton extraerJB;
	private static final String BORRAR = "Borrar";
	private JTextArea mensajesJTA;
	private JLabel saldoJL;

	public PanelCuenta3() {
		cantidadJTF = new JTextField(10);
		cantidadJTF.setEditable(false);
		cantidadJTF.setHorizontalAlignment(JTextField.RIGHT);
		saldoJL = new JLabel(" ");
		saldoJL.setHorizontalAlignment(JLabel.RIGHT);
//		saldoJL.setOpaque(true);
//		saldoJL.setBackground(Color.ORANGE);
		ingresarJB = new JButton("Ingresar");
		extraerJB = new JButton("Extraer");

		// Construcción de la botonera
		JPanel botonera = new JPanel();
		botonera.setLayout(new GridLayout(4, 3, 1, 1));
		JButton[] botones = new JButton[10];
		for (int i = 1; i <= 9; i++) {
			botones[i] = new JButton(Integer.toString(i));
			botones[i].setActionCommand(Integer.toString(i));
			botones[i].addActionListener(this);
			botonera.add(botones[i]);
		}
		botones[0] = new JButton("0");
		botones[0].setActionCommand("0");
		botones[0].addActionListener(this);
		botonera.add(botones[0]);
		botonera.add(new JLabel(" "));
		JButton borrar = new JButton(BORRAR);
		borrar.addActionListener(this);
		borrar.setActionCommand(BORRAR);
		botonera.add(borrar);
		
		// Panel de acciones
		JPanel acciones = new JPanel();
		acciones.setLayout(new GridLayout(2, 1));
		acciones.add(ingresarJB);
		acciones.add(extraerJB);

		
		// Panel izquierdo
		JPanel izq = new JPanel();
		izq.setLayout(new BorderLayout());
		izq.add(cantidadJTF, BorderLayout.NORTH);
		izq.add(botonera, BorderLayout.CENTER);
		izq.add(acciones, BorderLayout.EAST);
		
		// Panel derecho
		JPanel dch = new JPanel();
		mensajesJTA = new JTextArea(10,20);
		dch.setLayout(new BorderLayout());
		dch.add(new JScrollPane(mensajesJTA), BorderLayout.CENTER);
		dch.add(saldoJL, BorderLayout.NORTH);

		// Panel total
		setLayout(new GridLayout(2,1));
		add(izq);
		add(dch);
	}

	public void controlador(ActionListener ctr) {
		ingresarJB.addActionListener(ctr);
		ingresarJB.setActionCommand(INGRESO);
		extraerJB.addActionListener(ctr);
		extraerJB.setActionCommand(GASTO);
	}

	public double obtenerCantidad() {
		return Double.parseDouble(cantidadJTF.getText());
	}

	public void saldo(double cantidad) {
		saldoJL.setText(String.format("Saldo: %12.2f", cantidad));
	}

	public void mensaje(String msg) {
		mensajesJTA.append(msg+"\n");
	}

	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		// Este copntrolador vale para borrar y para los nÃºmeros
		if (comando.equals(BORRAR)) {
					cantidadJTF.setText("");
		} else {
			int i = Integer.parseInt(comando);
			cantidadJTF.setText(Integer
					.toString(i
							+ 10
							* Integer.parseInt(cantidadJTF.getText()
									.equals("") ? "0" : cantidadJTF
									.getText())));
		}
	}
	
	public void borrar() {
		cantidadJTF.setText("");
	}
}
