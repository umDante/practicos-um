
import java.util.Scanner;

import entidades.Persona;

public class app{

	public static void main(String[] args) {
		Persona per= new Persona();
		Scanner sc = new Scanner(System.in); // Se crea el lector
		
		System.out.println("Por favor ingrese su nombre");
		String nom = sc.nextLine(); // Se lee el nombre con nextLine() que retorna un String con el dato
		System.out.println("Por favor ingrese su Apellido");
		String apell = sc.nextLine();
		System.out.println("Por favor ingrese su dni");
		long dni = sc.nextLong();
		
		per.input_llenarAtributos(nom, apell, dni);
		per.show_mostrarAributos(per);
		
	}

}