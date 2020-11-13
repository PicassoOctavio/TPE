import java.util.ArrayList;
import java.util.Collections;

public class Juego {
	private int cantTurnos;	
	private static int nroRonda = 0;	
	private Jugador jugador1;
	private Jugador jugador2;
	private Jugador jugadorTurno;
	private Jugador jugadorTurnoDos;
	private Mazo mazo;
	private boolean seJuegaConPocimas;
	private ArrayList<Pocima> pocimas;
	
	public Juego(int cantTurnos, Jugador jugador1, Jugador jugador2,
			Mazo mazo, boolean seJuegaConPocimas) {
		this.cantTurnos = cantTurnos;
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.mazo = mazo;
		this.jugadorTurno = jugador1;
		this.jugadorTurnoDos = jugador2;
		this.seJuegaConPocimas = seJuegaConPocimas;
		pocimas = new ArrayList<Pocima>();
	}
	//FALTA CONTROLAR EMPATE
	//FALTA COMPROBAR CANT POCIMAS
	
	// INICIA JUEGO
	public void repartirCartas(){ 	
		mazo.darCartas(jugador1, jugador2);
		if(seJuegaConPocimas()) {
			mezclarPocimas();
			repartirPocimas();
		}
	}	
	
	//COMPARAR
	public void comparar() {
		while(!juegoTerminado()) {
			nroRonda++;// ver luego
			imprimirNroRonda();
			Jugador ganadorRonda = jugadorTurno.enfretarse(jugadorTurnoDos, this);
			//imprimir(ganadorRonda)
			
			
			//-----------------------------------------------
			//jugador enfreta a otro jugador
			//devuleven los valores a comparar
			
			/*Atributo atributoJPri = jugadorTurno.empezarRonda();
			//String nombreAtributo = atributoJPri.getNombre();
			double valorAtributoJSeg = jugadorTurnoDos.valorAtributoTurnoDos(atributoJPri);	
			double valorAtributoJpri = atributoJPri.getValor();
			imprimirNroRonda();
			imprimirSeleccionJturno(jugadorTurno, nombreAtributo);
			imprimirAccionJugador(jugadorTurno, nombreAtributo, valorAtributoJpri);
			if(jugadorTurno.tienePocima()) {
				double valorAtributoConPocima = jugadorTurno.aplicarPocima(valorAtributoJpri, nombreAtributo);
				String nombrePocimaJT = jugadorTurno.getNombrePocima();
				imprimirAccionPocima(nombrePocimaJT, valorAtributoConPocima);
				valorAtributoJpri = valorAtributoConPocima;
			}
			imprimirAccionJugador(jugadorTurnoDos, nombreAtributo, valorAtributoJSeg);
			if(jugadorTurnoDos.tienePocima()) {
				double valorAtributoConPocimaJTdos = jugadorTurnoDos.aplicarPocima(valorAtributoJSeg, nombreAtributo);
				String nombrePocimaJTD = jugadorTurnoDos.getNombrePocima();
				imprimirAccionPocima(nombrePocimaJTD, valorAtributoConPocimaJTdos);
				valorAtributoJSeg = valorAtributoConPocimaJTdos;
			}	
			Jugador ganador = ganadorRonda(valorAtributoJpri, valorAtributoJSeg);
			Jugador perdedor = perdedorRonda(valorAtributoJpri, valorAtributoJSeg);
			if(ganador != null && perdedor != null) {
				ganador.recibirCarta(perdedor.darCarta());
				ganador.enviarCartaAlFondo();
				imprimirEstadoCartas(ganador, perdedor);
				imprimirGanadorRonda(ganador);
				setJugadorTurno(ganador);
				setJugadorTurnoDos(perdedor);
			}
			else {//EMPATE
				jugadorTurno.enviarCartaAlFondo();
				jugadorTurnoDos.enviarCartaAlFondo();
				imprimirEmpate();
			}
		}
		Jugador ganoJuego = chequearGanador();
		imprimirGanadorJuego(ganoJuego);
	}*/
		}
	}
	public void imprimirAccionesRonda(String nombreAtributo, Carta cartaJT1, Carta cartaJT2) {
		//String nombAtributo = nombreAtributo;
		//Carta cartaJT1 = cartaJTUno;
		//Carta cartaJT2 = cartaJTDos;
		imprimirSeleccionJturno(jugadorTurno, nombreAtributo);
		imprimirAccionJugador(jugadorTurno, nombreAtributo, cartaJT1);
		imprimirAccionJugador(jugadorTurnoDos, nombreAtributo, cartaJT2);
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
	
	private boolean juegoTerminado(){
		if((!jugador1.tieneCartas() || !jugador2.tieneCartas()) 
				|| noHayMasTurnos())
			return true;
		else
			return false;
	}
	
	private boolean noHayMasTurnos() {
		if(cantTurnos - nroRonda == 0)
			return true;
		else
			return false;
	}
	
	private Jugador ganadorRonda(double Jpri, double Jseg) {
		if(Jpri > Jseg) 
			return jugadorTurno;
		if(Jpri < Jseg) 
			return jugadorTurnoDos;
		else
			return null;
	}
	
	private Jugador perdedorRonda(double Jpri, double Jseg) {
		if(Jpri < Jseg)
			return jugadorTurno;
		if(Jpri > Jseg)
			return jugadorTurnoDos;
		else
			return null;
	}
	//----------------------------- POCIMAS --------------------------------------------
	private void repartirPocimas() {
		for(int i= 0; i< pocimas.size()-1; i++) {
			//System.out.println(cartas.get(i));
			jugadorTurno.addPocimaAcarta(pocimas.get(i));
			pocimas.remove(i); 
			jugadorTurnoDos.addPocimaAcarta(pocimas.get(i));
			pocimas.remove(i);
		}
	}
	private void mezclarPocimas() {
		Collections.shuffle(this.pocimas);
	}
	
	//-----------------------------    METODOS IMPRIMIR --------------------------------------------
	private void imprimirNroRonda() {
		System.out.println("---------------- RONDA " + nroRonda+" ----------------");
	}
	private void imprimirSeleccionJturno(Jugador j, String a) {
		System.out.println("El jugador "+j.getNombre().toUpperCase()+" selecciona competir por el atributo "+ a.toUpperCase());
	}
	
	//le paso (jugadorTurno, nombreAtributo, cartaJT1)
	private void imprimirAccionJugador(Jugador j, String nombreAtributo, Carta carta) {
		System.out.println("La carta de "+j.getNombre().toUpperCase()+" es "+carta.getNombrePersonaje()+" con "+nombreAtributo+" "+carta.getValorAtributoPorNombre(nombreAtributo));
		if(carta.tienePocima())
			imprimirAccionPocima(carta, nombreAtributo);
	}
	private void imprimirAccionPocima(Carta carta, String nombreAtributo) {
		// ver bien acà como pasarle el valor modificado con la pocima
		String datos = carta.getDatosPocima(nombreAtributo);
		//Pocima p = carta.getPocima();
		//double valorAtributoJpri = carta.getValorAtributoPorNombre(nombreAtributo);
		//double valorAPocima = carta.aplicarPocima(valorAtributoJpri, nombreAtributo);
		System.out.println(datos);
	}
	/*private void imprimirAccionPocima(String nombrePocima, double valorAPocima) {
		System.out.println("se aplicó la pocima "+nombrePocima.toUpperCase()+" valor resultante "+valorAPocima);
	}*/
	
	private void imprimirGanadorRonda(Jugador ganador) {
		System.out.println("Ganó la ronda " + ganador.getNombre().toUpperCase() +"\n");
	}
	private void imprimirEstadoCartas(Jugador ganador, Jugador perdedor) {
		System.out.println(ganador.getNombre().toUpperCase()+" posee ahora "+ganador.cantidadCartas()+" cartas y "+perdedor.getNombre()+" posee "+perdedor.cantidadCartas()+" cartas");
	}
	
	private void imprimirGanadorJuego(Jugador jugador) {
		if(jugador!= null)
			System.out.println("GANÓ " + jugador.getNombre().toUpperCase() +" :D" );
		else
			System.out.println("Empate");
	}
	private void imprimirEmpate() {
			System.out.println("La ronda resultó en EMPATE"+"\n");
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
	
	public void addPocima(Pocima p) {
		if(p != null) {
			if(!pocimas.contains(p)) 
				pocimas.add(p);
		}
	}
	
	public int getCantPocimas() {
		return this.pocimas.size();
	}

	public boolean seJuegaConPocimas() {
		return seJuegaConPocimas;
	}

	public void setSeJuegaConPocimas(boolean seJuegaConPocimas) {
		this.seJuegaConPocimas = seJuegaConPocimas;
	}
}