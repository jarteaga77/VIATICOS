package sistemaviaticosutd.presentacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormatSymbols;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistemaviaticosutd.conexion.ConexionBD;
import sistemaviaticosutd.viaticos.Anticipos;
import sistemaviaticosutd.viaticos.DaoDetalle_Anticipo;
import sistemaviaticosutd.viaticos.Dao_Anticipo;
import sistemaviaticosutd.viaticos.Detalle_Anticipo;

/**
 *
 * @author jarteaga
 */
public class JIFRegAnticipo extends javax.swing.JInternalFrame {

  
    private ConexionBD conexion;
    private Anticipos anticipo;
    private Dao_Anticipo daoAnticipo;
    private Detalle_Anticipo detalle;
    private DaoDetalle_Anticipo daodetalle;
    private DefaultTableModel modelo;
    
    public JIFRegAnticipo() {
        initComponents();
        
        conexion=new ConexionBD();
        modelo=new DefaultTableModel();
        
        ResultSet obj=conexion.executeQuery("SELECT nombre_usuario FROM usuarios.usuarios WHERE activo=true ORDER BY nombre_usuario ASC");
        try {
             while(obj.next())
            {
                cb_usuario.addItem(obj.getObject("nombre_usuario"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(JIFRegAnticipo.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
        ResultSet obj1=conexion.executeQuery("SELECT descripcion FROM month_year.mes");
        
        try {
             while(obj1.next())
            {
                cb_mes.addItem(obj1.getObject("descripcion"));
            }
            
            
        } catch (Exception ex) 
        {
            
            JOptionPane.showMessageDialog(null, ex.getMessage());
        
        }
        
        ResultSet obj2=conexion.executeQuery("SELECT descripcion FROM month_year.year");
        
        try {
             while(obj2.next())
            {
                cb_anio.addItem(obj2.getObject("descripcion"));
            }
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        
        }
        
//         ResultSet obj3=conexion.executeQuery("SELECT COALESCE (MAX (id_anticipo), 0)+1 AS id FROM anticipos_cruce_ctas.anticipo");
//        
//        try {
//             while(obj3.next())
//            {
//                txt_id.setText(String.valueOf(obj3.getInt("id")));
//            }
//            
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(JIFRegAnticipo.class.getName()).log(Level.SEVERE, null, ex);
//        
//        }
        genId();
            
            conexion.desconectar();
            
            
            modelo.addColumn("ID");
            modelo.addColumn("Técnico");
            modelo.addColumn("Valor Anticipo");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        btn_cancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cb_anio = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        txt_oficio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cb_mes = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        cb_usuario = new javax.swing.JComboBox();
        txt_vlor_anticipo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_deta = new javax.swing.JTable();
        btn_aceptar = new javax.swing.JButton();
        label_total = new javax.swing.JLabel();

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemaviaticosutd/recursos/delete.png"))); // NOI18N
        jMenuItem1.setText("Eliminar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Registro Anticipos");

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Anticipo"));

        cb_anio.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("ID Anticipo");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Soporte Oficio");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Mes");

        txt_id.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Año");

        cb_mes.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_oficio, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_mes, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_anio, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_oficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(cb_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cb_anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Anticipos Técnicos"));

        cb_usuario.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Usuario");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Valor Anticipo $");

        tabla_deta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_deta.setComponentPopupMenu(jPopupMenu1);
        tabla_deta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_detaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_deta);

        btn_aceptar.setText("Aceptar");
        btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarActionPerformed(evt);
            }
        });

        label_total.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        label_total.setText("Total Anticipo $ 0.0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_vlor_anticipo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_aceptar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(label_total)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_vlor_anticipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(cb_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_aceptar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_total))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cancelar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cancelar))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
         
        try
        {
            int vlor_anti=Integer.parseInt(txt_vlor_anticipo.getText());
            
            int id_mes=0, id_anio=0, id_us=0;
            String mes =cb_mes.getSelectedItem().toString();
            String anio=cb_anio.getSelectedItem().toString();
            String usuario=cb_usuario.getSelectedItem().toString();
            ResultSet obj1=conexion.executeQuery("SELECT id_mes FROM month_year.mes WHERE descripcion='"+mes+"'");
            ResultSet obj2=conexion.executeQuery("SELECT id_year FROM month_year.year WHERE descripcion='"+anio+"'");
            ResultSet obj3=conexion.executeQuery("SELECT id_usuario FROM usuarios.usuarios WHERE nombre_usuario='"+usuario+"'");

               while(obj1.next())
                {
                    id_mes=obj1.getInt("id_mes");
                  
                }
               
                while(obj2.next())
                {
                    id_anio=obj2.getInt("id_year");
                }
                
                 while(obj3.next())
                {
                    id_us=obj3.getInt("id_usuario");
                }
            
        if(txt_oficio.getText().equals("") || txt_vlor_anticipo.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "El campo Oficio  y/o Valor Anticipo estan vacios!" + "* Campos obligatorios" ,"Alerta", JOptionPane.WARNING_MESSAGE);
        }
         else
   
             if(txt_vlor_anticipo.getText().matches("[0-9]*"))
             {
                    anticipo=new Anticipos();
                    daoAnticipo=new Dao_Anticipo();
                    detalle=new Detalle_Anticipo();
                    daodetalle=new DaoDetalle_Anticipo();
                    
                  ResultSet obj=conexion.executeQuery("SELECT id_anticipo FROM anticipos_cruce_ctas.anticipo WHERE id_anticipo="+txt_id.getText()+"");
                  
                  if(vlor_anti <= 1000000)
                  {
                  
                        if(obj.next()==false)
                        {
                            anticipo.setAnti_fecha(new Date());
                            anticipo.setAnti_oficio(txt_oficio.getText());
                            anticipo.setMes(id_mes);
                            anticipo.setAnio(id_anio);
                     
                            daoAnticipo.registrar(anticipo);

                           detalle.setId_usuario(id_us);
                           detalle.setVlor_anticipo(Integer.parseInt(txt_vlor_anticipo.getText()));
                           detalle.setId_anticipo(Integer.parseInt(txt_id.getText()));
                    
                           daodetalle.regDetalle(detalle);
                           LimpiarTabla();
                           detalleTabla();
                        }
                    else
                    {
                        
                        ResultSet obj4=conexion.executeQuery("SELECT id_usuario FROM anticipos_cruce_ctas.detalle_anticipo WHERE id_usuario="+id_us+" AND id_anticipo="+txt_id.getText()+"");
                        
                        if(obj4.next()==false)
                        {
                        detalle.setId_usuario(id_us);
                        detalle.setVlor_anticipo(Integer.parseInt(txt_vlor_anticipo.getText()));
                        detalle.setId_anticipo(Integer.parseInt(txt_id.getText()));
                    
                        daodetalle.regDetalle(detalle);
                    
                        LimpiarTabla();
                        detalleTabla();
                       }
                        else
                        {
                           JOptionPane.showMessageDialog(null, "El Técnico " + usuario + " ya tiene un Anticipo registrado","Alerta", JOptionPane.WARNING_MESSAGE);
                        }
                  }
                } 
                  else
                  {
                     JOptionPane.showMessageDialog(null, "El valor del Anticipo supera los limites permitidos" ,"Alerta", JOptionPane.WARNING_MESSAGE);

                  }
             }
         else
             {
                JOptionPane.showMessageDialog(null, "El valor del Anticipo son datos numéricos" ,"Alerta", JOptionPane.WARNING_MESSAGE);

             }
        
        }catch(Exception e)
        {
           JOptionPane.showMessageDialog(null, e ,"Error", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_btn_aceptarActionPerformed

    private void tabla_detaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_detaMouseClicked
        
    }//GEN-LAST:event_tabla_detaMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        eliminarRegistroTabla();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JComboBox cb_anio;
    private javax.swing.JComboBox cb_mes;
    private javax.swing.JComboBox cb_usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_total;
    private javax.swing.JTable tabla_deta;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_oficio;
    private javax.swing.JTextField txt_vlor_anticipo;
    // End of variables declaration//GEN-END:variables


public void limpiarCampos()
{
    txt_oficio.setText("");
    txt_vlor_anticipo.setText("");
    txt_id.setText("");
    genId();

}

public void genId()
{
     ResultSet obj3=conexion.executeQuery("SELECT COALESCE (MAX (id_anticipo), 0)+1 AS id FROM anticipos_cruce_ctas.anticipo");
        
        try {
             while(obj3.next())
            {
                txt_id.setText(String.valueOf(obj3.getInt("id")));
            }
 
        } catch (SQLException ex) {
            Logger.getLogger(JIFRegAnticipo.class.getName()).log(Level.SEVERE, null, ex);
        
        }
}

       public void detalleTabla()
        {
     try
        {
            ConexionBD nueva=new ConexionBD();
            
            ResultSet obj=nueva.executeQuery("SELECT det.id_det_ant,(us.nombre_usuario ||' '|| us.apellido_usuario) AS usuario,det.vlor_anticipo "
                    + "FROM anticipos_cruce_ctas.detalle_anticipo det JOIN usuarios.usuarios us ON det.id_usuario=us.id_usuario "
                    + "WHERE det.id_anticipo="+txt_id.getText()+""
                    + "ORDER BY usuario ASC ");
                    
            
         while (obj.next()) 
        {
        
        Object [] datos = new Object[3];
        
     
        for (int i=0;i<3;i++)
        {
            datos[i] =obj.getObject(i+1);
        }

         modelo.addRow(datos);
       
        }
           tabla_deta.setModel(modelo);
           nueva.desconectar();
           sumatoriaTotales();

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }

        }

         public void sumatoriaTotales()
    {
        
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setPerMill('.');
        java.text.DecimalFormat formato = new java.text.DecimalFormat("'Total Anti.: $' #,##0.00",dfs);
        
        
        int sum_total = 0;
        int totalRow= tabla_deta.getRowCount();
        totalRow-=1; 
        for(int i=0;i<=(totalRow);i++)
        {
             int sumatoria= Integer.parseInt(String.valueOf(tabla_deta.getValueAt(i,2)));
             sum_total+=sumatoria;
   
          label_total.setText(formato.format(sum_total));
          
           }
    }

    public void eliminarRegistroTabla()
    {
         ConexionBD nueva=new ConexionBD();
        
        //Verifica que la fila de la tabla esta seleccionada
        if(tabla_deta.isRowSelected(tabla_deta.getSelectedRow()))
        {
           int row = tabla_deta.getSelectedRow();

        for(int i = 0; i < modelo.getRowCount(); i++)
        {
           nueva.executeUpdateQuery("DELETE FROM anticipos_cruce_ctas.detalle_anticipo WHERE id_det_ant="+modelo.getValueAt(row,0)+" ");

        }
         int numRows = tabla_deta.getSelectedRows().length;
         
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
          nueva.desconectar(); 
          LimpiarTabla();
          detalleTabla();  
    }
        
    
     public void LimpiarTabla()
    {
  
        for(int i=modelo.getRowCount()-1;i>=0;i--)
        {
            modelo.removeRow(i);
            
        }
    }
         
}
