/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "TIPOSSENSORES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipossensores.findAll", query = "SELECT t FROM Tipossensores t"),
    @NamedQuery(name = "Tipossensores.findByIdtiposensor", query = "SELECT t FROM Tipossensores t WHERE t.idtiposensor = :idtiposensor"),
    @NamedQuery(name = "Tipossensores.findByTiposensor", query = "SELECT t FROM Tipossensores t WHERE t.tiposensor = :tiposensor"),
    @NamedQuery(name = "Tipossensores.findByUnidadmedida", query = "SELECT t FROM Tipossensores t WHERE t.unidadmedida = :unidadmedida")})
public class Tipossensores implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTIPOSENSOR")
    private BigDecimal idtiposensor;
    @Size(max = 100)
    @Column(name = "TIPOSENSOR")
    private String tiposensor;
    @Size(max = 20)
    @Column(name = "UNIDADMEDIDA")
    private String unidadmedida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtiposensor")
    private Collection<Sensores> sensoresCollection;

    public Tipossensores() {
    }

    public Tipossensores(BigDecimal idtiposensor) {
        this.idtiposensor = idtiposensor;
    }

    public BigDecimal getIdtiposensor() {
        return idtiposensor;
    }

    public void setIdtiposensor(BigDecimal idtiposensor) {
        this.idtiposensor = idtiposensor;
    }

    public String getTiposensor() {
        return tiposensor;
    }

    public void setTiposensor(String tiposensor) {
        this.tiposensor = tiposensor;
    }

    public String getUnidadmedida() {
        return unidadmedida;
    }

    public void setUnidadmedida(String unidadmedida) {
        this.unidadmedida = unidadmedida;
    }

    @XmlTransient
    public Collection<Sensores> getSensoresCollection() {
        return sensoresCollection;
    }

    public void setSensoresCollection(Collection<Sensores> sensoresCollection) {
        this.sensoresCollection = sensoresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtiposensor != null ? idtiposensor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipossensores)) {
            return false;
        }
        Tipossensores other = (Tipossensores) object;
        if ((this.idtiposensor == null && other.idtiposensor != null) || (this.idtiposensor != null && !this.idtiposensor.equals(other.idtiposensor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.idiger.reportessab.entities.Tipossensores[ idtiposensor=" + idtiposensor + " ]";
    }
    
}
