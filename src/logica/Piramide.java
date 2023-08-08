package logica;

public class Piramide extends FiguraGeometrica {
	private double base;
	private double altura;
	private double apotema;
	
	public Piramide(double base, double altura, double apotema) {
		super();
		this.base = base;
		this.altura = altura;
		this.apotema = apotema;
		this.setVolumen(calcularVolumen());
		this.setSuperficie(calcularSuperficie());			
		}
	
	public double calcularVolumen() {
		double volumen = (Math.pow(base, 2)*altura)/3;
		return volumen;
	}
	
	public double calcularSuperficie() {
		double areaBase = Math.pow(base, 2);
		double areaLado = 2*base*apotema;
		return areaBase + areaLado;
	}
}
	
	

