import java.util.ArrayList;

public class Ambicioso implements Estrategia{

	@Override
	public Atributo elegirAtributo(Carta carta) {
		ArrayList<Atributo> atributos = carta.getAtributos();
		Atributo aux = new Atributo(null, 0);
		for(Atributo atributo: atributos){
			if (atributo.getValor() > aux.getValor())
				aux = atributo;
		}
		return aux;
	}
}
