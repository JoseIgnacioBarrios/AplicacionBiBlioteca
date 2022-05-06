package Biblioteca.View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import Biblioteca.Control.Controller;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminRmvUser extends JPanel {
	private JTextField emailTf = new JTextField();;
	private JLabel emailLbl = new JLabel("Email :");;
	private JButton EliminarBtn = new JButton("Eliminar");
	private Controller _ctrl;
	/**
	 * Create the panel.
	 */
	public AdminRmvUser(Controller _ctrl) {
		this._ctrl = _ctrl;
		setBackground(Color.WHITE);
		setLayout(null);
		 
		emailLbl.setForeground(Color.BLACK);
		emailLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		emailLbl.setBounds(30, 50, 65, 13);
		add(emailLbl);
		
		 
		emailTf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		emailTf.setBounds(121, 45, 206, 23);
		add(emailTf);
		emailTf.setColumns(10);
		EliminarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteUsuario();
			}
		});
		
		
		EliminarBtn.setBounds(136, 95, 85, 21);
		EliminarBtn.setForeground(Color.WHITE);
		EliminarBtn.setBackground(Color.BLACK);
		add(EliminarBtn);

	}
	public void deleteUsuario() {
		String email = emailTf.getText();
		if(_ctrl.existeUsuario(email)) {
			int dialogButton = JOptionPane.showConfirmDialog (null, "Seguro de Eliminar ","Eliminar",JOptionPane.OK_CANCEL_OPTION);
			if(dialogButton == JOptionPane.OK_OPTION) {
				_ctrl.deleteUsuario(email);
				//System.exit(0);
				emailTf.setText(null);
			}else {remove(dialogButton);}
		}
	}
}
