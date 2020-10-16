import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class Main {
    public static void main(String[] args) {
        String mazoPath = "./src/superheroes.json";

        Mazo mazo = cargarMazo(mazoPath);
        mazo.mostrarMazo(); //HACER ESTE METODO
        mazo.chequearMazo();
        mazo.linea();
        mazo.mostrarMazo(); //HACER ESTE METODO
        
        Jugador gian = new Jugador("gian");
        Jugador octi = new Jugador("octi");
        
        Juego juego = new Juego(200, octi, gian, mazo, octi, gian);
        juego.repartirCartas();
        juego.comparar();
        //mazo.getCantCartas();
    }
    
    public static Mazo cargarMazo(String jsonFile) {
        //URL url = getClass().getResource(jsonFile);
        File jsonInputFile = new File(jsonFile);
        InputStream is;
        Mazo mazo = new Mazo(); 
        try {
            is = new FileInputStream(jsonInputFile);
            // Creo el objeto JsonReader de Json.
            JsonReader reader = Json.createReader(is);
            // Obtenemos el JsonObject a partir del JsonReader.
            JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
            for (JsonObject cartaJson : cartas.getValuesAs(JsonObject.class)) {
                String nombreCarta = cartaJson.getString("nombre");
                Carta unaCarta = new Carta(nombreCarta);
                JsonObject atributos = (JsonObject) cartaJson.getJsonObject("atributos");
                //String atributosStr = "";
                for (String nombreAtributo:atributos.keySet()) {
                	Atributo unAtributo = new Atributo(nombreAtributo, atributos.getInt(nombreAtributo));
                    unaCarta.addAtributo(unAtributo);
                	//atributosStr = atributosStr + nombreAtributo + ": " +
                            //atributos.getInt(nombreAtributo) + "; ";
                }
                mazo.addCarta(unaCarta);
                //System.out.println(nombreCarta+"\t\t\t"+atributosStr);
            }
            reader.close();
            return mazo;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return mazo;
        }
    }
}

    
    
    