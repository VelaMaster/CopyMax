package Modelo;

public class Productosprecios {
    
    private String nombre,direccionicon;
    private double precio;

    public Productosprecios(String nombre, double precio, String icono) {
        this.nombre = nombre;
        this.precio = precio;
        this.direccionicon= icono;
    }

    public String getDireccionicon() {
        return direccionicon;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
    
}
