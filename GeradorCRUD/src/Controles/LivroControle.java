package Controles;

import Entidades.Livro;
import Tools.ManipulaArquivo;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JoaoAN2 11/11/2021 - 17:52:33
 */
public class LivroControle {

    private List<Livro> list = new ArrayList<>();

    public LivroControle() {
    }

    public void clear() {
        list.clear();
    }

    public void create(Livro livro) {
        list.add(livro);
    }

    public List<Livro> list() {
        return list;
    }

    public Livro read(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (id == list.get(i).getId()) {
                return list.get(i);
            }
        }
        return null;
    }

    public void update(Livro atual, Livro novo) {
        list.set(list.indexOf(atual), novo);
    }

    public void delete(Livro livro) {
        list.remove(livro);
    }

    public void saveData(String path) {
        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        List<String> stringList = new ArrayList<>();
        for (Livro livro : list) {
            stringList.add(livro.toString());
        }
        manipulaArquivo.salvarArquivo(path, stringList);
    }

    public void loadData(String path) {
        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        if (!manipulaArquivo.existeOArquivo(path)) {
            manipulaArquivo.criarArquivoVazio(path);
        }
        List<String> listLoad = manipulaArquivo.abrirArquivo(path);
        Livro livro;
        for (String atribute : listLoad) {
            String aux[] = atribute.split(";");
            livro = new Livro(Integer.valueOf(aux[0]), aux[1], Integer.valueOf(aux[2]), aux[3], Double.valueOf(aux[4]));
            list.add(livro);
        }
    }
}
