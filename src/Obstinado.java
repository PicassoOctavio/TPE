import java.util.ArrayList;

public class Obstinado implements Estrategia{

	@Override
	public Atributo elegirAtributo(Carta carta) {
		ArrayList<Atributo> atributos = carta.getAtributos();
		return atributos.get(0);
	}
}
