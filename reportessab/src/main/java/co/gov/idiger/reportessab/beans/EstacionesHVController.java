/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.beans;

import co.gov.idiger.reportessab.entities.Estaciones;
import co.gov.idiger.reportessab.entities.EstacionesHV;
import co.gov.idiger.reportessab.entities.Mantenimientos;
import co.gov.idiger.reportessab.entities.Observaciones;
import co.gov.idiger.reportessab.entities.SensoresInstalados;
import co.gov.idiger.reportessab.entities.Usuarios;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.eclipse.persistence.internal.sessions.ArrayRecord;
import org.primefaces.context.RequestContext;

/**
 * Clase con las rutinas de visualizar las hojas de vida de las estaciones
 *
 * @author USER
 */
@ManagedBean
@SessionScoped
public class EstacionesHVController implements Serializable {

    @EJB
    private co.gov.idiger.reportessab.facade.local.EstacionesHVFacadeLocal ejbFacade;
    private List<Estaciones> listaEstaciones = null;
    private List<EstacionesHV> listaEstacionesHV = null;
    private List<SensoresInstalados> listaSensoresInst = null;
    private List<Mantenimientos> listaMantenimientos = null;
    private List<Observaciones> listaObservaciones = null;
    private List listSenInst = null;
    private List listMant = null;
    private List listObs = null;
    private SensoresInstalados sensoresInstaladas;
    private Mantenimientos mantenimientos;
    private Mantenimientos mantenimientosCrear;
    private Observaciones observaciones;
    private Observaciones observacionesCrear;
    private String observacionesstr=" ";
    private List listEstHV = null;
    private Estaciones estaciones;
    private EstacionesHV estacionesHV;

    public List<Estaciones> getListaEstaciones() {
        if (listaEstaciones == null) {
            listaEstaciones = ejbFacade.findAll();
        }
        return listaEstaciones;
    }

    public void setListaEstaciones(List<Estaciones> listaEstaciones) {
        this.listaEstaciones = listaEstaciones;
    }

    public Estaciones getEstaciones() {
        return estaciones;
    }

    public void setEstaciones(Estaciones estaciones) {
        this.estaciones = estaciones;
    }

    public EstacionesHV getEstacionesHV() {
        return estacionesHV;
    }

    public void setEstacionesHV(EstacionesHV estacionesHV) {
        this.estacionesHV = estacionesHV;
    }

    public Mantenimientos getMantenimientosCrear() {
        return mantenimientosCrear;
    }

    public void setMantenimientosCrear(Mantenimientos mantenimientosCrear) {
        this.mantenimientosCrear = mantenimientosCrear;
    }

    public Observaciones getObservacionesCrear() {
        return observacionesCrear;
    }

    public void setObservacionesCrear(Observaciones observacionesCrear) {
        this.observacionesCrear = observacionesCrear;
    }

    public String getObservacionesstr() {
        return observacionesstr;
    }

    public void setObservacionesstr(String observacionesstr) {
        this.observacionesstr = observacionesstr;
    }

    public List<SensoresInstalados> getListaSensoresInst() {
        getListarSensoresxEstacionesCNE();
        return listaSensoresInst;
    }

    public void setListaSensoresInst(List<SensoresInstalados> listaSensoresInst) {
        this.listaSensoresInst = listaSensoresInst;
    }

    public List<Mantenimientos> getListaMantenimientos() {
        getListarMantenimientosxEstacionesCNE();
        return listaMantenimientos;
    }

    public void setListaMantenimientos(List<Mantenimientos> listaMantenimientos) {
        this.listaMantenimientos = listaMantenimientos;
    }

    public List<Observaciones> getListaObservaciones() {
        getListarObservacionesxEstacionesCNE();
        return listaObservaciones;
    }

    public void setListaObservaciones(List<Observaciones> listaObservaciones) {
        this.listaObservaciones = listaObservaciones;
    }

    public List<EstacionesHV> getListaEstacionesHV() {
        if (listaEstacionesHV == null) {
            getAbrirFormulario();
        }
        return listaEstacionesHV;
    }

    public void setListaEstacionesHV(List<EstacionesHV> listaEstacionesHV) {
        this.listaEstacionesHV = listaEstacionesHV;
    }

    public Estaciones prepareCreate() {
        estacionesHV = new EstacionesHV();
        listaEstaciones = new ArrayList<>();
        estaciones = new Estaciones();
        initializeEmbeddableKey();
        listaEstacionesHV = null;
//         mantenimientosCrear = new Mantenimientos();
//        observacionesCrear = new Observaciones();
        return estaciones;
    }

    @PostConstruct
    public void init() {
        mantenimientosCrear = new Mantenimientos();
        observacionesCrear = new Observaciones();
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    public void getAbrirFormulario() {

        try {
            if (estaciones != null) {
                estacionesHV = new EstacionesHV();
                listaEstacionesHV = new ArrayList<>();
                listEstHV = ejbFacade.getEstacionesHV(estaciones.getIdestacion().intValue());

                if (!listEstHV.isEmpty()) {
                    ArrayRecord ar = null;
                    for (Object list1 : listEstHV) {
                        ar = (ArrayRecord) list1;
                        estacionesHV.setIdestacion((BigDecimal) ar.getValues("IDESTACION"));
                        estacionesHV.setIdestacioncne((BigDecimal) ar.getValues("IDESTACIONCNE"));
                        estacionesHV.setEstacion((String) ar.getValues("ESTACION"));
                        estacionesHV.setTipo((String) ar.getValues("TIPO"));
                        estacionesHV.setCodigoCNE((String) ar.getValues("CODIGOCNE"));
                        estacionesHV.setLatitud((BigDecimal) ar.getValues("LATITUD"));
                        estacionesHV.setLongitud((BigDecimal) ar.getValues("LONGITUD"));
                        estacionesHV.setDepto((String) ar.getValues("DEPARTAMENTO"));
                        estacionesHV.setCiudad((String) ar.getValues("MUNICIPIO"));
                        estacionesHV.setArea((String) ar.getValues("AREAOPERATIVA"));
                        estacionesHV.setLocalidad((String) ar.getValues("LOCALIDAD"));
                        estacionesHV.setEstadoEstacion((String) ar.getValues("ESTADOESTACION"));
                        estacionesHV.setEscenarioRiesgo((String) ar.getValues("ESCENARIORIESGO"));
                        estacionesHV.setLugarMonitoreo((String) ar.getValues("LUGARMONITOREO"));
                        estacionesHV.setTipoMonitoreo((String) ar.getValues("TIPOMONITOREO"));
                        estacionesHV.setTipoTransmision((String) ar.getValues("TIPOTRANSMISION"));
                        estacionesHV.setTipoTecnologia((String) ar.getValues("TIPOTECNOLOGIA"));
                        estacionesHV.setEscala((String) ar.getValues("'LOCAL'"));

                    }
                    FacesContext.getCurrentInstance().getExternalContext().redirect("crearEstacionesHV.xhtml");
                    RequestContext.getCurrentInstance().update("EstacionesHVCreateForm");
                } else {
                    RequestContext.getCurrentInstance().update("grow2");
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Notificación", "No hay datos "));

                }
            } else {
                RequestContext.getCurrentInstance().update("grow2");
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Seleccionar", "Debe seleccionar alguna estación"));

            }

        } catch (IOException ex) {
            Logger.getLogger(EstacionesHVController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getListarSensoresxEstacionesCNE() {
        sensoresInstaladas = new SensoresInstalados();
        listaSensoresInst = new ArrayList<>();
        listSenInst = ejbFacade.getListaSensoresxEstacionesCNE(estacionesHV.getIdestacioncne().intValue());

        if (!listSenInst.isEmpty()) {
            ArrayRecord ar = null;
            for (Object list1 : listSenInst) {
                ar = (ArrayRecord) list1;
                sensoresInstaladas.setIdSensoresInstalados((BigDecimal) ar.getValues("IDSENSORESINSTALADOS"));
                sensoresInstaladas.setIdEstacionCne((BigDecimal) ar.getValues("IDESTACIONCNE"));
                sensoresInstaladas.setTipoSensor((String) ar.getValues("TIPOSENSOR"));
                sensoresInstaladas.setFechaInstalacion((Date) ar.getValues("FECHAINSTALACION"));
                sensoresInstaladas.setFechaSerie((String) ar.getValues("FECHASERIE"));
                sensoresInstaladas.setFechaMetaDatos((Date) ar.getValues("FECHAMETADATOS"));
                sensoresInstaladas.setEstado((BigDecimal) ar.getValues("ESTADO"));
                listaSensoresInst.add(sensoresInstaladas);
                sensoresInstaladas = new SensoresInstalados();

            }
        }
    }

    public void getListarMantenimientosxEstacionesCNE() {
        mantenimientos = new Mantenimientos();
        listaMantenimientos = new ArrayList<>();
        listMant = ejbFacade.getListaMantenimientoxEstacionesCNE(estacionesHV.getIdestacioncne().intValue());

        if (!listMant.isEmpty()) {
            ArrayRecord ar = null;
            for (Object list1 : listMant) {
                ar = (ArrayRecord) list1;
                mantenimientos.setIdMantenimiento((BigDecimal) ar.getValues("IDMANTENIMIENTO"));
                mantenimientos.setIdEstacionCNE((BigDecimal) ar.getValues("IDESTACIONCNE"));
                mantenimientos.setDocumento((BigDecimal) ar.getValues("DOCUMENTO"));
                mantenimientos.setIdtipoMantenimiento((BigDecimal) ar.getValues("IDTIPOMANTENIMIENTO"));
                mantenimientos.setFechaInicio((Date) ar.getValues("FECHAINICIO"));
                mantenimientos.setFechaFin((Date) ar.getValues("FECHAFIN"));
                mantenimientos.setDescripcion((String) ar.getValues("DESCRIPCION"));
                mantenimientos.setUbicacion((String) ar.getValues("UBICACION"));
                mantenimientos.setUrl((String) ar.getValues("URL"));
                listaMantenimientos.add(mantenimientos);
                mantenimientos = new Mantenimientos();

            }
        }
    }

    public void getListarObservacionesxEstacionesCNE() {
        observaciones = new Observaciones();
        listaObservaciones = new ArrayList<>();
        listObs = ejbFacade.getListaObservacionesxEstacionesCNE(estacionesHV.getIdestacioncne().intValue());

        if (!listObs.isEmpty()) {
            ArrayRecord ar = null;
            for (Object list1 : listObs) {
                ar = (ArrayRecord) list1;
                observaciones.setIdObservaciones((BigDecimal) ar.getValues("IDOBSERVACIONES"));
                observaciones.setObservacion((String) ar.getValues("OBSERVACIONES"));
                observaciones.setFecha((Date) ar.getValues("FECHA"));
                observaciones.setEstado((BigDecimal) ar.getValues("ESTADO"));
                observaciones.setIdEstacioncne((BigDecimal) ar.getValues("IDESTACIONCNE"));
                listaObservaciones.add(observaciones);
                observaciones = new Observaciones();

            }
        } else {
            System.out.println("this = " + this);
        }
    }
    FacesContext context = FacesContext.getCurrentInstance();
    Usuarios usu = (Usuarios) context.getExternalContext().getSessionMap().get("usuario");

    public Usuarios getUsu() {
        return usu;
    }

    public void setUsu(Usuarios usu) {
        this.usu = usu;
    }

    public void guardarEstacionesCNE() {

        boolean band = false;
        if (estacionesHV != null) {
            ejbFacade.guardarEstacionesCNE(estacionesHV);

            for (SensoresInstalados sensoresInstalados : listaSensoresInst) {
                ejbFacade.guardarSensoresCNE(sensoresInstalados);
            }

            if ("" != observacionesstr) {
                observacionesCrear.setObservacion(observacionesstr);
                observacionesCrear.setIdObservaciones(ejbFacade.getUltimoObservacion());
                observacionesCrear.setIdEstacioncne(estacionesHV.getIdestacioncne());
                ejbFacade.guardarObservacionesCNE(observacionesCrear);
                observacionesCrear = new Observaciones();
                band = true;
            }
//            if (band == true) {
            try {
                RequestContext.getCurrentInstance().update("formsen");
                RequestContext.getCurrentInstance().update("EstacionesHVCreateForm");
//                    RequestContext.getCurrentInstance().update("formob");
                FacesContext.getCurrentInstance().getExternalContext().redirect("../estaciones/crearEstacionesHV.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(EstacionesHVController.class.getName()).log(Level.SEVERE, null, ex);
            }
//            }

//            RequestContext.getCurrentInstance().update("growlu");
//            context = FacesContext.getCurrentInstance();
//            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Notificación", "Datos actualizados "));
        }
    }
}
