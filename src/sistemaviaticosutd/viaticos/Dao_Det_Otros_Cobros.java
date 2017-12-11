
package sistemaviaticosutd.viaticos;

import sistemaviaticosutd.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class Dao_Det_Otros_Cobros 
{
    
    private ConexionBD conexion;
    
    
    public void registroOtrosCobros(Detalle_Otros_Cobros oCobros)
    {
        conexion=new ConexionBD();
        
        conexion.executeUpdateQuery("INSERT INTO viaticos.otros_cobros (concepto,tarifa,fecha,id_cta_cobro,novedad)VALUES('"+oCobros.getConcepto()+"', "+oCobros.getTarifa()+", '"+oCobros.getFecha()+"', "+oCobros.getId_manejo_cta()+", '"+oCobros.getNovedad()+"')");
        conexion.desconectar();
        
        
    }
    
    
    
    
    
    
    
    
}
