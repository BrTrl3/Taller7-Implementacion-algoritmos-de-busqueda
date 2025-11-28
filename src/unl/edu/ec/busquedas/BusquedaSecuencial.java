package unl.edu.ec.busquedas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

public class BusquedaSecuencial {

    // Paso 1: Primera ocurrencia (Revisado para null y vacío)
    public static int indexOfFirst(int[] a, int key) {
        if (a == null || a.length == 0) {
            return -1;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }

    // Paso 2: Última ocurrencia (Revisado para null y vacío)
    public static int indexOfLast(int[] a, int key) {
        if (a == null || a.length == 0) {
            return -1;
        }
        int lastIndex = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                lastIndex = i;
            }
        }
        return lastIndex;
    }

    // Paso 3: findAll por predicado (Revisado para null y vacío)
    public static List<Integer> findAll(int[] a, IntPredicate p) {
        List<Integer> resultIndices = new ArrayList<>();
        if (a == null || a.length == 0) {
            return resultIndices; // Retorna lista vacía (esperado por CSV)
        }
        for (int i = 0; i < a.length; i++) {
            if (p.test(a[i])) {
                resultIndices.add(i);
            }
        }
        return resultIndices;
    }
}