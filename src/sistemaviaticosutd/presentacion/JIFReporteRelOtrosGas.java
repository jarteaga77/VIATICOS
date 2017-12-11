package sistemaviaticosutd.presentacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import sistemaviaticosutd.conexion.ConexionBD;
import sistemaviaticosutd.reportes.generales.ReporteRelOtrosGas;

/**
 *
 * @author jarteaga
 */
public class JIFReporteRelOtrosGas extends javax.swing.JInternalFrame {

    private ConexionBD conexion;
    private int id_rel_gastos;
    private Date fecha;
    private String factura,usuario;
    private long total_cta, nit;
    private ReporteRelOtrosGas reporte;
    private DefaultTableModel modelo;
    

    //private int idusuario=MDIPrincipal.getSeccion();
    public JIFReporteRelOtrosGas() {
        initComponents();
        
        modelo=new DefaultTableModel();
        
        modelo.addColumn("Consecutivo");
        modelo.addColumn("Fecha Generación");
        modelo.addColumn("Total");
        
        relacion_gastos();
 
        
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_relg = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        date_ini = new com.toedter.calendar.JDateChooser();
        date_fin = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        btn_generar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_visualizar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Reporte Relación Otros Gastos");
        setToolTipText("");

        tabla_relg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_relg);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Al");

        btn_generar.setText("Generar");
        btn_generar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generarActionPerformed(evt);
            }
        });

        btn_cancelar.setText("Cancelar");
        btn_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel1.setText("Entre");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date_ini, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(date_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_generar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cancelar)
                .addContainerGap(118, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_generar)
                        .addComponent(btn_cancelar))
                    .addComponent(date_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(date_ini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        btn_visualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemaviaticosutd/recursos/buscar.png"))); // NOI18N
        btn_visualizar.setToolTipText("Visualizar Relación Gastos");
        btn_visualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_visualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_visualizar)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_visualizar)
                        .addGap(0, 184, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generarActionPerformed
        Date fecha_ini=date_ini.getDate();
        Date fecha_fin=date_fin.getDate();
        
        info_relacionGastos(fecha_ini, fecha_fin);
    }//GEN-LAST:event_btn_generarActionPerformed

    private void btn_visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_visualizarActionPerformed
         if(tabla_relg.isRowSelected(tabla_relg.getSelectedRow()))
            {
                int consecutivo = (Integer) tabla_relg.getValueAt(tabla_relg.getSelectedRow(), 0); 
                reporte=new ReporteRelOtrosGas();
                reporte.ejecutarReporte(consecutivo);
            }
    }//GEN-LAST:event_btn_visualizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_generar;
    private javax.swing.JButton btn_visualizar;
    private com.toedter.calendar.JDateChooser date_fin;
    private com.toedter.calendar.JDateChooser date_ini;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_relg;
    // End of variables declaration//GEN-END:variables

    public void info_relacionGastos(Date fechaIn, Date fechaFin)
    {

        conexion=new ConexionBD();
        Date fecha_sistema=new Date();
        
        ResultSet obj=conexion.executeQuery("INSERT INTO relacion_otros_gastos.rel_otros_gastos(rel_fecha_gen)VALUES('"+fecha_sistema+"')RETURNING rel_consecutivo");
        try {
            while(obj.next())
            {
                id_rel_gastos=obj.getInt("rel_consecutivo");
            
            }
            
            
            /*
             * Consulta para traer los totales de la cuenta y su relacion por tecnico
             * para llenarla la tabla de relacion_gastos.
             * 
             * 
             */
         ResultSet obj1=conexion.executeQuery("SELECT MAX(det.fecha)AS fecha, (to_char(current_date, 'yy') ||''||cta.id_otros_cobros)AS factura,(us.apellido_usuario ||' '|| us.nombre_usuario) AS usuario, SUM(det.tarifa) AS sumatotal, "
                 + "us.cedula_usuario AS nit "
                 + "FROM viaticos.cuenta_otros_cobros cta JOIN viaticos.otros_cobros det ON cta.id_cta_otros=det.id_cta_cobro "
                 + "JOIN usuarios.usuarios us ON us.id_usuario=cta.id_usuario "
                 + "WHERE cta.cta_aprobada=true AND cta.desde='"+fechaIn+"'AND cta.hasta='"+fechaFin+"' "
                 + "GROUP BY cta.id_otros_cobros,us.nombre_usuario,us.apellido_usuario,us.cedula_usuario "
                 + "ORDER BY cta.id_otros_cobros ASC");
         
               /*
                * Captura de información de la consulta
                * 
                */
               while(obj1.next())
               {
                   fecha=obj1.getDate("fecha");
                   factura=obj1.getString("factura");
                   usuario=obj1.getString("usuario");
                   nit=obj1.getLong("nit");
                   total_cta=obj1.getLong("sumatotal");
                   
                   //Llenado de la tabla relacion_gastos
                   conexion.executeUpdateQuery("INSERT INTO relacion_otros_gastos.det_rel_otros_gas(fecha,usuario,total_cta,factura,id_rel_gas,nit_usuario)VALUES('"+fecha+"', '"+usuario+"', "+total_cta+", '"+factura+"', "+id_rel_gastos+", "+nit+")");
               }
                conexion.desconectar();
                reporte=new ReporteRelOtrosGas();
                reporte.ejecutarReporte(id_rel_gastos);
                LimpiarTabla();
                relacion_gastos();

        } catch (SQLException ex) {
            Logger.getLogger(JIFReporteRelOtrosGas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void relacion_gastos()
    {
        
        conexion=new ConexionBD();
        
        ResultSet obj=conexion.executeQuery("SELECT rel.rel_consecutivo, rel.rel_fecha_gen,SUM(det.total_cta) AS total "
                + "FROM relacion_otros_gastos.rel_otros_gastos rel JOIN relacion_otros_gastos.det_rel_otros_gas det ON rel.rel_consecutivo=det.id_rel_gas "
                + "GROUP BY rel.rel_consecutivo");
        try {
            while(obj.next())
            {
                 Object [] datos = new Object[3];
        
     
        for (int i=0;i<3;i++)
        {
            datos[i] =obj.getObject(i+1);
        }

         modelo.addRow(datos);
       
        }
           tabla_relg.setModel(modelo);
           conexion.desconectar();

            
        } catch (SQLException ex) {
            Logger.getLogger(JIFReporteRelOtrosGas.class.getName()).log(Level.SEVERE, null, ex);
        }
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
