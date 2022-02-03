package Main;

import Tools.ManipulaArquivo;
import Tools.StringsTools;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author JoaoAN2
 */
class GeradorDeGUI {

    GeradorDeGUI(String className, List<String> atributos) {
        StringsTools stringsTools = new StringsTools();
        String classNameMin = stringsTools.firstLetterToLowerCase(className);
        String[] aux;
        List<String> cg = new ArrayList(); // Código gerado

        cg.add("package GUI;\n");

        // Imports
        cg.add("import Entidades." + className + ";\n"
                + "import Tools.ManipulaArquivo;\n"
                + "import Controles." + className + "Controle;\n"
                + "import java.awt.BorderLayout;\n"
                + "import java.awt.CardLayout;\n"
                + "import java.awt.Color;\n"
                + "import java.awt.Container;\n"
                + "import java.awt.FlowLayout;\n"
                + "import java.awt.GridLayout;\n"
                + "import java.awt.event.ActionEvent;\n"
                + "import java.awt.event.ActionListener;\n"
                + "import java.util.ArrayList;\n"
                + "import java.util.List;\n"
                + "import javax.swing.BorderFactory;\n"
                + "import javax.swing.DefaultComboBoxModel;\n"
                + "import javax.swing.JButton;\n"
                + "import javax.swing.JComboBox;\n"
                + "import javax.swing.JDialog;\n"
                + "import javax.swing.JLabel;\n"
                + "import javax.swing.JOptionPane;\n"
                + "import javax.swing.JPanel;\n"
                + "import javax.swing.JScrollPane;\n"
                + "import javax.swing.JTable;\n"
                + "import javax.swing.JTextField;\n"
                + "import javax.swing.table.DefaultTableModel;"
        );

        cg.add("\n /**\n * @author JoaoAN2 " + new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").format(new Date()) + "\n */\n");
        cg.add("public class " + className + "GUI extends JDialog {\n"
                + "    String path = \""+ classNameMin +".csv\";\n"
                + "    " + className + " " + classNameMin + " = new " + className + "();\n"
                + "    String action;"
                + "    "
        );

        cg.add("    private List<" + className + "> list = new ArrayList<>();");
        cg.add("\n    public " + className + "GUI() {\n    }"); // Construtor Vazio
        cg.add("");

        cg.add("}"); // Fim da classe

        for (String linha : cg) {
            System.out.println(linha);
        }

        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        manipulaArquivo.salvarArquivo("src/GUI/" + className + "GUI.java", cg);
    }

}
