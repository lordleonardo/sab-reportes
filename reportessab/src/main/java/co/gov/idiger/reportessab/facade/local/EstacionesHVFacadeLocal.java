/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.facade.local;

import co.gov.idiger.reportessab.entities.Estaciones;
import co.gov.idiger.reportessab.entities.EstacionesHV;
import co.gov.idiger.reportessab.entities.Mantenimientos;
import co.gov.idiger.reportessab.entities.Observaciones;
import co.gov.idiger.reportessab.entities.SensoresInstalados;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface EstacionesHVFacadeLocal {

    void create(Estaciones estaciones);

    void edit(Estaciones estaciones);

    void remove(Estaciones estaciones);

    Estaciones find(Object id);

    List<Estaciones> findAll();

    List<Estaciones> findRange(int[] range);

    List getEstacionesHV(int idEstacion);

    List<SensoresInstalados> getListaSensoresxEstacionesCNE(int idEstacioncne);

    List<Mantenimientos> getListaMantenimientoxEstacionesCNE(int idEstacioncne);

    List<Observaciones> getListaObservacionesxEstacionesCNE(int idEstacioncne);

    void guardarEstacionesCNE(EstacionesHV estacionesHV);

    void guardarSensoresCNE(SensoresInstalados sensoresInstalados);

    void guardarMantenimientosCNE(Mantenimientos mantenimientos);

    BigDecimal getUltimoMantenimientos();
    
    void guardarObservacionesCNE(Observaciones observaciones);
    
    BigDecimal getUltimoObservacion();
    
}
