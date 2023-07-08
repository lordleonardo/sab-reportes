/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.beans;

import co.gov.idiger.reportessab.entities.Estaciones;
import co.gov.idiger.reportessab.entities.Nivelesvalores;
import co.gov.idiger.reportessab.entities.Sensores;
import co.gov.idiger.reportessab.entities.UmbralesNiveles;
import co.gov.idiger.reportessab.entities.UmbralesNivelesR;
import co.gov.idiger.reportessab.entities.UmbralesNivelesRes;
import co.gov.idiger.reportessab.entities.Usuarios;
import co.gov.idiger.reportessab.facade.local.UmbralesNivelesFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.eclipse.persistence.internal.sessions.ArrayRecord;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

/**
 * Clase que gestiona Niveles
 *
 * @author Leo Montes
 */
@ManagedBean
@SessionScoped
public class NivelesController implements Serializable {

    @EJB
    private co.gov.idiger.reportessab.facade.local.EstacionesFacadeLocal ejbFacade;

    @EJB
    private UmbralesNivelesFacadeLocal ejbFacadeUmbrales;

    private List<Estaciones> listaEstacionesNivel = null;
    private Estaciones estaciones = null;
    private UmbralesNivelesR umbralesNivelesR = new UmbralesNivelesR();
    private UmbralesNivelesRes umbralesNivelesRes = new UmbralesNivelesRes();
    private UmbralesNiveles umbralesNiveles = new UmbralesNiveles();
    private List<Nivelesvalores> listaNivelesvalores = null;
    private Nivelesvalores nivelesvalores = null;
    private List listaUmbralesNivel = null;
    private List listaEstacionesUmbrales = null;
    private List<UmbralesNivelesR> listaUmbrales = null;
    private List<UmbralesNivelesRes> listaIdNivelUmbrales = null;
    private String idNivel;
    private DataTable tabla;

    public List<UmbralesNivelesR> getListaUmbrales() {
        if (listaUmbrales == null) {
            getUmbrales();
        }
        return listaUmbrales;
    }

    public void setListaUmbrales(List<UmbralesNivelesR> listaUmbrales) {
        this.listaUmbrales = listaUmbrales;
    }

    public List<Estaciones> getListaEstacionesNivel() {
        if (listaEstacionesNivel == null) {
            listaEstacionesNivel = ejbFacade.getEstacionesNiveles();
        }
        return listaEstacionesNivel;
    }

    public void setListaEstacionesNivel(List<Estaciones> listaEstacionesNivel) {
        this.listaEstacionesNivel = listaEstacionesNivel;
    }

    public UmbralesNivelesR getUmbralesNivelesR() {
        return umbralesNivelesR;
    }

    public void setUmbralesNivelesR(UmbralesNivelesR umbralesNivelesR) {
        this.umbralesNivelesR = umbralesNivelesR;
    }

    public Estaciones getEstaciones() {
        return estaciones;
    }

    public void setEstaciones(Estaciones estaciones) {
        this.estaciones = estaciones;
    }

    public String getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(String idNivel) {
        this.idNivel = idNivel;
    }

    public List<UmbralesNivelesRes> getListaIdNivelUmbrales() {
        return listaIdNivelUmbrales;
    }

    public void setListaIdNivelUmbrales(List<UmbralesNivelesRes> listaIdNivelUmbrales) {
        this.listaIdNivelUmbrales = listaIdNivelUmbrales;
    }

    public UmbralesNiveles getUmbralesNiveles() {
        return umbralesNiveles;
    }

    public void setUmbralesNiveles(UmbralesNiveles umbralesNiveles) {
        this.umbralesNiveles = umbralesNiveles;
    }

    public Estaciones prepareCreate() {
        estaciones = new Estaciones();
        umbralesNivelesR = new UmbralesNivelesR();
        umbralesNiveles = new UmbralesNiveles();
        listaEstacionesNivel = null;
        return estaciones;
    }

    public List<Nivelesvalores> getListaNivelesvalores() {
        return listaNivelesvalores;
    }

    public void setListaNivelesvalores(List<Nivelesvalores> listaNivelesvalores) {
        this.listaNivelesvalores = listaNivelesvalores;
    }

    public Nivelesvalores getNivelesvalores() {
        return nivelesvalores;
    }

    public void setNivelesvalores(Nivelesvalores nivelesvalores) {
        this.nivelesvalores = nivelesvalores;
    }

    public DataTable getTabla() {
        return tabla;
    }

    public void setTabla(DataTable tabla) {
        this.tabla = tabla;
    }

    @PostConstruct
    public void init() {
        estaciones = new Estaciones();
        umbralesNivelesR = new UmbralesNivelesR();
        umbralesNiveles = new UmbralesNiveles();
        listaNivelesvalores = new ArrayList<>();
        nivelesvalores = new Nivelesvalores();
        getEstacionesUmbrales();

    }

    /**
     * Visualizar la tabla niveles valores por estación
     */
    public void getVerInformacion() {
        try {
            if (estaciones != null) {
                nivelesvalores = new Nivelesvalores();
                listaNivelesvalores = new ArrayList<>();
                listaNivelesvalores = (ejbFacade.getNivelesvaloresxEstacion(estaciones.getIdestacion().intValue()));
                if (!listaNivelesvalores.isEmpty()) {
                    RequestContext.getCurrentInstance().update("NivelesListForm");
                    FacesContext.getCurrentInstance().getExternalContext().redirect("listarNivelesValores.xhtml");
                } else {
                    abrirCrearValores(0);
                }
            } else {
                RequestContext.getCurrentInstance().update("grow2");
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Seleccionar", "Debe seleccionar alguna estación"));
            }

        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("grow2");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Seleccionar", "Debe seleccionar alguna estación"));
        }

    }

    /**
     * Obtener los niveles valores por por sensor
     *
     * @param i
     */
    public void abrirCrearValores(int i) {
        nivelesvalores = new Nivelesvalores();
        try {
            if (i == 1) {
                ejbFacade.getObtenerSensorxEstacion(estaciones.getIdestacion().intValue());
                nivelesvalores = ejbFacade.getNivelesvaloresxSensor(ejbFacade.getObtenerSensorxEstacion(estaciones.getIdestacion().intValue()).intValue());
            }
            RequestContext.getCurrentInstance().update("NivelesCreateForm");
            FacesContext.getCurrentInstance().getExternalContext().redirect("crearNivelesValores.xhtml");

        } catch (IOException ex) {
            RequestContext.getCurrentInstance().update("msg1");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error ", ex.getMessage()));
        }

    }

    /**
     * Almacenar niveles según lo digitado desde del formulario
     */
    public void guardarNivelesValores() {

        FacesContext context = FacesContext.getCurrentInstance();
        try {
            if (nivelesvalores != null) {
                Usuarios usu = (Usuarios) context.getExternalContext().getSessionMap().get("usuario");
                nivelesvalores.setIdnivelesvalores(ejbFacade.getUltimoNivelesValores());
                nivelesvalores.setFechaCreacion(new Date());
                nivelesvalores.setIdusuario(usu.getDocumento().getDocumento());
                nivelesvalores.setIdsensor(new Sensores());
                nivelesvalores.getIdsensor().setIdsensor(ejbFacade.getObtenerSensorxEstacion(estaciones.getIdestacion().intValue()));
                nivelesvalores.setEstado(BigInteger.ONE);

                ejbFacade.guardarNivelesValores(nivelesvalores);

                nivelesvalores = new Nivelesvalores();
                nivelesvalores.setIdsensor(new Sensores());

                getVerInformacion();

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

    /**
     * Consultar todos los umbrales de niveles
     */
    public void getUmbrales() {
        umbralesNivelesR = new UmbralesNivelesR();
        listaUmbrales = new ArrayList<>();
        listaUmbralesNivel = ejbFacade.getUmbralesNiveles();
        ArrayRecord ar = null;
        for (Object list1 : listaUmbralesNivel) {
            ar = (ArrayRecord) list1;
            umbralesNivelesR.setId((BigDecimal) ar.getValues("IDUMBRALES"));
            umbralesNivelesR.setEstacion((String) ar.getValues("ESTACION"));
            umbralesNivelesR.setNivelAlto((BigDecimal) ar.getValues("NIVELALTO"));
            umbralesNivelesR.setNivelMedio((BigDecimal) ar.getValues("NIVELMEDIO"));
            umbralesNivelesR.setNivelBajo((BigDecimal) ar.getValues("NIVELBAJO"));
            listaUmbrales.add(umbralesNivelesR);
            umbralesNivelesR = new UmbralesNivelesR();
        }
        RequestContext.getCurrentInstance().update("UmbralesListForm");
    }

    /**
     * Consultar todas los estaciones de niveles
     */
    public void getEstacionesUmbrales() {
        listaEstacionesUmbrales = ejbFacade.getUmbralesEstacionesNiveles();
        listaIdNivelUmbrales = new ArrayList<>();
        ArrayRecord ar = null;
        umbralesNivelesRes = new UmbralesNivelesRes();
        for (Object list1 : listaEstacionesUmbrales) {
            ar = (ArrayRecord) list1;
            umbralesNivelesRes.setEstacion((String) ar.getValues("ESTACION"));
            umbralesNivelesRes.setIdNiveles((BigDecimal) ar.getValues("IDNIVELES"));
            listaIdNivelUmbrales.add(umbralesNivelesRes);
            umbralesNivelesRes = new UmbralesNivelesRes();
        }
        RequestContext.getCurrentInstance().update("UmbralesListForm");
    }

    public void getVerUmbrales() {
        try {
            if (umbralesNivelesR != null) {
                RequestContext.getCurrentInstance().update("UmbralesCreateForm");
                FacesContext.getCurrentInstance().getExternalContext().redirect("crearUmbrales.xhtml");
            } else {
                RequestContext.getCurrentInstance().update("grow2");
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Seleccionar ", "Debe seleccionar alguna estación"));
            }

        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("grow2");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Seleccionar", "Debe seleccionar alguna estación"));
        }

    }

    /**
     * Almacenar umbrales niveles según lo digitado desde del formulario
     */
    public void guardarUmbralesNiveles() {

        FacesContext context = FacesContext.getCurrentInstance();
        BigDecimal idNivelD = new BigDecimal(idNivel);
        try {
            if (umbralesNiveles != null) {
                Usuarios usu = (Usuarios) context.getExternalContext().getSessionMap().get("usuario");
                umbralesNiveles.setIdNiveles(idNivelD);
                umbralesNiveles.setIdUmbrales(ejbFacade.getUltimoUmbralesNiveles());
                umbralesNiveles.setFechaCreacion(new Date());
                umbralesNiveles.setIdUsuario(usu.getDocumento().getDocumento());
                ejbFacade.getGuardarUmbralesNiveles(umbralesNiveles);
                umbralesNiveles = new UmbralesNiveles();
                getUmbrales();
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

    /**
     * Editar sismos seleccionando cada registro
     *
     */
    public void editarUmbrales() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        UmbralesNiveles umbralesNiveles = new UmbralesNiveles();
        umbralesNiveles = ejbFacadeUmbrales.find(umbralesNivelesR.getId());
        if (umbralesNiveles != null) {
            Usuarios usu = (Usuarios) context.getExternalContext().getSessionMap().get("usuario");
            umbralesNiveles.setFechaModificacion(new Date());
            umbralesNiveles.setIdUsuario(usu.getDocumento().getDocumento());
            umbralesNiveles.setNivelAlto(umbralesNivelesR.getNivelAlto());
            umbralesNiveles.setNivelMedio(umbralesNivelesR.getNivelMedio());
            umbralesNiveles.setNivelBajo(umbralesNivelesR.getNivelBajo());
            ejbFacade.actualizarUmbralesNiveles(umbralesNiveles);
            getUmbrales();
            RequestContext.getCurrentInstance().update("UmbralesListForm");
            FacesContext.getCurrentInstance().getExternalContext().redirect("listarUmbrales.xhtml");
            context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Edición", "Los datos se editaron con éxito"));
        } else {
            context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Edición", "No Se editó nungún elemento "));
        }

    }

    /**
     * Visualizar la tabla umbrales niveles
     */
    public void getVerModificar() {
        try {
            if (umbralesNivelesR != null) {

                RequestContext.getCurrentInstance().update("UmbralesCreateForm");
                FacesContext.getCurrentInstance().getExternalContext().redirect("modificarUmbrales.xhtml");
            } else {
                RequestContext.getCurrentInstance().update("grow2");
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Seleccionar", "Debe seleccionar alguna estación"));
            }

        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("grow2");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Seleccionar", "Debe seleccionar alguna estación"));
        }
    }

}
