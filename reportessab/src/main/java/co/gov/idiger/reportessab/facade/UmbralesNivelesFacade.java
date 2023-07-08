/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.facade;

import co.gov.idiger.reportessab.entities.UmbralesNiveles;
import co.gov.idiger.reportessab.facade.local.UmbralesNivelesFacadeLocal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 * Clase que implementa los métodos generales y específíficos de la clase
 * UltimoConsolidado y sus relaciones
 *
 * @author admin
 */
@Stateless
public class UmbralesNivelesFacade extends AbstractFacade<UmbralesNiveles> implements UmbralesNivelesFacadeLocal {
    @PersistenceContext(unitName = "reportessabPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UmbralesNivelesFacade() {
        super(UmbralesNiveles.class);
    }

    
}
