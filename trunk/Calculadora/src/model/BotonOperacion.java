package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import vista.Vista;

public class BotonOperacion extends JButton implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vista vista;
	
	public BotonOperacion(Vista vista, String operacion, JPanel panel){
		super();
		this.vista = vista;
		
		this.setForeground(Color.RED);
		this.setFont(new Font("FuenteOperacion", Font.BOLD, 15));
		this.setText(operacion);
		panel.add(this);
		this.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btnOper = (JButton) e.getSource();
		vista.operacionPulsado(btnOper.getText());
		System.out.println("pulsado el boton operacion:" + btnOper.getText());
		
	}

	
}
