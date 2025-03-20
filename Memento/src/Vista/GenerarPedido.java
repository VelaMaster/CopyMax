package Vista;

import Modelo.Pedidoclass;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author maxst
 */
public class GenerarPedido extends javax.swing.JPanel {

    private static GenerarPedido instance;

    public static GenerarPedido getInstancePedido() {
        if (instance == null) {
            instance = new GenerarPedido();
        }
        return instance;
    }

    public GenerarPedido() {
        initComponents();
        cargarPedidosEnTabla(Tablapedido);
        agregarListenerTabla(Tablapedido, txtNumPedido, txtCajero, txtNombre, txtCelular, txtServicio, txtTotal, txtAnticipo, txtResto, txtFechayHora);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGenerarPedido = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tablapedido = new javax.swing.JTable();
        btnrefrescar = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        btnFinalizarpedido = new javax.swing.JButton();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        txtNumPedido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtAnticipo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtResto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtServicio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCajero = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtFechayHora = new javax.swing.JTextField();
        VerPedido = new javax.swing.JButton();
        btnactualzar = new javax.swing.JButton();

        setBackground(new java.awt.Color(240, 240, 240));

        btnGenerarPedido.setBackground(new java.awt.Color(204, 204, 204));
        btnGenerarPedido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGenerarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pedido.png"))); // NOI18N
        btnGenerarPedido.setText("Generar Pedido");
        btnGenerarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarPedidoActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Generación de Pedidos");

        Tablapedido.setModel(new javax.swing.table.DefaultTableModel(
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
        Tablapedido.setShowGrid(true);
        jScrollPane1.setViewportView(Tablapedido);

        btnrefrescar.setBackground(new java.awt.Color(204, 255, 204));
        btnrefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar-flecha.png"))); // NOI18N
        btnrefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefrescarActionPerformed(evt);
            }
        });

        jDesktopPane1.setBackground(new java.awt.Color(240, 240, 240));
        jDesktopPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jDesktopPane1.setForeground(new java.awt.Color(0, 0, 0));

        txtNombre.setBackground(new java.awt.Color(240, 240, 240));
        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Nombre:");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Celular:");

        txtCelular.setBackground(new java.awt.Color(240, 240, 240));
        txtCelular.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jDesktopPane1.setLayer(txtNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txtCelular, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(txtCelular))
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnFinalizarpedido.setBackground(new java.awt.Color(204, 204, 204));
        btnFinalizarpedido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFinalizarpedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/entrega (Custom).png"))); // NOI18N
        btnFinalizarpedido.setText("Finalizar Pedido");
        btnFinalizarpedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarpedidoActionPerformed(evt);
            }
        });

        jDesktopPane2.setBackground(new java.awt.Color(240, 240, 240));
        jDesktopPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Pedido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jDesktopPane2.setForeground(new java.awt.Color(0, 0, 0));

        txtNumPedido.setBackground(new java.awt.Color(240, 240, 240));
        txtNumPedido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNumPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumPedidoActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("N° de P:");

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Total: $");

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Anticipo: $");

        txtTotal.setBackground(new java.awt.Color(240, 240, 240));
        txtTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtAnticipo.setBackground(new java.awt.Color(240, 240, 240));
        txtAnticipo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Resto: $");

        txtResto.setBackground(new java.awt.Color(240, 240, 240));
        txtResto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Servicio:");

        txtServicio.setBackground(new java.awt.Color(240, 240, 240));
        txtServicio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtServicioActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Cajero:");

        txtCajero.setBackground(new java.awt.Color(240, 240, 240));
        txtCajero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Hora y Fecha de Entrega:");

        txtFechayHora.setBackground(new java.awt.Color(240, 240, 240));
        txtFechayHora.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jDesktopPane2.setLayer(txtNumPedido, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(txtTotal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(txtAnticipo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(txtResto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(txtServicio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(txtCajero, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(txtFechayHora, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNumPedido)
                            .addComponent(txtServicio, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCajero, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(12, 12, 12)
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane2Layout.createSequentialGroup()
                                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtTotal, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAnticipo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtResto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechayHora)))
                .addContainerGap())
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNumPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtAnticipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtResto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtCajero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechayHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        VerPedido.setBackground(new java.awt.Color(204, 204, 204));
        VerPedido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        VerPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/vista.png"))); // NOI18N
        VerPedido.setText("Ver Pedido");
        VerPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerPedidoActionPerformed(evt);
            }
        });

        btnactualzar.setBackground(new java.awt.Color(204, 204, 204));
        btnactualzar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnactualzar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pedido.png"))); // NOI18N
        btnactualzar.setText("Actualizar pedido");
        btnactualzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualzarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jDesktopPane2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFinalizarpedido)
                            .addComponent(btnGenerarPedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VerPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnactualzar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(187, 187, 187)
                        .addComponent(btnrefrescar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 19, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 831, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(btnrefrescar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnGenerarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnactualzar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(VerPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFinalizarpedido, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPedidoActionPerformed
        Pedido pedidoventana = new Pedido();
        pedidoventana.setVisible(true);

    }//GEN-LAST:event_btnGenerarPedidoActionPerformed

    private void btnFinalizarpedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarpedidoActionPerformed
        try {
            int numPedido = Integer.parseInt(txtNumPedido.getText());

            // Llamar al método para finalizar el pedido
            finalizarPedido(numPedido);
            double resto = Double.parseDouble(txtResto.getText());

            if (txtResto.equals("PAGADO")) {
                System.out.println("no hace nada -_-");
            } else {
                actualizarCaja(resto);
            }
            // Opcional: recargar los datos en la tabla
            actualizarpedidos();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce un número de pedido válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnFinalizarpedidoActionPerformed

    public void actualizarCaja(double resto) {
        Conexion conex = new Conexion();

        // Consultas SQL
        String obtenerTotalesSQL = "SELECT TotalPedidos, TotalCaja FROM caja WHERE DATE(FechaInicio) = CURDATE()";
        String actualizarCajaSQL = "UPDATE caja SET TotalPedidos = ?, TotalCaja = ? WHERE DATE(FechaInicio) = CURDATE()";

        try (Connection con = conex.getConnection(); PreparedStatement pstObtener = con.prepareStatement(obtenerTotalesSQL); PreparedStatement pstActualizar = con.prepareStatement(actualizarCajaSQL)) {

            // Paso 1: Obtener los valores actuales de TotalPedidos y TotalCaja
            double totalPedidosActual = 0.0;
            double totalCajaActual = 0.0;

            try (ResultSet rs = pstObtener.executeQuery()) {
                if (rs.next()) {
                    totalPedidosActual = rs.getDouble("TotalPedidos");
                    totalCajaActual = rs.getDouble("TotalCaja");
                }
            }

            // Paso 2: Calcular los nuevos valores
            double nuevoTotalPedidos = totalPedidosActual + resto;
            double nuevoTotalCaja = totalCajaActual + resto;

            // Paso 3: Actualizar la tabla caja
            pstActualizar.setDouble(1, nuevoTotalPedidos);
            pstActualizar.setDouble(2, nuevoTotalCaja);

            int rowsUpdated = pstActualizar.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Caja actualizada exitosamente con el anticipo.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar la caja.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al actualizar la caja: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnrefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefrescarActionPerformed
        actualizarpedidos();
    }//GEN-LAST:event_btnrefrescarActionPerformed

    private void txtNumPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumPedidoActionPerformed

    private void txtServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServicioActionPerformed

    private void VerPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerPedidoActionPerformed
        generarReporte(Integer.parseInt(txtNumPedido.getText()));
    }//GEN-LAST:event_VerPedidoActionPerformed

    private void btnactualzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualzarActionPerformed
        //Obtengo la fila
        int filaSeleccionada = Tablapedido.getSelectedRow();
        //Valido la seleccion
        if (filaSeleccionada >= 0) {
            //Creo la instancia
            Pedido pedidoventana = new Pedido();

            // Obtener *TODOS* los datos del pedido.  Esto es crucial.
            DefaultTableModel model = (DefaultTableModel) Tablapedido.getModel();
            Pedidoclass pedidoSeleccionado = new Pedidoclass();
            pedidoSeleccionado.setNumpedido(Integer.parseInt(model.getValueAt(filaSeleccionada, 0).toString()));
            pedidoSeleccionado.setNombredeusuario(model.getValueAt(filaSeleccionada, 1).toString());
            pedidoSeleccionado.setNombrecliennte(model.getValueAt(filaSeleccionada, 2).toString());
            pedidoSeleccionado.setCelularcliente(model.getValueAt(filaSeleccionada, 3).toString());
            pedidoSeleccionado.setServicio(model.getValueAt(filaSeleccionada, 4).toString());
            try {
                // Formatos para la fecha y la hora
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

                // Convertir la fecha y hora combinadas en objetos Date
                Date fechaEntregaDate = dateFormat.parse(model.getValueAt(filaSeleccionada, 5).toString());
                Date horaEntregaDate = timeFormat.parse(model.getValueAt(filaSeleccionada, 6).toString());
                pedidoSeleccionado.setFechaentrega(fechaEntregaDate);
                pedidoSeleccionado.setHoraentrega(horaEntregaDate);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al cargar los datos del pedido: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();

            }

            pedidoSeleccionado.setTotal(Double.parseDouble(model.getValueAt(filaSeleccionada, 7).toString()));
            pedidoSeleccionado.setAnticipo(Double.parseDouble(model.getValueAt(filaSeleccionada, 8).toString()));
            pedidoSeleccionado.setResto(Double.parseDouble(model.getValueAt(filaSeleccionada, 9).toString()));
            pedidoSeleccionado.setStatus(model.getValueAt(filaSeleccionada, 10).toString());

            // Recuperar todos los atributos desde la base de datos
            pedidoSeleccionado = pedidoSeleccionado.obtenerPedidoPorNumero(pedidoSeleccionado.getNumpedido());

            pedidoSeleccionado.guardarEstado(); // Guarda el estado *ACTUAL* (vacío, en este caso)
            // Llenar los campos de la ventana Pedido usando  el objeto Pedido
            pedidoventana.llenardatosactualizar(pedidoSeleccionado);
            pedidoventana.setVisible(true); // Mostrar la ventana Pedido

        } else {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un pedido de la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnactualzarActionPerformed
    private void generarReporte(int numpedido) {
        try {
            String reporthpath = "src/Reportes/Pedido.jasper"; // Ruta del reporte
            // Parámetros del reporte
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("Numpedido", numpedido); // Pasar el parámetro como int

            // Conexión a la base de datos
            Conexion conexion = new Conexion();
            if (conexion.verificarConexion()) {
                // Llenar el reporte con los datos
                JasperPrint jasperPrint = JasperFillManager.fillReport(reporthpath, parameters, conexion.getConnection());

                // Mostrar el reporte en el visor
                JasperViewer viewer = new JasperViewer(jasperPrint, false); // false evita cerrar la aplicación al cerrar el visor
                viewer.setTitle("Vista Previa del Reporte");
                viewer.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Error de conexión a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al visualizar el reporte: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void cargarPedidosEnTabla(JTable tabla) {
        // Obtener los pedidos pendientes

        List<Pedidoclass> pedidos = new Pedidoclass().obtenerpedidos();

        // Crear un modelo de tabla
        DefaultTableModel model = new DefaultTableModel();

        // Configurar las columnas de la tabla
        model.addColumn("Pedido");
        model.addColumn("Cajero");
        model.addColumn("Nombre");
        model.addColumn("Celular");
        model.addColumn("Servicio");
        model.addColumn("Fecha Entrega");
        model.addColumn("Hora Entrega");
        model.addColumn("Total");
        model.addColumn("Anticipo");
        model.addColumn("Resto");
        model.addColumn("Status");

        // Agregar filas al modelo
        for (Pedidoclass pedido : pedidos) {
            model.addRow(new Object[]{
                pedido.getNumpedido(),
                pedido.getNombredeusuario(),
                pedido.getNombrecliennte(),
                pedido.getCelularcliente(),
                pedido.getServicio(),
                pedido.getFechaentrega(),
                pedido.getHoraentrega(),
                pedido.getTotal(),
                pedido.getAnticipo(),
                pedido.getResto(),
                pedido.getStatus()
            });
        }

        // Establecer el modelo en la tabla
        tabla.setModel(model);

    }

    public void agregarListenerTabla(JTable tabla, JTextField txtNumPedido, JTextField txtCajero, JTextField txtNombre,
            JTextField txtCelular, JTextField txtServicio, JTextField txtTotal,
            JTextField txtAnticipo, JTextField txtResto, JTextField txtFechayhora) {

        tabla.getSelectionModel().addListSelectionListener(event -> {
            //Este if se encarga de que no se ejecute varias veces.
            if (!event.getValueIsAdjusting() && tabla.getSelectedRow() != -1) {
                // Obtén el modelo de la tabla
                DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                int filaSeleccionada = tabla.getSelectedRow();
                String fechayhora = model.getValueAt(filaSeleccionada, 6).toString() + " hrs " + model.getValueAt(filaSeleccionada, 5).toString();
                // Actualiza los JTextFields con los datos de la fila seleccionada
                txtNumPedido.setText(model.getValueAt(filaSeleccionada, 0).toString());
                txtCajero.setText(model.getValueAt(filaSeleccionada, 1).toString());
                txtNombre.setText(model.getValueAt(filaSeleccionada, 2).toString());
                txtCelular.setText(model.getValueAt(filaSeleccionada, 3).toString());
                txtServicio.setText(model.getValueAt(filaSeleccionada, 4).toString());
                txtTotal.setText(model.getValueAt(filaSeleccionada, 7).toString());
                txtAnticipo.setText(model.getValueAt(filaSeleccionada, 8).toString());

                if (model.getValueAt(filaSeleccionada, 9).toString().equals("0.0")) {
                    txtResto.setText("PAGADO");
                } else {
                    txtResto.setText(model.getValueAt(filaSeleccionada, 9).toString());
                }

                txtFechayHora.setText(fechayhora);
            }
        });
    }

    public void finalizarPedido(int numPedido) {
        Conexion conex = new Conexion();
        String sql = "UPDATE pedido SET Status = 'Finalizado' WHERE NumPedido = ?";

        try (Connection con = conex.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

            // Asignar el número de pedido al parámetro
            pst.setInt(1, numPedido);

            // Ejecutar el update
            int rowsUpdated = pst.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "¡Pedido finalizado exitosamente!");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo finalizar el pedido. Verifica el número de pedido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al finalizar el pedido: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizarpedidos() {
        cargarPedidosEnTabla(Tablapedido);
        Tablapedido.revalidate();
        Tablapedido.repaint();

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tablapedido;
    private javax.swing.JButton VerPedido;
    private javax.swing.JButton btnFinalizarpedido;
    private javax.swing.JButton btnGenerarPedido;
    private javax.swing.JButton btnactualzar;
    private javax.swing.JButton btnrefrescar;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAnticipo;
    private javax.swing.JTextField txtCajero;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtFechayHora;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumPedido;
    private javax.swing.JTextField txtResto;
    private javax.swing.JTextField txtServicio;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
