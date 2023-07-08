/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.entities;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author USER
 */
public class UmbralesNivelesRes implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigDecimal idNiveles;
    private String estacion;

    public BigDecimal getIdNiveles() {
        return idNiveles;
    }

    public void setIdNiveles(BigDecimal idNiveles) {
        this.idNiveles = idNiveles;
    }

    public String getEstacion() {
        return estacion;
    }

    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }

    @Override
    public String toString() {
        return getEstacion();
    }
    
    
 

   
}
