package Domain;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Nave implements Legible {

    int posnave = 0;
    int posactual = 700;
    private Image icono;

    


    public Nave() {
        try {
            icono = leerImagen("C:/Users/nacho/OneDrive - Universidad Pontificia Comillas/2ºGITT/POO/Starships_Juego/starships/src/Domain/nave_buena.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Image leerImagen(String path) throws IOException {
        return ImageIO.read(new File(path)).getScaledInstance(100, 130, Image.SCALE_SMOOTH);
    }



    public void movex( int x){

        if(posactual + x > -50 && posactual + x < 1425){
            posactual = (posactual + x);
            posnave = posactual;
        }
    }


    public void paint(Graphics g) {
        g.drawImage(icono, posactual,600, null);
    }

    public int getPosnave() {
        return posnave;
    }

    public int getPosactual() {
        return posactual;
    }

    

    

}
