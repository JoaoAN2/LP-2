package Main;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author JoaoAN2
 */
class GUI extends JFrame {

    JLabel lbIdade = new JLabel("Insira a idade: ");
    JTextField tfIdade = new JTextField(2);
    JLabel lbRes = new JLabel("Categoria: ");
    JTextField tfRes = new JTextField(30);
    JLabel lbEmpty = new JLabel("");
    JButton buttonVerifier = new JButton("Verificar categoria: ");

    public GUI() {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(4, 2));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        cp.add(lbIdade);
        cp.add(tfIdade);
        cp.add(lbEmpty);
        cp.add(buttonVerifier);
        cp.add(lbRes);
        cp.add(tfRes);

        buttonVerifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num = Double.valueOf(tfIdade.getText());
                if (num >= 5 & num <= 7) {
                    tfRes.setText("Infantil A");
                } else if (num >= 8 & num <= 10) {
                    tfRes.setText("Infantil B");
                } else if (num >= 11 & num <= 13) {
                    tfRes.setText("Juvenil A");
                } else if (num >= 14 & num <= 17) {
                    tfRes.setText("Juvenil B");
                } else {
                    tfRes.setText("Adulto");
                }
            }
        });

        setTitle("Categoria idade");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
