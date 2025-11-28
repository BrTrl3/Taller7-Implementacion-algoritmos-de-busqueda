package unl.edu.ec.ordenacion;


/**
 * Representa un nodo para la Lista Simple Enlazada (SLL).
 */
public class NodoSLL {
    public int valor;
    public NodoSLL siguiente;

    public NodoSLL(int valor) {
        this.valor = valor;
        this.siguiente = null;
    }

    @Override
    public String toString() {
        // Formato para una salida amigable, mostrando el valor
        return "{" + valor + "}";
    }
}