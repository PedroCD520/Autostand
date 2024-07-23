package isisur.cl.autostand30.modelo;

public class Producto {
    private String nombre;
    private String descripcion;
    private String tipo;
    private int anio;

    public Producto(String nombre) {
        // Constructor vacío requerido para Firestore
    }

    public Producto(String nombre, String descripcion, String tipo, int anio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.anio = anio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
}
