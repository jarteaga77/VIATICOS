package sistemaviaticosutd.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author jarteaga
 * Clase que hace de puente entre el servidor de base de datos y el reporte (JasperReport)
 */
public class Conexion 
{
    
   private final String bd = "SistemaLiquidacionViaticosUTD";
//   private final String bd = "prueba";// Nombre de la base de datos
   private final String login = "postgres";            //Login de la Base de datos
   private final String password = "postgres";         // Clave de la base de datos
//private final String url = "jdbc:postgresql://40.4.5.21:5432/"+bd; 
  //private final String url = "jdbc:postgresql://utdvvcc.sytes.net:40500/"+bd; 
   private final String url = "jdbc:postgresql://192.168.1.128:5432/"+bd;

   private Connection conn = null;
   //private Statement estatuto;
   

   /** Constructor de DbConnection */
   public Conexion() {
      try{
         //obtenemos el driver de para postgres
         Class.forName("org.postgresql.Driver");
         //obtenemos la conexión
         conn = DriverManager.getConnection(url,login,password);
         if (conn!=null){
            System.out.println("Conexión a base de datos "+bd+". listo");
         }
      }catch(Exception e){
         JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
      }
   }
   /**Permite retornar la conexión*/
   public Connection getConnection(){
      return conn;
   }

   public void desconectar(){
        try {
            conn.close();
            //estatuto.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
      
      
      System.out.println("La conexion a la  base de datos "+bd+" a terminado");
   }
    
}
