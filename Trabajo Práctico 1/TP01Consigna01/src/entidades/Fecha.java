package entidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fecha {

	private int dia;
	private int mes;
	private int anho;

	public Fecha() {
		super();
	}

	public void desplaZar() {

		int opcion = 0;
		System.out.println("Desplazamiento");
		System.out.println("1: Sumar espacios");
		System.out.println("2: Restar espacios");

		BufferedReader dato = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Ingrese opción ");
		try {
			opcion = (Integer.parseInt(dato.readLine()));
		} catch (IOException e) {
			System.out.println("Error, Ingrese un valor entero" + e);
		}

		switch (opcion) {

		case 1:
			System.out.println("Desplazamiento actual:" + this.getDia());
			System.out.println("Ingrese los días a desṕazar");
			try {
				this.setDia(this.getDia() + (Integer.parseInt(dato.readLine())));
				System.out.println("Desplazamiento nuevo:" + this.getDia());
			} catch (Exception e) {
				System.out.println("Error, Ingrese un valor entero" + e);
			}
			break;
		case 2:
			System.out.println("Desplazamiento actual:" + this.getDia());
			System.out.println("Ingrese los días a desṕazar");
			try {
				this.setDia(this.getDia() - (Integer.parseInt(dato.readLine())));
				System.out.println("Desplazamiento nuevo:" + this.getDia());
			} catch (Exception e) {
				System.out.println("Error, Ingrese un valor entero" + e);
			}
			break;
		default:
			System.out.println("Ingrese un valor entre 1 o 2");
			this.desplaZar();
			break;

		}

	}

	public static int compararFecha(Fecha fecha1, Fecha fecha2) {

		int val = 0;

		if (!((fecha1.getAnho() == fecha2.getAnho()))) {
			val = (fecha1.getAnho() > fecha2.getAnho()) ? 1 : -1;

		} else if (!(fecha1.getMes() == fecha2.getMes())) {
			val = (fecha1.getMes() > fecha2.getMes()) ? 1 : -1;

		} else if (!(fecha1.getDia() == fecha2.getDia())) {
			val = (fecha1.getDia() > fecha2.getDia()) ? 1 : -1;
		}

		System.out.println("Retorno: " + val);
		return val;
	}

	public void inputFecha() {

		BufferedReader dato = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Ingrese Las fechas a comparar \n");

		System.out.println("Ingrese Fecha- : día, formato dd");

		try {
			this.setDia(Integer.parseInt(dato.readLine()));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Ingrese mes, formato mm");
		try {
			this.setMes((Integer.parseInt(dato.readLine())));
		} catch (IOException e) {
			System.out.println(e.getMessage());

		}
		System.out.println("Ingrese año, formato aaaa");
		try {
			this.setAnho((Integer.parseInt(dato.readLine())));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void outputFecha() {
		System.out.println("Fecha : " + this.getDia() + "/" + this.getMes() + "/" + this.getAnho());
	}

	public String toSting() {
		return "Trabajo practico 1 punto2, año 2018";
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

}