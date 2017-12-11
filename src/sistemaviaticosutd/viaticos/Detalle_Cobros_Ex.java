
package sistemaviaticosutd.viaticos;

import java.util.Date;

/**
 *
 * @author jarteaga
 */
public class Detalle_Cobros_Ex 
{
    
    
    private String concepto;
    private int tarifa;
    private Date fecha;
    private String novedad;
    private int id_cta;

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId_cta() {
        return id_cta;
    }

    public void setId_cta(int id_cta) {
        this.id_cta = id_cta;
    }

    public String getNovedad() {
        return novedad;
    }

    public void setNovedad(String novedad) {
        this.novedad = novedad;
    }
    
    
    
}
