package sistemaviaticosutd.viaticos;

import java.sql.ResultSet;
import java.sql.SQLException;
import sistemaviaticosutd.conexion.ConexionBD;

    
    
    
    
    
    
/**
 *
 * @author jarteaga
 */
public class DaoDetalle_Viaticos 
{
   private ConexionBD conexion=new ConexionBD();
   
    public void guardarDetalle(Detalle_Viaticos detalle) throws SQLException
    {
      
            conexion.executeUpdateQuery("INSERT INTO viaticos.detalle_cuenta_cobro(id_desplazamiento,novedad,id_cuenta_cobro,fecha_despla)VALUES("+detalle.getId_desplaza()+", '"+detalle.getNovedad()+"', "+detalle.getId_manejo_acta()+", '"+detalle.getFecha_despla()+"')");
   
          
            conexion.desconectar();
            
            //JOptionPane.showMessageDialog(null,"Se registro con exito la orden de compra");
            
       
    }   
  
}
