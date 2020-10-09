
public class Juego {
	private int cantTurnos;
	private Jugador jugador1;
	private Jugador jugador2;
	private Mazo mazo;
	
	public Juego(int maxTurnos, Jugador jugador1, Jugador jugador2, Mazo mazo) {
		this.cantTurnos = maxTurnos;
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
		Atributo atributoSeleccionado = jugador1.elegirAtributoRandom();
		atributoSeleccionado.getValor();//
		
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
