package Biblioteca.View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Biblioteca.Control.Controller;

public class libroAdmin extends JPanel{

	private static final long serialVersionUID = 1L;
	private Controller control;
	private JButton anadir;
	private JButton editar;
	private JButton eliminar;
	private JButton volver;
	private JLabel titulo;
	private JButton mostrar;
	public libroAdmin(Controller c) {
		this.control=c;
		initGUI();
	}
	
	
	public void initGUI() {
		this.setLayout(null);
		titulo = new JLabel();
		titulo.setText("�Qu� quieres hacer?");
		titulo.setBounds(110, 10, 200, 30);
		this.add(titulo);
		//boton a�adir
		anadir=new JButton("A�adir libro");
		anadir.setToolTipText("A�adir un libro a la base de datos");
		anadir.setBounds(140, 55, 100, 30);
		anadir.setForeground(Color.WHITE);
		anadir.setBackground(Color.BLACK);
		anadir.setFocusPainted(false);
		anadir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				anadir();
			}
			
		});
		this.add(anadir);
		//boton editar
		editar=new JButton("Editar libro");
		editar.setToolTipText("Editar un libro de la base de datos");
		editar.setBounds(140, 85, 100, 30);
		editar.setForeground(Color.WHITE);
		editar.setBackground(Color.BLACK);
		editar.setFocusPainted(false);
		editar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				editar();
			}
			
		});
		this.add(editar);
		//boton eliminar
		eliminar=new JButton("Eliminar libro");
		eliminar.setToolTipText("Eliminar un libro de la base de datos");
		eliminar.setBounds(135, 115, 110, 30);
		eliminar.setForeground(Color.WHITE);
		eliminar.setBackground(Color.BLACK);
		eliminar.setFocusPainted(false);
		eliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				eliminar();
			}
			
		});
		this.add(eliminar);
		mostrar=new JButton("Mostrar libros");
		mostrar.setToolTipText("Muestra todos los libros");
		mostrar.setBounds(120, 145, 140, 30);
		mostrar.setForeground(Color.WHITE);
		mostrar.setBackground(Color.BLACK);
		mostrar.setFocusPainted(false);
		mostrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s= control.mostrarLibros();
				if(s!=null) {
					JFrame jFrame = new JFrame();
					 JOptionPane.showMessageDialog(jFrame, s);
				}else {
					JFrame jFrame = new JFrame();
					 JOptionPane.showMessageDialog(jFrame, "Lista de libros vacia");
				}
			}
		});
		this.add(mostrar);
		//boton volver
		volver=new JButton("Volver");
		volver.setBounds(295, 170, 70, 30);
		volver.setForeground(Color.WHITE);
		volver.setBackground(Color.BLACK);
		volver.setFocusPainted(false);
		this.add(volver);
	}
	public void eliminar() {
		EliminarLibro e=new EliminarLibro(control);
		//e.setLocationRelativeTo(null);
	}
	public void anadir() {
		AnadirLibro a =new AnadirLibro(control);
		//a.setLocationRelativeTo(null);
	}

	public void editar() {
		EditarLibro e=new EditarLibro(control);
		//e.setLocationRelativeTo(null);
	}
}
