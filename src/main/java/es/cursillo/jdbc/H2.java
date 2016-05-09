package es.cursillo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class H2 {

	Connection h2;

	public void connect() {
		try {
			Class.forName("org.h2.Driver");
			h2 = DriverManager.getConnection("jdbc:h2:~/curso", "sa", "");
		} catch (ClassNotFoundException | SQLException e) {
			new RuntimeException(e);
		}

	}

	public void executeSql(String sql) throws SQLException {
		Statement statement = null;
		try {
			statement = h2.createStatement();
			statement.executeQuery(sql);
		} catch (SQLException e) {
			throw e;
		} finally {
			closeStatement(statement);
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
