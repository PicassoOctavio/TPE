
public class PocimaValorFijo extends Pocima {
	private int valor;
	
	public PocimaValorFijo(String nombre, int valor) {
		super(nombre);
		this.valor = valor;
	}
	
	@Override
	public int modificarValor(Atributo atributo) {
		int valorAtributo = this.getValor();
		return valorAtributo;
	}
	
	public int getValor() {
		return valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
}
