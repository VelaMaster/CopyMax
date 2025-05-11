package Modelo;

public class FiltroAlfanumerico extends FiltroDocumento {
    @Override
    protected boolean validarEntrada(String texto) {
         return texto.matches("[a-zA-Z0-9ñÑáéíóúÁÉÍÓÚ\\s]+");
    }
}