package entidad;

public class Tarea {
    private int id;
    private String inicio;
    private String autor;
    private String descripcion;

    public Tarea() {
    }

    public Tarea(int id, String inicio, String autor, String descripcion) {
        this.id = id;
        this.inicio = inicio;
        this.autor = autor;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
