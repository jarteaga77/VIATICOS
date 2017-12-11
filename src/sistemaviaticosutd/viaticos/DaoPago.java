
package sistemaviaticosutd.viaticos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemaviaticosutd.conexion.ConexionBD;
import static sistemaviaticosutd.viaticos.DaoCruceCtas.setIdcruce;

/**
 *
 * @author jarteaga
 */
public class DaoPago 
{
    
    private ConexionBD conexion;
    
    
      private static int id_pago;

    public static int getId_pago() {
        return id_pago;
    }

    public static void setId_pago(int id_pago) {
        DaoPago.id_pago = id_pago;
    }

  
    public void regPago(Pago pago)
    {
       ResultSet obj= conexion.executeQuery("INSERT INTO anticipos_cruce_ctas.pagos (total_causado,vlor_anticipo,saldo,id_cruce_ctas)VALUES("+pago.getTotal_causado()+","+pago.getTotal_anticipo()+","+pago.getSaldo()+", "+pago.getId_cruce_ctas()+")RETURNING id_pago");
        
       try {
            while(obj.next()==true)
             {
                 setIdcruce(obj.getInt("id_pago"));
             }
        } catch (SQLException ex) {
            Logger.getLogger(DaoPago.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       conexion.desconectar();
    }
    
    
    
    
    
}
