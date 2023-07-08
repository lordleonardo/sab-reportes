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
public class MrPresipitDia implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long pdiId;
    private short pdiCodi;
    private short pdiAno;
    private short pdiDia;
    private short pdiHora;
    private BigDecimal pdiMedi;
    private Date pdiFech;
    private String pdiUsuaModi;
    private Date pdiFechModi;
    private MrArchivoDat madId;

    public MrPresipitDia() {
    }

    public MrPresipitDia(Long pdiId) {
        this.pdiId = pdiId;
    }

    public MrPresipitDia(Long pdiId, short pdiCodi, short pdiAno, short pdiDia, short pdiHora, BigDecimal pdiMedi, Date pdiFech) {
        this.pdiId = pdiId;
        this.pdiCodi = pdiCodi;
        this.pdiAno = pdiAno;
        this.pdiDia = pdiDia;
        this.pdiHora = pdiHora;
        this.pdiMedi = pdiMedi;
        this.pdiFech = pdiFech;
    }

    public Long getPdiId() {
        return pdiId;
    }

    public void setPdiId(Long pdiId) {
        this.pdiId = pdiId;
    }

    public short getPdiCodi() {
        return pdiCodi;
    }

    public void setPdiCodi(short pdiCodi) {
        this.pdiCodi = pdiCodi;
    }

    public short getPdiAno() {
        return pdiAno;
    }

    public void setPdiAno(short pdiAno) {
        this.pdiAno = pdiAno;
    }

    public short getPdiDia() {
        return pdiDia;
    }

    public void setPdiDia(short pdiDia) {
        this.pdiDia = pdiDia;
    }

    public short getPdiHora() {
        return pdiHora;
    }

    public void setPdiHora(short pdiHora) {
        this.pdiHora = pdiHora;
    }

    public BigDecimal getPdiMedi() {
        return pdiMedi;
    }

    public void setPdiMedi(BigDecimal pdiMedi) {
        this.pdiMedi = pdiMedi;
    }

    public Date getPdiFech() {
        return pdiFech;
    }

    public void setPdiFech(Date pdiFech) {
        this.pdiFech = pdiFech;
    }

    public String getPdiUsuaModi() {
        return pdiUsuaModi;
    }

    public void setPdiUsuaModi(String pdiUsuaModi) {
        this.pdiUsuaModi = pdiUsuaModi;
    }

    public Date getPdiFechModi() {
        return pdiFechModi;
    }

    public void setPdiFechModi(Date pdiFechModi) {
        this.pdiFechModi = pdiFechModi;
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
        hash += (pdiId != null ? pdiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MrPresipitDia)) {
            return false;
        }
        MrPresipitDia other = (MrPresipitDia) object;
        if ((this.pdiId == null && other.pdiId != null) || (this.pdiId != null && !this.pdiId.equals(other.pdiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MrPresipitDia[ pdiId=" + pdiId + " ]";
    }
    
}
