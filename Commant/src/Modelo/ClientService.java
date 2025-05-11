/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Conexion.Conexion;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Alan
 */
public class ClientService {

    private Clientesclass model;

    public ClientService(Clientesclass model) {
        this.model = model;
    }

    public void addClient() {
        Conexion conex = new Conexion();
        String sql = "INSERT INTO Cliente (Nombre, Apellidos, Celular, RFC, Correo) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pst = conex.getConnection().prepareCall(sql)) {
            pst.setString(1, model.getNombre());
            pst.setString(2, model.getApellidos());
            pst.setString(3, model.getCelular());
            pst.setString(4, model.getRfc());
            pst.setString(5, model.getCorreo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cliente Agregado Con Exito !!!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar cliente: " + e.toString());
        }
    }

    public void updateClient() {
        Conexion conex = new Conexion();
        String sql = "UPDATE Cliente SET Nombre=?, Apellidos=?, RFC=?, Correo=? WHERE Celular=?";
        try (PreparedStatement pst = conex.getConnection().prepareCall(sql)) {
            pst.setString(1, model.getNombre());
            pst.setString(2, model.getApellidos());
            pst.setString(3, model.getRfc());
            pst.setString(4, model.getCorreo());
            pst.setString(5, model.getCelular());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente Modificado Con Exito !!!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar cliente: " + e.toString());
        }
    }

    public void deleteClient() {
        Conexion conex = new Conexion();
        String sql = "DELETE FROM Cliente WHERE Celular=?";
        try (PreparedStatement pst = conex.getConnection().prepareCall(sql)) {
            pst.setString(1, model.getCelular());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente Eliminado Con Exito !!!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar cliente: " + e.toString());
        }
    }

}
