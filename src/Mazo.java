import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
	protected ArrayList<Carta> cartas;

	public Mazo(int cantAtributos) {
		cartas = new ArrayList<Carta>();
	}
	
	public Mazo() {
		cartas = new ArrayList<Carta>();
	};
	
	//crearMazo() HECHO
	//verificarCartas() HECHO
	//getTamañoMazo() HECHO
	//darPrimerCarta() HECHO
	//guardarCartaAlFinal() HECHO
	
	// hacer el mostrarCarta();
	
	public void chequearMazo() {
		for(int i=0; i< cartas.size();i++) {
			Carta carta = cartas.get(0);
			Carta cartaAux = cartas.get(i);
			if(!carta.esDelMismoTipo(cartaAux))	// esta bien pasarle la misma carta?
				cartas.remove(i);
		}
	}//hacer metodo borrarCarta() que no pertenece
	
	public void linea() {
		System.out.println("--------------------------------------------------------");
	}
	
	public void mostrarMazo() {
		for(int i=0; i< cartas.size();i++) {
			Carta cartaAux = cartas.get(i);
			System.out.println(cartaAux.toString());
		}
	}
	
	public String toString(Carta carta){
        return carta.toString();
    }

	
	public ArrayList<Carta> getMazo(){
		return new ArrayList<Carta>(this.cartas);
	}
	
	private void mezclarCartas() {
		Collections.shuffle(cartas);
	}
	
	protected void darCartas(Jugador jugador1, Jugador jugador2) {
		mezclarCartas();
		for(int i= 0; i< cartas.size()-1; i++) {// se nos va de rango
			System.out.println(cartas.get(i));
			jugador1.recibirCarta(cartas.get(i));
			cartas.remove(i); 
			jugador2.recibirCarta(cartas.get(i));
			cartas.remove(i);
		}
	}
	
	public int getTamanioMazo() {
		return cartas.size();
	}
	
	public void addCarta(Carta unaCarta) {
		if(cartas.size() < 1) {
			cartas.add(unaCarta);			
		}
		if(!cartas.contains(unaCarta)) {
			cartas.add(unaCarta);
		}
		//si el mazo esta vacio agrego HECHO
		//si ya tiene una carta, verificar que sean iguales HECHO con equals
	}
	
	//SETS AND GETS
	/*public int getCantAtributos() {
		return cantAtributos;
	}

	public void setCantAtributos(int cantAtributos) {
		this.cantAtributos = cantAtributos;
	}*/
}