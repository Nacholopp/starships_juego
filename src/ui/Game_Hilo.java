package ui;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Collection;
import java.util.HashSet;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Domain.*;

public class Game_Hilo extends JPanel implements Runnable{

    Thread thread;
    Game game;
    Collection<Integer> teclaspulsadas;
    boolean running = false; 
    String Nombre;
    String Grado;
    Jugador jugador;
    Escribir_Fichero registro;

    
    
    public Game_Hilo(){

        
        game = new Game();
        //Nave nave = new Nave();
        teclaspulsadas = new HashSet<>();

        this.setFocusable(true); // Añadido para asegurarse de que el JPanel puede recibir eventos de teclado
        this.requestFocusInWindow(); // Añadido para asegurarse de que el JPanel está enfocado y puede recibir eventos de teclado

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                    teclaspulsadas.add(e.getKeyCode());

            }
            @Override
            public void keyReleased(KeyEvent e) {
                teclaspulsadas.remove(e.getKeyCode());
            }
        });
    }
        

    

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            game.paint(g);
        }

        @Override
        public void run() {
            while (running ) {
                this.repaint();
                
                game.calcular_posicion_nave(teclaspulsadas);
                game.disparar(teclaspulsadas);
                game.actualizarbalas();
                game.actualizarMeteoritos();
                game.colision_meteorito_laser();
                if (game.colision_final() == true){
                    try {
                        stop();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    
        }
    
        

        public void start(){
            thread = new Thread(this);
            thread.start();
            running = true;
        }

        public void stop() throws InterruptedException {
            Nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
            Grado = JOptionPane.showInputDialog("Ingrese su grado:");
            jugador = new Jugador(Nombre,Grado,game.getMeteoritosEliminados());
            registro = new Escribir_Fichero();
            registro.escribe(jugador);
            try {
                thread.join();
                running = false;            
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }

    }

    
        

