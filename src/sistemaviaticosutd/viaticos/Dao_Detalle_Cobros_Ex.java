
package sistemaviaticosutd.viaticos;

import sistemaviaticosutd.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class Dao_Detalle_Cobros_Ex 
{
    
    private ConexionBD conexion;
    
    
    public void regDetalle(Detalle_Cobros_Ex detalle)
    {   
        
        conexion=new ConexionBD();
        
        conexion.executeUpdateQuery("INSERT INTO viaticos.detalle_cobros_extras(concepto,tarifa,fecha_des,id_cta_cobro, novedad)VALUES('"+detalle.getConcepto()+"', "+detalle.getTarifa()+", '"+detalle.getFecha()+"', "+detalle.getId_cta()+", '"+detalle.getNovedad()+"')");
        conexion.desconectar();

    }
    
    
    
    
    
    
    
}
