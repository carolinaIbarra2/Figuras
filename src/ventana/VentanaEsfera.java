package ventana;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import logica.Esfera;

public class VentanaEsfera  extends JFrame implements ActionListener{

	private Container contenedor;
	private JLabel radio, volumen, superficie;
	private JTextField campoRadio;
	private JButton calcular, reiniciar;
	
	public VentanaEsfera() {
		inicio();
		setTitle("Esfera");
		setSize(350,280);
		setLocationRelativeTo(null); //Posicion ventana en el centro
		setResizable(false); //Al salir del programa se cierra aplicacion
		
	}
	
	private void inicio() {
		contenedor = getContentPane();
		contenedor.setLayout(null);  //Contenedor no tiene layout
		
		//Etiqueta
		radio = new JLabel();
		radio.setText("Radio(cms):");
		radio.setBounds(50, 20, 135, 23);
		//Texto
		campoRadio = new JTextField();
		campoRadio.setBounds(130, 20, 135, 23);
			
		//Boton
		calcular = new JButton();
		calcular.setText("Calcular");
		calcular.setBounds(130, 50, 135, 23);
		calcular.addActionListener(this);
	
		//Boton
		reiniciar = new JButton();
		reiniciar.setText("Reiniciar");
		reiniciar.setBounds(130, 170, 135, 23);
		reiniciar.addActionListener(this);
		
		volumen = new JLabel();
		volumen.setText("Volumen (cm3): ");
		volumen.setBounds(50, 98, 135, 23);
	
		superficie = new JLabel();
		superficie.setText("Superficie(cm2): ");
		superficie.setBounds(50, 125, 135, 23);
		
		//Se añade cada componente gráfico al contenedor de la ventana
		contenedor.add(radio);
		contenedor.add(campoRadio);
		contenedor.add(calcular);
		contenedor.add(reiniciar);
		contenedor.add(volumen);
		contenedor.add(superficie);	
	}
	
	public void actionPerformed(ActionEvent event) {
		//Se inicializa variable para determinar si ocurre un error
		boolean error = false;
		
		try {
			double radio = Double.parseDouble(campoRadio.getText());
		
			Esfera esfera = new Esfera(radio);
			//Se calcula volumen
			volumen.setText("Volumen (cm3): " + String.format("%.2f", esfera.calcularVolumen()));
			//Se calcula superficie
			superficie.setText("Superficie (cm2): " + String.format("%.2f", esfera.calcularSuperficie()) );
			
		}catch(Exception e) {
			error = true;
		}finally{
			if(error) {
				JOptionPane.showMessageDialog(null, "Campo nulo o error en formato de numero", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(event.getSource() == reiniciar) {
			dispose();
			VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
			ventanaPrincipal.setVisible(true);
		}
	}	
}


