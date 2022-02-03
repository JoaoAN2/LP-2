package Controlls;

import Entities.Federation;
import Tools.DateTools;
import Tools.ManipulaArquivo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JoaoAN2
 */
public class ControllFederation {
    
    private List<Federation> federationList = new ArrayList<>();
    DateTools dateTools = new DateTools();
    
    
    public void create(Federation federation){
        federationList.add(federation);
    }
    
    public Federation read(String sigla){
        for (int i = 0; i<federationList.size(); i++){
            if(sigla.equals(federationList.get(i).getSigla_federation())){
                return federationList.get(i);
            }
        }
        return null;
    }
    
    public void update(Federation atual, Federation newFederation){
        federationList.set(federationList.indexOf(atual), newFederation);
    }
    
    public void delete(Federation federation){
        federationList.remove(federation);
    }
    
    public List list(){
        return federationList;
    }
    
    public void saveData(String path) {
        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        List<String> stringList = new ArrayList<>();
        for (Federation federation : federationList) {
            stringList.add(federation.toString());
        }
        manipulaArquivo.salvarArquivo(path, stringList);
    }
    
    public void loadData(String path) {
        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        if(!manipulaArquivo.existeOArquivo(path)){
            manipulaArquivo.criarArquivoVazio(path);
        }
        
        List<String> list = manipulaArquivo.abrirArquivo(path);
        
        Federation federation;
        for (String atribute : list) {
            String aux[] = atribute.split(";");
            federation = new Federation(aux[0], aux[1]);
            federationList.add(federation);
        }
    }
}
