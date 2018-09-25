package clasesgenericas;

public interface IAlmacenar<T> {
    void agregar(T elemento);
    T obtener(int posicion);
    void borrar(int posicion);
    void borrarTodos();
    }
