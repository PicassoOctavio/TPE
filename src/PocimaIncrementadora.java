
public class PocimaIncrementadora extends Pocima {
	private double valor;
	
	public PocimaIncrementadora(String nombre, double valor) {
		super(nombre);
		this.valor = valor;
	}

	@Override
	public double modificarValor(Atributo atributo) {
		double valorAtributo = atributo.getValor();
		return valorAtributo += valorAtributo * this.getValor() / 100;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
