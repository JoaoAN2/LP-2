package GUI;

import Entities.Federation;
import Controlls.ControllFederation;
import Tools.DateTools;
import Tools.ManipulaArquivo;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * sigla_federation; name_federation;
 *
 * @author JoaoAN2
 */
public class GUIFederation extends JDialog {

    String path = "federations.csv";

    Federation federation = new Federation();
    String action;

    ControllFederation controll = new ControllFederation();
    ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
    DateTools dateTools = new DateTools();

    Container cp;
    JPanel pnNorth = new JPanel();
    JPanel pnSouth = new JPanel();
    JPanel pnCenter = new JPanel();

    JPanel pnList = new JPanel(new GridLayout(1, 1));
    CardLayout cardLayout = new CardLayout();

    JLabel lbSiglaPK = new JLabel("Sigla");
    JLabel lbName_federation = new JLabel("Nome");

    JTextField tfSiglaPK = new JTextField(3);
    JTextField tfName_federation = new JTextField(50);

    JButton btnSearch = new JButton("Buscar");
    JButton btnCreate = new JButton("Adicionar");
    JButton btnSave = new JButton("Salvar");
    JButton btnUpdate = new JButton("Alterar");
    JButton btnDelete = new JButton("Excluir");
    JButton btnList = new JButton("Listar");
    JButton btnCancel = new JButton("Cancelar");

    String[] col = new String[]{"Sigla", "Nome"};
    String[][] data = new String[0][2];
    DefaultTableModel model = new DefaultTableModel(data, col);
    JTable table = new JTable(model);
    JScrollPane scrollTable = new JScrollPane();
    JPanel pnEmpty = new JPanel(new GridLayout(6, 1));

    public void printList(List<Federation> federationsList) {
        for (int i = 0; i < federationsList.size(); i++) {
            System.out.println(
                    federationsList.get(i).getSigla_federation() + " - "
                    + federationsList.get(i).getName_federation()
            );
        }
    }

    public void clear() {
        tfName_federation.setText("");
    }

    public void enabled() {
        tfName_federation.setEditable(true);
    }

    public void disabled() {
        tfName_federation.setEditable(false);
    }

    public GUIFederation() {

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        setTitle("CRUD - Chess");

        pnCenter.setLayout(new GridLayout(1, 2));
        pnNorth.setLayout(new FlowLayout(FlowLayout.LEFT));

        cp.add(pnNorth, BorderLayout.NORTH);
        cp.add(pnSouth, BorderLayout.SOUTH);
        cp.add(pnCenter, BorderLayout.CENTER);

        pnNorth.setBackground(Color.cyan);
        pnCenter.setBorder(BorderFactory.createLineBorder(Color.black));

        pnNorth.add(lbSiglaPK);
        pnNorth.add(tfSiglaPK);
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

        pnCenter.add(lbName_federation);
        pnCenter.add(tfName_federation);

        for (int i = 0; i < 5; i++) {
            pnEmpty.add(new JLabel(" "));
        }

        pnSouth.setLayout(cardLayout);
        pnSouth.add(pnEmpty, "empty");
        pnSouth.add(pnList, "list");

        controll.loadData(path);

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cardLayout.show(pnSouth, "warning");
                if (tfSiglaPK.getText().length() == 3) {
                    federation = controll.read(tfSiglaPK.getText().toUpperCase());
                    if (federation != null) {
                        btnCreate.setVisible(false);
                        btnUpdate.setVisible(true);
                        btnDelete.setVisible(true);

                        tfName_federation.setText(federation.getName_federation());
                    } else {
                        clear();
                        btnCreate.setVisible(true);
                        btnUpdate.setVisible(false);
                    }
                } else {
                    JOptionPane.showMessageDialog(cp, "Insira um valor válido!", "Deu ruim patrão...", JOptionPane.PLAIN_MESSAGE);
                    tfSiglaPK.selectAll();
                    tfSiglaPK.requestFocus();
                }
            }
        });

        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tfName_federation.requestFocus();

                tfSiglaPK.setEnabled(false);
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
                if (tfName_federation.getText().equals("")) {
                    JOptionPane.showMessageDialog(cp, "Dados inseridos de maneira inválida!", "Deu ruim patrão...", JOptionPane.PLAIN_MESSAGE);
                } else {
                    Federation oldFederation = federation;

                    if ("create".equals(action)) {
                        federation = new Federation();
                    }

                    federation.setSigla_federation(tfSiglaPK.getText());
                    federation.setName_federation(tfName_federation.getText());
                    System.out.println(federation.getName_federation());

                    if ("create".equals(action)) {
                        controll.create(federation);
                    }

                    if ("update".equals(action)) {
                        controll.update(federation, oldFederation);
                    }

                    btnSearch.setVisible(true);
                    btnList.setVisible(true);
                    btnSave.setVisible(false);
                    btnCancel.setVisible(false);
                    btnDelete.setVisible(false);

                    tfSiglaPK.setEnabled(true);
                    tfSiglaPK.setEditable(true);
                    tfSiglaPK.requestFocus();
                    clear();
                    disabled();

                    controll.saveData(path);
                }
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btnSearch.setVisible(false);
                btnUpdate.setVisible(false);
                btnSave.setVisible(true);
                btnCancel.setVisible(true);

                tfName_federation.requestFocus();

                tfSiglaPK.setEditable(false);
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

                tfSiglaPK.setEnabled(true);
                tfSiglaPK.setEditable(true);
                tfSiglaPK.requestFocus();
                tfSiglaPK.setText("");
                clear();
                disabled();
                btnDelete.setVisible(false);
                btnUpdate.setVisible(false);
                btnCancel.setVisible(false);

                if (response == JOptionPane.YES_OPTION) {
                    controll.delete(federation);
                    controll.saveData(path);
                }

            }
        });

        btnList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                List<Federation> federationsList = controll.list();
                String[] col = {"Sigla", "Nome"};
                Object[][] data = new Object[federationsList.size()][col.length];
                String aux[];

                for (int i = 0; i < federationsList.size(); i++) {
                    aux = federationsList.get(i).toString().split(";");
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
                tfSiglaPK.setText("");
                tfSiglaPK.requestFocus();
                tfSiglaPK.setEnabled(true);
                tfSiglaPK.setEditable(true);

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
