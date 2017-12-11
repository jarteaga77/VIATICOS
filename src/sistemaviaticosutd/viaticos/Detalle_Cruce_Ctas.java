
package sistemaviaticosutd.viaticos;

import java.util.Date;

/**
 *
 * @author jarteaga
 */
public class Detalle_Cruce_Ctas 

{
    
    private int id_cruce_cta;
    private String cta_relacionada;
    private int vlor_cta;
    private Date fecha;

    public int getId_cruce_cta() {
        return id_cruce_cta;
    }

    public void setId_cruce_cta(int id_cruce_cta) {
        this.id_cruce_cta = id_cruce_cta;
    }

    public String getCta_relacionada() {
        return cta_relacionada;
    }

    public void setCta_relacionada(String cta_relacionada) {
        this.cta_relacionada= cta_relacionada;
    }

    public int getVlor_cta() {
        return vlor_cta;
    }

    public void setVlor_cta(int vlor_cta) {
        this.vlor_cta = vlor_cta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

   

   

}
