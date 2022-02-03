package GUI;
import Entidades.Livro;

import Tools.ManipulaArquivo;
import Controles.LivroControle;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

 /**
 * @author JoaoAN2 11/11/2021 - 18:29:12
 */

public class LivroGUI extends JDialog {
    String path = "livro.csv";
    Livro livro = new Livro();
    String action;    
    private List<Livro> list = new ArrayList<>();

    public LivroGUI() {
    }

}
