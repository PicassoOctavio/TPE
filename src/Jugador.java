import java.util.ArrayList;

public class Jugador implements Estrategia{
	private String nombre;
	protected ArrayList<Carta> cartasJugador;
	private Estrategia estrategia;
	
	public Jugador(String nombre){
		this.nombre = nombre;
		cartasJugador = new ArrayList<Carta>();
	}
	
	//public los metodos que usa otra clase
	protected int cantidadCartas() {
		return cartasJugador.size();
	}
	
	public void addPocimaAcarta(Pocima pocima) {
		int i = (int) Math.floor(Math.random() * cartasJugador.size());
		Carta cartaAux = cartasJugador.get(i);
		cartaAux.setPocima(pocima);//carta tiene Pocima, no elementoPocima
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
	
	@Override
	public Atributo elegirAtributo(Carta carta) {
		return estrategia.elegirAtributo(carta);
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
	
	public int aplicarPocima(int valorAtributoJpri, String nombreAtributo) {
		Carta c = elegirPrimerCarta();
		Pocima p = c.getPocima();
		Atributo atributo = new Atributo(nombreAtributo, valorAtributoJpri);
		int valorAtributoConPocima = p.modificarValor(atributo);
		return valorAtributoConPocima;
	}
	
	public String getNombrePocima() {
		Carta c = elegirPrimerCarta();
		Pocima pocima = c.getPocima();
		String nombrePocima = pocima.getNombre();
		borrarPocima(c);
		return nombrePocima;
	}
	
	public void borrarPocima(Carta c) {
		c.borrarPocima();
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

	public Estrategia getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(Estrategia estrategia) {
		this.estrategia = estrategia;
	}
}
