package Poo2.tp4.p3.modelo;

import java.util.Objects;

public class Participante {
	private String nombre;
	private Long dni;
	private String email;
	private String apellido;
	private String telefono;


	public String getEmail() {
		return email;
	}

	public Participante(String nombre, String StringDni, String email, String apellido, String telefono) {
		if (nombre == null || nombre.isEmpty()) {
			throw new RuntimeException("debe cargar un nombre");
		}
		if (apellido == null || apellido.isEmpty()) {
			throw new RuntimeException("debe cargar un apellido");
		}
		if (email == null || email.isEmpty()) {
			throw new RuntimeException("debe cargar un Mail");
		}
		if (dni == null) {
			throw new RuntimeException("debe cargar un Dni");
		}
		try{
			Long longDni = Long.parseLong(StringDni);
			this.dni = longDni;
		}catch (NumberFormatException ex){
			throw new RuntimeException("el dni tiene que ser solo numeros");
		}
		if (telefono == null || !validarTelefono(telefono)) {
			throw new RuntimeException("el telefono debe ingresarse de la forma: NNNN-NNNNNN");
		}

		this.nombre = nombre;
		this.email = email;
		this.apellido = apellido;
		this.telefono = telefono;
	}

	public Long getDni(){
		return dni;
	}

	private boolean validarTelefono(String telefono) {
		return telefono.matches("\\d{4}-\\d{6}");
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Participante that)) return false;
		return Objects.equals(dni, that.dni);
	}
}