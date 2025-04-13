package Domain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ui.Game_Hilo;

public class Menu extends JFrame {
    final boolean[] comienzo = {false};
    public  Menu() {
        int ancho = 1500;
        int largo = 800;
        final boolean[] comienzo = {false};

        // Titulo del menu
        JPanel titulo = new JPanel();
        titulo.setBackground(Color.BLACK);
        JLabel etiqueta = new JLabel("STARSHIPS");
        etiqueta.setFont(new Font("Agency FB", Font.BOLD, 180));
        etiqueta.setForeground(new Color(20, 85, 109));
        titulo.add(etiqueta);
        this.add(titulo, BorderLayout.NORTH);

        JPanel restomenu = new JPanel();
        restomenu.setBackground(Color.black);
        restomenu.setLayout(null);

        JButton jugar = new JButton("Empieza nueva partida");
        jugar.setFont(new Font("Agency FB", Font.BOLD, 30));
        jugar.setLayout(null);
        jugar.setForeground(Color.WHITE);
        jugar.setBackground(new Color(20, 85, 109));
        jugar.setBounds(200, 120, 300, 120);

        JButton estadisticas = new JButton("Estadísticas");
        estadisticas.setFont(new Font("Agency FB", Font.BOLD, 30));
        estadisticas.setLayout(null);
        estadisticas.setForeground(Color.WHITE);
        estadisticas.setBackground(new Color(20, 85, 109));
        estadisticas.setBounds(600, 120, 300, 120);

        JButton salir = new JButton("Salir");
        salir.setFont(new Font("Agency FB", Font.BOLD, 30));
        salir.setLayout(null);
        salir.setForeground(Color.WHITE);
        salir.setBackground(new Color(20, 85, 109));
        salir.setBounds(1000, 120, 300, 120);

        restomenu.add(salir);
        restomenu.add(estadisticas);
        restomenu.add(jugar);

        JPanel creditos = new JPanel();
        creditos.setBackground(Color.BLACK);
        JLabel etiqueta2 = new JLabel("BY IGNACIO LOPEZ 2ºA GITT");
        etiqueta2.setFont(new Font("Agency FB", Font.BOLD, 80));
        etiqueta2.setForeground(new Color(20, 85, 109));
        creditos.add(etiqueta2);
        this.add(creditos, BorderLayout.SOUTH);

        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cierra la ventana actual
                dispose();
            }
        });

        estadisticas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcion = JOptionPane.showConfirmDialog(null, "¿Desea filtrar por grado?", "Filtrar por Grado", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    String grado = JOptionPane.showInputDialog(null, "Ingrese el grado:");
                    Tabla_filtrada tabla = new Tabla_filtrada(grado);
                } else {
                    Tabla_filtrada tabla = new Tabla_filtrada(null);
                }
            }
        });


        jugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // NUEVO COMPONENTE GRÁFICO

                        comienzo[0] = true;
                        // Mostrar el juego después de ingresar el grado
                        Game_Hilo game_hilo = new Game_Hilo();
                        
                            getContentPane().removeAll();
                            add(game_hilo);
                            pack();
                            setSize(1500, 800);
                            setResizable(true);
                            setLocationRelativeTo(null);
                            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            setVisible(true);
                            game_hilo.requestFocus();
                            game_hilo.start();
                        
                        
                        
            }          
    });

    if (comienzo[0] == false) {
        this.add(restomenu, BorderLayout.CENTER);
        this.pack();
        this.setSize(ancho, largo);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
}