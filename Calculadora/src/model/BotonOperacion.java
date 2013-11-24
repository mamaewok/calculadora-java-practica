package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import vista.Vista;
/**
 * Crea un botón de tipo operación que incluye la funcionalidad básica que va a tener
 * @author MAMAEWOK
 *
 */
public class BotonOperacion extends JButton implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vista vista;
	/**
	 * Establece la VISTA, operador y el panel al que pertenece dicho botón a instanciar
	 * @param vista
	 * @param operacion
	 * @param panel
	 */
	public BotonOperacion(Vista vista, String operacion, JPanel panel){
		super();
		this.vista = vista;
		
		this.setForeground(Color.RED);
		this.setFont(new Font("FuenteOperacion", Font.BOLD, 15));
		this.setText(operacion);
		panel.add(this);
		this.addActionListener(this);
	}
	/**
	 * Acción a relizar por nuestro botón operaación
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btnOper = (JButton) e.getSource();
		vista.operacionPulsado(btnOper.getText());
		System.out.println("pulsado el boton operacion:" + btnOper.getText());
		
	}

	
}
