
package sistemaviaticosutd.presentacion;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistemaviaticosutd.conexion.ConexionBD;
import sistemaviaticosutd.reportes.tecnicos.ReporteTecnicos_1_2;
import sistemaviaticosutd.viaticos.DaoDetalle_Viaticos;
import sistemaviaticosutd.viaticos.DaoViaticos;
import sistemaviaticosutd.viaticos.Dao_Detalle_Cobros_Ex;
import sistemaviaticosutd.viaticos.Detalle_Cobros_Ex;
import sistemaviaticosutd.viaticos.Detalle_Viaticos;
import sistemaviaticosutd.viaticos.Viaticos;

/**
 *
 * @author jarteaga
 */
public class JIFCtaCobro extends javax.swing.JInternalFrame {
    
    
   private int consecutivo = 0;
   ConexionBD conexion=new ConexionBD(); //Objeto de tipo ConexionBD para conexion base de datos
   private int id_usuario=MDIPrincipal.getSeccion();/// Variable de inicio de seccion
   private DefaultTableModel modelo;// Modelo de tabla 1    
   private DefaultTableModel modelo2;// Modelo de tablas 2
   private int id, id_tabla;
   private static Date fecha_ini;
   private static Date fecha_fin;
   SimpleDateFormat formato = new SimpleDateFormat ("yyyy/MM/dd"); 
   
   
   private Viaticos viatico; // Objeto de Tipo Viaticos
   private Detalle_Viaticos detalle;// Objeto de tipo Detalle_Viaticos
   private DaoViaticos daovia;// DaoViaticos Objeto para transación
   private DaoDetalle_Viaticos daodetalle;// DaoDetalle_Viaticos Objeto para transación
  // private ReporteTecnicos_1 reporte; // Objeto tipo ReporteTecnicos_1
   private ReporteTecnicos_1_2 reporte2; // Objeto tipo ReporteTecnicos_1_2
   private Detalle_Cobros_Ex detalle_ex;
   private Dao_Detalle_Cobros_Ex daoEx;

  

    public JIFCtaCobro() {
        initComponents();
        
        modelo=new DefaultTableModel();
        modelo2=new DefaultTableModel();
        
     //Consulta para traer el consecutivo que el sistema asigna a la cuenta.
        ResultSet obj=conexion.executeQuery("SELECT (control_cosnsecutivo +1) AS consecutivo FROM usuarios.usuarios WHERE id_usuario="+id_usuario+" ");
        try {
            if(obj.next()==true)
            {
                consecutivo=obj.getInt("consecutivo");
                txt_idcta.setText(String.valueOf(consecutivo));
                conexion.desconectar();
           
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFCtaCobro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Modelo Inicial de las tablas
        
        //Tabla 1 (Desplazamientos)
        modelo.addColumn("ID");
        modelo.addColumn("Fecha");
        modelo.addColumn("Desplazamiento");
        modelo.addColumn("Novedad");
        modelo.addColumn("Valor");
        
       // Tabla 2 (Otros cobros)
        modelo2.addColumn("ID");
        modelo2.addColumn("Fecha");
        modelo2.addColumn("Concepto");
        modelo2.addColumn("Novedad");
        modelo2.addColumn("Valor");
   
    }

    public static Date getFecha_ini() {
        return fecha_ini;
    }

    public static void setFecha_ini(Date fecha_ini) {
        JIFCtaCobro.fecha_ini = fecha_ini;
    }

    public static Date getFecha_fin() {
        return fecha_fin;
    }
    
    
    public static void setFecha_fin(Date fecha_fin) {
        JIFCtaCobro.fecha_fin = fecha_fin;
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
        jLabel6 = new javax.swing.JLabel();
        txt_tarifa = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cb_replica = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        JD_Mod_desplazamientos = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jdc_fecha1 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        txt_iddespla1 = new javax.swing.JTextField();
        jcb_desplazamiento1 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txta_novedad1 = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btn_aceptar1 = new javax.swing.JButton();
        btn_cancelar1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
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
        btn_mod = new javax.swing.JButton();
        label_total = new javax.swing.JLabel();
        btn_terminar = new javax.swing.JButton();

        JD_desplazamientos.setTitle("Desplazamientos...");

        jdc_fecha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Fecha *");

        txt_iddespla.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_iddespla.setToolTipText("Iniciales de la estación + la tecla Shift");
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

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Tarifa $");

        txt_tarifa.setEditable(false);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Cantidad a Replicar el Desplazamiento *");

        cb_replica.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        cb_replica.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_aceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_cancelar))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_tarifa, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(3, 3, 3)
                                        .addComponent(jdc_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(4, 4, 4)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_iddespla, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcb_desplazamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_replica, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
                    .addComponent(jdc_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_tarifa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cb_replica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelar)
                    .addComponent(btn_aceptar))
                .addContainerGap())
        );

        javax.swing.GroupLayout JD_desplazamientosLayout = new javax.swing.GroupLayout(JD_desplazamientos.getContentPane());
        JD_desplazamientos.getContentPane().setLayout(JD_desplazamientosLayout);
        JD_desplazamientosLayout.setHorizontalGroup(
            JD_desplazamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_desplazamientosLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        JD_desplazamientosLayout.setVerticalGroup(
            JD_desplazamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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

        JD_Mod_desplazamientos.setTitle("Desplazamientos...");

        jdc_fecha1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Fecha *");

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

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Novedad:");

        txta_novedad1.setColumns(20);
        txta_novedad1.setRows(5);
        jScrollPane4.setViewportView(txta_novedad1);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Desplazamiento *");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(238, 13, 13));
        jLabel10.setText("*  Campos Obligatorios");

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

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Tarifa $");

        txt_tarifa1.setEditable(false);

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
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_tarifa1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(3, 3, 3)
                                .addComponent(jdc_fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(4, 4, 4)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_iddespla1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcb_desplazamiento1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_aceptar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_cancelar1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel10)
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
                        .addComponent(jLabel9))
                    .addComponent(jdc_fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(11, 11, 11)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_tarifa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_cancelar1)
                            .addComponent(btn_aceptar1)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
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
        setTitle("Registro Cuenta Cobro");

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

        btn_mod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemaviaticosutd/recursos/mod_detalle.png"))); // NOI18N
        btn_mod.setPreferredSize(new java.awt.Dimension(32, 32));
        btn_mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(btn_agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_mod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btn_agregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_eliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_mod, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        label_total.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        label_total.setText("Total $ 0,0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label_total, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
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
                .addGap(5, 5, 5)
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
        //Crea el JDialog Hijo de JIFCtaCobro    
        
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        JD_desplazamientos.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void txt_iddesplaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_iddesplaKeyReleased
        // Metodo KeyEvent (Evento presionar la Tecla Shift para el campo txt_iddespla  
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

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
   
    try {
                Calendar c1=jdc_fecha.getCalendar();
  
        if(jdc_fecha.getDate().before(fecha_ini) || jdc_fecha.getDate().after(fecha_fin) )
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
      
            int replica=(int) cb_replica.getSelectedIndex();
          
            for(int i=0; i<=replica; i++)
          {
              
              System.out.println(i);
              
          if(txt_iddespla.getText().matches("[0-9]*"))
          {
    
            detalle=new Detalle_Viaticos();
            daodetalle=new DaoDetalle_Viaticos();
            viatico=new Viaticos();
            ConexionBD conexion=new ConexionBD();
            daovia=new DaoViaticos();
     
   
        ResultSet obj=conexion.executeQuery("SELECT id_cuenta_cobro FROM viaticos.cuenta_cobro WHERE id_cuenta_cobro="+txt_idcta.getText()+" AND id_usuario="+id_usuario+" AND cta_aprobada=false  ");
       
           if(obj.next()==false)
           {
     
                  //int con_cta=0;
               
             viatico.setId_cta_viaticos(consecutivo);
             viatico.setFecha_sistema(new Date());
             viatico.setId_usuario(id_usuario);
             fecha_ini= MDIPrincipal.getfecha_ini();
             fecha_fin=MDIPrincipal.getfecha_fin();
             viatico.setDesde(fecha_ini);
             viatico.setHasta(fecha_fin);
       
             daovia.guardarViaticos(viatico);
             
             id=DaoViaticos.getIdcta();
            
        
        //obtiene el ultimo consecutivo de la actas de cobro
//        ResultSet obj1=conexion.executeQuery("SELECT MAX(id_cuenta_cobro)AS consecutivo FROM viaticos.cuenta_cobro WHERE id_usuario="+id_usuario+"");
//      
//           if(obj1.next()==true)
//           {
//              con_cta=obj1.getInt("consecutivo");
//               System.out.print(con_cta);
//           }
           //Actualiza el control de los consecutivos
            conexion.executeUpdateQuery("UPDATE usuarios.usuarios SET control_cosnsecutivo="+txt_idcta.getText()+" WHERE id_usuario="+id_usuario+"");
            conexion.desconectar();
       
            //Detalle cuenta de cobro
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

                 detalle.setId_manejo_acta(id);  
                 
                 //Date increFecha=jdc_fecha.getDate();
 
                 detalle.setFecha_despla(c1.getTime());
                 detalle.setId_desplaza(Integer.parseInt(txt_iddespla.getText()));
                 detalle.setNovedad(txta_novedad.getText());
 
                 daodetalle.guardarDetalle(detalle);
                
                 LimpiarTabla();
                 detalleTabla();
                 sumatoriaTotales();
                 
//                 txt_iddespla.setText("");
//                 txt_tarifa.setText("");
//                 txta_novedad.setText("");
                 
               }
           }
           else
           {
    
              detalle.setId_manejo_acta(id); 
              detalle.setFecha_despla(c1.getTime());
              detalle.setId_desplaza(Integer.parseInt(txt_iddespla.getText()));
              detalle.setNovedad(txta_novedad.getText());

              daodetalle.guardarDetalle(detalle);
              LimpiarTabla();
              detalleTabla();
              sumatoriaTotales();
              
//               txt_iddespla.setText("");
//               txt_tarifa.setText("");
//               txta_novedad.setText("");
 
           }
   
         }
      else //detalle cuenta de cobro
           {
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
                   
                   
                 detalle.setId_manejo_acta(DaoViaticos.getIdcta());         
                 detalle.setFecha_despla(c1.getTime());
                 detalle.setId_desplaza(Integer.parseInt(txt_iddespla.getText()));
                 detalle.setNovedad(txta_novedad.getText());
 
                 daodetalle.guardarDetalle(detalle);
                
                 LimpiarTabla();
                 detalleTabla();
                 sumatoriaTotales();
                 
//                 txt_iddespla.setText("");
//                 txt_tarifa.setText("");
//                 txta_novedad.setText("");

                 
                 
               }
           }
           else
           {
               
              detalle.setId_manejo_acta(DaoViaticos.getIdcta()); 
              detalle.setFecha_despla(c1.getTime());
              detalle.setId_desplaza(Integer.parseInt(txt_iddespla.getText()));
              detalle.setNovedad(txta_novedad.getText());

              daodetalle.guardarDetalle(detalle);
              LimpiarTabla();
              detalleTabla();
              sumatoriaTotales();
              
//               txt_iddespla.setText("");
//               txt_tarifa.setText("");
//               txta_novedad.setText("");
               
           }
  
           }
        
           conexion.desconectar();
      
     }
           else
           {
             JOptionPane.showMessageDialog(null, " El ID del desplazamiento es un dato numérico!","Alerta", JOptionPane.WARNING_MESSAGE);
           }
          
          c1.add(Calendar.DATE,1);
          
        }
      
       }
         } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
       }

    }//GEN-LAST:event_btn_aceptarActionPerformed

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
            reporte2=new ReporteTecnicos_1_2();
         //   reporte.ejecutarReporte(Integer.parseInt(txt_idcta.getText()),id);
            reporte2.ejecutarReporte(Integer.parseInt(txt_idcta.getText()),id);

           dispose();
           
        }
       }  
    }//GEN-LAST:event_btn_terminarActionPerformed

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
                    txt_tarifa1.setText(String.valueOf(tarifa));
                }
                conexion.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(JIFCtaCobro.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
    }//GEN-LAST:event_jcb_desplazamiento1ActionPerformed

    private void btn_aceptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptar1ActionPerformed

          if(jdc_fecha1.getDate().before(fecha_ini) || jdc_fecha1.getDate().after(fecha_fin) )
        {
           JOptionPane.showMessageDialog(null, "La fecha del desplazamiento debe estar dentro del rango.");
        }
        
        else
        if(jdc_fecha1.getDate() == null || txt_iddespla1.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Los campos fecha o el ID del desplazamiento estan vacios!" + "* Campos obligatorios" ,"Alerta", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
        
           if(txt_iddespla1.getText().matches("[0-9]*"))
            {
        
        
        
            int id_des=Integer.parseInt( txt_iddespla1.getText()); 
            conexion.executeUpdateQuery("UPDATE viaticos.detalle_cuenta_cobro SET id_desplazamiento="+id_des+" ,novedad='"+txta_novedad1.getText()+"', fecha_despla='"+jdc_fecha1.getDate()+"' WHERE id_detalle_cuenta="+id_tabla+"");
            conexion.desconectar();
            JD_Mod_desplazamientos.dispose();
            LimpiarTabla();
            detalleTabla();
       
        
       }else
           {
             JOptionPane.showMessageDialog(null, " El ID del desplazamiento es un dato numérico!","Alerta", JOptionPane.WARNING_MESSAGE);
           }
               
     }
       
    }//GEN-LAST:event_btn_aceptar1ActionPerformed

    private void btn_cancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelar1ActionPerformed
        JD_Mod_desplazamientos.dispose();
    }//GEN-LAST:event_btn_cancelar1ActionPerformed

    private void btn_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modActionPerformed
         
          Date fecha;
          String novedad;
        
        if(tabla_despla.isRowSelected(tabla_despla.getSelectedRow()))
            {
                id_tabla = (Integer) tabla_despla.getValueAt(tabla_despla.getSelectedRow(), 0);    
                fecha=(Date) tabla_despla.getValueAt(tabla_despla.getSelectedRow(), 1);
                novedad=(String) tabla_despla.getValueAt(tabla_despla.getSelectedRow(), 3);
                
                jdc_fecha1.setDate(fecha);
                txta_novedad1.setText(novedad);
                
                 JD_Mod_desplazamientos.pack();
                 JD_Mod_desplazamientos.setLocationRelativeTo(null);
                 JD_Mod_desplazamientos.setVisible(true);
                 JD_Mod_desplazamientos.setResizable(false);
     
            }else
            {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla!", "Alerta!", JOptionPane.WARNING_MESSAGE);
            }
       
         
    }//GEN-LAST:event_btn_modActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog JD_Mod_desplazamientos;
    private javax.swing.JDialog JD_desplazamientos;
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_aceptar1;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_cancelar1;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_mod;
    private javax.swing.JButton btn_terminar;
    private javax.swing.JComboBox cb_replica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox jcb_desplazamiento;
    private javax.swing.JComboBox jcb_desplazamiento1;
    private com.toedter.calendar.JDateChooser jdc_fecha;
    private com.toedter.calendar.JDateChooser jdc_fecha1;
    private javax.swing.JLabel label_total;
    private javax.swing.JTable tabla_despla;
    private javax.swing.JTextField txt_idcta;
    private javax.swing.JTextField txt_iddespla;
    private javax.swing.JTextField txt_iddespla1;
    private javax.swing.JTextField txt_tarifa;
    private javax.swing.JTextField txt_tarifa1;
    private javax.swing.JTextArea txta_novedad;
    private javax.swing.JTextArea txta_novedad1;
    // End of variables declaration//GEN-END:variables

    //Metodo para buscar los desplazamientos, llenandolos en un JComboBox
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
    
      //Metodo para buscar los desplazamientos, llenandolos en un JComboBox
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
    
    
     public void LimpiarTabla()
    {
  
        for(int i=modelo.getRowCount()-1;i>=0;i--)
        {
            modelo.removeRow(i);
            
        }
    }
     
         public void LimpiarTabla_2()
    {
  
        for(int i=modelo2.getRowCount()-1;i>=0;i--)
        {
            modelo2.removeRow(i);
            
        }
    }
       // Metodo para llenar la tabla detalle
       public void detalleTabla()
        {
       try
        {
            ConexionBD nueva=new ConexionBD();
            
//            ResultSet obj=nueva.executeQuery("SELECT det.id_detalle,det.fecha_des,det.concepto,det.tarifa,det.novedad "
//                    + "FROM viaticos.detalle_cobros_extras det JOIN viaticos.cuenta_cobro cta ON cta.id_manejo_cta=det.id_cta_cobro "
//                    + "WHERE cta.id_manejo_cta="+id+" AND id_usuario="+id_usuario+" "
//                    + "ORDER BY det.fecha_des,det.id_detalle ASC");
            
           ResultSet obj=nueva.executeQuery("SELECT det.id_detalle_cuenta,det.fecha_despla,desp.descrip_despla,det.novedad, desp.tarifa_despla "
                    + "FROM viaticos.detalle_cuenta_cobro det JOIN viaticos.cuenta_cobro cta ON cta.id_manejo_cta=det.id_cuenta_cobro "
                    + "JOIN desplazamientos.desplazamiento desp ON desp.id_desplazamiento=det.id_desplazamiento "
                    + "WHERE cta.id_manejo_cta="+id+" AND id_usuario="+id_usuario+" "
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
           nueva.desconectar();
           sumatoriaTotales();

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
         // nueva.desconectar(); 
          LimpiarTabla();
          detalleTabla();  
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
