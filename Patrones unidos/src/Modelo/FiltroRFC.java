package Modelo;
import javax.swing.text.DocumentFilter;

public class FiltroRFC extends DocumentFilter{
    private Filtro siguiente;

    public void setSiguiente(Filtro siguiente) {
        this.siguiente = siguiente;
    }

    public boolean validar(String texto) {
        if (texto.length() != 13) {
            System.out.println("Error: El RFC debe tener exactamente 13 caracteres.");
            return false;
        }
        String primeros4 = texto.substring(0, 4);
        if (!primeros4.matches("[A-Za-z]{4}")) {
            System.out.println("Error: Los primeros 4 caracteres deben ser letras.");
            return false;
        }
        String siguientes6 = texto.substring(4, 10);
        if (!siguientes6.matches("[0-9]{6}")) {
            System.out.println("Error: Los siguientes 6 caracteres deben ser números.");
            return false;
        }
        String ultimos3 = texto.substring(10, 13);
        if (!ultimos3.matches("[A-Za-z0-9]{3}")) {
            System.out.println("Error: Los últimos 3 caracteres deben ser alfanuméricos.");
            return false;
        }
        return siguiente == null || siguiente.validar(texto);
    }
}
