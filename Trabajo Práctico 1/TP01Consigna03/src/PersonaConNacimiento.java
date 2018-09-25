import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PersonaConNacimiento extends Persona {

	Fecha nacimiento;

	public PersonaConNacimiento() {
		super();
	}

	public void inputPersonaConNacimiento(Fecha fecha) {
				
		BufferedReader dato = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Ingrese Nombre");

		try {
			this.setNombre(dato.readLine());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Ingrese Apellido");

		try {
			this.setApellido(dato.readLine());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
			
		System.out.println("Ingrese dni");

		try {
			this.setDni(Integer.parseInt(dato.readLine()));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}		
		System.out.println("Ingrese Fecha- : día, formato dd");

		try {
			
		fecha.setDia(Integer.parseInt(dato.readLine()));	
			
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Ingrese mes, formato mm");
		try {
			 fecha.setMes(Integer.parseInt(dato.readLine()));
		} catch (IOException e) {
			System.out.println(e.getMessage());

		}
		System.out.println("Ingrese año, formato aaaa");
		try {
			 fecha.setAnho(Integer.parseInt(dato.readLine()));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}		
	}

	public void showPersonaConNacimiento(Fecha fecha) {
		System.out.println("la fecha es: " + fecha.getDia() + "/" 
										   + fecha.getMes() + "/" 
										   + fecha.getAnho());
		
		System.out.println("Nombre: " + this.getNombre() + "\n"
						+ "Apellido: " + this.getApellido() + "\n"
						+ "Dni: " + this.getDni()+"\n..Fin");
	}

	@Override
	public String toString() {

		return "Trabaj práctico 1 enunciado 2";
	}

	public Fecha getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Fecha nacimiento) {
		this.nacimiento = nacimiento;
	}

}
