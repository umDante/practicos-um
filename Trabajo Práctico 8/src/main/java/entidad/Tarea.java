package entidad;

import javax.persistence.*;

@Entity
@Table(name = "tarea")
public class Tarea {
    @Id
    @Column(name="id", nullable=false, unique=true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="inicio")
    private String inicio;

    @Column(name="autor")
    private String autor;


    @Column(name="descripcion")
    private String descripcion;

    public Tarea() {
    }

    public Tarea(String inicio, String descripcion, String autor) {
        this.inicio = inicio;
        this.descripcion = descripcion;
        this.autor = autor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
