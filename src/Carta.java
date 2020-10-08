import java.util.ArrayList;

public class Carta {
	private int nroCarta;
	private String nombrePersonaje;
	private ArrayList<Atributo> atributos;
	
	public Carta(int nroCarta, String nombrePersonaje) {
		this.nroCarta = nroCarta;
		this.nombrePersonaje = nombrePersonaje;
		atributos = new ArrayList<Atributo>();
	}
	
	
	private boolean esDelMismoTipo(Carta unaCarta) {
		ArrayList<String> lista1 = unaCarta.getNombreAtributos();
		ArrayList<String> lista2 = this.getNombreAtributos();
		for(int i=0; i<lista1.size();i++) {
			Atributo unAtributo = atributos.get(i);
			if(lista1.get(i).equals(lista2.get(i)))	
		}
	}
	private ArrayList<String> getNombreAtributos(){
		ArrayList<String> nombres = new ArrayList<String>();
		for(int i= 0; i<atributos.size(); i++) {
			nombres.add(atributos.get(i).getNombre());
		}
		return nombres;
	}
	
	public Atributo getAtributo(String nombre) {
		for(int i= 0; i<atributos.size(); i++) {
			Atributo atributoAux = atributos.get(i);
			if(atributoAux.getNombre().equals(nombre))
				return atributoAux;
		}
		return null;
	}
	
	public void addAtributo(Atributo unAtributo) {
		if(!atributos.contains(unAtributo)) {
			atributos.add(unAtributo);
		}
	}
	
	//GETS AND SETS
	public int getNroCarta() {
		return nroCarta;
	}

	public void setNroCarta(int nroCarta) {
		this.nroCarta = nroCarta;
	}

	public String getNombrePersonaje() {
		return nombrePersonaje;
	}

	public void setNombrePersonaje(String nombrePersonaje) {
		this.nombrePersonaje = nombrePersonaje;
	}
	
}
