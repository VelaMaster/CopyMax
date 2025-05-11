package Modelo;

public class FiltroLetras extends FiltroDocumento {
    @Override
    protected boolean validarEntrada(String texto) {
        return texto.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+");
    }
}