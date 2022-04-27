package Controles;
import Entidades.CatReferee;
import Tools.ManipulaArquivo;
import java.util.ArrayList;
import java.util.List;

 /**
 * @author JoaoAN2 27/04/2022 - 14:56:38
 */

public class CatRefereeControle{
 
    private List<CatReferee> list = new ArrayList<>();

    public CatRefereeControle() {
    }

    public void clear() {
        list.clear();
    }

    public List<CatReferee> list() {
        return list;
    }

    public void create(CatReferee catReferee) {
        list.add(catReferee);
    }

    public Catreferee read(String siglaCatReferee) {
        for (int i = 0; i < list.size(); i++){
            if(siglaCatReferee == list.get(i).getSiglaCatReferee()){
                return list.get(i);
            }
        }
        return null;
    }

    public void update(CatReferee atual, CatReferee novo) {
        list.set(list.indexOf(atual), novo);
    }

    public void delete(CatReferee catReferee) {
        list.remove(catReferee);
    }

    public void saveData(String path) {
        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        List<String> stringList = new ArrayList<>();
        for(CatReferee catReferee: list) {
            stringList.add(catReferee.toString());
        }
        manipulaArquivo.salvarArquivo(path, stringList);
    }

    public void loadData(String path) {
        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        if(!manipulaArquivo.existeOArquivo(path)) {
            manipulaArquivo.criarArquivoVazio(path);
        }
        List<String> listLoad = manipulaArquivo.abrirArquivo(path);
        CatReferee catReferee;
        for (String atribute : listLoad) {
            String aux[] = atribute.split(";");
            catReferee = new CatReferee(aux[0], aux[1]);
            list.add(catReferee);
        }
    }
}
