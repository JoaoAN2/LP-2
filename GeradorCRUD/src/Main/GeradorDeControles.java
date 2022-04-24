package Main;

import Tools.ManipulaArquivo;
import Tools.StringTools;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author JoaoAN2
 */
class GeradorDeControles {

    GeradorDeControles(String className, List<String> atributos) {
        StringTools stringsTools = new StringTools();
        String[] aux;
        List<String> cg = new ArrayList(); // Código gerado

        cg.add("package Controles;");

        // Imports
        cg.add("import Entidades." + className + ";\nimport Tools.ManipulaArquivo;\nimport java.util.ArrayList;\nimport java.util.List;");

        cg.add("\n /**\n * @author JoaoAN2 " + new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").format(new Date()) + "\n */\n");
        cg.add("public class " + className + "Controle" + "{\n ");

        cg.add("    private List<" + className + "> list = new ArrayList<>();");
        cg.add("\n    public " + className + "Controle() {\n    }"); // Construtor Vazio

        cg.add("\n    public void clear() {"
                + "\n        list.clear();"
                + "\n    }");

        cg.add("\n    public List<" + className + "> list() {"
                + "\n        return list;"
                + "\n    }");

        cg.add("\n    public void create(" + className + " " + stringsTools.firstLetterToLowerCase(className) + ") {"
                + "\n        list.add(" + stringsTools.firstLetterToLowerCase(className) + ");"
                + "\n    }");

        aux = atributos.get(0).split(";");

        cg.add("\n    public " + stringsTools.capitalize(className) + " read(" + aux[0] + " " + aux[1] + ") {\n        for (int i = 0; i < list.size(); i++){\n            if(" + aux[1] + " == list.get(i).get" + stringsTools.capitalize(aux[1]) + "()){\n                return list.get(i);\n            }\n        }\n        return null;\n    }");
        cg.add("\n    public void update(" + className + " atual, " + className + " novo) {\n        list.set(list.indexOf(atual), novo);\n    }");
        cg.add("\n    public void delete(" + className + " " + stringsTools.firstLetterToLowerCase(className) + ") {\n        list.remove(" + stringsTools.firstLetterToLowerCase(className) + ");\n    }");

        cg.add("\n    public void saveData(String path) {"
                + "\n        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();"
                + "\n        List<String> stringList = new ArrayList<>();"
                + "\n        for(" + className + " " + stringsTools.firstLetterToLowerCase(className) + ": list) {"
                + "\n            stringList.add(" + stringsTools.firstLetterToLowerCase(className) + ".toString());"
                + "\n        }"
                + "\n        manipulaArquivo.salvarArquivo(path, stringList);"
                + "\n    }");

        String parametros = "";
        for (int i = 0; i < atributos.size(); i++) {
            aux = atributos.get(i).split(";");
            if (aux[0].equals("String")) {
                parametros += "aux[" + i + "], ";
            } else if ("int".equals(aux[0])) {
                parametros += "Integer.valueOf(aux[" + i + "]), ";
            } else if ("double".equals(aux[0])) {
                parametros += "Double.valueOf(aux[" + i + "]), ";
            }
        }

        parametros = parametros.substring(0, parametros.length() - 2);

        cg.add("\n    public void loadData(String path) {"
                + "\n        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();"
                + "\n        if(!manipulaArquivo.existeOArquivo(path)) {"
                + "\n            manipulaArquivo.criarArquivoVazio(path);"
                + "\n        }"
                + "\n        List<String> listLoad = manipulaArquivo.abrirArquivo(path);"
                + "\n        " + className + " " + stringsTools.firstLetterToLowerCase(className) + ";"
                + "\n        for (String atribute : listLoad) {"
                + "\n            String aux[] = atribute.split(\";\");"
                + "\n            " + stringsTools.firstLetterToLowerCase(className) + " = new " + className + "(" + parametros + ");"
                + "\n            list.add(" + stringsTools.firstLetterToLowerCase(className) + ");"
                + "\n        }"
                + "\n    }");

        cg.add("}"); // Fim da classe

        for (String linha : cg) {
            System.out.println(linha);
        }

        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        manipulaArquivo.salvarArquivo("src/Controles/" + className + "Controle.java", cg);
    }

}
