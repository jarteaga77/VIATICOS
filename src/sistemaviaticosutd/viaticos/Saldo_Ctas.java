
package sistemaviaticosutd.viaticos;

/**
 *
 * @author jarteaga
 */
public class Saldo_Ctas 
{
    
    
    private boolean a_favor;
    private boolean en_contra;
    private int id_usuario;
    private int id_crucecta;
    private int vlor_saldo;

    public boolean isA_favor() {
        return a_favor;
    }

    public void setA_favor(boolean a_favor) {
        this.a_favor = a_favor;
    }

    public boolean isEn_contra() {
        return en_contra;
    }

    public void setEn_contra(boolean en_contra) {
        this.en_contra = en_contra;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_crucecta() {
        return id_crucecta;
    }

    public void setId_crucecta(int id_crucecta) {
        this.id_crucecta = id_crucecta;
    }

    public int getVlor_saldo() {
        return vlor_saldo;
    }

    public void setVlor_saldo(int vlor_saldo) {
        this.vlor_saldo = vlor_saldo;
    }
    
    
    
    
}
