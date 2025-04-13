package Domain;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Game extends JPanel {

    // Aquí hago todos los métodos del juego, para después implementarlos en el hilo del juego

    public static final int FPS = 0;
    Nave nave;
    Collection<Laser> balas;
    Image fondo;
    private HashSet<Meteoros> meteoritos;
    private Timer meteoritoTimer;
    int meteoritosEliminados = 0;
    //private Timer timer; 

    public Game() {
        try {
            fondo = ImageIO.read(new File("C:/Users/nacho/OneDrive - Universidad Pontificia Comillas/2ºGITT/POO/Starships_Juego/starships/src/Domain/fondo_juego.png")).getScaledInstance(1500, 800, Image.SCALE_SMOOTH);
            nave = new Nave();
            balas = new HashSet<>();
            meteoritos = new HashSet<>(); //Pongo hashset en todos para acceder más rapido y que el juego vaya más rapido
            meteoritoTimer = new Timer();
            meteoritoTimer.scheduleAtFixedRate(new MeteoritoTask(), 0, 4000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        

    public void calcular_posicion_nave(Collection<Integer> keysPressed){
        if (keysPressed.contains( KeyEvent.VK_D))
            nave.movex(10);
        else if (keysPressed.contains( KeyEvent.VK_A))
            nave.movex(-10);
    }

    
    

    public void disparar(Collection<Integer> keysPressed){
        if (keysPressed.contains( KeyEvent.VK_W))
            balas.add(new Laser(nave.getPosactual()+33)); //Para que el laser se dispare desde la posición de la nave
    }

    public void actualizarbalas(){
        for (Laser laser : balas){
            if (laser != null)
                laser.mueve_laser(laser);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(fondo, 0, 0, this);
        nave.paint(g);
        for (Laser laser : balas){
             if (laser != null)
                 laser.paint(g);
         }
         for (Meteoros meteorito : meteoritos) {
            meteorito.paint(g); // Pintar el meteorito en la pantalla
        }
    }

    private class MeteoritoTask extends TimerTask {
        Random random = new Random();
        
        @Override
        public void run() {
            // Agregar un nuevo meteorito a la lista
            int x = random.nextInt(1400);
            meteoritos.add(new Meteoros(x)); //Creo el meteorito en una x random
        }
    }

    public void actualizarMeteoritos() {
        for (Meteoros meteorito : meteoritos) {
            meteorito.Caer_meteorito(meteorito); // Actualiza la posición del meteorito
        }
    }


    public boolean colision_final() {
        for (Meteoros meteorito : meteoritos) {
            if (meteorito.getY() == 600){
                return true;
            }
        }
        return false; // Agregamos este return en caso de que no se cumpla la condición del if
    }

    public void colision_meteorito_laser(){
        List<Meteoros> meteoritosAEliminar = new ArrayList<>();

        for (Meteoros meteorito : meteoritos) {
            for (Laser laser : balas) {
                if (meteorito.getRectangulo().intersects(laser.getRectangulo())) {
                    meteoritosAEliminar.add(meteorito);
                    meteoritosEliminados +=1;
                    break;
                }
            }
        }
        
        meteoritos.removeAll(meteoritosAEliminar);
        meteoritosAEliminar.clear();
    }


    public int getMeteoritosEliminados() {
        return meteoritosEliminados;
    }

    
    

    


}
