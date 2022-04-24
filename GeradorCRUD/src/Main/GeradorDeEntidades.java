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
class GeradorDeEntidades {

    GeradorDeEntidades(String className, List<String> atributos) {
        StringTools stringTools = new StringTools();
        List<String> cg = new ArrayList(); // Código gerado

        cg.add("package Entidades;");
        cg.add("\n /**\n * @author JoaoAN2 "+ new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").format(new Date()) +"\n */\n");
        cg.add("public class " + className + "{\n ");

        // Declarar elementos
        String[] aux;
        for (int i = 0; i < atributos.size(); i++) {
            aux = atributos.get(i).split(";"); 
            cg.add("    private " + aux[0] + " " + aux[1] + ";"); // Elementos encapsulados
        } // Fim declarar

        cg.add("\n    public " + className + "() {\n    }\n"); // Construtor Vazio

        // Construtor entidade
        String parametros = "";
        for (int i = 0; i < atributos.size(); i++) {
            aux = atributos.get(i).split(";");
            parametros = parametros + aux[0] + " " + aux[1] + ", ";
        }

        parametros = parametros.substring(0, parametros.length() - 2);
        cg.add("    public " + className + "(" + parametros + ") {");
        for (int i = 0; i < atributos.size(); i++) {
            aux = atributos.get(i).split(";");
            cg.add("        this." + aux[1] + " = " + aux[1] + ";");
        }

        cg.add("    }"); // Fim Construtor entidade

        // Gets e Sets
        for (int i = 0; i < atributos.size(); i++) {
            aux = atributos.get(i).split(";");
            cg.add("\n    public " + aux[0] + " get" + stringTools.firstLetterToUpperCase(aux[1]) + "() {\n        return " + aux[1] + ";\n    }");
            cg.add("\n    public void " + "set" + stringTools.firstLetterToUpperCase(aux[1]) + "(" + aux[0] + " " + aux[1] + ") {\n        this." + aux[1] + " = " + aux[1] + ";\n    }");
        } // Fim Gets e Sets

        // toString
        String toString = "";
        for (int i = 0; i < atributos.size(); i++) {
            aux = atributos.get(i).split(";");
            toString = toString + aux[1] + " + \";\" + ";
        }
        toString = toString.substring(0, toString.length() - 9);
        cg.add("\n    @Override\n    public String toString() {\n        return " + toString + ";\n    }");
        // Fim toString

        cg.add("}"); // Fim da classe

        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        manipulaArquivo.salvarArquivo("src/Entidades/" + className + ".java", cg);
    }
   
}
