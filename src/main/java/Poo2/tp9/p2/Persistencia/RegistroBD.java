package Poo2.tp4.p3.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistroBD implements RegistroInscripcion {
	private String url = "jdbc:mysql://localhost:3306/registros_db";
	private String user = "root";
	private String password = "das3vale";

	@Override
	public void guardar(String fecha, String idParticipante, String idConcurso) {
		String sql = "INSERT INTO inscripcion (fecha, idParticipante, idConcurso) VALUES (?, ?, ?)";
		try (Connection conn = DriverManager.getConnection(url, user, password);
			 PreparedStatement statement = conn.prepareStatement(sql)) {

			statement.setString(1, fecha);
			statement.setString(2, idParticipante);
			statement.setString(3, idConcurso);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Error al guardar en BD", e);
		}
	}
}
