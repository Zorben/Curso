package es.cursillo.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class H2 {

	private static final String JDBC_H2_CURSO = "jdbc:h2:~/curso";
	private static final String ORG_H2_DRIVER = "org.h2.Driver";
	Connection h2;


	public void connect() {
		try {
			Class.forName(ORG_H2_DRIVER);
			h2 = DriverManager.getConnection(JDBC_H2_CURSO, "sa", "");
		} catch (ClassNotFoundException | SQLException e) {
			new RuntimeException(e);
		}
	}

	public int executeSql(String sql) throws SQLException {
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = h2.prepareStatement(sql);
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			throw e;
		} finally {
			closeResultSet(resultSet);
			closeStatement(statement);
		}
		return 0;

	}
/*

DROP ALIAS IF EXISTS ADDUSER;
CREATE ALIAS ADDUSER AS $$
import java.util.Date; 
@CODE 
int addUser(String pname, Date birthday, float money) { 
return 15; 
} 
$$;

 */
	public int executeSampleCall() throws SQLException {
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			CallableStatement cs = null;
			ResultSet rs = null;
			String sql = "{? = CALL ADDUSER(?,?,?)}";
			cs = h2.prepareCall(sql);
			cs.setString(2, "ps name");
			cs.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			cs.setFloat(4, 100f);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.executeQuery();
			System.out.println(cs.getInt(1));
			// resultSet = statement.executeQuery(sql);
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
