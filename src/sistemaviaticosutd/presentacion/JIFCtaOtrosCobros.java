
package sistemaviaticosutd.presentacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistemaviaticosutd.conexion.ConexionBD;
import sistemaviaticosutd.reportes.tecnicos.ReporteOtrosCobros;
import sistemaviaticosutd.viaticos.Dao_Det_Otros_Cobros;
import sistemaviaticosutd.viaticos.Dao_OtrosCobros;
import sistemaviaticosutd.viaticos.Detalle_Otros_Cobros;
import sistemaviaticosutd.viaticos.OtrosCobros;

/**
 *
 * @author jarteaga
 */
public class JIFCtaOtrosCobros extends javax.swing.JInternalFrame {
    
    
   private int consecutivo = 0;
   ConexionBD conexion=new ConexionBD(); //Objeto de tipo ConexionBD para conexion base de datos
   private int id_usuario=MDIPrincipal.getSeccion();/// Variable de inicio de seccion
   private DefaultTableModel modelo;// Modelo de tabla 1    
 //  private DefaultTableModel modelo2;// Modelo de tablas 2
   private int id;

   private OtrosCobros otros;
   private Dao_OtrosCobros daoOtros;
   private Detalle_Otros_Cobros detalle;
   private Dao_Det_Otros_Cobros daodetalle;
   
   private static Date fecha_ini;
   private static Date fecha_fin;
   
   
   //private Viaticos viatico; // Objeto de Tipo Viaticos
  // private Detalle_Viaticos detalle;// Objeto de tipo Detalle_Viaticos
  // private DaoViaticos daovia;// DaoViaticos Objeto para transación
  // private DaoDetalle_Viaticos daodetalle;// DaoDetalle_Viaticos Objeto para transación
  // private ReporteTecnicos_1 reporte; // Objeto tipo ReporteTecnicos_1
   private ReporteOtrosCobros reporte; // Objeto tipo ReporteTecnicos_1_2
   

   

    public JIFCtaOtrosCobros() {
        initComponents();
        
        modelo=new DefaultTableModel();
        //modelo2=new DefaultTableModel();
        
     //Consulta para traer el consecutivo que el sistema asigna a la cuenta.
        ResultSet obj=conexion.executeQuery("SELECT (control_otros_cobros +1) AS consecutivo FROM usuarios.usuarios WHERE id_usuario="+id_usuario+" ");
        try {
            if(obj.next()==true)
            {
                consecutivo=obj.getInt("consecutivo");
                txt_idcta.setText(String.valueOf(consecutivo));
                conexion.desconectar();
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFCtaOtrosCobros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Modelo Inicial de las tablas
        
//        //Tabla 1 (Desplazamientos)
        modelo.addColumn("ID");
        modelo.addColumn("Fecha");
        modelo.addColumn("Concepto");
        modelo.addColumn("Novedad");
        modelo.addColumn("Tarifa");
        
        //Tabla 2 (Otros cobros)
//        modelo2.addColumn("ID");
//        modelo2.addColumn("Fecha");
//        modelo2.addColumn("Conceopto");
//        modelo2.addColumn("Novedad");
//        modelo2.addColumn("Tarifa");
   
    }
    
      public static Date getFecha_ini() {
        return fecha_ini;
    }

    public static void setFecha_ini(Date fecha_ini) {
        JIFCtaOtrosCobros.fecha_ini = fecha_ini;
    }

    public static Date getFecha_fin() {
        return fecha_fin;
    }

    public static void setFecha_fin(Date fecha_fin) {
        JIFCtaOtrosCobros.fecha_fin = fecha_fin;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        JD_Otros_Cobros = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        jdc_fecha1 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        txt_concepto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txta_novedad1 = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btn_aceptar1 = new javax.swing.JButton();
        btn_cancelar1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txt_tarifa1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_idcta = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_despla = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btn_agregar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        label_total = new javax.swing.JLabel();
        btn_terminar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable1);

        JD_Otros_Cobros.setTitle("Otros Cobros...");

        jdc_fecha1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Fecha *");

        txt_concepto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_concepto.setToolTipText("");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Novedad:");

        txta_novedad1.setColumns(20);
        txta_novedad1.setRows(5);
        jScrollPane5.setViewportView(txta_novedad1);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Concepto *");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(238, 13, 13));
        jLabel11.setText("*  Campos Obligatorios");

        btn_aceptar1.setText("Aceptar");
        btn_aceptar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_aceptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptar1ActionPerformed(evt);
            }
        });

        btn_cancelar1.setText("Cancelar");
        btn_cancelar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelar1ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Tarifa $ *");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(3, 3, 3)
                        .addComponent(jdc_fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_concepto, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_tarifa1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_aceptar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_cancelar1))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane5))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_concepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel12)
                        .addComponent(txt_tarifa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jdc_fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelar1)
                    .addComponent(btn_aceptar1))
                .addContainerGap())
        );

        javax.swing.GroupLayout JD_Otros_CobrosLayout = new javax.swing.GroupLayout(JD_Otros_Cobros.getContentPane());
        JD_Otros_Cobros.getContentPane().setLayout(JD_Otros_CobrosLayout);
        JD_Otros_CobrosLayout.setHorizontalGroup(
            JD_Otros_CobrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_Otros_CobrosLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );
        JD_Otros_CobrosLayout.setVerticalGroup(
            JD_Otros_CobrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registro Cuenta Cobro - Otros Gastos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cuenta de Cobro"));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Consecutivo N°:");

        txt_idcta.setEditable(false);
        txt_idcta.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_idcta, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_idcta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Desplazamientos"));

        tabla_despla.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        tabla_despla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_despla);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemaviaticosutd/recursos/add.png"))); // NOI18N
        btn_agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemaviaticosutd/recursos/delete.png"))); // NOI18N
        btn_eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_eliminar)
                    .addComponent(btn_agregar))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btn_agregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_eliminar)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        label_total.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        label_total.setText("Total $ 0,0");

        btn_terminar.setText("Terminar");
        btn_terminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_terminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_terminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_terminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label_total, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label_total)
                        .addContainerGap())
                    .addComponent(btn_terminar, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
          
        //Crea el JDialog Hijo de JIFCtaCobro    
          JD_Otros_Cobros.pack();
          JD_Otros_Cobros.setLocationRelativeTo(null);
          JD_Otros_Cobros.setVisible(true);
          JD_Otros_Cobros.setResizable(false);
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        eliminarRegistroTabla();

    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_terminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_terminarActionPerformed
         int opc=JOptionPane.showConfirmDialog(null,"Desea concluir la Cta. de Cobro?", "Aviso!", JOptionPane.YES_NO_OPTION); 
          
        if(opc==JOptionPane.YES_OPTION)
        {
            
        if(tabla_despla.getRowCount()== 0 && tabla_despla.getSelectedRow()==-1)
        {
            JOptionPane.showMessageDialog(null, "La tabla Desplazamiento no contiene ningun registro!");
            
        }
        else 
        {
            
            System.out.print(id);
         //   reporte=new ReporteTecnicos_1();
            reporte=new ReporteOtrosCobros();
         //   reporte.ejecutarReporte(Integer.parseInt(txt_idcta.getText()),id);
            reporte.ejecutarReporte(Integer.parseInt(txt_idcta.getText()),id);

           dispose();

        }
       }  
    }//GEN-LAST:event_btn_terminarActionPerformed

    private void btn_aceptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptar1ActionPerformed

         if(jdc_fecha1.getDate().before(fecha_ini) || jdc_fecha1.getDate().after(fecha_fin) )
        {
           JOptionPane.showMessageDialog(null, "La fecha del desplazamiento debe estar dentro del rango.");
        }
        else
        
        if(jdc_fecha1.getDate() == null || txt_concepto.getText().equals("") || txt_tarifa1.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Los campos fecha, concepto y tarifa son campos obligatorios!" ,"Alerta", JOptionPane.WARNING_MESSAGE);
        }
        
         else
        {
        
           if(txt_tarifa1.getText().matches("[0-9]*"))
            {
        
        
               detalle=new Detalle_Otros_Cobros();
               daodetalle=new Dao_Det_Otros_Cobros();
               otros=new OtrosCobros();       
               daoOtros=new Dao_OtrosCobros();
               ConexionBD conexion=new ConexionBD();
        
        
        ResultSet obj=conexion.executeQuery("SELECT id_otros_cobros FROM viaticos.cuenta_otros_cobros WHERE id_otros_cobros="+txt_idcta.getText()+" AND id_usuario="+id_usuario+"");
       try {
           if(obj.next()==false)
           {
     
                 // int con_cta=0;
    
             otros.setControl_otros(consecutivo);
             otros.setFecha_sistema(new Date());
             otros.setId_usuario(id_usuario);
             fecha_ini=MDIPrincipal.getfecha_ini1();
             fecha_fin=MDIPrincipal.getfecha_fin1();
             otros.setDesde(fecha_ini);
             otros.setHasta(fecha_fin);
       
             daoOtros.registroOtrosCobros(otros);
             
             id=Dao_OtrosCobros.getIdcta();
            
        
       
//        ResultSet obj1=conexion.executeQuery("SELECT MAX(id_otros_cobros)AS consecutivo FROM viaticos.cuenta_otros_cobros WHERE id_usuario="+id_usuario+"");
//      
//           if(obj1.next()==true)
//           {
//              con_cta=obj1.getInt("consecutivo");
//               System.out.print(con_cta);
//           }
           //Actualiza el control de los consecutivos
            conexion.executeUpdateQuery("UPDATE usuarios.usuarios SET control_otros_cobros="+txt_idcta.getText()+" WHERE id_usuario="+id_usuario+"");
            conexion.desconectar();
       
                 detalle.setId_manejo_cta(id);         
                 detalle.setFecha(jdc_fecha1.getDate());
                 detalle.setConcepto(txt_concepto.getText());
                 detalle.setTarifa(Integer.parseInt(txt_tarifa1.getText()));
                 detalle.setNovedad(txta_novedad1.getText());
 
                 daodetalle.registroOtrosCobros(detalle);
                
                 LimpiarTabla();
                 detalleTabla();
                 sumatoriaTotales();
                 
                 txt_concepto.setText("");
                 txt_tarifa1.setText("");
                 txta_novedad1.setText("");

           }
           else
           {
               
                detalle.setId_manejo_cta(id);         
                 detalle.setFecha(jdc_fecha1.getDate());
                 detalle.setConcepto(txt_concepto.getText());
                 detalle.setTarifa(Integer.parseInt(txt_tarifa1.getText()));
                 detalle.setNovedad(txta_novedad1.getText());
 
                 daodetalle.registroOtrosCobros(detalle);
                
                 LimpiarTabla();
                 detalleTabla();
                 sumatoriaTotales();
                 
                 txt_concepto.setText("");
                 txt_tarifa1.setText("");
                 txta_novedad1.setText("");
               
           }

       } catch (SQLException ex) {
           Logger.getLogger(JIFCtaOtrosCobros.class.getName()).log(Level.SEVERE, null, ex);
       }
       }else
           {
               JOptionPane.showMessageDialog(null, " El Campo tarifa debe ser campo numérico tipo entero! ","Alerta", JOptionPane.WARNING_MESSAGE);

           }
      }     
       
    }//GEN-LAST:event_btn_aceptar1ActionPerformed

    private void btn_cancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelar1ActionPerformed
        JD_Otros_Cobros.dispose();
    }//GEN-LAST:event_btn_cancelar1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog JD_Otros_Cobros;
    private javax.swing.JButton btn_aceptar1;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_cancelar1;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_terminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser jdc_fecha1;
    private javax.swing.JLabel label_total;
    private javax.swing.JTable tabla_despla;
    private javax.swing.JTextField txt_concepto;
    private javax.swing.JTextField txt_idcta;
    private javax.swing.JTextField txt_tarifa1;
    private javax.swing.JTextArea txta_novedad1;
    // End of variables declaration//GEN-END:variables

    //Metodo para buscar los desplazamientos, llenandolos en un JComboBox
//    public void buscarDesplazamiento() throws SQLException
//    {
//      //  ConexionBD conexion=new ConexionBD();
//        
//         ResultSet obj=conexion.executeQuery("SELECT descrip_despla FROM desplazamientos.desplazamiento WHERE descrip_despla ilike '%"+txt_iddespla.getText()+"%' ORDER BY descrip_despla");
//            
//            while(obj.next())
//            {
//                jcb_desplazamiento.addItem(obj.getObject("descrip_despla"));
//            }
//            
//            conexion.desconectar();
//    }
    
    
     public void LimpiarTabla()
    {
  
        for(int i=modelo.getRowCount()-1;i>=0;i--)
        {
            modelo.removeRow(i); 
        }
    }
     
//         public void LimpiarTabla_2()
//    {
//  
//        for(int i=modelo2.getRowCount()-1;i>=0;i--)
//        {
//            modelo2.removeRow(i);
//            
//        }
//    }
       // Metodo para llenar la tabla detalle
       public void detalleTabla()
        {
       try
        {
            ConexionBD nueva=new ConexionBD();
            
            ResultSet obj=nueva.executeQuery("SELECT det.id_otros_cobros,det.fecha,det.concepto,det.novedad,det.tarifa "
                    + "FROM viaticos.otros_cobros det JOIN viaticos.cuenta_otros_cobros cta ON det.id_cta_cobro=cta.id_cta_otros "
                    + "WHERE cta.id_otros_cobros="+txt_idcta.getText()+" AND id_usuario="+id_usuario+" ORDER BY det.fecha ASC");
            
         while (obj.next()) 
        {
        
        Object [] datos = new Object[5];
        
     
        for (int i=0;i<5;i++)
        {
            datos[i] =obj.getObject(i+1);
        }

         modelo.addRow(datos);
       
        }
           tabla_despla.setModel(modelo);
           nueva.desconectar();

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
       
       
//        for (int i=0;i<eldetalle.size();i++)
//        {
//            
//            ((Detalle_Viaticos)eldetalle.elementAt(i)).getFecha_despla();
//            ((Detalle_Viaticos)eldetalle.elementAt(i)).getFecha_despla();
//            
//            eldetalle.elementAt(i+1);
//        }
//        modelo.addRow(eldetalle);
//        tabla_despla.setModel(modelo);
   }
    
       //Metodo que suma la columna Total de la tabla detalle 
    public void sumatoriaTotales()
    {
        
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setPerMill('.');
        java.text.DecimalFormat formato = new java.text.DecimalFormat("'Total: $' #,##0.00",dfs);
        
        
        int sum_total = 0;
        int totalRow= tabla_despla.getRowCount();
        totalRow-=1; 
        for(int i=0;i<=(totalRow);i++)
        {
             int sumatoria= Integer.parseInt(String.valueOf(tabla_despla.getValueAt(i,4)));
             sum_total+=sumatoria;
   
          label_total.setText(formato.format(sum_total));
          
           }
    }
    
    //Metodo que suma la columna Total de la tabla otrosCobros
//    public void sumatoriaTotalesOtros()
//    {
//        
//        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
//        dfs.setPerMill('.');
//        java.text.DecimalFormat formato = new java.text.DecimalFormat("'Total: $' #,##0.00",dfs);
//        
//        
//        int sum_total = 0;
//        int totalRow= tabla_otros_cobros.getRowCount();
//        totalRow-=1; 
//        for(int i=0;i<=(totalRow);i++)
//        {
//            int sumatoria= Integer.parseInt(String.valueOf(tabla_otros_cobros.getValueAt(i,4)));
//            sum_total+=sumatoria;
//   
//            label_total1.setText(formato.format(sum_total));
//          
//         }
//    }
    
    //Eliminar registro Tabla Detalle Desplazamiento
    public void eliminarRegistroTabla()
    {
         ConexionBD nueva=new ConexionBD();
        
        //Verifica que la fila de la tabla esta seleccionada
        if(tabla_despla.isRowSelected(tabla_despla.getSelectedRow()))
        {
           int row = tabla_despla.getSelectedRow();

        for(int i = 0; i < modelo.getRowCount(); i++)
        {
           nueva.executeUpdateQuery("DELETE FROM viaticos.otros_cobros WHERE id_otros_cobros="+modelo.getValueAt(row,0)+" ");

        }
         int numRows = tabla_despla.getSelectedRows().length;
         
         for(int i = 0; i < numRows ; i++ )
         {
            modelo.removeRow(row);
         } 
          
        }         
 
     else
     {
      JOptionPane.showMessageDialog(this, "Debe seleccionar un registro de la tabla para eliminarlo!."
         ,"Aviso", JOptionPane.WARNING_MESSAGE);
     }
          nueva.desconectar(); 
          LimpiarTabla();
          detalleTabla(); 
          sumatoriaTotales();
    }
    
    //Metodo que llena la tabla detalle otros cobros
//    public void detalle_otros_cobros()
//    {
//        ConexionBD nueva=new ConexionBD();
//        
//        
//        ResultSet obj=conexion.executeQuery("SELECT det.id_otros_cobros,det.fecha,det.concepto,det.novedad,det.tarifa "
//                + "FROM viaticos.otros_cobros det JOIN viaticos.cuenta_cobro cta ON det.id_cta_cobro=cta.id_manejo_cta "
//                + "WHERE det.id_cta_cobro="+id+" ORDER BY det.fecha ASC");
//       try {
//           while (obj.next()) 
//          {
//          
//          Object [] datos = new Object[5];
//       
//          for (int i=0;i<5;i++)
//          {
//              datos[i] =obj.getObject(i+1);
//          }
//
//           modelo2.addRow(datos);
//         
//          }
//       } catch (SQLException ex) {
//           Logger.getLogger(JIFCtaCobro.class.getName()).log(Level.SEVERE, null, ex);
//       }
//          // tabla_otros_cobros.setModel(modelo2);
//           nueva.desconectar();
//
//        
//    }
    
    //Elimina registro de la tabla otros cobros
//    public void eliminarRegistroTablaOtros()
//    {
//         ConexionBD nueva=new ConexionBD();
//        
//        //Verifica que la fila de la tabla esta seleccionada
//        if(tabla_otros_cobros.isRowSelected(tabla_otros_cobros.getSelectedRow()))
//        {
//           int row = tabla_otros_cobros.getSelectedRow();
//
//        for(int i = 0; i < modelo2.getRowCount(); i++)
//        {
//           nueva.executeUpdateQuery("DELETE FROM viaticos.otros_cobros WHERE id_otros_cobros="+modelo2.getValueAt(row,0)+" ");
//
//        }
//         int numRows = tabla_otros_cobros.getSelectedRows().length;
//         
//         for(int i = 0; i < numRows ; i++ )
//         {
//            modelo2.removeRow(row);
//         } 
//          sumatoriaTotalesOtros();
//        }         
// 
//     else
//     {
//      JOptionPane.showMessageDialog(this, "Debe seleccionar un registro de la tabla para eliminarlo!."
//         ,"Aviso", JOptionPane.WARNING_MESSAGE);
//     }
//          nueva.desconectar(); 
//          LimpiarTabla_2();
//          detalle_otros_cobros();
//    }
    
      public static Date getPrimerDiaDelMes() {

        Calendar cal = Calendar.getInstance();

        cal.set(cal.get(Calendar.YEAR),

                cal.get(Calendar.MONTH),

                cal.getActualMinimum(Calendar.DAY_OF_MONTH),

                cal.getMinimum(Calendar.HOUR_OF_DAY),

                cal.getMinimum(Calendar.MINUTE),

                cal.getMinimum(Calendar.SECOND));
        return cal.getTime();


    }

    public static Date getUltimoDiaDelMes() {

        Calendar cal = Calendar.getInstance();

        cal.set(cal.get(Calendar.YEAR),

                cal.get(Calendar.MONTH),

              cal.getActualMaximum(Calendar.DAY_OF_MONTH),

                cal.getMaximum(Calendar.HOUR_OF_DAY),

                cal.getMaximum(Calendar.MINUTE),

                cal.getMaximum(Calendar.SECOND));

        return cal.getTime();

    }
    
    
    
}
