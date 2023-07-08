/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author USER
 */
public class EstacionesHV implements Serializable {

    private BigDecimal idestacion;
    private BigDecimal idestacioncne;
    private String estacion;
    private String tipo;
    private String codigoCNE;
    private BigDecimal latitud;
    private BigDecimal longitud;
    private String depto;
    private String ciudad;
    private String area;
    private String localidad;
    private String estadoEstacion;
    private String escenarioRiesgo;
    private String lugarMonitoreo;
    private String tipoMonitoreo;
    private String tipoTransmision;
    private String tipoTecnologia;
    private String escala;
    private Date fechaInstalacion;

    public BigDecimal getIdestacion() {
        return idestacion;
    }

    public void setIdestacion(BigDecimal idestacion) {
        this.idestacion = idestacion;
    }

    public String getEstacion() {
        return estacion;
    }

    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigoCNE() {
        return codigoCNE;
    }

    public void setCodigoCNE(String codigoCNE) {
        this.codigoCNE = codigoCNE;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getEstadoEstacion() {
        return estadoEstacion;
    }

    public void setEstadoEstacion(String estadoEstacion) {
        this.estadoEstacion = estadoEstacion;
    }

    public String getEscenarioRiesgo() {
        return escenarioRiesgo;
    }

    public void setEscenarioRiesgo(String escenarioRiesgo) {
        this.escenarioRiesgo = escenarioRiesgo;
    }

    public String getLugarMonitoreo() {
        return lugarMonitoreo;
    }

    public void setLugarMonitoreo(String lugarMonitoreo) {
        this.lugarMonitoreo = lugarMonitoreo;
    }

    public String getTipoMonitoreo() {
        return tipoMonitoreo;
    }

    public void setTipoMonitoreo(String tipoMonitoreo) {
        this.tipoMonitoreo = tipoMonitoreo;
    }

    public String getTipoTransmision() {
        return tipoTransmision;
    }

    public void setTipoTransmision(String tipoTransmision) {
        this.tipoTransmision = tipoTransmision;
    }

    
    public String getTipoTecnologia() {
        return tipoTecnologia;
    }

    public void setTipoTecnologia(String tipoTecnologia) {
        this.tipoTecnologia = tipoTecnologia;
    }

    public String getEscala() {
        return escala;
    }

    public void setEscala(String escala) {
        this.escala = escala;
    }

    public Date getFechaInstalacion() {
        return fechaInstalacion;
    }

    public void setFechaInstalacion(Date fechaInstalacion) {
        this.fechaInstalacion = fechaInstalacion;
    }

    public BigDecimal getIdestacioncne() {
        return idestacioncne;
    }

    public void setIdestacioncne(BigDecimal idestacioncne) {
        this.idestacioncne = idestacioncne;
    }
    
    
     @Override
    public String toString() {
        return getEstacion();
    }

}
