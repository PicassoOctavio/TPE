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
	
	protected boolean esDelMismoTipo(Carta unaCarta) { 		//CONSULTAR SI ESTA BIEN!
		ArrayList<String> listaUno = new ArrayList<String>();
		ArrayList<String> listaDos = new ArrayList<String>();
		listaUno = unaCarta.getNombreAtributos();
		listaDos = this.getNombreAtributos();
		int contador = 0;
		for(int i =0; i < listaUno.size(); i++) {
			if(!listaUno.get(i).equals(listaDos.get(contador)))//donde defino el equals si son strings?
				return false;									//no son objects atributo
			else {
				contador++;
				i = 0;
			}
		}
		return true;	
	}
	
	protected ArrayList<String> getNombreAtributos(){
		ArrayList<String> nombres = new ArrayList<String>();
		for(int i= 0; i < atributos.size(); i++) {
			nombres.add(atributos.get(i).getNombre());
		}
		return nombres;
	}
	
	public void addAtributo(Atributo unAtributo) {
		if(!atributos.contains(unAtributo)) {
			atributos.add(unAtributo);
		}
	}
	
	public boolean equals(Object o) { //EQUALS ATRIBUTO
		try {
			Carta unaCarta = (Carta) o;
			if(unaCarta.getNombrePersonaje() == this.nombrePersonaje)
				return true;
			else
				return false;
		}
		catch(Exception exc){
			return false;
		}
	}

	public ArrayList<Atributo> getAtributos() {
		return new ArrayList<Atributo> (this.atributos);
	}
	
	/*for(int i= 0; i<atributos.size(); i++) {
	Atributo atributoAux = atributos.get(i);
	if(atributoAux.getNombre().equals(nombre))
		return atributoAux;
	}
	return null;*/
	
	
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
