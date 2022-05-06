package Biblioteca.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Biblioteca.Control.Controller;

public class EliminarLibro extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Controller _ctrl;
	private JLabel id = new JLabel("ID: ");
	private JTextField id_field = new JTextField();
	private JButton ok = new JButton("Ok");
	private JButton cancel = new JButton("Cancel");
	
	public EliminarLibro(Controller ctrl) {
		setBackground(Color.WHITE);
		this._ctrl = ctrl;
		this.setPreferredSize(new Dimension(400, 150));
		//JPanel mainPanel = new JPanel();
		//mainPanel.setLayout(null);
		
		// Componentes visuales
		id.setBounds(52, 32, 53, 13);
		id_field.setBounds(134, 29, 163, 19);

		// Buttons
		ok.setBounds(79, 99, 62, 21);
		ok.setForeground(Color.WHITE);
		ok.setBackground(Color.BLACK);
		ok.setFocusPainted(false);
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String idLibro;
				idLibro=id_field.getText();
				if(_ctrl.eliminarLibro(idLibro)) {
					 JFrame jFrame = new JFrame();
				 JOptionPane.showMessageDialog(jFrame, "Se ha eliminado correctamente");
				 //EliminarLibro.this.dispose();
				}else {
					 JFrame jFrame = new JFrame();
					 JOptionPane.showMessageDialog(jFrame, "Ha ocurrido un error");
					 
				}
				
	
				 
			}
			
		});
		
		cancel.setBounds(180, 99, 92, 21);
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(Color.BLACK);
		cancel.setFocusPainted(false);
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//EliminarLibro.this.dispose();
			}		
		});
		setLayout(null);
		
		add(id);	
		add(id_field);
		
		add(ok);
		add(cancel);
		
		this.setVisible(true);
		//this.add(mainPanel);
		//this.pack();
		//this.setResizable(false);
	}
	
}
