package arkanoid;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Raquete extends Alma{
    private int dx;
    
    public Raquete(){
        iniciaRaquete();
    }
    private void iniciaRaquete(){
        loadImage();
        getImagemDimensions();
        resetaRaquete();
    }
    
    private void loadImage(){
        var ii = new ImageIcon("src/resources/raquete.png");
        this.setImagem(ii.getImage());
    }
    public void movimento(){
        this.setX(this.getX() + dx);
        
        if (this.getX()<=0)
            this.setX(0);
        
        if (this.getX()>=Comuns.largura - this.getLarguraImagem())
            this.setX(Comuns.largura - this.getLarguraImagem());
    }
    
    private void resetaRaquete(){
        this.setX(Comuns.inicioRaqueteX);
        this.setY(Comuns.inicioRaqueteY);
    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT)
            dx = -1;
        
        if (key == KeyEvent.VK_RIGHT)
            dx = 1;
    }
    
    public void keyReleased (KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT)
            dx = 0;
        
        if (key == KeyEvent.VK_RIGHT)
            dx = 0;
    }
}


