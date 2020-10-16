import java.util.ArrayList;

public class Carta {
	private String nombrePersonaje;
	private ArrayList<Atributo> atributos;
	
	public Carta(String nombrePersonaje) {
		this.nombrePersonaje = nombrePersonaje;
		atributos = new ArrayList<Atributo>();
	}
	//por cada atributo pregunto a la carta si tiene atributo
	
	public String toString() {
		return this.getNombrePersonaje().toUpperCase() + "    "+ atributos.toString();
	}
	
	public boolean esDelMismoTipo(Carta unaCarta) { 		//CONSULTAR SI ESTA BIEN!
		ArrayList<String> listaUno = new ArrayList<String>();
		ArrayList<String> listaDos = new ArrayList<String>();
		listaUno = unaCarta.getNombreAtributos();
		listaDos = this.getNombreAtributos();
		for(int i =0; i < listaUno.size(); i++) {
			if(!listaDos.contains(listaUno.get(i)))
				return false;									//no son objects atributo
			//if(!listaUno.get(i).equals(listaDos.get(contador)))//donde defino el equals si son strings?
			/*else {
				contador++;
				i = 0;
			}// CORREGIR*/
		}
		return true;	
	}
	
	public int getValorAtributoPorNombre(String atributo) {
		for(int i=0; i<atributos.size(); i++) {
			Atributo atributoAux = atributos.get(i);
			if(atributoAux.getNombre().equals(atributo))
				return atributoAux.getValor();
		}
		return -1;
	}

	public ArrayList<String> getNombreAtributos(){
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
		
	//GETS AND SETS
	public String getNombrePersonaje() {
		return nombrePersonaje;
	}

	public void setNombrePersonaje(String nombrePersonaje) {
		this.nombrePersonaje = nombrePersonaje;
	}
}
