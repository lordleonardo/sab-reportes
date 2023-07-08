/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "LECTURAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lecturas.findAll", query = "SELECT l FROM Lecturas l"),
    @NamedQuery(name = "Lecturas.findByIdlectura", query = "SELECT l FROM Lecturas l WHERE l.idlectura = :idlectura"),
    @NamedQuery(name = "Lecturas.findByFechalectura", query = "SELECT l FROM Lecturas l WHERE l.fechalectura = :fechalectura"),
    @NamedQuery(name = "Lecturas.findByValorlectura", query = "SELECT l FROM Lecturas l WHERE l.valorlectura = :valorlectura"),
    @NamedQuery(name = "Lecturas.findByCodestadolectura", query = "SELECT l FROM Lecturas l WHERE l.codestadolectura = :codestadolectura")})
public class Lecturas implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDLECTURA")
    private BigDecimal idlectura;
    @Column(name = "FECHALECTURA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechalectura;
    @Column(name = "VALORLECTURA")
    private BigDecimal valorlectura;
    @Column(name = "CODESTADOLECTURA")
    private BigInteger codestadolectura;
    @JoinColumn(name = "IDSENSOR", referencedColumnName = "IDSENSOR")
    @ManyToOne(optional = false)
    private Sensores idsensor;

    public Lecturas() {
    }

    public Lecturas(BigDecimal idlectura) {
        this.idlectura = idlectura;
    }

    public BigDecimal getIdlectura() {
        return idlectura;
    }

    public void setIdlectura(BigDecimal idlectura) {
        this.idlectura = idlectura;
    }

    public Date getFechalectura() {
        return fechalectura;
    }

    public void setFechalectura(Date fechalectura) {
        this.fechalectura = fechalectura;
    }

    public BigDecimal getValorlectura() {
        return valorlectura;
    }

    public void setValorlectura(BigDecimal valorlectura) {
        this.valorlectura = valorlectura;
    }

    public BigInteger getCodestadolectura() {
        return codestadolectura;
    }

    public void setCodestadolectura(BigInteger codestadolectura) {
        this.codestadolectura = codestadolectura;
    }

    public Sensores getIdsensor() {
        return idsensor;
    }

    public void setIdsensor(Sensores idsensor) {
        this.idsensor = idsensor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlectura != null ? idlectura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lecturas)) {
            return false;
        }
        Lecturas other = (Lecturas) object;
        if ((this.idlectura == null && other.idlectura != null) || (this.idlectura != null && !this.idlectura.equals(other.idlectura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.idiger.reportessab.entities.Lecturas[ idlectura=" + idlectura + " ]";
    }
    
}
