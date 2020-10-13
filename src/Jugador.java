import java.util.ArrayList;

public class Jugador {
	private String name;
	private int jugador;
	protected ArrayList<Carta> cartasJugador;
	//private Mazo mazo;
	
	public Jugador(int jugador, boolean turno) {
		this.jugador = jugador;
		this.turno = turno;
		//this.mazo = mazo;
	}
	
	protected void recibirCarta(Carta unaCarta) {
		cartasJugador.add(unaCarta);
	}
	
	public void removerCarta() {
		cartasJugador.remove(cartasJugador.get(0));
	}
	
	protected Carta elegirPrimerCarta() {
		return cartasJugador.get(0);
	}
	
	protected Atributo elegirAtributoRandom(Carta carta) {
		//Carta cartaAux = elegirPrimerCarta();
		ArrayList<Atributo> atributos = carta.getAtributos();
		int i = (int) Math.floor(Math.random() * atributos.size());
		return atributos.get(i);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	/*private int valorAtributoSeleccionado(String atributo) {
		Carta carta = elegirPrimerCarta();
		carta.
	}*/
	
	
	//colocarCartaAlFinal()->MAZO
	
}
