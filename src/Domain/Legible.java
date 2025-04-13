package Domain;

import java.awt.Image;
import java.io.IOException;

interface Legible {
    Image leerImagen(String path) throws IOException;
}