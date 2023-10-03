package trabajoFinal;

import java.util.ArrayList;

public class Estudiante {
	private int legajo;
	private String nombreApellido;
	private ArrayList<String> materiasAprobadas;

	public Estudiante(int legajo, String nombreApellido) {
		this.legajo = legajo;
		this.nombreApellido = nombreApellido;
		this.materiasAprobadas = new ArrayList<>();
	}

	public void mostrarEstudiante() {

		String materias = ",";
		for (String lista : this.getMateria()) {
			materias = materias + ", " + lista;
		}

		System.out.println(
				this.legajo + " - " + this.nombreApellido + " - " + materias.substring(3, materias.length()) + " ");

	}

	public void agregarMateriaAprobada(String materiaAprobada) {
		materiasAprobadas.add(materiaAprobada);
	}

	public ArrayList<String> getMateria() {

		return materiasAprobadas;

	}

	// Setters y Getters
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setNombre(String nombreApellido) {
		this.nombreApellido = nombreApellido;

	}

	public String getNombre() {

		return nombreApellido;
	}
}
