package co.gov.idiger.reportessab.conexiones;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Clase para conectarse con la base de datos Oracle en el esquema de SIDISAT
 *
 * @author Lmontes
 *
 */
public class ConexionBD {

    private static Connection cnn = null;
    private static Logger log = Logger.getLogger(ConexionBD.class.getName());

    public ConexionBD() {
    }

    public Connection getConnection() {
        return cnn;
    }

    public void closeConexion() throws SQLException {
        cnn.close();
    }

    public static Connection conectar() {

        try {
            InitialContext context = new InitialContext();
            DataSource datasource = (DataSource) context.lookup("jdbc/sidisat");
            cnn = datasource.getConnection();
        } catch (SQLException | NamingException ex) {
            log.log(Level.WARNING, "error conectar= {0}-{1}", new Object[]{ex.getMessage(), ConexionBD.class.getName()});
        }
        return cnn;
    }

}
