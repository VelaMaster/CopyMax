/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Alan
 */
public class AddClientCommand implements ClientCommand{

    private ClientService receiver;

    public AddClientCommand(ClientService receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.addClient();
    }
}
