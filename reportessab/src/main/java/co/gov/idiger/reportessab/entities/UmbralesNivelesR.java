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

public class UmbralesNivelesR implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigDecimal id;
    private String estacion;
    private BigDecimal nivelAlto;
    private BigDecimal nivelMedio;
    private BigDecimal nivelBajo;
    

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getEstacion() {
        return estacion;
    }

    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }

    public BigDecimal getNivelAlto() {
        return nivelAlto;
    }

    public void setNivelAlto(BigDecimal nivelAlto) {
        this.nivelAlto = nivelAlto;
    }

    public BigDecimal getNivelMedio() {
        return nivelMedio;
    }

    public void setNivelMedio(BigDecimal nivelMedio) {
        this.nivelMedio = nivelMedio;
    }

    public BigDecimal getNivelBajo() {
        return nivelBajo;
    }

    public void setNivelBajo(BigDecimal nivelBajo) {
        this.nivelBajo = nivelBajo;
    }
    
    


    
}
