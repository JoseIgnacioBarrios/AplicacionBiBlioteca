package Biblioteca.View;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Biblioteca.Control.Controller;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class AdminPanel extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Controller _ctrl;
	private JMenuBar JmenuBar = new JMenuBar();
	private JMenu jNewMenuModificaciones = new JMenu("Modificaciones");
	private JMenuItem btnModPelicula = new JMenuItem("Modificar Pelicula");
	private JMenuItem btnModUsuario = new JMenuItem("Modificar Usuario");
	private JMenuItem btnModLibro = new JMenuItem("Modificar    Libro");
	private JMenu jNewMenuInsertar = new JMenu("  Insertar  ");
	private JMenuItem btnInsLibro = new JMenuItem("Nuevo     Libro");
	private JMenuItem btnInsPelicula = new JMenuItem("Nueva Pelicula");
	private JMenuItem btnInsUsuario = new JMenuItem("Nuevo Usuario");
	private JMenu jNewMenuElimar = new JMenu("Eliminar");
	private JMenuItem btnEliUsuario = new JMenuItem("Eliminar Usuario");
	private JMenuItem btnEliLibro = new JMenuItem("Eliminar Libro");
	private JMenuItem btnEliPeli = new JMenuItem("Eliminar Pelicula");
	private JPanel panel = new JPanel();
	private AdminModUser modUser;
	private AdminInsUser insUser;
	private AdminRmvUser remUser;
	private EditarPelicula modPeli;
	private EditarLibro editarLibro;
	private AnadirLibro insertLibro;
	private EliminarLibro deleteLibro;
	private EliminarPelicula deletePeli;

	/**
	 * public static void main(String[] args) { try { JDialogAdmin dialog = new
	 * JDialogAdmin(); dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } /**
	 * /** Create the dialog.
	 */
	public AdminPanel(Controller _ctrl) {
		getContentPane().setBackground(Color.WHITE);
		this._ctrl = _ctrl;
		initGUI();

	}

	private void initGUI() {
		setBounds(100, 100, 890, 577);
		getContentPane().setLayout(null);
		this.setVisible(true);
		

		// MODIFICAMOS jBAR Y MENUS
		JmenuBar.setMargin(new Insets(4, 0, 0, 0));
		JmenuBar.setBackground(Color.WHITE);
		JmenuBar.setBounds(0, 0, 876, 44);
		JmenuBar.setBorderPainted(false);
		btnModPelicula.setVerticalAlignment(SwingConstants.BOTTOM);

		// MODIFICAR EL COLOR DE LOS BOTONES
		btnModPelicula.setForeground(Color.WHITE);
		btnModPelicula.setBackground(Color.BLACK);
		btnModUsuario.setVerticalAlignment(SwingConstants.BOTTOM);

		btnModUsuario.setForeground(Color.WHITE);
		btnModUsuario.setBackground(Color.BLACK);

		btnModLibro.setForeground(Color.WHITE);
		btnModLibro.setBackground(Color.BLACK);

		btnInsLibro.setForeground(Color.WHITE);
		btnInsLibro.setBackground(Color.BLACK);

		btnInsPelicula.setForeground(Color.WHITE);
		btnInsPelicula.setBackground(Color.BLACK);

		btnInsUsuario.setForeground(Color.WHITE);
		btnInsUsuario.setBackground(Color.BLACK);

		btnEliUsuario.setForeground(Color.WHITE);
		btnEliUsuario.setBackground(Color.BLACK);
		
		btnEliLibro.setForeground(Color.WHITE);
		btnEliLibro.setBackground(Color.BLACK);
		
		btnEliPeli.setForeground(Color.WHITE);
		btnEliPeli.setBackground(Color.BLACK);
		
		//ICON IMAGENES
		ImageIcon iconMod=new ImageIcon("Image Icons/mod.png");
		jNewMenuModificaciones.setIcon(iconMod);
		
		ImageIcon iconEli=new ImageIcon("Image Icons/eliminar.png");
		jNewMenuElimar.setIcon(iconEli);
		
		ImageIcon iconIns=new ImageIcon("Image Icons/insert.png");
		jNewMenuInsertar.setIcon(iconIns);
		
		jNewMenuModificaciones.setBackground(Color.WHITE);
		jNewMenuModificaciones.setForeground(Color.BLACK);

		jNewMenuModificaciones.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jNewMenuModificaciones.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		jNewMenuInsertar.setForeground(Color.BLACK);

		jNewMenuInsertar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jNewMenuInsertar.setBorder(new LineBorder(Color.BLACK, 2, true));
		jNewMenuElimar.setForeground(Color.BLACK);

		jNewMenuElimar.setBorder(new LineBorder(Color.BLACK, 2, true));

		// AGREGARMOS BOTTONES A MENU MODIFICACIONES
		
		jNewMenuModificaciones.add(btnModPelicula);
		jNewMenuModificaciones.add(btnModUsuario);
		jNewMenuModificaciones.add(btnModLibro);

		// AGREGAMOS BOTONES AL MENU INSERTAR
		jNewMenuInsertar.add(btnInsUsuario);
		jNewMenuInsertar.add(btnInsLibro);
		jNewMenuInsertar.add(btnInsPelicula);
		// AGREGAMOS BOTONES A MENU ELIMINAR
		jNewMenuElimar.add(btnEliUsuario);
		jNewMenuElimar.add(btnEliLibro);
		jNewMenuElimar.add(btnEliPeli);

		// AGREGAMOS A JBAR UN MENU DE MODIFICACIONES o BOx PARA LOS ESPACIOS

		JmenuBar.add(jNewMenuModificaciones);
		JmenuBar.add(jNewMenuInsertar);
		JmenuBar.add(jNewMenuElimar);
		// AGREGAMOS AL CONTENEDOR PRINCIPAL
		getContentPane().add(JmenuBar);
		panel.setBackground(Color.WHITE);

		panel.setBounds(170, 101, 685, 406);
		getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("BIBLIOTECA");
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 40));
		lblNewLabel.setBounds(10, 54, 330, 37);
		getContentPane().add(lblNewLabel);

		// EVENTOS DE BOTONES
		// BOTON MODIFICAR
		btnModUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarUsuario();
			}
		});

		// BOTON INSERTAR
		btnInsUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarUsuario();
			}
		});

		// BOTON ELIMINAR
		btnEliUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteUser();
			}
		});
		
		btnModPelicula.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				modPelicula();
			}
			
		});
		btnInsPelicula.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				anadirP();
			}
			
		});
		btnModLibro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				editarlibro();
			}
			
		});
		btnInsLibro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				insertLibro();
			}
		});
		btnEliLibro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				deleteLibro();
			}
		});
		btnEliPeli.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				deletePeli();
			}
		});
		
		

	}
	

	public void modificarUsuario() {
		modUser = new AdminModUser(_ctrl);
		nuevoPanel(modUser);
	}

	public void insertarUsuario() {
		insUser = new AdminInsUser(_ctrl);
		nuevoPanel(insUser);
	}

	public void deleteUser() {
		remUser = new AdminRmvUser(_ctrl);
		nuevoPanel(remUser);
	}
	public void modPelicula() {
		modPeli =new EditarPelicula(_ctrl);
		//e.setLocationRelativeTo(null);
		nuevoPanel(modPeli);
	}
	public void anadirP() {
		AnadirPelicula a =new AnadirPelicula(_ctrl);
		nuevoPanel(a);
	}
	public void deletePeli() {
		deletePeli = new EliminarPelicula(_ctrl);
		nuevoPanel(deletePeli);
	}
	public void editarlibro() {
		editarLibro=new EditarLibro(_ctrl);
		nuevoPanel(editarLibro);
	}
	public void insertLibro() {
		insertLibro=new AnadirLibro(_ctrl);
		nuevoPanel(insertLibro);
	}
	public void deleteLibro() {
		deleteLibro=new EliminarLibro(_ctrl);
		nuevoPanel(deleteLibro);
	}
	public void nuevoPanel(JPanel panelActual) {
		panel.removeAll();
		panel.add(panelActual);
		panel.repaint();
		panel.revalidate();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
