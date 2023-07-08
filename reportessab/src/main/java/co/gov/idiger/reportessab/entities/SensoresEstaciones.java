/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.entities;

import java.math.BigDecimal;

/**
 *
 * @author admin
 */
public class SensoresEstaciones {

    private BigDecimal idSensor;
    private String tipoSensor;
    private BigDecimal idtipoSensor;
    private BigDecimal latitud;
    private BigDecimal longitud;
    private BigDecimal estado;
    private BigDecimal visible;
    private String unidadmedida;
    private String estacion;
    private BigDecimal idestacion;

    public BigDecimal getVisible() {
        return visible;
    }

    public void setVisible(BigDecimal visible) {
        this.visible = visible;
    }

    public BigDecimal getIdestacion() {
        return idestacion;
    }

    public void setIdestacion(BigDecimal idestacion) {
        this.idestacion = idestacion;
    }

    public String getUnidadmedida() {
        return unidadmedida;
    }

    public void setUnidadmedida(String unidadmedida) {
        this.unidadmedida = unidadmedida;
    }

    public String getEstacion() {
        return estacion;
    }

    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }

    public BigDecimal getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(BigDecimal idSensor) {
        this.idSensor = idSensor;
    }

    public BigDecimal getIdtipoSensor() {
        return idtipoSensor;
    }

    public void setIdtipoSensor(BigDecimal idtipoSensor) {
        this.idtipoSensor = idtipoSensor;
    }

    public BigDecimal getEstado() {
        return estado;
    }

    public void setEstado(BigDecimal estado) {
        this.estado = estado;
    }

    public String getTipoSensor() {
        return tipoSensor;
    }

    public void setTipoSensor(String tipoSensor) {
        this.tipoSensor = tipoSensor;
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

    @Override
    public String toString() {
        return getTipoSensor();
    }

}
