/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.facade.local;

import co.gov.idiger.reportessab.entities.PromediosMensuales;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface PromediosMensualesFacadeLocal {

    void create(PromediosMensuales promediosMensuales);
    
    void insertarPromedioMensual(PromediosMensuales promediosMensuales);

    void edit(PromediosMensuales promediosMensuales);

    void remove(PromediosMensuales promediosMensuales);

    PromediosMensuales find(Object id);

    List<PromediosMensuales> findAll();

    List<PromediosMensuales> findRange(int[] range);

    int count();
    
    BigDecimal obtenerMaximoId();
    
   void deletePromediosMensuales();

}
