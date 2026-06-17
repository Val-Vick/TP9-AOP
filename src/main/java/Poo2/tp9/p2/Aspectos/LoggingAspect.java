package Poo2.tp9.p2.Aspectos;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;

@Aspect
public class LoggingAspect {

	@Before("@annotation(Poo2.tp4.p3.aspectos.Log)")
	public void logearMetodo(JoinPoint joinPoint) {
		String nombreMetodo = joinPoint.getSignature().getName();

		Object[] args = joinPoint.getArgs();
		String parametrosStr;

		if (args == null || args.length == 0) {
			parametrosStr = "sin parametros";
		} else {
			StringJoiner joiner = new StringJoiner(" | ");
			for (Object arg : args) {
				joiner.add(arg != null ? arg.toString() : "null");
			}
			parametrosStr = joiner.toString();
		}

		LocalDateTime ahora = LocalDateTime.now();
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String fechaFormateada = ahora.format(formateador);

		String lineaLog = String.format("\"%s\", \"%s\", \"%s\"", nombreMetodo, parametrosStr, fechaFormateada);

		try (BufferedWriter writer = new BufferedWriter(new FileWriter("log_ejecucion.txt", true))) {
			writer.write(lineaLog);
			writer.newLine();
		} catch (IOException e) {
			System.err.println("Error al escribir en el archivo de log: " + e.getMessage());
		}
	}
}