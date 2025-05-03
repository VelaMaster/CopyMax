package Modelo;

import java.util.List;

public class ClientesFacade {

    private Clientesclass clientesclass;

    public ClientesFacade() {
        this.clientesclass = new Clientesclass();
    }
    public List<Clientesclass> obtenerClientes() {
        return clientesclass.obtenerClientes();
    }
    public List<Clientesclass> obtenerClientesPorNumero(String numero) {
        return clientesclass.obtenerClientesPorNumero(numero);
    }
    public List<Clientesclass> obtenerClientesidnombre() {
        return clientesclass.obtenerClientesidnombre();
    }
}
