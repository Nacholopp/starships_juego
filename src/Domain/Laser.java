package Domain;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.awt.Rectangle;
import javax.imageio.ImageIO;


public class Laser implements Legible{
    int y = 580;
    int x = 700;
    private Image bala;
    int dy = 10;
    Nave nave;
    
    public Laser(int x) {
        try {
            this.x = x;
            nave = new Nave();
            bala = leerImagen("C:/Users/nacho/OneDrive - Universidad Pontificia Comillas/2ºGITT/POO/Starships_Juego/starships/src/Domain/laser.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Image leerImagen(String path) throws IOException {
        return ImageIO.read(new File(path)).getScaledInstance(30, 60, Image.SCALE_SMOOTH);
    }

    public void paint(Graphics g) {
        g.drawImage(bala, x ,y, null);
    }

    public void mueve_laser(Laser laser){
        y  = (laser.getY() - dy);
    
    }
    public int getY() {
        return y;
    }
    public int getX(){
        return x;
    }

    public Rectangle getRectangulo() {
        return new Rectangle(x, y, bala.getWidth(null), bala.getHeight(null));
    }

    

    
}
