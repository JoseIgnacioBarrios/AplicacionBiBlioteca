package Biblioteca.View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Biblioteca.Control.Controller;

public class peliAdmin extends JPanel{

	private static final long serialVersionUID = 1L;
	private Controller control;
	private JButton anadir;
	private JButton editar;
	private JButton eliminar;
	private JButton mostrar;
	private JButton volver;
	private JLabel titulo;
	public peliAdmin(Controller c) {
		this.control=c;
		initGUI();
	}
	
	
	public void initGUI() {
		this.setLayout(null);
		titulo=new JLabel();
		titulo.setText("Que quieres hacer?");
		titulo.setBounds(110, 10, 200, 30);
		this.add(titulo);
		//boton a�adir
		anadir=new JButton("Anyadir pelicula");
		anadir.setToolTipText("Anyadir una pelicula a la base de datos");
		anadir.setBounds(125, 55, 120, 30);
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
		editar=new JButton("Editar pelicula");
		editar.setToolTipText("Editar una pelicula de la base de datos");
		editar.setBounds(125, 85, 120, 30);
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
		eliminar=new JButton("Eliminar pelicula");
		eliminar.setToolTipText("Eliminar una pelicula de la base de datos");
		eliminar.setBounds(120, 115, 130, 30);
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
		//boton volver
		volver=new JButton("Volver");
		volver.setBounds(295, 170, 70, 30);
		volver.setForeground(Color.WHITE);
		volver.setBackground(Color.BLACK);
		volver.setFocusPainted(false);
		this.add(volver);
		
		mostrar=new JButton("Mostrar peliculas");
		mostrar.setToolTipText("Muestra todas las peliculas");
		mostrar.setBounds(105, 145, 160, 30);
		mostrar.setForeground(Color.WHITE);
		mostrar.setBackground(Color.BLACK);
		mostrar.setFocusPainted(false);
		mostrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s= control.mostrarPeliculas();
				if(s!=null) {

					JFrame jFrame = new JFrame();
					 JOptionPane.showMessageDialog(jFrame, s);
				}else {
					JFrame jFrame = new JFrame();
					 JOptionPane.showMessageDialog(jFrame, "Lista de peliculas vacia");
				}
				
				
			}
			
		});
		this.add(mostrar);
		
	}
	public void eliminar() {
		EliminarPelicula e=new EliminarPelicula(control);
		//e.setLocationRelativeTo(null);
	}
	public void anadir() {
		AnadirPelicula a =new AnadirPelicula(control);
	}

	public void editar() {
		EditarPelicula e=new EditarPelicula(control);
		//e.setLocationRelativeTo(null);
	}
}
