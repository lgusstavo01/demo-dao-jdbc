package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	private static Connection conn = null;

	public static Connection getConnecttion() {
		if (conn == null) {
			try {
				Properties props = loadPropertiaes();
				String urldb = props.getProperty("dburl");
				conn = DriverManager.getConnection(urldb, props);
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}

	private static Properties loadPropertiaes() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}

	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	public static void closeStatement(Statement st) {
		if (st != null)
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
	}
	
	public static void closeResultset(ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
	}
	
	public static void rollbackTransaction(Connection conn, Exception e) {
        if (conn != null) {
            try {
                conn.rollback();
                throw new DbException("Update error: " + e.getMessage());
            } catch (SQLException ex) {
                throw new DbException("Erro crítico no rollback: " + ex.getMessage());
            }
        } else {
            throw new DbException("Conexão inexistente para rollback.");
        }
    }

}
