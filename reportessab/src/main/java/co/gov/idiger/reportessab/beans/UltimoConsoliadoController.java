/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.beans;

import co.gov.idiger.reportessab.entities.UltimoConsolidado;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 * Clase que gestiona UltimoConsolidado
 *
 * @author Leo Montes
 */
@ManagedBean
@SessionScoped
public class UltimoConsoliadoController implements Serializable {

    @EJB
    private co.gov.idiger.reportessab.facade.local.UltimoConsolidadoFacadeLocal ejbFacade;

    private List<UltimoConsolidado> listaUltimoConsolidado = null;
    private UltimoConsolidado ultimoConsolidado = new UltimoConsolidado();

    public UltimoConsolidado prepareCreate() {
        ultimoConsolidado = new UltimoConsolidado();
        listaUltimoConsolidado = null;
        return ultimoConsolidado;
    }

    @PostConstruct
    public void init() {
        ultimoConsolidado = new UltimoConsolidado();
        listaUltimoConsolidado = new ArrayList<>();

    }

    public List<UltimoConsolidado> getListaUltimoConsolidado() {
        listaUltimoConsolidado = ejbFacade.findAll();
        return listaUltimoConsolidado;
    }

    public void setListaUltimoConsolidado(List<UltimoConsolidado> listaUltimoConsolidado) {
        this.listaUltimoConsolidado = listaUltimoConsolidado;
    }

    public UltimoConsolidado getUltimoConsolidado() {
        return ultimoConsolidado;
    }

    public void setUltimoConsolidado(UltimoConsolidado ultimoConsolidado) {
        this.ultimoConsolidado = ultimoConsolidado;
    }

    /**
     * Cargar el actualizar consolidado
     */
    public void abrirGuardarConsolidado() {
        prepareCreate();
        RequestContext.getCurrentInstance().update("ConsolidadosCreateForm");
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("crearConsolidado.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(UltimoConsoliadoController.class.getName()).log(Level.SEVERE, null, ex);
            RequestContext.getCurrentInstance().update("grow2");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error ", ex.getMessage()));
        }
    }

    /**
     * Actualizar el ultimo consolidado
     */
    public void guardarUltimoConsolidado() {

        FacesContext context = FacesContext.getCurrentInstance();
        try {
            if (ultimoConsolidado != null) {
                ultimoConsolidado.setIdUltimoConsolidado(BigDecimal.ONE);
                ejbFacade.edit(ultimoConsolidado);

                RequestContext.getCurrentInstance().update("growlu");
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Los datos se almacenaron con éxito"));
            } else {
                RequestContext.getCurrentInstance().update("growlu");
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Información", "Debe diligenciar los campos obligatorios"));
            }
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("growlu");
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Información", "No se almacenaron los registros " + e.getMessage()));
        }
    }
}
