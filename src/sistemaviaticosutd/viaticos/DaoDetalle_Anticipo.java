
package sistemaviaticosutd.viaticos;

import sistemaviaticosutd.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class DaoDetalle_Anticipo 
{
    private ConexionBD conexion;
    
    public void regDetalle(Detalle_Anticipo detalle)
    {
        conexion=new ConexionBD();
        conexion.executeUpdateQuery("INSERT INTO anticipos_cruce_ctas.detalle_anticipo(id_usuario,vlor_anticipo,id_anticipo)VALUES("+detalle.getId_usuario()+", "+detalle.getVlor_anticipo()+","+detalle.getId_anticipo()+")");
        conexion.desconectar();
    }

}
