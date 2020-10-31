import java.util.ArrayList;

public class Jugador {
	private String nombre;
	protected ArrayList<Carta> cartasJugador;
	private String estrategia;
	
	public Jugador(String nombre, String estrategia){
		this.nombre = nombre;
		cartasJugador = new ArrayList<Carta>();
		this.estrategia = "timbero";
	}
	
	//public los metodos que usa otra clase
	protected int cantidadCartas() {
		return cartasJugador.size();
	}
	
	public void addPocimaAcarta(ElementoPocima elementoPocima) {
		int i = (int) Math.floor(Math.random() * cartasJugador.size());
		Carta cartaAux = cartasJugador.get(i);
		cartaAux.setPocima(elementoPocima);//carta tiene Pocima, no elementoPocima
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
	
	private Atributo elegirAtributo(Carta carta) {
		Atributo aux = new Atributo(null, 0);
		if(estrategia.equals("timbero"))
			return aux = elegirAtributoRandom(carta);
		if(estrategia.equals("ambicioso"))
			return aux = elegirAtributoAmbicioso(carta);
		if(estrategia.equals("obstinado"))
			return aux = elegirAtributoObstinado(carta);
		else
			return null;
	}

	private Atributo elegirAtributoRandom(Carta carta) {
		ArrayList<Atributo> atributos = carta.getAtributos();
		int i = (int) Math.floor(Math.random() * atributos.size());
		return atributos.get(i);
	}
	
	private Atributo elegirAtributoAmbicioso(Carta carta) {
		ArrayList<Atributo> atributos = carta.getAtributos();
		Atributo aux = new Atributo(null, 0);
		for(Atributo atributo: atributos){
			if (atributo.getValor() > aux.getValor())
				aux = atributo;
		}
		return aux;
	}
	
	private Atributo elegirAtributoObstinado(Carta carta) {
		ArrayList<Atributo> atributos = carta.getAtributos();
		return atributos.get(0);
	}

	protected Atributo empezarRonda() {
		Carta primerCartaJ1 = this.elegirPrimerCarta();
		//if(primerCartaJ1.tienePocima())	
		Atributo atributoSeleccionado = this.elegirAtributo(primerCartaJ1);
		return atributoSeleccionado;
	}
	
	public boolean tienePocima() {
		Carta c = elegirPrimerCarta();
		if(c.tienePocima())
			return true;
		else
			return false;
	}
	
	public ElementoPocima aplicarPocima(int valorAtributoJpri, String nombreAtributo) {
		Carta c = elegirPrimerCarta();
		ElementoPocima p = c.getPocima();
		p.modificarAtributo(valorAtributoJpri, nombreAtributo);
		return p;
	}
	
	
	
	protected int obtenerValorAtributo() {
		Atributo a = this.empezarRonda();
		//darleValorAlaPocima(a.getValor());
		return a.getValor();
	}
	
	/*private int darleValorAlaPocima(int valorOriginal) {
		
	}*/
	
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

	public String getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(String e, Juego j) {
		ArrayList<String> estrategias = j.getEstrategias();
		if(estrategias.contains(e))
			this.estrategia = e;
	}
		
}
