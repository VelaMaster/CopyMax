/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

import java.util.List;

/**
 *
 * @author Alan
 */
public interface EntidadPersistente<T> { // Interfaz genérica

    List<T> obtenerTodos();

    void actualizar(T entidad);

    void eliminar(int id);

    // Podrías agregar métodos para buscar por ID, etc.
    List<T> obtenerPorNumero(String numero);
}
