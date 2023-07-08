/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.facade.local;

import co.gov.idiger.reportessab.entities.UltimoConsolidado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface UltimoConsolidadoFacadeLocal {

    void create(UltimoConsolidado ultimoConsolidado);

    void edit(UltimoConsolidado ultimoConsolidado);

    void remove(UltimoConsolidado ultimoConsolidado);

    UltimoConsolidado find(Object id);

    List<UltimoConsolidado> findAll();

    List<UltimoConsolidado> findRange(int[] range);

    int count();

}
