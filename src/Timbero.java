import java.util.ArrayList;

public class Timbero implements Estrategia{

	@Override
	public Atributo elegirAtributo(Carta carta) {
		ArrayList<Atributo> atributos = carta.getAtributos();
		int i = (int) Math.floor(Math.random() * atributos.size());
		return atributos.get(i);
	}

}
