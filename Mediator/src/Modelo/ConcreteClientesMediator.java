/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.Clientes;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alan
 */
public class ConcreteClientesMediator implements ClientesMediator {

    private Clientes clientesPanel;
    private Clientesclass clientesClass;

    @Override
    public void registrarClientePanel(Clientes clientesPanel) {
        this.clientesPanel = clientesPanel;
    }

    @Override
    public void registrarClientesClass(Clientesclass clientesClass) {
        this.clientesClass = clientesClass;
    }

    @Override
    public void obtenerClientes() {
        if (clientesClass != null && clientesPanel != null) {
            List<Clientesclass> clientes = clientesClass.obtenerClientes();
            clientesPanel.actualizarTablaUI(clientes);
        }
    }

    @Override
    public void buscarClientesPorNumero(String numero) {
        if (clientesClass != null && clientesPanel != null) {
            List<Clientesclass> clientes = clientesClass.obtenerClientesPorNumero(numero);
            clientesPanel.actualizarTablaUI(clientes);
        }
    }

    @Override
    public void agregarNuevoCliente() {
        if (clientesPanel != null) {
            //RegistroClientes regi = new RegistroClientes();
            //regi.setVisible(true);
            // Aquí podríamos tener una forma de comunicar desde RegistroClientes
            // al Mediator cuando se guarda un nuevo cliente para refrescar la tabla.
            // Para este ejemplo, lo haremos mediante el botón "Actualizar".
        }
    }

    @Override
    public void modificarCliente(int selectedRow) {
        if (clientesPanel != null && selectedRow != -1) {
            DefaultTableModel modelo = clientesPanel.getModeloTabla();
            String nombre = (String) modelo.getValueAt(selectedRow, 0);
            String apellidos = (String) modelo.getValueAt(selectedRow, 1);
            String celular = (String) modelo.getValueAt(selectedRow, 2);
            String rfc = (String) modelo.getValueAt(selectedRow, 3);
            String correo = (String) modelo.getValueAt(selectedRow, 4);

            Clientesclass cliente = new Clientesclass();
            cliente.setNombre(nombre);
            cliente.setApellidos(apellidos);
            cliente.setCelular(celular);
            cliente.setRfc(rfc);
            cliente.setCorreo(correo);

            if (clientesClass != null) {
                clientesClass.actualizarClienteBD(cliente);
                obtenerClientes(); // Refrescar la tabla después de la modificación
            }
        } else if (clientesPanel != null) {
            JOptionPane.showMessageDialog(clientesPanel, "Seleccione una fila para modificar.");
        }
    }

    @Override
    public void eliminarCliente(int selectedRow) {
        if (clientesPanel != null && selectedRow != -1) {
            DefaultTableModel modelo = clientesPanel.getModeloTabla();
            String celular = (String) modelo.getValueAt(selectedRow, 2);

            if (clientesClass != null) {
                clientesClass.eliminarClienteBD(celular);
                obtenerClientes(); // Refrescar la tabla después de la eliminación
            }
        } else if (clientesPanel != null) {
            JOptionPane.showMessageDialog(clientesPanel, "Seleccione una fila para eliminar.");
        }
    }

    @Override
    public void actualizarTabla() {
        obtenerClientes();
    }
}
