
public class Juego {
	private int cantTurnos;
	private int turno;	
	private Jugador jugador1;
	private Jugador jugador2;
	private Mazo mazo;
	
	public Juego(int maxTurnos, int turno, Jugador jugador1, Jugador jugador2, Mazo mazo) {
		this.cantTurnos = maxTurnos;
		this.turno = turno;
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.mazo = mazo;
	}
	
	//setJugadores()
	public void setJugadores() {
		
	}
	// INICIA JUEGO
	private void repartirCartas(){
		mazo.darCartas(jugador1, jugador2);
	}
	
	//COMPARAR
	public void comparar() {
		if(!juegoTerminado()) {
			cantTurnos--;
			if(getTurno()==1)
				empezarRonda(jugador1); 
			
			Carta primerCartaJ1 = jugador1.elegirPrimerCarta();
			Atributo atributoSeleccionado = jugador1.elegirAtributoRandom(primerCartaJ1);
			int valorJugadorUno = atributoSeleccionado.getValor();
			Carta primerCartaJ2 = jugador2.elegirPrimerCarta();
			int valorJugadorDos = primerCartaJ2.getValorAtributoPorNombre(atributoSeleccionado.getNombre());
			if(valorJugadorUno > valorJugadorDos) {
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
		}
		//las cartas al fonfo del mazo
		//está haciendo mucho éste metodo, hay que delegar tareas.
	}
	
	private Jugador chequearGanador() {
		if(jugador1.cartasJugador.size() == 0)
			return jugador2;
		if(jugador2.cartasJugador.size() == 0)
			return jugador1;
		else {
			if(jugador1.cartasJugador.size() > jugador2.cartasJugador.size())
				return jugador1;
			if(jugador1.cartasJugador.size() < jugador2.cartasJugador.size())
				return jugador2;
			//VER CASO EMPATE!	
		}
	}
	
	public boolean juegoTerminado(){
		if((jugador1.cartasJugador.size() == 0 || jugador2.cartasJugador.size() == 0) || cantTurnos == 0)
			return true;
		else
			return false;
	}
	
	public void imprimirGanador(Jugador jugador) {
		System.out.println("Ganó el Jugador " + jugador.getName());
	}
	

	
	//SETS AND GETS
	public int getCantTurnos() {
		return cantTurnos;
	}

	public void setCantTurnos(int cantTurnos) {
		this.cantTurnos = cantTurnos;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno() {
		if(turno == 1) {
			turno = 2;
		}else
			turno = 1;
	} 
	
	
	
	
	//------------- METODOS Y FUNCIONES -------------
	//repartirCartas() HECHO
	//setTurno()
	//resultadoRonda()
	
	//compararCartas()
	
	//ganador()
	
	//crearMazo()
	//verificarCartas()
}
