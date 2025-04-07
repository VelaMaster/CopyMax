/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Conexion.Conexion;
import Vista.Usuariospan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Alan
 */
public class UsuarioMediator {

    private Usuariosclass modeloUsuario;
    private Usuariospan vistaUsuario;
    private Usuariosesion sesion;

    public UsuarioMediator(Usuariosclass modelo, Usuariospan vista, Usuariosesion sesion) {
        this.modeloUsuario = modelo;
        this.vistaUsuario = vista;
        this.sesion = sesion;
        this.modeloUsuario.setMediator(this); // Establecer la referencia al mediador en el modelo
        this.vistaUsuario.setMediator(this); // Establecer la referencia al mediador en la vista
    }


    // Métodos mediados - Ahora con lógica de base de datos
    public List<Usuariosclass> obtenerUsuariosBD() {
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
            JOptionPane.showMessageDialog(null, "Error al obtener usuarios: " + e.toString());
        }
        return usuarios;
    }

    public void actualizarUsuarioBD(Usuariosclass usuario) {
        Conexion conex = new Conexion();
        String consulta = "UPDATE Usuario SET Nombreusuario=?, Nombre=?, Apellidos=?, Celular=?, Rol=? WHERE idUsuario=?";
        try (
                PreparedStatement pst = conex.getConnection().prepareCall(consulta)) {
            pst.setString(1, usuario.getNombreUsuario());
            pst.setString(2, usuario.getNombre());
            pst.setString(3, usuario.getApellidos());
            pst.setString(4, usuario.getCelular()); // Corregido el orden
            pst.setString(5, usuario.getRol());     // Corregido el orden
            pst.setInt(6, usuario.getId());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario Modificado Con Exito !!!");
            notificarActualizacionGUI(); // Notificar a la vista después de la actualización
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar Usuario: " + e.toString());
        }
    }

    public void eliminarUsuarioBD(int id) {
        Conexion conex = new Conexion();
        String consulta = "DELETE FROM Usuario WHERE idUsuario = ?";
        try (
                PreparedStatement pst = conex.getConnection().prepareCall(consulta)) {
            pst.setInt(1, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario Eliminado Con Exito !!!");
            notificarActualizacionGUI(); // Notificar a la vista después de la eliminación
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar cliente: " + e.toString());
        }
    }

    public void notificarActualizacionGUI() {
        vistaUsuario.actualizarTabla();
    }

    public String getRolUsuarioActual() {
        return sesion.getRol();
    }

    // Método para solicitar la eliminación de un usuario desde la vista
    public void solicitarEliminacionUsuario(int idUsuario) {
        eliminarUsuarioBD(idUsuario);
    }

    // Método para solicitar la actualización de un usuario desde la vista
    public void solicitarActualizacionUsuario(Usuariosclass usuario) {
        actualizarUsuarioBD(usuario);
    }

    public List<Usuariosclass> obtenerUsuariosAdministradoresBD() {
        List<Usuariosclass> usuarios = new ArrayList<>();
        Conexion conex = new Conexion();
        String sql = "SELECT idUsuario, Nombreusuario, Nombre, Apellidos, Celular, Rol FROM Usuario WHERE Rol = 'Administrador'"; // Ejemplo de consulta

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
            JOptionPane.showMessageDialog(null, "Error al obtener usuarios administradores: " + e.toString());
        }
        return usuarios;
    }

    public List<Usuariosclass> obtenerUsuariosPorNumeroBD(String numero) {
        List<Usuariosclass> usuarios = new ArrayList<>();
        Conexion conex = new Conexion();
        String sql = "SELECT idUsuario, Nombre, Apellidos, Nombreusuario, Celular, Rol FROM Usuario WHERE Celular LIKE ?";
        try (Connection con = conex.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, "%" + numero + "%");
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Usuariosclass usuario = new Usuariosclass();
                    usuario.setId(rs.getInt("idUsuario"));
                    usuario.setNombre(rs.getString("Nombre"));
                    usuario.setApellidos(rs.getString("Apellidos"));
                    usuario.setNombreUsuario(rs.getString("Nombreusuario"));
                    usuario.setCelular(rs.getString("Celular"));
                    usuario.setRol(rs.getString("Rol"));
                    usuarios.add(usuario);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener clientes por número: " + e.toString());
        }
        return usuarios;
    }
}
