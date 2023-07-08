package co.gov.idiger.reportessab.beans;

import co.gov.idiger.reportessab.entities.*;
import co.gov.idiger.reportessab.facade.local.EstacionesFacadeLocal;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.eclipse.persistence.internal.sessions.ArrayRecord;
import org.primefaces.context.RequestContext;
import java.io.IOException;
import javax.faces.context.ExternalContext;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

@ManagedBean
@ViewScoped
public class EstacionesController implements Serializable {

    @EJB
    private co.gov.idiger.reportessab.facade.local.EstacionesFacadeLocal ejbFacade;
    private List<Estaciones> listaEstaciones = null;
    private List<Estaciones> listaEstacionesxTiposensor = null;
    private List<SensoresEstaciones> listaSensores = null;
    private List<Tipossensores> listaTipoSensor = null;
    private List<Estaciones> listaEsta = null;
    private List<SensoresEstaciones> listasensoresEstaciones = null;
    private List<Localidades> listalocalidades = null;
    private List<String> listaTipoReporte = null;
    private List listaLectxSensores = null;
    private List listaReporteEstaciones = null;
    private List listaReporteConsolidados = null;
    private List listaLectEstacionesAcumLluvia = null;
    private List listaLectEstacionesAcumLluviaMensuales = null;
    private List listaLectEstacionesReportes = null;
    private List<LecturasMensualDiario> listaLecturaEstacionesReportes = new ArrayList<>();
    private SensoresEstaciones sensoresEstaciones;
    private Estaciones estaciones;
    private LecturasSensores lecturasxSensores;
    private LecturasEstaciones lecturasEstaciones;
    private LecturasMensualDiario lecturasMensualDiario;
    private int idEstacion;
    private int idReporte;
    private int idTipoSensor = 0;
    private int localidad;
    private String localidades;
    private String estacion;
    private BigDecimal idSensorLectura;
    private Date fechainicial;
    private Date fechafinal;
    private Date fechainicialMes;
    private Date fechafinalMes;
    private Date fechadiaantes;
    private Boolean boolFechaMes = false;
    private Boolean boolFecha = true;
    private Boolean boolDiario = false;
    private Boolean boolHorario = false;
    private Boolean boolMinimo = false;
    private Boolean boolMaximo = false;
    private Boolean boolPromedio = false;
    private Boolean boolMedia = false;
    private Boolean boolDiarioLluvia = false;
    private Boolean boolMensualLluvia = false;
    private Boolean boolTodas = false;
    private String mesInicio;
    private String anioInicio;
    private String mesFinal;
    private String anioFinal;

    @PostConstruct
    public void init() {
        // getlistarEstacionesxTipoestacio();
        listaSensores = new ArrayList<>();
        listasensoresEstaciones = new ArrayList<>();
        listaTipoSensor = new ArrayList<>();
        idSensorLectura = new BigDecimal(BigInteger.ZERO);
    }

    public EstacionesController() {
    }

    public LecturasMensualDiario getLecturasMensualDiario() {
        return lecturasMensualDiario;
    }

    public void setLecturasMensualDiario(LecturasMensualDiario lecturasMensualDiario) {
        this.lecturasMensualDiario = lecturasMensualDiario;
    }

    public List<LecturasMensualDiario> getListaLecturaEstacionesReportes() {
        return listaLecturaEstacionesReportes;
    }

    public void setListaLecturaEstacionesReportes(List<LecturasMensualDiario> listaLecturaEstacionesReportes) {
        this.listaLecturaEstacionesReportes = listaLecturaEstacionesReportes;
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public Boolean getBoolFechaMes() {
        return boolFechaMes;
    }

    public void setBoolFechaMes(Boolean boolFechaMes) {
        this.boolFechaMes = boolFechaMes;
    }

    public Boolean getBoolFecha() {
        return boolFecha;
    }

    public void setBoolFecha(Boolean boolFecha) {
        this.boolFecha = boolFecha;
    }

    public LecturasEstaciones getLecturasEstaciones() {
        return lecturasEstaciones;
    }

    public void setLecturasEstaciones(LecturasEstaciones lecturasEstaciones) {
        this.lecturasEstaciones = lecturasEstaciones;
    }

    public Date getFechadiaantes() {
        fechadiaantes = diaantes();
        return fechadiaantes;
    }

    public void setFechadiaantes(Date fechadiaantes) {
        this.fechadiaantes = fechadiaantes;
    }

    public Date getFechainicial() {
        return fechainicial;
    }

    public void setFechainicial(Date fechainicial) {
        this.fechainicial = fechainicial;
    }

    public Date getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(Date fechafinal) {
        this.fechafinal = fechafinal;
    }

    public LecturasSensores getLecturasxSensores() {
        return lecturasxSensores;
    }

    public void setLecturasxSensores(LecturasSensores lecturasxSensores) {
        this.lecturasxSensores = lecturasxSensores;
    }

    public BigDecimal getIdSensorLectura() {
        return idSensorLectura;
    }

    public void setIdSensorLectura(BigDecimal idSensorLectura) {
        this.idSensorLectura = idSensorLectura;
    }

    public String getEstacion() {
        return estacion;
    }

    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }

    public SensoresEstaciones getSensoresEstaciones() {
        return sensoresEstaciones;
    }

    public void setSensoresEstaciones(SensoresEstaciones sensoresEstaciones) {
        this.sensoresEstaciones = sensoresEstaciones;
    }

    public List<SensoresEstaciones> getListaSensores() {
        return listaSensores;
    }

    public void setListaSensores(List<SensoresEstaciones> listaSensores) {
        this.listaSensores = listaSensores;
    }

    public List<SensoresEstaciones> getListasensoresEstaciones() {
        return listasensoresEstaciones;
    }

    public void setListasensoresEstaciones(List<SensoresEstaciones> listasensoresEstaciones) {
        this.listasensoresEstaciones = listasensoresEstaciones;
    }

    public List<Estaciones> getListaEstaciones() {
//        if (listaEstaciones == null) {
//            getlistarEstacionesxTipoestacio();
//        }
        return listaEstaciones;
    }

    public void setListaEstaciones(List<Estaciones> listaEstaciones) {
        this.listaEstaciones = listaEstaciones;
    }

    public List<Estaciones> getListaEstacionesxTiposensor() {
        if (listaEstacionesxTiposensor == null) {
            listaEstacionesxTiposensor = ejbFacade.getEstacionxTipoSensor(2);
        }
        return listaEstacionesxTiposensor;
    }

    public List<Localidades> getListalocalidades() {
        if (listalocalidades == null) {
            listalocalidades = ejbFacade.getLocalidades();
        }
        return listalocalidades;
    }

    public void setListalocalidades(List<Localidades> listalocalidades) {
        this.listalocalidades = listalocalidades;
    }

    public int getLocalidad() {
        return localidad;
    }

    public void setLocalidad(int localidad) {
        this.localidad = localidad;
    }

    public String getLocalidades() {
        return localidades;
    }

    public void setLocalidades(String localidades) {
        this.localidades = localidades;
    }

    public void setListaEstacionesxTiposensor(List<Estaciones> listaEstacionesxTiposensor) {
        this.listaEstacionesxTiposensor = listaEstacionesxTiposensor;
    }

    public Estaciones getEstaciones() {
        return estaciones;
    }

    public void setEstaciones(Estaciones estaciones) {
        this.estaciones = estaciones;
    }

    public Date getFechainicialMes() {
        return fechainicialMes;
    }

    public void setFechainicialMes(Date fechainicialMes) {
        this.fechainicialMes = fechainicialMes;
    }

    public Date getFechafinalMes() {
        return fechafinalMes;
    }

    public void setFechafinalMes(Date fechafinalMes) {
        this.fechafinalMes = fechafinalMes;
    }

    public String getMesInicio() {
        return mesInicio;
    }

    public void setMesInicio(String mesInicio) {
        this.mesInicio = mesInicio;
    }

    public String getAnioInicio() {
        return anioInicio;
    }

    public void setAnioInicio(String anioInicio) {
        this.anioInicio = anioInicio;
    }

    public String getMesFinal() {
        return mesFinal;
    }

    public void setMesFinal(String mesFinal) {
        this.mesFinal = mesFinal;
    }

    public String getAnioFinal() {
        return anioFinal;
    }

    public void setAnioFinal(String anioFinal) {
        this.anioFinal = anioFinal;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    public int getIdEstacion() {
        return idEstacion;
    }

    public void setIdEstacion(int idEstacion) {
        this.idEstacion = idEstacion;
    }

    public EstacionesFacadeLocal getEjbFacade() {
        return ejbFacade;
    }

    public List<String> getListaTipoReporte() {
        return listaTipoReporte;
    }

    public void setListaTipoReporte(List<String> listaTipoReporte) {
        this.listaTipoReporte = listaTipoReporte;
    }

    public Boolean getBoolDiario() {
        return boolDiario;
    }

    public void setBoolDiario(Boolean boolDiario) {
        this.boolDiario = boolDiario;
    }

    public Boolean getBoolHorario() {
        return boolHorario;
    }

    public void setBoolHorario(Boolean boolHorario) {
        this.boolHorario = boolHorario;
    }

    public Boolean getBoolMinimo() {
        return boolMinimo;
    }

    public void setBoolMinimo(Boolean boolMinimo) {
        this.boolMinimo = boolMinimo;
    }

    public Boolean getBoolMaximo() {
        return boolMaximo;
    }

    public void setBoolMaximo(Boolean boolMaximo) {
        this.boolMaximo = boolMaximo;
    }

    public Boolean getBoolPromedio() {
        return boolPromedio;
    }

    public void setBoolPromedio(Boolean boolPromedio) {
        this.boolPromedio = boolPromedio;
    }

    public Boolean getBoolMedia() {
        return boolMedia;
    }

    public void setBoolMedia(Boolean boolMedia) {
        this.boolMedia = boolMedia;
    }

    public Boolean getBoolDiarioLluvia() {
        return boolDiarioLluvia;
    }

    public void setBoolDiarioLluvia(Boolean boolDiarioLluvia) {
        this.boolDiarioLluvia = boolDiarioLluvia;
    }

    public Boolean getBoolTodas() {
        return boolTodas;
    }

    public void setBoolTodas(Boolean boolTodas) {
        this.boolTodas = boolTodas;
    }

    public Boolean getBoolMensualLluvia() {
        return boolMensualLluvia;
    }

    public void setBoolMensualLluvia(Boolean boolMensualLluvia) {
        this.boolMensualLluvia = boolMensualLluvia;
    }

    public int getIdTipoSensor() {
        return idTipoSensor;
    }

    public void setIdTipoSensor(int idTipoSensor) {
        this.idTipoSensor = idTipoSensor;
    }

    public Estaciones prepareCreate() {
        listaEstaciones = new ArrayList<>();
        estaciones = new Estaciones();
        listaSensores = new ArrayList<>();
        listasensoresEstaciones = new ArrayList<>();
        initializeEmbeddableKey();
        return estaciones;
    }

    /**
     * Cargar los sensores por estación
     */
    public void getlistarEstacionesxTipoestacio() {
        estaciones = new Estaciones();
        listaEstaciones = new ArrayList<>();
        boolTodas = false;
        if (!"0".equals(localidades)) {
            listaEsta = ejbFacade.getEstacionesSireSidisat(Integer.parseInt(localidades));
            ArrayRecord ar = null;
            for (Object list1 : listaEsta) {
                ar = (ArrayRecord) list1;
                estaciones.setIdestacion((BigDecimal) ar.getValues("IDESTACION"));
                estaciones.setEstacion((String) ar.getValues("ESTACION"));
                listaEstaciones.add(estaciones);
                estaciones = new Estaciones();
            }
        } else {
            boolTodas = true;
        }
        RequestContext.getCurrentInstance().update("formularioreportes");
    }

    /**
     * Activar el tipo de reporte según la estación y sensor seleccionado
     */
    public void getGestionarEstaciones() {
        boolFechaMes = false;
        boolFecha = true;
        if (idReporte == 8) {
            boolFechaMes = true;
            boolFecha = false;
        }
    }

    /**
     * Mostar los sensores dependiendo de la estación o todas las estaciones
     */
    public void getListarSensoresEstaciones() {
        System.out.println("estacion = " + estacion);
        sensoresEstaciones = new SensoresEstaciones();
        listasensoresEstaciones = new ArrayList<>();
        if (estacion != null) {
            if ("todas".equals(estacion)) {
                listaTipoSensor = ejbFacade.getTipoSensores();
                if (!listaTipoSensor.isEmpty()) {

                    for (Tipossensores tipossensores : listaTipoSensor) {
                        sensoresEstaciones.setIdSensor(tipossensores.getIdtiposensor());
                        sensoresEstaciones.setTipoSensor(tipossensores.getTiposensor());
                        listasensoresEstaciones.add(sensoresEstaciones);
                        sensoresEstaciones = new SensoresEstaciones();
                    }
                }
            } else {
                listaSensores = ejbFacade.getSensoresxEstaciones(idtiposensoresxNombre(estacion).intValue(), 0);
                if (!listaSensores.isEmpty()) {
                    ArrayRecord ar = null;
                    for (Object list1 : listaSensores) {
                        ar = (ArrayRecord) list1;
                        sensoresEstaciones.setIdSensor((BigDecimal) ar.getValues("S.IDSENSOR"));
                        sensoresEstaciones.setTipoSensor((String) ar.getValues("TS.TIPOSENSOR"));
                        sensoresEstaciones.setIdtipoSensor((BigDecimal) ar.getValues("TS.IDTIPOSENSOR"));
                        sensoresEstaciones.setLatitud((BigDecimal) ar.getValues("S.LATITUD"));
                        sensoresEstaciones.setLongitud((BigDecimal) ar.getValues("S.LONGITUD"));
                        sensoresEstaciones.setEstado((BigDecimal) ar.getValues("S.ESTADO"));
                        sensoresEstaciones.setUnidadmedida((String) ar.getValues("TS.UNIDADMEDIDA"));
                        sensoresEstaciones.setEstacion((String) ar.getValues("E.ESTACION"));
                        sensoresEstaciones.setVisible((BigDecimal) ar.getValues("S.VISIBLE"));
                        listasensoresEstaciones.add(sensoresEstaciones);
                        sensoresEstaciones = new SensoresEstaciones();
                    }
                }
            }
        }
        RequestContext.getCurrentInstance().update("formularioreportes");
    }

    /**
     * Obtiene el id por nombre de estacion recorriendo la lista de
     * listaEstaciones previamente llena
     *
     * @param estacion
     * @return idestacion
     */
    public BigDecimal idtiposensoresxNombre(String estacion) {
        BigDecimal idEstacion = new BigDecimal(BigInteger.ZERO);

        for (Estaciones listaestaciones : listaEstaciones) {
            if (estacion.equals(listaestaciones.getEstacion())) {
                return idEstacion = listaestaciones.getIdestacion();
            }
        }
        return null;
    }

    /**
     * Validar la opción del Sensor para el tipo de reporte (Acumulado
     * Diario,Acumulado Diario Lluvias,Acumulado Mensual
     * Lluvias,Horario,Minutal,Mínimo Diario,Máximo Diario,romedio Diario)
     */
    public void getTipoReporte() {
        idTipoSensor = 0;
        boolDiario = false;
        boolHorario = false;
        boolDiarioLluvia = false;
        boolMensualLluvia = false;
        boolMinimo = false;
        boolMaximo = false;
        boolPromedio = false;
        boolMedia = false;
        if (idSensorLectura != null) {
            if (!"todas".equals(estacion)) {
                for (SensoresEstaciones lista : listasensoresEstaciones) {
                    if (idSensorLectura.equals(lista.getIdSensor())) {
                        idTipoSensor = lista.getIdtipoSensor().intValue();
                    }
                }
            } else {
                idTipoSensor = idSensorLectura.intValue();
            }
            switch (idTipoSensor) {
                case 1:
                    boolHorario = true;
                    boolMedia = true;
                    boolMinimo = true;
                    boolMaximo = true;
                    if (!"todas".equals(estacion)) {
                        boolPromedio = true;
                    }
                    break;
                case 3:
                    boolHorario = true;
                    break;
                case 5:
                    boolMensualLluvia = true;
                    if (!"todas".equals(estacion)) {
                        boolDiario = true;
                    } else {
                        boolDiarioLluvia = true;
                    }
                    break;

            }
        }
    }

    /**
     * Selecciono el el tipo de reporte para asi invocar los métodos según lo
     * que seleccione por estación y sensor,
     */
    public void getlecturasxEstaciones() {
        listaLectxSensores = null;
        listaLectEstacionesAcumLluvia = null;
        listaLectEstacionesAcumLluviaMensuales = null;
        listaLectEstacionesReportes = null;
        try {
        if (validarFechas()) {
            long init = System.currentTimeMillis();
            long end;
            long time;
            switch (idReporte) {
                case 1:
                    getlecturasEstacionesReportes(idSensorLectura.intValue());
                    end = System.currentTimeMillis();
                    time = end - init;
                    System.out.println("Tiempo de ejecución Reporte 1" + time / 1000 + " segundos");
                    RequestContext.getCurrentInstance().update("datalecturasReportes");
                    break;
                case 2:
                case 3:
                    if (estacion.equals("todas")) {
                        getReportesEstacionesPOI(idSensorLectura.intValue());//Todas las estaciones
                        end = System.currentTimeMillis();
                        time = end - init;
                        System.out.println("Tiempo de ejecución Estaciones " + time / 1000 + " segundos");
                    } else {
                        getReportesxSensores();
                        end = System.currentTimeMillis();
                        time = end - init;
                        System.out.println("Tiempo de ejecución Estaciones " + time / 1000 + " segundos");
                    }
                    break;
                case 7:
                    if (estacion.equals("todas")) {
                        getReporteAcumulados();
                        end = System.currentTimeMillis();
                        time = end - init;
                        System.out.println("Tiempo de ejecución Estaciones Acumuladas " + time / 1000 + " segundos");
                        RequestContext.getCurrentInstance().update("dataestacionesacum");
                    }
                    break;
                case 8:
                    getObtenerReporteMensual();
                    if (estacion.equals("todas")) {
                        getlecturasTodasEstacionesAcumuladasMensuales();
                    } else {
                        getlecturasEstacionesAcumuladasMensuales();
                    }
                    end = System.currentTimeMillis();
                    time = end - init;
                    System.out.println("Tiempo de ejecución Estaciones Acumuladas Mensuales " + time / 1000 + " segundos");
                    RequestContext.getCurrentInstance().update("dataestacionesmensuales");
                    break;
                case 11:
                case 12:
                case 13:
                case 14:
                    if (estacion.equals("todas")) {
                        if (idReporte != 13) {
                            getReporteConosolidadoTemperaturaMaxMinMediaDiaria();
                        } else {
                            getReporteEstacionesConsolidado();
                        }
                        end = System.currentTimeMillis();
                        time = end - init;
                        System.out.println("Tiempo de ejecución Reporte 1" + time / 1000 + " segundos");
                    } else {
                        getlecturasEstacionesReportes(idSensorLectura.intValue());
                        end = System.currentTimeMillis();
                        time = end - init;
                        System.out.println("Tiempo de ejecución Reporte 1" + time / 1000 + " segundos");
                    }
                    break;

                default:
                    if (estacion.equals("todas")) {
                        getReportesEstacionesPOI(idSensorLectura.intValue());//Todas las estaciones
                        end = System.currentTimeMillis();
                        time = end - init;
                        System.out.println("Tiempo de ejecución Estaciones " + time / 1000 + " segundos");
                    }
            }
            RequestContext.getCurrentInstance().update("formularioreportes");
        } else {
            RequestContext.getCurrentInstance().update("grow2");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "La fecha inicial debe ser menor a la fecha final"));
        }
        } catch (Exception e) {
            RequestContext.getCurrentInstance().update("grow2");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Debe seleccionar las opciones"));

        }
        RequestContext.getCurrentInstance().update("formularioreportes");
        iniciarFormulario();
    }

    /**
     * Método que obtiene la lectura minutal y horaria del sensor seleccionado y
     * lo visualiza en archivo excel a través de la librería POI
     */
    public void getReportesxSensores() {
        if (idSensorLectura != null && fechainicial != null && fechafinal != null) {
            if (validarFechasxTipoReporte(idReporte)) {
                lecturasxSensores = new LecturasSensores();
                listaLectxSensores = ejbFacade.getLecturasxSensor(idSensorLectura.intValue(), fechainicial, fechafinal, idReporte);
                Workbook workbook = new HSSFWorkbook();
                Sheet sheet = workbook.createSheet();

                if (!listaLectxSensores.isEmpty()) {
                    Vector encabezado = ((ArrayRecord) listaLectxSensores.get(0)).getFields();
                    Row filaEncabezado = sheet.createRow(0);
                    for (int k = 0; k < encabezado.size(); k++) {
                        Cell celdaEncabezado = filaEncabezado.createCell(k);
                        String original = (encabezado.get(k).toString());
                        celdaEncabezado.setCellValue(original);
                    }
                    int rowNum = 1;
                    for (int i = 1; i < listaLectxSensores.size(); i++) {
                        Vector lect = ((ArrayRecord) listaLectxSensores.get(i)).getValues();
                        Row filaLectura = sheet.createRow(rowNum++);
                        int colNum = 0;
                        int j = 0;
                        for (Object field : lect) {
                            Cell celdaLectura = filaLectura.createCell(colNum++);
                            if (field instanceof Date) {
                                if (j == 0) {
                                    celdaLectura.setCellValue(field.toString());
                                    j++;
                                }
                            } else if (field instanceof BigDecimal) {
                                BigDecimal lectura = (BigDecimal) field;
                                celdaLectura.setCellValue(lectura.doubleValue());
                            }
                        }

                        if (idTipoSensor == 5) {
                            if (rowNum == listaLectxSensores.size()) {
                                ColumnasExcel columnas = new ColumnasExcel();
                                filaLectura.setRowNum(rowNum++);
                                Cell celdaAcumulado = filaLectura.createCell(0);
                                celdaAcumulado.setCellValue("ACUMULADO");

                                Cell celdaLectura3 = filaLectura.createCell(1);
                                String formulaAcumulado = "ROUND(SUM(B2:B" + listaLectxSensores.size() + "),2)";
                                celdaLectura3.setCellFormula(formulaAcumulado);
                            }

                        }

                    }

                    FacesContext context = FacesContext.getCurrentInstance();
                    ExternalContext externalContext = context.getExternalContext();
                    externalContext.responseReset();
                    externalContext.setResponseContentType("application/vnd.ms-excel");
                    externalContext.setResponseHeader("Content-Disposition", "attachment;filename=Reporte estacion " + estacion + ".xls");

                    try {
                        workbook.write(externalContext.getResponseOutputStream());
                        context.responseComplete();
                    } catch (IOException ex) {
                        Logger.getLogger(EstacionesController.class.getName()).log(Level.SEVERE, null, ex);
                        showMessage("No se generó el archivo " + ex.getMessage(), 2);
                    }
                } else {
                    showMessage("No hay datos para visualizar ", 1);

                }

            } else {
                if (idReporte == 2) {
                    showMessage("Las fechas seleccionadas deben ser menor o igual a 31 días ", 2);
                }
                if (idReporte == 3) {
                    showMessage("Las fechas seleccionadas deben ser menor o igual a 1 año ", 2);
                }
                iniciarFormulario();
            }
        } else {
            showMessage("Debe seleccionar las opciones ", 1);
        }

    }

    /**
     * Obtener valores mes inicial y final y año inicial y final para el reporte
     * mensual
     */
    public void getObtenerReporteMensual() {
        if (fechainicialMes != null && fechafinalMes != null) {
            DateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
            String fechaI = dateFormat.format(fechainicialMes);
            String[] inicial = fechaI.split("/");
            setMesInicio(inicial[0]);
            setAnioInicio(inicial[1]);
            String fechaF = dateFormat.format(fechafinalMes);
            String[] finalf = fechaF.split("/");
            setMesFinal(finalf[0]);
            setAnioFinal(finalf[1]);
        }
    }

    /**
     * Consultar una de las estaciones por tipo de reporte, Acumulado diario de
     * lluvias, Mínimo Diario de temperatura,Máximo Diario temperatura, Promedio
     * Diario temperatura según fecha inicial y final Tipo de Reporte: 1
     * Acumulado diario, 11 Mínimo Diario, 12 Máximo Diario, 13 Promedio Diario
     *
     * @param idSensorLectura Tipo de sensor
     */
    public void getlecturasEstacionesReportes(int idSensorLectura) {
        if (validarFechasxTipoReporte(idReporte)) {
            listaLectEstacionesReportes = ejbFacade.getLecturasEstaciones(idSensorLectura, fechainicial, fechafinal, idReporte);
            if (idReporte == 14) {
                getMediaDiaria(listaLectEstacionesReportes);
            } else {
                getConsolidados(listaLectEstacionesReportes);
            }
        } else if (idReporte == 1) {
            showMessage("Las fechas seleccionadas deben ser menor o igual a 5 años ", 2);
        }
        if (idReporte == 3) {
            showMessage("Las fechas seleccionadas deben ser menor o igual a 5 años ", 2);
        }

        iniciarFormulario();
    }

    /**
     * Reporte para obtener el consolidado del tipo de reporte, Acumulado diario
     * de lluvias, Mínimo Diario de temperatura,Máximo Diario temperatura,
     * Promedio Diario temperatura según fecha inicial y final Tipo de Reporte:
     * 1 Acumulado diario, 11 Mínimo Diario, 12 Máximo Diario, 13 Promedio
     * Diario y así visualizarlos en archivo excel con la librería POI
     *
     * @param listaLectEstacionesReportes envía los valores cargados para poder
     * visualizarlos y recorrerlos
     */
    public void getConsolidados(List listaLectEstacionesReportes) {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        if (!listaLectEstacionesReportes.isEmpty()) {
            Vector encabezado = ((ArrayRecord) listaLectEstacionesReportes.get(0)).getFields();
            Row filaEncabezado = sheet.createRow(0);
            for (int k = 0; k < encabezado.size(); k++) {
                Cell celdaEncabezado = filaEncabezado.createCell(k);
                String original = (encabezado.get(k).toString());
                celdaEncabezado.setCellValue(original);
            }
            int rowNum = 1;
            for (int i = 0; i < listaLectEstacionesReportes.size(); i++) {
                Vector lect = ((ArrayRecord) listaLectEstacionesReportes.get(i)).getValues();
                Row filaLectura = sheet.createRow(rowNum++);
                int colNum = 0;
                int j = 0;
                for (Object field : lect) {
                    Cell celdaLectura = filaLectura.createCell(colNum++);
                    if (field instanceof Date) {
                        if (j == 0) {
                            celdaLectura.setCellValue(field.toString());
                            j++;
                        }
                    } else if (field instanceof BigDecimal) {
                        BigDecimal lectura = (BigDecimal) field;
                        celdaLectura.setCellValue(lectura.doubleValue());
                    }
                }

            }

            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext externalContext = context.getExternalContext();
            externalContext.responseReset();
            externalContext.setResponseContentType("application/vnd.ms-excel");
            externalContext.setResponseHeader("Content-Disposition", "attachment;filename=Reporte estacion " + estacion + ".xls");

            try {
                workbook.write(externalContext.getResponseOutputStream());
                context.responseComplete();
            } catch (IOException ex) {
                Logger.getLogger(EstacionesController.class.getName()).log(Level.SEVERE, null, ex);
                showMessage("No se generó el archivo " + ex.getMessage(), 2);
            }
        } else {
            showMessage("No hay datos para visualizar ", 1);

        }
    }

    /**
     * Reporte para obtener el consolidado del tipo de reporte, Acumulado diario
     * de lluvias, Mínimo Diario de temperatura,Máximo Diario temperatura,
     * Promedio Diario temperatura según fecha inicial y final Tipo de Reporte:
     * 1 Acumulado diario, 11 Mínimo Diario, 12 Máximo Diario, 13 Promedio
     * Diario y así visualizarlos en archivo excel con la librería POI
     *
     * @param listaLectEstacionesReportes envía los valores cargados para poder
     * visualizarlos y recorrerlos
     */
    public void getMediaDiaria(List listaLectEstacionesReportes) {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        if (!listaLectEstacionesReportes.isEmpty()) {
            Vector encabezado = ((ArrayRecord) listaLectEstacionesReportes.get(0)).getFields();
            Row filaEncabezado = sheet.createRow(0);
            for (int k = 0; k < encabezado.size(); k++) {
                Cell celdaEncabezado = filaEncabezado.createCell(k);
                String original = (encabezado.get(k).toString());
                celdaEncabezado.setCellValue(original);
            }
            int rowNum = 1;
            for (int i = 0; i < listaLectEstacionesReportes.size(); i++) {
                Vector lect = ((ArrayRecord) listaLectEstacionesReportes.get(i)).getValues();
                Row filaLectura = sheet.createRow(rowNum++);
                int colNum = 0;
                int j = 0;
                for (Object field : lect) {
                    Cell celdaLectura = filaLectura.createCell(colNum++);
                    if (field instanceof Date) {
                        if (j == 0) {
                            celdaLectura.setCellValue(field.toString());
                            j++;
                        }
                    } else if (field instanceof BigDecimal) {
                        BigDecimal lectura = (BigDecimal) field;
                        celdaLectura.setCellValue(lectura.doubleValue());
                    }
                }
            }

            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext externalContext = context.getExternalContext();
            externalContext.responseReset();
            externalContext.setResponseContentType("application/vnd.ms-excel");
            externalContext.setResponseHeader("Content-Disposition", "attachment;filename=Reporte estacion " + estacion + ".xls");

            try {
                workbook.write(externalContext.getResponseOutputStream());
                context.responseComplete();
            } catch (IOException ex) {
                Logger.getLogger(EstacionesController.class.getName()).log(Level.SEVERE, null, ex);
                showMessage("No se generó el archivo " + ex.getMessage(), 2);
            }
        } else {
            showMessage("No hay datos para visualizar ", 1);

        }
    }

    /**
     * Valores por defecto para ser cargados en el formulario de inicio de
     * reportes
     */
    public void iniciarFormulario() {
        boolDiario = false;
        boolDiarioLluvia = false;
        boolMensualLluvia = false;
        boolFechaMes = false;
        boolFecha = true;
        idReporte = 0;
        listasensoresEstaciones = new ArrayList<>();
        listaSensores = new ArrayList<>();
        fechainicial = null;
        fechafinal = null;
        RequestContext.getCurrentInstance().update("formularioreportes");

    }

    /**
     * Validar fechas inicial y final con el fin de que el usuario seleccione
     * las fechas adecuadamente
     *
     * @return true despues before antes
     */
    public boolean validarFechas() {
        if (idReporte != 8) {
            if (fechainicial != null && fechafinal != null) {
                return fechainicial.before(fechafinal) || fechainicial.equals(fechafinal);
            } else {
                return false;
            }
        } else {
            return true;
        }

    }

    public Date diaantes() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date()); // Configuramos la fecha que se recibe
        calendar.add(Calendar.DAY_OF_YEAR, -1);  // numero de días a añadir, o restar en caso de días<0
        return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
    }

    /**
     * Consultar todas las estaciones con valor acumuladas según decha inicial y
     * final
     */
    public void getlecturasEstacionesAcumuladas() {
        listaLectEstacionesAcumLluvia = ejbFacade.getLecturasEstaciones(0, fechainicial, fechafinal, 7);
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        if (!listaLectEstacionesAcumLluvia.isEmpty()) {
            Vector encabezado = ((ArrayRecord) listaLectEstacionesAcumLluvia.get(0)).getFields();
            Row filaEncabezado = sheet.createRow(0);
            for (int k = 0; k < encabezado.size(); k++) {
                Cell celdaEncabezado = filaEncabezado.createCell(k);
                String original = (encabezado.get(k).toString());
                celdaEncabezado.setCellValue(original);
            }
            int rowNum = 1;
            for (int i = 0; i < listaLectEstacionesAcumLluvia.size(); i++) {
                Vector lect = ((ArrayRecord) listaLectEstacionesAcumLluvia.get(i)).getValues();
                Row filaLectura = sheet.createRow(rowNum++);
                int colNum = 0;
                int j = 0;
                for (Object field : lect) {
                    Cell celdaLectura = filaLectura.createCell(colNum++);
                    if (field instanceof Date) {
                        if (j == 0) {
                            celdaLectura.setCellValue(field.toString());
                            j++;
                        }
                    } else if (field instanceof BigDecimal) {
                        BigDecimal lectura = (BigDecimal) field;
                        celdaLectura.setCellValue(lectura.doubleValue());
                    }
                    if (field instanceof String) {
                        celdaLectura.setCellValue(field.toString());
                    }
                }

            }

            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext externalContext = context.getExternalContext();
            externalContext.responseReset();
            externalContext.setResponseContentType("application/vnd.ms-excel");
            externalContext.setResponseHeader("Content-Disposition", "attachment;filename=Reporte Acumulado.xls");

            try {
                workbook.write(externalContext.getResponseOutputStream());
                context.responseComplete();
            } catch (IOException ex) {
                Logger.getLogger(EstacionesController.class.getName()).log(Level.SEVERE, null, ex);
                showMessage("No se generó el archivo " + ex.getMessage(), 2);
            }
        } else {
            showMessage("No hay datos para visualizar ", 1);

        }
    }

    /**
     * Consultar todas las estaciones con acumuladas mensuales según decha
     * inicial y final
     */
    public void getlecturasEstacionesAcumuladasMensuales() {

        int anioInicial = Integer.parseInt(getAnioInicio());
        int anioFinal = Integer.parseInt(getAnioFinal());
        int idSensor = 0;
        if (anioInicial < anioFinal) {
            setMesInicio("1");
            setMesFinal("12");
        }
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        if (!estacion.equals("todas")) {
            if (idSensorLectura.intValue() != 0) {
                idSensor = idSensorLectura.intValue();
            }
        } else {
            idSensor = 0;
        }

        listaLectEstacionesAcumLluviaMensuales = ejbFacade.getLecturasLluviasMensuales(Integer.parseInt(getMesInicio()), Integer.parseInt(getAnioInicio()), Integer.parseInt(getMesFinal()), Integer.parseInt(getAnioFinal()), idSensor);
        if (!listaLectEstacionesAcumLluviaMensuales.isEmpty()) {
            Vector encabezado = ((ArrayRecord) listaLectEstacionesAcumLluviaMensuales.get(0)).getFields();
            Row filaEncabezado = sheet.createRow(0);
            for (int k = 0; k < encabezado.size(); k++) {
                Cell celdaEncabezado = filaEncabezado.createCell(k);
                String original = (encabezado.get(k).toString());
                celdaEncabezado.setCellValue(original);
            }
            int rowNum = 1;
            for (int i = 0; i < listaLectEstacionesAcumLluviaMensuales.size(); i++) {
                Vector lect = ((ArrayRecord) listaLectEstacionesAcumLluviaMensuales.get(i)).getValues();
                Row filaLectura = sheet.createRow(rowNum++);
                int colNum = 0;
                int j = 0;
                for (Object field : lect) {
                    Cell celdaLectura = filaLectura.createCell(colNum++);
                    if (field instanceof Date) {
                        if (j == 0) {
                            celdaLectura.setCellValue(field.toString());
                            j++;
                        }
                    } else if (field instanceof BigDecimal) {
                        BigDecimal lectura = (BigDecimal) field;
                        celdaLectura.setCellValue(lectura.doubleValue());
                    }

                }
            }

            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            externalContext.setResponseContentType("application/vnd.ms-Excel");
            externalContext.setResponseHeader("Content-Disposition", "attachment; filename=\"Reportes_Acumado_Mensual_" + estacion + "..xls\"");

            try {
                workbook.write(externalContext.getResponseOutputStream());
            } catch (IOException ex) {
                Logger.getLogger(EstacionesController.class.getName()).log(Level.SEVERE, null, ex);
                showMessage("No se generó el archivo " + ex.getMessage(), 2);
            }
            facesContext.responseComplete();
            fechainicial = null;
            fechafinal = null;
        } else {
            showMessage("No hay datos para visualizar ", 1);
        }
    }

    /**
     * Cambiar el valor del número del mes por el nombre
     *
     * @param mes
     * @return
     */
    public String fechasMesAnio(BigDecimal mes) {
        String mostrarMes = "";
        switch (mes.intValue()) {
            case 1:
                return mostrarMes = "Enero";
            case 2:
                return mostrarMes = "Febrero";
            case 3:
                return mostrarMes = "Marzo";
            case 4:
                return mostrarMes = "Abril";
            case 5:
                return mostrarMes = "Mayo";

            case 6:
                return mostrarMes = "Junio";

            case 7:
                return mostrarMes = "Julio";

            case 8:
                return mostrarMes = "Agosto";

            case 9:
                return mostrarMes = "Septiembre";

            case 10:
                return mostrarMes = "Octubre";

            case 11:
                return mostrarMes = "Noviembre";

            case 12:
                return mostrarMes = "Diciembre";
            default:
                return mostrarMes = "";
        }

    }

    /**
     * Reporte para cualquier tipo de sensor de todas las estaciones
     * exportandolo a excel a través de la librería POI
     *
     * @param Tipo de sensor
     */
    public void getReportesEstacionesPOI(int tipoSensor) {
        if (validarFechasTodasEstaciones(idReporte)) {
            RequestContext.getCurrentInstance().update("formularioreportes");
            listaReporteEstaciones = null;
            Workbook workbook = new HSSFWorkbook();
            Sheet sheet = workbook.createSheet();
            listaReporteEstaciones = ejbFacade.getLecturasEstacionesxTipoSensor(fechainicial, fechafinal, tipoSensor, idReporte);
            if (!listaReporteEstaciones.isEmpty()) {
                Vector encabezado = ((ArrayRecord) listaReporteEstaciones.get(0)).getFields();
                Row filaEncabezado = sheet.createRow(0);
                for (int k = 0; k < encabezado.size(); k++) {
                    Cell celdaEncabezado = filaEncabezado.createCell(k);
                    String original = (encabezado.get(k).toString());
                    String replace = original.replaceAll("^[\"']+|[\"']+$", "");
                    celdaEncabezado.setCellValue(replace);
                }
                int rowNum = 1;
                for (int i = 1; i < listaReporteEstaciones.size(); i++) {
                    Vector lect = ((ArrayRecord) listaReporteEstaciones.get(i)).getValues();
                    Row filaLectura = sheet.createRow(rowNum++);
                    int colNum = 0;
                    int j = 0;
                    for (Object field : lect) {
                        Cell celdaLectura = filaLectura.createCell(colNum++);
                        if (field instanceof Date) {
                            if (j == 0) {
                                celdaLectura.setCellValue(field.toString());
                                j++;
                            }
                        } else if (field instanceof BigDecimal) {
                            BigDecimal lectura = (BigDecimal) field;
                            celdaLectura.setCellValue(lectura.doubleValue());
                        }
                    }
                    /**
                     * Para los tipos de sensores 5 o 1 Lluvia y temperatura se
                     * le agrega al excel formulas al final de cada columna
                     */
                    if (tipoSensor == 5 || tipoSensor == 1) {
                        if (rowNum == listaReporteEstaciones.size()) {
                            ColumnasExcel columnas = new ColumnasExcel();
                            Row filaMaximo = null;
                            Row filaPromedio = null;
                            Row filaAcumulado = null;
                            if (tipoSensor == 1) {
                                filaLectura.setRowNum(rowNum++);
                                Cell celdaMinimo = filaLectura.createCell(0);
                                celdaMinimo.setCellValue("MÍNIMO");
                                filaMaximo = sheet.createRow(filaLectura.getRowNum() + 1);
                                Cell celdaMaximo = filaMaximo.createCell(0);
                                celdaMaximo.setCellValue("MÁXIMO");
                                filaPromedio = sheet.createRow(filaMaximo.getRowNum() + 1);
                                Cell celdaPromedio = filaPromedio.createCell(0);
                                celdaPromedio.setCellValue("PROMEDIO");
                            } else {
                                filaLectura.setRowNum(rowNum++);
                                Cell celdaAcumulado = filaLectura.createCell(0);
                                celdaAcumulado.setCellValue("ACUMULADO");
                            }

                            for (int k = 1; k < colNum; k++) {
                                if (tipoSensor == 1) {
                                    Cell celdaLectura = filaLectura.createCell(k);
                                    String formula1 = "MIN(" + columnas.getColumnas().get(k) + "2:" + columnas.getColumnas().get(k) + listaReporteEstaciones.size() + ")";
                                    celdaLectura.setCellFormula(formula1);

                                    Cell celdaLectura1 = filaMaximo.createCell(k);
                                    String formulaMaximo = "MAX(" + columnas.getColumnas().get(k) + "2:" + columnas.getColumnas().get(k) + listaReporteEstaciones.size() + ")";
                                    celdaLectura1.setCellFormula(formulaMaximo);

                                    Cell celdaLectura2 = filaPromedio.createCell(k);
                                    String formulaPromedio = "ROUND(AVERAGE(" + columnas.getColumnas().get(k) + "2:" + columnas.getColumnas().get(k) + listaReporteEstaciones.size() + "),2)";
                                    celdaLectura2.setCellFormula(formulaPromedio);
                                } else {
                                    Cell celdaLectura3 = filaLectura.createCell(k);
                                    String formulaAcumulado = "ROUND(SUM(" + columnas.getColumnas().get(k) + "2:" + columnas.getColumnas().get(k) + listaReporteEstaciones.size() + "),2)";
                                    celdaLectura3.setCellFormula(formulaAcumulado);
                                }
                            }
                        }
                    }
                }

                FacesContext facesContext = FacesContext.getCurrentInstance();
                ExternalContext externalContext = facesContext.getExternalContext();
                externalContext.setResponseContentType("application/vnd.ms-Excel");
                externalContext.setResponseHeader("Content-Disposition", "attachment; filename=\"Reportes_Todas_Estaciones.xls\"");

                try {
                    workbook.write(externalContext.getResponseOutputStream());
                } catch (IOException ex) {
                    Logger.getLogger(EstacionesController.class.getName()).log(Level.SEVERE, null, ex);
                    showMessage("No se generó el archivo " + ex.getMessage(), 2);
                }
                facesContext.responseComplete();
                fechainicial = null;
                fechafinal = null;
            } else {
                showMessage("No hay datos para visualizar ", 1);
            }
        } else {
            if (idReporte == 2) {
                showMessage("Las fechas seleccionadas deben ser menor o igual a 8 días ", 2);
            }
            if (idReporte == 3) {
                showMessage("Las fechas seleccionadas deben ser menor o igual a 1 año ", 2);
            }

            iniciarFormulario();
        }
    }

    /**
     * Mensajes de validación según el tipo
     *
     * @param message Mensaje que se muestra
     * @param tipoError Tipo de mensaje
     */
    public void showMessage(String message, int tipoError) {
        RequestContext.getCurrentInstance().update("grow2");
        FacesContext context = FacesContext.getCurrentInstance();
        if (tipoError == 1) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso, ", message));
        } else if (tipoError == 2) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error,", message));
        }
    }

    /**
     * Validar el rangosegún la consulta de fechas de consulta
     *
     * @return
     */
    public boolean validarFechasTodasEstaciones(int idReporte) {
        long total = 0;
        long fechaIni = fechainicial.getTime();
        long fechaFin = fechafinal.getTime();
        total = ((fechaFin - fechaIni) / 1000) / 60;
        if (idReporte == 2) {
            return total <= 10080;
        }
        if (idReporte == 3) {
            return total <= 525600;
        }
        if (idReporte == 11 || idReporte == 12 || idReporte == 7) {
            return total <= 44640;
        }
        if (idReporte == 14) {
            return total <= 394200;
        }

        return total <= 10080;
    }

    /**
     * Tipo de reporte 1, Validar el rango mayor a 8 días para el reporte 1
     * (Acumulado diario) Tipo de reporte 3, Validar el rango mayor a 8 días
     * para el reporte 3 (Horario) Tipo de reporte 8, Validar el rango mayor a 8
     * días para el reporte 8 (Acumulado Mensual) Tipo de reporte
     * 11,12,13,Validar el rango mayor a 8 días para el reporte 11,12,13
     * (mínimo,máximo y promedio)
     *
     * @return
     */
    public boolean validarFechasxTipoReporte(int idReporte) {
        long total = 0;
        long fechaIni = fechainicial.getTime();
        long fechaFin = fechafinal.getTime();
        total = ((fechaFin - fechaIni) / 1000) / 60;
        if (idReporte == 1) {
            return total <= 525600*5;
        }
        if (idReporte == 2) {
            return total <= 44640;
        }
        if (idReporte == 3) {
            return total <= 525600*5;
        }
        if (idReporte == 8) {

            return total <= 57600*5;
        }
        if (idReporte == 11 || idReporte == 12 || idReporte == 13) {
            return total <= 1529280;

        }

        return total <= 10080;
    }

    /**
     * Reporte consolidado con valores mínimo, máximos y promedios según el tipo
     * de reporte
     */
    public void getReporteEstacionesConsolidado() {
        if (validarFechasTodasEstaciones(idReporte)) {
            RequestContext.getCurrentInstance().update("formularioreportes");
            listaReporteConsolidados = null;
            Workbook workbook = new HSSFWorkbook();
            Sheet sheet = workbook.createSheet();
            listaReporteConsolidados = ejbFacade.getLecturasxTipoSensorConsolidado(fechafinal, fechafinal, 1);
            if (!listaReporteConsolidados.isEmpty()) {
                Vector encabezado = ((ArrayRecord) listaReporteConsolidados.get(0)).getFields();
                Row filaEncabezado = sheet.createRow(0);
                for (int k = 0; k < encabezado.size(); k++) {
                    Cell celdaEncabezado = filaEncabezado.createCell(k);
                    String original = (encabezado.get(k).toString());
                    String replace = original.replaceAll("^[\"']+|[\"']+$", "");
                    celdaEncabezado.setCellValue(replace);
                }
                int rowNum = 1;
                for (int i = 1; i < listaReporteConsolidados.size(); i++) {
                    Vector lect = ((ArrayRecord) listaReporteConsolidados.get(i)).getValues();
                    Row filaLectura = sheet.createRow(rowNum++);
                    int colNum = 0;
                    int j = 0;
                    for (Object field : lect) {
                        Cell celdaLectura = filaLectura.createCell(colNum++);
                        if (field instanceof Date) {
                            if (j == 0) {
                                celdaLectura.setCellValue(field.toString());
                                j++;
                            }
                        } else if (field instanceof BigDecimal) {
                            BigDecimal lectura = (BigDecimal) field;
                            celdaLectura.setCellValue(lectura.doubleValue());
                        }
                        if (field instanceof String) {
                            celdaLectura.setCellValue(field.toString());
                        }
                    }
                }

                FacesContext facesContext = FacesContext.getCurrentInstance();
                ExternalContext externalContext = facesContext.getExternalContext();
                externalContext.setResponseContentType("application/vnd.ms-Excel");
                externalContext.setResponseHeader("Content-Disposition", "attachment; filename=\"Reportes_Todas_Estaciones.xls\"");

                try {
                    workbook.write(externalContext.getResponseOutputStream());
                } catch (IOException ex) {
                    Logger.getLogger(EstacionesController.class.getName()).log(Level.SEVERE, null, ex);
                    showMessage("No se generó el archivo " + ex.getMessage(), 2);
                }
                facesContext.responseComplete();
                fechainicial = null;
                fechafinal = null;
            } else {
                showMessage("No hay datos para visualizar ", 1);
            }
        } else {
            showMessage("Las fechas seleccionadas deben ser menor o igual a 8 días ", 2);
            iniciarFormulario();
        }

    }

    /**
     * Reporte consolidado para todas las estaciones temperatura media,máxima y
     * mínima diaria
     */
    public void getReporteConosolidadoTemperaturaMaxMinMediaDiaria() {
        if (validarFechasTodasEstaciones(idReporte)) {
            RequestContext.getCurrentInstance().update("formularioreportes");
            listaReporteEstaciones = null;
            Workbook workbook = new HSSFWorkbook();
            Sheet sheet = workbook.createSheet();
            listaReporteEstaciones = ejbFacade.getLecturasEstacionesxTipoSensor(fechainicial, fechafinal, 1, idReporte);
            if (!listaReporteEstaciones.isEmpty()) {
                Vector encabezado = ((ArrayRecord) listaReporteEstaciones.get(0)).getFields();
                Row filaEncabezado = sheet.createRow(0);
                for (int k = 0; k < encabezado.size(); k++) {
                    Cell celdaEncabezado = filaEncabezado.createCell(k);
                    String original = (encabezado.get(k).toString());
                    String replace = original.replaceAll("^[\"']+|[\"']+$", "");
                    celdaEncabezado.setCellValue(replace);
                }
                int rowNum = 1;
                List<String> listaFecha = new ArrayList<>();
                for (int i = 0; i < listaReporteEstaciones.size(); i++) {
                    Vector lect = ((ArrayRecord) listaReporteEstaciones.get(i)).getValues();
                    Row filaLectura = sheet.createRow(rowNum++);
                    int colNum = 0;
                    int j = 0;
                    for (Object field : lect) {
                        Cell celdaLectura = filaLectura.createCell(colNum++);

                        if (field instanceof Date) {
                            if (j == 0) {

                                celdaLectura.setCellValue(field.toString());
                                listaFecha.add(field.toString());
                                j++;
                            }
                        } else if (field instanceof BigDecimal) {
                            BigDecimal lectura = (BigDecimal) field;
                            celdaLectura.setCellValue(lectura.doubleValue());
                        }
                    }

                    switch (idReporte) {
                        case 11:
                            if (rowNum == listaReporteEstaciones.size() + 1) {
                                int limite = listaReporteEstaciones.size() / 360;
                                int c = 361;
                                int b = 2;
                                for (int k = 0; k < limite; k++) {
                                    filaLectura.setRowNum(rowNum++);
                                    Cell celdaMinimo = filaLectura.createCell(0);
                                    celdaMinimo.setCellValue("MÏNIMO DIARIO " + listaFecha.get(b).substring(0, 10));
                                    ColumnasExcel columnas = new ColumnasExcel();

                                    for (int z = 1; z < colNum; z++) {
                                        Cell celdaLectura2 = filaLectura.createCell(z);
                                        String formulaPromedio = "ROUND(MIN(" + columnas.getColumnas().get(z) + b + ":" + columnas.getColumnas().get(z) + c + "),2)";
                                        celdaLectura2.setCellFormula(formulaPromedio);
                                    }
                                    b = b + 360;
                                    c = c + 360;
                                }
                            }
                            break;
                        case 12:
                            if (rowNum == listaReporteEstaciones.size() + 1) {
                                int limite = listaReporteEstaciones.size() / 540;
                                int c = 541;
                                int b = 2;
                                for (int k = 0; k < limite; k++) {
                                    filaLectura.setRowNum(rowNum++);
                                    Cell celdaMinimo = filaLectura.createCell(0);
                                    celdaMinimo.setCellValue("MÁXIMO DIARIO " + listaFecha.get(b).substring(0, 10));
                                    ColumnasExcel columnas = new ColumnasExcel();

                                    for (int z = 1; z < colNum; z++) {
                                        Cell celdaLectura2 = filaLectura.createCell(z);
                                        String formulaPromedio = "ROUND(MAX(" + columnas.getColumnas().get(z) + b + ":" + columnas.getColumnas().get(z) + c + "),2)";
                                        celdaLectura2.setCellFormula(formulaPromedio);
                                    }
                                    b = b + 540;
                                    c = c + 540;
                                }
                            }
                            break;
                        case 14:
                            if (rowNum == listaReporteEstaciones.size() + 1) {
                                int limite = listaReporteEstaciones.size() / 3;
                                int c = 4;
                                int b = 2;
                                for (int k = 0; k < limite; k++) {
                                    filaLectura.setRowNum(rowNum++);
                                    Cell celdaMinimo = filaLectura.createCell(0);
                                    celdaMinimo.setCellValue("MEDIA DIARIA " + listaFecha.get(b).substring(0, 10));
                                    ColumnasExcel columnas = new ColumnasExcel();

                                    for (int z = 1; z < colNum; z++) {
                                        Cell celdaLectura2 = filaLectura.createCell(z);
                                        String formulaPromedio = "ROUND(AVERAGE(" + columnas.getColumnas().get(z) + b + ":" + columnas.getColumnas().get(z) + c + "),2)";
                                        celdaLectura2.setCellFormula(formulaPromedio);
                                    }
                                    b = b + 3;
                                    c = c + 3;
                                }
                            }
                            break;

                    }

                }

                FacesContext facesContext = FacesContext.getCurrentInstance();
                ExternalContext externalContext = facesContext.getExternalContext();
                externalContext.setResponseContentType("application/vnd.ms-Excel");
                externalContext.setResponseHeader("Content-Disposition", "attachment; filename=\"Reportes_Todas_Estaciones.xls\"");

                try {
                    workbook.write(externalContext.getResponseOutputStream());
                } catch (IOException ex) {
                    Logger.getLogger(EstacionesController.class.getName()).log(Level.SEVERE, null, ex);
                    showMessage("No se generó el archivo " + ex.getMessage(), 2);
                }
                facesContext.responseComplete();
                fechainicial = null;
                fechafinal = null;
            } else {
                showMessage("No hay datos para visualizar ", 1);
            }
        } else {
            if (idReporte == 11 || idReporte == 12) {
                showMessage("Las fechas seleccionadas deben ser menor o igual a 31 días ", 2);
            }
            if (idReporte == 14) {
                showMessage("Las fechas seleccionadas deben ser menor o igual a 9 meses ", 2);
            }
            iniciarFormulario();
        }

    }

    /**
     * Mostar los sensores dependiendo de la estación seleccionada
     */
    public void getListarSensoresInternos() {
        sensoresEstaciones = new SensoresEstaciones();
        listasensoresEstaciones = new ArrayList<>();
        if (estacion != null) {

            listaSensores = ejbFacade.getSensoresxEstaciones(idtiposensoresxNombre(estacion).intValue(), 1);
            if (!listaSensores.isEmpty()) {
                ArrayRecord ar = null;
                for (Object list1 : listaSensores) {
                    ar = (ArrayRecord) list1;
                    sensoresEstaciones.setIdtipoSensor((BigDecimal) ar.getValues("TS.IDTIPOSENSOR"));
                    sensoresEstaciones.setIdSensor((BigDecimal) ar.getValues("S.IDSENSOR"));
                    sensoresEstaciones.setTipoSensor((String) ar.getValues("TS.TIPOSENSOR"));
                    sensoresEstaciones.setIdtipoSensor((BigDecimal) ar.getValues("TS.IDTIPOSENSOR"));
                    sensoresEstaciones.setLatitud((BigDecimal) ar.getValues("S.LATITUD"));
                    sensoresEstaciones.setLongitud((BigDecimal) ar.getValues("S.LONGITUD"));
                    sensoresEstaciones.setEstado((BigDecimal) ar.getValues("S.ESTADO"));
                    sensoresEstaciones.setUnidadmedida((String) ar.getValues("TS.UNIDADMEDIDA"));
                    sensoresEstaciones.setEstacion((String) ar.getValues("E.ESTACION"));
                    sensoresEstaciones.setVisible((BigDecimal) ar.getValues("S.VISIBLE"));
                    listasensoresEstaciones.add(sensoresEstaciones);
                    sensoresEstaciones = new SensoresEstaciones();
                }
            }
        }

        RequestContext.getCurrentInstance().update("formularioreportes");
    }

    /**
     * Reporte consolidado de acumulados diarios de lluvia
     */
    public void getReporteAcumulados() {
        if (validarFechasTodasEstaciones(idReporte)) {
            RequestContext.getCurrentInstance().update("formularioreportes");
            listaReporteEstaciones = null;
            Workbook workbook = new HSSFWorkbook();
            Sheet sheet = workbook.createSheet();
            listaReporteEstaciones = ejbFacade.getLecturasEstacionesAcumladas(fechainicial, fechafinal, 5, idReporte);
            if (!listaReporteEstaciones.isEmpty()) {
                Vector encabezado = ((ArrayRecord) listaReporteEstaciones.get(0)).getFields();
                //Se comienza en la celda,columna  1 en el archivo de excel
                Row filaEncabezado = sheet.createRow(1);
                for (int k = 0; k < encabezado.size(); k++) {
                    Cell celdaEncabezado = filaEncabezado.createCell(k);
                    String original = (encabezado.get(k).toString());
                    String replace = original.replaceAll("^[\"']+|[\"']+$", "");
                    celdaEncabezado.setCellValue(replace);
                }
                //Se inicia las lecturas a partir de la fila 2
                int rowNum = 2;
                List<String> listaFecha = new ArrayList<>();
                for (int i = 0; i < listaReporteEstaciones.size(); i++) {
                    Vector lect = ((ArrayRecord) listaReporteEstaciones.get(i)).getValues();
                    Row filaLectura = sheet.createRow(rowNum++);
                    int colNum = 0;
                    int j = 0;
                    for (Object field : lect) {
                        Cell celdaLectura = filaLectura.createCell(colNum++);

                        if (field instanceof Date) {
                            if (j == 0) {

                                celdaLectura.setCellValue(field.toString());
                                listaFecha.add(field.toString());
                                j++;
                            }
                        } else if (field instanceof BigDecimal) {
                            BigDecimal lectura = (BigDecimal) field;
                            celdaLectura.setCellValue(lectura.doubleValue());
                        }
                    }

                    //Agregar formula de conteo de valores
                    if (rowNum == listaReporteEstaciones.size() + 2) {
                        ColumnasExcel columnas = new ColumnasExcel();
                        Row filaConteo = null;
                        filaLectura.setRowNum(rowNum++);
                        Cell celdaMinimo = filaLectura.createCell(0);
                        celdaMinimo.setCellValue("Número de Registros");
                        filaConteo = sheet.createRow(filaLectura.getRowNum() + 1);
                        for (int k = 1; k < colNum; k++) {
                            Cell celdaLectura = filaLectura.createCell(k);
                            String formConteo = "COUNT(" + columnas.getColumnas().get(k) + "3:" + columnas.getColumnas().get(k) + (listaReporteEstaciones.size() + 2) + ")";
                            celdaLectura.setCellFormula(formConteo);

                        }
                    }

                }

                FacesContext facesContext = FacesContext.getCurrentInstance();
                ExternalContext externalContext = facesContext.getExternalContext();
                externalContext.setResponseContentType("application/vnd.ms-Excel");
                externalContext.setResponseHeader("Content-Disposition", "attachment; filename=\"Reportes_Acumulados.xls\"");

                try {
                    workbook.write(externalContext.getResponseOutputStream());
                } catch (IOException ex) {
                    Logger.getLogger(EstacionesController.class.getName()).log(Level.SEVERE, null, ex);
                    showMessage("No se generó el archivo " + ex.getMessage(), 2);
                }
                facesContext.responseComplete();
                fechainicial = null;
                fechafinal = null;
            } else {
                showMessage("No hay datos para visualizar ", 1);
            }
        } else {
            showMessage("Las fechas seleccionadas deben ser menor o igual a 31 días ", 2);
            iniciarFormulario();
        }

    }

    /**
     * Consultar todas las estaciones acumuladas mensuales según decha inicial y
     * final
     */
    public void getlecturasTodasEstacionesAcumuladasMensuales() {

        int anioInicial = Integer.parseInt(getAnioInicio());
        int anioFinal = Integer.parseInt(getAnioFinal());
        if (anioInicial < anioFinal) {
            setMesInicio("1");
            setMesFinal("12");
        }
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        listaLectEstacionesAcumLluviaMensuales = ejbFacade.getLecturasTodasLluviasMensuales(Integer.parseInt(getMesInicio()), Integer.parseInt(getAnioInicio()), Integer.parseInt(getMesFinal()), Integer.parseInt(getAnioFinal()), idTipoSensor);
        if (!listaLectEstacionesAcumLluviaMensuales.isEmpty()) {
            Vector encabezado = ((ArrayRecord) listaLectEstacionesAcumLluviaMensuales.get(0)).getFields();
            Row filaEncabezado = sheet.createRow(0);
            for (int k = 0; k < encabezado.size(); k++) {
                Cell celdaEncabezado = filaEncabezado.createCell(k);
                String original = (encabezado.get(k).toString());
                String replace = original.replaceAll("^[\"']+|[\"']+$", "");
                celdaEncabezado.setCellValue(replace);
            }

            int rowNum = 1;
            for (int i = 0; i < listaLectEstacionesAcumLluviaMensuales.size(); i++) {
                Vector lect = ((ArrayRecord) listaLectEstacionesAcumLluviaMensuales.get(i)).getValues();
                Row filaLectura = sheet.createRow(rowNum++);
                int colNum = 0;
                int j = 0;
                for (Object field : lect) {
                    Cell celdaLectura = filaLectura.createCell(colNum++);
                    if (field instanceof Date) {
                        if (j == 0) {
                            celdaLectura.setCellValue(field.toString());
                            j++;
                        }
                    } else if (field instanceof BigDecimal) {
                        BigDecimal lectura = (BigDecimal) field;
                        celdaLectura.setCellValue(lectura.doubleValue());
                    }

                }
            }

            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            externalContext.setResponseContentType("application/vnd.ms-Excel");
            externalContext.setResponseHeader("Content-Disposition", "attachment; filename=\"Reportes_Acumado_Mensual_" + estacion + "..xls\"");

            try {
                workbook.write(externalContext.getResponseOutputStream());
            } catch (IOException ex) {
                Logger.getLogger(EstacionesController.class.getName()).log(Level.SEVERE, null, ex);
                showMessage("No se generó el archivo " + ex.getMessage(), 2);
            }
            facesContext.responseComplete();
            fechainicial = null;
            fechafinal = null;
        } else {
            showMessage("No hay datos para visualizar ", 1);
        }
    }
}
