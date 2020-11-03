	
public class Cocktail extends Pocima {
	Pocima p1;
	Pocima p2;
	
	public Cocktail(String nombre, Pocima p1, Pocima p2) {
		super(nombre);
		this.p1 = p1;
		this.p2 = p2;
	}
	
	@Override
	public int modificarValor(Atributo atributo) {
		Atributo a = new Atributo (atributo.getNombre(), p1.modificarValor(atributo));
		Atributo b = new Atributo (atributo.getNombre(), p2.modificarValor(a));
		return b.getValor();
	}

	public Pocima getP1() {
		return p1;
	}

	public void setP1(Pocima p1) {
		this.p1 = p1;
	}

	public Pocima getP2() {
		return p2;
	}

	public void setP2(Pocima p2) {
		this.p2 = p2;
	}
}
