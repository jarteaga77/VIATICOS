
package sistemaviaticosutd.presentacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistemaviaticosutd.conexion.ConexionBD;
import sistemaviaticosutd.viaticos.DaoCruceCtas;
import sistemaviaticosutd.viaticos.DaoDetCruceCtas;
import sistemaviaticosutd.viaticos.DaoPago;
import sistemaviaticosutd.viaticos.Detalle_Cruce_Ctas;
import sistemaviaticosutd.viaticos.Pago;
import sistemaviaticosutd.viaticos.cruce_ctas;

/**
 *
 * @author jarteaga
 */
public class JIFCruceCtas extends javax.swing.JInternalFrame {

    private ConexionBD conexion;
    private int id_us=0;
    private int id_cruce=0;
    private Detalle_Cruce_Ctas detalle;
    private DaoDetCruceCtas daoDetalle;
    private Pago pago;
    private DaoPago daopago;
    private cruce_ctas cruce;
    private DaoCruceCtas daocruce;
    private int id_anticipo=0;
    private String fact;
    private DefaultTableModel modelo;
    private DefaultTableModel modelo2;
    private int sum_total;
    SimpleDateFormat formateador ;
    private int total_causado,total_anticipo,saldo;
    
   DecimalFormatSymbols dfs = new DecimalFormatSymbols();

    private Date fecha;
    
  
    public JIFCruceCtas() {
        initComponents();
        
        modelo=new DefaultTableModel();
        modelo2=new DefaultTableModel();
        conexion=new ConexionBD();
        
        ResultSet obj=conexion.executeQuery("SELECT nombre_usuario FROM usuarios.usuarios WHERE activo=true ORDER BY nombre_usuario ASC");
        
          try {
             while(obj.next())
            {
                cb_usuario.addItem(obj.getObject("nombre_usuario"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(JIFCruceCtas.class.getName()).log(Level.SEVERE, null, ex);
        
        }
         genId();
         
         
         modelo.addColumn("ID");
         modelo.addColumn("Cta. Relacionada");
         modelo.addColumn("Vlor. Cta.");
         
         modelo2.addColumn("ID");
         modelo2.addColumn("Total Causado");
         modelo2.addColumn("Anticipo");
         modelo2.addColumn("Saldo");
         
         
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cb_ctas_cruzar = new javax.swing.JComboBox();
        cb_usuario = new javax.swing.JComboBox();
        btn_cruzar = new javax.swing.JButton();
        cb_anticipo = new javax.swing.JComboBox();
        txt_idcruce = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_total_cta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_consultar = new javax.swing.JButton();
        btn_fijar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_vlor_anti = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_cruces = new javax.swing.JTable();
        label_total = new javax.swing.JLabel();
        btn_eliminar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_pagos = new javax.swing.JTable();
        btn_pago = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        label_saldo = new javax.swing.JLabel();
        label_causado = new javax.swing.JLabel();
        label_anticipo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Registro Cruce Cuentas");

        cb_ctas_cruzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ctas_cruzarActionPerformed(evt);
            }
        });

        cb_usuario.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        btn_cruzar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_cruzar.setText("Cruzar Cuenta");
        btn_cruzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cruzarActionPerformed(evt);
            }
        });

        cb_anticipo.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        cb_anticipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_anticipoActionPerformed(evt);
            }
        });

        txt_idcruce.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Usuario");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("ID cruce Ctas");

        txt_total_cta.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Valor Cuenta $");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Valor Anticipo $");

        btn_consultar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_consultar.setText("Consultar");
        btn_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_consultarActionPerformed(evt);
            }
        });

        btn_fijar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_fijar.setText("Fijar Anticipo");
        btn_fijar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fijarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("N° Anticipo:");

        txt_vlor_anti.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Ctas x cruzar");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Fecha");

        txt_fecha.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_idcruce)
                    .addComponent(cb_anticipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_ctas_cruzar, 0, 86, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_vlor_anti, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(3, 3, 3)
                        .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_total_cta, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_consultar)
                    .addComponent(btn_fijar)
                    .addComponent(btn_cruzar))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_idcruce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cb_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_consultar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cb_anticipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txt_vlor_anti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_fijar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(cb_ctas_cruzar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(txt_total_cta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_cruzar)
                        .addComponent(jLabel7)))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cruce de Cuentas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        tabla_cruces.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        tabla_cruces.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_cruces);

        label_total.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        label_total.setText("Total Ctas. $");

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemaviaticosutd/recursos/delete.png"))); // NOI18N
        btn_eliminar.setToolTipText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_eliminar)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_total)
                .addGap(153, 153, 153))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_eliminar)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_total))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pago", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        tabla_pagos.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        tabla_pagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tabla_pagos);

        btn_pago.setText("Realizar Pago");
        btn_pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pagoActionPerformed(evt);
            }
        });

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_saldo.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        label_saldo.setText("Total Saldo $");

        label_causado.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        label_causado.setText("Total Causado $");

        label_anticipo.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        label_anticipo.setText("Total Anticipo $");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_pago)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_causado, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_anticipo, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btn_pago)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(label_anticipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label_causado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_saldo))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_consultarActionPerformed
   
        cb_anticipo.removeAllItems();
 
        String nombre_usuario=cb_usuario.getSelectedItem().toString();
         
        ResultSet obj=conexion.executeQuery("SELECT id_usuario FROM usuarios.usuarios WHERE nombre_usuario='"+nombre_usuario+"'");
        try {
            while(obj.next())
                   {
                       id_us=obj.getInt("id_usuario");
                   }
        } catch (SQLException ex) {
            Logger.getLogger(JIFCruceCtas.class.getName()).log(Level.SEVERE, null, ex);
            
        }  
        
           ResultSet obj1=conexion.executeQuery("SELECT id_anticipo FROM anticipos_cruce_ctas.anticipo WHERE id_usuario="+id_us+" AND anticipo_cruzado=false AND anticipo_saldado=false");
           
           try {
             while(obj1.next())
            {
                cb_anticipo.addItem(obj1.getInt("id_anticipo"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(JIFCruceCtas.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    
    }//GEN-LAST:event_btn_consultarActionPerformed

    private void cb_anticipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_anticipoActionPerformed
          if(cb_anticipo.getSelectedItem()!=null)
            {
                int vlor_anticipo;
             
                
               // ConexionBD conexion=new ConexionBD();
            try {
                 id_anticipo=(int) cb_anticipo.getSelectedItem();
                ResultSet obj=conexion.executeQuery("SELECT vlor_anticipo FROM anticipos_cruce_ctas.anticipo WHERE id_anticipo="+id_anticipo+"");
                
                while(obj.next())
                {
                 vlor_anticipo=obj.getInt("vlor_anticipo");
                 txt_vlor_anti.setText(String.valueOf(vlor_anticipo));
                }
                conexion.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(JIFCtaCobro.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
    }//GEN-LAST:event_cb_anticipoActionPerformed

    private void btn_fijarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fijarActionPerformed
       cb_anticipo.setEnabled(false);
       cb_usuario.setEnabled(false);
       btn_consultar.setEnabled(false);
       
//       String nombre_usuario=cb_usuario.getSelectedItem().toString();
//         
//        ResultSet obj1=conexion.executeQuery("SELECT id_usuario FROM usuarios.usuarios WHERE nombre_usuario='"+nombre_usuario+"'");
//        try {
//            while(obj1.next())
//                   {
//                       id_us=obj1.getInt("id_usuario");
//                   }
//        } catch (SQLException ex) {
//            Logger.getLogger(JIFCruceCtas.class.getName()).log(Level.SEVERE, null, ex);
//            
//        }  

       
       ResultSet obj=conexion.executeQuery("SELECT rg.factura as factura FROM relacion_gastos.detalle_relacion_gastos rg, usuarios.usuarios us "
               + "WHERE us.cedula_usuario=rg.nit_usuario AND us.id_usuario="+id_us+" AND cta_cruzada=false");
       
       
       try {
             while(obj.next())
            {
                cb_ctas_cruzar.addItem(obj.getString("factura"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(JIFCruceCtas.class.getName()).log(Level.SEVERE, null, ex);
        
        }
  
    }//GEN-LAST:event_btn_fijarActionPerformed

    private void cb_ctas_cruzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ctas_cruzarActionPerformed
         if(cb_ctas_cruzar.getSelectedItem()!=null)
            {
                int vlor_cta;
                
  
            try {
                 fact=cb_ctas_cruzar.getSelectedItem().toString();
                ResultSet obj=conexion.executeQuery("SELECT total_cta,fecha FROM relacion_gastos.detalle_relacion_gastos WHERE factura='"+fact+"'");
                
                while(obj.next())
                {
                 vlor_cta=obj.getInt("total_cta");
                 fecha=obj.getDate("fecha");
                 
                 txt_total_cta.setText(String.valueOf(vlor_cta));
                 txt_fecha.setText(String.valueOf(fecha));
                }
                conexion.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(JIFCtaCobro.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
    }//GEN-LAST:event_cb_ctas_cruzarActionPerformed

    private void btn_cruzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cruzarActionPerformed
        cruce=new cruce_ctas();
        daocruce=new DaoCruceCtas();
        detalle=new Detalle_Cruce_Ctas();
        daoDetalle=new DaoDetCruceCtas();
        pago=new Pago();
        daopago=new DaoPago();
        //formateador = new SimpleDateFormat("yyyy/MM/dd");
        int id_pago=0;
        
        ResultSet obj=conexion.executeQuery("SELECT id_cruce_ctas FROM anticipos_cruce_ctas.cruce_ctas WHERE  id_cruce_ctas="+txt_idcruce.getText()+" AND id_usuario="+id_us+"");
        try {
            if(obj.next()==false)
            {
                cruce.setId_anticipo(id_anticipo);
                cruce.setId_usuario(id_us);
                cruce.setFecha(new Date());
                
                daocruce.regCruceCtas(cruce);
                
                id_cruce=DaoCruceCtas.getIdcruce();
                
                detalle.setId_cruce_cta(id_cruce);
                detalle.setCta_relacionada(fact);
                detalle.setVlor_cta(Integer.parseInt(txt_total_cta.getText()));
        
                detalle.setFecha(fecha);
    
                daoDetalle.regDetalleCruce(detalle);
                
                id_pago=DaoPago.getId_pago();
                
                detalleCruce();
                sumatoriaTotales();
                actualizarCtas_cruzar();
                conexion.executeUpdateQuery("UPDATE relacion_gastos.detalle_relacion_gastos SET cta_cruzada=true WHERE factura='"+detalle.getCta_relacionada()+"'");
                conexion.executeQuery("UPDATE anticipos_cruce_ctas.anticipo SET anticipo_cruzado=true WHERE id_anticipo="+id_anticipo+"");
                conexion.desconectar();
//                ResultSet obj1=conexion.executeQuery("SELECT id_pago FROM anticipos_cruce_ctas.pagos WEHRE id_pago="+id_pago+" ");
//                
//                if(obj1.next()==false)
//                {
//                    pago.setId_cruce_ctas(id_cruce);
//                    
//                }
            }
            else
            {
                 id_cruce=DaoCruceCtas.getIdcruce();
                
                detalle.setId_cruce_cta(id_cruce);
                detalle.setCta_relacionada(fact);
                detalle.setVlor_cta(Integer.parseInt(txt_total_cta.getText()));

                detalle.setFecha(fecha);
          
                daoDetalle.regDetalleCruce(detalle);
                
                id_pago=DaoPago.getId_pago();
                
                conexion.executeUpdateQuery("UPDATE relacion_gastos.detalle_relacion_gastos SET cta_cruzada=true WHERE factura='"+detalle.getCta_relacionada()+"'");
                conexion.executeQuery("UPDATE anticipos_cruce_ctas.anticipo SET anticipo_cruzado=true WHERE id_anticipo="+id_anticipo+"");
                conexion.desconectar();
                actualizarCtas_cruzar();
               
                
                LimpiarTabla();
                detalleCruce();
                sumatoriaTotales();
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFCruceCtas.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }//GEN-LAST:event_btn_cruzarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        elminarFila();
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_pagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pagoActionPerformed
       ResultSet obj=conexion.executeQuery("SELECT SUM(vlor_total_cta) AS causado FROM anticipos_cruce_ctas.detalle_cruce_ctas WHERE id_cruce_ctas="+txt_idcruce.getText()+"");
       
        boolean a_favor,en_contra; 
       
       
       try {
            while(obj.next())
            {
                total_causado=obj.getInt("causado");
            }

            total_anticipo=Integer.parseInt(txt_vlor_anti.getText());
            saldo=total_causado - total_anticipo;
            
            conexion.executeUpdateQuery("INSERT INTO anticipos_cruce_ctas.pagos(total_causado,vlor_anticipo,saldo,id_cruce_ctas)VALUES("+total_causado+", "+total_anticipo+", "+saldo+", "+txt_idcruce.getText()+")");
            conexion.desconectar();
            
            detalle_pago();
            
            
             java.text.DecimalFormat formato1 = new java.text.DecimalFormat("'Total Causado: $' #,##0.00",dfs);
             java.text.DecimalFormat formato2 = new java.text.DecimalFormat("'Total Anticipo: $' #,##0.00",dfs);
             java.text.DecimalFormat formato3 = new java.text.DecimalFormat("'Total Saldo: $' #,##0.00",dfs);
            
             dfs.setPerMill('.');
          
            label_causado.setText(formato1.format(total_causado));
            label_anticipo.setText(formato2.format(total_anticipo));
            label_saldo.setText(formato3.format(saldo));
            
            btn_cruzar.setEnabled(false);
            btn_pago.setEnabled(false);
            
            
            if(saldo==0)
            {
                JOptionPane.showMessageDialog(null, "No tiene saldo a favor o encontra,esta al día con los pagos.");
                
            }else
                
                if(saldo<0)
                {
                    a_favor=false;
                    en_contra=true;
                    
                    conexion.executeUpdateQuery("INSERT INTO anticipos_cruce_ctas.saldo_ctas(vlor_saldo,a_favor,en_contra,id_usuario,id_cruce_cta)VALUES("+saldo+","+a_favor+", "+en_contra+","+id_us+", "+txt_idcruce.getText()+")");
                    JOptionPane.showMessageDialog(null, "Tiene saldo encontra por $ "+saldo);

                    
                }else 
                    if(saldo>0 )
                    {
                        a_favor=true;
                        en_contra=false;
                    
                    conexion.executeUpdateQuery("INSERT INTO anticipos_cruce_ctas.saldo_ctas(vlor_saldo,a_favor,en_contra,id_usuario,id_cruce_cta)VALUES("+saldo+","+a_favor+", "+en_contra+","+id_us+", "+txt_idcruce.getText()+")");
                    JOptionPane.showMessageDialog(null, "Tiene saldo a favor por $ "+saldo);
                    }

        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_pagoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_consultar;
    private javax.swing.JButton btn_cruzar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_fijar;
    private javax.swing.JButton btn_pago;
    private javax.swing.JComboBox cb_anticipo;
    private javax.swing.JComboBox cb_ctas_cruzar;
    private javax.swing.JComboBox cb_usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel label_anticipo;
    private javax.swing.JLabel label_causado;
    private javax.swing.JLabel label_saldo;
    private javax.swing.JLabel label_total;
    private javax.swing.JTable tabla_cruces;
    private javax.swing.JTable tabla_pagos;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_idcruce;
    private javax.swing.JTextField txt_total_cta;
    private javax.swing.JTextField txt_vlor_anti;
    // End of variables declaration//GEN-END:variables
    public void elminarFila()
    {

        //Verifica que la fila de la tabla esta seleccionada
        if(tabla_cruces.isRowSelected(tabla_cruces.getSelectedRow()))
        {
           int row = tabla_cruces.getSelectedRow();

        for(int i = 0; i < modelo.getRowCount(); i++)
        {
           conexion.executeUpdateQuery("DELETE FROM anticipos_cruce_ctas.detalle_cruce_ctas WHERE id_det_ctas="+modelo.getValueAt(row,0)+" ");

        }
         int numRows = tabla_cruces.getSelectedRows().length;
         
         for(int i = 0; i < numRows ; i++ )
         {
            modelo.removeRow(row);
         } 
          sumatoriaTotales();
        }         
 
     else
     {
      JOptionPane.showMessageDialog(this, "Debe seleccionar un registro de la tabla para eliminarlo!."
         ,"Aviso", JOptionPane.WARNING_MESSAGE);
     }
          conexion.desconectar(); 
          LimpiarTabla();
          detalleCruce();
    }

    
      public void LimpiarTabla()
    {
  
        for(int i=modelo.getRowCount()-1;i>=0;i--)
        {
            modelo.removeRow(i);
        }
    }

    public void detalleCruce()
    {
        
        ResultSet obj=conexion.executeQuery("SELECT id_det_ctas,cta_relacionada,vlor_total_cta FROM anticipos_cruce_ctas.detalle_cruce_ctas WHERE id_cruce_ctas="+id_cruce+"");
        try {
            while (obj.next()) 
           {
           Object [] datos = new Object[3];
           
        
           for (int i=0;i<3;i++)
           {
               datos[i] =obj.getObject(i+1);
           }

            modelo.addRow(datos);
       
           }
        } catch (SQLException ex) {
            Logger.getLogger(JIFCruceCtas.class.getName()).log(Level.SEVERE, null, ex);
        }
           tabla_cruces.setModel(modelo);

    }
        public void sumatoriaTotales()
    {
        
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setPerMill('.');
        java.text.DecimalFormat formato = new java.text.DecimalFormat("'Total Causado: $' #,##0.00",dfs);
        
        
        sum_total = 0;
        int totalRow= tabla_cruces.getRowCount();
        totalRow-=1; 
        for(int i=0;i<=(totalRow);i++)
        {
             int sumatoria= Integer.parseInt(String.valueOf(tabla_cruces.getValueAt(i,2)));
             sum_total+=sumatoria;
   
          label_total.setText(formato.format(sum_total));
          
           }
    }
 public void genId()
{
     ResultSet obj=conexion.executeQuery("SELECT COALESCE (MAX (id_cruce_ctas), 0)+1 AS id FROM anticipos_cruce_ctas.cruce_ctas ");
        
        try {
             while(obj.next())
            {
                txt_idcruce.setText(String.valueOf(obj.getInt("id")));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(JIFRegAnticipo.class.getName()).log(Level.SEVERE, null, ex);
        
        }
}
 
 public void detalle_pago()
 {
     ResultSet obj=conexion.executeQuery("SELECT id_pago,total_causado,vlor_anticipo,saldo FROM anticipos_cruce_ctas.pagos WHERE id_cruce_ctas="+id_cruce+"");
        try {
            while (obj.next()) 
           {
           Object [] datos = new Object[4];
           
        
           for (int i=0;i<4;i++)
           {
               datos[i] =obj.getObject(i+1);
           }

            modelo2.addRow(datos);
       
           }
        } catch (SQLException ex) {
            Logger.getLogger(JIFCruceCtas.class.getName()).log(Level.SEVERE, null, ex);
        }
           tabla_pagos.setModel(modelo2);
 }
 
 
 public void actualizarCtas_cruzar()
 {
     cb_ctas_cruzar.removeAllItems();
     ResultSet obj=conexion.executeQuery("SELECT rg.factura as factura FROM relacion_gastos.detalle_relacion_gastos rg, usuarios.usuarios us "
               + "WHERE us.cedula_usuario=rg.nit_usuario AND us.id_usuario="+id_us+" AND cta_cruzada=false");
       
       
       try {
             while(obj.next())
            {
                cb_ctas_cruzar.addItem(obj.getString("factura"));
            }
             conexion.desconectar();
            
        } catch (SQLException ex) {
            Logger.getLogger(JIFCruceCtas.class.getName()).log(Level.SEVERE, null, ex);
        
        }
 }
}

