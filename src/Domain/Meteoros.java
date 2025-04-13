package Domain;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.awt.Rectangle;


import javax.imageio.ImageIO;

public class Meteoros implements Legible {

    private Image meteorito;
    int y = 0;
    int x ;
    int dy = 1;
    

    public Meteoros(int x){
        try{
            this.x = x;
            meteorito = leerImagen("C:/Users/nacho/OneDrive - Universidad Pontificia Comillas/2ºGITT/POO/Starships_Juego/starships/src/Domain/meteorito.png");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public Image leerImagen(String path) throws IOException {
        return ImageIO.read(new File(path)).getScaledInstance(80, 110, Image.SCALE_SMOOTH);
    }

    public void Caer_meteorito(Meteoros meteorito){
        y = meteorito.getY() + dy; // Voy haciendo que caigan los meteoritos
    }

    public int getY() {
        return y;
    }
    public int getX(){
        return x;
    }

    public void paint(Graphics g) {
        g.drawImage(meteorito, x ,y, null); // Lo va a pintar en x aleatorio pero desde y=0 siempre
    }

    public Rectangle getRectangulo() {
    
        return new Rectangle(x, y, meteorito.getWidth(null), meteorito.getHeight(null));
    }
   

    

    
    





}
