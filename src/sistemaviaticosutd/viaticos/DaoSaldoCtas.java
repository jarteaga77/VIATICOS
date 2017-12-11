
package sistemaviaticosutd.viaticos;

import sistemaviaticosutd.conexion.ConexionBD;

/**
 *
 * @author jarteaga
 */
public class DaoSaldoCtas 
{
    private ConexionBD conexion;
    
    
    public void regSaldoCtas(Saldo_Ctas saldo)
    {
        conexion.executeUpdateQuery("INSERT INTO anticipos_cruce_ctas.saldo_ctas (vlor_saldo,a_favor,en_contra,id_usuario,id_cruce_cta)"
                + "VALUES("+saldo.getVlor_saldo()+","+saldo.isA_favor()+","+saldo.isEn_contra()+", "+saldo.getId_usuario()+", "+saldo.getId_crucecta()+")");
    
        conexion.desconectar();
    }
    
}
