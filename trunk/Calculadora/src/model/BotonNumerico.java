package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import vista.Vista;

/**
 * Crea un bot�n de tipo numerico que incluye la funcionalidad b�sica que va a tener este tipo de botones
 * @author MAMAEWOK
 *
 */
public class BotonNumerico extends JButton implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vista vista;
	
	/**
	 * Crea un boton de teclado num�rico, enlaza sus eventos y lo coloca en un panel de la vista
	 * 
	 * @param vista
	 * @param digito
	 * @param panelNum
	 */
	
	public BotonNumerico(Vista vista, String digito, JPanel panelNum){
		super();
		this.vista = vista;
		this.setText(digito);
			this.setForeground(Color.BLACK);
			this.setFont(new Font("FuenteOperacion", Font.BOLD, 15));
		panelNum.add(this);
		this.addActionListener(this);
	}
	/**
	 * Acci�n a relizar por nuestro bot�n num�rico
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btnNum = (BotonNumerico) e.getSource();
		vista.numeroPulsado(btnNum.getText());
		System.out.println("pulsado el boton numerico:" + btnNum.getText());
	}
	
	
}
