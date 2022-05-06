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

	public class EditarPelicula extends JPanel{
		private static final long serialVersionUID = 1L;
		private Controller _ctrl;
		private JLabel isbn = new JLabel("ISBN");
		private JLabel titulo = new JLabel("Titulo");
		private JLabel duracion = new JLabel("Duraci�n");
		private JLabel categoria = new JLabel("Categoria");
		private JTextField isbn_field = new JTextField();
		private JTextField titulo_field = new JTextField();
		private JTextField duracion_field = new JTextField();
		private JTextField categoria_field = new JTextField();
		private JButton ok_button = new JButton("Ok");
		private JButton cancel_button = new JButton("Cancel");
		private JButton buscar=new JButton ("Buscar");
		

		public EditarPelicula(Controller ctrl) {
			this._ctrl = ctrl;
			//this.setPreferredSize(new Dimension(400, 300));
			//JPanel mainPanel = new JPanel();
			//mainPanel.setLayout(null);
			
			ok_button.setBounds(100, 190, 80, 28);
			ok_button.setForeground(Color.WHITE);
			ok_button.setBackground(Color.BLACK);
			ok_button.setFocusPainted(false);
			ok_button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					int duracion=Integer.parseInt(duracion_field.getText());
					if(_ctrl.editarPelicula(isbn_field.getText(), titulo_field.getText(), duracion, categoria_field.getText(), true)) {
						 JFrame jFrame = new JFrame();
						 JOptionPane.showMessageDialog(jFrame, "Se ha editado correctamente");
						 //EditarPelicula.this.dispose();
					}else {
						JFrame jFrame = new JFrame();
						 JOptionPane.showMessageDialog(jFrame, "Ha habido un error");
						 //EditarPelicula.this.dispose();
					}
				}
				
			});
			cancel_button.setBounds(200, 190, 80, 28);
			cancel_button.setForeground(Color.WHITE);
			cancel_button.setBackground(Color.BLACK);
			cancel_button.setFocusPainted(false);
			cancel_button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//EditarPelicula.this.dispose();
				}		
			});
			buscar.setBounds(266, 25, 80, 28);
			buscar.setForeground(Color.WHITE);
			buscar.setBackground(Color.BLACK);
			buscar.setFocusPainted(false);
			buscar.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String s= _ctrl.existePelicula(isbn_field.getText());
					if(s!=null) {
						
						JFrame jFrame = new JFrame();
						 JOptionPane.showMessageDialog(jFrame, s);
						 visible(true);
						
					}else {
						JFrame jFrame = new JFrame();
						 JOptionPane.showMessageDialog(jFrame, "ERROR:No existe esta pelicula");
					}
					
				}
				
			});
			visible(false);
			this.setLayout(null);
			isbn.setBounds(50, 25, 70, 20);
			this.add(isbn);	
			isbn_field.setBounds(115, 25, 150, 28);
			this.add(isbn_field);
			this.add(buscar);
			titulo.setBounds(50, 65, 70, 20);
			this.add(titulo);
			titulo_field.setBounds(115, 65, 193, 28);
			this.add(titulo_field);
			duracion.setBounds(50, 105, 70, 20);
			this.add(duracion);
			duracion_field.setBounds(115, 105, 193, 28);
			this.add(duracion_field);
			categoria.setBounds(30, 150, 120, 20);
			this.add(categoria);
			categoria_field.setBounds(115, 150, 193, 28);
			this.add(categoria_field);
			this.add(ok_button);
			this.add(cancel_button);
			
			this.setVisible(true);
			//this.add(mainPanel);
			//this.pack();
			//this.setResizable(false);
		}
		public void visible(boolean a ) {
			titulo.setVisible(a);
			titulo_field.setVisible(a);
			duracion.setVisible(a);
			duracion_field.setVisible(a);
			categoria.setVisible(a);
			categoria_field.setVisible(a);
			ok_button.setVisible(a);
			cancel_button.setVisible(a);
		}
			
	}


