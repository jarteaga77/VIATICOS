
package sistemaviaticosutd.viaticos;

import java.sql.ResultSet;
import java.sql.SQLException;
import sistemaviaticosutd.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class DaoViaticos 
{
    
    private ConexionBD conexion=new ConexionBD();
    
    private static int idcta;

    public static int getIdcta() {
        return idcta;
    }

    public static void setIdcta(int idcta) {
        DaoViaticos.idcta = idcta;
    }

    public void guardarViaticos(Viaticos viatico) throws SQLException
    {
        ResultSet obj=conexion.executeQuery("INSERT INTO viaticos.cuenta_cobro (id_cuenta_cobro,fecha_sistema,id_usuario,desde,hasta)VALUES("+viatico.getId_cta_viaticos()+", '"+viatico.getFecha_sistema()+"', "+viatico.getId_usuario()+", '"+viatico.getDesde()+"','"+viatico.getHasta()+"')RETURNING id_manejo_cta");
        
        while(obj.next()==true)
           {
               setIdcta(obj.getInt("id_manejo_cta"));
           }
        
        
        conexion.desconectar();
    }
    
}
