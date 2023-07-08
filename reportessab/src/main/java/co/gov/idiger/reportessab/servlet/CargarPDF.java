/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.servlet;

import co.gov.idiger.reportessab.entities.Mantenimientos;
import idiger.lib.ftp.Ftp;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author USER
 */
@WebServlet(name = "CargarPDF", urlPatterns = {"/CargarPDF"})
public class CargarPDF extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ArchivosPDF archivopdf = new ArchivosPDF();
    Mantenimientos mantenimientosCrear = new Mantenimientos();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String fecha = null;
            String descripcion = null;
            String idtipomantenimiento = null;
            String idestacioncne = null;
            String idusuario = null;
            String ruta = "SAB";
            String nombreArchivo = "";
            Ftp ftp = new Ftp();
            int estadoConFtp = 0;
            boolean flagFtp = true;

            try {
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                List<FileItem> items = upload.parseRequest(request);
                for (FileItem item : items) {
                    if (item.isFormField()) { // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
                        if (item.getFieldName().equals("fechaInic")) {
                            fecha = item.getString();
                        }
                        if (item.getFieldName().equals("iddescripcionIn")) {
                            descripcion = item.getString();
                        }
                        if (item.getFieldName().equals("idtipomantenimientoIn")) {
                            idtipomantenimiento = item.getString();
                        }
                        if (item.getFieldName().equals("idestacioncne")) {
                            idestacioncne = item.getString();
                        }
                        if (item.getFieldName().equals("idusuario")) {
                            idusuario = item.getString();
                        }
                    } else { // Process form file field (input type="file").  
//                        System.out.println("item = " + item.getName());
//                        if (!"".equals(item.getName())) {
//                            if (estadoConFtp == 0) {
//                                if (ftp.conectar()) {
//                                    estadoConFtp = 1;
//                                } else {
//                                    flagFtp = false;
//                                    continue;
//                                }
//                            }
//                        }
                        ftp.conectar();
                        nombreArchivo = normalizarString(item.getName());
                        if (ftp.cambiarCarpeta(ruta)) {
                            ftp.enviarArchivo(nombreArchivo, new ByteArrayInputStream(item.get()));
                            ftp.desconectar();
                        }
                    }
                }
            } catch (Exception ex) {
                ftp.desconectar();
            }
            if (!fecha.equals("")) {
                Date fechaInicia = new SimpleDateFormat("yyyy-mm-dd").parse(fecha);
                mantenimientosCrear.setIdEstacionCNE(new BigDecimal(idestacioncne));
                mantenimientosCrear.setIdtipoMantenimiento(new BigDecimal(idtipomantenimiento));
                mantenimientosCrear.setDocumento(new BigDecimal(idusuario));
                mantenimientosCrear.setDescripcion(descripcion);
                mantenimientosCrear.setFechaInicio(fechaInicia);
                mantenimientosCrear.setUrl(nombreArchivo);

                archivopdf.guardarMantenimiento(mantenimientosCrear);
            }
        } catch (IOException ex) {
        } catch (ParseException ex) {
            Logger.getLogger(CargarPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("/reportessab/faces/estaciones/crearEstacionesHV.xhtml");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public String normalizarString(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }
}
