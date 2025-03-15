package Modelo;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Productoclass implements Producto {
    private int id, cantidad, stock;
    private String Nombre, Categoria, icono;
    private double precio;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Métodos para stock
    @Override
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // Método para obtener productos desde la BD
    public List<Producto> obtenerProductos() {
        List<Producto> productos = new ArrayList<>();
        Conexion conex = new Conexion();
        String sql = "SELECT idProductos, Nombre_producto, Precio, Cantidad, Categoria FROM Productos";

        try (Connection con = conex.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("idProductos");
                String nombre = rs.getString("Nombre_producto");
                double precio = rs.getDouble("Precio");
                int cantidad = rs.getInt("Cantidad");
                String categoria = rs.getString("Categoria");

                // Crear producto
                Productoclass producto = new Productoclass();
                producto.setId(id);
                producto.setNombre(nombre);
                producto.setPrecio(precio);
                producto.setCantidad(cantidad);
                producto.setCategoria(categoria);
                producto.setStock(cantidad); // Asignamos el stock correctamente

                productos.add(producto);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener productos: " + e.toString());
        }
        return productos;
    }

    public List<Producto> obtenerClientesProductoscatego(String categoria) {
        List<Producto> productos = new ArrayList<>();
        Conexion conex = new Conexion();
        String sql = "SELECT idProductos, Nombre_producto, Precio, Cantidad, Categoria FROM Productos WHERE Categoria LIKE ?";

        try (Connection con = conex.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, "%" + categoria + "%");

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("idProductos");
                    String nombre = rs.getString("Nombre_producto");
                    double precio = rs.getDouble("Precio");
                    int cantidad = rs.getInt("Cantidad");
                    String categoriaBD = rs.getString("Categoria");

                    Productoclass producto = new Productoclass();
                    producto.setId(id);
                    producto.setNombre(nombre);
                    producto.setPrecio(precio);
                    producto.setCantidad(cantidad);
                    producto.setCategoria(categoriaBD);
                    producto.setStock(cantidad); 

                    productos.add(producto);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener productos por categoría: " + e.toString());
        }
        return productos;
    }

    // Método para validar stock en ticket
    private boolean validarStockEnTicket(List<Producto> listaProductos) {
        for (Producto producto : listaProductos) {
            if (producto.getStock() < 1) {
                return false;
            }
        }
        return true;
    }
}
