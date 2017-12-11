
package sistemaviaticosutd.viaticos;

/**
 *
 * @author jarteaga
 */
public class Pago 
{
    private int id_cruce_ctas;
    private int total_causado;
    private int total_anticipo;
    private int saldo;

    public int getId_cruce_ctas() {
        return id_cruce_ctas;
    }

    public void setId_cruce_ctas(int id_cruce_ctas) {
        this.id_cruce_ctas = id_cruce_ctas;
    }

    public int getTotal_causado() {
        return total_causado;
    }

    public void setTotal_causado(int total_causado) {
        this.total_causado = total_causado;
    }

    public int getTotal_anticipo() {
        return total_anticipo;
    }

    public void setTotal_anticipo(int total_anticipo) {
        this.total_anticipo = total_anticipo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    
    
    
}
