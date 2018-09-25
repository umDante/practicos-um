package entidades;

import clasesgenericas.IAlmacenar;

public class Zapatilla {

    private String marca;
    private String color;
    private int talle;


public Zapatilla() {
    }

    public Zapatilla(String marca, String color, int talle) {
    this.marca = marca;
    this.color = color;
    this.talle = talle;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTalle() {
        return talle;
    }

    public void setTalle(int talle) {
        this.talle = talle;
    }
}
