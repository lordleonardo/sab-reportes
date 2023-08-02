/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.facade;

import co.gov.idiger.reportessab.entities.MaximosMensuales;
import co.gov.idiger.reportessab.facade.local.MaximosMensualesFacadeLocal;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Clase que implementa los métodos generales y específíficos de la clase
 * estaciones y sus relaciones
 *
 * @author lmontes
 */
@Stateless
public class MaximosMensualesFacade extends AbstractFacade<MaximosMensuales> implements MaximosMensualesFacadeLocal {

    @PersistenceContext(unitName = "reportessabPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaximosMensualesFacade() {
        super(MaximosMensuales.class);
    }

    @Override
    public void insertarMaximosMensual(MaximosMensuales maximosMensuales) {
        maximosMensuales.setIdMaximosMensuales(obtenerMaximoId());
        em.persist(maximosMensuales);
    }

    @Override
    public BigDecimal obtenerMaximoId() {
        BigDecimal ultimovalor = new BigDecimal(BigInteger.ZERO);
        ultimovalor = (BigDecimal) em.createNamedQuery("MaximosMensuales.findMax").getSingleResult();
        if (ultimovalor != null) {
            ultimovalor = ultimovalor.add(BigDecimal.ONE);
        } else {
            ultimovalor = new BigDecimal(BigInteger.ONE);
        }
        return ultimovalor;

    }

    @Override
    public void deleteMaximosMensuales() {
        String delete = "DELETE FROM MaximosMensuales p";
        em.createQuery(delete).executeUpdate();
    }

}
