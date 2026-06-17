package Poo2.tp4.p3.modelo;

import java.time.LocalDate;

public class Inscripcion {
	private Participante participante;
	private int puntos;

	public Inscripcion(Participante participante) {
		this.participante = participante;
		puntos = 0;
	}

	public boolean contieneA(Participante participante) {
		return this.participante.equals(participante);
	}

	public void asignarPuntos(int puntos, LocalDate fechaHoy, LocalDate inicioInscripcion){
		if (fechaHoy.equals(inicioInscripcion)) {
			this.puntos = puntos;
		}
	}
}
