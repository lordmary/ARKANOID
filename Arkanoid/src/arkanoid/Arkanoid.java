package arkanoid;

import javax.swing.JFrame;
import java.awt.EventQueue;

public class Arkanoid extends JFrame{

    public Arkanoid(){
        initUI();
    }
    public void initUI(){
        add(new Tabuleiro());
        setTitle("Arkanoid");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
    }
    
    public static void main(String[] a){
        EventQueue.invokeLater(() ->{
            var game = new Arkanoid();
            game.setVisible(true);
            
        });
    }
    
}
