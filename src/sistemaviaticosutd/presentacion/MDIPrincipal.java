
package sistemaviaticosutd.presentacion;

import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import sistemaviaticosutd.conexion.ConexionBD;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author jarteaga
 */
public class MDIPrincipal extends javax.swing.JFrame {

    private JIFCtaCobro ctacobro;
    private JIFCtaCobroMod ctacobromod;
    private JIFAprobacionCtaCobro aprobarcta;
    private JIFReportes reportes;
    private JIFReporteRelGastos reporte_rel;
    private JIFImprimirCtaViaticos imprimir;
    private JIFCtaOtrosCobros ctaotroscobros;
    private JIFCtaOtrosMod ctamodotros;
    private JIFAprobacionCtaOtros aproOtros;
    private JIFImprimirCtaOtrosGastos imprimirOtros;
    private JIFReporte_Otros_Gastos reporte_otros;
    private JIFReporteRelOtrosGas reporte_rel_otros;
    private JIFRegAnticipo regAnticipo;
    private JIFCruceCtas regcruce;
    private JIFReporteConsolidado reporteCon;
           
    
    private static int seccion;
    
    private static Date fecha_ini;
    private static Date fecha_fin;
 
    private static Date fecha_ini1;
    private static Date fecha_fin1;
    
    
    public MDIPrincipal() {
        initComponents();
    }

    @Override
         public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("sistemaviaticosutd/recursos/icono.png"));


        return retValue;
    }
   
     //get Seccion para obtener el ID del usuario del sistema
     public static int getSeccion() {
        return MDIPrincipal.seccion;
    }

     //Set statico para mantener vigente el ID del usuario del sistema
    public static void setSeccion(int seccion) {
        MDIPrincipal.seccion = seccion;
    }
    
    public static Date getfecha_ini()
    {
 
        return MDIPrincipal.fecha_ini;       
    }
    
    public static Date getfecha_fin()
    {
        return MDIPrincipal.fecha_fin;
    }
    
    public static Date getfecha_ini1()
    {
        return MDIPrincipal.fecha_ini1;
    }
    
    public static Date getfecha_fin1()
    {
        return MDIPrincipal.fecha_fin1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JD_Inicio = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jpf_contra = new javax.swing.JPasswordField();
        btn_aceptar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        JD_fecha_corte = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        date_desde = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        date_hasta = new com.toedter.calendar.JDateChooser();
        btn_acep_fecha = new javax.swing.JButton();
        JD_fecha_corte_otros = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        date_desde1 = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        date_hasta1 = new com.toedter.calendar.JDateChooser();
        btn_acep_fecha1 = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        l_usuario = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btn_ctacobro = new javax.swing.JButton();
        btn_modcta = new javax.swing.JButton();
        btn_reg_otros = new javax.swing.JButton();
        btn_mod_otros = new javax.swing.JButton();
        btn_aprobar = new javax.swing.JButton();
        btn_apro_otros = new javax.swing.JButton();
        btn_reportes = new javax.swing.JButton();
        btn_totalOtros = new javax.swing.JButton();
        btn_rel_gast = new javax.swing.JButton();
        btn_relOtros = new javax.swing.JButton();
        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        mi_apr_cta = new javax.swing.JMenuItem();
        menu = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        mi_apro_otros = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        mi_rep_cta = new javax.swing.JMenuItem();
        mi_rep_gas = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        mi_otros_gas = new javax.swing.JMenuItem();
        mi_rel_otros = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();

        JD_Inicio.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        JD_Inicio.setTitle("Inicio de Sesión");
        JD_Inicio.setUndecorated(true);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemaviaticosutd/recursos/inicio.png"))); // NOI18N

        jLabel3.setText("Usuario");

        jLabel5.setText("Contraseña");

        jpf_contra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpf_contraKeyPressed(evt);
            }
        });

        btn_aceptar.setText("Aceptar");
        btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarActionPerformed(evt);
            }
        });

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JD_InicioLayout = new javax.swing.GroupLayout(JD_Inicio.getContentPane());
        JD_Inicio.getContentPane().setLayout(JD_InicioLayout);
        JD_InicioLayout.setHorizontalGroup(
            JD_InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_InicioLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(JD_InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JD_InicioLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(JD_InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JD_InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_usuario)
                            .addComponent(jpf_contra, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)))
                    .addGroup(JD_InicioLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(btn_aceptar)
                        .addGap(56, 56, 56)
                        .addComponent(btn_cancelar)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        JD_InicioLayout.setVerticalGroup(
            JD_InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JD_InicioLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel4)
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(JD_InicioLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(JD_InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(JD_InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jpf_contra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JD_InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_aceptar)
                    .addComponent(btn_cancelar))
                .addGap(38, 38, 38))
        );

        JD_fecha_corte.setTitle("Registro Cuenta de Cobro");

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Periodo Facturado"));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setText("Desde");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setText("Hasta");

        btn_acep_fecha.setText("Aceptar");
        btn_acep_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_acep_fechaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date_desde, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date_hasta, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_acep_fecha)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_acep_fecha)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(date_hasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel12)
                        .addComponent(date_desde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JD_fecha_corteLayout = new javax.swing.GroupLayout(JD_fecha_corte.getContentPane());
        JD_fecha_corte.getContentPane().setLayout(JD_fecha_corteLayout);
        JD_fecha_corteLayout.setHorizontalGroup(
            JD_fecha_corteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JD_fecha_corteLayout.setVerticalGroup(
            JD_fecha_corteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        JD_fecha_corte_otros.setTitle("Registro Cuenta otros Cobros");

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Periodo Facturado"));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setText("Desde");

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setText("Hasta");

        btn_acep_fecha1.setText("Aceptar");
        btn_acep_fecha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_acep_fecha1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date_desde1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date_hasta1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_acep_fecha1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_acep_fecha1)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(date_hasta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)
                        .addComponent(jLabel14)
                        .addComponent(date_desde1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JD_fecha_corte_otrosLayout = new javax.swing.GroupLayout(JD_fecha_corte_otros.getContentPane());
        JD_fecha_corte_otros.getContentPane().setLayout(JD_fecha_corte_otrosLayout);
        JD_fecha_corte_otrosLayout.setHorizontalGroup(
            JD_fecha_corte_otrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JD_fecha_corte_otrosLayout.setVerticalGroup(
            JD_fecha_corte_otrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Liquidación Viaticos UTD");
        setIconImage(getIconImage());

        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Usuario:");
        jToolBar1.add(jLabel1);

        l_usuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        l_usuario.setText("usuario");
        jToolBar1.add(l_usuario);

        jSeparator1.setBackground(new java.awt.Color(31, 24, 17));
        jToolBar1.add(jSeparator1);

        btn_ctacobro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemaviaticosutd/recursos/r_comision.png"))); // NOI18N
        btn_ctacobro.setToolTipText("Registro Cuenta Cobro");
        btn_ctacobro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ctacobro.setFocusable(false);
        btn_ctacobro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_ctacobro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_ctacobro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ctacobroActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_ctacobro);

        btn_modcta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemaviaticosutd/recursos/modificar_cuenta.png"))); // NOI18N
        btn_modcta.setToolTipText("Modificar Cuenta Cobro");
        btn_modcta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_modcta.setFocusable(false);
        btn_modcta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_modcta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_modcta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modctaActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_modcta);

        btn_reg_otros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemaviaticosutd/recursos/pagos.png"))); // NOI18N
        btn_reg_otros.setToolTipText("Reg. Otros Gastos");
        btn_reg_otros.setEnabled(false);
        btn_reg_otros.setFocusable(false);
        btn_reg_otros.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_reg_otros.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_reg_otros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reg_otrosActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_reg_otros);

        btn_mod_otros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemaviaticosutd/recursos/modificar_cuenta_otros .png"))); // NOI18N
        btn_mod_otros.setToolTipText("Mod. Otros Cobros");
        btn_mod_otros.setEnabled(false);
        btn_mod_otros.setFocusable(false);
        btn_mod_otros.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_mod_otros.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_mod_otros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mod_otrosActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_mod_otros);

        btn_aprobar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemaviaticosutd/recursos/aprobar.png"))); // NOI18N
        btn_aprobar.setToolTipText("Aprobar Cta Cobro");
        btn_aprobar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_aprobar.setEnabled(false);
        btn_aprobar.setFocusable(false);
        btn_aprobar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_aprobar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_aprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aprobarActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_aprobar);

        btn_apro_otros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemaviaticosutd/recursos/aprobar1.png"))); // NOI18N
        btn_apro_otros.setToolTipText("Aprobación Otros Cobros");
        btn_apro_otros.setEnabled(false);
        btn_apro_otros.setFocusable(false);
        btn_apro_otros.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_apro_otros.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_apro_otros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_apro_otrosActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_apro_otros);

        btn_reportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemaviaticosutd/recursos/reporte.png"))); // NOI18N
        btn_reportes.setToolTipText("Reporte Consolidado de Ctas.");
        btn_reportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_reportes.setEnabled(false);
        btn_reportes.setFocusable(false);
        btn_reportes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_reportes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reportesActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_reportes);

        btn_totalOtros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemaviaticosutd/recursos/rel_gastos_otros.png"))); // NOI18N
        btn_totalOtros.setToolTipText("Consolidado Ctas. Otros Gastos");
        btn_totalOtros.setEnabled(false);
        btn_totalOtros.setFocusable(false);
        btn_totalOtros.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_totalOtros.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_totalOtros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_totalOtrosActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_totalOtros);

        btn_rel_gast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemaviaticosutd/recursos/rel_gas.png"))); // NOI18N
        btn_rel_gast.setToolTipText("Reporte Relación Gastos Viaticos");
        btn_rel_gast.setEnabled(false);
        btn_rel_gast.setFocusable(false);
        btn_rel_gast.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_rel_gast.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_rel_gast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rel_gastActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_rel_gast);

        btn_relOtros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemaviaticosutd/recursos/rel_gas_otros.png"))); // NOI18N
        btn_relOtros.setToolTipText("Reporte Relación Otros Gastos");
        btn_relOtros.setEnabled(false);
        btn_relOtros.setFocusable(false);
        btn_relOtros.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_relOtros.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_relOtros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_relOtrosActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_relOtros);

        jMenu1.setText("Archivo");

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem7.setText("Salir");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");

        jMenu3.setText("Cta. Viaticos");

        jMenuItem1.setText("Reg. Cta. Viaticos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Mod. Cta. Viaticos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Imprimir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        mi_apr_cta.setText("Aprobación Ctas. Viaticos");
        mi_apr_cta.setEnabled(false);
        mi_apr_cta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_apr_ctaActionPerformed(evt);
            }
        });
        jMenu3.add(mi_apr_cta);

        jMenu2.add(jMenu3);

        menu.setText("Cta. Otros Gastos");

        jMenuItem4.setText("Reg. Cta. Otros Gastos");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menu.add(jMenuItem4);

        jMenuItem5.setText("Mod. Cta. Otros Gastos");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menu.add(jMenuItem5);

        jMenuItem6.setText("Imprimir");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        menu.add(jMenuItem6);

        mi_apro_otros.setText("Aprobación  Ctas. Otros Gastos");
        mi_apro_otros.setEnabled(false);
        mi_apro_otros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_apro_otrosActionPerformed(evt);
            }
        });
        menu.add(mi_apro_otros);

        jMenu2.add(menu);

        jMenu4.setText("Reportes");

        jMenu6.setText("Viaticos");

        mi_rep_cta.setText("Ctas. Viaticos");
        mi_rep_cta.setEnabled(false);
        mi_rep_cta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_rep_ctaActionPerformed(evt);
            }
        });
        jMenu6.add(mi_rep_cta);

        mi_rep_gas.setText("Relación Gastos");
        mi_rep_gas.setEnabled(false);
        mi_rep_gas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_rep_gasActionPerformed(evt);
            }
        });
        jMenu6.add(mi_rep_gas);

        jMenu4.add(jMenu6);

        jMenu7.setText("Otros Gastos");

        mi_otros_gas.setText("Ctas. Otros Gastos");
        mi_otros_gas.setEnabled(false);
        mi_otros_gas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_otros_gasActionPerformed(evt);
            }
        });
        jMenu7.add(mi_otros_gas);

        mi_rel_otros.setText("Relación Gastos");
        mi_rel_otros.setEnabled(false);
        mi_rel_otros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_rel_otrosActionPerformed(evt);
            }
        });
        jMenu7.add(mi_rel_otros);

        jMenu4.add(jMenu7);

        jMenu2.add(jMenu4);

        jMenu5.setText("Anticipos");

        jMenuItem8.setText("Anticipo");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem8);

        jMenu2.add(jMenu5);

        jMenu8.setText("Cruce Ctas.");

        jMenuItem9.setText("Cruce Ctas.");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem9);

        jMenu2.add(jMenu8);

        jMenu9.setText("Resumen Consolidado");

        jMenuItem10.setText("Consolidado Mes");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem10);

        jMenu2.add(jMenu9);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ctacobroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ctacobroActionPerformed
          JD_fecha_corte.pack();
          JD_fecha_corte.setLocationRelativeTo(null);
          JD_fecha_corte.setVisible(true);
          JD_fecha_corte.setResizable(false);
    }//GEN-LAST:event_btn_ctacobroActionPerformed

    private void btn_modctaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modctaActionPerformed
          if(estacerrado(ctacobromod))
      {
       ctacobromod=new JIFCtaCobroMod();
       escritorio.add(ctacobromod);
       ctacobromod.setLocation(250, 0);
       ctacobromod.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_btn_modctaActionPerformed

    private void btn_aprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aprobarActionPerformed
       if(estacerrado(aprobarcta))
      {
       aprobarcta=new JIFAprobacionCtaCobro();
       escritorio.add(aprobarcta);
       aprobarcta.setLocation(250, 0);
       aprobarcta.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_btn_aprobarActionPerformed

    private void btn_reportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportesActionPerformed
         if(estacerrado(reportes))
      {
       reportes=new JIFReportes();
       escritorio.add(reportes);
       reportes.setLocation(250, 0);
       reportes.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_btn_reportesActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
        logueo();
    }//GEN-LAST:event_btn_aceptarActionPerformed

    private void jpf_contraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpf_contraKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            logueo();
        }
    }//GEN-LAST:event_jpf_contraKeyPressed

    private void btn_rel_gastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rel_gastActionPerformed
          if(estacerrado(reporte_rel))
      {
       reporte_rel=new JIFReporteRelGastos();
       escritorio.add(reporte_rel);
       reporte_rel.setLocation(250, 0);
       reporte_rel.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_btn_rel_gastActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void mi_apr_ctaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_apr_ctaActionPerformed
         if(estacerrado(aprobarcta))
      {
       aprobarcta=new JIFAprobacionCtaCobro();
       escritorio.add(aprobarcta);
       aprobarcta.setLocation(250, 0);
       aprobarcta.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_mi_apr_ctaActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if(estacerrado(ctacobromod))
      {
       ctacobromod=new JIFCtaCobroMod();
       escritorio.add(ctacobromod);
       ctacobromod.setLocation(250, 0);
       ctacobromod.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
         if(estacerrado(ctacobro))
      {
       ctacobro=new JIFCtaCobro();
       escritorio.add(ctacobro);
       ctacobro.setLocation(250, 0);
       ctacobro.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void mi_rep_ctaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_rep_ctaActionPerformed
       if(estacerrado(reportes))
      {
       reportes=new JIFReportes();
       escritorio.add(reportes);
       reportes.setLocation(250, 0);
       reportes.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_mi_rep_ctaActionPerformed

    private void mi_rep_gasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_rep_gasActionPerformed
           if(estacerrado(reporte_rel))
      {
       reporte_rel=new JIFReporteRelGastos();
       escritorio.add(reporte_rel);
       reporte_rel.setLocation(250, 0);
       reporte_rel.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_mi_rep_gasActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
         if(estacerrado(imprimir))
      {
       imprimir=new JIFImprimirCtaViaticos();
       escritorio.add(imprimir);
       imprimir.setLocation(250, 0);
       imprimir.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void btn_reg_otrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reg_otrosActionPerformed
    
          JD_fecha_corte_otros.pack();
          JD_fecha_corte_otros.setLocationRelativeTo(null);
          JD_fecha_corte_otros.setVisible(true);
          JD_fecha_corte_otros.setResizable(false);

    }//GEN-LAST:event_btn_reg_otrosActionPerformed

    private void btn_mod_otrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mod_otrosActionPerformed
      if(estacerrado(ctamodotros))
      {
       ctamodotros=new JIFCtaOtrosMod();
       escritorio.add(ctamodotros);
       ctamodotros.setLocation(250, 0);
       ctamodotros.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_btn_mod_otrosActionPerformed

    private void btn_apro_otrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_apro_otrosActionPerformed
        
                
      if(estacerrado(aproOtros))
      {
       aproOtros=new JIFAprobacionCtaOtros();
       escritorio.add(aproOtros);
       aproOtros.setLocation(250, 0);
       aproOtros.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_btn_apro_otrosActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if(estacerrado(ctaotroscobros))
      {
       ctaotroscobros=new JIFCtaOtrosCobros();
       escritorio.add(ctaotroscobros);
       ctaotroscobros.setLocation(250, 0);
       ctaotroscobros.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        if(estacerrado(ctamodotros))
      {
       ctamodotros=new JIFCtaOtrosMod();
       escritorio.add(ctamodotros);
       ctamodotros.setLocation(250, 0);
       ctamodotros.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void mi_apro_otrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_apro_otrosActionPerformed
         if(estacerrado(aproOtros))
      {
       aproOtros=new JIFAprobacionCtaOtros();
       escritorio.add(aproOtros);
       aproOtros.setLocation(250, 0);
       aproOtros.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_mi_apro_otrosActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
       if(estacerrado(imprimirOtros))
      {
       imprimirOtros=new JIFImprimirCtaOtrosGastos();
       escritorio.add(imprimirOtros);
       imprimirOtros.setLocation(250, 0);
       imprimirOtros.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void btn_totalOtrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_totalOtrosActionPerformed
       if(estacerrado(reporte_otros))
      {
       reporte_otros=new JIFReporte_Otros_Gastos();
       escritorio.add(reporte_otros);
       reporte_otros.setLocation(250, 0);
       reporte_otros.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_btn_totalOtrosActionPerformed

    private void mi_otros_gasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_otros_gasActionPerformed
        if(estacerrado(reporte_otros))
      {
       reporte_otros=new JIFReporte_Otros_Gastos();
       escritorio.add(reporte_otros);
       reporte_otros.setLocation(250, 0);
       reporte_otros.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      } 
    }//GEN-LAST:event_mi_otros_gasActionPerformed

    private void btn_relOtrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_relOtrosActionPerformed
        if(estacerrado(reporte_rel_otros))
      {
       reporte_rel_otros=new JIFReporteRelOtrosGas();
       escritorio.add(reporte_rel_otros);
       reporte_rel_otros.setLocation(250, 0);
       reporte_rel_otros.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_btn_relOtrosActionPerformed

    private void mi_rel_otrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_rel_otrosActionPerformed
       if(estacerrado(reporte_rel_otros))
      {
       reporte_rel_otros=new JIFReporteRelOtrosGas();
       escritorio.add(reporte_rel_otros);
       reporte_rel_otros.setLocation(250, 0);
       reporte_rel_otros.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_mi_rel_otrosActionPerformed

    private void btn_acep_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_acep_fechaActionPerformed
        
        fecha_ini=date_desde.getDate();
        fecha_fin=date_hasta.getDate();
        ConexionBD conexion=new ConexionBD();

        
        JIFCtaCobro.setFecha_ini(fecha_ini);
        JIFCtaCobro.setFecha_fin(fecha_fin);
        
        if(fecha_fin.before(fecha_ini)  )
        {
            JOptionPane.showMessageDialog(null, "La fecha Final no debe ser inferior a la Fecha Inicial");
        }
        else
        {
        
        
        ResultSet obj=conexion.executeQuery("SELECT id_manejo_cta FROM viaticos.cuenta_cobro WHERE desde>='"+fecha_ini+"' AND hasta>='"+fecha_fin+"' AND id_usuario="+MDIPrincipal.getSeccion()+"");
        try {
            if(obj.next()==false)
            {
                  if(estacerrado(ctacobro))
          {
           ctacobro=new JIFCtaCobro();
           escritorio.add(ctacobro);
           ctacobro.setLocation(250, 0);
           ctacobro.show();
          }
          else
          {
              JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
          }

            JD_fecha_corte.dispose();
            }else
            {
                JOptionPane.showMessageDialog(this,"No se permite el rango seleccionado", "Error",JOptionPane.ERROR_MESSAGE);

            }
        } catch (SQLException ex) {
            Logger.getLogger(MDIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
      
    }//GEN-LAST:event_btn_acep_fechaActionPerformed

    private void btn_acep_fecha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_acep_fecha1ActionPerformed
      fecha_ini1=date_desde1.getDate();
      fecha_fin1=date_hasta1.getDate();

       JIFCtaOtrosCobros.setFecha_ini(fecha_ini1);
       JIFCtaOtrosCobros.setFecha_fin(fecha_fin1);
        
        
        if(estacerrado(ctaotroscobros))
      {
       ctaotroscobros=new JIFCtaOtrosCobros();
       escritorio.add(ctaotroscobros);
       ctaotroscobros.setLocation(250, 0);
       ctaotroscobros.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
        JD_fecha_corte_otros.dispose();
    }//GEN-LAST:event_btn_acep_fecha1ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
          if(estacerrado(regAnticipo))
      {
       regAnticipo=new JIFRegAnticipo();
       escritorio.add(regAnticipo);
       regAnticipo.setLocation(250, 0);
       regAnticipo.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
            if(estacerrado(regcruce))
      {
       regcruce=new JIFCruceCtas();
       escritorio.add(regcruce);
       regcruce.setLocation(250, 0);
       regcruce.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
      if(estacerrado(reporteCon))
      {
       reporteCon=new JIFReporteConsolidado();
       escritorio.add(reporteCon);
       reporteCon.setLocation(250, 0);
       reporteCon.show();
      }
      else
      {
          JOptionPane.showMessageDialog(this,"La ventana esta abierta", "Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ParseException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
           
         
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;");
                    break;
                }
            }
            
            UIManager.setLookAndFeel(new SyntheticaBlackStarLookAndFeel());
             
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
            MDIPrincipal principal = new MDIPrincipal(); // Inicializa la ventana con los menús de la aplicación
            principal.setLocationRelativeTo(null);
            principal.setVisible(false);//Frame Principal No arranca visible
            principal.setExtendedState(JFrame.MAXIMIZED_BOTH);//Frame toma el tramaño de la resolución de la pantalla
            principal.inicioSeccion();  
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MDIPrincipal().setVisible(false);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog JD_Inicio;
    private javax.swing.JDialog JD_fecha_corte;
    private javax.swing.JDialog JD_fecha_corte_otros;
    private javax.swing.JButton btn_acep_fecha;
    private javax.swing.JButton btn_acep_fecha1;
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_apro_otros;
    private javax.swing.JButton btn_aprobar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_ctacobro;
    private javax.swing.JButton btn_mod_otros;
    private javax.swing.JButton btn_modcta;
    private javax.swing.JButton btn_reg_otros;
    private javax.swing.JButton btn_relOtros;
    private javax.swing.JButton btn_rel_gast;
    private javax.swing.JButton btn_reportes;
    private javax.swing.JButton btn_totalOtros;
    private com.toedter.calendar.JDateChooser date_desde;
    private com.toedter.calendar.JDateChooser date_desde1;
    private com.toedter.calendar.JDateChooser date_hasta;
    private com.toedter.calendar.JDateChooser date_hasta1;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPasswordField jpf_contra;
    private javax.swing.JLabel l_usuario;
    private javax.swing.JMenu menu;
    private javax.swing.JMenuItem mi_apr_cta;
    private javax.swing.JMenuItem mi_apro_otros;
    private javax.swing.JMenuItem mi_otros_gas;
    private javax.swing.JMenuItem mi_rel_otros;
    private javax.swing.JMenuItem mi_rep_cta;
    private javax.swing.JMenuItem mi_rep_gas;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables

      public void inicioSeccion()
    {
        JD_Inicio.pack();
        JD_Inicio.setLocationRelativeTo(null);
        JD_Inicio.setVisible(true);
        JD_Inicio.setResizable(false);
    }
    
        //Metodo para Validar al usuario (usuario y contraseña)
    public void logueo()
    {
        try
        {
            
           String usuario=txt_usuario.getText();
           ConexionBD conexion=new ConexionBD();
           ResultSet oResultSet=conexion.executeQuery("SELECT id_usuario,usuario,clave FROM usuarios.usuarios WHERE usuario='"+usuario+"' AND clave= md5('"+String.valueOf(jpf_contra.getPassword())+"' )AND activo=true");
    
         if(oResultSet.next()==true)
         {
           JD_Inicio.dispose();
           jpf_contra.setText("");
           this.setVisible(true);
     
           int id=oResultSet.getInt("id_usuario");//Se captura el ID del usuario
           String clave=oResultSet.getString("clave");//Se captura la clave del usuario
           String usuarios=oResultSet.getString("usuario");//Se captura el nombre usuario
           
           l_usuario.setText(usuarios);
           //System.out.println(id);
           //Se adiciona la cedula del usuario
           setSeccion(id);
           
           System.out.println(id);
           
           if(id== 11 || id==16)
           {
               btn_reportes.setEnabled(true);
               btn_rel_gast.setEnabled(true);
               btn_aprobar.setEnabled(true);
               btn_apro_otros.setEnabled(true);
               btn_relOtros.setEnabled((true));
               btn_totalOtros.setEnabled(true);
               mi_apro_otros.setEnabled(true);
               mi_otros_gas.setEnabled(true);
               mi_rel_otros.setEnabled(true);          
               mi_rep_gas.setEnabled(true);
               mi_rep_cta.setEnabled(true);
               mi_apr_cta.setEnabled(true);
               
           }
           conexion.desconectar();
          
         }
         else
         {
             jpf_contra.setText("");
             
             JOptionPane.showMessageDialog(null, "Usuario ó Contraseña invalido ó usuario inactivo,  \n Intentelo de nuevo!", "Error", JOptionPane.ERROR_MESSAGE);           
         }
       
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //METODO QUE DEVUELVE UN VALOR BOOLEAN PARA SABER SI UN JINTERNALFRAME ESTA ABIERTO O NO
    private boolean estacerrado(Object obj){
        JInternalFrame[] activos=escritorio.getAllFrames();
        boolean cerrado=true;
        int i=0;
        while (i<activos.length && cerrado){
            if(activos[i]==obj){
		cerrado=false;
            }
            i++;
        }
    return cerrado;
    }

}