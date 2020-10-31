import java.util.ArrayList;

public class Cocktail extends ElementoPocima {
	private ArrayList<ElementoPocima> elementos;
	
	public Cocktail(String nombre) {
		super(nombre);
		elementos = new ArrayList<ElementoPocima>();
	}
	
	public void addElemento(ElementoPocima e) {
		elementos.add(e);
	}

	@Override
	public boolean getCantMinimaPocimas() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cumple(Filtro f) {
		// TODO Auto-generated method stub
		return false;
	}
	//valor atributo ORIGINAL 100
	//valor atributo 100 + %35 psf | valor atributo  135
	//valor attributo 135 + %20 fortalecedora | valor atributo  162
	// valor atributo 162 + %45 
	
	//cocktail tiene:
	// psf |  fortalecedora | reductor plomo | vale cuatro
	
	@Override
	public int modificarAtributo(int valorAtributo, String nombreAtributo) {
		for(ElementoPocima pocima: this.elementos) {
			valorAtributo = pocima.modificarAtributo(valorAtributo, nombreAtributo);
		}
		return valorAtributo;
	}
}
