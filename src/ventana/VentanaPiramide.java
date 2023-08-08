package ventana;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import logica.Piramide;

public class VentanaPiramide extends JFrame implements ActionListener{
	
	private Container contenedor;
	private JLabel base, altura, apotema, volumen, superficie;
	private JTextField campoBase, campoAltura, campoApotema;
	private JButton calcular, reiniciar;
	
	
	public VentanaPiramide() {
		inicio();
		setTitle("Piramide");
		setSize(350,280);
		setLocationRelativeTo(null); //Posicion ventana en el centro
		setResizable(false); //Al salir del programa se cierra aplicacion
		
	}
	
	private void inicio() {
		contenedor = getContentPane();
		contenedor.setLayout(null);  //Contenedor no tiene layout
		
		//Etiqueta
		base = new JLabel();
		base.setText("Base(cms):");
		base.setBounds(35, 20, 135, 23);
		//Texto
		campoBase = new JTextField();
		campoBase.setBounds(135, 20, 135, 23);
	
		//Etiqueta
		altura = new JLabel();
		altura.setText("Altura(cms):");
		altura.setBounds(35, 50, 135, 23);
		//Texto
		campoAltura = new JTextField();
		campoAltura.setBounds(135, 50, 135, 23);
			
		//Apotema
		apotema = new JLabel();
		apotema.setText("Apotema(cms):");
		apotema.setBounds(35, 80, 135, 23);
		//Texto
		campoApotema = new JTextField();
		campoApotema.setBounds(135, 80, 135, 23);
		
		
		//Boton
		calcular = new JButton();
		calcular.setText("Calcular");
		calcular.setBounds(135, 110, 135, 23);
		calcular.addActionListener(this);
		
		//Boton
		reiniciar = new JButton();
		reiniciar.setText("Reiniciar");
		reiniciar.setBounds(130, 200, 135, 23);
		reiniciar.addActionListener(this);
	
		volumen = new JLabel();
		volumen.setText("Volumen (cm3): ");
		volumen.setBounds(35, 140, 135, 23);
	
		superficie = new JLabel();
		superficie.setText("Superficie(cm2): ");
		superficie.setBounds(35, 170, 135, 23);
		
		//Se añade cada componente gráfico al contenedor de la ventana
		contenedor.add(base);
		contenedor.add(campoBase);
		contenedor.add(altura);
		contenedor.add(campoAltura);
		contenedor.add(apotema);
		contenedor.add(campoApotema);
		contenedor.add(calcular);
		contenedor.add(reiniciar);
		contenedor.add(volumen);
		contenedor.add(superficie);
		
	}
	
	public void actionPerformed(ActionEvent event) {
		
		double base = 0;
		double altura = 0;
		double apotema = 0;
		
		//Se inicializa variable para determinar si ocurre un error
		boolean error = false;
		
		try {
			base = Double.parseDouble(campoBase.getText());
			altura = Double.parseDouble(campoAltura.getText());
			apotema = Double.parseDouble(campoApotema.getText());
			
			
			Piramide piramide = new Piramide(base, altura, apotema);
			//Se calcula volumen
			volumen.setText("Volumen (cm3): " + String.format("%.2f", piramide.calcularVolumen()));
			//Se calcula superficie
			superficie.setText("Superficie (cm2): " + String.format("%.2f", piramide.calcularSuperficie()) );
			
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
