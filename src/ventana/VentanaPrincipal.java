package ventana;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class VentanaPrincipal extends JFrame implements ActionListener{
	private Container contenedor;
	private JButton cilindro, esfera, piramide;

	public VentanaPrincipal() {
		inicio();
		setTitle("Figuras");
		setSize(350,160);
		setLocationRelativeTo(null); //Posicion ventana en el centro
		setResizable(false); //Al salir del programa se cierra aplicacion
	}
	
	private void inicio() {
		contenedor = getContentPane();
		contenedor.setLayout(null);  //Contenedor no tiene layout
		
		//Boton
		cilindro = new JButton();
		cilindro.setText("Cilindro");
		cilindro.setBounds(20, 50, 80, 23);
		cilindro.addActionListener(this);
		
		//Boton
		esfera = new JButton();
		esfera.setText("Esfera");
		esfera.setBounds(125, 50, 80, 23);
		esfera.addActionListener(this);
						
		//Boton
		piramide = new JButton();
		piramide.setText("Piramide");
		piramide.setBounds(225, 50, 100, 23);
		piramide.addActionListener(this);
	
		//Se añade cada componente gráfico al contenedor de la ventana
		contenedor.add(cilindro);
		contenedor.add(esfera);
		contenedor.add(piramide);
		
		
	}
	
	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource() == esfera) {
			VentanaEsfera esfera = new VentanaEsfera();
			esfera.setVisible(true);
			dispose();
		} 
		if(evento.getSource() == cilindro) {
			VentanaCilindro cilindro = new VentanaCilindro();
			cilindro.setVisible(true);
			dispose();
		}
		if(evento.getSource() == piramide) {
			VentanaPiramide piramide = new VentanaPiramide();
			piramide.setVisible(true);
			dispose();
		}
	
	}
}
