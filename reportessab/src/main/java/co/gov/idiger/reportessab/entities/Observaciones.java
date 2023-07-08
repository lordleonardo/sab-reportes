/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.entities;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author USER
 */
public class Observaciones {
    
    private BigDecimal idObservaciones;
    private String observacion;
    private Date fecha;
    private BigDecimal estado;
    private BigDecimal idEstacioncne;

    public BigDecimal getIdObservaciones() {
        return idObservaciones;
    }

    public void setIdObservaciones(BigDecimal idObservaciones) {
        this.idObservaciones = idObservaciones;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

  

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getEstado() {
        return estado;
    }

    public void setEstado(BigDecimal estado) {
        this.estado = estado;
    }

    public BigDecimal getIdEstacioncne() {
        return idEstacioncne;
    }

    public void setIdEstacioncne(BigDecimal idEstacioncne) {
        this.idEstacioncne = idEstacioncne;
    }
    
    
}
