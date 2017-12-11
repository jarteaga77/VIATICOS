
package sistemaviaticosutd.viaticos;

import java.util.Date;

/**
 *
 * @author jarteaga
 */
public class Viaticos 
{
    
    
    private Date fecha_sistema;
    private int id_usuario;
    private boolean ctagenerada;
    private int id_cta_viaticos;
    private boolean ctaaprobada;
    private Date desde;
    private Date hasta;

//    public Viaticos(Date fecha_sistema, int id_usuario, int id_cta_viaticos) {
//        this.fecha_sistema = fecha_sistema;
//        this.id_usuario = id_usuario;
//        this.id_cta_viaticos = id_cta_viaticos;
//    }

    public Date getFecha_sistema() {
        return fecha_sistema;
    }

    public void setFecha_sistema(Date fecha_sistema) {
        this.fecha_sistema = fecha_sistema;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public boolean isCtagenerada() {
        return ctagenerada;
    }

    public void setCtagenerada(boolean ctagenerada) {
        this.ctagenerada = ctagenerada;
    }

    public int getId_cta_viaticos() {
        return id_cta_viaticos;
    }

    public void setId_cta_viaticos(int id_cta_viaticos) {
        this.id_cta_viaticos = id_cta_viaticos;
    }

    public boolean isCtaaprobada() {
        return ctaaprobada;
    }

    public void setCtaaprobada(boolean ctaaprobada) {
        this.ctaaprobada = ctaaprobada;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }
    
    
    
    
    
}
