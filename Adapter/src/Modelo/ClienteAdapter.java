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
public class ClienteAdapter implements EntidadPersistente<Clientesclass> {

    private Clientesclass clientes; // O una clase ClienteDAO

    public ClienteAdapter() {
        clientes = new Clientesclass();
    }

    @Override
    public List<Clientesclass> obtenerTodos() {
        return clientes.obtenerClientes();
    }

    @Override
    public void actualizar(Clientesclass cliente) {
        clientes.actualizarClienteBD(cliente);
    }

    @Override
    public void eliminar(int id) {
        clientes.eliminarClienteBD(id); //  Ahora recibe el ID como int
    }

    @Override
    public List<Clientesclass> obtenerPorNumero(String numero) {
        return clientes.obtenerClientesPorNumero(numero);
    }
}
