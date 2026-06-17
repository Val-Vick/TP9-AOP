package Poo2.tp4.p3.persistencia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RegistroArchivo implements RegistroInscripcion {
	@Override
	public void guardar(String fecha, String idParticipante, String idConcurso) {
		try (BufferedWriter writer = new BufferedWriter(
				new FileWriter("inscripciones.txt", true))) {

			writer.write(fecha + ", " + idParticipante + ", " + idConcurso);
			writer.newLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
