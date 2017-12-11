package sistemaviaticosutd.presentacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistemaviaticosutd.conexion.ConexionBD;
import sistemaviaticosutd.reportes.tecnicos.ReporteTecnicos_1_2;

/**
 *
 * @author jarteaga
 */
public class JIFAprobacionCtaCobro extends javax.swing.JInternalFrame {
    
    
    private ConexionBD conexion=new ConexionBD();
    private DefaultTableModel modelo;
    private int id_manejo, idacta;
   // private ReporteTecnicos_1 reporte;
    private ReporteTecnicos_1_2  reporte_2;
    private int id_usuario=MDIPrincipal.getSeccion();;
    
    public JIFAprobacionCtaCobro() {
        initComponents();
        
       
        
        modelo=new DefaultTableModel();
        
        modelo.addColumn("ID");
        modelo.addColumn("Cta. Num.");
        modelo.addColumn("Fecha");
        modelo.addColumn("Cédula");
        modelo.addColumn("Técnico");
        modelo.addColumn("Total");
        
        detalleTabla();
        

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_cta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_idtec_ = new javax.swing.JTextField();
        txt_tec_ = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_valor = new javax.swing.JTextField();
        jcb_aprobar = new javax.swing.JCheckBox();
        btn_guardar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_apro = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btn_visualizar = new javax.swing.JButton();
        btn_mod = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Aprobación Cuenta de Cobro");
        setToolTipText("");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Aprobación Cta Cobro"));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Cta N°");

        txt_cta.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Cédula /Nit");

        txt_idtec_.setEditable(false);

        txt_tec_.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Valor $");

        txt_valor.setEditable(false);

        jcb_aprobar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jcb_aprobar.setText("* Aprobar");

        btn_guardar.setText("Aceptar");
        btn_guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_guardar.setEnabled(false);
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_cancelar.setText("Cancelar");
        btn_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Técnico");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(236, 19, 19));
        jLabel1.setText("* Campos Obligatorios");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cta, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_idtec_, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_tec_, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_cancelar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcb_aprobar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txt_idtec_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tec_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcb_aprobar)
                    .addComponent(jLabel4)
                    .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardar)
                    .addComponent(btn_cancelar)
                    .addComponent(jLabel1)))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabla_apro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_apro);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_visualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemaviaticosutd/recursos/buscar.png"))); // NOI18N
        btn_visualizar.setToolTipText("Visualizar Cta Viaticos");
        btn_visualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_visualizarActionPerformed(evt);
            }
        });

        btn_mod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemaviaticosutd/recursos/mod_detalle.png"))); // NOI18N
        btn_mod.setToolTipText("Aprobar Cta Viaticos");
        btn_mod.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_visualizar)
            .addComponent(btn_mod)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(btn_visualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_mod)
                .addGap(0, 36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_visualizarActionPerformed
       // reporte=new ReporteTecnicos_1();
        reporte_2=new ReporteTecnicos_1_2();
        
        id_manejo = (Integer) tabla_apro.getValueAt(tabla_apro.getSelectedRow(), 0);    
        idacta=(Integer) tabla_apro.getValueAt(tabla_apro.getSelectedRow(), 1);

      //  reporte.ejecutarReporte(idacta, id_manejo);
        reporte_2.ejecutarReporte(idacta, id_manejo);
    }//GEN-LAST:event_btn_visualizarActionPerformed

    private void btn_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modActionPerformed

      long cedula;
      long valor;
      String tecnico;
      
           if(tabla_apro.isRowSelected(tabla_apro.getSelectedRow()))
            {
                id_manejo = (Integer) tabla_apro.getValueAt(tabla_apro.getSelectedRow(), 0);    
                idacta=(Integer) tabla_apro.getValueAt(tabla_apro.getSelectedRow(), 1);
                txt_cta.setText(String.valueOf(idacta));
                cedula=(long) tabla_apro.getValueAt(tabla_apro.getSelectedRow(), 3);
                txt_idtec_.setText(String.valueOf(cedula));
                tecnico=(String) tabla_apro.getValueAt(tabla_apro.getSelectedRow(), 4);
                txt_tec_.setText(tecnico);
                valor=(long) tabla_apro.getValueAt(tabla_apro.getSelectedRow(), 5);
                txt_valor.setText(String.valueOf(valor));
                
                btn_guardar.setEnabled(true);
            }
    }//GEN-LAST:event_btn_modActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
       boolean aprobado;
        
        if(jcb_aprobar.isSelected())
        {
            aprobado=true;
            conexion.executeUpdateQuery("UPDATE viaticos.cuenta_cobro SET cta_aprobada='"+aprobado+"', persona_aprueba="+id_usuario+" WHERE id_manejo_cta="+id_manejo+" AND id_cuenta_cobro="+idacta+" ");
            conexion.desconectar();
            txt_cta.setText("");
            txt_idtec_.setText("");
            txt_tec_.setText("");
            txt_valor.setText("");
            btn_guardar.setEnabled(false);
            jcb_aprobar.setSelected(false);

      
            JOptionPane.showMessageDialog(null, "Se aprobó la Cta de cobro " + idacta);
            LimpiarTabla();
            detalleTabla();
            
            id_manejo=0;
            idacta=0;
            
        }else 
        {
            JOptionPane.showMessageDialog(null, "No fue aprobada la Cta de cobro " + idacta);
        }
        
    }//GEN-LAST:event_btn_guardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_mod;
    private javax.swing.JButton btn_visualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox jcb_aprobar;
    private javax.swing.JTable tabla_apro;
    private javax.swing.JTextField txt_cta;
    private javax.swing.JTextField txt_idtec_;
    private javax.swing.JTextField txt_tec_;
    private javax.swing.JTextField txt_valor;
    // End of variables declaration//GEN-END:variables

    public void detalleTabla()
    {
        /*
         * Consulta que me permite unir (UNION) varios selects para traer informacion y
         * realizar operaciones a traves de dos campos de tabla diferentes.
         */
        ResultSet obj=conexion.executeQuery("SELECT cta.id_manejo_cta AS cuenta, cta.id_cuenta_cobro AS consecutivo,cta.fecha_sistema AS fecha,"
                + "us.cedula_usuario AS cedula,(us.nombre_usuario ||' '|| us.apellido_usuario)AS nombre, "
                + "SUM(des.tarifa_despla)AS total "
                + "FROM viaticos.cuenta_cobro cta JOIN viaticos.detalle_cuenta_cobro det ON cta.id_manejo_cta=det.id_cuenta_cobro "
                + "JOIN desplazamientos.desplazamiento des ON des.id_desplazamiento=det.id_desplazamiento "
                + "JOIN usuarios.usuarios us ON us.id_usuario=cta.id_usuario "
                + "WHERE cta.cta_aprobada=false "
                + "GROUP BY consecutivo,cuenta,us.cedula_usuario,us.nombre_usuario,us.apellido_usuario "
                + "ORDER BY us.nombre_usuario ASC");
        try {
            while (obj.next()) 
              {
              
              Object [] datos = new Object[6];
              
           
              for (int i=0;i<6;i++)
              {
                  datos[i] =obj.getObject(i+1);
              }

               modelo.addRow(datos);
        
              }
        } catch (SQLException ex) {
            Logger.getLogger(JIFAprobacionCtaCobro.class.getName()).log(Level.SEVERE, null, ex);
        }

           tabla_apro.setModel(modelo);
           
           conexion.desconectar();

    }

      public void LimpiarTabla()
    {
  
        for(int i=modelo.getRowCount()-1;i>=0;i--)
        {
            modelo.removeRow(i);
            
        }
    }   
    
}
