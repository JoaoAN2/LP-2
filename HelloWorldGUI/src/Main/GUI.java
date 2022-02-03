package Main;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author JoaoAN
 */
class GUI extends JFrame{
    
    Container cp;
    
    public GUI() {
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        setTitle("Hello World GUI");
        setSize(400,300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
    
}
