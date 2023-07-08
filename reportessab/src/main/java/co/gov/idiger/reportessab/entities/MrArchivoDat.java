/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */

public class MrArchivoDat implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long madId;
    private String madPath;
    private String madNameFile;
    private Date madFechCrea;
    private Date madFechUlti;
    private String madEstado;
    private Date madFechModi;
    private Long madLineProc;
    private String madNombre;
    private String madDireccion;
    private String madTipoGraf;
    private BigDecimal madValorCota;
    private String madTipoEsta;
    private BigDecimal madAlerAmar;
    private BigDecimal madAlerNara;
    private BigDecimal madAlerRoja;
    private Short msgIdAcumll;
    private String madCalcHora;
    private Short msgIdIntens;
    private String madTipoFuente;
    private Short ordenRptLluvias;
    private String humedadTemperatura;
    private Short ordenRptRhb;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "madId")
    private Collection<MrPresipitHora> mrPresipitHoraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "madId")
    private Collection<MrPresipitDia> mrPresipitDiaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "madId")
    private Collection<MrPresipitMinu> mrPresipitMinuCollection;

    public MrArchivoDat() {
    }

    public MrArchivoDat(Long madId) {
        this.madId = madId;
    }

    public MrArchivoDat(Long madId, String madPath, String madNameFile, Date madFechCrea, String madEstado, String madTipoEsta, BigDecimal madAlerAmar, BigDecimal madAlerNara, BigDecimal madAlerRoja) {
        this.madId = madId;
        this.madPath = madPath;
        this.madNameFile = madNameFile;
        this.madFechCrea = madFechCrea;
        this.madEstado = madEstado;
        this.madTipoEsta = madTipoEsta;
        this.madAlerAmar = madAlerAmar;
        this.madAlerNara = madAlerNara;
        this.madAlerRoja = madAlerRoja;
    }

    public Long getMadId() {
        return madId;
    }

    public void setMadId(Long madId) {
        this.madId = madId;
    }

    public String getMadPath() {
        return madPath;
    }

    public void setMadPath(String madPath) {
        this.madPath = madPath;
    }

    public String getMadNameFile() {
        return madNameFile;
    }

    public void setMadNameFile(String madNameFile) {
        this.madNameFile = madNameFile;
    }

    public Date getMadFechCrea() {
        return madFechCrea;
    }

    public void setMadFechCrea(Date madFechCrea) {
        this.madFechCrea = madFechCrea;
    }

    public Date getMadFechUlti() {
        return madFechUlti;
    }

    public void setMadFechUlti(Date madFechUlti) {
        this.madFechUlti = madFechUlti;
    }

    public String getMadEstado() {
        return madEstado;
    }

    public void setMadEstado(String madEstado) {
        this.madEstado = madEstado;
    }

    public Date getMadFechModi() {
        return madFechModi;
    }

    public void setMadFechModi(Date madFechModi) {
        this.madFechModi = madFechModi;
    }

    public Long getMadLineProc() {
        return madLineProc;
    }

    public void setMadLineProc(Long madLineProc) {
        this.madLineProc = madLineProc;
    }

    public String getMadNombre() {
        return madNombre;
    }

    public void setMadNombre(String madNombre) {
        this.madNombre = madNombre;
    }

    public String getMadDireccion() {
        return madDireccion;
    }

    public void setMadDireccion(String madDireccion) {
        this.madDireccion = madDireccion;
    }

    public String getMadTipoGraf() {
        return madTipoGraf;
    }

    public void setMadTipoGraf(String madTipoGraf) {
        this.madTipoGraf = madTipoGraf;
    }

    public BigDecimal getMadValorCota() {
        return madValorCota;
    }

    public void setMadValorCota(BigDecimal madValorCota) {
        this.madValorCota = madValorCota;
    }

    public String getMadTipoEsta() {
        return madTipoEsta;
    }

    public void setMadTipoEsta(String madTipoEsta) {
        this.madTipoEsta = madTipoEsta;
    }

    public BigDecimal getMadAlerAmar() {
        return madAlerAmar;
    }

    public void setMadAlerAmar(BigDecimal madAlerAmar) {
        this.madAlerAmar = madAlerAmar;
    }

    public BigDecimal getMadAlerNara() {
        return madAlerNara;
    }

    public void setMadAlerNara(BigDecimal madAlerNara) {
        this.madAlerNara = madAlerNara;
    }

    public BigDecimal getMadAlerRoja() {
        return madAlerRoja;
    }

    public void setMadAlerRoja(BigDecimal madAlerRoja) {
        this.madAlerRoja = madAlerRoja;
    }

    public Short getMsgIdAcumll() {
        return msgIdAcumll;
    }

    public void setMsgIdAcumll(Short msgIdAcumll) {
        this.msgIdAcumll = msgIdAcumll;
    }

    public String getMadCalcHora() {
        return madCalcHora;
    }

    public void setMadCalcHora(String madCalcHora) {
        this.madCalcHora = madCalcHora;
    }

    public Short getMsgIdIntens() {
        return msgIdIntens;
    }

    public void setMsgIdIntens(Short msgIdIntens) {
        this.msgIdIntens = msgIdIntens;
    }

    public String getMadTipoFuente() {
        return madTipoFuente;
    }

    public void setMadTipoFuente(String madTipoFuente) {
        this.madTipoFuente = madTipoFuente;
    }

    public Short getOrdenRptLluvias() {
        return ordenRptLluvias;
    }

    public void setOrdenRptLluvias(Short ordenRptLluvias) {
        this.ordenRptLluvias = ordenRptLluvias;
    }

    public String getHumedadTemperatura() {
        return humedadTemperatura;
    }

    public void setHumedadTemperatura(String humedadTemperatura) {
        this.humedadTemperatura = humedadTemperatura;
    }

    public Short getOrdenRptRhb() {
        return ordenRptRhb;
    }

    public void setOrdenRptRhb(Short ordenRptRhb) {
        this.ordenRptRhb = ordenRptRhb;
    }

    @XmlTransient
    public Collection<MrPresipitHora> getMrPresipitHoraCollection() {
        return mrPresipitHoraCollection;
    }

    public void setMrPresipitHoraCollection(Collection<MrPresipitHora> mrPresipitHoraCollection) {
        this.mrPresipitHoraCollection = mrPresipitHoraCollection;
    }

    @XmlTransient
    public Collection<MrPresipitDia> getMrPresipitDiaCollection() {
        return mrPresipitDiaCollection;
    }

    public void setMrPresipitDiaCollection(Collection<MrPresipitDia> mrPresipitDiaCollection) {
        this.mrPresipitDiaCollection = mrPresipitDiaCollection;
    }

    @XmlTransient
    public Collection<MrPresipitMinu> getMrPresipitMinuCollection() {
        return mrPresipitMinuCollection;
    }

    public void setMrPresipitMinuCollection(Collection<MrPresipitMinu> mrPresipitMinuCollection) {
        this.mrPresipitMinuCollection = mrPresipitMinuCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (madId != null ? madId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MrArchivoDat)) {
            return false;
        }
        MrArchivoDat other = (MrArchivoDat) object;
        if ((this.madId == null && other.madId != null) || (this.madId != null && !this.madId.equals(other.madId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MrArchivoDat[ madId=" + madId + " ]";
    }
    
}
