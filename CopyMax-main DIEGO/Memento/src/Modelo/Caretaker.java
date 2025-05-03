/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Alan
 */
import java.util.Stack;

public class Caretaker {
    private Stack<Memento> mementos = new Stack<>();

    public void guardarMemento(Memento memento) {
        mementos.push(memento);
    }

    public Memento obtenerMemento() {
        if (!mementos.isEmpty()) {
            return mementos.pop();
        }
        return null;
    }
}