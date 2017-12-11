
package sistemaviaticosutd.presentacion;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import sistemaviaticosutd.conexion.ConexionBD;
import sistemaviaticosutd.reportes.tecnicos.ReporteOtrosCobros;
import sistemaviaticosutd.reportes.tecnicos.ReporteOtrosCobros1;

/**
 *
 * @author jarteaga
 */
public class JIFImprimirCtaOtrosGastos extends javax.swing.JInternalFrame {

    
    private DefaultTableModel modelo;
    private ConexionBD conexion;
    private int id_usuario= MDIPrincipal.getSeccion();
   // private ReporteTecnicos_1 reporte;
    private ReporteOtrosCobros reporte;
    //private ReporteTecnicos_2 reporte_1;
    private ReporteOtrosCobros1 reporte_2;
    
    public JIFImprimirCtaOtrosGastos() {
        initComponents();
        
        modelo=new DefaultTableModel();
        
        modelo.addColumn("ID");
        modelo.addColumn("Consecutivo");
        modelo.addColumn("Fecha Registro");
        modelo.addColumn("Total");
        
        detalle_tabla();

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_conse = new javax.swing.JTextField();
        btn_imprimir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_detalle = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btn_visu = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Visor Cta. Viaticos");
        setToolTipText("");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Consecutivo");

        txt_conse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_conseKeyPressed(evt);
            }
        });

        btn_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemaviaticosutd/recursos/impresora.png"))); // NOI18N
        btn_imprimir.setToolTipText("Imprimir");
        btn_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_conse, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_imprimir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_conse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(5, 5, 5))
                    .addComponent(btn_imprimir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabla_detalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_detalle);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_visu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemaviaticosutd/recursos/buscar.png"))); // NOI18N
        btn_visu.setToolTipText("Visualizar Cta. Viaticos");
        btn_visu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_visu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_visuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btn_visu)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btn_visu)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_visuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_visuActionPerformed
       int id_manejo,idacta;
        
       // reporte=new ReporteTecnicos_1();
        reporte=new ReporteOtrosCobros();
        
        
        id_manejo = (Integer) tabla_detalle.getValueAt(tabla_detalle.getSelectedRow(), 0);    
        idacta=(Integer) tabla_detalle.getValueAt(tabla_detalle.getSelectedRow(), 1);

       // reporte.ejecutarReporte(idacta, id_manejo);
        reporte.ejecutarReporte(idacta, id_manejo);
    }//GEN-LAST:event_btn_visuActionPerformed

    private void btn_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimirActionPerformed
        int consecutivo = 0;

        consecutivo=Integer.parseInt(txt_conse.getText());
        
        
        //reporte_1=new ReporteTecnicos_2();
        reporte_2=new ReporteOtrosCobros1();
        
       // reporte_1.ejecutarReporte(consecutivo, id_usuario);
        reporte_2.ejecutarReporte(consecutivo, id_usuario);
    }//GEN-LAST:event_btn_imprimirActionPerformed

    private void txt_conseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_conseKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
             int consecutivo = 0;

            consecutivo=Integer.parseInt(txt_conse.getText());
        
        
             //reporte_1=new ReporteTecnicos_2();
            reporte_2=new ReporteOtrosCobros1();
        
            // reporte_1.ejecutarReporte(consecutivo, id_usuario);
            reporte_2.ejecutarReporte(consecutivo, id_usuario);
        }
    }//GEN-LAST:event_txt_conseKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JButton btn_visu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_detalle;
    private javax.swing.JTextField txt_conse;
    // End of variables declaration//GEN-END:variables

    public void detalle_tabla()
    {
        
        conexion=new ConexionBD();
          ResultSet obj=conexion.executeQuery("SELECT cta.id_cta_otros AS control,cta.id_otros_cobros AS consecutivo,cta.fecha_sistema, SUM(det.tarifa)AS total "
                  + "FROM viaticos.cuenta_otros_cobros cta JOIN viaticos.otros_cobros det ON det.id_cta_cobro=cta.id_cta_otros "
                  + "WHERE cta.id_usuario="+id_usuario+" "
                  + "GROUP BY control, consecutivo");
        try {
          while (obj.next()) 
          {
          
          Object [] datos = new Object[4];
       
          for (int i=0;i<4;i++)
          {
              datos[i] =obj.getObject(i+1);
          }

           modelo.addRow(datos);
         
          }
        } catch (SQLException ex) {
            Logger.getLogger(JIFImprimirCtaOtrosGastos.class.getName()).log(Level.SEVERE, null, ex);
        }
           tabla_detalle.setModel(modelo);
           conexion.desconectar();
    }
    

}
