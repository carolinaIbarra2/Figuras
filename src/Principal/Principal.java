package Principal;

import javax.swing.JOptionPane;

import ventana.VentanaPrincipal;

public class Principal {

	public static void main(String[] args) {
		
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(); //crea ventana principal
		ventanaPrincipal.setVisible(true);
		ventanaPrincipal.setResizable(false);				
	}

}
