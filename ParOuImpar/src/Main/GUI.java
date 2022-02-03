package Main;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author JoaoAN2
 */
class GUI extends JFrame {

    JLabel lValue = new JLabel("Insira o valor");
    JTextField tfValue = new JTextField(10);
    JButton verifier = new JButton("Verificar");
    JLabel res = new JLabel("Resultado: ");
    JTextField tfRes = new JTextField(5);
    JLabel lbVazio = new JLabel("");

    public GUI() {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(4, 2));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        cp.add(lValue);
        cp.add(tfValue);
        cp.add(lbVazio);
        cp.add(verifier);
        cp.add(res);
        cp.add(tfRes);
        verifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num = Double.valueOf(tfValue.getText());
                if (num % 2 == 0) {
                    tfRes.setText("Par");
                } else {
                    tfRes.setText("Impar");
                }
            }
        });
        setTitle("Par ou Impar");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
