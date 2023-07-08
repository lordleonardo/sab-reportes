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
public class SensoresInstalados {
    private BigDecimal idSensoresInstalados;
    private BigDecimal idEstacionCne;
    private String tipoSensor;
    private Date fechaInstalacion;
    private String fechaSerie;
    private Date fechaMetaDatos;
    private BigDecimal estado;

    public BigDecimal getIdSensoresInstalados() {
        return idSensoresInstalados;
    }

    public void setIdSensoresInstalados(BigDecimal idSensoresInstalados) {
        this.idSensoresInstalados = idSensoresInstalados;
    }

    public BigDecimal getIdEstacionCne() {
        return idEstacionCne;
    }

    public void setIdEstacionCne(BigDecimal idEstacionCne) {
        this.idEstacionCne = idEstacionCne;
    }

    public String getTipoSensor() {
        return tipoSensor;
    }

    public void setTipoSensor(String tipoSensor) {
        this.tipoSensor = tipoSensor;
    }

    public Date getFechaInstalacion() {
        return fechaInstalacion;
    }

    public void setFechaInstalacion(Date fechaInstalacion) {
        this.fechaInstalacion = fechaInstalacion;
    }

    public String getFechaSerie() {
        return fechaSerie;
    }

    public void setFechaSerie(String fechaSerie) {
        this.fechaSerie = fechaSerie;
    }

    public Date getFechaMetaDatos() {
        return fechaMetaDatos;
    }

    public void setFechaMetaDatos(Date fechaMetaDatos) {
        this.fechaMetaDatos = fechaMetaDatos;
    }

    public BigDecimal getEstado() {
        return estado;
    }

    public void setEstado(BigDecimal estado) {
        this.estado = estado;
    }
    
    
}
