package Modelo;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import Modelo.FiltroLetras;
import Modelo.FiltroNumeros;
import Modelo.FiltroAlfanumerico;

public class voidTemplate {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CopyMax - Prueba de Filtros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        JTextField campoLetras = new JTextField();
        ((AbstractDocument) campoLetras.getDocument()).setDocumentFilter(new FiltroLetras());
        campoLetras.setBounds(50, 50, 300, 30);
        campoLetras.setToolTipText("Solo letras");

        JTextField campoNumeros = new JTextField();
        ((AbstractDocument) campoNumeros.getDocument()).setDocumentFilter(new FiltroNumeros());
        campoNumeros.setBounds(50, 100, 300, 30);
        campoNumeros.setToolTipText("Solo números");

        JTextField campoAlfanumerico = new JTextField();
        ((AbstractDocument) campoAlfanumerico.getDocument()).setDocumentFilter(new FiltroAlfanumerico());
        campoAlfanumerico.setBounds(50, 150, 300, 30);
        campoAlfanumerico.setToolTipText("Solo letras y números");

        frame.add(campoLetras);
        frame.add(campoNumeros);
        frame.add(campoAlfanumerico);

        frame.setVisible(true);
    }
}
