
package sistemaviaticosutd.presentacion;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormatSymbols;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistemaviaticosutd.conexion.ConexionBD;
import sistemaviaticosutd.reportes.tecnicos.ReporteTecnicos_1_2;
import sistemaviaticosutd.viaticos.DaoDetalle_Viaticos;
import sistemaviaticosutd.viaticos.Detalle_Viaticos;

/**
 *
 * @author jarteaga
 */
public class JIFCtaCobroMod extends javax.swing.JInternalFrame {
    
    
    private ConexionBD conexion=new ConexionBD();
    private DefaultTableModel modelo;
   // private DefaultTableModel modelo2;   
    private int id_usuario=MDIPrincipal.getSeccion();
    private int id_manejoCta,ctanumero,id_tec ;
    private Date desde,hasta;
   // private ReporteTecnicos_1 reporte;
    private Detalle_Viaticos detalle;
    private DaoDetalle_Viaticos daodetalle;
    private ReporteTecnicos_1_2 reporte2;
    public int id_tabla;
    
    

    public JIFCtaCobroMod() {
        initComponents();
        
        
        if(id_usuario==11 || id_usuario==16)
        {
            txt_cta_num.setEnabled(true);
            txt_tec.setEnabled(true);
            jcb_tec.setEnabled(true);
            btn_buscar.setEnabled(true);
      
        }
     
         modelo=new DefaultTableModel();
       //  modelo2=new DefaultTableModel();
           
        modelo.addColumn("ID");
        modelo.addColumn("Fecha");
        modelo.addColumn("Desplazamiento");
        modelo.addColumn("Novedad");
        modelo.addColumn("Valor");
        
//        modelo2.addColumn("ID");
//        modelo2.addColumn("Fecha");
//        modelo2.addColumn("Conceopto");
//        modelo2.addColumn("Novedad");
//        modelo2.addColumn("Tarifa");
//      
          try {
        
        ResultSet obj=conexion.executeQuery("SELECT id_cuenta_cobro,id_manejo_cta,id_usuario,desde,hasta FROM viaticos.cuenta_cobro WHERE id_usuario="+id_usuario+ " AND cuenta_generada=false AND cta_aprobada=false");
      
            while(obj.next())
            {
                id_manejoCta=obj.getInt("id_manejo_cta");
                
                ctanumero=obj.getInt("id_cuenta_cobro");
                id_tec=obj.getInt("id_usuario");
                
                txt_cta_num.setText(String.valueOf(ctanumero));
                txt_tec.setText(String.valueOf(id_tec));
                
                desde=obj.getDate("desde");
                hasta=obj.getDate("hasta");
            }
            System.out.println(id_manejoCta);
        
        ResultSet obj1=conexion.executeQuery("SELECT det.id_detalle_cuenta,det.fecha_despla,desp.descrip_despla,det.novedad,desp.tarifa_despla "
                    + "FROM viaticos.detalle_cuenta_cobro det JOIN viaticos.cuenta_cobro cta ON cta.id_manejo_cta=det.id_cuenta_cobro "
                    + "JOIN desplazamientos.desplazamiento desp ON desp.id_desplazamiento=det.id_desplazamiento "
                    + "WHERE cta.cuenta_generada=false AND cta.cta_aprobada=false AND id_usuario="+id_usuario+""
                    + "ORDER BY det.fecha_despla,det.id_detalle_cuenta ASC");
        
           while (obj1.next()) 
           {
           
           Object [] datos = new Object[5];
           
        
           for (int i=0;i<5;i++)
           {
               datos[i] =obj1.getObject(i+1);
           }

            modelo.addRow(datos);
            
       
           }
           tabla_despla.setModel(modelo);
           sumatoriaTotales();
           conexion.desconectar();
           
        } catch (SQLException ex) {
            Logger.getLogger(JIFCtaCobroMod.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           
//             ResultSet obj2=conexion.executeQuery("SELECT det.id_otros_cobros,det.fecha,det.concepto,det.novedad, det.tarifa "
//                     + "FROM viaticos.otros_cobros det JOIN viaticos.cuenta_cobro cta ON cta.id_manejo_cta=det.id_cta_cobro "
//                     + "WHERE cta.cuenta_generada=false AND cta.cta_aprobada=false AND cta.id_usuario="+id_usuario+" "
//                     + "ORDER BY det.fecha ASC");
//        try {
//            while (obj2.next()) 
//            {
//            
//            Object [] datos = new Object[5];
//         
//            for (int i=0;i<5;i++)
//            {
//                datos[i] =obj2.getObject(i+1);
//            }
//
//             modelo2.addRow(datos);
//             
//        
//            }
//            
//            tabla_otros_cobros.setModel(modelo2);
//            sumatoriaTotalesOtros();
//            conexion.desconectar();
//        } catch (SQLException ex) {
//            Logger.getLogger(JIFCtaCobroMod.class.getName()).log(Level.SEVERE, null, ex);
//        }
 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JD_desplazamientos = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jdc_fecha = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        txt_iddespla = new javax.swing.JTextField();
        jcb_desplazamiento = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txta_novedad = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_aceptar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        txt_tarifa = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        JD_Mod_desplazamientos = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jdc_fecha2 = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        txt_iddespla1 = new javax.swing.JTextField();
        jcb_desplazamiento1 = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txta_novedad2 = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btn_aceptar2 = new javax.swing.JButton();
        btn_cancelar2 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txt_tarifa2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_cta_num = new javax.swing.JTextField();
        txt_tec = new javax.swing.JTextField();
        jcb_tec = new javax.swing.JComboBox();
        btn_buscar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_despla = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btn_agregar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        label_total = new javax.swing.JLabel();
        btn_terminar = new javax.swing.JButton();

        JD_desplazamientos.setTitle("Desplazamientos...");

        jdc_fecha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Fecha *");

        txt_iddespla.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_iddespla.setToolTipText("Iniciales del Peaje + tecla Shift ");
        txt_iddespla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_iddesplaKeyReleased(evt);
            }
        });

        jcb_desplazamiento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcb_desplazamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_desplazamientoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Novedad:");

        txta_novedad.setColumns(20);
        txta_novedad.setRows(5);
        jScrollPane2.setViewportView(txta_novedad);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Desplazamiento *");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(238, 13, 13));
        jLabel5.setText("*  Campos Obligatorios");

        btn_aceptar.setText("Aceptar");
        btn_aceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarActionPerformed(evt);
            }
        });

        btn_cancelar.setText("Cancelar");
        btn_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        txt_tarifa.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Tarifa $");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(3, 3, 3)
                                .addComponent(jdc_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel4))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_tarifa, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_iddespla, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcb_desplazamiento, 0, 268, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_aceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_cancelar)
                .addGap(28, 28, 28))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_iddespla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcb_desplazamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdc_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_tarifa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_aceptar)
                    .addComponent(btn_cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JD_desplazamientosLayout = new javax.swing.GroupLayout(JD_desplazamientos.getContentPane());
        JD_desplazamientos.getContentPane().setLayout(JD_desplazamientosLayout);
        JD_desplazamientosLayout.setHorizontalGroup(
            JD_desplazamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JD_desplazamientosLayout.setVerticalGroup(
            JD_desplazamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        JD_Mod_desplazamientos.setTitle("Desplazamientos...");

        jdc_fecha2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("Fecha *");

        txt_iddespla1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_iddespla1.setToolTipText("Iniciales de la estación + la tecla Shift");
        txt_iddespla1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_iddespla1KeyReleased(evt);
            }
        });

        jcb_desplazamiento1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcb_desplazamiento1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_desplazamiento1ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setText("Novedad:");

        txta_novedad2.setColumns(20);
        txta_novedad2.setRows(5);
        jScrollPane4.setViewportView(txta_novedad2);

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("Desplazamiento *");

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(238, 13, 13));
        jLabel16.setText("*  Campos Obligatorios");

        btn_aceptar2.setText("Aceptar");
        btn_aceptar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_aceptar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptar2ActionPerformed(evt);
            }
        });

        btn_cancelar2.setText("Cancelar");
        btn_cancelar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelar2ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setText("Tarifa $");

        txt_tarifa2.setEditable(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_tarifa2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(3, 3, 3)
                                .addComponent(jdc_fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(4, 4, 4)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_iddespla1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcb_desplazamiento1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_aceptar2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_cancelar2))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane4))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_iddespla1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcb_desplazamiento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15))
                    .addComponent(jdc_fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(11, 11, 11)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txt_tarifa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_cancelar2)
                            .addComponent(btn_aceptar2)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addGap(0, 36, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout JD_Mod_desplazamientosLayout = new javax.swing.GroupLayout(JD_Mod_desplazamientos.getContentPane());
        JD_Mod_desplazamientos.getContentPane().setLayout(JD_Mod_desplazamientosLayout);
        JD_Mod_desplazamientosLayout.setHorizontalGroup(
            JD_Mod_desplazamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_Mod_desplazamientosLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        JD_Mod_desplazamientosLayout.setVerticalGroup(
            JD_Mod_desplazamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Modificar Cuenta Cobro");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cuenta de Cobro"));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Consecutivo N°:");

        txt_cta_num.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        txt_cta_num.setEnabled(false);

        txt_tec.setEnabled(false);
        txt_tec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_tecKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_tecKeyReleased(evt);
            }
        });

        jcb_tec.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jcb_tec.setToolTipText("");
        jcb_tec.setEnabled(false);
        jcb_tec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_tecActionPerformed(evt);
            }
        });

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemaviaticosutd/recursos/buscar.png"))); // NOI18N
        btn_buscar.setToolTipText("Buscar");
        btn_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buscar.setEnabled(false);
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Técnico");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cta_num, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_tec, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcb_tec, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_buscar)
                .addGap(6, 6, 6))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_buscar)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txt_cta_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_tec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcb_tec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
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

        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemaviaticosutd/recursos/mod_detalle.png"))); // NOI18N
        btn_modificar.setToolTipText("Modificar");
        btn_modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_modificar.setPreferredSize(new java.awt.Dimension(32, 32));
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btn_agregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_eliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );

        label_total.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        label_total.setText("Total $ 0,0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(label_total, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_total))
        );

        btn_terminar.setText("Terminar");
        btn_terminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_terminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_terminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_terminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_terminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
          JD_desplazamientos.pack();
          JD_desplazamientos.setLocationRelativeTo(null);
          JD_desplazamientos.setVisible(true);
          JD_desplazamientos.setResizable(false);
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        JD_desplazamientos.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        LimpiarTabla();
        buscarCta();
//        LimpiarTabla_2();
//        buscarOtrosCobros();
//        sumatoriaTotalesOtros();
       
      
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void txt_tecKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tecKeyPressed
       
    }//GEN-LAST:event_txt_tecKeyPressed

    private void txt_tecKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tecKeyReleased
          if(evt.getKeyCode()== KeyEvent.VK_SHIFT)
        {
            try {
                jcb_tec.removeAllItems();
                buscarTecnico();
            } catch (SQLException ex) {
                Logger.getLogger(JIFCtaCobro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txt_tecKeyReleased

    private void jcb_tecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_tecActionPerformed
        if(jcb_tec.getSelectedItem()!=null)
            {
                int id;
      
               // ConexionBD conexion=new ConexionBD();
            try {
                String nombre=jcb_tec.getSelectedItem().toString();
                ResultSet obj=conexion.executeQuery("SELECT id_usuario FROM usuarios.usuarios WHERE nombre_usuario='"+nombre+"'");
                
                while(obj.next())
                {
                    id=obj.getInt("id_usuario");
                    
                    txt_tec.setText("");
                    txt_tec.setText(String.valueOf(id));
                   
                }
                conexion.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(JIFCtaCobro.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
    }//GEN-LAST:event_jcb_tecActionPerformed

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed

        try
        {
        
        if(jdc_fecha.getDate().before(desde) || jdc_fecha.getDate().after(hasta) )
        {
           JOptionPane.showMessageDialog(null, "La fecha del desplazamiento debe estar dentro del rango.");
        }
        
        else
        
          if(jdc_fecha.getDate() == null || txt_iddespla.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Los campos fecha o el ID del desplazamiento estan vacios!" + "* Campos obligatorios" ,"Alerta", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
        
           if(txt_iddespla.getText().matches("[0-9]*"))
            {
     
            detalle=new Detalle_Viaticos();
            daodetalle=new DaoDetalle_Viaticos();
       
            int id_desp=Integer.parseInt(txt_iddespla.getText());
       
            ResultSet obj2=conexion.executeQuery("SELECT * FROM viaticos.detalle_cuenta_cobro det JOIN viaticos.cuenta_cobro cta ON cta.id_manejo_cta=det.id_cuenta_cobro "
                    + "WHERE det.fecha_despla='"+jdc_fecha.getDate()+"' AND cta.id_usuario="+id_usuario+"");
      
           if(obj2.next()==false)
           {
               if(id_desp==9 || id_desp==10 || id_desp==23 || id_desp==24)
               {
                   JOptionPane.showMessageDialog(null,"El traslado CALI - ESTAMBUL,CCO ó CIAT ó PALMIRA - ESTAMBUL,CCO ó CIAT no se paga si se arranca por estas estaciones.");

               }
               else
               {                  
                 detalle.setId_manejo_acta(id_manejoCta);         
                 detalle.setFecha_despla(jdc_fecha.getDate());
                 detalle.setId_desplaza(Integer.parseInt(txt_iddespla.getText()));
                 detalle.setNovedad(txta_novedad.getText());
 
                 daodetalle.guardarDetalle(detalle);
                
                 LimpiarTabla();
                 detalleTabla();
                 
                 txt_iddespla.setText("");
                 txt_tarifa.setText("");
                 txta_novedad.setText("");

               }
           }
           else
           { 
              detalle.setId_manejo_acta(id_manejoCta); 
              detalle.setFecha_despla(jdc_fecha.getDate());
              detalle.setId_desplaza(Integer.parseInt(txt_iddespla.getText()));
              detalle.setNovedad(txta_novedad.getText());

              daodetalle.guardarDetalle(detalle);
              LimpiarTabla();
              detalleTabla();
              sumatoriaTotales();
              
               txt_iddespla.setText("");
               txt_tarifa.setText("");
               txta_novedad.setText("");
               
           }
  
           
           conexion.desconectar();
      
      }else
           {
             JOptionPane.showMessageDialog(null, " El ID del desplazamiento es un dato numérico!","Alerta", JOptionPane.WARNING_MESSAGE);

           }
     }  
        
      } catch (Exception ex) {
          JOptionPane.showMessageDialog(null,ex,"Error",JOptionPane.ERROR_MESSAGE);
       }   
        
    }//GEN-LAST:event_btn_aceptarActionPerformed

    private void txt_iddesplaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_iddesplaKeyReleased
         if(evt.getKeyCode()== KeyEvent.VK_SHIFT)
        {
            try {
                jcb_desplazamiento.removeAllItems();
                buscarDesplazamiento();
            } catch (SQLException ex) {
                Logger.getLogger(JIFCtaCobro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txt_iddesplaKeyReleased

    private void jcb_desplazamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_desplazamientoActionPerformed
         if(jcb_desplazamiento.getSelectedItem()!=null)
            {
                int id;
                int tarifa;
                
               // ConexionBD conexion=new ConexionBD();
            try {
                String nombre=jcb_desplazamiento.getSelectedItem().toString();
                ResultSet obj=conexion.executeQuery("SELECT id_desplazamiento,tarifa_despla FROM desplazamientos.desplazamiento WHERE descrip_despla='"+nombre+"'");
                
                while(obj.next())
                {
                    id=obj.getInt("id_desplazamiento");
                    tarifa=obj.getInt("tarifa_despla");
                    txt_iddespla.setText("");
                    txt_iddespla.setText(String.valueOf(id));
                    txt_tarifa.setText(String.valueOf(tarifa));
                }
                conexion.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(JIFCtaCobro.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
    }//GEN-LAST:event_jcb_desplazamientoActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        eliminarRegistroTabla();
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
         Date fecha;
          String novedad;
        
        if(tabla_despla.isRowSelected(tabla_despla.getSelectedRow()))
            {
                id_tabla = (Integer) tabla_despla.getValueAt(tabla_despla.getSelectedRow(), 0);    
                fecha=(Date) tabla_despla.getValueAt(tabla_despla.getSelectedRow(), 1);
                novedad=(String) tabla_despla.getValueAt(tabla_despla.getSelectedRow(), 3);
                
                jdc_fecha2.setDate(fecha);
                txta_novedad2.setText(novedad);
                
                 JD_Mod_desplazamientos.pack();
                 JD_Mod_desplazamientos.setLocationRelativeTo(null);
                 JD_Mod_desplazamientos.setVisible(true);
                 JD_Mod_desplazamientos.setResizable(false);
     
            }else
            {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla!", "Alerta!", JOptionPane.WARNING_MESSAGE);
            }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void txt_iddespla1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_iddespla1KeyReleased
        // Metodo KeyEvent (Evento presionar la Tecla Shift para el campo txt_iddespla
            if(evt.getKeyCode()== KeyEvent.VK_SHIFT)
            {
                try {
                    jcb_desplazamiento1.removeAllItems();
                    buscarDesplazamiento1();
                } catch (SQLException ex) {
                    Logger.getLogger(JIFCtaCobro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }//GEN-LAST:event_txt_iddespla1KeyReleased

    private void jcb_desplazamiento1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_desplazamiento1ActionPerformed
        if(jcb_desplazamiento1.getSelectedItem()!=null)
        {
            int id;
            int tarifa;

            // ConexionBD conexion=new ConexionBD();
            try {
                String nombre=jcb_desplazamiento1.getSelectedItem().toString();
                ResultSet obj=conexion.executeQuery("SELECT id_desplazamiento,tarifa_despla FROM desplazamientos.desplazamiento WHERE descrip_despla='"+nombre+"'");

                while(obj.next())
                {
                    id=obj.getInt("id_desplazamiento");
                    tarifa=obj.getInt("tarifa_despla");
                    txt_iddespla1.setText("");
                    txt_iddespla1.setText(String.valueOf(id));
                    txt_tarifa2.setText(String.valueOf(tarifa));
                }
                conexion.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(JIFCtaCobro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jcb_desplazamiento1ActionPerformed

    private void btn_aceptar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptar2ActionPerformed
          if(jdc_fecha2.getDate().before(desde) || jdc_fecha2.getDate().after(hasta) )
        {
           JOptionPane.showMessageDialog(null, "La fecha del desplazamiento debe estar dentro del rango.");
        }
        
        else   
        
        
        if(jdc_fecha2.getDate() == null || txt_iddespla1.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Los campos fecha o el ID del desplazamiento estan vacios!" + "* Campos obligatorios" ,"Alerta", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
        
           if(txt_iddespla.getText().matches("[0-9]*"))
            {
        
        
                 int id_des=Integer.parseInt(txt_iddespla1.getText());
                 conexion.executeUpdateQuery("UPDATE viaticos.detalle_cuenta_cobro SET id_desplazamiento="+id_des+" ,novedad='"+txta_novedad2.getText()+"',fecha_despla='"+jdc_fecha2.getDate()+"' WHERE id_detalle_cuenta="+id_tabla+"");
                 conexion.desconectar();
                 JD_Mod_desplazamientos.dispose();
                 LimpiarTabla();
                 txt_iddespla1.setText("");
                 txt_tarifa2.setText("");
                 txta_novedad2.setText("");
                 
        detalleTabla();
            }
           else
           {
                JOptionPane.showMessageDialog(null, " El ID del desplazamiento es un dato numérico!","Alerta", JOptionPane.WARNING_MESSAGE);

           }
        }
    }//GEN-LAST:event_btn_aceptar2ActionPerformed

    private void btn_cancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelar2ActionPerformed
        JD_Mod_desplazamientos.dispose();
    }//GEN-LAST:event_btn_cancelar2ActionPerformed

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
                //  reporte=new ReporteTecnicos_1();
                reporte2=new ReporteTecnicos_1_2();
                //reporte.ejecutarReporte(Integer.parseInt(txt_cta_num.getText()),id_manejoCta);
                reporte2.ejecutarReporte(Integer.parseInt(txt_cta_num.getText()),id_manejoCta);
                dispose();

            }
        }
    }//GEN-LAST:event_btn_terminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog JD_Mod_desplazamientos;
    private javax.swing.JDialog JD_desplazamientos;
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_aceptar2;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_cancelar2;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_terminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JComboBox jcb_desplazamiento;
    private javax.swing.JComboBox jcb_desplazamiento1;
    private javax.swing.JComboBox jcb_tec;
    private com.toedter.calendar.JDateChooser jdc_fecha;
    private com.toedter.calendar.JDateChooser jdc_fecha2;
    private javax.swing.JLabel label_total;
    private javax.swing.JTable tabla_despla;
    private javax.swing.JTextField txt_cta_num;
    private javax.swing.JTextField txt_iddespla;
    private javax.swing.JTextField txt_iddespla1;
    private javax.swing.JTextField txt_tarifa;
    private javax.swing.JTextField txt_tarifa2;
    private javax.swing.JTextField txt_tec;
    private javax.swing.JTextArea txta_novedad;
    private javax.swing.JTextArea txta_novedad2;
    // End of variables declaration//GEN-END:variables

     public void buscarDesplazamiento() throws SQLException
    {
      //  ConexionBD conexion=new ConexionBD();
        
         ResultSet obj=conexion.executeQuery("SELECT descrip_despla FROM desplazamientos.desplazamiento WHERE descrip_despla ilike '%"+txt_iddespla.getText()+"%' ORDER BY descrip_despla");
            
            while(obj.next())
            {
                jcb_desplazamiento.addItem(obj.getObject("descrip_despla"));
            }
            
            conexion.desconectar();
    }
     
        public void buscarDesplazamiento1() throws SQLException
    {
      //  ConexionBD conexion=new ConexionBD();
        
         ResultSet obj=conexion.executeQuery("SELECT descrip_despla FROM desplazamientos.desplazamiento WHERE descrip_despla ilike '%"+txt_iddespla1.getText()+"%' ORDER BY descrip_despla");
            
            while(obj.next())
            {
                jcb_desplazamiento1.addItem(obj.getObject("descrip_despla"));
            }
            
            conexion.desconectar();
    }
    
    
     public void buscarTecnico() throws SQLException
    {
      //  ConexionBD conexion=new ConexionBD();
        
         ResultSet obj=conexion.executeQuery("SELECT nombre_usuario FROM usuarios.usuarios WHERE nombre_usuario ilike '%"+txt_tec.getText()+"%' OR apellido_usuario ilike '%"+txt_tec.getText()+"%' ORDER BY nombre_usuario");
            
            while(obj.next())
            {
                jcb_tec.addItem(obj.getObject("nombre_usuario"));
            }
            
            conexion.desconectar();
    }
     
     
     public void buscarCta()
     {
          try {
          ResultSet obj1=conexion.executeQuery("SELECT id_cuenta_cobro,id_manejo_cta,desde,hasta FROM viaticos.cuenta_cobro WHERE id_usuario="+txt_tec.getText()+ " AND cuenta_generada=false AND cta_aprobada=false");
      
            while(obj1.next())
            {
                id_manejoCta=obj1.getInt("id_manejo_cta");
                ctanumero=obj1.getInt("id_cuenta_cobro");
                desde=obj1.getDate("desde");
                hasta=obj1.getDate("hasta");
                
                txt_cta_num.setText(String.valueOf(ctanumero));
                
            }
         
         ResultSet obj=conexion.executeQuery("SELECT det.id_detalle_cuenta,det.fecha_despla,desp.descrip_despla,det.novedad, desp.tarifa_despla "
                    + "FROM viaticos.detalle_cuenta_cobro det JOIN viaticos.cuenta_cobro cta ON cta.id_manejo_cta=det.id_cuenta_cobro "
                    + "JOIN desplazamientos.desplazamiento desp ON desp.id_desplazamiento=det.id_desplazamiento "
                    + "WHERE cta.cuenta_generada=false AND cta.cta_aprobada=false AND id_usuario="+txt_tec.getText()+""
                    + "ORDER BY det.fecha_despla,det.id_detalle_cuenta ASC");
       
            while (obj.next()) 
             {
             
             Object [] datos = new Object[5];
             
          
             for (int i=0;i<5;i++)
             {
                 datos[i] =obj.getObject(i+1);
             }

              modelo.addRow(datos);
         
             }
        } catch (SQLException ex) {
            Logger.getLogger(JIFCtaCobroMod.class.getName()).log(Level.SEVERE, null, ex);
        }
        
           tabla_despla.setModel(modelo);
           conexion.desconectar();
           sumatoriaTotales();

     }
     
     
       public void LimpiarTabla()
    {
  
        for(int i=modelo.getRowCount()-1;i>=0;i--)
        {
            modelo.removeRow(i);
            
        }
    }
       
//          public void LimpiarTabla_2()
//    {
//  
//        for(int i=modelo2.getRowCount()-1;i>=0;i--)
//        {
//            modelo2.removeRow(i);
//            
//        }
//    }
//       
       
        public void detalleTabla()
        {
       try
        {
            ConexionBD nueva=new ConexionBD();
            
            ResultSet obj=nueva.executeQuery("SELECT det.id_detalle_cuenta,det.fecha_despla,desp.descrip_despla,det.novedad, desp.tarifa_despla "
                    + "FROM viaticos.detalle_cuenta_cobro det JOIN viaticos.cuenta_cobro cta ON cta.id_manejo_cta=det.id_cuenta_cobro "
                    + "JOIN desplazamientos.desplazamiento desp ON desp.id_desplazamiento=det.id_desplazamiento "
                    + "WHERE cta.id_manejo_cta="+id_manejoCta+" AND cta.id_cuenta_cobro="+txt_cta_num.getText()+"  AND id_usuario="+txt_tec.getText()+" "
                    + "ORDER BY det.fecha_despla,det.id_detalle_cuenta ASC");
            
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
           sumatoriaTotales();
           nueva.desconectar();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
       

   }
    
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
    
    public void eliminarRegistroTabla()
    {
         ConexionBD nueva=new ConexionBD();
        
        //Verifica que la fila de la tabla esta seleccionada
        if(tabla_despla.isRowSelected(tabla_despla.getSelectedRow()))
        {
           int row = tabla_despla.getSelectedRow();

        for(int i = 0; i < modelo.getRowCount(); i++)
        {
           nueva.executeUpdateQuery("DELETE FROM viaticos.detalle_cuenta_cobro WHERE id_detalle_cuenta="+modelo.getValueAt(row,0)+" ");
           nueva.desconectar();
        }
         int numRows = tabla_despla.getSelectedRows().length;
         
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
          nueva.desconectar();
    }
    
    
//    
//     public void detalle_otros_cobros()
//    {
//       // ConexionBD nueva=new ConexionBD();
//        
//        
//        ResultSet obj=conexion.executeQuery("SELECT det.id_otros_cobros,det.fecha,det.concepto,det.novedad,det.tarifa "
//                + "FROM viaticos.otros_cobros det JOIN viaticos.cuenta_cobro cta ON det.id_cta_cobro=cta.id_manejo_cta "
//                + "WHERE det.id_cta_cobro="+id_manejoCta+""
//                + "ORDER BY det.fecha ASC");
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
//           
//           tabla_otros_cobros.setModel(modelo2);
//           sumatoriaTotalesOtros();
//           conexion.desconectar();
//       } catch (SQLException ex) {
//           Logger.getLogger(JIFCtaCobro.class.getName()).log(Level.SEVERE, null, ex);
//       }        
//    }
//    
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
    
//     public void sumatoriaTotalesOtros()
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
     
     
//     public void buscarOtrosCobros()
//    {
//       // ConexionBD nueva=new ConexionBD();
//        
//        
//        ResultSet obj=conexion.executeQuery("SELECT det.id_otros_cobros,det.fecha,det.concepto,det.novedad,det.tarifa "
////                + "FROM viaticos.otros_cobros det JOIN viaticos.cuenta_cobro cta ON det.id_cta_cobro=cta.id_manejo_cta "
//                + "WHERE cta.id_usuario="+txt_tec.getText()+" AND cta.cta_aprobada=false AND cta.id_cuenta_cobro="+txt_cta_num.getText()+""
//                + "ORDER BY det.fecha ASC");
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
//        //   modelo2.addRow(datos);
//         
//          }
//           
////           tabla_otros_cobros.setModel(modelo2);
////           sumatoriaTotalesOtros();
//           conexion.desconectar();
//       } catch (SQLException ex) {
//           Logger.getLogger(JIFCtaCobro.class.getName()).log(Level.SEVERE, null, ex);
//       }        
//    }
     
}
