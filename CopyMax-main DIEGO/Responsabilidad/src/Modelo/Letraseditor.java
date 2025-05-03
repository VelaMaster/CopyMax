    package Modelo;
    import javax.swing.*;
    import javax.swing.text.*;
    import java.awt.event.*;

    public class Letraseditor extends DefaultCellEditor {
         private boolean shouldReplaceContent = true;

        public Letraseditor() {
            super(new JTextField());
            JTextField textField = (JTextField) getComponent();
            ((AbstractDocument) textField.getDocument()).setDocumentFilter(new FiltroLetras());

            textField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    shouldReplaceContent = true;
                    textField.selectAll();
                }
            });

            textField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    if (shouldReplaceContent) {
                        textField.setText("");
                        shouldReplaceContent = false;
                    }
                }
            });
        }
    }
