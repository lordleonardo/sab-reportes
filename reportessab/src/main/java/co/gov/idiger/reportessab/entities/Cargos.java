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
 * @author Leo
 */
@Entity
@Table(name = "CARGOS", catalog = "", schema = "SIDISAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargos.findAll", query = "SELECT c FROM Cargos c"),
    @NamedQuery(name = "Cargos.findByIdcargo", query = "SELECT c FROM Cargos c WHERE c.idcargo = :idcargo"),
    @NamedQuery(name = "Cargos.findByCargo", query = "SELECT c FROM Cargos c WHERE c.cargo = :cargo")})
public class Cargos implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCARGO")
    private BigDecimal idcargo;
    @Size(max = 200)
    @Column(name = "CARGO")
    private String cargo;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcargo")
//    private Collection<Personas> personasCollection;

    public Cargos() {
    }

    public Cargos(BigDecimal idcargo) {
        this.idcargo = idcargo;
    }

    public BigDecimal getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(BigDecimal idcargo) {
        this.idcargo = idcargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

//    @XmlTransient
//    public Collection<Personas> getPersonasCollection() {
//        return personasCollection;
//    }
//
//    public void setPersonasCollection(Collection<Personas> personasCollection) {
//        this.personasCollection = personasCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcargo != null ? idcargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargos)) {
            return false;
        }
        Cargos other = (Cargos) object;
        if ((this.idcargo == null && other.idcargo != null) || (this.idcargo != null && !this.idcargo.equals(other.idcargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getCargo();
    }
    
}
