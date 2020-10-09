import java.util.ArrayList;

public class Jugador {
	private int jugador;
	private boolean turno;
	private ArrayList<Carta> cartasJugador;
	//private Mazo mazo;
	
	public Jugador(int jugador, boolean turno) {
		this.jugador = jugador;
		this.turno = turno;
		//this.mazo = mazo;
	}
	
	private void recibirCartas(Carta unaCarta) {
		cartasJugador.add(unaCarta);
	}
	
	private Carta elegirPrimerCarta() {
		return cartasJugador.get(0);
	}
	
	protected Atributo elegirAtributoRandom() {
		Carta cartaAux = elegirPrimerCarta();
		ArrayList<Atributo> atributos = cartaAux.getAtributos();
		int i = (int) Math.floor(Math.random() * atributos.size());
		return atributos.get(i);
	}
	
	private int valorAtributoSeleccionado(String atributo) {
		Carta carta = elegirPrimerCarta();
		carta.
	}
	
	//colocarCartaAlFinal()->MAZO
	
}
