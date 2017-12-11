
package sistemaviaticosutd.viaticos;

import java.sql.ResultSet;
import java.sql.SQLException;
import sistemaviaticosutd.conexion.ConexionBD;
/**
 *
 * @author jarteaga
 */
public class Dao_OtrosCobros 
{
    
      private ConexionBD conexion=new ConexionBD();
      private static int idcta;

    public static int getIdcta() {
        return idcta;
    }

    public static void setIdcta(int idcta) {
        Dao_OtrosCobros.idcta = idcta;
    }

    public void registroOtrosCobros(OtrosCobros oCobros) throws SQLException
    {
    
        ResultSet obj=conexion.executeQuery("INSERT INTO viaticos.cuenta_otros_cobros(fecha_sistema,id_usuario,id_otros_cobros,desde,hasta)VALUES('"+oCobros.getFecha_sistema()+"',"+oCobros.getId_usuario()+","+oCobros.getControl_otros()+", '"+oCobros.getDesde()+"', '"+oCobros.getHasta()+"')RETURNING id_cta_otros");
      
         while(obj.next()==true)
           {
               setIdcta(obj.getInt("id_cta_otros"));
           }
            conexion.desconectar();
 
    }
    
}
