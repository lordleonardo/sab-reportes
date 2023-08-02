/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.beans;

import co.gov.idiger.reportessab.entities.MaximosMensuales;
import co.gov.idiger.reportessab.entities.PromediosMensuales;
import co.gov.idiger.reportessab.entities.Sensores;
import co.gov.idiger.reportessab.facade.local.MaximosMensualesFacadeLocal;
import co.gov.idiger.reportessab.facade.local.PromediosMensualesFacadeLocal;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author lmontes Esta clase se encarga de subir los datos tomados de un
 * archivo excel
 */
@ManagedBean
@ViewScoped
public class PromediosMensualesController implements Serializable {

    @EJB
    private PromediosMensualesFacadeLocal ejbFacade;
    @EJB
    private MaximosMensualesFacadeLocal ejbFacadeMaximos;
    private List<PromediosMensuales> listaPromedios = null;
    private List<MaximosMensuales> listaMaximos = null;
    private boolean promedio;
    private boolean maximo;

    public List<PromediosMensuales> getListaPromedios() {
        listaPromedios = ejbFacade.findAll();
        return listaPromedios;
    }

    public void setListaPromedios(List<PromediosMensuales> listaPromedios) {
        this.listaPromedios = listaPromedios;
    }

    public List<MaximosMensuales> getListaMaximos() {
        listaMaximos = ejbFacadeMaximos.findAll();
        return listaMaximos;
    }

    public void setListaMaximos(List<MaximosMensuales> listaMaximos) {
        this.listaMaximos = listaMaximos;
    }

    public boolean isPromedio() {
        return promedio;
    }

    public void setPromedio(boolean promedio) {
        this.promedio = promedio;
    }

    public boolean isMaximo() {
        return maximo;
    }

    public void setMaximo(boolean maximo) {
        this.maximo = maximo;
    }

    @PostConstruct
    public void init() {
        getListaPromedios();
        getListaMaximos();
        if(!listaPromedios.isEmpty() || !listaMaximos.isEmpty()){
         promedio = true;
         maximo=true;
         FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("form:idListaPromedio");
         FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("form:idListaMaximos");
        }
    }

    /**
     * Método encargado para importar archivo de excel XLS
     *
     * @param event
     */
    public void handleFileUpload(FileUploadEvent event) {
        try {
            UploadedFile uploadedFile = event.getFile();
            String fileName = uploadedFile.getFileName();

            // Validar la extensión del archivo
            if (!fileName.toLowerCase().endsWith(".xls")) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de carga", "Solo se permiten archivos XLS.");
                FacesContext.getCurrentInstance().addMessage(null, message);
                return;
            }
            InputStream inputStream = event.getFile().getInputstream();
            Workbook workbook = new HSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0); // Obtén la primera hoja del archivo
            PromediosMensuales promediosMensuales = null;
            ejbFacade.deletePromediosMensuales();
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                promediosMensuales = new PromediosMensuales();
                promediosMensuales.setSensores(new Sensores());
                promediosMensuales.setEstacion(row.getCell(0).getStringCellValue());
                double idSenosr = row.getCell(1).getNumericCellValue();
                promediosMensuales.getSensores().setIdsensor(BigDecimal.valueOf(idSenosr));
                promediosMensuales.setEnero(row.getCell(2).getNumericCellValue());
                promediosMensuales.setFebrero(row.getCell(3).getNumericCellValue());
                promediosMensuales.setMarzo(row.getCell(4).getNumericCellValue());
                promediosMensuales.setAbril(row.getCell(5).getNumericCellValue());
                promediosMensuales.setMayo(row.getCell(6).getNumericCellValue());
                promediosMensuales.setJunio(row.getCell(7).getNumericCellValue());
                promediosMensuales.setJulio(row.getCell(8).getNumericCellValue());
                promediosMensuales.setAgosto(row.getCell(9).getNumericCellValue());
                promediosMensuales.setSeptiembre(row.getCell(10).getNumericCellValue());
                promediosMensuales.setOctubre(row.getCell(11).getNumericCellValue());
                promediosMensuales.setNoviembre(row.getCell(12).getNumericCellValue());
                promediosMensuales.setDiciembre(row.getCell(13).getNumericCellValue());
                promediosMensuales.setAnual(row.getCell(14).getNumericCellValue());
                promediosMensuales.setPeriodoReferencia(row.getCell(15).getStringCellValue());
                promediosMensuales.setnAnioCompletos(row.getCell(16).getNumericCellValue());
                promediosMensuales.setObservaciones(row.getCell(17).getStringCellValue());
                ejbFacade.insertarPromedioMensual(promediosMensuales);
                promedio = true;

            }
            getListaPromedios();
            sheet = workbook.getSheetAt(1); // Obtén la primera hoja del archivo
            MaximosMensuales maximosMensuales = null;
            ejbFacadeMaximos.deleteMaximosMensuales();
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {

                Row row = sheet.getRow(i);
                maximosMensuales = new MaximosMensuales();
                maximosMensuales.setSensores(new Sensores());
                maximosMensuales.setEstacion(row.getCell(0).getStringCellValue());
                double idSenosr = row.getCell(1).getNumericCellValue();
                maximosMensuales.getSensores().setIdsensor(BigDecimal.valueOf(idSenosr));
                maximosMensuales.setEnero(row.getCell(2).getNumericCellValue());
                maximosMensuales.setFebrero(row.getCell(3).getNumericCellValue());
                maximosMensuales.setMarzo(row.getCell(4).getNumericCellValue());
                maximosMensuales.setAbril(row.getCell(5).getNumericCellValue());
                maximosMensuales.setMayo(row.getCell(6).getNumericCellValue());
                maximosMensuales.setJunio(row.getCell(7).getNumericCellValue());
                maximosMensuales.setJulio(row.getCell(8).getNumericCellValue());
                maximosMensuales.setAgosto(row.getCell(9).getNumericCellValue());
                maximosMensuales.setSeptiembre(row.getCell(10).getNumericCellValue());
                maximosMensuales.setOctubre(row.getCell(11).getNumericCellValue());
                maximosMensuales.setNoviembre(row.getCell(12).getNumericCellValue());
                maximosMensuales.setDiciembre(row.getCell(13).getNumericCellValue());
                maximosMensuales.setAnual(row.getCell(14).getNumericCellValue());
                ejbFacadeMaximos.insertarMaximosMensual(maximosMensuales);
                maximo = true;

            }
            getListaMaximos();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Carga exitosa", "El archivo se cargó y se actualizó correctamente."));

            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de carga", "Solo se permiten archivos XLS.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

}
