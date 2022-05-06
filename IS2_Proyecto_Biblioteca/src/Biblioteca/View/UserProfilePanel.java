package Biblioteca.View;

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

import Biblioteca.Control.Controller;
import Biblioteca.Model.Usuario;

@SuppressWarnings("serial")
public class UserProfilePanel extends JDialog {

	private Usuario usuario;
	private Controller _ctrl;
	private JTextField username;
	private JTextField email;
	private JTextField password;
	private JLabel fecha_creacion;
	private JLabel informacion_usuario = new JLabel("Informacion del Usuario");
	private JLabel username_label = new JLabel("username");
	private JLabel email_label = new JLabel("email");
	private JLabel password_label = new JLabel("password");
	private JButton saveButton;
	private JButton cancelButton;

	public UserProfilePanel(Usuario usuario, Controller ctrl) {
		this._ctrl = ctrl;
		this.usuario = usuario;
		initGUI();
	}

	private void initGUI() {
		this.setName("Perfil de Usuario");
		JPanel mainPanel = new JPanel();
		this.setContentPane(mainPanel);
		mainPanel.setLayout(null);
		this.setPreferredSize(new Dimension(300, 400));

		this.username = new JTextField(usuario.getName());
		this.email = new JTextField(usuario.getEmail());
		this.password = new JTextField(usuario.getPassword());
		this.fecha_creacion = new JLabel("Creada en " + usuario.getFechaCreacion());

		this.saveButton = new JButton("Guardar");
		this.saveButton.setFocusable(false);
		this.saveButton.setBounds(20, 250, 100, 30);
		this.saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (cambiarPerfil())
					dispose();

			}

		});

		this.cancelButton = new JButton("Cancelar");
		this.cancelButton.setFocusable(false);
		this.cancelButton.setBounds(130, 250, 100, 30);
		this.cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}

		});

		this.informacion_usuario.setBounds(20, 15, 150, 30);
		this.username_label.setBounds(20, 50, 150, 30);
		this.username.setBounds(100, 50, 150, 30);
		this.email_label.setBounds(20, 100, 150, 30);
		this.email.setBounds(100, 100, 150, 30);
		this.password_label.setBounds(20, 150, 150, 30);
		this.password.setBounds(100, 150, 150, 30);
		this.fecha_creacion.setBounds(100, 320, 200, 20);

		mainPanel.add(username_label);
		mainPanel.add(email_label);
		mainPanel.add(password_label);
		mainPanel.add(informacion_usuario);
		mainPanel.add(username);
		mainPanel.add(email);
		mainPanel.add(password);
		mainPanel.add(fecha_creacion);
		mainPanel.add(saveButton);
		mainPanel.add(cancelButton);

		this.pack();
		this.setResizable(false);
		this.setLayout(null);
		this.setVisible(true);
		this.setLocationRelativeTo(getParent());
	}

	public boolean cambiarPerfil() {

		if (username.getText().isEmpty() || email.getText().isEmpty() || password.getText().isEmpty()) {
			JOptionPane.showMessageDialog(getParent(), "Por favor, rellena los campos antes de Guardar",
					"Error Registro", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (!isEmail(email.getText())) {
			JOptionPane.showMessageDialog(getParent(), "El formato del Correo no es Correcto!",
					"Error Registro", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (!usuario.getEmail().equals(email.getText()) && _ctrl.existeEmail(email.getText())) {
			JOptionPane.showMessageDialog(getParent(), "Ya existe un Usuario con ese correo registrado",
					"Error Registro", JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			if (!usuario.getName().equals(username.getText())) {
				usuario.setName(username.getText());
			}

			if (!usuario.getPassword().equals(password.getText())) {
				usuario.setPassword(password.getText());
			}

			usuario.setEmail(email.getText());
			JOptionPane.showMessageDialog(getParent(), "Datos actualizados correctamente","Mensaje" ,JOptionPane.PLAIN_MESSAGE);
			return true;
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
