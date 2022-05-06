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

	public class AnadirLibro extends JPanel{
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

		public AnadirLibro(Controller ctrl) {
			setBackground(Color.WHITE);
			this._ctrl = ctrl;
			this.setPreferredSize(new Dimension(614, 377));
			isbn.setForeground(Color.BLACK);
			isbn.setFont(new Font("Tahoma", Font.PLAIN, 14));
			//JPanel mainPanel = new JPanel();
			//mainPanel.setLayout(null);
			
			// Componentes visuales
			isbn.setBounds(59, 58, 58, 13);
			isbn_field.setBounds(202, 57, 147, 19);
			titulo.setForeground(Color.BLACK);
			titulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			titulo.setBounds(53, 98, 64, 13);
			titulo_field.setBounds(202, 97, 147, 19);
			autor.setForeground(Color.BLACK);
			autor.setFont(new Font("Tahoma", Font.PLAIN, 14));
			autor.setBounds(59, 140, 104, 13);
			autor_field.setBounds(202, 139, 147, 19);
			editorial.setForeground(Color.BLACK);
			editorial.setFont(new Font("Tahoma", Font.PLAIN, 14));
			editorial.setBounds(59, 199, 104, 13 );
			editorial_field.setBounds(202, 198 , 147, 19);
			
			// Buttons
			ok_button.setBounds(96, 254, 58, 21);
			ok_button.setForeground(Color.WHITE);
			ok_button.setBackground(Color.BLACK);
			ok_button.setFocusPainted(false);
			ok_button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					 JFrame jFrame = new JFrame();
					 JOptionPane.showMessageDialog(jFrame, "Se ha a�adido correctamente");
					 //AnadirLibro.this.dispose();
					int autor_id=Integer.parseInt(autor_field.getText());
					if(_ctrl.crearLibro(isbn_field.getText(), titulo_field.getText(), autor_id, editorial_field.getText(), true)) {
						
						
					}else {
						//JFrame jFrame = new JFrame();
						 JOptionPane.showMessageDialog(jFrame, "Ha habido un error");
						 //AnadirLibro.this.dispose();
					}
				}
				
			});
			
			cancel_button.setBounds(183, 254, 91, 21);
			cancel_button.setForeground(Color.WHITE);
			cancel_button.setBackground(Color.BLACK);
			cancel_button.setFocusPainted(false);
			cancel_button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//AnadirLibro.this.dispose();
				}		
			});
			setLayout(null);
			
			add(isbn);	
			add(isbn_field);
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
	}


