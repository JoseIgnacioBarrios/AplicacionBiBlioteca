package Biblioteca.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Biblioteca.Control.Controller;
import java.awt.Font;

public class AnadirPelicula extends JPanel {
	private static final long serialVersionUID = 1L;
	private Controller _ctrl;
	private JLabel isbn = new JLabel("ISBN");
	private JLabel titulo = new JLabel("Titulo");
	private JLabel duracion = new JLabel("Duracion");
	private JLabel categoria = new JLabel("Categoria");
	private JTextField isbn_field = new JTextField();
	private JTextField titulo_field = new JTextField();
	private JTextField duracion_field = new JTextField();
	private JTextField categoria_field = new JTextField();
	private JButton ok_button = new JButton("Ok");
	private JButton cancel_button = new JButton("Cancel");

	public AnadirPelicula(Controller ctrl) {
		setBackground(Color.WHITE);
		this._ctrl = ctrl;
		ok_button.setBounds(106, 269, 62, 21);
		ok_button.setForeground(Color.WHITE);
		ok_button.setBackground(Color.BLACK);
		ok_button.setFocusPainted(false);
		ok_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int duracion = Integer.parseInt(duracion_field.getText());
				if (_ctrl.crearPelicula(isbn_field.getText(), titulo_field.getText(), duracion,
						categoria_field.getText(), true)) {
					JFrame jFrame = new JFrame();
					JOptionPane.showMessageDialog(jFrame, "Se ha anadido correctamente");
				} else {
					JFrame jFrame = new JFrame();
					JOptionPane.showMessageDialog(jFrame, "Ha habido un error");
				}
			}

		});
		cancel_button.setBounds(214, 269, 82, 21);
		cancel_button.setForeground(Color.WHITE);
		cancel_button.setBackground(Color.BLACK);
		cancel_button.setFocusPainted(false);
		cancel_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		setLayout(null);
		isbn.setForeground(Color.BLACK);
		isbn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		isbn.setBounds(40, 33, 67, 13);

		this.add(isbn);
		isbn_field.setBounds(146, 30, 192, 19);
		this.add(isbn_field);
		titulo.setForeground(Color.BLACK);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		titulo.setBounds(40, 100, 62, 13);
		this.add(titulo);
		titulo_field.setBounds(146, 99, 192, 19);
		this.add(titulo_field);
		duracion.setForeground(Color.BLACK);
		duracion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		duracion.setBounds(40, 153, 96, 13);
		this.add(duracion);
		duracion_field.setBounds(146, 152, 192, 19);
		this.add(duracion_field);
		categoria.setForeground(Color.BLACK);
		categoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		categoria.setBounds(40, 202, 96, 13);
		this.add(categoria);
		categoria_field.setBounds(146, 199, 192, 19);
		this.add(categoria_field);
		this.add(ok_button);
		this.add(cancel_button);
		
		this.setVisible(true);
		
	}
}
