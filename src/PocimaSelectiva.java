
public class PocimaSelectiva extends Pocima {
	private String nombreAtributo;
	private int valor;
	
	
	public PocimaSelectiva(String nombre, String nombreAtributo, int valor) {
		super(nombre);
		this.nombreAtributo = nombreAtributo;
		this.valor = valor;
	}

	@Override
	public int modificarValor(Atributo atributo) {
		if(atributo.getNombre().equals(this.getNombreAtributo())) {
			int valorAtributo = atributo.getValor();
			return valorAtributo += valorAtributo * this.getValor() / 100;
		}
		else
			return atributo.getValor();
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getNombreAtributo() {
		return nombreAtributo;
	}

	public void setNombreAtributo(String nombreAtributo) {
		this.nombreAtributo = nombreAtributo;
	}
}
