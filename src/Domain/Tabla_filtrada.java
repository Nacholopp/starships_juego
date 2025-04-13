package Domain;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Tabla_filtrada extends JPanel {
    public Tabla_filtrada(String gradoFiltrar) {
        DefaultTableModel tabla_entera = new DefaultTableModel();
        tabla_entera.addColumn("Nombre");
        tabla_entera.addColumn("Grado");
        tabla_entera.addColumn("Número de Meteoritos");

        JTable table = new JTable(tabla_entera);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(580, 380)); // Tamaño ajustado a la tabla
        add(scrollPane);

        String ruta = "C:/Users/nacho/OneDrive - Universidad Pontificia Comillas/2ºGITT/POO/Starships_Juego/starshipsjugadores.txt";
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                if (gradoFiltrar == null) {
                    tabla_entera.addRow(data);
                } else {
                    if (data.length >= 2) {
                        String gradoArchivo = data[1];
                        String gradoFiltro = gradoFiltrar;
                        if (gradoArchivo.equalsIgnoreCase(gradoFiltro)) {
                            tabla_entera.addRow(data);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Crear el JFrame
        JFrame frame = new JFrame("Tabla de Datos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
