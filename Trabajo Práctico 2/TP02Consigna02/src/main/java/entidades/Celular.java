package entidades;

public class Celular {

    private String marca;
    private String capacidad;
    private int precio;

    public Celular() {
    }

    public Celular(String marca, String capacidad, int precio) {
        this.marca = marca;
        this.capacidad = capacidad;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
