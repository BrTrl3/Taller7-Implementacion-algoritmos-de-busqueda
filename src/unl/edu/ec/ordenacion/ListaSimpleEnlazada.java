package unl.edu.ec.ordenacion;

public class ListaSimpleEnlazada {
    public NodoSLL head; // Cambiado de NodoSSL a NodoSLL

    public ListaSimpleEnlazada() {
        this.head = null;
    }

    // Método de ayuda para construir la lista
    public void insert(int val) {
        NodoSLL newNode = new NodoSLL(val); // Cambiado de NodoSSL a NodoSLL
        if (head == null) {
            head = newNode;
        } else {
            NodoSLL current = head; // Cambiado de NodoSSL a NodoSLL
            while (current.siguiente != null) {
                current = current.siguiente;
            }
            current.siguiente = newNode;
        }
    }
}