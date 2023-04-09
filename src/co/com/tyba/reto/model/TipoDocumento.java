package co.com.tyba.reto.model;

public class TipoDocumento {
    private String nombre;
    private boolean invertir;

    public TipoDocumento(String nombre, boolean invertir) {
        this.nombre = nombre;
        this.invertir = invertir;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isInvertir() {
        return invertir;
    }

    public void setInvertir(boolean invertir) {
        this.invertir = invertir;
    }

    @Override
    public String toString() {
        return "TipoDocumento{" +
                "nombre='" + nombre + '\'' +
                ", invertir=" + invertir +
                '}';
    }
}
