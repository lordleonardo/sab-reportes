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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "UMBRALESNIVELES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UmbralesNiveles.findAll", query = "SELECT e FROM UmbralesNiveles e")})
public class UmbralesNiveles implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDUMBRALES")
    private BigDecimal idUmbrales;
    @Size(max = 100)
    @NotNull
    @Column(name = "IDNIVELES")
    private BigDecimal idNiveles;
    @Column(name = "NIVELALTO")
    private BigDecimal nivelAlto;
    @Column(name = "NIVELMEDIO")
    private BigDecimal nivelMedio;
    @Column(name = "NIVELBAJO")
    private BigDecimal nivelBajo;
    @Column(name = "FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @NotNull
    @Column(name = "IDUSUARIO")

    private BigDecimal idUsuario;

    public UmbralesNiveles() {
    }

    public BigDecimal getIdUmbrales() {
        return idUmbrales;
    }

    public void setIdUmbrales(BigDecimal idUmbrales) {
        this.idUmbrales = idUmbrales;
    }

    public BigDecimal getIdNiveles() {
        return idNiveles;
    }

    public void setIdNiveles(BigDecimal idNiveles) {
        this.idNiveles = idNiveles;
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public BigDecimal getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }

}
