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
import javax.persistence.ManyToMany;
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
@Table(name = "PERFILES", catalog = "", schema = "SIDISAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfiles.findAll", query = "SELECT p FROM Perfiles p"),
    @NamedQuery(name = "Perfiles.findByIdperfil", query = "SELECT p FROM Perfiles p WHERE p.idperfil = :idperfil"),
    @NamedQuery(name = "Perfiles.findByPerfil", query = "SELECT p FROM Perfiles p WHERE p.perfil = :perfil")})
public class Perfiles implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPERFIL")
    private BigDecimal idperfil;
    @Size(max = 100)
    @Column(name = "PERFIL")
    private String perfil;
//    @ManyToMany(mappedBy = "perfilesCollection")
//    private Collection<Opciones> opcionesCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idperfil")
//    private Collection<Usuarios> usuariosCollection;

    public Perfiles() {
    }

    public Perfiles(BigDecimal idperfil) {
        this.idperfil = idperfil;
    }

    public BigDecimal getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(BigDecimal idperfil) {
        this.idperfil = idperfil;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

//    @XmlTransient
//    public Collection<Opciones> getOpcionesCollection() {
//        return opcionesCollection;
//    }
//
//    public void setOpcionesCollection(Collection<Opciones> opcionesCollection) {
//        this.opcionesCollection = opcionesCollection;
//    }

//    @XmlTransient
//    public Collection<Usuarios> getUsuariosCollection() {
//        return usuariosCollection;
//    }
//
//    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
//        this.usuariosCollection = usuariosCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idperfil != null ? idperfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfiles)) {
            return false;
        }
        Perfiles other = (Perfiles) object;
        if ((this.idperfil == null && other.idperfil != null) || (this.idperfil != null && !this.idperfil.equals(other.idperfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getPerfil();
    }
    
}
