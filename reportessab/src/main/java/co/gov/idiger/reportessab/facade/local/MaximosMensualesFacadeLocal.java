/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.facade.local;

import co.gov.idiger.reportessab.entities.MaximosMensuales;
import co.gov.idiger.reportessab.entities.PromediosMensuales;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface MaximosMensualesFacadeLocal {

    void create(MaximosMensuales maximosMensuales);
    
    void insertarMaximosMensual(MaximosMensuales maximosMensuales);

    void edit(MaximosMensuales maximosMensuales);

    void remove(MaximosMensuales maximosMensuales);

    MaximosMensuales find(Object id);

    List<MaximosMensuales> findAll();

    List<MaximosMensuales> findRange(int[] range);

    int count();
    
    BigDecimal obtenerMaximoId();
    
   void deleteMaximosMensuales();

}
