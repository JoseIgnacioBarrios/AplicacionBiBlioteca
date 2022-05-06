package Biblioteca.View;

import javax.swing.JPanel;
import javax.swing.JTextPane;

import Biblioteca.Control.Controller;
import Biblioteca.Model.Usuario;

import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AdminModUser extends JPanel {
	private JTextField textFCorreoBM;
	private JTextField textFNombre;
	private JTextField textFPassword;
	private JButton btnmodificaruser ;
	private JButton btnBuscarUser;
	private JLabel lblCorreoBuscar;
	private JLabel lblNombre;
	private JLabel lblPassword;
	private Controller _ctrl;
	

	
	public AdminModUser(Controller _ctrl) {
		setBackground(Color.WHITE);
		this._ctrl=_ctrl;
		setLayout(null);
		
		btnBuscarUser = new JButton("Buscar usuario");
		btnBuscarUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarusuario();
			}
		});
		btnBuscarUser.setBounds(257, 60, 129, 21);
		btnBuscarUser.setForeground(Color.WHITE);
		btnBuscarUser.setBackground(Color.BLACK);
		add(btnBuscarUser);
		
		lblCorreoBuscar = new JLabel("Correo");
		lblCorreoBuscar.setForeground(Color.BLACK);
		lblCorreoBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCorreoBuscar.setBounds(32, 64, 66, 13);
		add(lblCorreoBuscar);
		
		textFCorreoBM = new JTextField();
		textFCorreoBM.setBounds(108, 61, 96, 19);
		add(textFCorreoBM);
		textFCorreoBM.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setEnabled(false);
		lblNombre.setBounds(32, 132, 66, 13);
		add(lblNombre);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setEnabled(false);
		lblPassword.setBounds(32, 183, 73, 13);
		add(lblPassword);
		
		textFNombre = new JTextField();
		textFNombre.setEnabled(false);
		textFNombre.setBounds(108, 129, 96, 19);
		add(textFNombre);
		textFNombre.setColumns(10);
		
		textFPassword = new JTextField();
		textFPassword.setEnabled(false);
		textFPassword.setBounds(108, 180, 96, 19);
		add(textFPassword);
		textFPassword.setColumns(10);
		
		btnmodificaruser = new JButton("Modificar User");
		btnmodificaruser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificaruser();
			}
		});
		btnmodificaruser.setEnabled(false);
		btnmodificaruser.setBounds(119, 234, 129, 21);
		btnmodificaruser.setForeground(Color.WHITE);
		btnmodificaruser.setBackground(Color.BLACK);
		add(btnmodificaruser);
		

	}
	
	public void buscarusuario() {
		String email = textFCorreoBM.getText();
		if(!this._ctrl.existeUsuario(email)) {
			JOptionPane.showMessageDialog(this, "No existe un usuario con ese Correo!" );
		}else {
		status(true);
		JOptionPane.showMessageDialog(this, "User encontrado \n Modificara este usuario" );
		}
	}
	public void modificaruser() {
		Usuario us;
		String email=textFCorreoBM.getText();
		String nombre=textFNombre.getText();
		String password=textFPassword.getText();
		us=new Usuario(nombre,email,password,0);
		
		if(this._ctrl.modificaUsuario(us)) {
			JOptionPane.showMessageDialog(this, "Modificacion correcta" );
			status(false);
		}else JOptionPane.showMessageDialog(this, "Error compruebe los campos" );
		
	}
	
	
	private void status(boolean stado) {
		textFNombre.setEnabled(stado);
		textFPassword.setEnabled(stado);
		btnmodificaruser.setEnabled(stado);
		btnBuscarUser.setEnabled(!stado);
		lblNombre.setEnabled(stado);
		lblPassword.setEnabled(stado);
		
	}
	

}
