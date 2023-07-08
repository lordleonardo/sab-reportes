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
@Table(name = "ENTIDADES", catalog = "", schema = "SIDISAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entidades.findAll", query = "SELECT e FROM Entidades e"),
    @NamedQuery(name = "Entidades.findByIdentidad", query = "SELECT e FROM Entidades e WHERE e.identidad = :identidad"),
    @NamedQuery(name = "Entidades.findByEntidad", query = "SELECT e FROM Entidades e WHERE e.entidad = :entidad")})
public class Entidades implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDENTIDAD")
    private BigDecimal identidad;
    @Size(max = 200)
    @Column(name = "ENTIDAD")
    private String entidad;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "identidad")
//    private Collection<Personas> personasCollection;

    public Entidades() {
    }

    public Entidades(BigDecimal identidad) {
        this.identidad = identidad;
    }

    public BigDecimal getIdentidad() {
        return identidad;
    }

    public void setIdentidad(BigDecimal identidad) {
        this.identidad = identidad;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
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
        hash += (identidad != null ? identidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entidades)) {
            return false;
        }
        Entidades other = (Entidades) object;
        if ((this.identidad == null && other.identidad != null) || (this.identidad != null && !this.identidad.equals(other.identidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getEntidad();
    }
    
}
