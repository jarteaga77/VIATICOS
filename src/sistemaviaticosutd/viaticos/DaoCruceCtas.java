
package sistemaviaticosutd.viaticos;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import sistemaviaticosutd.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class DaoCruceCtas 

{
    
    private ConexionBD conexion;
    
    
    private static int idcruce;

    public static int getIdcruce() {
        return idcruce;
    }

    public static void setIdcruce(int idcruce) {
        DaoCruceCtas.idcruce = idcruce;
    }

    public void regCruceCtas(cruce_ctas cruce)
    {
        
        conexion=new ConexionBD();
       try {
        ResultSet obj=conexion.executeQuery("INSERT INTO anticipos_cruce_ctas.cruce_ctas(id_anticipo,id_usuario,fecha_cruce)"
                + "VALUES("+cruce.getId_anticipo()+","+cruce.getId_usuario()+",'"+cruce.getFecha()+"')RETURNING id_cruce_ctas");
      
            while(obj.next()==true)
             {
                 setIdcruce(obj.getInt("id_cruce_ctas"));
             }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    
        conexion.desconectar();
    }
}
