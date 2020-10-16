import java.util.ArrayList;

public class Jugador {
	private String nombre;
	protected ArrayList<Carta> cartasJugador;
	
	public Jugador(String nombre){
		this.nombre = nombre;
		cartasJugador = new ArrayList<Carta>();
	}
	
	//public los metodos que usa otra clase
	protected int cantidadCartas() {
		return cartasJugador.size();
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
	
	protected Carta darCarta() {
		Carta c = this.cartasJugador.get(0);
		this.removerCarta();
		return c;
	}
	
	protected void enviarCartaAlFondo() {
		recibirCarta(cartasJugador.get(0));
		removerCarta();
	}
	
	protected Atributo elegirAtributoRandom(Carta carta) {
		ArrayList<Atributo> atributos = carta.getAtributos();
		int i = (int) Math.floor(Math.random() * atributos.size());
		return atributos.get(i);
	}
	
	protected Atributo empezarRonda() {
		Carta primerCartaJ1 = this.elegirPrimerCarta();
		Atributo atributoSeleccionado = this.elegirAtributoRandom(primerCartaJ1);
		return atributoSeleccionado;
	}
	
	protected int obtenerValorAtributo() {
		Atributo a = this.empezarRonda();
		return a.getValor();
	}
	
	protected int valorAtributoTurnoDos(Atributo atributo) {
		Carta primerCartaJ2 = this.elegirPrimerCarta();
		int valorJugadorDos = primerCartaJ2.getValorAtributoPorNombre(atributo.getNombre());
		return valorJugadorDos;
	}
	
	protected boolean tieneCartas() {
		if(cartasJugador.size() > 0)
			return true;
		else
			return false;
	}
	
	//GET AND SET
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//colocarCartaAlFinal()->MAZO	
}
