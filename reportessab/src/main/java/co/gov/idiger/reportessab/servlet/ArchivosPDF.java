/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.servlet;

import co.gov.idiger.reportessab.conexiones.ConexionBD;
import co.gov.idiger.reportessab.entities.Mantenimientos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class ArchivosPDF {

    public void guardarMantenimiento(Mantenimientos mantenimientos) {
        Connection conexion = ConexionBD.conectar();
        PreparedStatement ps = null;
        String sql = "INSERT INTO MANTENIMIENTOS VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, getUltimoMantenimientos());
            ps.setInt(2, mantenimientos.getIdEstacionCNE().intValue());
            ps.setInt(3, mantenimientos.getDocumento().intValue());
            ps.setInt(4, mantenimientos.getIdtipoMantenimiento().intValue());
            ps.setDate(5, new java.sql.Date(new java.util.Date().getTime()));
            ps.setDate(6, new java.sql.Date(new java.util.Date().getTime()));
            ps.setString(7, mantenimientos.getDescripcion());
            ps.setString(8, "SAB");
            ps.setString(9, mantenimientos.getUrl());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ArchivosPDF.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ex = " + ex.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception ex) {
                System.out.println("el error es el siguiente " + ex.getMessage() + ":)");
            }
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (Exception ex) {
                System.out.println("el error es el siguiente " + ex.getMessage() + ":)");
            }
        }
    }

    public int getUltimoMantenimientos() {
        Connection conexion = ConexionBD.conectar();
        int idMantenimiento = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement("SELECT MAX(M.IDMANTENIMIENTO) FROM MANTENIMIENTOS M");
            rs = ps.executeQuery();
            while (rs.next()) {
                idMantenimiento = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("ex = " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception ex) {
                System.out.println("el error es el siguiente " + ex.getMessage() + ":)");
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception ex) {
                System.out.println("el error es el siguiente " + ex.getMessage() + ":)");
            }
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (Exception ex) {
                System.out.println("el error es el siguiente " + ex.getMessage() + ":)");
            }
        }
        return idMantenimiento + 1;
    }

    public String getUrl(int idMantenimiento) {
        Connection conexion = ConexionBD.conectar();
        String url = " ";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement("SELECT URL FROM MANTENIMIENTOS WHERE IDMANTENIMIENTO=?");
            ps.setInt(1, idMantenimiento);
            rs = ps.executeQuery();
            while (rs.next()) {
                url = rs.getString(1);
            }
        } catch (SQLException ex) {
            System.out.println("ex getUrl= " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception ex) {
                System.out.println("el error es el siguiente getUrl" + ex.getMessage() + ":)");
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception ex) {
                System.out.println("el error es el siguiente getUrl" + ex.getMessage() + ":)");
            }
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (Exception ex) {
                System.out.println("el error es el siguiente getUrl" + ex.getMessage() + ":)");
            }
        }
        return url;
    }

}
