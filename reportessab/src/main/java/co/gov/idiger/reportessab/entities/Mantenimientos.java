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
public class Mantenimientos {

    private BigDecimal idMantenimiento;
    private BigDecimal idEstacionCNE;
    private BigDecimal documento;
    private BigDecimal idtipoMantenimiento;
    private Date fechaInicio;
    private Date fechaFin;
    private String descripcion;
    private String ubicacion;
    private String url;

    public BigDecimal getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(BigDecimal idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public BigDecimal getIdEstacionCNE() {
        return idEstacionCNE;
    }

    public void setIdEstacionCNE(BigDecimal idEstacionCNE) {
        this.idEstacionCNE = idEstacionCNE;
    }

    public BigDecimal getDocumento() {
        return documento;
    }

    public void setDocumento(BigDecimal documento) {
        this.documento = documento;
    }

    public BigDecimal getIdtipoMantenimiento() {
        return idtipoMantenimiento;
    }

    public void setIdtipoMantenimiento(BigDecimal idtipoMantenimiento) {
        this.idtipoMantenimiento = idtipoMantenimiento;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    

}
