package Poo2.tp4.p3.persistencia;

import Poo2.tp4.p3.modelo.Concurso;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class RegistroArchivoConcurso implements RegistroConcurso{
	private String ruta;

	public RegistroArchivoConcurso(String ruta){
		this.ruta = ruta;
	}

	@Override
	public List<Concurso> obtenerTodos() {
		try {
			return Files.lines(Paths.get(ruta))
					.map(linea -> {
						String[] datos = linea.split(",");
						return new Concurso(
								datos[1].trim(),
								LocalDate.parse(datos[3].trim(), DateTimeFormatter.ofPattern("yyyy/MM/dd")),
								LocalDate.parse(datos[2].trim(), DateTimeFormatter.ofPattern("yyyy/MM/dd"))
						);
					})
					.collect(Collectors.toList());
		} catch (IOException e) {
			throw new RuntimeException("Error al leer concursos", e);
		}
	}
}
