/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Clientesclass {

    int id;
    String Correo;
    String Celular;
    String Rfc;
    String Nombre;
    String Apellidos;

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getRfc() {
        return Rfc;
    }

    public void setRfc(String Rfc) {
        this.Rfc = Rfc;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }
    //Metodos de acceso a datos
    public List<Clientesclass> obtenerClientes() {
        List<Clientesclass> clientes = new ArrayList<>();
        Conexion conex = new Conexion();
        String sql = "SELECT idCliente, Nombre, Apellidos, Celular, RFC, Correo FROM Cliente"; // Incluye idCliente

        try (Connection con = conex.getConnection(); PreparedStatement pst = con.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Clientesclass cliente = new Clientesclass();
                cliente.setId(rs.getInt("idCliente")); // Obtén el ID
                cliente.setNombre(rs.getString("Nombre"));
                cliente.setApellidos(rs.getString("Apellidos"));
                cliente.setCelular(rs.getString("Celular"));
                cliente.setRfc(rs.getString("RFC"));
                cliente.setCorreo(rs.getString("Correo"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener clientes: " + e.getMessage()); // Mejor manejo de errores
        }
        return clientes;
    }

    public List<Clientesclass> obtenerClientesPorNumero(String numero) {
        List<Clientesclass> clientes = new ArrayList<>();
        Conexion conex = new Conexion();
        String sql = "SELECT idCliente, Nombre, Apellidos, Celular, RFC, Correo FROM Cliente WHERE Celular LIKE ?"; // Incluye idCliente

        try (Connection con = conex.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, "%" + numero + "%"); // Correcto

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Clientesclass cliente = new Clientesclass();
                    cliente.setId(rs.getInt("idCliente")); // Obtén el ID
                    cliente.setNombre(rs.getString("Nombre"));
                    cliente.setApellidos(rs.getString("Apellidos"));
                    cliente.setCelular(rs.getString("Celular"));
                    cliente.setRfc(rs.getString("RFC"));
                    cliente.setCorreo(rs.getString("Correo"));
                    clientes.add(cliente);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener clientes por número: " + e.getMessage()); // Mejor manejo de errores
        }
        return clientes;
    }

    // Método para ACTUALIZAR un cliente
    public void actualizarClienteBD(Clientesclass cliente) {
        Conexion conex = new Conexion();
        String sql = "UPDATE Cliente SET Nombre = ?, Apellidos = ?, Celular = ?, RFC = ?, Correo = ? WHERE idCliente = ?"; // Usamos idCliente

        try (Connection con = conex.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellidos());
            pst.setString(3, cliente.getCelular());
            pst.setString(4, cliente.getRfc());
            pst.setString(5, cliente.getCorreo());
            pst.setInt(6, cliente.getId()); // Usamos el ID para la condición WHERE
            pst.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar cliente: " + e.getMessage());
        }
    }

    // Método para ELIMINAR un cliente 
    public void eliminarClienteBD(int idCliente) { // Recibe el ID como entero
        Conexion conex = new Conexion();
        String sql = "DELETE FROM Cliente WHERE idCliente = ?"; // Usamos idCliente

        try (Connection con = conex.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, idCliente); // Usamos el ID
            pst.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar cliente: " + e.getMessage());
        }
    }

    public List<Clientesclass> obtenerClientesidnombre() {
        List<Clientesclass> clientes = new ArrayList<>();
        Conexion conex = new Conexion();
        String sql = "SELECT idCliente, Nombre FROM Cliente";

        try (Connection con = conex.getConnection(); PreparedStatement pst = con.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

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
