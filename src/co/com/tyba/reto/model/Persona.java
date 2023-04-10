package co.com.tyba.reto.model;

public class Persona {
    private String nombre;
    private String tipoDocumento;
    private String numeroDocumento;
    private String contrasenia;
    private double inversion;

    public Persona(String nombre, String tipoDocumento, String numeroDocumento, String contrasenia, double inversion) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.contrasenia = contrasenia;
        this.inversion = inversion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public double getInversion() {
        return inversion;
    }

    public void setInversion(double inversion) {
        this.inversion = inversion;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String toCSV(){
        return this.nombre + ";" + this.tipoDocumento + ";" + this.numeroDocumento + ";" + this.contrasenia + ";" +
                this.inversion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", numeroDocumento='" + numeroDocumento + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", inversion=" + inversion +
                '}';
    }
}
