package Main;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author JoaoAN
 */
class GUI extends JFrame {
    DecimalFormat decimalFormat = new DecimalFormat("#0.00");
    
    Container cp;
    JPanel panelTitle = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();

    JLabel lbTitle = new JLabel("João's Investimento");
    JLabel lbInvestment = new JLabel("Valor investido: R$");
    JLabel lbTime = new JLabel("Tempo em que o dinheiro ficará investido (anos)");
    JLabel lbProfitability = new JLabel("Rentabilidade (%)");
    JLabel lbRes = new JLabel("TOTAL: R$");

    JTextField tfInvestment = new JTextField(10);
    JTextField tfTime = new JTextField(1);
    JTextField tfProfitability = new JTextField(4);
    JTextField tfRes = new JTextField(20);

    JButton btnStopStart = new JButton("Calcular");

    public GUI() {
        cp = getContentPane();
        cp.setLayout(new GridLayout(6, 1));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        cp.add(panelTitle);
        cp.add(panel1);
        cp.add(panel2);
        cp.add(panel3);
        cp.add(panel4);
        cp.add(panel5);

        lbTitle.setFont(new Font("Verdana", Font.BOLD, 55));
        lbInvestment.setFont(new Font("Verdana", Font.PLAIN, 15));
        tfInvestment.setFont(new Font("Verdana", Font.PLAIN, 15));
        lbTime.setFont(new Font("Verdana", Font.PLAIN, 15));
        tfTime.setFont(new Font("Verdana", Font.PLAIN, 15));
        lbProfitability.setFont(new Font("Verdana", Font.PLAIN, 15));
        tfProfitability.setFont(new Font("Verdana", Font.PLAIN, 15));
        lbRes.setFont(new Font("Verdana", Font.PLAIN, 15));
        panelTitle.add(lbTitle);
        panel1.add(lbInvestment);
        panel1.add(tfInvestment);
        panel2.add(lbTime);
        panel2.add(tfTime);
        panel3.add(lbProfitability);
        panel3.add(tfProfitability);
        panel4.add(btnStopStart);
        panel5.add(lbRes);
        panel5.add(tfRes);
        btnStopStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    tfRes.setText("");
                    double investment = Double.valueOf(tfInvestment.getText());
                    int time = Integer.valueOf(tfTime.getText());
                    double profitability = Double.valueOf(tfProfitability.getText());
                    Processamento processamento = new Processamento();
                    double total = processamento.calculate(investment, time, profitability);
                    tfRes.setText(String.valueOf(decimalFormat.format(total)));
                } catch (Exception e) {
                    System.out.println(e);
                    tfRes.setText("Erro nos dados inseridos!");
                }
            }
        });

        setTitle("Investimentos");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
