/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.entities;

/**
 *
 * @author lmontes
 */
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "MAXIMOSMENSUALES", catalog = "", schema = "SIDISAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaximosMensuales.findAll", query = "SELECT e FROM MaximosMensuales e"),
    @NamedQuery(name = "MaximosMensuales.findMax", query = "SELECT MAX(e.idMaximosMensuales) FROM MaximosMensuales e")})
public class MaximosMensuales implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDMAXIMOSMENSUALES")
    private BigDecimal idMaximosMensuales;
    @Size(max = 20)
    @Column(name = "ESTACION")
    private String estacion;
    @JoinColumn(name = "IDSENSOR", referencedColumnName = "IDSENSOR")
    @ManyToOne(optional = false)
    private Sensores sensores;
    @Column(name = "ENERO")
    private Double enero;
    @Column(name = "FEBRERO")
    private Double febrero;
    @Column(name = "MARZO")
    private Double marzo;
    @Column(name = "ABRIL")
    private Double abril;
    @Column(name = "MAYO")
    private Double mayo;
    @Column(name = "JUNIO")
    private Double junio;
    @Column(name = "JULIO")
    private Double julio;
    @Column(name = "AGOSTO")
    private Double agosto;
    @Column(name = "SEPTIEMBRE")
    private Double septiembre;
    @Column(name = "OCTUBRE")
    private Double octubre;
    @Column(name = "NOVIEMBRE")
    private Double noviembre;
    @Column(name = "DICIEMBRE")
    private Double diciembre;
    @Column(name = "ANUAL")
    private Double anual;
   

    public MaximosMensuales() {
    }

    public Double getFebrero() {
        return febrero;
    }

    public void setFebrero(Double febrero) {
        this.febrero = febrero;
    }

    public BigDecimal getIdMaximosMensuales() {
        return idMaximosMensuales;
    }

    public void setIdMaximosMensuales(BigDecimal idMaximosMensuales) {
        this.idMaximosMensuales = idMaximosMensuales;
    }

    public BigDecimal getIdPromedioMensuales() {
        return idMaximosMensuales;
    }

  
    public String getEstacion() {
        return estacion;
    }

    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }

    public Sensores getSensores() {
        return sensores;
    }

    public void setSensores(Sensores sensores) {
        this.sensores = sensores;
    }

    public Double getEnero() {
        return enero;
    }

    public void setEnero(Double enero) {
        this.enero = enero;
    }

    public Double getMarzo() {
        return marzo;
    }

    public void setMarzo(Double marzo) {
        this.marzo = marzo;
    }

    public Double getAbril() {
        return abril;
    }

    public void setAbril(Double abril) {
        this.abril = abril;
    }

    public Double getMayo() {
        return mayo;
    }

    public void setMayo(Double mayo) {
        this.mayo = mayo;
    }

    public Double getJunio() {
        return junio;
    }

    public void setJunio(Double junio) {
        this.junio = junio;
    }

    public Double getJulio() {
        return julio;
    }

    public void setJulio(Double julio) {
        this.julio = julio;
    }

    public Double getAgosto() {
        return agosto;
    }

    public void setAgosto(Double agosto) {
        this.agosto = agosto;
    }

    public Double getSeptiembre() {
        return septiembre;
    }

    public void setSeptiembre(Double septiembre) {
        this.septiembre = septiembre;
    }

    public Double getOctubre() {
        return octubre;
    }

    public void setOctubre(Double octubre) {
        this.octubre = octubre;
    }

    public Double getNoviembre() {
        return noviembre;
    }

    public void setNoviembre(Double noviembre) {
        this.noviembre = noviembre;
    }

    public Double getDiciembre() {
        return diciembre;
    }

    public void setDiciembre(Double diciembre) {
        this.diciembre = diciembre;
    }

    public Double getAnual() {
        return anual;
    }

    public void setAnual(Double anual) {
        this.anual = anual;
    }

   

}
