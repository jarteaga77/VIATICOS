
package sistemaviaticosutd.reportes.generales;


import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import sistemaviaticosutd.conexion.Conexion;


/**
 *
 * @author jarteaga
 */
public class ReporteTotalCtas1 

{
    
  private Conexion nueva=new Conexion();//Variable  de tipo conexion
  //private final String encabezado="/UTDVVCC/recursos/encabezado.png";//Ruta del logo de la empresa
  //private final String pie="/UTDVVCC/recursos/pie.png";
  
  
    public void ejecutarReporte(Date fecha_ini, Date fecha_fin)
    {
        try
        {
        JasperReport reporte;// varible de tipo JasperReport  
        JasperReport subreporte;
        JasperReport otros_cobros;
        JasperReport total_cobros;
     
        JasperPrint reporte_view;// Varible de tipo JasperPrint utilizada para imprimir el reporte
        
        URL  in = this.getClass().getResource("/sistemaviaticosutd/reportes/generales/reportecta_1.jasper");//Ruta del reporte maestro
        reporte = (JasperReport) JRLoader.loadObject( in );//La variable de tipo JasperReport utiliza la clase JRLoadrer y el metodo loadObject y recibe como parametro una varible de tipo url con la ruta del reporte.
        URL  in1 = this.getClass().getResource("/sistemaviaticosutd/reportes/generales/detalle_viaticos.jasper");//Ruta del reporte maestro
        subreporte = (JasperReport) JRLoader.loadObject( in1 );//La variable de tipo JasperReport utiliza la clase JRLoadrer y el metodo loadObject y recibe como parametro una varible de tipo url con la ruta del reporte.
        URL  in2 = this.getClass().getResource("/sistemaviaticosutd/reportes/generales/Otros_cobros.jasper");//Ruta del reporte maestro
        otros_cobros = (JasperReport) JRLoader.loadObject( in2 );//La variable de tipo JasperReport utiliza la clase JRLoadrer y el metodo loadObject y recibe como parametro una varible de tipo url con la ruta del reporte.
        URL  in3 = this.getClass().getResource("/sistemaviaticosutd/reportes/generales/totalCobros.jasper");//Ruta del reporte maestro
        total_cobros = (JasperReport) JRLoader.loadObject( in3 );//La variable de tipo JasperReport utiliza la clase JRLoadrer y el metodo loadObject y recibe como parametro una varible de tipo url con la ruta del reporte.

         Map parametros = new HashMap();// Mapeo de los parametros
         parametros.clear();//Limpia la varible parametros
         parametros.put("fecha_ini",fecha_ini);//Nombre del parametro en el reporte y la variable q se le va asignar al parametro
         parametros.put("fecha_fin",fecha_fin);//Nombre del parametro en el reporte y la variable q se le va asignar al parametro
         parametros.put("subreporte",subreporte);
         parametros.put("otros_costos",otros_cobros);
         parametros.put("total_cobros",total_cobros);
         //parametros.put("encabezado",this.getClass().getResourceAsStream(encabezado));//Carga la imagen encabezado en el reporte
         // parametros.put("pie",this.getClass().getResourceAsStream(pie));//Carga la imagen pie en el reporte
  
         reporte_view= JasperFillManager.fillReport(reporte, parametros, nueva.getConnection());//impresion del reporte, el metodo fillreport recibe como parametros variable de tipo jasperReport, parametros y la instancia de la conexion con la BD 
         //JasperViewer.viewReport(reporte_view , false );
         JasperViewer jviewer = new JasperViewer(reporte_view,false);//Se carga el reporte
         jviewer.setTitle("Sistema Viaticos UTD - Reporte Ctas Viaticos - Otros Cobros");
         jviewer.setVisible(true);

         nueva.desconectar();
        
        
        }catch(JRException e)
        {
             System.out.println(e);
        }
    }
 
}
