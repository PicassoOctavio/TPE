import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
	private int cantAtributos;
	private int cantCartas;
	protected ArrayList<Carta> cartas;

	public Mazo(int cantAtributos, int cantCartas) {
		this.cantAtributos = cantAtributos;
		this.cantCartas = cantCartas;
		cartas = new ArrayList<Carta>();
	}
	
	//crearMazo() HECHO
	//verificarCartas() HECHO
	//getTamañoMazo() HECHO
	
	//darPrimerCarta() 
	//guardarCartaAlFinal()
	
	private void chequearMazo() {
		for(int i=0; i< cartas.size();i++) {
			Carta cartaAux = cartas.get(i);
			if(!cartaAux.esDelMismoTipo(cartaAux))	// esta bien pasarle la misma carta?
				cartas.remove(i);
		}
	}//hacer metodo borrarCarta() que no pertenece
	

	
	public ArrayList<Carta> getMazo(){
		return new ArrayList<Carta>(this.cartas);
	}
	
	private void mezclarCartas() {
		Collections.shuffle(cartas);
	}
	
	protected void darCartas(Jugador jugador1, Jugador jugador2) {
		mezclarCartas();
		for(int i= 0; i< cartas.size(); i++) {
			jugador1.recibirCarta(cartas.get(i));
			cartas.remove(i); // se acomoda solo?
			jugador2.recibirCarta(cartas.get(i));
			cartas.remove(i);
		}
	}
	/*public Carta getCartaRandom() {
		int i = Math.floor(Math.random() * this.getTamanioMazo() + 1); // consultar esto!
		return cartas.get(i);
		//cartas.remove(i); si remuevo la carta no la retorno, y si no la remuevo el j2 la puede obtener
	}*/
	
	public int getTamanioMazo() {
		return cartas.size();
	}
	
	public void addCarta(Carta unaCarta) {
		if(cartas.size() < 1) {
			cartas.add(unaCarta);			
			cantCartas++;
		}
		if(!cartas.contains(unaCarta)) {
			cartas.add(unaCarta);
			cantCartas++;
		}
		//si el mazo esta vacio agrego HECHO
		//si ya tiene una carta, verificar que sean iguales HECHO con equals
	}
	
	//SETS AND GETS
	public int getCantAtributos() {
		return cantAtributos;
	}

	public void setCantAtributos(int cantAtributos) {
		this.cantAtributos = cantAtributos;
	}
}
