package Controles;
import Entidades.Papelaria;
import Tools.ManipulaArquivo;
import java.util.ArrayList;
import java.util.List;

 /**
 * @author JoaoAN2 22/04/2022 - 22:33:51
 */

public class PapelariaControle{
 
    private List<Papelaria> list = new ArrayList<>();

    public PapelariaControle() {
    }

    public void clear() {
        list.clear();
    }

    public List<Papelaria> list() {
        return list;
    }

    public void create(Papelaria papelaria) {
        list.add(papelaria);
    }

    public Papelaria read(int id) {
        for (int i = 0; i < list.size(); i++){
            if(id == list.get(i).getId()){
                return list.get(i);
            }
        }
        return null;
    }

    public void update(Papelaria atual, Papelaria novo) {
        list.set(list.indexOf(atual), novo);
    }

    public void delete(Papelaria papelaria) {
        list.remove(papelaria);
    }

    public void saveData(String path) {
        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        List<String> stringList = new ArrayList<>();
        for(Papelaria papelaria: list) {
            stringList.add(papelaria.toString());
        }
        manipulaArquivo.salvarArquivo(path, stringList);
    }

    public void loadData(String path) {
        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        if(!manipulaArquivo.existeOArquivo(path)) {
            manipulaArquivo.criarArquivoVazio(path);
        }
        List<String> listLoad = manipulaArquivo.abrirArquivo(path);
        Papelaria papelaria;
        for (String atribute : listLoad) {
            String aux[] = atribute.split(";");
            papelaria = new Papelaria(Integer.valueOf(aux[0]), aux[1], Double.valueOf(aux[2]));
            list.add(papelaria);
        }
    }
}
