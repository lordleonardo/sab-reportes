/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.idiger.reportessab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "PERSONAS", catalog = "", schema = "SIDISAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personas.findAll", query = "SELECT p FROM Personas p"),
    @NamedQuery(name = "Personas.findByDocumento", query = "SELECT p FROM Personas p WHERE p.documento = :documento"),
    @NamedQuery(name = "Personas.findByNombres", query = "SELECT p FROM Personas p WHERE p.nombres = :nombres"),
    @NamedQuery(name = "Personas.findByApellidos", query = "SELECT p FROM Personas p WHERE p.apellidos = :apellidos"),
    @NamedQuery(name = "Personas.findByDireccion", query = "SELECT p FROM Personas p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Personas.findByTelefonos", query = "SELECT p FROM Personas p WHERE p.telefonos = :telefonos"),
    @NamedQuery(name = "Personas.findByCorreo", query = "SELECT p FROM Personas p WHERE p.correo = :correo"),
    @NamedQuery(name = "Personas.findByEstado", query = "SELECT p FROM Personas p WHERE p.estado = :estado")})
public class Personas implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOCUMENTO")
    private BigDecimal documento;
    @Size(max = 100)
    @Column(name = "NOMBRES")
    private String nombres;
    @Size(max = 100)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Size(max = 100)
    @Column(name = "DIRECCION")
    private String direccion;
    @Size(max = 100)
    @Column(name = "TELEFONOS")
    private String telefonos;
    @Size(max = 100)
    @Column(name = "CORREO")
    private String correo;
    @Column(name = "ESTADO")
    private BigInteger estado;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personas")
//    private Personasconsejoslocales personasconsejoslocales;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documento")
//    private Collection<Mantenimientos> mantenimientosCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documento")
//    private Collection<Usuarios> usuariosCollection;
    @JoinColumn(name = "IDENTIDAD", referencedColumnName = "IDENTIDAD")
    @ManyToOne(optional = false)
    private Entidades identidad;
    @JoinColumn(name = "IDCARGO", referencedColumnName = "IDCARGO")
    @ManyToOne(optional = false)
    private Cargos idcargo;

    public Personas() {
    }

    public Personas(BigDecimal documento) {
        this.documento = documento;
    }

    public BigDecimal getDocumento() {
        return documento;
    }

    public void setDocumento(BigDecimal documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public BigInteger getEstado() {
        return estado;
    }

    public void setEstado(BigInteger estado) {
        this.estado = estado;
    }

//    public Personasconsejoslocales getPersonasconsejoslocales() {
//        return personasconsejoslocales;
//    }
//
//    public void setPersonasconsejoslocales(Personasconsejoslocales personasconsejoslocales) {
//        this.personasconsejoslocales = personasconsejoslocales;
//    }
//
//    @XmlTransient
//    public Collection<Mantenimientos> getMantenimientosCollection() {
//        return mantenimientosCollection;
//    }
//
//    public void setMantenimientosCollection(Collection<Mantenimientos> mantenimientosCollection) {
//        this.mantenimientosCollection = mantenimientosCollection;
//    }

//    @XmlTransient
//    public Collection<Usuarios> getUsuariosCollection() {
//        return usuariosCollection;
//    }
//
//    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
//        this.usuariosCollection = usuariosCollection;
//    }

    public Entidades getIdentidad() {
        return identidad;
    }

    public void setIdentidad(Entidades identidad) {
        this.identidad = identidad;
    }

    public Cargos getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(Cargos idcargo) {
        this.idcargo = idcargo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documento != null ? documento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personas)) {
            return false;
        }
        Personas other = (Personas) object;
        if ((this.documento == null && other.documento != null) || (this.documento != null && !this.documento.equals(other.documento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  getNombres()+" "+getApellidos();
    }
    
}
