/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.facade;

import co.gov.idiger.reportessab.entities.PromediosMensuales;
import co.gov.idiger.reportessab.facade.local.PromediosMensualesFacadeLocal;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 * Clase que implementa los métodos generales y específíficos de la clase
 * estaciones y sus relaciones
 *
 * @author lmontes
 */
@Stateless
public class PromediosMensualesFacade extends AbstractFacade<PromediosMensuales> implements PromediosMensualesFacadeLocal {

    @PersistenceContext(unitName = "reportessabPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PromediosMensualesFacade() {
        super(PromediosMensuales.class);
    }

    @Override
    public void insertarPromedioMensual(PromediosMensuales promedioMensual) {
        promedioMensual.setIdPromedioMensuales(obtenerMaximoId());
        em.persist(promedioMensual);
    }

    @Override
    public BigDecimal obtenerMaximoId() {
        BigDecimal ultimovalor = new BigDecimal(BigInteger.ZERO);
        ultimovalor = (BigDecimal) em.createNamedQuery("PromediosMensuales.findMax").getSingleResult();
        if (ultimovalor != null) {
            ultimovalor = ultimovalor.add(BigDecimal.ONE);
        } else {
            ultimovalor = new BigDecimal(BigInteger.ONE);
        }
        return ultimovalor;

    }

    @Override
    public void deletePromediosMensuales() {
        String delete = "DELETE FROM PromediosMensuales p";
        em.createQuery(delete).executeUpdate();
    }

}
