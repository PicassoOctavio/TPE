//import java.util.ArrayList;

public class Jugador implements Estrategia{
	private String nombre;
	//protected ArrayList<Carta> cartasJugador;
	protected Mazo cartasJugador;
	private Estrategia estrategia;
	
	public Jugador(String nombre){
		this.nombre = nombre;
		cartasJugador = new Mazo();
		//cartasJugador = new ArrayList<Carta>();
	}
	
	public Jugador enfretarse(Jugador jugadorTurnoDos, Juego juego){
		Atributo atributoJPri = this.empezarRonda();
		String nombreAtributo = atributoJPri.getNombre();
		//devolverAjuegoNombreAtributo(nombreAtributo);
		Carta cartaJT1 = cartasJugador.elegirPrimerCarta();
		Carta cartaJT2 = jugadorTurnoDos.elegirPrimerCarta();
		
		juego.imprimirAccionesRonda(nombreAtributo, cartaJT1, cartaJT2);
		
		Carta ganadora = cartaJT1.compararCartas(cartaJT2, nombreAtributo);
		if(this.tengoEstaCarta(ganadora)) {
			return this;
		}
		if(jugadorTurnoDos.tengoEstaCarta(ganadora))
			return jugadorTurnoDos;
		else 
			return null;
		
		/*double valorAtributoJSeg = jugadorTurnoDos.valorAtributoTurnoDos(atributoJPri);	
		double valorAtributoJpri = atributoJPri.getValor();
		if(this.tienePocima()) {
			double valorAtributoConPocima = this.aplicarPocima(valorAtributoJpri, nombreAtributo);

			valorAtributoJpri = valorAtributoConPocima;
		}
		if(jugadorTurnoDos.tienePocima()) {
			double valorAtributoConPocimaJTdos = jugadorTurnoDos.aplicarPocima(valorAtributoJSeg, nombreAtributo);
			String nombrePocimaJTD = jugadorTurnoDos.getNombrePocima();
			valorAtributoJSeg = valorAtributoConPocimaJTdos;
		}*/
		//obtenerGanador();	
		
		

	}
	public boolean tengoEstaCarta(Carta ganadora) {
		return cartasJugador.tengoEstaCarta(ganadora);
	}
	
	//comparar atributos elegidos en Carta??
	
	//modifiqué recibir carta
	//agregue en mazo borrarCarta. addCarta, elegirPrimer, mandarAlFondo,
	// y demas
	
	public int cantidadCartas() {
		return cartasJugador.getCantCartas();
	}
	
	// esto no esta bien, jugador no deberia ponerle pocima a la carta CREO
	//ahora lo hace mazo
	public void addPocimaAcarta(Pocima pocima) {
		cartasJugador.addPocimaAcarta(pocima);
		
		/*int i = (int) Math.floor(Math.random() * cartas.size());
		Carta cartaAux = cartas.get(i);
		cartaAux.setPocima(pocima);//carta tiene Pocima, no elementoPocima*/
	}
	
	public void recibirCarta(Carta unaCarta) {//este no cambia, los metodos se llaman igual
		//System.out.println(unaCarta.getNombrePersonaje() + "  asdasd");
		cartasJugador.addCarta(unaCarta);
	}
	
	private void removerCarta() {
		cartasJugador.eliminarCarta();
	}
	
	/*private void removerCarta() { //ANTERIOR
		cartasJugador.remove(cartasJugador.get(0));
	}*/
	
	public Carta elegirPrimerCarta() {
		return cartasJugador.elegirPrimerCarta();
	}
	
	//ahora la logica la hace mazo, jugador solo da la carta
	public Carta darCarta() { 
		return cartasJugador.darCarta();
	}
	
	public void enviarCartaAlFondo() {
		cartasJugador.enviarCartaAlFondo();
	}
	
	@Override
	public Atributo elegirAtributo(Carta carta) {
		return estrategia.elegirAtributo(carta);
	}
	
	public Atributo empezarRonda() {
		Carta primerCartaJ1 = cartasJugador.elegirPrimerCarta();
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
	
	
	//acá me parece bien que el jugador se aplique la pocima
	//pero segun las nuevas modificaciones ahora directamente la carta se aplica la pocima
	public double aplicarPocima(double valorAtributoJpri, String nombreAtributo) {	
		Carta c = elegirPrimerCarta();
		double valorAtributoConPocima = c.aplicarPocima(valorAtributoJpri, nombreAtributo);
		return valorAtributoConPocima;
		/*Pocima p = c.getPocima();
		Atributo atributo = new Atributo(nombreAtributo, valorAtributoJpri);
		double valorAtributoConPocima = p.modificarValor(atributo);
		return valorAtributoConPocima;*/
	}
	
	public String getNombrePocima() { //éste no creo que esté bien
		Carta c = elegirPrimerCarta();
		Pocima pocima = c.getPocima();
		String nombrePocima = pocima.getNombre();
		borrarPocima(c);
		return nombrePocima;
	}
	
	private void borrarPocima(Carta c) {
		c.borrarPocima();
	}
	
	public double obtenerValorAtributo() {
		Atributo a = this.empezarRonda();
		return a.getValor();
	}
	
	public double valorAtributoTurnoDos(Atributo atributo) {
		Carta primerCartaJ2 = this.elegirPrimerCarta();
		double valorJugadorDos = primerCartaJ2.getValorAtributoPorNombre(atributo.getNombre());
		return valorJugadorDos;
	} 
	
	public boolean tieneCartas() {
		if(cartasJugador.getCantCartas() > 0)
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
