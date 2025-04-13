package Domain;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Escribir_Fichero {

    public Escribir_Fichero(){

    }

    

    public void escribe(Jugador jugador){
        try (FileWriter f = new FileWriter("C:/Users/nacho/OneDrive - Universidad Pontificia Comillas/POO/Starships_Juego/starships/jugadores.txt",true)) {
            PrintWriter p = new PrintWriter(f);
            p.println(jugador.toString());
            p.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
