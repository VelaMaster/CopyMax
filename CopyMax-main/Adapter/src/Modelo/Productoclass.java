package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Productoclass {

    int id, cantidad;
    String nombre, categoria, icono;
    double precio;

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
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Método para obtener productos desde la base de datos
    public List<Productoclass> obtenerProductos() {
        List<Productoclass> productos = new ArrayList<>();
        Conexion conex = new Conexion();
        String sql = "SELECT idProductos, Nombre_producto, Precio, Cantidad, Categoria FROM Productos";

        try (Connection con = conex.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Productoclass producto = new Productoclass();

                producto.setId(rs.getInt("idProductos"));
                producto.setNombre(rs.getString("Nombre_producto"));
                producto.setPrecio(rs.getDouble("Precio"));
                producto.setCantidad(rs.getInt("Cantidad"));
                producto.setCategoria(rs.getString("Categoria"));
                productos.add(producto);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener productos: " + e.toString());
        }

        return productos;
    }

    // Método para obtener productos por categoría
    public List<Productoclass> obtenerClientesProductoscatego(String categoria) {
        List<Productoclass> productos = new ArrayList<>();
        Conexion conex = new Conexion();
        String sql = "SELECT idProductos, Nombre_producto, Precio, Cantidad, Categoria FROM Productos WHERE Categoria LIKE ?";

        try (Connection con = conex.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, "%" + categoria + "%");

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Productoclass producto = new Productoclass();

                    producto.setId(rs.getInt("idProductos"));
                    producto.setNombre(rs.getString("Nombre_producto"));
                    producto.setPrecio(rs.getDouble("Precio"));
                    producto.setCantidad(rs.getInt("Cantidad"));
                    producto.setCategoria(rs.getString("Categoria"));
                    productos.add(producto);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener productos por categoría: " + e.toString());
        }

        return productos;
    }
}

