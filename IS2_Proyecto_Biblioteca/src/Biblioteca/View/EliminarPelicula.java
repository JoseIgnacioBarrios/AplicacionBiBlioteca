package Biblioteca.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Biblioteca.Control.Controller;

public class EliminarPelicula extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Controller _ctrl;
	private JLabel id = new JLabel("ID: ");
	private JTextField id_field = new JTextField();
	private JButton ok = new JButton("Ok");
	
	public EliminarPelicula(Controller ctrl) {
		this._ctrl = ctrl;
		this.setPreferredSize(new Dimension(400, 150));
		//JPanel mainPanel = new JPanel();
		setLayout(null);
		
		// Componentes visuales
		id.setBounds(23, 28, 92, 20);
		id_field.setBounds(115, 25, 193, 28);

		// Buttons
		ok.setBounds(115, 70, 92, 28);
		ok.setForeground(Color.WHITE);
		ok.setBackground(Color.BLACK);
		ok.setFocusPainted(false);
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String idPelicula;
				idPelicula=id_field.getText();
				if(_ctrl.eliminarPelicula(idPelicula)) {
					 JFrame jFrame = new JFrame();
				 JOptionPane.showMessageDialog(jFrame, "Se ha eliminado correctamente");
				 //EliminarPelicula.this.dispose();
				}else {
					 JFrame jFrame = new JFrame();
					 JOptionPane.showMessageDialog(jFrame, "Ha ocurrido un error");
					 
				}
				
	
				 
			}
			
		});
		
		setBounds(215, 70, 80, 28);
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		
		add(id);	
		add(id_field);
		
		add(ok);
		
		this.setVisible(true);
		//this.add(mainPanel);
		//this.pack();
		//this.setResizable(false);
	}
	
}
