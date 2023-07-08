/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.facade.local;

import co.gov.idiger.reportessab.entities.UmbralesNiveles;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface UmbralesNivelesFacadeLocal {

    void create(UmbralesNiveles umbralesNiveles);

    void edit(UmbralesNiveles umbralesNiveles);

    void remove(UmbralesNiveles umbralesNiveles);

    UmbralesNiveles find(Object id);

    List<UmbralesNiveles> findAll();

    List<UmbralesNiveles> findRange(int[] range);

    int count();
    
}
