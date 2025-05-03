package Vista;

import Modelo.Usuariosclass;
import Conexion.Conexion;
import Modelo.EntidadPersistente;
import Modelo.Letraseditor;
import Modelo.Numeroseditor;
import Modelo.UsuarioAdapter;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Usuariospan extends javax.swing.JPanel {

    private DefaultTableModel modelo;
    private EntidadPersistente<Usuariosclass> entidadPersistente;

    public Usuariospan() {
        initComponents();
        modelo = new DefaultTableModel() {
            // Hacer que la columna ID no sea editable
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0; // La columna 0 (ID) no es editable.
            }
        };
        modelo.addColumn("idUsuario");
        modelo.addColumn("Nombre de Usuario");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Celular");
        modelo.addColumn("Rol");
        Tablausuarios.setModel(modelo);

        entidadPersistente = new UsuarioAdapter(); // Usa el adaptador para Usuarios
        llenarTabla();
        tabladiseño();
        //El ID lo ocultamos 
        Tablausuarios.getColumnModel().getColumn(0).setMinWidth(0);
        Tablausuarios.getColumnModel().getColumn(0).setMaxWidth(0);
        Tablausuarios.getColumnModel().getColumn(0).setWidth(0);
    }

    private void tabladiseño() {
        // Asigna editores personalizados a las columnas para restringir el tipo de entrada
        Tablausuarios.getColumnModel().getColumn(1).setCellEditor(new Letraseditor());//Letras
        Tablausuarios.getColumnModel().getColumn(2).setCellEditor(new Letraseditor()); // Solo letras en columna Nombre
        Tablausuarios.getColumnModel().getColumn(3).setCellEditor(new Letraseditor()); // Solo letras en columna Apellidos
        Tablausuarios.getColumnModel().getColumn(4).setCellEditor(new Numeroseditor()); // Solo números en columna Celular
        //Tablausuarios.getColumnModel().getColumn(5).setCellEditor(new Letraseditor());//No es necesario, porque debe ser un combobox
        if (Tablausuarios.getColumnModel().getColumnCount() > 0) {

            Tablausuarios.getColumnModel().getColumn(0).setMaxWidth(90);
            Tablausuarios.getColumnModel().getColumn(1).setMaxWidth(150);
            Tablausuarios.getColumnModel().getColumn(2).setMaxWidth(120);
            Tablausuarios.getColumnModel().getColumn(3).setMaxWidth(160);
            Tablausuarios.getColumnModel().getColumn(4).setMaxWidth(140);
            Tablausuarios.getColumnModel().getColumn(5).setMaxWidth(150);

            Tablausuarios.setRowHeight(30);

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tablausuarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        BtnModificar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        Btnactualizar = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 204));

        Tablausuarios.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Tablausuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tablausuarios.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(Tablausuarios);
        Tablausuarios.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clasificacion (Custom).png"))); // NOI18N
        jLabel1.setText("Lista Usuarios");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        BtnModificar.setBackground(new java.awt.Color(153, 255, 204));
        BtnModificar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        BtnModificar.setForeground(new java.awt.Color(0, 0, 0));
        BtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reclutamiento.png"))); // NOI18N
        BtnModificar.setText("Modificar");
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });

        BtnEliminar.setBackground(new java.awt.Color(255, 153, 153));
        BtnEliminar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        BtnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        BtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida.png"))); // NOI18N
        BtnEliminar.setText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        Btnactualizar.setBackground(new java.awt.Color(204, 204, 255));
        Btnactualizar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Btnactualizar.setForeground(new java.awt.Color(0, 0, 0));
        Btnactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuarios.png"))); // NOI18N
        Btnactualizar.setText("Actualizar");
        Btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnactualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(BtnModificar)
                .addGap(18, 18, 18)
                .addComponent(Btnactualizar)
                .addGap(18, 18, 18)
                .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btnactualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        int selectedRow = Tablausuarios.getSelectedRow();
        if (selectedRow != -1) {
            // Obtener los valores de la fila, incluyendo el ID.
            int id = (int) modelo.getValueAt(selectedRow, 0);  // Obtiene el ID
            String nombreUsuario = (String) modelo.getValueAt(selectedRow, 1);
            String nombre = (String) modelo.getValueAt(selectedRow, 2);
            String apellidos = (String) modelo.getValueAt(selectedRow, 3);
            String celular = (String) modelo.getValueAt(selectedRow, 4);
            String rol = (String) modelo.getValueAt(selectedRow, 5);

            Usuariosclass usuario = new Usuariosclass();
            usuario.setId(id);  // Establece el ID
            usuario.setNombreUsuario(nombreUsuario);
            usuario.setNombre(nombre);
            usuario.setApellidos(apellidos);
            usuario.setCelular(celular);
            usuario.setRol(rol);
            //usuario.setContraseña(contraseña);  //Si vas a permitir cambiar la contraseña.

            // Usa el Adapter para actualizar
            entidadPersistente.actualizar(usuario);
            JOptionPane.showMessageDialog(this, "Usuario modificado con éxito.");
            actualizarTabla(); // Actualiza la tabla para reflejar los cambios.
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para modificar.");
        }
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        int selectedRow = Tablausuarios.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) modelo.getValueAt(selectedRow, 0); // Obtiene el ID

            // Usa el Adapter para eliminar
            entidadPersistente.eliminar(id);
            JOptionPane.showMessageDialog(this, "Usuario eliminado con éxito.");
            actualizarTabla(); // Actualiza la tabla
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.");
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnactualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_BtnactualizarActionPerformed

    private void llenarTabla() {
        modelo.setRowCount(0); // Limpia la tabla
        List<Usuariosclass> usuarios = entidadPersistente.obtenerTodos(); // Usa el Adapter

        for (Usuariosclass usuario : usuarios) {
            Object[] fila = new Object[6]; //  6 columnas
            fila[0] = usuario.getId();       // ID
            fila[1] = usuario.getNombreUsuario();
            fila[2] = usuario.getNombre();
            fila[3] = usuario.getApellidos();
            fila[4] = usuario.getCelular();
            fila[5] = usuario.getRol();
            modelo.addRow(fila);
        }
    }

    public void actualizarTabla() {
        modelo.setRowCount(0); // Limpia la tabla
        List<Usuariosclass> usuarios = entidadPersistente.obtenerTodos();  // Usa el Adapter

        for (Usuariosclass usuario : usuarios) {
            Object[] fila = new Object[6]; // 6 columnas
            fila[0] = usuario.getId();    // ID
            fila[1] = usuario.getNombreUsuario();
            fila[2] = usuario.getNombre();
            fila[3] = usuario.getApellidos();
            fila[4] = usuario.getCelular();
            fila[5] = usuario.getRol();
            modelo.addRow(fila);
        }
    }

    public void ajustarInterfazSegunRol(String rol) {
        if ("Estandar".equals(rol)) {
            BtnModificar.setEnabled(false);
            BtnEliminar.setEnabled(false);

        } else {
            BtnModificar.setEnabled(true);
            BtnEliminar.setEnabled(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnEliminar;
    public javax.swing.JButton BtnModificar;
    private javax.swing.JButton Btnactualizar;
    private javax.swing.JTable Tablausuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
