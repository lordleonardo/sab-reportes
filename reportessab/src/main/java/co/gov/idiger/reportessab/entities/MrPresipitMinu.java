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
 * @author admin
 */
public class MrPresipitMinu implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long pmiId;
    private short pmiCodi;
    private short pmiAno;
    private short pmiDia;
    private short pmiHora;
    private BigDecimal pmiMedi;
    private Date pmiFech;
    private String pmiUsuaModi;
    private Date pmiFechModi;
    private BigDecimal humedadInterna;
    private BigDecimal humedadExterna;
    private BigDecimal temperaturaInterna;
    private BigDecimal temperaturaExterna;
    private BigDecimal bateria;
    private MrArchivoDat madId;

    public MrPresipitMinu() {
    }

    public MrPresipitMinu(Long pmiId) {
        this.pmiId = pmiId;
    }

    public MrPresipitMinu(Long pmiId, short pmiCodi, short pmiAno, short pmiDia, short pmiHora, BigDecimal pmiMedi, Date pmiFech) {
        this.pmiId = pmiId;
        this.pmiCodi = pmiCodi;
        this.pmiAno = pmiAno;
        this.pmiDia = pmiDia;
        this.pmiHora = pmiHora;
        this.pmiMedi = pmiMedi;
        this.pmiFech = pmiFech;
    }

    public Long getPmiId() {
        return pmiId;
    }

    public void setPmiId(Long pmiId) {
        this.pmiId = pmiId;
    }

    public short getPmiCodi() {
        return pmiCodi;
    }

    public void setPmiCodi(short pmiCodi) {
        this.pmiCodi = pmiCodi;
    }

    public short getPmiAno() {
        return pmiAno;
    }

    public void setPmiAno(short pmiAno) {
        this.pmiAno = pmiAno;
    }

    public short getPmiDia() {
        return pmiDia;
    }

    public void setPmiDia(short pmiDia) {
        this.pmiDia = pmiDia;
    }

    public short getPmiHora() {
        return pmiHora;
    }

    public void setPmiHora(short pmiHora) {
        this.pmiHora = pmiHora;
    }

    public BigDecimal getPmiMedi() {
        return pmiMedi;
    }

    public void setPmiMedi(BigDecimal pmiMedi) {
        this.pmiMedi = pmiMedi;
    }

    public Date getPmiFech() {
        return pmiFech;
    }

    public void setPmiFech(Date pmiFech) {
        this.pmiFech = pmiFech;
    }

    public String getPmiUsuaModi() {
        return pmiUsuaModi;
    }

    public void setPmiUsuaModi(String pmiUsuaModi) {
        this.pmiUsuaModi = pmiUsuaModi;
    }

    public Date getPmiFechModi() {
        return pmiFechModi;
    }

    public void setPmiFechModi(Date pmiFechModi) {
        this.pmiFechModi = pmiFechModi;
    }

    public BigDecimal getHumedadInterna() {
        return humedadInterna;
    }

    public void setHumedadInterna(BigDecimal humedadInterna) {
        this.humedadInterna = humedadInterna;
    }

    public BigDecimal getHumedadExterna() {
        return humedadExterna;
    }

    public void setHumedadExterna(BigDecimal humedadExterna) {
        this.humedadExterna = humedadExterna;
    }

    public BigDecimal getTemperaturaInterna() {
        return temperaturaInterna;
    }

    public void setTemperaturaInterna(BigDecimal temperaturaInterna) {
        this.temperaturaInterna = temperaturaInterna;
    }

    public BigDecimal getTemperaturaExterna() {
        return temperaturaExterna;
    }

    public void setTemperaturaExterna(BigDecimal temperaturaExterna) {
        this.temperaturaExterna = temperaturaExterna;
    }

    public BigDecimal getBateria() {
        return bateria;
    }

    public void setBateria(BigDecimal bateria) {
        this.bateria = bateria;
    }

    public MrArchivoDat getMadId() {
        return madId;
    }

    public void setMadId(MrArchivoDat madId) {
        this.madId = madId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pmiId != null ? pmiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MrPresipitMinu)) {
            return false;
        }
        MrPresipitMinu other = (MrPresipitMinu) object;
        if ((this.pmiId == null && other.pmiId != null) || (this.pmiId != null && !this.pmiId.equals(other.pmiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MrPresipitMinu[ pmiId=" + pmiId + " ]";
    }
    
}
