package Modelo;

public class FiltroNumeros extends FiltroDocumento {
    @Override
    protected boolean validarEntrada(String texto) {
        return texto.matches("[0-9]+");
    }
}