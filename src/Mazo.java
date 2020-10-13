import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
	private int cantAtributos;
	private int cantCartas;
	protected ArrayList<Carta> cartas;

	public Mazo(int cantAtributos, int cantCartas) {
		this.cantAtributos = cantAtributos;
		this.cantCartas = cantCartas;
		cartas = new ArrayList<Carta>();
	}
	
	//crearMazo() HECHO
	//verificarCartas() HECHO
	//getTamañoMazo() HECHO
	
	//darPrimerCarta() 
	//guardarCartaAlFinal()
	
	private void chequearMazo() {
		for(int i=0; i< cartas.size();i++) {
			Carta cartaAux = cartas.get(i);
			if(!cartaAux.esDelMismoTipo(cartaAux))	// esta bien pasarle la misma carta?
				cartas.remove(i);
		}
	}//hacer metodo borrarCarta() que no pertenece
	

	
	public ArrayList<Carta> getMazo(){
		return new ArrayList<Carta>(this.cartas);
	}
	
	private void mezclarCartas() {
		Collections.shuffle(cartas);
	}
	
	protected void darCartas(Jugador jugador1, Jugador jugador2) {
		mezclarCartas();
		for(int i= 0; i< cartas.size(); i++) {
			jugador1.recibirCarta(cartas.get(i));
			cartas.remove(i); // se acomoda solo?
			jugador2.recibirCarta(cartas.get(i));
			cartas.remove(i);
		}
	}
	/*public Carta getCartaRandom() {
		int i = Math.floor(Math.random() * this.getTamanioMazo() + 1); // consultar esto!
		return cartas.get(i);
		//cartas.remove(i); si remuevo la carta no la retorno, y si no la remuevo el j2 la puede obtener
	}*/
	
	public int getTamanioMazo() {
		return cartas.size();
	}
	
	public void addCarta(Carta unaCarta) {
		if(cartas.size() < 1) {
			cartas.add(unaCarta);			
			cantCartas++;
		}
		if(!cartas.contains(unaCarta)) {
			cartas.add(unaCarta);
			cantCartas++;
		}
		//si el mazo esta vacio agrego HECHO
		//si ya tiene una carta, verificar que sean iguales HECHO con equals
	}
	
	//SETS AND GETS
	public int getCantAtributos() {
		return cantAtributos;
	}

	public void setCantAtributos(int cantAtributos) {
		this.cantAtributos = cantAtributos;
	}
}
/*import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Mazo {

    public static void mostrarMazo(String jsonFile) {
        //URL url = getClass().getResource(jsonFile);
        File jsonInputFile = new File(jsonFile);
        InputStream is;
        try {
            is = new FileInputStream(jsonInputFile);
            // Creo el objeto JsonReader de Json.
            JsonReader reader = Json.createReader(is);
            // Obtenemos el JsonObject a partir del JsonReader.
            JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
            for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
                String nombreCarta = carta.getString("nombre").toUpperCase();
                JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
                String atributosStr = "";
                for (String nombreAtributo:atributos.keySet())
                    atributosStr = atributosStr + nombreAtributo + ": " +
                            atributos.getInt(nombreAtributo) + "; ";
                System.out.println(nombreCarta+"\t\t\t"+atributosStr);
            }

            reader.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



}
*/
