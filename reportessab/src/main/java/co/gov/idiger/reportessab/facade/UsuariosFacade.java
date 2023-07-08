/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.facade;

import co.gov.idiger.reportessab.entities.Usuarios;
import co.gov.idiger.reportessab.facade.local.UsuariosFacadeLocal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 * Clase que implementa los métodos generales y específíficos de la clase
 * Usuarios y sus relaciones
 *
 * @author admin
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> implements UsuariosFacadeLocal {
    @PersistenceContext(unitName = "reportessabPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    /**
     * Validar y obtener el usuario logueado en el aplicativo
     * @param usu
     * @return 
     */
    @Override
   public Usuarios login(Usuarios usu){
   try {
            Usuarios usuario = em.createNamedQuery("Usuarios.login", Usuarios.class).setParameter("usuario", usu.getUsuario()).setParameter("clave", usu.getClave()).setParameter("estado", 1).getSingleResult();
            if (usuario != null) {
                return usuario;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("login = " + e.getMessage());
            return null;
        }
   }
    
}
