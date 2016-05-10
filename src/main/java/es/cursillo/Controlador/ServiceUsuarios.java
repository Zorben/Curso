package es.cursillo.Controlador;

import java.util.ArrayList;
import java.util.List;

import es.cursillo.Modelo.Usuarios;
import es.cursillo.jdbc.H2;

public class ServiceUsuarios implements DAO<Usuarios, Integer> {

	private static final String SQL_DELETE = "DELETE FROM USUARIOS WHERE idUsuario= ";
	private static final String SQL_UPDATE = "UPDATE USUARIOS SET ";
	private static final String SQL_FIND_ALL = "SELECT * FROM USUARIOS ";
	private static final String SQL_INSERT = "INSERT INTO USUARIOS (idUsuario, user, pass) VALUES";
	private static final String SQL_FIND = "SELECT * FROM USUARIOS ";

	private H2 conexion;
	@Override
	public Integer create(Usuarios bean) throws Exception {
		conexion.connect();
		String sql = SQL_INSERT + "('" + bean.getIdUsuario() + "'," + bean.getUser() + "'," + "'" + bean.getPass()
				+ "')";
		int respuesta = conexion.executeSql(sql);
		conexion.close();
		return respuesta;
	}

	@Override
	public Integer update(Usuarios bean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer remove(Integer idUsuario) throws Exception {
		conexion.connect();
		String sql = SQL_DELETE + idUsuario;
		int resp = conexion.executeSql(sql);
		conexion.close();
		return resp;
	}

	@Override
	public Usuarios find(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuarios> findAll(Usuarios bean) throws Exception {
		conexion.connect();
		String cabecera = SQL_FIND_ALL;
		String cuerpo = "";
		String sql;

		if (bean.getUser() != null) {
			if (cuerpo.equals("")) {
				cuerpo += " WHERE user like '" + bean.getUser() + "'";
			} else {
				cuerpo += " AND user like '" + bean.getUser() + "'";
			}
		}
		if (bean.getPass() != null) {
			if (cuerpo.equals("")) {
				cuerpo += " WHERE pass like '" + bean.getPass() + "'";
			} else {
				cuerpo += " AND pass like '" + bean.getPass() + "'";
			}
		}
		sql = cabecera + cuerpo;
		int rs = conexion.executeSql(sql);
		ArrayList<Usuarios> tabla = new ArrayList<Usuarios>();
		conexion.close();
		return tabla;
	}
}