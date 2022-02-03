package GUI;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author JoaoAN2
 */
public class GUIMenu extends JFrame {
    
    private Container cp;
    
    JButton btnPlayer = new JButton("Jogadores");
    JButton btnFederation = new JButton("Federações");
    
    public GUIMenu() {
        cp = getContentPane();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Menu - Chess");
        
        cp.setLayout(new GridLayout(1,2));
        cp.add(btnPlayer);
        cp.add(btnFederation);
        
        btnFederation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUIFederation guiFederation = new GUIFederation();
            }
        });
        
        btnPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUIPlayers guiPlayers = new GUIPlayers();
            }
        });
        
        setLocationRelativeTo(null);
        setSize(400,100);
        setVisible(true);
    }
    
}
