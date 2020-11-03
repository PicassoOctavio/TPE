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
        mazo.mostrarMazo(); 
        mazo.chequearMazo();
        mazo.linea();
        mazo.mostrarMazo(); 
        
        Jugador gian = new Jugador("gian");
        Jugador octi = new Jugador("octi");
        Juego juego = new Juego(90, octi, gian, mazo, octi, gian, true);
        Timbero timbero = new Timbero(); 
        Ambicioso ambicioso = new Ambicioso(); 
        Obstinado obstinado = new Obstinado(); 
        PocimaIncrementadora fortalecedora = new PocimaIncrementadora("fortalecedora", 20);
        PocimaIncrementadora fortalecedoraDos = new PocimaIncrementadora("fortalecedora", 30);
        PocimaIncrementadora fortalecedoraPlus = new PocimaIncrementadora("fortalecedoraPlus", 50);
        PocimaIncrementadora fortalecedoraPlusDos = new PocimaIncrementadora("fortalecedoraPlus", 60);
        PocimaDecrementadora kriptonita = new PocimaDecrementadora("kriptonita", 25);
        PocimaDecrementadora kriptonitaDos = new PocimaDecrementadora("kriptonita", 35);
        PocimaDecrementadora reductorPlomo = new PocimaDecrementadora("reductorPlomo", 55);
        PocimaDecrementadora reductorPlomoDos = new PocimaDecrementadora("reductorPlomo", 65);
        PocimaValorFijo valeCuatro = new PocimaValorFijo("valeCuatro", 4);
        PocimaValorFijo valeCuatroDos = new PocimaValorFijo("valeCuatro", 6);
        PocimaValorFijo numeroMagico = new PocimaValorFijo("numeroMagico", 23);
        PocimaValorFijo numeroMagicoDos = new PocimaValorFijo("numeroMagico", 24);
        PocimaSelectiva PSF = new PocimaSelectiva("Selectiva Fuerza", "fuerza", 35);
        PocimaSelectiva PSFdos = new PocimaSelectiva("Selectiva Fuerza", "fuerza", 36);
        PocimaSelectiva PSP = new PocimaSelectiva("Selectiva Peso", "peso", 43);
        PocimaSelectiva PSPdos = new PocimaSelectiva("Selectiva Peso", "peso", 44);
        Cocktail cocktail = new Cocktail("cocktail", fortalecedora, fortalecedoraPlus);
        Cocktail cocktailDos = new Cocktail("cocktail", kriptonita, reductorPlomo);   
        juego.addEstrategia(timbero);
        juego.addEstrategia(ambicioso);
        juego.addEstrategia(obstinado);
        juego.addPocima(fortalecedora);
        juego.addPocima(fortalecedoraDos);
        juego.addPocima(fortalecedoraPlus);
        juego.addPocima(fortalecedoraPlusDos);
        juego.addPocima(kriptonita);
        juego.addPocima(kriptonitaDos);
        juego.addPocima(reductorPlomo);
        juego.addPocima(reductorPlomoDos);
        juego.addPocima(valeCuatro);
        juego.addPocima(valeCuatroDos);
        juego.addPocima(numeroMagico);
        juego.addPocima(numeroMagicoDos);
        juego.addPocima(PSF);
        juego.addPocima(PSFdos);
        juego.addPocima(PSP);
        juego.addPocima(PSPdos);
        juego.addPocima(cocktail);
        juego.addPocima(cocktailDos);
        gian.setEstrategia(ambicioso);
        octi.setEstrategia(ambicioso);
        juego.repartirCartas();
        juego.comparar();
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

    
    
    