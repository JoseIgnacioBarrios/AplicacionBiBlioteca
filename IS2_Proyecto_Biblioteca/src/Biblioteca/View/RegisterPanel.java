package Biblioteca.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Biblioteca.Control.Controller;

public class RegisterPanel extends JDialog {

	private static final long serialVersionUID = 1L;
	private Controller _ctrl;
	private JLabel email = new JLabel("Email");
	private JLabel username = new JLabel("Username");
	private JLabel password = new JLabel("Password");
	private JLabel confirmation = new JLabel("Confirm Password");
	private JTextField email_field = new JTextField();
	private JTextField username_field = new JTextField();
	private JTextField password_field = new JTextField();
	private JTextField confirmation_field = new JTextField();
	private JButton ok_button = new JButton("Ok");
	private JButton cancel_button = new JButton("Cancel");

	public RegisterPanel(Controller _ctrl) {
		this._ctrl = _ctrl;
		initGUI();
	}

	private void initGUI() {
		this.setPreferredSize(new Dimension(400, 300));
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);

		// Componentes visuales
		username.setBounds(50, 25, 70, 20);
		username_field.setBounds(115, 25, 193, 28);
		email.setBounds(50, 65, 70, 20);
		email_field.setBounds(115, 65, 193, 28);
		password.setBounds(50, 105, 70, 20);
		password_field.setBounds(115, 105, 193, 28);
		confirmation.setBounds(30, 150, 120, 20);
		confirmation_field.setBounds(145, 150, 193, 28);

		// Buttons
		ok_button.setBounds(100, 190, 80, 28);
		ok_button.setForeground(Color.WHITE);
		ok_button.setBackground(Color.BLACK);
		ok_button.setFocusPainted(false);
		ok_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				crearUsuario();
			}

		});

		cancel_button.setBounds(200, 190, 80, 28);
		cancel_button.setForeground(Color.WHITE);
		cancel_button.setBackground(Color.BLACK);
		cancel_button.setFocusPainted(false);
		cancel_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RegisterPanel.this.dispose();
			}
		});

		mainPanel.add(username);
		mainPanel.add(username_field);
		mainPanel.add(email);
		mainPanel.add(email_field);
		mainPanel.add(password);
		mainPanel.add(password_field);
		mainPanel.add(confirmation);
		mainPanel.add(confirmation_field);
		mainPanel.add(ok_button);
		mainPanel.add(cancel_button);

		this.setVisible(true);
		this.add(mainPanel);
		this.pack();
		this.setResizable(false);
	}

	private void crearUsuario() {
		if (!password_field.getText().equals(confirmation_field.getText())) {
			JOptionPane.showMessageDialog(this, "passwords don't match", "Error", JOptionPane.ERROR_MESSAGE);
		} else if (!username_field.getText().isEmpty() && !email_field.getText().isEmpty()
				&& !password_field.getText().isEmpty()) {
			if (isEmail(email_field.getText()) && this._ctrl.registrarUsuario(username_field.getText(),
					email_field.getText(), password_field.getText())) {
				JOptionPane.showMessageDialog(this, "User Registered Successfully!", "Info", JOptionPane.PLAIN_MESSAGE);
				RegisterPanel.this.dispose();
			} else if (!isEmail(email_field.getText())) {
				JOptionPane.showMessageDialog(this, "The Email format is not correct!", "Wrong Email",
						JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Email already in Use!", "Info", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public boolean isEmail(String correo) {
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		Matcher mather = pattern.matcher(correo);

		if (mather.find()) {
			return true;
		} else {
			return false;
		}

	}
}
