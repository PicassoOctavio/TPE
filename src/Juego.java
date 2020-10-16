
public class Juego {
	private int cantTurnos;
	private static int nroRonda = 0;	
	private Jugador jugador1;
	private Jugador jugador2;
	private Jugador jugadorTurno;
	private Jugador jugadorTurnoDos;
	private Mazo mazo;
	
	public Juego(int maxTurnos, Jugador jugador1, Jugador jugador2,
			Mazo mazo, Jugador jugadorTurno, Jugador jugadorTurnoDos) {
		this.cantTurnos = maxTurnos;
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.mazo = mazo;
		this.jugadorTurno = jugadorTurno;
		this.jugadorTurnoDos = jugadorTurnoDos;
	}
	//variable jugador turno que va cambiando segun el turno
	
	// INICIA JUEGO
	public void repartirCartas(){
		mazo.darCartas(jugador1, jugador2);
	}

	//COMPARAR
	public void comparar() {
		while(!juegoTerminado()) {
			cantTurnos--;
			nroRonda++;//no lo estamos usando
			Atributo atributoJPri = jugadorTurno.empezarRonda();
			String nombreAtributo = atributoJPri.getNombre();
			int valorAtributoJSeg = jugadorTurnoDos.valorAtributoTurnoDos(atributoJPri);
			int valorAtributoJpri = atributoJPri.getValor();
			imprimirNroRonda();
			imprimirSeleccionJturno(jugadorTurno, nombreAtributo);
			imprimirAccionJugador(jugadorTurno, nombreAtributo, valorAtributoJpri);
			imprimirAccionJugador(jugadorTurnoDos, nombreAtributo, valorAtributoJSeg);
			Jugador ganador = ganadorRonda(valorAtributoJpri, valorAtributoJSeg);
			Jugador perdedor = perdedorRonda(valorAtributoJpri, valorAtributoJSeg);
			if(ganador != null && perdedor != null) {
				//imprimirGanadorRonda(ganador);	
				ganador.recibirCarta(perdedor.darCarta());
				ganador.enviarCartaAlFondo();
				imprimirEstadoCartas(ganador, perdedor);
				imprimirGanadorRonda(ganador);
				setJugadorTurno(ganador);
				setJugadorTurnoDos(perdedor);
			}
		}
		Jugador ganoJuego = chequearGanador();
		imprimirGanadorJuego(ganoJuego);
	}
	
	private Jugador chequearGanador() {
		if(!jugador1.tieneCartas())
			return jugador2;
		if(!jugador2.tieneCartas())
			return jugador1;
		else {
			if(jugador1.cantidadCartas() > jugador2.cantidadCartas())
				return jugador1;
			if(jugador1.cantidadCartas() < jugador2.cantidadCartas())
				return jugador2;
			else
				return null;
		}
	}
	
	private boolean juegoTerminado(){//jugador devuelve cant cartas ó boolean si le quedan cartas
		if((!jugador1.tieneCartas() || !jugador2.tieneCartas()) 
				|| noHayMasTurnos())
			return true;
		else
			return false;
	}
	
	private boolean noHayMasTurnos() {
		if(cantTurnos == 0)
			return true;
		else
			return false;
	}
	
	private Jugador ganadorRonda(int Jpri, int Jseg) {
		if(Jpri > Jseg) 
			return jugadorTurno;
		if(Jpri < Jseg) 
			return jugadorTurnoDos;
		else
			return null;
	}
	
	private Jugador perdedorRonda(int Jpri, int Jseg) {
		if(Jpri < Jseg)
			return jugadorTurno;
		if(Jpri > Jseg)
			return jugadorTurnoDos;
		else
			return null;
	}
	//-----------------------------    METODOS IMPRIMIR --------------------------------------------
	public void imprimirNroRonda() {
		System.out.println("---------------- RONDA " + nroRonda+" ----------------");
	}
	public void imprimirSeleccionJturno(Jugador j, String a) {
		System.out.println("El jugador "+j.getNombre().toUpperCase()+" selecciona competir por el atributo "+ a.toUpperCase());
	}
	
	public void imprimirAccionJugador(Jugador j, String a, int valorJpri) {
		Carta carta = j.elegirPrimerCarta();
		System.out.println("La carta de "+j.getNombre().toUpperCase()+" es "+carta.getNombrePersonaje()+" con "+a+" "+valorJpri);
	}
	
	public void imprimirGanadorRonda(Jugador ganador) {
		System.out.println("Ganó la ronda " + ganador.getNombre().toUpperCase() +"\n");
	}
	public void imprimirEstadoCartas(Jugador ganador, Jugador perdedor) {
		System.out.println(ganador.getNombre().toUpperCase()+" posee ahora "+ganador.cantidadCartas()+" cartas y "+perdedor.getNombre()+" posee "+perdedor.cantidadCartas()+" cartas");
	}
	
	public void imprimirGanadorJuego(Jugador jugador) {
		if(jugador!= null)
			System.out.println("GANÓ " + jugador.getNombre().toUpperCase() +" :D" );
		else
			System.out.println("Empate");
	}
	public void linea() {
		System.out.println("--------------------------------------------------------");
	}
	
	//SETS AND GETS
	public int getCantTurnos() {
		return cantTurnos;
	}

	public void setCantTurnos(int cantTurnos) {
		this.cantTurnos = cantTurnos;
	}

	public Jugador getJugadorTurno() {
		return jugadorTurno;
	}

	public void setJugadorTurno(Jugador jugadorTurno) {
		this.jugadorTurno = jugadorTurno;
	}

	public Jugador getJugadorTurnoDos() {
		return jugadorTurnoDos;
	}

	public void setJugadorTurnoDos(Jugador jugadorTurnoDos) {
		this.jugadorTurnoDos = jugadorTurnoDos;
	}
	
	//------------- METODOS Y FUNCIONES -------------
	//repartirCartas() HECHO
	//setTurno()
	//resultadoRonda()
	
	//compararCartas()
	
	//ganador()
	
	//crearMazo()
	//verificarCartas()
	
	//como defino jugadorSinTurno
	//
	
	//---------------------------------------------------------
	/*if(getTurno() == 1) {
		Atributo atributoSelec = jugador1.empezarRonda(jugador1); 
		int valorJugadorUno = atributoSelec.getValor();
		int valorJugadorDos = jugador2.valorAtributoTurnoDos(jugador2, atributoSelec);
	}else {
		Atributo atributoSelec = jugador2.empezarRonda(jugador2); 
		int valorJugadorDos = atributoSelec.getValor();
		int valorJugadorUno = jugador1.valorAtributoTurnoDos(jugador1, atributoSelec);
	}*/
	//Carta primerCartaJ1 = jugador1.elegirPrimerCarta();
	//Atributo atributoSeleccionado = jugador1.elegirAtributoRandom(primerCartaJ1);
	//int valorJugadorUno = atributoSeleccionado.getValor();
	//Carta primerCartaJ2 = jugador2.elegirPrimerCarta();
	//int valorJugadorDos = primerCartaJ2.getValorAtributoPorNombre(atributoSeleccionado.getNombre());
	
	//definirGanadorRonda()
	/*if(valorJugadorUno > valorJugadorDos) {
		System.out.println("Ganó la ronda " + jugador1.getName());
		jugador1.recibirCarta(primerCartaJ2);
		jugador2.removerCarta();
	}
	if(valorJugadorUno < valorJugadorDos) {
		System.out.println("Ganó la ronda " + jugador2.getName());
		jugador2.recibirCarta(primerCartaJ1);
		jugador1.removerCarta();
	}
	else {
		jugador1.recibirCarta(primerCartaJ1);
		jugador1.removerCarta();
		jugador2.recibirCarta(primerCartaJ2);
		jugador2.removerCarta();
	}
}else {
	Jugador ganador = chequearGanador();
	imprimirGanador(ganador);
}*/
//las cartas al fonfo del mazo
//está haciendo mucho éste metodo, hay que delegar tareas.
}
