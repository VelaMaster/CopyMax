/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
 import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
/**
 *
 * @author orvic
 */
public class TestJackson {
   


    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            
            // Crear un objeto de prueba
            Productoclass producto = new Productoclass();
            producto.setId(1);
            producto.setNombre("Lápiz");
            producto.setPrecio(5.0);
            producto.setCantidad(10);
            producto.setCategoria("Papelería");

            // Convertir el objeto a JSON
            String json = objectMapper.writeValueAsString(producto);
            System.out.println("Objeto convertido a JSON: " + json);

            // Convertir JSON a objeto
            Productoclass nuevoProducto = objectMapper.readValue(json, Productoclass.class);
            System.out.println("Producto convertido desde JSON: " + nuevoProducto.getNombre());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


