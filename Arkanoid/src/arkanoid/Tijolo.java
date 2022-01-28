package arkanoid;

import javax.swing.ImageIcon;

public class Tijolo extends Alma{
    private boolean vivo;
    
    public Tijolo(int x,int y){
        iniciaTijolo(x,y);
    }
    
    private void iniciaTijolo(int x, int y){
        this.setX(x);
        this.setY(y);
        vivo = true;
        loadImagem();
        getImagemDimensions();
    }
    
    private void loadImagem(){
        var ii = new ImageIcon("src/resources/tijoloAzul.png");
        this.setImagem(ii.getImage());
    }
    
    public boolean isVivo(){
        return vivo;
    }
    
    public void setVivo(boolean Vivo){
        this.vivo = Vivo; 
    }
}
