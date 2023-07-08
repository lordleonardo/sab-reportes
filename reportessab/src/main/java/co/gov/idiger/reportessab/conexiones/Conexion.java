/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.idiger.reportessab.conexiones;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Conexión a la base de datos de SIRE
 *
 * @author admin
 */
public class Conexion {

    public static Connection con_oracle;

    public static Connection conectar() throws Exception {

        InputStream inputStream = null;
        try {
            Properties prop = new Properties();
            String propFileName = "Bundle.properties";
            inputStream = Conexion.class.getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            prop.load(inputStream);

            String url = "fopaescan.fopaedom.local";
            String puerto = "1521";
            String servicio = "siredb";
            String usuario = "SIRE";
            String clave = "a5y73jnhwx";

            Class.forName("oracle.jdbc.OracleDriver");

            String cadena = "jdbc:oracle:thin:@(DESCRIPTION= (LOAD_BALANCE=on) (ADDRESS=(PROTOCOL=TCP)(HOST=" + url + ")(PORT=" + puerto + ")) (CONNECT_DATA=(SERVICE_NAME=" + servicio + ")))";
            con_oracle = DriverManager.getConnection(cadena, usuario, clave);
//            System.out.println("Conexion con Oracle Establecida..");

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return con_oracle;
    }
}
