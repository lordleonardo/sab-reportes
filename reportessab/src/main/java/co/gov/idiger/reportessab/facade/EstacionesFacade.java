/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.facade;

import co.gov.idiger.reportessab.conexiones.Conexion;
import co.gov.idiger.reportessab.entities.Estaciones;
import co.gov.idiger.reportessab.entities.Localidades;
import co.gov.idiger.reportessab.entities.MrArchivoDat;
import co.gov.idiger.reportessab.entities.Nivelesvalores;
import co.gov.idiger.reportessab.entities.Tipossensores;
import co.gov.idiger.reportessab.entities.UmbralesNiveles;
import co.gov.idiger.reportessab.entities.UmbralesNivelesR;
import co.gov.idiger.reportessab.facade.local.EstacionesFacadeLocal;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.eclipse.persistence.internal.sessions.ArrayRecord;
import org.eclipse.persistence.jpa.JpaEntityManager;
import org.eclipse.persistence.queries.DataReadQuery;
import org.eclipse.persistence.queries.StoredProcedureCall;

/**
 * Clase que implementa los métodos generales y específíficos de la clase
 * estaciones y sus relaciones
 *
 * @author admin
 */
@Stateless
public class EstacionesFacade extends AbstractFacade<Estaciones> implements EstacionesFacadeLocal {

    @PersistenceContext(unitName = "reportessabPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstacionesFacade() {
        super(Estaciones.class);
    }

    /**
     * Obtener las estaciones por tipo hidrometeorológicas
     */
    @Override
    public List getEstacionesxTipoEstacion() {
        EntityManager em = null;
        em = getEntityManager();

        StoredProcedureCall call = new StoredProcedureCall();
        call.setProcedureName("PSIDISAT.PESTACIONESHIDROMETEROLOGICAS");
        call.addNamedArgumentValue("VIDTIPOESTACION", new Integer(1));
        call.useNamedCursorOutputAsResultSet("CESTACIONESHIDROMETEROLOGICAS");
        DataReadQuery databaseQuery = new DataReadQuery();
        databaseQuery.setCall(call);

        Query query = ((JpaEntityManager) em.getDelegate()).createQuery(databaseQuery);
        List result = query.getResultList();

        return result;
    }

    /**
     * Obtener los sensores por estacion desde un procedimiento almacenado
     *
     * @param idestacion, sinterno(sensores para monitoreo interno)
     * @return lista con los valores de sensores dependiendo del idestacion
     */
    @Override
    public List getSensoresxEstaciones(int idestacion, int sinterno) {
        EntityManager em = null;
        em = getEntityManager();
        StoredProcedureCall call = new StoredProcedureCall();
        call.setProcedureName("PSIDISAT.PPROCESARSENSORESXESTACIONES");
        call.addNamedArgumentValue("VIDESTACION", new Integer(idestacion));
        call.addNamedArgumentValue("VIINTERNO", new Integer(sinterno));
        call.useNamedCursorOutputAsResultSet("CSENSORESXESTACIONES");
        DataReadQuery databaseQuery = new DataReadQuery();
        databaseQuery.setCall(call);

        Query query = ((JpaEntityManager) em.getDelegate()).createQuery(databaseQuery);
        List result = query.getResultList();
        return result;
    }

    /**
     * Obtener las lecturas de la estacion
     *
     * @param idsensor
     * @param fechainicial
     * @param fechafinal
     * @param tiporeporte tipo de reporte 0 lecturas por id sensor, 1 cálculos
     * consolidados
     * @return lista con las lecturas asociadas a el idsensor
     */
    @Override
    public List getLecturasxSensor(int idsensor, Date fechainicial, Date fechafinal, int tiporeporte) {
        EntityManager em = null;
        em = getEntityManager();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMMM/yyyy");
        StoredProcedureCall call = new StoredProcedureCall();
        call.setProcedureName("PSIDISAT.PCONSULTARLECTURAS");
        call.addNamedArgumentValue("VIDSENSOR", new Integer(idsensor));
        call.addNamedArgumentValue("VFECHAINICIO", sdf.format(fechainicial));
        call.addNamedArgumentValue("VFECHAFIN", sdf.format(fechafinal));
        call.addNamedArgumentValue("VTIPOREPORTE", new Integer(tiporeporte));
        call.useNamedCursorOutputAsResultSet("CREGISTROS");
        DataReadQuery databaseQuery = new DataReadQuery();
        databaseQuery.setCall(call);

        Query query = ((JpaEntityManager) em.getDelegate()).createQuery(databaseQuery);
        List result = query.getResultList();
        return result;
    }

    /**
     * Obtener las lecturas de todas las estacion por sensor fecha inicial,final
     * y tipo de reporte
     *
     * @param idsensor
     * @param fechainicial
     * @param fechafinal
     * @param tiporeporte tipo de reporte 0 lecturas por id sensor, 1 cálculos
     * consolidados
     * @return lista con las lecturas asociadas a el idsensor
     */
    @Override
    public List getLecturasEstaciones(int idsensor, Date fechainicial, Date fechafinal, int tiporeporte) {
        EntityManager em = null;
        em = getEntityManager();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMMM/yyyy");
        StoredProcedureCall call = new StoredProcedureCall();
        call.setProcedureName("PSIDISAT.PCONSULTARLECTURAS");
        call.addNamedArgumentValue("VIDSENSOR", new Integer(idsensor));
        call.addNamedArgumentValue("VFECHAINICIO", sdf.format(fechainicial));
        call.addNamedArgumentValue("VFECHAFIN", sdf.format(fechafinal));
        call.addNamedArgumentValue("VTIPOREPORTE", new Integer(tiporeporte));
        call.useNamedCursorOutputAsResultSet("CREGISTROS");
        DataReadQuery databaseQuery = new DataReadQuery();
        databaseQuery.setCall(call);
        Query query = ((JpaEntityManager) em.getDelegate()).createQuery(databaseQuery);
        List result = query.getResultList();
        return result;
    }

    /**
     * Método para traer las estaciones del Sire
     *
     * @return Lista llena con la tabla MR_ARCHIVO_DAT de Sire
     * @throws SQLException
     * @throws Exception
     */
    @Override
    public List<MrArchivoDat> getEstacionesSire() {
        LinkedList<MrArchivoDat> listaEstaciones;
        MrArchivoDat estacionesSire = new MrArchivoDat();
        Connection conexion = null;
        ResultSet rs = null;
        try {
            conexion = Conexion.conectar();
            conexion.setAutoCommit(true);
            listaEstaciones = new LinkedList<MrArchivoDat>();
            Statement st = conexion.createStatement();

            String sql = "SELECT * FROM MR_ARCHIVO_DAT@MR "
                    + "WHERE MAD_TIPO_ESTA='Lluvias'";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                estacionesSire = new MrArchivoDat();
                Long idMad = rs.getLong("MAD_ID");
                estacionesSire.setMadId(idMad);
                estacionesSire.setMadPath(rs.getString("MAD_PATH"));
                estacionesSire.setMadNameFile(rs.getString("MAD_NAME_FILE"));
                estacionesSire.setMadFechCrea(rs.getDate("MAD_FECH_CREA"));
                estacionesSire.setMadFechUlti(rs.getDate("MAD_FECH_ULTI"));
                estacionesSire.setMadEstado(rs.getString("MAD_ESTADO"));
                estacionesSire.setMadFechModi(rs.getDate("MAD_FECH_MODI"));
                Long idLineaProc = rs.getLong("MAD_LINE_PROC");
                estacionesSire.setMadLineProc(idLineaProc);
                estacionesSire.setMadNombre(rs.getString("MAD_NOMBRE"));
                estacionesSire.setMadDireccion(rs.getString("MAD_DIRECCION"));
                estacionesSire.setMadTipoGraf(rs.getString("MAD_TIPO_GRAF"));
                BigDecimal idvalorProc;
                idvalorProc = rs.getBigDecimal("MAD_VALOR_COTA");
                estacionesSire.setMadValorCota(idvalorProc);
                estacionesSire.setMadTipoEsta(rs.getString("MAD_TIPO_ESTA"));
                BigDecimal idalertaAma;
                idalertaAma = rs.getBigDecimal("MAD_ALER_AMAR");
                estacionesSire.setMadAlerAmar(idalertaAma);
                BigDecimal idalertaNar;
                idalertaNar = rs.getBigDecimal("MAD_ALER_NARA");
                estacionesSire.setMadAlerNara(idalertaNar);
                BigDecimal idalertaRoja;
                idalertaRoja = rs.getBigDecimal("MAD_ALER_ROJA");
                estacionesSire.setMadAlerRoja(idalertaRoja);
                Short idAcumulado = rs.getShort("MSG_ID_ACUMLL");
                estacionesSire.setMsgIdAcumll(idAcumulado);
                estacionesSire.setMadCalcHora(rs.getString("MAD_CALC_HORA"));
                Short idIntensidad = rs.getShort("MSG_ID_INTENS");
                estacionesSire.setMsgIdIntens(idIntensidad);
                estacionesSire.setMadTipoFuente(rs.getString("MAD_TIPO_FUENTE"));
                Short ordenRptLluvias = rs.getShort("ORDEN_RPT_LLUVIAS");
                estacionesSire.setOrdenRptLluvias(ordenRptLluvias);
                estacionesSire.setHumedadTemperatura(rs.getString("HUMEDAD_TEMPERATURA"));
                Short ordenRptRhb = rs.getShort("ORDEN_RPT_RHB");
                estacionesSire.setOrdenRptRhb(ordenRptRhb);
                listaEstaciones.add(estacionesSire);
            }
            return listaEstaciones;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("getEstacionesSire = " + e.getMessage());
        } finally {

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EstacionesFacade.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EstacionesFacade.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return null;
    }

    /**
     * Método para traer las estaciones del Sire
     *
     * @return Lista llena con la tabla MR_ARCHIVO_DAT de Sire
     * @throws SQLException
     * @throws Exception
     */
    @Override
    public List getEstacionesSireSidisat(int idLocalidad) {
        //Inicializa objeEtos de JPA
        EntityManager em = null;
        em = getEntityManager();
        StoredProcedureCall call = new StoredProcedureCall();
        call.setProcedureName("PSIDISAT.PESTACIONESSIRESAB");
        call.addNamedArgumentValue("VIDTIPOESTACION", new Integer(1));
        call.addNamedArgumentValue("VIDLOCALIDAD", new Integer(idLocalidad));
        call.useNamedCursorOutputAsResultSet("CESTACIONESSIRESAB");
        DataReadQuery databaseQuery = new DataReadQuery();
        databaseQuery.setCall(call);

        Query query = ((JpaEntityManager) em.getDelegate()).createQuery(databaseQuery);
        List result = query.getResultList();
        return result;
    }

    /**
     * Método para listar el reporte mensual de lluvias acumuladas
     *
     * @param mesinicial
     * @param anioinicial
     * @param mesfinal
     * @param aniofinal
     * @param idSensor
     * @return Lista con el reporte mensual
     */
    @Override
    public List getLecturasLluviasMensuales(int mesinicial, int anioinicial, int mesfinal, int aniofinal, int idSensor) {
        EntityManager em = null;
        em = getEntityManager();
        StoredProcedureCall call = new StoredProcedureCall();
        call.setProcedureName("PSIDISAT.PREPORTEMENSUALLLUVIAS");
        call.addNamedArgumentValue("VMESINICIAL", new Integer(mesinicial));
        call.addNamedArgumentValue("VANIOINICIAL", new Integer(anioinicial));
        call.addNamedArgumentValue("VMESFINAL", new Integer(mesfinal));
        call.addNamedArgumentValue("VANIOFINAL", new Integer(aniofinal));
        call.addNamedArgumentValue("VIDSENSOR", new Integer(idSensor));
        call.useNamedCursorOutputAsResultSet("CREPORTEMENSUALLLUVIAS");
        DataReadQuery databaseQuery = new DataReadQuery();
        databaseQuery.setCall(call);
        Query query = ((JpaEntityManager) em.getDelegate()).createQuery(databaseQuery);
        List result = query.getResultList();
        Iterator i = result.iterator();
        return result;
    }

    /**
     * Obtener todas las lecturas de las estaciones según el tipo de sensor
     * seleccionado
     *
     * @param fechaInicial
     * @param fechaFinal
     * @param tipoSensor
     * @param idReporte
     * @return
     */
    @Override
    public List getLecturasEstacionesxTipoSensor(Date fechaInicial, Date fechaFinal, int tipoSensor, int idReporte) {
        EntityManager em = null;
        em = getEntityManager();
        StoredProcedureCall call = new StoredProcedureCall();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMMM/yyyy");
        call.setProcedureName("PA_REPORTES");
        call.addNamedArgumentValue("P_TIPOSENSOR", new Integer(tipoSensor));
        call.addNamedArgumentValue("P_TIPOREPORTE", new Integer(idReporte));
        call.addNamedArgumentValue("VFECHAINICIO", sdf.format(fechaInicial));
        call.addNamedArgumentValue("VFECHAFIN", sdf.format(fechaFinal));
        call.useNamedCursorOutputAsResultSet("P_SALIDA");
        DataReadQuery databaseQuery = new DataReadQuery();
        databaseQuery.setCall(call);
        Query query = ((JpaEntityManager) em.getDelegate()).createQuery(databaseQuery);
        List result = query.getResultList();
        Iterator i = result.iterator();

        return result;
    }

    /**
     * Obtener todas las estaciones según el tipo de sensor seleccionado
     *
     * @param idTipoSensor
     * @return
     */
    @Override
    public List<Estaciones> getEstacionxTipoSensor(int idTipoSensor) {
        EntityManager em = null;
        em = getEntityManager();
        List<Estaciones> listaEstaciones = new ArrayList<>();
        Query nativeQuery = em.createNativeQuery("SELECT E.IDESTACION,E.ESTACION FROM ESTACIONES E INNER JOIN SENSORES S ON S.IDESTACION=E.IDESTACION WHERE S.IDTIPOSENSOR =?  AND S.ESTADO=1 AND S.VISIBLE=1 ORDER BY E.ESTACION", Estaciones.class);
        nativeQuery.setParameter(1, idTipoSensor);
        listaEstaciones = nativeQuery.getResultList();
        return listaEstaciones;

    }

    /**
     * Obtener todas las estaciones de nivel
     *
     * @return Lista de nivel
     */
    @Override
    public List<Estaciones> getEstacionesNiveles() {
        EntityManager em = null;
        em = getEntityManager();
        Query nativeQuery = em.createNativeQuery("SELECT E.* FROM ESTACIONES E, SENSORES S WHERE S.IDESTACION = E.IDESTACION AND E.IDPROPIETARIO!=7 AND S.IDTIPOSENSOR = 3 AND S.ESTADO=1 AND S.VISIBLE=1 ORDER BY E.ESTACION", Estaciones.class);
        return nativeQuery.getResultList();
    }

    /**
     * Obtener los valores de los niveles para la gráfica
     *
     * @param idEstacion
     * @return
     */
    @Override
    public List<Nivelesvalores> getNivelesvaloresxEstacion(int idEstacion) {
        EntityManager em = null;
        em = getEntityManager();
        Query nativeQuery = em.createNativeQuery("SELECT NV.* FROM NIVELESVALORES NV INNER JOIN SENSORES S ON S.IDSENSOR= NV.IDSENSOR INNER JOIN ESTACIONES ES ON ES.IDESTACION=S.IDESTACION WHERE S.ESTADO=1 AND S.VISIBLE=1 AND ES.IDESTACION=? ORDER BY NV.FECHACREACION DESC", Nivelesvalores.class);
        nativeQuery.setParameter(1, idEstacion);
        return nativeQuery.getResultList();
    }

    /**
     * Insertar los valores para la gráfica niveles
     *
     * @param valores de niveles
     */
    @Override
    public void guardarNivelesValores(Nivelesvalores n) {
        EntityManager em = null;
        em = getEntityManager();
        Query nativeQuery = em.createNativeQuery("INSERT INTO NIVELESVALORES  VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
        nativeQuery.setParameter(1, n.getIdnivelesvalores());
        nativeQuery.setParameter(2, n.getCotasensor());
        nativeQuery.setParameter(3, n.getMinsensor());
        nativeQuery.setParameter(4, n.getCotabm());
        nativeQuery.setParameter(5, n.getNiveldesbordamiento());
        nativeQuery.setParameter(6, n.getValorreferencia());
        nativeQuery.setParameter(7, n.getObservacion());
        nativeQuery.setParameter(8, n.getFechaCreacion());
        nativeQuery.setParameter(9, n.getIdusuario());
        nativeQuery.setParameter(10, n.getIdsensor().getIdsensor());
        nativeQuery.setParameter(11, n.getEstado());
        nativeQuery.setParameter(12, n.getIdLectura());
        nativeQuery.executeUpdate();
        actualizarNiveles(n);
    }

    /**
     * Obtener el último valor de la tabla niveles valores para ser insertado un
     * nuevo valor
     *
     * @return ultimo valor de la tabla
     */
    @Override
    public BigDecimal getUltimoNivelesValores() {
        BigDecimal ultimovalor = new BigDecimal(BigInteger.ZERO);
        ultimovalor = (BigDecimal) em.createNativeQuery("SELECT MAX(N.IDNIVELESVALORES) FROM NIVELESVALORES N").getSingleResult();
        if (ultimovalor != null) {
            ultimovalor = ultimovalor.add(BigDecimal.ONE);
        } else {
            ultimovalor = new BigDecimal(BigInteger.ONE);
        }
        return ultimovalor;
    }

    /**
     * Obtener el IdSensor según la estación de nivel
     *
     * @param i idEstación
     * @return IdSensor
     */
    @Override
    public BigDecimal getObtenerSensorxEstacion(int i) {
        BigDecimal idSensor = new BigDecimal(BigInteger.ZERO);
        Query nativeQuery = (Query) em.createNativeQuery("SELECT S.IDSENSOR FROM SENSORES S INNER JOIN ESTACIONES E ON E.IDESTACION=S.IDESTACION WHERE S.IDTIPOSENSOR=3 AND S.IDESTACION=?");
        nativeQuery.setParameter(1, i);
        idSensor = (BigDecimal) nativeQuery.getSingleResult();
        return idSensor;
    }

    /**
     * Actualizar campos de la tabla niveles para la gráfica
     *
     * @param Objeto de niveles valores
     */
    @Override
    public void actualizarNiveles(Nivelesvalores nvls) {
        EntityManager em = null;
        em = getEntityManager();
        Query nativeQuery = em.createNativeQuery("UPDATE NIVELES SET NIVELDESBORDAMIENTO= ? , COTASENSOR = ?,MINSENSOR=?,IDTIPOLECTURA=? WHERE IDSENSOR = ?");
        nativeQuery.setParameter(1, nvls.getNiveldesbordamiento());
        nativeQuery.setParameter(2, nvls.getCotasensor());
        nativeQuery.setParameter(3, nvls.getMinsensor());
        nativeQuery.setParameter(4, nvls.getIdLectura());
        nativeQuery.setParameter(5, nvls.getIdsensor().getIdsensor());
        nativeQuery.executeUpdate();
    }

    /**
     * Obtener los valores de niveles valores según el idsensor
     *
     * @param id Sensor
     * @return Niveles valores
     */
    @Override
    public Nivelesvalores getNivelesvaloresxSensor(int i) {
        EntityManager em = null;
        em = getEntityManager();
        List<Nivelesvalores> lista = new ArrayList<>();
        Query nativeQuery = em.createNativeQuery("SELECT NV.* FROM NIVELESVALORES NV WHERE NV.IDSENSOR=?", Nivelesvalores.class);
        nativeQuery.setParameter(1, i);
        lista = nativeQuery.getResultList();

        if (!lista.isEmpty()) {
            Nivelesvalores niveles = new Nivelesvalores();
            niveles = Collections.max(lista, new Comparator<Nivelesvalores>() {
                @Override
                public int compare(Nivelesvalores o1, Nivelesvalores o2) {
                    if (o1.getIdnivelesvalores().intValue() == o2.getIdnivelesvalores().intValue()) {
                        return 0;
                    } else if (o1.getIdnivelesvalores().intValue() > o2.getIdnivelesvalores().intValue()) {
                        return 1;
                    } else if (o1.getIdnivelesvalores().intValue() < o2.getIdnivelesvalores().intValue()) {
                        return -1;
                    }
                    return 0;
                }
            });
            return niveles;
        }
        return null;
    }

    /**
     * Obtener los tipos de sensores para el reporte
     *
     * @return Tipos de sensores
     */
    @Override
    public List<Tipossensores> getTipoSensores() {
        EntityManager em = null;
        em = getEntityManager();
        Query nativeQuery = em.createNativeQuery("SELECT T.* FROM TIPOSSENSORES T WHERE IDTIPOSENSOR IN (1,2,3,5,8,10,11)", Tipossensores.class);
        return nativeQuery.getResultList();
    }

    /**
     * Obtener lecturas de las estaciones según el tipo de sensor seleccionado
     *
     * @param fechainicial
     * @param fechafinal
     * @param idTiposensor
     * @return
     */
    @Override
    public List getLecturasxTipoSensorConsolidado(Date fechainicial, Date fechafinal, int idTiposensor) {
        EntityManager em = null;
        em = getEntityManager();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMMM/yyyy");
        StoredProcedureCall call = new StoredProcedureCall();
        call.setProcedureName("PA_REPORTES_CONSOLIDADO");
        call.addNamedArgumentValue("P_TIPOSENSOR", new Integer(idTiposensor));
        call.addNamedArgumentValue("VFECHAINICIAL", sdf.format(fechainicial));
        call.addNamedArgumentValue("VFECHAFINAL", sdf.format(fechafinal));
        call.useNamedCursorOutputAsResultSet("P_SALIDA");
        DataReadQuery databaseQuery = new DataReadQuery();
        databaseQuery.setCall(call);
        Query query = ((JpaEntityManager) em.getDelegate()).createQuery(databaseQuery);
        List result = query.getResultList();
        Iterator i = result.iterator();
//        System.out.println("result = " + result.get(0).toString());
//        while (i.hasNext()) {
//
//            ArrayRecord ar = (ArrayRecord) i.next();
//            System.out.println(ar.values());
//        }
        return result;
    }

    @Override
    public List getLecturasEstacionesAcumladas(Date fechaInicial, Date fechaFinal, int tipoSensor, int idReporte) {
        EntityManager em = null;
        em = getEntityManager();
        StoredProcedureCall call = new StoredProcedureCall();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMMM/yyyy");
        call.setProcedureName("PA_ACUMULADOS");
        call.addNamedArgumentValue("P_TIPOSENSOR", new Integer(tipoSensor));
        call.addNamedArgumentValue("P_TIPOREPORTE", new Integer(idReporte));
        call.addNamedArgumentValue("VFECHAINICIO", sdf.format(fechaInicial));
        call.addNamedArgumentValue("VFECHAFIN", sdf.format(fechaFinal));
        call.useNamedCursorOutputAsResultSet("P_SALIDA");
        DataReadQuery databaseQuery = new DataReadQuery();
        databaseQuery.setCall(call);
        Query query = ((JpaEntityManager) em.getDelegate()).createQuery(databaseQuery);
        List result = query.getResultList();
        Iterator i = result.iterator();
        return result;
    }

    @Override
    public List getLecturasTodasLluviasMensuales(int mesinicial, int anioinicial, int mesfinal, int aniofinal, int idTipoSensor) {
        EntityManager em = null;
        em = getEntityManager();
        StoredProcedureCall call = new StoredProcedureCall();
        call.setProcedureName("PA_ACUMULADOS_MES");
        call.addNamedArgumentValue("VMESINICIAL", mesinicial);
        call.addNamedArgumentValue("VANIOINICIAL", anioinicial);
        call.addNamedArgumentValue("VMESFINAL", mesfinal);
        call.addNamedArgumentValue("VANIOFINAL", aniofinal);
        call.addNamedArgumentValue("P_TIPOSENSOR", idTipoSensor);
        call.useNamedCursorOutputAsResultSet("P_SALIDA");
        DataReadQuery databaseQuery = new DataReadQuery();
        databaseQuery.setCall(call);
        Query query = ((JpaEntityManager) em.getDelegate()).createQuery(databaseQuery);
        List result = query.getResultList();
        Iterator i = result.iterator();
        return result;
    }

    @Override
    public List<Localidades> getLocalidades() {
        List<Localidades> listaLocalidades = new ArrayList<>();
        try {
            listaLocalidades = em.createNamedQuery("Localidades.findAll", Localidades.class).getResultList();
            return listaLocalidades;
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            return listaLocalidades;
        }
    }

    /**
     * Obtener los umbrales de las estaciones de niveles
     *
     * @return
     */
    @Override
    public List getUmbralesNiveles() {
        EntityManager em = null;
        em = getEntityManager();
        StoredProcedureCall call = new StoredProcedureCall();
        call.setProcedureName("PSIDISAT.PUMBRALESNIVELES");
        call.useNamedCursorOutputAsResultSet("CUMBRALESNIVELES");
        DataReadQuery databaseQuery = new DataReadQuery();
        databaseQuery.setCall(call);
        Query query = ((JpaEntityManager) em.getDelegate()).createQuery(databaseQuery);
        List result = query.getResultList();
//        Iterator i = result.iterator();
//        System.out.println("result = " + result.get(0).toString());
//        while (i.hasNext()) {
//
//            ArrayRecord ar = (ArrayRecord) i.next();
//            System.out.println(ar.values());
//        }
        return result;
    }

    /**
     * Obtener las estaciones de niveles
     *
     * @return
     */
    @Override
    public List getUmbralesEstacionesNiveles() {
        EntityManager em = null;
        em = getEntityManager();
        StoredProcedureCall call = new StoredProcedureCall();
        call.setProcedureName("PSIDISAT.PUMBRALESESTACIONESNIVELES");
        call.useNamedCursorOutputAsResultSet("CUMBRALESESTACIONESNIVELES");
        DataReadQuery databaseQuery = new DataReadQuery();
        databaseQuery.setCall(call);
        Query query = ((JpaEntityManager) em.getDelegate()).createQuery(databaseQuery);
        List result = query.getResultList();
//        Iterator i = result.iterator();
//        System.out.println("result = " + result.get(0).toString());
//        while (i.hasNext()) {
//
//            ArrayRecord ar = (ArrayRecord) i.next();
//            System.out.println(ar.values());
//        }
        return result;
    }

    /**
     * Obtener el último valor de la tabla niveles valores para ser insertado un
     * nuevo valor
     *
     * @return ultimo valor de la tabla
     */
    @Override
    public BigDecimal getUltimoUmbralesNiveles() {
        BigDecimal ultimovalor = new BigDecimal(BigInteger.ZERO);
        ultimovalor = (BigDecimal) em.createNativeQuery("SELECT MAX(U.IDUMBRALES) FROM UMBRALESNIVELES U").getSingleResult();
        if (ultimovalor != null) {
            ultimovalor = ultimovalor.add(BigDecimal.ONE);
        } else {
            ultimovalor = new BigDecimal(BigInteger.ONE);
        }
        return ultimovalor;
    }

    @Override
    public void getGuardarUmbralesNiveles(UmbralesNiveles umbralesNiveles) {
        EntityManager em = null;
        em = getEntityManager();
        Query nativeQuery = em.createNativeQuery("INSERT INTO UMBRALESNIVELES  VALUES (?,?,?,?,?,?,?,?)");
        nativeQuery.setParameter(1, umbralesNiveles.getIdUmbrales());
        nativeQuery.setParameter(2, umbralesNiveles.getIdNiveles());
        nativeQuery.setParameter(3, umbralesNiveles.getNivelAlto());
        nativeQuery.setParameter(4, umbralesNiveles.getNivelMedio());
        nativeQuery.setParameter(5, umbralesNiveles.getNivelBajo());
        nativeQuery.setParameter(6, umbralesNiveles.getFechaCreacion());
        nativeQuery.setParameter(7, umbralesNiveles.getFechaModificacion());
        nativeQuery.setParameter(8, umbralesNiveles.getIdUsuario());
        nativeQuery.executeUpdate();
    }

    @Override
    public void actualizarUmbralesNiveles(UmbralesNiveles umbralesNiveles) {
        EntityManager em = null;
        em = getEntityManager();
        Query nativeQuery = em.createNativeQuery("UPDATE UMBRALESNIVELES SET NIVELALTO= ? , NIVELMEDIO = ?,NIVELBAJO=?,FECHAMODIFICACION=? ,IDUSUARIO=? WHERE IDUMBRALES= ?");
        nativeQuery.setParameter(1, umbralesNiveles.getNivelAlto());
        nativeQuery.setParameter(2, umbralesNiveles.getNivelMedio());
        nativeQuery.setParameter(3, umbralesNiveles.getNivelBajo());
        nativeQuery.setParameter(4, umbralesNiveles.getFechaModificacion());
        nativeQuery.setParameter(5, umbralesNiveles.getIdUsuario());
        nativeQuery.setParameter(6, umbralesNiveles.getIdUmbrales());
        nativeQuery.executeUpdate();
    }
}
