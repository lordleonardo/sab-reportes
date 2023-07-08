package co.gov.idiger.reportessab.beans;

import co.gov.idiger.reportessab.entities.Usuarios;
import co.gov.idiger.reportessab.seguridad.Encriptar;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class UsuariosController implements Serializable {

    @EJB
    private co.gov.idiger.reportessab.facade.local.UsuariosFacadeLocal ejbFacade;
    private Usuarios usuarios;

    public UsuariosController() {
        usuarios = new Usuarios();
    }

    @PostConstruct
    public void init() {
        usuarios = new Usuarios();
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * Validar inicio de sesión del usuario que ingresa
     *
     * @return
     */
    public String validarUsuario() {
        String redireccion = "";
        Usuarios usu;
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            validarAcceso();
            usu = ejbFacade.login(usuarios);
            if (usu != null) {
                context.getExternalContext().getSessionMap().put("usuario", usu);
                redireccion = "menu.xhtml";
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales Incorrectas"));
            }
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
        }
        return redireccion;
    }

    /**
     * Verificar la sesión del usuario logueado
     */
    public void verificarSesion() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            Usuarios usu = (Usuarios) context.getExternalContext().getSessionMap().get("usuario");
            if (usu == null) {
                context.getExternalContext().redirect("../index.xhtml");
            }
        } catch (Exception e) {
        }
    }

    /**
     * Validar la clave del usuario encriptada
     */
    public void validarAcceso() {

        try {
//            System.out.println("contrasena = " + usuarios.getClave());
//            System.out.println("contrasenaencr = " + contrasenaencr);
            usuarios.setClave(Encriptar.encrypt(usuarios.getClave()));

        } catch (GeneralSecurityException ex) {
            System.out.println("ex = " + ex.getMessage());
        } catch (UnsupportedEncodingException ex) {
        }

    }

}
