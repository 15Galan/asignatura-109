
package prJarrasGUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
//import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class PanelJarras extends JPanel implements VistaJarras {
	private JLabel etiquetaJarraA;

	private JLabel etiquetaJarraB;

	private JButton botonLlenarA;

	private JButton botonLlenarB;

	private JTextField textoContenidoA;

	private JTextField textoContenidoB;

	private JTextField textoCapacidadA;

	private JTextField textoCapacidadB;

	private JButton botonVaciarA;

	private JButton botonVaciarB;

	private JTextArea textoAreaHistorico;

	private JLabel etiquetaInformacion;

	private JButton botonVolcarAEnB;

	private JButton botonVolcarBEnA;

	private JButton botonIniciar;

	private JTextField textoCapacidadInicialA;

	private JTextField textoCapacidadInicialB;

	private JLabel etiquetaContenidoA;

	private JLabel etiquetaCapacidadA;

	private JLabel etiquetaContenidoB;

	private JLabel etiquetaCapacidadB;

	private JButton botonFinalizar;

	public PanelJarras() {
		setLayout(new BorderLayout(5, 5));

		// Creamos el panel de inicar capacidades
		JPanel panelIniciarCapacidades = new JPanel();
		panelIniciarCapacidades.setLayout(new GridLayout(1, 3, 2, 2));
		textoCapacidadA = new JTextField(4);
		textoCapacidadB = new JTextField(4);
		etiquetaJarraA = new JLabel("Jarra A");
		etiquetaJarraB = new JLabel("Jarra B");
		textoCapacidadInicialA = new JTextField(4);
		textoCapacidadInicialB = new JTextField(4);
		botonIniciar = new JButton("Iniciar Capacidades");
		JPanel panelCapacidadInicialA = new JPanel();
		panelCapacidadInicialA.setLayout(new FlowLayout());
		panelCapacidadInicialA.add(etiquetaJarraA);
		panelCapacidadInicialA.add(textoCapacidadInicialA);
		JPanel panelCapacidadInicialB = new JPanel();
		panelCapacidadInicialB.setLayout(new FlowLayout());
		panelCapacidadInicialB.add(etiquetaJarraB);
		panelCapacidadInicialB.add(textoCapacidadInicialB);
		panelIniciarCapacidades.add(panelCapacidadInicialA);
		panelIniciarCapacidades.add(botonIniciar);
		panelIniciarCapacidades.add(panelCapacidadInicialB);

		// Creamos el panel central
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new GridLayout(2, 1, 5, 5));

		// Creamos el panel de las jarras
		JPanel panelJarras = new JPanel();
		panelJarras.setLayout(new GridLayout(1, 3, 5, 5));

		// Creamos el panel de la Jarra A
		JPanel panelJarraA = new JPanel();
		panelJarraA.setLayout(new GridLayout(4, 1, 2, 2));
		botonLlenarA = new JButton("Llenar");
		textoContenidoA = new JTextField(4);
		textoContenidoA.setEditable(false);
		textoCapacidadA = new JTextField(4);
		textoCapacidadA.setEditable(false);
		botonVaciarA = new JButton("Vaciar");
		etiquetaContenidoA = new JLabel("Contenido: ");
		etiquetaCapacidadA = new JLabel("Capacidad: ");
		// panelJarraA.add(etiquetaJarraA);
		JPanel panelContenidoA = new JPanel();
		JPanel panelCapacidadA = new JPanel();
		panelContenidoA.setLayout(new FlowLayout());
		panelContenidoA.add(etiquetaContenidoA);
		panelContenidoA.add(textoContenidoA);
		panelCapacidadA.setLayout(new FlowLayout());
		panelCapacidadA.add(etiquetaCapacidadA);
		panelCapacidadA.add(textoCapacidadA);
		panelJarraA.add(botonLlenarA);
		panelJarraA.add(panelContenidoA);
		panelJarraA.add(panelCapacidadA);
		panelJarraA.add(botonVaciarA);

		// Creamos el panel de las flechas
		JPanel panelFlechas = new JPanel();
		panelFlechas.setLayout(new GridLayout(3, 1, 2, 2));
		//botonVolcarAEnB = new JButton("=>");
//		botonVolcarAEnB = new JButton(new ImageIcon(getClass().getResource("imagenes/go-next.jpg")));
//		botonVolcarBEnA = new JButton(new ImageIcon(getClass().getResource("imagenes/go-previous.jpg")));
		botonVolcarAEnB = new JButton(new ImageIcon("imagenes/go-next.jpg"));
		botonVolcarBEnA = new JButton(new ImageIcon("imagenes/go-previous.jpg"));
//		botonVolcarAEnB = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage("/imagenes/go-next.png")));
//		botonVolcarAEnB = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage("/imagenes/go-previous.png")));

		
		botonFinalizar = new JButton("Finalizar");
		panelFlechas.add(botonVolcarAEnB);
		panelFlechas.add(botonVolcarBEnA);
		panelFlechas.add(botonFinalizar);

		// Creamos el panel de la Jarra B
		JPanel panelJarraB = new JPanel();
		panelJarraB.setLayout(new GridLayout(4, 1, 2, 2));
		botonLlenarB = new JButton("Llenar");
		textoContenidoB = new JTextField(4);
		textoContenidoB.setEditable(false);
		textoCapacidadB = new JTextField(4);
		textoCapacidadB.setEditable(false);
		botonVaciarB = new JButton("Vaciar");
		etiquetaContenidoB = new JLabel("Contenido: ");
		etiquetaCapacidadB = new JLabel("Capacidad: ");
		// panelJarraB.add(etiquetaJarraB);
		JPanel panelContenidoB = new JPanel();
		JPanel panelCapacidadB = new JPanel();
		panelContenidoB.setLayout(new FlowLayout());
		panelContenidoB.add(etiquetaContenidoB);
		panelContenidoB.add(textoContenidoB);
		panelCapacidadB.setLayout(new FlowLayout());
		panelCapacidadB.add(etiquetaCapacidadB);
		panelCapacidadB.add(textoCapacidadB);

		panelJarraB.add(botonLlenarB);
		panelJarraB.add(panelContenidoB);
		panelJarraB.add(panelCapacidadB);
		panelJarraB.add(botonVaciarB);

		// Creamos el panel del historico
		textoAreaHistorico = new JTextArea();
		textoAreaHistorico.setEditable(false);
		JScrollPane panelHistorico = new JScrollPane(textoAreaHistorico);

		// Creamos la etiqueta de informacion
		etiquetaInformacion = new JLabel();

		// Ensamblamos los paneles
		panelJarras.add(panelJarraA);
		panelJarras.add(panelFlechas);
		panelJarras.add(panelJarraB);
		panelCentral.add(panelJarras);
		panelCentral.add(panelHistorico);
		add(panelIniciarCapacidades, BorderLayout.NORTH);
		add(panelCentral, BorderLayout.CENTER);
		add(etiquetaInformacion, BorderLayout.SOUTH);
	}

	public void controlador(ActionListener cj) {
		botonIniciar.addActionListener(cj);
		botonLlenarA.addActionListener(cj);
		botonLlenarB.addActionListener(cj);
		botonVaciarA.addActionListener(cj);
		botonVaciarB.addActionListener(cj);
		botonVolcarAEnB.addActionListener(cj);
		botonVolcarBEnA.addActionListener(cj);
		botonFinalizar.addActionListener(cj);
		botonIniciar.setActionCommand(VistaJarras.INICIAR);
		botonLlenarA.setActionCommand(VistaJarras.LLENAR_A);
		botonLlenarB.setActionCommand(VistaJarras.LLENAR_B);
		botonVaciarA.setActionCommand(VistaJarras.VACIAR_A);
		botonVaciarB.setActionCommand(VistaJarras.VACIAR_B);
		botonVolcarAEnB.setActionCommand(VistaJarras.VOLCAR_A_EN_B);
		botonVolcarBEnA.setActionCommand(VistaJarras.VOLCAR_B_EN_A);
		botonFinalizar.setActionCommand(VistaJarras.FINALIZAR);
	}

	public void error(String mensaje) {
		etiquetaInformacion.setForeground(Color.RED);
		etiquetaInformacion.setText(mensaje);
	}

	public void ok(String mensaje) {
		etiquetaInformacion.setForeground(Color.BLUE);
		etiquetaInformacion.setText(mensaje);
	}

	public void habilitarInicio(boolean b) {
		etiquetaJarraA.setEnabled(b);
		etiquetaJarraB.setEnabled(b);
		botonIniciar.setEnabled(b);
		textoCapacidadInicialA.setEnabled(b);
		textoCapacidadInicialB.setEnabled(b);

		botonLlenarA.setEnabled(!b);
		botonLlenarB.setEnabled(!b);
		botonVaciarA.setEnabled(!b);
		botonVaciarB.setEnabled(!b);
		etiquetaContenidoA.setEnabled(!b);
		etiquetaContenidoB.setEnabled(!b);
		etiquetaCapacidadA.setEnabled(!b);
		etiquetaCapacidadB.setEnabled(!b);
		botonVolcarAEnB.setEnabled(!b);
		botonVolcarBEnA.setEnabled(!b);
		botonFinalizar.setEnabled(!b);
	}

	public int capacidadInicialA() {
		return Integer.parseInt(textoCapacidadInicialA.getText());
	}

	public int capacidadInicialB() {
		return Integer.parseInt(textoCapacidadInicialB.getText());
	}

	public void capacidadA(int c) {
		textoCapacidadA.setText("" + c);
	}

	public void capacidadB(int c) {
		textoCapacidadB.setText("" + c);
	}

	public void contenidoA(int c) {
		textoContenidoA.setText("" + c);
	}

	public void contenidoB(int c) {
		textoContenidoB.setText("" + c);
	}

	public void agregarAHistorico(String mensaje) {
		textoAreaHistorico.append(mensaje + "\n");
	}

	public void limpiar() {
		textoAreaHistorico.setText("");
		textoCapacidadA.setText("");
		textoCapacidadB.setText("");
		textoContenidoA.setText("");
		textoContenidoB.setText("");
	}
}