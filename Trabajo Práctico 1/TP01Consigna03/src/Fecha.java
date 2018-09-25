public class Fecha {

	private int dia;
	private int mes;
	private int anho;

	public Fecha() {
		super();
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getAnho() {
		return anho;
	}

	public void setAnho(int anho) {
		this.anho = anho;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public String toSting() {
		return "Fecha de PersonaConNacimiento";
	}
}
