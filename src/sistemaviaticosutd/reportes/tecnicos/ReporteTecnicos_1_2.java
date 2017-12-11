
package sistemaviaticosutd.reportes.tecnicos;


import java.net.URL;
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
public class ReporteTecnicos_1_2 

{
    
  private Conexion nueva=new Conexion();//Variable  de tipo conexion
  //private final String encabezado="/UTDVVCC/recursos/encabezado.png";//Ruta del logo de la empresa
  //private final String pie="/UTDVVCC/recursos/pie.png";
  
  
    public void ejecutarReporte(int  cta, int id_manejo)
    {
        try
        {
        JasperReport reporte;// varible de tipo JasperReport                
//        JasperReport subreporte;
//        JasperReport total;
        JasperPrint reporte_view;// Varible de tipo JasperPrint utilizada para imprimir el reporte
        
        
        URL  in = this.getClass().getResource("/sistemaviaticosutd/reportes/tecnicos/reportectacobro_2.jasper");//Ruta del reporte maestro
//        URL  in1 = this.getClass().getResource("/sistemaviaticosutd/reportes/tecnicos/Otros_cobros.jasper");//Ruta del reporte maestro
//        URL  in2 = this.getClass().getResource("/sistemaviaticosutd/reportes/tecnicos/totalCobros.jasper");//Ruta del reporte maestro

        
        
        reporte = (JasperReport) JRLoader.loadObject( in );//La variable de tipo JasperReport utiliza la clase JRLoadrer y el metodo loadObject y recibe como parametro una varible de tipo url con la ruta del reporte.
//        subreporte=(JasperReport) JRLoader.loadObject(in1);
//        total=(JasperReport)JRLoader.loadObject(in2);
//        
        
         Map parametros = new HashMap();// Mapeo de los parametros
         parametros.clear();//Limpia la varible parametros
         parametros.put("ctanumero",cta);//Nombre del parametro en el reporte y la variable q se le va asignar al parametro
         parametros.put("id_manejo",id_manejo);//Nombre del parametro en el reporte y la variable q se le va asignar al parametro
        // parametros.put("EMPTY_DATASOURCE", new JREmptyDataSource());
//         parametros.put("subreporte", subreporte);
//         parametros.put("total", total);
         
       //  parametros.put("encabezado",this.getClass().getResourceAsStream(encabezado));//Carga la imagen encabezado en el reporte
        // parametros.put("pie",this.getClass().getResourceAsStream(pie));//Carga la imagen pie en el reporte
  
         reporte_view= JasperFillManager.fillReport(reporte, parametros, nueva.getConnection());//impresion del reporte, el metodo fillreport recibe como parametros variable de tipo jasperReport, parametros y la instancia de la conexion con la BD 
         //JasperViewer.viewReport(reporte_view , false );
         JasperViewer jviewer = new JasperViewer(reporte_view,false);//Se carga el reporte
         jviewer.setTitle("Sistema Viaticos UTD - Reporte Individual");
         jviewer.setVisible(true);

         nueva.desconectar();
        
        
        }catch(JRException e)
        {
             System.out.println(e);
        }
    }

  }
 

