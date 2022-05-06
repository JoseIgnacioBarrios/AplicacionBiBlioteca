package Biblioteca.View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Biblioteca.Control.Controller;
import Biblioteca.Model.Usuario;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Font;
import javax.swing.JPasswordField;

public class AdminInsUser extends JPanel {
	private JTextField textFcorreo;
	private JTextField textFnombre;
	private Controller _ctrl;
	private JLabel lblmsgExisteCorreo;
	private JLabel lblcorreoCorrecto;
	private JLabel lblEscritoCorreo;
	private JPasswordField passwordFpass;

	/**
	 * Create the panel.
	 */
	public AdminInsUser(Controller _ctrl) {
		setBackground(Color.WHITE);
		this._ctrl=_ctrl;
		setLayout(null);
		
		JLabel lblcorreo = new JLabel("Correo :");
		lblcorreo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblcorreo.setBounds(37, 74, 69, 13);
		add(lblcorreo);
		
		textFcorreo = new JTextField();
		textFcorreo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!textFcorreo.getText().isEmpty()) {
					if(isEmail(textFcorreo.getText())){
						if (_ctrl.existeUsuario(textFcorreo.getText())) {
							lblmsgExisteCorreo.setVisible(true);
						}
						else {
							lblcorreoCorrecto.setVisible(true);
						}
					}
					else {
						lblEscritoCorreo.setVisible(true);
					}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				lblcorreoCorrecto.setVisible(false);
				lblmsgExisteCorreo.setVisible(false);
				lblEscritoCorreo.setVisible(false);
			}
		});
		
		
		textFcorreo.setBounds(125, 71, 149, 19);
		add(textFcorreo);
		textFcorreo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(37, 123, 69, 13);
		add(lblNombre);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(37, 175, 78, 13);
		add(lblPassword);
		
		textFnombre = new JTextField();
		textFnombre.setBounds(125, 120, 96, 19);
		add(textFnombre);
		textFnombre.setColumns(10);
		
		JButton btnNewButton = new JButton("Crear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearUser();
			}
		});
		btnNewButton.setBounds(30, 227, 85, 21);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		add(btnNewButton);
		
		 lblmsgExisteCorreo = new JLabel("@Correo Existe");
		 lblmsgExisteCorreo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblmsgExisteCorreo.setForeground(Color.RED);
		lblmsgExisteCorreo.setBounds(286, 74, 125, 19);
		lblmsgExisteCorreo.setVisible(false);
		add(lblmsgExisteCorreo);
		
		 lblcorreoCorrecto = new JLabel("@Correo Correcto");
		 lblcorreoCorrecto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblcorreoCorrecto.setForeground(Color.GREEN);
		lblcorreoCorrecto.setBounds(286, 74, 107, 19);
		lblcorreoCorrecto.setVisible(false);
		add(lblcorreoCorrecto);
		
		lblEscritoCorreo = new JLabel("@Correo mal Escrito");
		lblEscritoCorreo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEscritoCorreo.setForeground(Color.MAGENTA);
		lblEscritoCorreo.setBounds(284, 74, 127, 19);
		lblEscritoCorreo.setVisible(false);
		add(lblEscritoCorreo);
		
		passwordFpass = new JPasswordField();
		passwordFpass.setBounds(126, 175, 107, 19);
		add(passwordFpass);

	}
	public boolean isEmail(String correo) {
		Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
 
        Matcher mather = pattern.matcher(correo);
 
        if (mather.find() == true) {	return true;
		}else {
			return false;
		}
	
	}
	public void crearUser() {
		String email=textFcorreo.getText();
		String nombre=textFnombre.getText();
		
		String password="";
		char [] pass = passwordFpass.getPassword();
		for(int x=0;x<pass.length;x++) {
			password+=pass[x];
		}
		if (!_ctrl.existeUsuario(email) && _ctrl.registrarUsuario(nombre, email, password)) {
			JOptionPane.showMessageDialog(this, "Usuario Creado" );
		}
		
		
		
	}
}
