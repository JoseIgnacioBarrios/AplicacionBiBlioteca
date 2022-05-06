package Biblioteca.View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import Biblioteca.Control.Controller;
import Biblioteca.Model.Libro;
import Biblioteca.Model.Pelicula;
import Biblioteca.Model.PrestamoLibro;
import Biblioteca.Model.PrestamoPelicula;
import Biblioteca.Model.Usuario;

public class UserPanel extends JDialog {

	private static final long serialVersionUID = 1L;
	private Controller _ctrl;
	private Usuario usuario;
	private JLabel title = new JLabel();
	private JLabel username_label = new JLabel();
	private JLabel search_icon = new JLabel();
	private JTextField searchBar = new JTextField();
	private JButton searchButton = new JButton("Buscar");
	private JButton loanButton = new JButton("Realizar Prestamo");
	private JButton profileButton = new JButton("perfil");
	private JButton exitButton = new JButton("salir");
	private DefaultTableModel modelo_libro;
	private DefaultTableModel modelo_pelicula;
	private DefaultTableModel modelo_prestamo;
	private JTable tabla_libro = new JTable();
	private JTable tabla_pelicula = new JTable();
	private JTable tabla_prestamo = new JTable();
	private JScrollPane scroll_prestamo;
	private JScrollPane scroll_libro;
	private JScrollPane scroll_pelicula;
	private JLabel currentTime = new JLabel();

	UserPanel(Usuario usuario, Controller _ctrl) {
		this._ctrl = _ctrl;
		this.usuario = usuario;
		initGUI();
	}

	@SuppressWarnings("serial")
	private void initGUI() {
		// Configuracion general del panel de usuario
		this.setPreferredSize(new Dimension(890, 577));
		this.setLayout(new BorderLayout());

		// Configuracion del panel superior siguiente el formato BorderLayout
		JPanel upperPanel = new JPanel();
		upperPanel.setPreferredSize(new Dimension(890, 100));
		upperPanel.setLayout(null);

		// Configuracion del titulo
		ImageIcon book_icon = new ImageIcon(
				new ImageIcon("Image Icons/book.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		this.title.setIcon(book_icon);
		this.title.setHorizontalTextPosition(JLabel.RIGHT);
		this.title.setBounds(50, 25, 400, 50);
		this.title.setFont(new Font("MV Boli", Font.BOLD, 40));
		this.title.setText("BIBLIOTECA");
		this.title.setIconTextGap(15);

		// Configuracion del Label del nombre de usuario
		this.username_label.setBounds(750, 50, 100, 50);
		this.username_label.setFont(new Font(username_label.getName(), Font.PLAIN, 20));
		upperPanel.add(title);
		upperPanel.add(username_label);
		upperPanel.setVisible(true);

		if (this.usuario != null) {
			username_label.setText(usuario.getName());
		} else {
			username_label.setText("Guest");
		}

		// Configuracion del panel central
		JPanel centralPanel = new JPanel();
		centralPanel.setLayout(null);

		// Configuracion de la barra de busqueda
		ImageIcon icono_busqueda = new ImageIcon(
				new ImageIcon("Image Icons/search.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		this.search_icon.setIcon(icono_busqueda);
		this.search_icon.setBounds(20, 20, 30, 30);
		this.searchBar.setBounds(60, 20, 300, 30);
		this.searchButton.setBounds(370, 20, 80, 30);
		this.searchButton.setFocusable(false);

		this.searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				buscar();
			}

		});

		// Configuracion de las tablas de busquedas
		this.modelo_libro = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};

		this.modelo_pelicula = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};

		this.modelo_prestamo = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};

		modelo_libro.addColumn("ISBN");
		modelo_libro.addColumn("titulo");
		modelo_libro.addColumn("autor");
		modelo_libro.addColumn("editorial");
		modelo_libro.addColumn("disponibilidad");

		modelo_pelicula.addColumn("ISAN");
		modelo_pelicula.addColumn("titulo");
		modelo_pelicula.addColumn("categoria");
		modelo_pelicula.addColumn("duracion");
		modelo_pelicula.addColumn("disponibilidad");

		modelo_prestamo.addColumn("tipo");
		modelo_prestamo.addColumn("titulo");
		modelo_prestamo.addColumn("fecha devolucion");

		this.tabla_libro = new JTable(modelo_libro) {
			@Override
			public String getToolTipText(MouseEvent e) {
				String text = null;
				java.awt.Point p = e.getPoint();
				int rowIndex = rowAtPoint(p);
				int colIndex = columnAtPoint(p);

				try {
					text = getValueAt(rowIndex, colIndex).toString();
				} catch (RuntimeException e1) {
				}

				return text;
			}
		};
		this.tabla_libro.getTableHeader().setReorderingAllowed(false);
		this.tabla_libro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		this.tabla_pelicula = new JTable(modelo_pelicula) {
			@Override
			public String getToolTipText(MouseEvent e) {
				String text = null;
				java.awt.Point p = e.getPoint();
				int rowIndex = rowAtPoint(p);
				int colIndex = columnAtPoint(p);

				try {
					text = getValueAt(rowIndex, colIndex).toString();
				} catch (RuntimeException e1) {
				}

				return text;
			}
		};
		this.tabla_pelicula.getTableHeader().setReorderingAllowed(false);
		this.tabla_pelicula.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		this.tabla_prestamo = new JTable(modelo_prestamo) {
			@Override
			public String getToolTipText(MouseEvent e) {
				String text = null;
				java.awt.Point p = e.getPoint();
				int rowIndex = rowAtPoint(p);
				int colIndex = columnAtPoint(p);

				try {
					text = getValueAt(rowIndex, colIndex).toString();
				} catch (RuntimeException e1) {
				}

				return text;
			}
		};
		if (usuario != null)
			getPrestamos(); // Cargar los prestamos del usuario actual en la JTable
		this.tabla_prestamo.getTableHeader().setReorderingAllowed(false);
		this.tabla_prestamo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		this.scroll_libro = new JScrollPane(tabla_libro, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		this.scroll_pelicula = new JScrollPane(tabla_pelicula, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		this.scroll_prestamo = new JScrollPane(tabla_prestamo, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		this.scroll_libro.setBounds(20, 100, 450, 100);
		this.scroll_libro.setBorder(BorderFactory.createTitledBorder("Libros Encontrados"));
		this.scroll_pelicula.setBounds(20, 220, 450, 100);
		this.scroll_pelicula.setBorder(BorderFactory.createTitledBorder("Peliculas Encontradas"));
		this.scroll_prestamo.setBounds(500, 100, 300, 220);
		this.scroll_prestamo.setBorder(BorderFactory.createTitledBorder("Prestamos pendientes"));

		// Configuracion del boton de prestamo
		this.loanButton.setBounds(20, 335, 140, 40);
		this.loanButton.setFocusable(false);
		this.loanButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				realizarPrestamo();
				update();
			}

		});

		if (this.usuario == null) {
			this.loanButton.setVisible(false);
			this.profileButton.setVisible(false);
		}

		this.profileButton.setBounds(700, 20, 100, 30);
		this.profileButton.setFocusable(false);
		this.profileButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				perfilUsuario();
			}

		});

		this.exitButton.setBounds(750, 380, 100, 30);
		this.exitButton.setFocusable(false);
		this.exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});
		
		Timer SimpleTimer = new Timer(1000, new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		        currentTime.setText(dateFormat.format(new Date()));
		    }
		});
		SimpleTimer.start();
		
		this.currentTime.setBounds(20, 380, 150, 30);

		centralPanel.add(searchButton);
		centralPanel.add(loanButton);
		centralPanel.add(this.search_icon);
		centralPanel.add(this.searchBar);
		centralPanel.add(scroll_libro);
		centralPanel.add(scroll_pelicula);
		centralPanel.add(scroll_prestamo);
		centralPanel.add(profileButton);
		centralPanel.add(exitButton);
		centralPanel.add(currentTime);

		// Configuracion en el Panel de Usuario principal
		this.add(upperPanel, BorderLayout.NORTH);
		this.add(centralPanel, BorderLayout.CENTER);

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}

	private void buscar() {

		if (!searchBar.getText().isEmpty()) {
			ArrayList<Libro> libros = (ArrayList<Libro>) this._ctrl.buscarLibro(searchBar.getText());
			ArrayList<Pelicula> peliculas = (ArrayList<Pelicula>) this._ctrl.buscarPelicula(searchBar.getText());

			// Borra todas las filas del JTable
			this.modelo_libro.setRowCount(0);
			this.modelo_pelicula.setRowCount(0);

			// Inserta los elementos encontrados en el modelo
			for (Libro libro : libros) {
				String disponibilidad = libro.getDisponibilidad() ? "SI" : "NO";
				this.modelo_libro.addRow(new Object[] { libro.getISBN(), libro.getTitulo(), libro.getAutor(),
						libro.getEditorial(), disponibilidad });
			}

			for (Pelicula peli : peliculas) {
				String disponibilidad = peli.getDisponibilidad() ? "SI" : "NO";
				this.modelo_pelicula.addRow(new Object[] { peli.getISAN(), peli.getTitulo(), peli.getCategoria(),
						peli.getDuracion(), disponibilidad });
			}
		}
	}

	private void realizarPrestamo() {
		int fila_libro = tabla_libro.getSelectedRow();
		int fila_pelicula = tabla_pelicula.getSelectedRow();

		if (fila_libro != -1) {
			String ISBN = modelo_libro.getValueAt(fila_libro, 0).toString();
			if (this._ctrl.prestamoLibro(ISBN, this.usuario)) {
				JOptionPane.showMessageDialog(this, "El proceso de prestamo ha finalizado correctamente", "Mensaje",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "El proceso de prestamo no ha finalizado correctamente", "Mensaje",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (fila_pelicula != -1) {
			String ISAN = modelo_pelicula.getValueAt(fila_pelicula, 0).toString();
			if (this._ctrl.prestamoPelicula(ISAN, this.usuario)) {
				JOptionPane.showMessageDialog(this, "El proceso de prestamo ha finalizado correctamente", "Mensaje",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "El proceso de prestamo no ha finalizado correctamente", "Mensaje",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this,
					"Seleciona un libro o pelicula de las tablas antes de realizar un prestamo", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	private void getPrestamos() {
		List<PrestamoLibro> prestamos_libro = this.usuario.getPrestamoLibro();
		List<PrestamoPelicula> prestamos_pelicula = this.usuario.getPrestamoPelicula();

		this.modelo_prestamo.setRowCount(0);
		for (PrestamoLibro p : prestamos_libro) {
			Libro libro = p.getLibro();
			this.modelo_prestamo.addRow(new Object[] { "Libro", libro.getTitulo(), p.getFecha_devolucion() });
		}

		for (PrestamoPelicula p : prestamos_pelicula) {
			Pelicula pelicula = p.getPelicula();
			this.modelo_prestamo.addRow(new Object[] { "pelicula", pelicula.getTitulo(), p.getFecha_devolucion() });
		}

	}

	private void perfilUsuario() {
		UserProfilePanel userPanel = new UserProfilePanel(this.usuario, this._ctrl);
	}

	private void update() {
		getPrestamos();
	}
}
