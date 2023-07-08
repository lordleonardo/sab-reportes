/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.facade;

import co.gov.idiger.reportessab.entities.UltimoConsolidado;
import co.gov.idiger.reportessab.facade.local.UltimoConsolidadoFacadeLocal;
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
public class UltimoConsolidadoFacade extends AbstractFacade<UltimoConsolidado> implements UltimoConsolidadoFacadeLocal {
    @PersistenceContext(unitName = "reportessabPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UltimoConsolidadoFacade() {
        super(UltimoConsolidado.class);
    }

    
}
