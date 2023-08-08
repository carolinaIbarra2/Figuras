package ventana;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import logica.Cilindro;

public class VentanaCilindro extends JFrame implements ActionListener{
	//Contenedor de elementos graficos
	private Container contenedor;
	//Etiquetas para identificar campos
	private JLabel radio, altura, volumen, superficie;
	private JTextField campoRadio, campoAltura;
	private JButton calcular, reiniciar;
	
	
	public VentanaCilindro() {
		inicio();
		setTitle("Cilindro");
		setSize(350,280);
		setLocationRelativeTo(null); //posicion de ventana en el centro
		setResizable(false);  //El boton cerrar finaliza la aplicacion
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
	
		//Etiqueta
		altura = new JLabel();
		altura.setText("Altura(cms):");
		altura.setBounds(50, 50, 135, 23);
		//Texto
		campoAltura = new JTextField();
		campoAltura.setBounds(130, 50, 135, 23);
				
		//Boton
		calcular = new JButton();
		calcular.setText("Calcular");
		calcular.setBounds(130, 80, 135, 23);
		calcular.addActionListener(this);
		
		//Boton
		reiniciar = new JButton();
		reiniciar.setText("Reiniciar");
		reiniciar.setBounds(130, 180, 135, 23);
		reiniciar.addActionListener(this);
	
		volumen = new JLabel();
		volumen.setText("Volumen (cm3): ");
		volumen.setBounds(50, 110, 135, 23);
	
		superficie = new JLabel();
		superficie.setText("Superficie(cm2): ");
		superficie.setBounds(50, 140, 135, 23);
		
		//Se añade cada componente gráfico al contenedor de la ventana
		contenedor.add(radio);
		contenedor.add(campoRadio);
		contenedor.add(altura);
		contenedor.add(campoAltura);
		contenedor.add(calcular);
		contenedor.add(reiniciar);
		contenedor.add(volumen);
		contenedor.add(superficie);
	}
	
	public void actionPerformed(ActionEvent event) {
		//Se inicializa el radio y altura del cilindro
		double radio = 0;
		double altura = 0;
		//Se inicializa variable para determinar si ocurre un error
		boolean error = false;
		
		try {
			radio = Double.parseDouble(campoRadio.getText());
			altura = Double.parseDouble(campoAltura.getText());
			
			Cilindro cilindro = new Cilindro(radio, altura);
			//Se calcula volumen
			volumen.setText("Volumen (cm3): " + String.format("%.2f", cilindro.calcularVolumen()));
			//Se calcula superficie
			superficie.setText("Superficie (cm2): " + String.format("%.2f", cilindro.calcularSuperficie()) );
			
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
