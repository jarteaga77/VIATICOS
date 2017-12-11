
package sistemaviaticosutd.viaticos;

import java.util.Date;

/**
 *
 * @author jarteaga
 */
public class Detalle_Viaticos 
{
    
    private int id_desplaza;
    private String novedad;
    private int id_ctacobro;
    private Date fecha_despla;
    private int id_manejo_acta;
    private int valor;

//    public Detalle_Viaticos(int id_desplaza, String novedad, Date fecha_despla, int valor) {
//        this.id_desplaza = id_desplaza;
//        this.novedad = novedad;
//        this.fecha_despla = fecha_despla;
//        this.valor = valor;
//    }

    
    

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    

    public int getId_desplaza() {
        return id_desplaza;
    }

    public void setId_desplaza(int id_desplaza) {
        this.id_desplaza = id_desplaza;
    }

    public String getNovedad() {
        return novedad;
    }

    public void setNovedad(String novedad) {
        this.novedad = novedad;
    }

    public int getId_ctacobro() {
        return id_ctacobro;
    }

    public void setId_ctacobro(int id_ctacobro) {
        this.id_ctacobro = id_ctacobro;
    }

    public Date getFecha_despla() {
        return fecha_despla;
    }

    public void setFecha_despla(Date fecha_despla) {
        this.fecha_despla = fecha_despla;
    }

    public int getId_manejo_acta() {
        return id_manejo_acta;
    }

    public void setId_manejo_acta(int id_manejo_acta) {
        this.id_manejo_acta = id_manejo_acta;
    }
    
    

}
