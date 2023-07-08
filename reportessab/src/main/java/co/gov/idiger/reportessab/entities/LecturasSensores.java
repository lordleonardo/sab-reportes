/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.entities;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author admin
 */
public class LecturasSensores {
        private BigDecimal idlectura;
        private BigDecimal idsensor;
        private Date fechalectura;
        private BigDecimal valorlectura;
        private BigDecimal codestadolectura;

        public BigDecimal getCodestadolectura() {
            return codestadolectura;
        }

        public void setCodestadolectura(BigDecimal codestadolectura) {
            this.codestadolectura = codestadolectura;
        }

        public BigDecimal getValorlectura() {
            return valorlectura;
        }

        public void setValorlectura(BigDecimal valorlectura) {
            this.valorlectura = valorlectura;
        }

        public BigDecimal getIdlectura() {
            return idlectura;
        }

        public void setIdlectura(BigDecimal idlectura) {
            this.idlectura = idlectura;
        }

        public BigDecimal getIdsensor() {
            return idsensor;
        }

        public void setIdsensor(BigDecimal idsensor) {
            this.idsensor = idsensor;
        }

        public Date getFechalectura() {
            return fechalectura;
        }

        public void setFechalectura(Date fechalectura) {
            this.fechalectura = fechalectura;
        }

}
