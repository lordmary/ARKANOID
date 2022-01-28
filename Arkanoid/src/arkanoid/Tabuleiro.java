package arkanoid;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Tabuleiro extends JPanel{
    private Timer tempo;
    private String message = "Game Over";
    private Bola bola;
    private Raquete raquete;
    private Tijolo[] tijolo;
    private boolean inGame = true;
    
    public Tabuleiro(){
        iniciaTabuleiro();
    }
    
    private void iniciaTabuleiro(){
        addKeyListener(new TAdapter());
        setFocusable(true);
        setPreferredSize(new Dimension(Comuns.largura, Comuns.altura));        
        gameInit(); 
    }
    private void gameInit(){
        tijolo = new Tijolo[Comuns.numeroTijolos];
        bola = new Bola();
        raquete = new Raquete();
        
        int k = 0;
        for (int i=0; i<5; i++){
            for (int j=0; j<6; j++){
                tijolo[k] = new Tijolo(j*40+30, i*10+50);
                k++;
            }
        }
        tempo = new Timer(Comuns.periodos, new GameCycle());
        tempo.start();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        var g2d = (Graphics2D) g;
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        
        if(inGame){
            drawObjects(g2d);
        }else{
            gameFinished(g2d);
        }
        
        Toolkit.getDefaultToolkit().sync();
    }
    
    private void drawObjects(Graphics2D g2d){
        g2d.drawImage(bola.getImagem(), bola.getX(), bola.getY(), bola.getLarguraImagem(),
                bola.getAlturaImagem(), this);
        g2d.drawImage(raquete.getImagem(), raquete.getX(), raquete.getY(), 
                raquete.getLarguraImagem(), raquete.getAlturaImagem(), this);
        for (int i=0; i<Comuns.numeroTijolos; i++){
            if (tijolo[i].isVivo()){
                g2d.drawImage(tijolo[i].getImagem(), tijolo[i].getX(), tijolo[i].getY(),
                        tijolo[i].getLarguraImagem(), tijolo[i].getAlturaImagem(), this);
            }
        }
            
    }
    
    private void gameFinished(Graphics2D g2d){
        var font = new Font("Verdana", Font.BOLD, 18);
        FontMetrics fontMetrics = this.getFontMetrics(font);
        
        g2d.setColor(Color.black);
        g2d.setFont(font);
        g2d.drawString(message, Comuns.largura - fontMetrics.stringWidth(message)/2, Comuns.largura/2 ) ;
    }
    private class TAdapter extends KeyAdapter{
        public void keyReleased(KeyEvent e){
            raquete.keyReleased(e);
        }
        
        public void keyPressed(KeyEvent e){
            raquete.keyPressed(e);
        }
        
    }
    
    private class GameCycle implements ActionListener{
        public void actionPerformed(ActionEvent e){
            doGameCycle();
        } 
    }
    private void doGameCycle(){
        bola.movimento();
        raquete.movimento();
        checkCollision();
        repaint();
    }
    
    public void stopGame(){
         inGame = false;
         tempo.stop();
    }
    private void checkCollision(){
        if (bola.getRect().getMaxY() > Comuns.limiteBaixo){
            stopGame();
        }
        for (int i=0, j=0; i<Comuns.numeroTijolos;i++){
            if (!tijolo[i].isVivo()){
                j++;
            }
            if (j == Comuns.numeroTijolos){
                message = "Parabens, voce ganhou";
                stopGame();
            }
        }
        if (bola.getRect().intersects(raquete.getRect())){
            int raquetePosEsq = (int) raquete.getRect().getMinX();
            int bolaPosEsq = (int) bola.getRect().getMinX();
            
            int primeiro = raquetePosEsq + 8;
            int segundo = raquetePosEsq + 16;
            int terceiro = raquetePosEsq + 24;
            int quarto = raquetePosEsq + 32;
            
            if (bolaPosEsq < primeiro){
                bola.setDirX(-1);
                bola.setDirY(-1);
            }
            
            if (bolaPosEsq >= primeiro && bolaPosEsq <segundo ){
                bola.setDirX(-1);
                bola.setDirY(-1*bola.getDirY());
            }
            if (bolaPosEsq >= segundo && bolaPosEsq < terceiro ){
                bola.setDirX(0);
                bola.setDirY(-1);
            }
            if (bolaPosEsq >= terceiro && bolaPosEsq < quarto ){
                bola.setDirX(-1);
                bola.setDirY(-1*bola.getDirY());
            }
            if (bolaPosEsq >= quarto){
                bola.setDirX(1);
                bola.setDirY(-1);
            }
        }
        for (int i = 0; i<Comuns.numeroTijolos; i++){
            if ((bola.getRect().intersects(tijolo[i].getRect()))){
                int bolaEsq = (int) bola.getRect().getMinX();
                int bolaAltura = (int) bola.getRect().getHeight();
                int bolaLargura = (int) bola.getRect().getWidth();
                int bolaTopo = (int) bola.getRect().getMinY();
                
                var pointRight = new Point(bolaEsq + bolaLargura + 1, bolaTopo);
                var pointLeft = new Point(bolaEsq - 1, bolaTopo);
                var pointTopo = new Point(bolaEsq, bolaTopo-1);
                var pointBaixo = new Point(bolaEsq, bolaTopo + bolaAltura + 1);
                
                if (tijolo[i].isVivo()){
                    if (tijolo[i].getRect().contains(pointRight)){
                        bola.setDirX(-1);
                    }else if (tijolo[i].getRect().contains(pointLeft)){
                        bola.setDirX(1);
                    }
                    
                    if (tijolo[i].getRect().contains(pointTopo)){
                        bola.setDirY(1);
                    }else if (tijolo[i].getRect().contains(pointBaixo)){
                        bola.setDirY(-1);
                    }
                    tijolo[i].setVivo(false);
                }
                
            }
        }
    }
    
}