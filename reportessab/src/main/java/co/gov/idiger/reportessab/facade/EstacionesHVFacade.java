/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.facade;

import co.gov.idiger.reportessab.entities.Estaciones;
import co.gov.idiger.reportessab.entities.EstacionesHV;
import co.gov.idiger.reportessab.entities.Mantenimientos;
import co.gov.idiger.reportessab.entities.Observaciones;
import co.gov.idiger.reportessab.entities.SensoresInstalados;
import co.gov.idiger.reportessab.facade.local.EstacionesHVFacadeLocal;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
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
public class EstacionesHVFacade extends AbstractFacade<Estaciones> implements EstacionesHVFacadeLocal {

    @PersistenceContext(unitName = "reportessabPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstacionesHVFacade() {
        super(Estaciones.class);
    }

    @Override
    public List getEstacionesHV(int idEstacion) {
        EntityManager em = null;
        em = getEntityManager();
        StoredProcedureCall call = new StoredProcedureCall();
        call.setProcedureName("PSIDISAT.PESTACIONESHV");
        call.addNamedArgumentValue("VIDESTACION", new Integer(idEstacion));
        call.useNamedCursorOutputAsResultSet("CIDESTACION");
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

    @Override
    public List<SensoresInstalados> getListaSensoresxEstacionesCNE(int idEstacioncne) {
        EntityManager em = null;
        em = getEntityManager();
        StoredProcedureCall call = new StoredProcedureCall();
        call.setProcedureName("PSIDISAT.PSENSORESINSTESTACIONESCNE");
        call.addNamedArgumentValue("VIDESTACIONCNE", new Integer(idEstacioncne));
        call.useNamedCursorOutputAsResultSet("CIDESTACIONCNE");
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
    public List<Mantenimientos> getListaMantenimientoxEstacionesCNE(int idEstacioncne) {
        EntityManager em = null;
        em = getEntityManager();
        StoredProcedureCall call = new StoredProcedureCall();
        call.setProcedureName("PSIDISAT.PMANTENIMIENTOSCNE");
        call.addNamedArgumentValue("VIDESTACIONCNE", new Integer(idEstacioncne));
        call.useNamedCursorOutputAsResultSet("CIDESTACIONCNE");
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
    public List<Observaciones> getListaObservacionesxEstacionesCNE(int idEstacioncne) {
        EntityManager em = null;
        em = getEntityManager();
        StoredProcedureCall call = new StoredProcedureCall();
        call.setProcedureName("PSIDISAT.POBSERVACIONESCNE");
        call.addNamedArgumentValue("VIDESTACIONCNE", new Integer(idEstacioncne));
        call.useNamedCursorOutputAsResultSet("CIDESTACIONCNE");
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
    public void guardarEstacionesCNE(EstacionesHV ehv) {
        EntityManager em = null;
        em = getEntityManager();
        Query nativeQuery = em.createNativeQuery("UPDATE ESTACIONESCNE SET CODIGOCNE=? , TIPO= ?,IDESTACION=?,DEPARTAMENTO=? "
                + ",MUNICIPIO=? ,AREAOPERATIVA=? ,ESCENARIORIESGO=? ,LUGARMONITOREO=? ,TIPOMONITOREO=?,TIPOTRANSMISION=?  WHERE IDESTACIONCNE = ?");
        nativeQuery.setParameter(1, ehv.getCodigoCNE());
        nativeQuery.setParameter(2, ehv.getTipo());
        nativeQuery.setParameter(3, ehv.getIdestacion());
        nativeQuery.setParameter(4, ehv.getDepto());
        nativeQuery.setParameter(5, ehv.getCiudad());
        nativeQuery.setParameter(6, ehv.getArea());
        nativeQuery.setParameter(7, ehv.getEscenarioRiesgo());
        nativeQuery.setParameter(8, ehv.getLugarMonitoreo());
        nativeQuery.setParameter(9, ehv.getTipoMonitoreo());
        nativeQuery.setParameter(10, ehv.getTipoTransmision());
        nativeQuery.setParameter(11, ehv.getIdestacioncne());
        nativeQuery.executeUpdate();

    }

    @Override
    public void guardarSensoresCNE(SensoresInstalados si) {
        EntityManager em = null;
        em = getEntityManager();
        Query nativeQuery = em.createNativeQuery("UPDATE SENSORESINSTALADOS SET IDESTACIONCNE=? , TIPOSENSOR= ?,FECHAINSTALACION=?,FECHASERIE=? "
                + ",FECHAMETADATOS=? ,ESTADO=? WHERE IDSENSORESINSTALADOS = ?");
        nativeQuery.setParameter(1, si.getIdEstacionCne());
        nativeQuery.setParameter(2, si.getTipoSensor());
        nativeQuery.setParameter(3, si.getFechaInstalacion());
        nativeQuery.setParameter(4, si.getFechaSerie());
        nativeQuery.setParameter(5, si.getFechaMetaDatos());
        nativeQuery.setParameter(6, si.getEstado());
        nativeQuery.setParameter(7, si.getIdSensoresInstalados());
        nativeQuery.executeUpdate();
    }

    @Override
    public void guardarMantenimientosCNE(Mantenimientos m) {
        EntityManager em = null;
        em = getEntityManager();
        Query nativeQuery = em.createNativeQuery("INSERT INTO MANTENIMIENTOS VALUES (?,?,?,?,?,?,?)");
        nativeQuery.setParameter(1, m.getIdMantenimiento());
        nativeQuery.setParameter(2, m.getIdEstacionCNE());
        nativeQuery.setParameter(3, m.getDocumento());
        nativeQuery.setParameter(4, m.getIdtipoMantenimiento());
        nativeQuery.setParameter(5, m.getFechaInicio());
        nativeQuery.setParameter(6, new Date());
        nativeQuery.setParameter(7, m.getDescripcion());
        nativeQuery.executeUpdate();
    }

    @Override
    public BigDecimal getUltimoMantenimientos() {
        BigDecimal ultimovalor = new BigDecimal(BigInteger.ZERO);
        ultimovalor = (BigDecimal) em.createNativeQuery("SELECT MAX(M.IDMANTENIMIENTO) FROM MANTENIMIENTOS M").getSingleResult();
        if (ultimovalor != null) {
            ultimovalor = ultimovalor.add(BigDecimal.ONE);
        } else {
            ultimovalor = new BigDecimal(BigInteger.ONE);
        }
        return ultimovalor;
    }

    @Override
    public void guardarObservacionesCNE(Observaciones o) {
        EntityManager em = null;
        em = getEntityManager();
        Query nativeQuery = em.createNativeQuery("INSERT INTO OBSERVACIONES VALUES (?,?,?,?,?)");
        nativeQuery.setParameter(1, o.getIdObservaciones());
        nativeQuery.setParameter(2, o.getObservacion());
        nativeQuery.setParameter(3, new Date());
        nativeQuery.setParameter(4, 1);
        nativeQuery.setParameter(5, o.getIdEstacioncne());
        nativeQuery.executeUpdate();
    }

    @Override
    public BigDecimal getUltimoObservacion() {
        BigDecimal ultimovalor = new BigDecimal(BigInteger.ZERO);
        ultimovalor = (BigDecimal) em.createNativeQuery("SELECT MAX(O.IDOBSERVACIONES) FROM OBSERVACIONES O").getSingleResult();
        if (ultimovalor != null) {
            ultimovalor = ultimovalor.add(BigDecimal.ONE);
        } else {
            ultimovalor = new BigDecimal(BigInteger.ONE);
        }
        return ultimovalor;
    }
}
