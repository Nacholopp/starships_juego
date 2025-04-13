package Domain;

public class Jugador {
    
    String nombre;
    String grado;
    int meteoritos_eliminados;

    public Jugador(String nombre, String grado, int meteoritos_eliminados){

        this.nombre = nombre;
        this.grado = grado;
        this.meteoritos_eliminados = meteoritos_eliminados;

    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getGrado() {
        return grado;
    }
    public void setGrado(String grado) {
        this.grado = grado;
    }
    public int getMeteoritos_eliminados() {
        return meteoritos_eliminados;
    }
    public void setMeteoritos_eliminados(int meteoritos_eliminados) {
        this.meteoritos_eliminados = meteoritos_eliminados;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.nombre + ";").append(this.grado + ";").append(this.meteoritos_eliminados);
        return sb.toString();
    }
}
