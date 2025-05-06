package Modelo;

import java.util.List;

public class ClientesFacade {
    private Clientesclass clientesclass;

    public ClientesFacade() {
        this.clientesclass = new Clientesclass();
    }
    // Método que obtiene todos los clientes
    public List<Clientesclass> obtenerClientes() {
        return clientesclass.obtenerClientes(); 
    } 
    // Método que obtiene clientes por número de celular
    public List<Clientesclass> obtenerClientesPorNumero(String numero) {
        return clientesclass.obtenerClientesPorNumero(numero);
    }
    // Método que obtiene clientes por ID y nombre
    public List<Clientesclass> obtenerClientesidnombre() {
        return clientesclass.obtenerClientesidnombre();
    }
}
