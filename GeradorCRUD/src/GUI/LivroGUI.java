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
 * @author JoaoAN2 22/04/2022 - 14:29:08
 */
public class LivroGUI extends JDialog {

    String path = "livro.csv";

    Livro livro = new Livro();
    LivroControle LivroControle = new LivroControle();
    ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
    String action;

    Container cp;
    JPanel pnNorth = new JPanel();
    JPanel pnSouth = new JPanel();
    JPanel pnCenter = new JPanel();
    JPanel pnList = new JPanel(new GridLayout(1, 1));

    String[] col = new String[]{"Id", "Nome", "AnoDeLancamento", "Autor", "Preco"};
    String[][] data = new String[0][col.length];
    DefaultTableModel model = new DefaultTableModel(data, col);

    CardLayout cardLayout = new CardLayout();
    JTable table = new JTable(model);
    JScrollPane scrollTable = new JScrollPane();
    JPanel pnEmpty = new JPanel(new GridLayout(6, 1));
    JButton btnSearch = new JButton("Buscar");
    JButton btnCreate = new JButton("Adicionar");
    JButton btnSave = new JButton("Salvar");
    JButton btnUpdate = new JButton("Alterar");
    JButton btnDelete = new JButton("Excluir");
    JButton btnList = new JButton("Listar");
    JButton btnCancel = new JButton("Cancelar");

    JLabel lbId = new JLabel("Id");
    JTextField tfId = new JTextField(11);

    JLabel lbNome = new JLabel("Nome");
    JTextField tfNome = new JTextField(45);

    JLabel lbAnoDeLancamento = new JLabel("AnoDeLancamento");
    JTextField tfAnoDeLancamento = new JTextField(11);

    JLabel lbAutor = new JLabel("Autor");
    JTextField tfAutor = new JTextField(45);

    JLabel lbPreco = new JLabel("Preco");
    JTextField tfPreco = new JTextField(45);

    private List<Livro> list = new ArrayList<>();

    public void clear() {
        tfNome.setText("");
        tfAnoDeLancamento.setText("");
        tfAutor.setText("");
        tfPreco.setText("");
    }

    public void enabled() {
        tfNome.setEditable(true);
        tfAnoDeLancamento.setEditable(true);
        tfAutor.setEditable(true);
        tfPreco.setEditable(true);
    }

    public void disabled() {
        tfNome.setEditable(false);
        tfAnoDeLancamento.setEditable(false);
        tfAutor.setEditable(false);
        tfPreco.setEditable(false);
    }

    public LivroGUI() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        setTitle("CRUD - Livro");

        pnCenter.setLayout(new GridLayout(4, col.length - 1));
        pnNorth.setLayout(new FlowLayout(FlowLayout.LEFT));

        cp.add(pnNorth, BorderLayout.NORTH);
        cp.add(pnSouth, BorderLayout.SOUTH);
        cp.add(pnCenter, BorderLayout.CENTER);

        pnNorth.setBackground(Color.cyan);
        pnCenter.setBorder(BorderFactory.createLineBorder(Color.black));

        pnNorth.add(lbId);
        pnNorth.add(tfId);
        pnNorth.add(btnSearch);
        pnNorth.add(btnList);
        pnNorth.add(btnCreate);
        pnNorth.add(btnUpdate);
        pnNorth.add(btnDelete);
        pnNorth.add(btnSave);
        pnNorth.add(btnCancel);

        btnCreate.setVisible(false);
        btnUpdate.setVisible(false);
        btnDelete.setVisible(false);
        btnSave.setVisible(false);
        btnCancel.setVisible(false);

        disabled();

        pnCenter.add(lbNome);
        pnCenter.add(tfNome);

        pnCenter.add(lbAnoDeLancamento);
        pnCenter.add(tfAnoDeLancamento);

        pnCenter.add(lbAutor);
        pnCenter.add(tfAutor);

        pnCenter.add(lbPreco);
        pnCenter.add(tfPreco);

        for (int i = 0; i < 5; i++) {
            pnEmpty.add(new JLabel(" "));
        }

        pnSouth.setLayout(cardLayout);
        pnSouth.add(pnEmpty, "empty");
        pnSouth.add(pnList, "list");

        LivroControle.loadData(path);

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cardLayout.show(pnSouth, "warning");
                livro = LivroControle.read(Integer.valueOf(tfId.getText()));
                if (livro != null) {
                    btnCreate.setVisible(false);
                    btnUpdate.setVisible(true);
                    btnDelete.setVisible(true);

                    tfNome.setText(livro.getNome());
                    tfAnoDeLancamento.setText(String.valueOf(livro.getAnoDeLancamento()));
                    tfAutor.setText(livro.getAutor());
                    tfPreco.setText(String.valueOf(livro.getPreco()));
                } else {
                    clear();
                    btnCreate.setVisible(true);
                    btnUpdate.setVisible(false);
                    btnDelete.setVisible(false);
                }
            }
        });

        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tfNome.requestFocus();
                tfId.setEnabled(false);
                enabled();

                btnSearch.setVisible(false);
                btnCreate.setVisible(false);
                btnSave.setVisible(true);
                btnCancel.setVisible(true);
                btnList.setVisible(false);

                action = "create";
            }
        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Livro oldLivro = livro;

                if ("create".equals(action)) {
                    livro = new Livro();
                }

                livro.setId(Integer.valueOf(tfId.getText()));
                livro.setNome(tfNome.getText());
                livro.setAnoDeLancamento(Integer.valueOf(tfAnoDeLancamento.getText()));
                livro.setAutor(tfAutor.getText());
                livro.setPreco(Double.parseDouble(tfPreco.getText()));

                if ("create".equals(action)) {
                    LivroControle.create(livro);
                }

                if ("update".equals(action)) {
                    LivroControle.update(livro, oldLivro);
                }

                btnSearch.setVisible(true);
                btnList.setVisible(true);
                btnSave.setVisible(false);
                btnCancel.setVisible(false);
                btnDelete.setVisible(false);

                tfId.setEnabled(true);
                tfId.setEditable(true);
                tfId.requestFocus();
                clear();
                disabled();

                LivroControle.saveData(path);

            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                btnSearch.setVisible(false);
                btnCreate.setVisible(false);
                btnSave.setVisible(true);
                btnCancel.setVisible(true);
                btnList.setVisible(false);
                tfNome.requestFocus();
                tfId.setEditable(false);
                enabled();

                action = "update";
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                int response = JOptionPane.showConfirmDialog(
                        cp,
                        "Tem certeza que deseja excluir?",
                        "Confirmar",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );
                tfId.setEnabled(true);
                tfId.setEditable(true);
                tfId.requestFocus();
                tfId.setText("");
                clear();
                disabled();
                btnDelete.setVisible(false);
                btnUpdate.setVisible(false);
                btnCancel.setVisible(false);

                if (response == JOptionPane.YES_OPTION) {
                    LivroControle.delete(livro);
                    LivroControle.saveData(path);
                }

            }
        });

        btnList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                List<Livro> livroList = LivroControle.list();
                String[] col = {"Id", "Nome", "AnoDeLancamento", "Autor", "Preco"};
                Object[][] data = new Object[livroList.size()][col.length];
                String aux[];

                for (int i = 0; i < livroList.size(); i++) {
                    aux = livroList.get(i).toString().split(";");
                    for (int j = 0; j < col.length; j++) {
                        data[i][j] = aux[j];
                    }
                }

                cardLayout.show(pnSouth, "list");

                scrollTable.setPreferredSize(table.getPreferredSize());
                pnList.add(table);
                pnList.add(scrollTable);
                scrollTable.setViewportView(table);
                model.setDataVector(data, col);

                btnCreate.setVisible(false);
                btnUpdate.setVisible(false);
                btnDelete.setVisible(false);
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tfId.setText("");
                tfId.requestFocus();
                tfId.setEnabled(true);
                tfId.setEditable(true);

                disabled();

                btnCreate.setVisible(false);
                btnUpdate.setVisible(false);
                btnDelete.setVisible(false);
                btnCancel.setVisible(false);
                btnSave.setVisible(false);
                btnSearch.setVisible(true);
                btnList.setVisible(true);
            }
        });

        setModal(true);
        setSize(600, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
