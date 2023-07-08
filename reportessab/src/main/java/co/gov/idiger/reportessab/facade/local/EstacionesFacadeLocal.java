/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.facade.local;

import co.gov.idiger.reportessab.entities.Estaciones;
import co.gov.idiger.reportessab.entities.Localidades;
import co.gov.idiger.reportessab.entities.MrArchivoDat;
import co.gov.idiger.reportessab.entities.Nivelesvalores;
import co.gov.idiger.reportessab.entities.Tipossensores;
import co.gov.idiger.reportessab.entities.UmbralesNiveles;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface EstacionesFacadeLocal {

    void create(Estaciones accionJudicial);

    void edit(Estaciones accionJudicial);

    void remove(Estaciones accionJudicial);

    Estaciones find(Object id);

    List<Estaciones> findAll();

    List<Estaciones> findRange(int[] range);

    int count();

    List getSensoresxEstaciones(int idestacion, int interno);

    List getLecturasxSensor(int idsensor, Date fechainicial, Date fechafinal, int tiporeporte);

    List getLecturasEstaciones(int idsensor, Date fechainicial, Date fechafinal, int tiporeporte);

    List getLecturasLluviasMensuales(int mesinicial, int anioinicial, int mesfinal, int aniofinal, int idSensor);

    List getEstacionesxTipoEstacion();

    List<MrArchivoDat> getEstacionesSire();

    List getEstacionesSireSidisat(int idLocalidad);

    List getLecturasEstacionesxTipoSensor(Date fechainicial, Date fechafinal, int idTipoSensor, int idReporte);

    List<Estaciones> getEstacionxTipoSensor(int idTipoSensor);

    List<Estaciones> getEstacionesNiveles();

    List<Nivelesvalores> getNivelesvaloresxEstacion(int idEstacion);

    void guardarNivelesValores(Nivelesvalores nivelesvalores);

    void actualizarNiveles(Nivelesvalores niveles);

    BigDecimal getUltimoNivelesValores();

    BigDecimal getObtenerSensorxEstacion(int idestacion);

    Nivelesvalores getNivelesvaloresxSensor(int idsensor);

    List<Tipossensores> getTipoSensores();

    List getLecturasxTipoSensorConsolidado(Date fechainicial, Date fechafinal, int idTipoSensor);

    List getLecturasEstacionesAcumladas(Date fechainicial, Date fechafinal, int idTipoSensor, int idReporte);

    List getLecturasTodasLluviasMensuales(int mesinicial, int anioinicial, int mesfinal, int aniofinal, int idTipoSensor);

    List<Localidades> getLocalidades();

    List getUmbralesNiveles();

    List getUmbralesEstacionesNiveles();

    BigDecimal getUltimoUmbralesNiveles();

    void getGuardarUmbralesNiveles(UmbralesNiveles umbralesNiveles);

    void actualizarUmbralesNiveles(UmbralesNiveles umbralesNiveles);
}
