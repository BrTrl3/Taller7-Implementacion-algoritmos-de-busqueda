package unl.edu.ec.busquedas;

import unl.edu.ec.ordenacion.NodoSLL;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Implementa los algoritmos de búsqueda secuencial para Listas Simplemente Enlazadas (SLL).
 */
public class BusquedaSLL {

    // Paso 1: Primera ocurrencia (retorna el nodo) [cite: 38]
    public static NodoSLL findFirst(NodoSLL head, int key) {
        NodoSLL actual = head;
        while (actual != null) {
            if (actual.valor == key) {
                return actual; // Retorna el primer nodo encontrado
            }
            actual = actual.siguiente;
        }
        return null; // No encontrado
    }

    // Paso 2: Última ocurrencia (retorna el nodo) [cite: 43]
    public static NodoSLL findLast(NodoSLL head, int key) {
        NodoSLL actual = head;
        NodoSLL lastMatch = null;
        while (actual != null) {
            if (actual.valor == key) {
                lastMatch = actual; // Actualiza el último nodo que coincide
            }
            actual = actual.siguiente;
        }
        return lastMatch; // Retorna el último nodo encontrado, o null
    }

    // Paso 3: findAll por predicado (retorna lista de nodos) [cite: 51]
    public static List<NodoSLL> findAll(NodoSLL head, Predicate<NodoSLL> p) {
        List<NodoSLL> resultNodes = new ArrayList<>();
        NodoSLL actual = head;
        while (actual != null) {
            if (p.test(actual)) { // Aplica el predicado al nodo actual
                resultNodes.add(actual);
            }
            actual = actual.siguiente;
        }
        return resultNodes;
    }
}