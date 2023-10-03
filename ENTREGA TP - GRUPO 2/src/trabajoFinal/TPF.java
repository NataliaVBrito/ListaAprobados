package trabajoFinal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class TPF {
	public static void main(String[] args) {

		HashMap<Integer, Estudiante> diccionario = new HashMap<>();

		String[] alumno;
		String alumnoo;

		int legajo;
		String nombre;
		String materia;
		int legajoBuscar;
		int respuesta = 0;
		boolean continua = false;

		try {

			BufferedReader buffered = new BufferedReader(new FileReader("aprobaciones.txt"));

			// CARGO EL DICCIONARIO CON LOS DATOS ALMACENADOS EN EL ARCHIVO.
			while ((alumnoo = buffered.readLine()) != null) {

				alumno = alumnoo.split(",");

				legajo = Integer.parseInt(alumno[0]);
				nombre = alumno[1];
				materia = alumno[2];
				Estudiante student = new Estudiante(legajo, nombre);
				student.agregarMateriaAprobada(alumno[2]);
				diccionario.put(legajo, student);

			}
			buffered.close();

		} catch (Exception e) {

			System.out.println(e);
			System.exit(0);
		}

		// Menu alumno
		do {
			respuesta = 0;
			continua = false;
			try {
				Scanner entrada = new Scanner(System.in);

				do {

					// Pido a usuario ingrese legajo de alumno a buscar

					System.out.println("Ingrese legajo a buscar: ");
					legajoBuscar = entrada.nextInt();
					entrada.nextLine();

					// Si en el diccionario existe el legajo
					// muestro los datos y solicito una materia a agregar
					if (diccionario.containsKey(legajoBuscar)) {

						Estudiante student = diccionario.get(legajoBuscar);
						student.mostrarEstudiante();
						do {
							System.out.println(
									"¿Desea cargarle una materia aprobada al legajo " + legajoBuscar + "? 1-Si 2- No");
							respuesta = entrada.nextInt();

							if (respuesta == 1) {
								entrada.nextLine();
								System.out.println("Agregar una materia: ");
								student.agregarMateriaAprobada(entrada.nextLine());
								student.mostrarEstudiante();
							}
							if ((respuesta != 1) && (respuesta != 2)) {
								System.out.println("Respuesta no valida. Intente de nuevo");
							}
						} while ((respuesta != 1) && (respuesta != 2));

						// Si no existe el legajo solicito cargue los datos y materia aprobada
					} else {
						do {
							System.out.println("El legajo no existe, ¿desea cargarlo? (1-Si 2- No)");
							respuesta = entrada.nextInt();

							if (respuesta == 1) {
								entrada.nextLine();
								System.out.println("Ingrese el Nombre y Apellido del alumno");
								nombre = entrada.nextLine();
								System.out.println("Ingrese el nombre de la materia");
								materia = entrada.nextLine();
								Estudiante student = new Estudiante(legajoBuscar, nombre);
								student.agregarMateriaAprobada(materia);
								diccionario.put(legajoBuscar, student);
								student.mostrarEstudiante();
							}
							if ((respuesta != 1) && (respuesta != 2)) {
								System.out.println("Respuesta no valida. Intente de nuevo");
							}
						} while ((respuesta != 1) && (respuesta != 2));

					}
					do {
						System.out.println("¿Desea buscar otro legajo? (1-Si 2- No)");
						respuesta = entrada.nextInt();
						entrada.nextLine();
						if ((respuesta != 1) && (respuesta != 2)) {
							System.out.println("Respuesta no valida. Intente de nuevo");
						}
					} while ((respuesta != 1) && (respuesta != 2));

				} while (respuesta == 1);
				entrada.close();
			} catch (Exception e) {
				System.out.println("Debe ingresar un valor correcto");
				continua = true;

			}

		} while (continua == true);
		System.out.println("Muchas Gracias, hasta pronto");
	}
}