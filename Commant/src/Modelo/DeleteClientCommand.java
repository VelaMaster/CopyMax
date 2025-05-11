/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Alan
 */
public class DeleteClientCommand implements ClientCommand {

    private ClientService receiver;

    public DeleteClientCommand(ClientService receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.deleteClient();
    }
}
