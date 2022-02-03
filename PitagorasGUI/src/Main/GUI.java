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
 * @author JoaoAN
 */
class GUI extends JFrame{
    
    Container cp;
    JLabel lbValueB = new JLabel("Valor B");
    JLabel lbValueC = new JLabel("Valor C");
    JTextField tfValueB = new JTextField(10);
    JTextField tfValueC = new JTextField(10);
    JLabel lbHipotenusa = new JLabel("Hipotenusa");
    JButton btnCalcular = new JButton("Calcular");
    JTextField tfHipotenusa = new JTextField();
    JLabel lbVazio = new JLabel("");
    
    
    public GUI() {
        cp = getContentPane();
        cp.setLayout(new GridLayout(4,2));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        cp.add(lbValueB);
        cp.add(tfValueB);
        cp.add(lbValueC);
        cp.add(tfValueC);
        cp.add(lbVazio);
        cp.add(btnCalcular);
        cp.add(lbHipotenusa);
        cp.add(tfHipotenusa);
        
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double b = Double.valueOf(tfValueB.getText());
                double c = Double.valueOf(tfValueC.getText());
                tfHipotenusa.setText(String.valueOf(Math.sqrt(b*b+c*c)));
            }
        });
        
        setTitle("Pitágoras");
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
    
}
