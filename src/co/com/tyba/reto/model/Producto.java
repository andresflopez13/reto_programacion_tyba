package co.com.tyba.reto.model;

public class Producto {

    private String nombre;
    private double minimo;
    private double maximo;
    private float ganancia;

    private String imagen;

    public Producto(String nombre, double minimo, double maximo, float ganancia, String imagen) {
        this.nombre = nombre;
        this.minimo = minimo;
        this.maximo = maximo;
        this.ganancia = ganancia;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMinimo() {
        return minimo;
    }

    public void setMinimo(double minimo) {
        this.minimo = minimo;
    }

    public double getMaximo() {
        return maximo;
    }

    public void setMaximo(double maximo) {
        this.maximo = maximo;
    }

    public float getGanancia() {
        return ganancia;
    }

    public void setGanancia(float ganancia) {
        this.ganancia = ganancia;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", minimo=" + minimo +
                ", maximo=" + maximo +
                ", ganancia=" + ganancia +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
