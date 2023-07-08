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
public class MrPresipitHora implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long phoId;
    private short phoCodi;
    private short phoAno;
    private short phoDia;
    private short phoHora;
    private BigDecimal phoMedi;
    private Date phoFech;
    private String phoUsuaModi;
    private Date phoFechModi;
    private MrArchivoDat madId;

    public MrPresipitHora() {
    }

    public MrPresipitHora(Long phoId) {
        this.phoId = phoId;
    }

    public MrPresipitHora(Long phoId, short phoCodi, short phoAno, short phoDia, short phoHora, BigDecimal phoMedi, Date phoFech) {
        this.phoId = phoId;
        this.phoCodi = phoCodi;
        this.phoAno = phoAno;
        this.phoDia = phoDia;
        this.phoHora = phoHora;
        this.phoMedi = phoMedi;
        this.phoFech = phoFech;
    }

    public Long getPhoId() {
        return phoId;
    }

    public void setPhoId(Long phoId) {
        this.phoId = phoId;
    }

    public short getPhoCodi() {
        return phoCodi;
    }

    public void setPhoCodi(short phoCodi) {
        this.phoCodi = phoCodi;
    }

    public short getPhoAno() {
        return phoAno;
    }

    public void setPhoAno(short phoAno) {
        this.phoAno = phoAno;
    }

    public short getPhoDia() {
        return phoDia;
    }

    public void setPhoDia(short phoDia) {
        this.phoDia = phoDia;
    }

    public short getPhoHora() {
        return phoHora;
    }

    public void setPhoHora(short phoHora) {
        this.phoHora = phoHora;
    }

    public BigDecimal getPhoMedi() {
        return phoMedi;
    }

    public void setPhoMedi(BigDecimal phoMedi) {
        this.phoMedi = phoMedi;
    }

    public Date getPhoFech() {
        return phoFech;
    }

    public void setPhoFech(Date phoFech) {
        this.phoFech = phoFech;
    }

    public String getPhoUsuaModi() {
        return phoUsuaModi;
    }

    public void setPhoUsuaModi(String phoUsuaModi) {
        this.phoUsuaModi = phoUsuaModi;
    }

    public Date getPhoFechModi() {
        return phoFechModi;
    }

    public void setPhoFechModi(Date phoFechModi) {
        this.phoFechModi = phoFechModi;
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
        hash += (phoId != null ? phoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MrPresipitHora)) {
            return false;
        }
        MrPresipitHora other = (MrPresipitHora) object;
        if ((this.phoId == null && other.phoId != null) || (this.phoId != null && !this.phoId.equals(other.phoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MrPresipitHora[ phoId=" + phoId + " ]";
    }
    
}
