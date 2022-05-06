package Biblioteca.View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Biblioteca.Control.Controller;
import Biblioteca.Model.Usuario;

public class loginPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Controller _ctrl;

	// Componentes Visuales
	private JLabel email = new JLabel("Email");
	private JLabel password = new JLabel("Password");
	private JTextField email_field = new JTextField();
	private JPasswordField password_field = new JPasswordField();
	private JButton login_button = new JButton("Login");
	private JButton sign_in_button = new JButton("Sign-up");
	private JButton guest_button = new JButton("Guest");

	public loginPanel(Controller controller) {
		this._ctrl = controller;
		initGUI();
	}

	private void initGUI() {
		this.setLayout(null);
		this.add(email);
		this.add(email_field);
		this.add(password);
		this.add(password_field);

		email.setBounds(100, 8, 70, 20);
		email_field.setBounds(100, 27, 193, 28);
		email_field.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char a = e.getKeyChar();
				if (a == KeyEvent.VK_ENTER) {
					login_button.doClick();
				}
			}
		});
		password.setBounds(100, 67, 70, 20);
		password_field.setBounds(100, 87, 193, 28);

		password_field.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char a = e.getKeyChar();
				if (a == KeyEvent.VK_ENTER) {
					login_button.doClick();
				}
			}
		});

		// Boton de iniciar sesi�n
		login_button.setBounds(60, 130, 80, 28);
		login_button.setForeground(Color.WHITE);
		login_button.setBackground(Color.BLACK);
		login_button.setFocusPainted(false);
		login_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				inicioSesion();
			}

		});
		this.add(login_button);

		// Boton de registrar nueva cuenta
		sign_in_button.setBounds(150, 130, 80, 28);
		sign_in_button.setForeground(Color.WHITE);
		sign_in_button.setBackground(Color.BLACK);
		sign_in_button.setFocusPainted(false);
		sign_in_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				registrarUsuario();
			}
		});
		this.add(sign_in_button);

		// Boton de inicio como invitado
		guest_button.setBounds(240, 130, 80, 28);
		guest_button.setForeground(Color.WHITE);
		guest_button.setBackground(Color.BLACK);
		guest_button.setFocusPainted(false);
		guest_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vistaInvitado();
			}
		});
		this.add(guest_button);

	}

	public void inicioSesion() {

		String email = email_field.getText();
		String password = String.valueOf(password_field.getPassword());
		Usuario user = this._ctrl.iniciarSesion(email, password);

		if (!this._ctrl.existeUsuario(email)) {
			JOptionPane.showMessageDialog(this, "No match was found with that Email!");
		} else if (user != null) {
			// Cierra la ventana de login si los datos del usuario son correctos
			SwingUtilities.getWindowAncestor(this).dispose();
			if (this._ctrl.esAdmin(email)) {
				AdminPanel jadmin = new AdminPanel(_ctrl);
				SwingUtilities.getWindowAncestor(this).dispose();
			} else {
				UserPanel userPanel = new UserPanel(user, this._ctrl);
			}

		} else {
			JOptionPane.showMessageDialog(this, "Incorrect Password!");
		}
	}

	private void vistaInvitado() {
		UserPanel userPanel = new UserPanel(null, _ctrl);
		SwingUtilities.getWindowAncestor(this).dispose();
	}

	public void registrarUsuario() {
		RegisterPanel registerDialog = new RegisterPanel(this._ctrl);
		registerDialog.setLocationRelativeTo(null);
	}

}
