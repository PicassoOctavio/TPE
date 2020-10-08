import java.util.ArrayList;

public class Mazo {
	private int cantAtributos;
	private int cantCartas;
	protected ArrayList<Carta> cartas;

	public Mazo(int cantAtributos, int cantCartas) {
		this.cantAtributos = cantAtributos;
		this.cantCartas = cantCartas;
		cartas = new ArrayList<Carta>();
	}
	
	//crearMazo()
	//verificarCartas()
	//getTamañoMazo()
	
	//darPrimerCarta()
	//guardarCartaAlFinal()
	
	public void chequearMazo() {
		for(int i=0; i< cartas.size();i++) {
			Carta cartaAux = cartas.get(i);
			if(cartaAux.perteneceAmazo())		
		}
	}//hacer metodo borrarCarta() que no pertenece
	
	//repartirse() el mazo sabe repartirse?
	
	//sacarUnaCarta()
	
	public ArrayList<Carta> getMazo(){
		return new ArrayList<Carta>(this.cartas);
	}
	
	public ArrayList<Carta> repartir(Jugador jugadorUno, Jugador jugadorDos){
		/*double cantCartasJugador= cartas.size()/2; //31
		if((cartas.size() % 2) != 0) {
			Math.ceil(cantCartasJugadorUNO);
			Math.floor(cantCartasJugadorDOS);
		}
		ArrayList<Carta> cartasJugadorUno = new ArrayList<Carta>();
		for(int i= 0; i < cantCartasJugadorUNO; i++) {
			cartasJugadorUno.add(cartas.getCartaRandom());
			//cartas.remove(i);
		}*/
	}
	public Carta getCartaRandom() {
		int i = Math.floor(Math.random() * this.getTamanioMazo() + 1); // consultar esto!
		return cartas.get(i);
		//cartas.remove(i); si remuevo la carta no la retorno, y si no la remuevo el j2 la puede obtener
	}
	
	public int getTamanioMazo() {
		return cartas.size();
	}
	
	public void addCarta(Carta unaCarta) {
		if(!cartas.contains(unaCarta)) {
			cartas.add(unaCarta);
			cantCartas++;
		}
		//si el mazo esta vacio agrego
		//si ya tiene una carta, verificar que sean iguales
	}
	
	//SETS AND GETS
	public int getCantAtributos() {
		return cantAtributos;
	}

	public void setCantAtributos(int cantAtributos) {
		this.cantAtributos = cantAtributos;
	}
}
