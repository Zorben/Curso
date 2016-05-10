package es.cursillo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class H2 {

	private static final String JDBC_H2_CURSO = "jdbc:h2:~/curso";
	private static final String ORG_H2_DRIVER = "org.h2.Driver";
	Connection h2;

	public H2() {

		try {
			Class.forName(ORG_H2_DRIVER);
			h2 = DriverManager.getConnection(JDBC_H2_CURSO, "sa", "");
		} catch (ClassNotFoundException | SQLException e) {
			new RuntimeException(e);
		}

	}

	public void connect() {

	}

	public int executeSql(String sql) throws SQLException {
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = h2.createStatement();
			String fecha = "02/06/2013";
			String nombre = "gorka";
			sql = "INSERT INTO Batallas (nombre,fecha) VALUES(" + nombre + "," + fecha + ") ;";

			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			throw e;
		} finally {
			closeResultSet(resultSet);
			closeStatement(statement);
		}
		return 0;

	}

	private void closeResultSet(ResultSet resultSet) throws SQLException {
		if (null != resultSet) {
			resultSet.close();
		}
	}

	private void closeStatement(Statement statement) {
		try {
			if (null != statement) {
				statement.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean isConnected() {
		return null != h2;
	}

	public void close() {
		if (null != h2) {
			try {
				h2.close();
			} catch (SQLException e) {
				new RuntimeException(e);
			}
		}
	}

}
