/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.conexiones;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Conexión a la base de datos
 *
 * @author admin
 */
public class ConexionPDF {

    private static EntityManagerFactory emf;
    private static ConexionPDF conex;

    private ConexionPDF() {
        emf = Persistence.createEntityManagerFactory("reportessabPU");
    }

    public static ConexionPDF getInstance() {

        if (conex == null) {
            conex = new ConexionPDF();
        }
        return conex;
    }

    public static EntityManagerFactory getInstanceEMF() {
        if (!emf.isOpen()) {
            emf = Persistence.createEntityManagerFactory("reportessabPU");
        }
        return emf;
    }
}
