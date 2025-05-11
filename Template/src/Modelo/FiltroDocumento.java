package Modelo;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public abstract class FiltroDocumento extends DocumentFilter {
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (string != null && validarEntrada(string)) {
            super.insertString(fb, offset, string, attr);
        }
    }
    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (text != null && validarEntrada(text)) {
            super.replace(fb, offset, length, text, attrs);
        }
    }
    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        super.remove(fb, offset, length);
    }
    protected abstract boolean validarEntrada(String texto);
}
