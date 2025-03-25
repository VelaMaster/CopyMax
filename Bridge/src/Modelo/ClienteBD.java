package Modelo;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteBD implements ClienteImplementacion {
    @Override
    public List<Clientesclass> obtenerClientes() {
        List<Clientesclass> clientes = new ArrayList<>();
        Conexion conex = new Conexion();
        String sql = "SELECT Nombre, Apellidos, Celular, RFC, Correo FROM Cliente";

        try (Connection con = conex.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            
            while (rs.next()) {
                Clientesclass cliente = new Clientesclass();
                cliente.setNombre(rs.getString("Nombre"));
                cliente.setApellidos(rs.getString("Apellidos"));
                cliente.setCelular(rs.getString("Celular"));
                cliente.setRfc(rs.getString("RFC"));
                cliente.setCorreo(rs.getString("Correo"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener clientes: " + e.toString());
        }

        return clientes;
    }

    @Override
    public List<Clientesclass> obtenerClientesPorNumero(String numero) {
        List<Clientesclass> clientes = new ArrayList<>();
        Conexion conex = new Conexion();
        String sql = "SELECT Nombre, Apellidos, Celular, RFC, Correo FROM Cliente WHERE Celular LIKE ?";

        try (Connection con = conex.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, "%" + numero + "%");

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Clientesclass cliente = new Clientesclass();
                    cliente.setNombre(rs.getString("Nombre"));
                    cliente.setApellidos(rs.getString("Apellidos"));
                    cliente.setCelular(rs.getString("Celular"));
                    cliente.setRfc(rs.getString("RFC"));
                    cliente.setCorreo(rs.getString("Correo"));
                    clientes.add(cliente);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener clientes por número: " + e.toString());
        }
        return clientes;
    }

    @Override
    public List<Clientesclass> obtenerClientesidnombre() {
        List<Clientesclass> clientes = new ArrayList<>();
        Conexion conex = new Conexion();
        String sql = "SELECT idCliente, Nombre FROM Cliente";

        try (Connection con = conex.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            
            while (rs.next()) {
                Clientesclass cliente = new Clientesclass();
                cliente.setId(rs.getInt("idCliente"));
                cliente.setNombre(rs.getString("Nombre"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener clientes: " + e.toString());
        }

        return clientes;
    }
}