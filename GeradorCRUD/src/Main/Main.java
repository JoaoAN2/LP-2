package Main;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JoaoAN2
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        List<String> atributos = new ArrayList(); // Lista de atributos.
        String className = "CatReferee"; // Nome da classe.
        
        // Atributos da classe.
        atributos.add("String;siglaCatReferee;11");
        atributos.add("String;nameCatReferee;45");
        
        GeradorDeEntidades geradorDeEntidades = new GeradorDeEntidades(className, atributos);
        GeradorDeControles geradorDeControles = new GeradorDeControles(className, atributos);
        GeradorDeGUI geradorDeGUI = new GeradorDeGUI(className, atributos);
        
    }

}
