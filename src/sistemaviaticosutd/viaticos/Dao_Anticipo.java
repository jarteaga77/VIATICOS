
package sistemaviaticosutd.viaticos;

import sistemaviaticosutd.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class Dao_Anticipo 
{
    private ConexionBD conexion;
    
    public void registrar(Anticipos anticipo)
    {
        
        conexion=new ConexionBD();
        
        conexion.executeUpdateQuery("INSERT INTO anticipos_cruce_ctas.anticipo(fecha_anticipo,oficio_anticipo,id_mes,id_anio)VALUES('"+anticipo.getAnti_fecha()+"','"+anticipo.getAnti_oficio()+"' , "+anticipo.getMes()+", "+anticipo.getAnio()+" )");
        conexion.desconectar();
    }
    
}
