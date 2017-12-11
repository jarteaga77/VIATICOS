
package sistemaviaticosutd.viaticos;

import java.util.Date;

/**
 *
 * @author jarteaga
 */
public class Detalle_Otros_Cobros 
{
    
    
    private String concepto;
    private int tarifa;
    private Date fecha;
    private int id_manejo_cta;
    private String novedad;

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

    public int getId_manejo_cta() {
        return id_manejo_cta;
    }

    public void setId_manejo_cta(int id_manejo_cta) {
        this.id_manejo_cta = id_manejo_cta;
    }

    public String getNovedad() {
        return novedad;
    }

    public void setNovedad(String novedad) {
        this.novedad = novedad;
    }
    
    
   
    
}
