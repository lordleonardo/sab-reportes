/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leo
 */
@Entity
@Table(name = "ULTIMOCONSOLIDADO", catalog = "", schema = "SIDISAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UltimoConsolidado.findAll", query = "SELECT u FROM UltimoConsolidado u"),
    @NamedQuery(name = "UltimoConsolidado.findByIdcargo", query = "SELECT u FROM UltimoConsolidado u WHERE u.idUltimoConsolidado = :idUltimoConsolidado"),
    @NamedQuery(name = "UltimoConsolidado.findByCargo", query = "SELECT u FROM UltimoConsolidado u WHERE u.anio = :anio")})
public class UltimoConsolidado implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDULTIMOCONSOLIDADO")
    private BigDecimal idUltimoConsolidado;
    @NotNull
    @Column(name = "ANIO")
    private BigDecimal anio;

    public UltimoConsolidado() {
    }

    public BigDecimal getIdUltimoConsolidado() {
        return idUltimoConsolidado;
    }

    public void setIdUltimoConsolidado(BigDecimal idUltimoConsolidado) {
        this.idUltimoConsolidado = idUltimoConsolidado;
    }

    public BigDecimal getAnio() {
        return anio;
    }

    public void setAnio(BigDecimal anio) {
        this.anio = anio;
    }

}
