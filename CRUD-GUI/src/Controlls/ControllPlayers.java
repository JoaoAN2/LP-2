package Controlls;

import Entities.Player;
import Tools.DateTools;
import Tools.ManipulaArquivo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JoaoAN2
 */
public class ControllPlayers {
    
    private List<Player> playersList = new ArrayList<>();
    DateTools dateTools = new DateTools();
    
    
    public void create(Player player){
        playersList.add(player);
    }
    
    public Player read(int id){
        for (int i = 0; i<playersList.size(); i++){
            if(id == playersList.get(i).getId()){
                return playersList.get(i);
            }
        }
        return null;
    }
    
    public void update(Player atual, Player newPlayer){
        playersList.set(playersList.indexOf(atual), newPlayer);
    }
    
    public void delete(Player player){
        playersList.remove(player);
    }
    
    public List list(){
        return playersList;
    }
    
    public void saveData(String path) {
        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        List<String> stringList = new ArrayList<>();
        for (Player player : playersList) {
            stringList.add(player.toString());
        }
        manipulaArquivo.salvarArquivo(path, stringList);
    }
    
    public void loadData(String path) {
        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        if(!manipulaArquivo.existeOArquivo(path)){
            manipulaArquivo.criarArquivoVazio(path);
        }
        
        List<String> list = manipulaArquivo.abrirArquivo(path);
        
        Player player;
        for (String atribute : list) {
            String aux[] = atribute.split(";");
            player = new Player(Integer.valueOf(aux[0]), aux[1], aux[2], dateTools.conversionStringToDate(aux[3]), Integer.valueOf(aux[4]));
            playersList.add(player);
        }
    }
}
