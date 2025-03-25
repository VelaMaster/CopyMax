package Modelo;
import java.util.List;

public class Cliente extends ClienteBase {
    public Cliente(ClienteImplementacion implementacion) {
        super(implementacion);
    }
    @Override
    public List<Clientesclass> obtenerClientes() {
        return implementacion.obtenerClientes();
    }
    @Override
    public List<Clientesclass> obtenerClientesPorNumero(String numero) {
        return implementacion.obtenerClientesPorNumero(numero);
    }
    @Override
    public List<Clientesclass> obtenerClientesidnombre() {
        return implementacion.obtenerClientesidnombre();
    }
}