package Biblioteca.View;

import java.awt.Dimension;

import javax.swing.JFrame;

import Biblioteca.Control.Controller;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	protected Controller _ctrl;

	// Constructor de la Ventana principal, que crea la ventana y llama a initGUI
	public MainWindow(Controller controlador) {
		super("Biblioteca");
		_ctrl = controlador;
		initGUI();
	}

	private void initGUI() {
		// Panel de inicio de sesion
		this.setContentPane(new loginPanel(_ctrl));

		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(new Dimension(400, 250));
		this.setLocationRelativeTo(null);
	}

}
