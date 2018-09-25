package entidades;

public class Persona {
	private String nombre;
	private String apellido;
	private long dni;

	public Persona() {
	}

	public void input_llenarAtributos(String no, String ap, long dn) {
		
		this.setApellido(ap);
		this.setNombre(no);
		this.setDni(dn);
	}

	public void show_mostrarAributos(Persona p) {
		System.out.println("Nombre ingresado: " + p.getNombre() + 
							"\nApellido  ingresado: " + p.getApellido()+
							"\nDni ingresado: " + p.getDni()+"\n...Fin!");
	}

	@Override
	public String toString() {
		String mensaje = "Primer trabajo practico de Programación 2";
		return mensaje;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}