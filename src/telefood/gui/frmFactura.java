/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telefood.gui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import telefood.logica.Registro;
import telefood.logica.TeleFood;

/**
 *
 * @author dell
 */
public class frmFactura extends javax.swing.JFrame {

    TeleFood pedidos = null;
    int div;
    int id;
    boolean consumidor = false;
    boolean cliente = false;
    double subTotal, total;
    int iva = 12;

    public frmFactura(int div, boolean consumidor, TeleFood pedidos, int id) throws Exception {
        this.consumidor = consumidor;
        this.div = div;
        this.id = id;
        this.pedidos = pedidos;
        System.out.println("------------------" + div + "/" + consumidor);
        initComponents();

        lblFecha.setText(fechaActual());
        if (consumidor) {
            deshabilitar();
        }
        llenar();
        completarFactura();

    }

    public void completarFactura() {
        DefaultTableModel tb = (DefaultTableModel) tbListaFactura.getModel();
        subTotal = 0.00;
        for (int i = 0; i < tbListaFactura.getRowCount(); i++) {

            int c = Integer.parseInt(tb.getValueAt(i, 0).toString());
            double pu = Double.parseDouble(tb.getValueAt(i, 2).toString());

            subTotal += c * pu;

            tb.setValueAt(c * pu, i, 3);

        }
        double sIva = (double) iva / 100;
        System.out.println(sIva);
        total = subTotal + (subTotal * sIva);

        lblSubTotal.setText("$ " + subTotal);
        lblTotal.setText("$ " + total);
        lblIva.setText("$" + (subTotal * sIva));
    }

    public static String fechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YY");
        return formatoFecha.format(fecha);

    }

    public void deshabilitar() {
        txtCedula.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtNombre.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtNombre.setText("Consumidor Final");
        txtCedula.setText("-----");
    }

    public void llenar() throws Exception {

        DefaultTableModel tb = (DefaultTableModel) tbListaFactura.getModel();

        ArrayList<String> campos = new ArrayList();
        campos.add("count(*)");
        Registro reg = new Registro();
        reg.setDatos(campos);
        reg.setDatos("Factura");
        Object o = (Object) reg;
        ArrayList<Registro> registros = pedidos.listarDatos(o);

        for (Registro r : registros) {
            for (Object dat : r.getDatos()) {
                int cant = Integer.parseInt(dat.toString()) + 1;
                lblNumFactura.setText(String.valueOf(cant));
            }
        }
        campos = new ArrayList();
        campos.add("p.Cantidad");
        campos.add("p1.Nombre");
        campos.add("p.PrecioEnEseMomento");
        reg = new Registro();
        reg.setDatos(campos);
        reg.setDatos("Pedido_Producto p,Producto p1");
        reg.setDatos("p.ProductoId=p1.ProductoId and p.PedidoId=" + id);
        o = (Object) reg;

        registros = pedidos.listarDatos(o);

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListaFactura = new javax.swing.JTable();
        btnAceptar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        lblSubTotal = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblNumFactura = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblIva = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtIva = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telefood/gui/img/logo 2.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Script MT Bold", 2, 28)); // NOI18N
        jLabel2.setText("TeleFood");

        jLabel4.setText("Dir: Av. 24 de Mayo");

        tbListaFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cantidad", "Producto", "P.U.", "Total"
            }
        ));
        jScrollPane1.setViewportView(tbListaFactura);

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telefood/gui/img/aceptar.png"))); // NOI18N
        btnAceptar.setText("Finalizar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jLabel5.setText("Tlf: 0992147064");

        jLabel6.setText("e-mail: TeleFood@gmail.com");

        jLabel3.setText("C.I. / RUC:");

        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });

        jLabel7.setText("Nombre:");

        jLabel8.setText("Direccion:");

        jLabel9.setText("Telefono:");

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        lblSubTotal.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lblSubTotal.setText("$ 0000.00");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Sub-Total:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("I.V.A");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("TOTAL:");

        lblNumFactura.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lblNumFactura.setText("9999");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("Factura N°");

        jLabel18.setText("Fecha:");

        lblIva.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lblIva.setText("$ 0000.00");

        lblTotal.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lblTotal.setText("$ 0000.00");

        lblFecha.setText("DD/MM/YY");

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telefood/gui/img/atras.png"))); // NOI18N
        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(204, 102, 0));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telefood/gui/img/lupa.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtIva.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtIva.setText("12");
        txtIva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIvaActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("%:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                    .addComponent(txtTelefono))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel18)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblFecha)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblNumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(btnAtras)
                                .addGap(26, 26, 26)
                                .addComponent(btnAceptar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel16)
                                        .addGap(3, 3, 3))
                                    .addComponent(jLabel15))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblIva, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(lblNumFactura)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFecha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(btnBuscar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(lblSubTotal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIva)
                            .addComponent(txtIva)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotal)
                            .addComponent(jLabel15))
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAceptar)
                            .addComponent(btnAtras))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void insertarCliente() {
        Registro registro;
        if (!cliente && !txtCedula.equals("-----")) {
            try {
                registro = new Registro();
                registro.setDatos("'" + txtCedula.getText() + "'");
                registro.setDatos(txtNombre.getText());
                if (txtDireccion.getText().equals("")) {
                    registro.setDatos(null);
                } else {
                    registro.setDatos(txtDireccion.getText());

                }
                System.out.println(registro.getDatos());
                pedidos.insertarDatos("Cliente", registro);
                if (!txtTelefono.getText().equals("")) {

                    String telefono[] = txtTelefono.getText().split(",");
                    for (String tlf : telefono) {
                        registro = new Registro();
                        registro.setDatos("'" + txtCedula.getText() + "'");
                        registro.setDatos(tlf);

                        System.out.println(registro.getDatos());
                        pedidos.insertarDatos("Telefono", registro);
                    }

                }

            } catch (Exception ex) {
                Logger.getLogger(frmFactura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void insertarFactura() {
        try {
            Registro registro = new Registro();
            registro.setDatos("DEFAULT");
            registro.setDatos("'" + txtCedula.getText() + "'");
            registro.setDatos(id);
            
            String aux = String.format("%.2f", total).replaceAll(",", ".");
            double aux2 = Double.parseDouble(aux);

            registro.setDatos(aux2);
            registro.setDatos(iva);
            System.out.println(registro.getDatos());
            pedidos.insertarDatos("Factura", registro);

            ArrayList<String> camposEditar = new ArrayList();
            ArrayList<String> camposClave = new ArrayList();

            camposClave.add("PedidoId=" + id);
            camposEditar.add("Despachado=2");

            pedidos.editarDatos("Pedido", camposClave, camposEditar);
        } catch (Exception ex) {
            Logger.getLogger(frmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        div--;

        System.out.println("*************" + div);
        if (div == 0) {
            try {
                insertarCliente();
                insertarFactura();
                frmMenu ventana = new frmMenu(pedidos);
                ventana.setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(frmFactura.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            try {

                frmPedidos ventana = new frmPedidos(div, pedidos, id);
                ventana.setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(frmFactura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed


    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened


    }//GEN-LAST:event_formWindowOpened

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        try {
            if (div > 1) {
                frmPedidos ventana;

                ventana = new frmPedidos(div, pedidos, id);
                ventana.setVisible(true);

            } else {

                frmControlPedidos ventana = new frmControlPedidos(pedidos);
                ventana.setVisible(true);

            }
            dispose();
        } catch (Exception ex) {
            Logger.getLogger(frmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String ci = txtCedula.getText();

        ArrayList<Registro> reg = new ArrayList();
        ArrayList<String> param = new ArrayList();
        param.add("Cliente");
        param.add("ClienteId=" + ci);
        if (!ci.equals("")) {

            try {
                reg = pedidos.listarRegistros((Object) param);
                Registro r = reg.get(0);

                txtNombre.setText(r.getDatos().get(1).toString());
                txtDireccion.setText((String) r.getDatos().get(2));
                cliente = true;

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "No esta registrado");
                System.out.println("No esta registrado");
            }
        }
        reg = new ArrayList();
        param = new ArrayList();
        param.add("Telefono");
        param.add("ClienteId=" + ci);
        String tlf = "";
        if (!ci.equals("")) {
            try {
                reg = pedidos.listarRegistros((Object) param);
                int nt = reg.size();
                for (Registro r : reg) {
                    nt--;
                    tlf += r.getDatos().get(1);
                    if (nt > 0) {
                        tlf += ", ";
                    }
                }
                txtTelefono.setText(tlf);

            } catch (Exception e) {
                System.out.println("No esta registrado");
            }
        }


    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtIvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIvaActionPerformed
        iva = Integer.parseInt(txtIva.getText());
        total = subTotal * (1 + iva / 100);
        lblTotal.setText("$ " + total);
        lblIva.setText("$" + subTotal * (iva / 100));
    }//GEN-LAST:event_txtIvaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblIva;
    private javax.swing.JLabel lblNumFactura;
    private javax.swing.JLabel lblSubTotal;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tbListaFactura;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
