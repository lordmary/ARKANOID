package arkanoid;

import javax.swing.ImageIcon;

public class Tijolo extends Alma
{
    private boolean vivo;
    private int vida, cor, pontos;
    
    public Tijolo(int x,int y)
    {
        iniciaTijolo(x,y,vida,pontos);
    }
    
    // 1- branco 50 / 2- laranja 60 / 3- ciano 70 / 4- verde 80 / 5- vermelho 90 / 6- azul 100 / 7- roxo 110 / 8- amarelo 120 / 9- prata 50*n da fase / 10- ouro 
    private void iniciaTijolo(int x, int y, int vida, int pontos)
    {
        this.setX(x);
        this.setY(y);
        vivo = true;

        switch(cor)
        {
            case 1:
                loadImagemBranco();
                getImagemDimensions();
                this.setVida(1);
                this.setPonto(50);
                break;

            case 2:
                loadImagemLaranja();
                getImagemDimensions();
                this.setVida(1);
                this.setPonto(60);
                break;

            case 3:
                loadImagemCiano();
                getImagemDimensions();
                this.setVida(1);
                this.setPonto(70);
                break;

            case 4:
                loadImagemVerde();
                getImagemDimensions();
                this.setVida(1);
                this.setPonto(80);
                break;

            case 5:
                loadImagemVermelho();
                getImagemDimensions();
                this.setVida(1);
                this.setPonto(90);
                break;

            case 6:
                loadImagemAzul();
                getImagemDimensions();
                this.setVida(1);
                this.setPonto(100);
                break;

            case 7:
                loadImagemRoxo();
                getImagemDimensions();
                this.setVida(1);
                this.setPonto(110);
                break;

            case 8:
                loadImagemAmarelo();
                getImagemDimensions();
                this.setVida(1);
                this.setPonto(120);
                break;

            case 9:
                loadImagemPrata();
                getImagemDimensions();
                this.setVida(5);
                this.setPonto(150);
                break;

            case 10:
                loadImagemOuro();
                getImagemDimensions();
                this.setVida(-1);
                this.setPonto(0);
                break;
        }
    }
    
    private void loadImagemBranco()
    {
        var ii = new ImageIcon("src/resources/Arkanoid_Brick_White.png");
        this.setImagem(ii.getImage());
    }

    private void loadImagemLaranja()
    {
        var ii = new ImageIcon("src/resources/Arkanoid_Brick_Orange.png");
        this.setImagem(ii.getImage());
    }

    private void loadImagemCiano()
    {
        var ii = new ImageIcon("src/resources/Arkanoid_Brick_Cyan.png");
        this.setImagem(ii.getImage());
    }

    private void loadImagemVerde()
    {
        var ii = new ImageIcon("src/resources/Arkanoid_Brick_Green.png");
        this.setImagem(ii.getImage());
    }

    private void loadImagemVermelho()
    {
        var ii = new ImageIcon("src/resources/Arkanoid_Brick_Red.png");
        this.setImagem(ii.getImage());
    }

    private void loadImagemAzul()
    {
        var ii = new ImageIcon("src/resources/Arkanoid_Brick_Blue.png");
        this.setImagem(ii.getImage());
    }

    private void loadImagemRoxo()
    {
        var ii = new ImageIcon("src/resources/Arkanoid_Brick_Violet.png");
        this.setImagem(ii.getImage());
    }

    private void loadImagemAmarelo()
    {
        var ii = new ImageIcon("src/resources/Arkanoid_Brick_Yellow.png");
        this.setImagem(ii.getImage());
    }

    private void loadImagemPrata()
    {
        var ii = new ImageIcon("src/resources/Arkanoid_Brick_Silver.png");
        this.setImagem(ii.getImage());
    }

    private void loadImagemOuro()
    {
        var ii = new ImageIcon("src/resources/Arkanoid_Brick_Gold.png");
        this.setImagem(ii.getImage());
    }
    
    public boolean isVivo()
    {
        return vivo;
    }

    public void setVida(int Vida)
    {
        this.vida = Vida;
    }

    public void setPonto(int Pontos)
    {
        this.pontos = Pontos;
    }
    
    public void setVivo(boolean Vivo)
    {
        this.vivo = Vivo; 
    }
}
