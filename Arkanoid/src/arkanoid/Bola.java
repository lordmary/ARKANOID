package arkanoid;

import javax.swing.ImageIcon;

public class Bola extends Alma{
    private int dirX;
    private int dirY;
    
    public Bola(){
        iniciaBola();
    }
    
    private void iniciaBola(){
        dirX = 1;
        dirY = -1;
        
        loadImagem();
        getImagemDimensions();
        resetaBola();
    }
    private void loadImagem(){
        var ii = new ImageIcon("src/resources/ball.png");
        this.setImagem(ii.getImage());
    }
    
    public void movimento(){
        this.setX(this.getX()+dirX);
        this.setY(this.getY()+dirY);
        
        if (this.getX() == 0)
            setDirX(1);
        
        if (this.getX() == Comuns.largura - (this.getLarguraImagem()))
            setDirX(-1);
    
        if (this.getY() == 0)
            setDirY(1);
    }
    
    private void resetaBola(){
        this.setX(Comuns.inicioBolaX);
        this.setY(Comuns.inicioBolaY);
    }
    
    public void setDirX(int direcaoX){
        dirX = direcaoX;
    }
    
    public void setDirY(int direcaoY){
        dirY = direcaoY;
    }
    
    public int getDirX(){
        return dirX;
    }
    
    public int getDirY(){
        return dirY;
    }
}
