
package sistemaviaticosutd.viaticos;

import sistemaviaticosutd.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class DaoDetCruceCtas {
    
    private ConexionBD conexion;
    
    
    public void regDetalleCruce(Detalle_Cruce_Ctas detalle)
    {
        conexion=new ConexionBD();
        conexion.executeUpdateQuery("INSERT INTO anticipos_cruce_ctas.detalle_cruce_ctas(cta_relacionada,vlor_total_cta,id_cruce_ctas,fecha)VALUES("+detalle.getCta_relacionada()+", "+detalle.getVlor_cta()+","+detalle.getId_cruce_cta()+", '"+detalle.getFecha()+"')");
        conexion.desconectar();
        
    }
    
}
