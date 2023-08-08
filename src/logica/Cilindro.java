package logica;

public class Cilindro extends FiguraGeometrica{

	private double radio;
	private double altura;
	
	public Cilindro(double radio, double altura) {
		super();
		this.radio = radio;
		this.altura = altura;
		this.setVolumen(calcularVolumen());
		this.setSuperficie(calcularSuperficie());
	}
	
	public double calcularVolumen() {
		double volumen = Math.PI * altura * Math.pow(radio, 2);
		return volumen;
	}
	
	public double calcularSuperficie() {
		double areaLadoA = 2*Math.PI*radio*altura;
		double areaLadoB = 2*Math.PI*radio*Math.pow(radio, 2);
		return areaLadoA + areaLadoB;
	}

}
