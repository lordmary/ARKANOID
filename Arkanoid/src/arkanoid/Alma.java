package arkanoid;

import java.awt.Image;
import java.awt.Rectangle;


public class Alma {
    private int x;
    private int y;
    private int larguraImagem;
    private int alturaImagem;
    private Image imagem;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLarguraImagem() {
        return larguraImagem;
    }

    public void setLarguraImagem(int larguraImagem) {
        this.larguraImagem = larguraImagem;
    }

    public int getAlturaImagem() {
        return alturaImagem;
    }

    public void setAlturaImagem(int alturaImagem) {
        this.alturaImagem = alturaImagem;
    }
    
    public void setImagem(Image I){
        imagem = I;
    }
    
    public Image getImagem(){
        return imagem;
    }
    
    public Rectangle getRect(){
        return new Rectangle(x, y, imagem.getWidth(null), imagem.getHeight(null));
    }
    
    public void getImagemDimensions(){
        larguraImagem = imagem.getWidth(null);
        alturaImagem = imagem.getHeight(null);
    }
}
