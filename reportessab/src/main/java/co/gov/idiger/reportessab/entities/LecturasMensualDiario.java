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
 * @author admin
 */
public class LecturasMensualDiario {

    private BigDecimal idsensor;
    private Date fechalectura;
    private BigDecimal minimo;
    private BigDecimal maximo;
    private BigDecimal promedio;
    private BigDecimal acumulado;
    private BigDecimal lecturas;

    public BigDecimal getIdsensor() {
        return idsensor;
    }

    public void setIdsensor(BigDecimal idsensor) {
        this.idsensor = idsensor;
    }

    public Date getFechalectura() {
        return fechalectura;
    }

    public void setFechalectura(Date fechalectura) {
        this.fechalectura = fechalectura;
    }

    public BigDecimal getMinimo() {
        return minimo;
    }

    public void setMinimo(BigDecimal minimo) {
        this.minimo = minimo;
    }

    public BigDecimal getMaximo() {
        return maximo;
    }

    public void setMaximo(BigDecimal maximo) {
        this.maximo = maximo;
    }

    public BigDecimal getPromedio() {
        return promedio;
    }

    public void setPromedio(BigDecimal promedio) {
        this.promedio = promedio;
    }

    public BigDecimal getAcumulado() {
        return acumulado;
    }

    public void setAcumulado(BigDecimal acumulado) {
        this.acumulado = acumulado;
    }

    public BigDecimal getLecturas() {
        return lecturas;
    }

    public void setLecturas(BigDecimal lecturas) {
        this.lecturas = lecturas;
    }

}
