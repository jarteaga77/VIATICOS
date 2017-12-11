/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaviaticosutd.viaticos;

import java.util.Date;

/**
 *
 * @author jarteaga
 */
public class OtrosCobros 
{
    
    private Date fecha_sistema, desde,hasta;
    private int id_usuario, control_otros;
    private boolean cta_aprobada;

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

    public int getControl_otros() {
        return control_otros;
    }

    public void setControl_otros(int control_otros) {
        this.control_otros = control_otros;
    }

    public boolean isCta_aprobada() {
        return cta_aprobada;
    }

    public void setCta_aprobada(boolean cta_aprobada) {
        this.cta_aprobada = cta_aprobada;
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
