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
class GUI extends JFrame{
    
    Container cp;
    JLabel lbA = new JLabel("Valor A");
    JLabel lbB = new JLabel("Valor B");
    JLabel lbC = new JLabel("Valor C");
    JLabel lbX1 = new JLabel("X1");
    JLabel lbX2 = new JLabel("X2");
    
    JTextField tfA = new JTextField(10);
    JTextField tfB = new JTextField(10);
    JTextField tfC = new JTextField(10);
    JTextField tfX1 = new JTextField(10);
    JTextField tfX2 = new JTextField(10);
    
    JLabel lbEmpty = new JLabel();
    
    JButton btnCalculate = new JButton("Calcular");
    
    public GUI(){
        cp = getContentPane();
        cp.setLayout(new GridLayout(6,2));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        cp.add(lbA);
        cp.add(tfA);
        cp.add(lbB);
        cp.add(tfB);
        cp.add(lbC);
        cp.add(tfC);
        cp.add(lbEmpty);
        cp.add(btnCalculate);
        cp.add(lbX1);
        cp.add(tfX1);
        cp.add(lbX2);
        cp.add(tfX2);
        
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                double a = Double.valueOf(tfA.getText());
                double b = Double.valueOf(tfB.getText());
                double c = Double.valueOf(tfC.getText());
                Processamento processamento = new Processamento(a, b, c);
                
                tfX1.setText(processamento.getX1());
                tfX2.setText((processamento.getX2()!=null) ? processamento.getX2() : "");
            }
        });
        
        setTitle("Bhaskara");
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
}
