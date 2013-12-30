package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import model.BotonNumerico;
import model.BotonOperacion;

/**
 * Crea la vista básica y contiene métodos que tienen que ver con el entorno
 * gráfico
 * 
 * @author MAMAEWOK
 * 
 */
public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;

	/** numero tecleado */
	JTextField pantalla;
	BotonNumerico b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bPunto;
	BotonOperacion bMas, bMenos, bMulti, bDiv, bC, bIgual;

	/** Indica si iniciamos una nueva operacion o no */
	boolean nuevaOperacion = true;
	/** Guarda la operacion a realizar */
	String operacion = "0";
	/** Guarda el resultado de la operacion anterior o la que estamos tecleando */
	double resultado;

	/**
	 * Constructor que crea los componentes básicos de la calculadora
	 */
	public Vista() {
		super("Calculadora");
		pantalla = new JTextField("0", 20);// Creo la ventana de texto
		pantalla.setBorder(new EmptyBorder(4, 4, 4, 4));
		pantalla.setBackground(Color.WHITE);
		pantalla.setFont(new Font("Arial", Font.BOLD, 25));
		pantalla.setEditable(false);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4, 5, 5));
		JPanel panelIgual = new JPanel();

		b1 = new BotonNumerico(this, "1", panel);
		b2 = new BotonNumerico(this, "2", panel);
		b3 = new BotonNumerico(this, "3", panel);
		bMas = new BotonOperacion(this, "+", panel);
		b4 = new BotonNumerico(this, "4", panel);
		b5 = new BotonNumerico(this, "5", panel);
		b6 = new BotonNumerico(this, "6", panel);
		bMenos = new BotonOperacion(this, "-", panel);
		b7 = new BotonNumerico(this, "7", panel);
		b8 = new BotonNumerico(this, "8", panel);
		b9 = new BotonNumerico(this, "9", panel);
		bMulti = new BotonOperacion(this, "x", panel);
		bPunto = new BotonNumerico(this, ".", panel);
		b0 = new BotonNumerico(this, "0", panel);
		bC = new BotonOperacion(this, "C", panel);
		bDiv = new BotonOperacion(this, "÷", panel);
		bIgual = new BotonOperacion(this, "=", panelIgual);

		this.setSize(250, 300);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(pantalla, BorderLayout.NORTH);
		this.add(panel, BorderLayout.CENTER);
		this.add(panelIgual, BorderLayout.SOUTH);
		this.setResizable(false);
		this.setVisible(true);

	} // Acaba el constructor

	/**
	 * Quita los dos últimos carácteres del texto que aparezca en la caja de
	 * texto
	 */
	public void imprimeSinDecimal() { 
		String text = pantalla.getText();
		if (text.endsWith(".0")) {
			resultado = new Double(text);
			DecimalFormat df = new DecimalFormat("0.#");
			pantalla.setText("" + (df.format(resultado)));
		} else {
			pantalla.setText("" + resultado);
		}
	}

	/**
	 * Gestiona la pulsacion de teclas numéricas
	 * 
	 * @param digito
	 */
	public void numeroPulsado(String digito) {
		if (pantalla.getText().equals("0") || nuevaOperacion) {
			pantalla.setText(digito);
			// Ver para que aparezca el 0 con decimales
			if (pantalla.getText().equals("."))
				pantalla.setText("0.");
		} else {
			pantalla.setText(pantalla.getText() + digito);
		}
		nuevaOperacion = false;

	}

	/**
	 * Gestiona la pulsacion de teclas de operacion
	 * 
	 * @param oper
	 */
	public void operacionPulsado(String oper) {
		if (oper.equals("="))
			calcularResultado();
		else if (oper.equals("C")) {
			resultado = 0;
			pantalla.setText("0");
			nuevaOperacion = true;
		} else {
			operacion = oper;
			if ((resultado > 0) && !nuevaOperacion) {
				calcularResultado();
			} else {
				resultado = new Double(pantalla.getText());
				pantalla.setText("" + resultado);
			}
		}
		nuevaOperacion = true;
	}

	/**
	 * Calcula el resultado y lo saca por pantalla sacando un mensaje de error en el caso de ser resultado infinito
	 */
	public void calcularResultado() {
		if (operacion.equals("+")) {
			resultado += new Double(pantalla.getText());
			imprimeSinDecimal();
		} else if (operacion.equals("-")) {
			resultado -= new Double(pantalla.getText());
			imprimeSinDecimal();
		} else if (operacion.equals("x")) {
			resultado *= new Double(pantalla.getText());
			imprimeSinDecimal();
		} else if (operacion.equals("÷")) {
			resultado /= new Double(pantalla.getText());
			imprimeSinDecimal();
		} else {
			resultado = new Double(pantalla.getText());
			imprimeSinDecimal();
		}
		if(Double.isInfinite(resultado)){
			pantalla.setText("ERROR");
		}
		else{
			pantalla.setText("" + resultado);
			imprimeSinDecimal();
			operacion = "";
		}
		
	}

}
