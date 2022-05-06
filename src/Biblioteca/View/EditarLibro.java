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

public class EditarLibro extends JPanel {
	private static final long serialVersionUID = 1L;
	private Controller _ctrl;
	private JLabel isbn = new JLabel("ISBN");
	private JLabel titulo = new JLabel("Titulo");
	private JLabel autor = new JLabel("Autor");
	private JLabel editorial = new JLabel("Editorial");
	private JTextField isbn_field = new JTextField();
	private JTextField titulo_field = new JTextField();
	private JTextField autor_field = new JTextField();
	private JTextField editorial_field = new JTextField();
	private JButton ok_button = new JButton("Ok");
	private JButton cancel_button = new JButton("Cancel");
	private JButton buscar = new JButton("Buscar");

	public EditarLibro(Controller ctrl) {
		setBackground(Color.WHITE);
		this._ctrl = ctrl;
		this.setPreferredSize(new Dimension(412, 308));
		//JPanel mainPanel = new JPanel();
		//mainPanel.setLayout(null);

		// Componentes visuales
		isbn.setBounds(34, 62, 50, 13);
		isbn_field.setBounds(119, 59, 142, 19);
		titulo.setBounds(34, 129, 37, 13);
		titulo_field.setBounds(140, 126, 142, 19);
		autor.setBounds(34, 183, 37, 13);
		autor_field.setBounds(140, 180, 142, 19);
		editorial.setBounds(34, 233, 62, 13);
		editorial_field.setBounds(140, 230, 131, 19);

		// Buttons
		ok_button.setBounds(75, 269, 62, 21);
		ok_button.setForeground(Color.WHITE);
		ok_button.setBackground(Color.BLACK);
		ok_button.setFocusPainted(false);
		ok_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int autor_id = Integer.parseInt(autor_field.getText());
				if (_ctrl.modificarLibro(isbn_field.getText(), titulo_field.getText(), autor_id,
						editorial_field.getText(), true)) {
					JFrame jFrame = new JFrame();
					JOptionPane.showMessageDialog(jFrame, "Se ha a�adido correctamente");
					//EditarLibro.this.dispose();
				} else {
					JFrame jFrame = new JFrame();
					JOptionPane.showMessageDialog(jFrame, "Ha habido un error");
					//EditarLibro.this.dispose();
				}
			}

		});

		cancel_button.setBounds(164, 269, 97, 21);
		cancel_button.setForeground(Color.WHITE);
		cancel_button.setBackground(Color.BLACK);
		cancel_button.setFocusPainted(false);
		cancel_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//EditarLibro.this.dispose();
			}
		});
		buscar.setBounds(298, 58, 74, 21);
		buscar.setForeground(Color.WHITE);
		buscar.setBackground(Color.BLACK);
		buscar.setFocusPainted(false);
		buscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				visible(true);
				String s = _ctrl.existeLibro(isbn_field.getText());

				if (s != null) {
					JFrame jFrame = new JFrame();
					JOptionPane.showMessageDialog(jFrame, s);

				} else {
					JFrame jFrame = new JFrame();
					JOptionPane.showMessageDialog(jFrame, "ERROR:No existe este libro");
				}
			}

		});
		visible(false);
		setLayout(null);
		add(isbn);
		add(isbn_field);
		add(buscar);
		add(titulo);
		add(titulo_field);
		add(autor);
		add(autor_field);
		add(editorial);
		add(editorial_field);
		add(ok_button);
		add(cancel_button);

		this.setVisible(true);
		//this.add(mainPanel);
		//this.pack();
		//this.setResizable(false);
	}

	public void visible(boolean a) {
		titulo.setVisible(a);
		titulo_field.setVisible(a);
		autor.setVisible(a);
		autor_field.setVisible(a);
		editorial.setVisible(a);
		editorial_field.setVisible(a);
		ok_button.setVisible(a);
		cancel_button.setVisible(a);
	}
}
