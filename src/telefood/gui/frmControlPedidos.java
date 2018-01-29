/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telefood.gui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import telefood.logica.Registro;
import telefood.logica.TeleFood;

/**
 *
 * @author Jorge
 */
public class frmControlPedidos extends javax.swing.JFrame {

    TeleFood pedidos = null;

    /**
     * Creates new form frmControlPedidos
     */
    public frmControlPedidos(TeleFood pedidos) throws Exception {
        initComponents();
        this.pedidos = pedidos;
        lblDividir.setVisible(false);
        spnCuentas.setVisible(false);
        llenar();
        llenarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSiguiente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPedidos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmbDesde = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        rbtnSi = new javax.swing.JRadioButton();
        rbtnNo = new javax.swing.JRadioButton();
        lblDividir = new javax.swing.JLabel();
        rbtnFactura = new javax.swing.JRadioButton();
        rbtnConsumidor = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        spnCuentas = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telefood/gui/img/siguiente.png"))); // NOI18N
        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        tbPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PedidoId", "Fecha", "Hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbPedidos);

        jLabel3.setFont(new java.awt.Font("Script MT Bold", 0, 22)); // NOI18N
        jLabel3.setText("Pedidos");

        jLabel2.setFont(new java.awt.Font("Script MT Bold", 2, 28)); // NOI18N
        jLabel2.setText("TeleFood  ");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telefood/gui/img/logo 2.png"))); // NOI18N

        cmbDesde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDesdeActionPerformed(evt);
            }
        });

        jLabel4.setText("Mesa/Bar:");

        rbtnSi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rbtnSi.setText("Si");
        rbtnSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnSiActionPerformed(evt);
            }
        });

        rbtnNo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rbtnNo.setSelected(true);
        rbtnNo.setText("No");
        rbtnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnNoActionPerformed(evt);
            }
        });

        lblDividir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDividir.setText("Cantidad de cuentas a dividir:");

        rbtnFactura.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rbtnFactura.setText("Factura");
        rbtnFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnFacturaActionPerformed(evt);
            }
        });

        rbtnConsumidor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rbtnConsumidor.setSelected(true);
        rbtnConsumidor.setText("Consumidor Final");
        rbtnConsumidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnConsumidorActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("¿Desea dividir la cuenta?");

        spnCuentas.setModel(new javax.swing.SpinnerNumberModel(2, 2, null, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(cmbDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(136, 136, 136)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(107, 107, 107)
                                        .addComponent(jLabel2)))
                                .addGap(93, 93, 93))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbtnSi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbtnNo)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblDividir))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(spnCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnFactura)
                            .addComponent(rbtnConsumidor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                        .addComponent(btnSiguiente)))
                .addGap(61, 61, 61))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cmbDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(btnSiguiente)
                        .addGap(49, 49, 49))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbtnFactura)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtnConsumidor))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(lblDividir))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rbtnSi)
                                    .addComponent(rbtnNo)
                                    .addComponent(spnCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void llenar() throws Exception {
        //SELECT  From Pedido ;
        //Array String, String, String

        ArrayList<String> campo = new ArrayList();
        campo.add("DISTINCT DesdeId");
        Registro r = new Registro();
        r.setDatos(campo);
        r.setDatos("Pedido");
        r.setDatos("Despachado=1");
        ArrayList<Registro> registro = pedidos.listarDatos(r);
        campo = new ArrayList();
        for (Registro reg : registro) {
            campo.add(reg.getDatos().get(0).toString());
        }
        
        
        Collections.sort(campo, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return extractInt(o1) - extractInt(o2);
            }

            int extractInt(String s) {
                String num = s.replaceAll("\\D", "");
                // return 0 if no digits found
                return num.isEmpty() ? 0 : Integer.parseInt(num);
            }
        });
        
        for(String c: campo){
            cmbDesde.addItem(c);
        }

    }
    
    
    
    

    public void llenarTabla() throws Exception {

        ArrayList<String> campos = new ArrayList();

        DefaultTableModel tb = (DefaultTableModel) tbPedidos.getModel();
        tb.setRowCount(0);
        for (int i = 0; i < tb.getColumnCount(); i++) {
            campos.add(tb.getColumnName(i));
        }

        Registro reg = new Registro();

        reg.setDatos(campos);
        reg.setDatos("Pedido");
        reg.setDatos("DesdeId='" + cmbDesde.getSelectedItem() + "' AND Despachado ='1'");

        Object o = (Object) reg;

        ArrayList<Registro> registros = pedidos.listarDatos(o);

        int i = 0;
        for (Registro r : registros) {
            int j = 0;

            tb.addRow(new Object[]{""});
            for (Object dat : r.getDatos()) {
                tb.setValueAt(dat, i, j);
                j++;
            }

            i++;
        }
    }


    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        int i = (Integer) spnCuentas.getValue();
        int id=Integer.parseInt(tbPedidos.getValueAt(0, 0).toString());
        System.out.println("id:"+id);
        if (rbtnSi.isSelected()) {
            frmPedidos ventana;
            try {
                ventana = new frmPedidos(i, pedidos,id);
                ventana.setVisible(true);
                dispose();
            } catch (Exception ex) {
                Logger.getLogger(frmControlPedidos.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            frmFactura ventana;
            try {
                if (rbtnConsumidor.isSelected()) {
                    ventana = new frmFactura(1, true, pedidos, id);
                } else {
                    ventana = new frmFactura(1, false, pedidos, id);
                }
                ventana.setVisible(true);
                dispose();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
        
        
        


    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void cmbDesdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDesdeActionPerformed
        try {
            llenarTabla();
        } catch (Exception ex) {
            Logger.getLogger(frmControlPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbDesdeActionPerformed

    private void rbtnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnNoActionPerformed
        rbtnSi.setSelected(false);
        rbtnNo.setSelected(true);
        lblDividir.setVisible(false);
        spnCuentas.setVisible(false);
        rbtnConsumidor.setVisible(true);
        rbtnFactura.setVisible(true);
    }//GEN-LAST:event_rbtnNoActionPerformed

    private void rbtnSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnSiActionPerformed
        rbtnNo.setSelected(false);
        rbtnSi.setSelected(true);
        lblDividir.setVisible(true);
        spnCuentas.setVisible(true);
        rbtnConsumidor.setVisible(false);
        rbtnFactura.setVisible(false);
    }//GEN-LAST:event_rbtnSiActionPerformed

    private void rbtnFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnFacturaActionPerformed
        // TODO add your handling code here:
        rbtnConsumidor.setSelected(false);
        rbtnFactura.setSelected(true);
    }//GEN-LAST:event_rbtnFacturaActionPerformed

    private void rbtnConsumidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnConsumidorActionPerformed
        // TODO add your handling code here:
        rbtnFactura.setSelected(false);
        rbtnConsumidor.setSelected(true);
    }//GEN-LAST:event_rbtnConsumidorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JComboBox<String> cmbDesde;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDividir;
    private javax.swing.JRadioButton rbtnConsumidor;
    private javax.swing.JRadioButton rbtnFactura;
    private javax.swing.JRadioButton rbtnNo;
    private javax.swing.JRadioButton rbtnSi;
    private javax.swing.JSpinner spnCuentas;
    private javax.swing.JTable tbPedidos;
    // End of variables declaration//GEN-END:variables
}
