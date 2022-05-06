package Biblioteca.Launcher;

import javax.swing.SwingUtilities;

import Biblioteca.Control.Controller;
import Biblioteca.Model.Biblioteca;
import Biblioteca.View.MainWindow;

public class Main {
	
	public static void main(String[] args) throws Exception {
		init();
	}

	private static void init() throws Exception {
		Biblioteca biblioteca = Biblioteca.getBiblioteca(); // Singleton		
		Controller _ctrl = new Controller(biblioteca);
    
		SwingUtilities.invokeAndWait(new Runnable() {
			@Override
			public void run() {
				new MainWindow(_ctrl);
			}
		});	
	}
}
