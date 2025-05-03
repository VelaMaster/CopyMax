/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.List;

/**
 *
 * @author Alan
 */
public class UsuarioAdapter implements EntidadPersistente<Usuariosclass> {

    private Usuariosclass usuariosDB; // Instancia de la clase existente (Adaptee)

    public UsuarioAdapter() {
        usuariosDB = new Usuariosclass();
    }

    @Override
    public List<Usuariosclass> obtenerTodos() {
        return usuariosDB.obtenerUsuarios();
    }

    @Override
    public void actualizar(Usuariosclass usuario) {
        usuariosDB.actualizarUsuarioBD(usuario); // Nombres de métodos consistentes
    }

    @Override
    public void eliminar(int id) {
        usuariosDB.eliminarUsuarioBD(id); // Nombres de métodos consistentes
    }

    @Override
    public List<Usuariosclass> obtenerPorNumero(String numero) {
        return usuariosDB.obtenerUsuariosPorNumero(numero);
    }
}
