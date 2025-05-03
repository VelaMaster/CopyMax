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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Usuariosclass {

    int id;
    String Nombre, NombreUsuario, Apellidos, Celular, Contraseña, Rol;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    // Método para obtener usuarios de la base de datos
    public List<Usuariosclass> obtenerUsuarios() {
        List<Usuariosclass> usuarios = new ArrayList<>();
        Conexion conex = new Conexion();
        String sql = "SELECT idUsuario, Nombreusuario, Nombre, Apellidos, Celular, Rol FROM Usuario";

        try (Connection con = conex.getConnection(); PreparedStatement pst = con.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Usuariosclass usuario = new Usuariosclass();
                usuario.setId(rs.getInt("idUsuario"));
                usuario.setNombreUsuario(rs.getString("Nombreusuario"));
                usuario.setNombre(rs.getString("Nombre"));
                usuario.setApellidos(rs.getString("Apellidos"));
                usuario.setCelular(rs.getString("Celular"));
                usuario.setRol(rs.getString("Rol"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener usuarios: " + e.getMessage()); // Mejor manejo de error
        }
        return usuarios;
    }

    public List<Usuariosclass> obtenerUsuariosAdministradores() {
        List<Usuariosclass> usuarios = new ArrayList<>();
        Conexion conex = new Conexion();
        String sql = "SELECT Nombreusuario, Rol FROM Usuario";

        try (Connection con = conex.getConnection(); PreparedStatement pst = con.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Usuariosclass usuario = new Usuariosclass();
                usuario.setId(rs.getInt("idUsuario"));
                usuario.setNombreUsuario(rs.getString("Nombreusuario"));
                usuario.setNombre(rs.getString("Nombre"));
                usuario.setApellidos(rs.getString("Apellidos"));
                usuario.setCelular(rs.getString("Celular"));
                usuario.setRol(rs.getString("Rol"));

                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener usuarios: " + e.toString());
        }

        return usuarios;
    }

    public List<Usuariosclass> obtenerUsuariosPorNumero(String numero) {
        List<Usuariosclass> usuarios = new ArrayList<>();
        Conexion conex = new Conexion();
        String sql = "SELECT idUsuario, Nombre, Apellidos, Nombreusuario, Celular, Rol FROM Usuario WHERE Celular LIKE ?"; // Incluye idUsuario

        try (Connection con = conex.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, "%" + numero + "%");

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Usuariosclass usuario = new Usuariosclass();
                    usuario.setId(rs.getInt("idUsuario")); // Obtén el ID
                    usuario.setNombre(rs.getString("Nombre"));
                    usuario.setApellidos(rs.getString("Apellidos"));
                    usuario.setNombreUsuario(rs.getString("Nombreusuario"));
                    usuario.setCelular(rs.getString("Celular"));
                    usuario.setRol(rs.getString("Rol"));
                    usuarios.add(usuario);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener usuarios por número: " + e.getMessage());// Mejor manejo de errores
        }
        return usuarios;
    }

    public void actualizarUsuarioBD(Usuariosclass usuario) {
        Conexion conex = new Conexion();
        //Corrección en la consulta: Incluye todos los campos a actualizar, incluyendo Contraseña si la vas a cambiar.
        String sql = "UPDATE Usuario SET Nombreusuario = ?, Nombre = ?, Apellidos = ?, Celular = ?, Rol = ?, Contraseña = ? WHERE idUsuario = ?";

        try (Connection con = conex.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, usuario.getNombreUsuario());
            pst.setString(2, usuario.getNombre());
            pst.setString(3, usuario.getApellidos());
            pst.setString(4, usuario.getCelular());
            pst.setString(5, usuario.getRol());
            pst.setString(6, usuario.getContraseña()); //  ¡CUIDADO!  Deberías usar hashing.
            pst.setInt(7, usuario.getId()); // Usamos el ID
            pst.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el Usuario: " + e.getMessage());
        }
    }

    public void eliminarUsuarioBD(int idUsuario) {
        Conexion conex = new Conexion();
        String sql = "DELETE FROM Usuario WHERE idUsuario = ?";

        try (Connection con = conex.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, idUsuario);
            pst.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el Usuario: " + e.getMessage());
        }
    }
}
