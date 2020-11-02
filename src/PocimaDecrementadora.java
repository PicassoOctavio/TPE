
public class PocimaDecrementadora extends Pocima {
	private int valor;
	
	public PocimaDecrementadora(String nombre, int valor) {
		super(nombre);
		this.valor = valor;
	}

	@Override
	public int modificarValor(Atributo atributo) {
		int valorAtributo = atributo.getValor();
		return valorAtributo -= valorAtributo * this.getValor() / 100;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
}
