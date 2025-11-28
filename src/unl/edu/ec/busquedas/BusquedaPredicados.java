package unl.edu.ec.busquedas;

import java.util.function.IntPredicate;

public class BusquedaPredicados {

    public static IntPredicate getPredicate(String name, Integer key) {
        switch (name.toUpperCase()) {
            case "MAYOR_QUE_3":
                return num -> num > 3;
            case "MENOR_QUE_5": // NUEVO PREDICADO
                return num -> num < 5;
            case "IMPAR": // NUEVO PREDICADO
                return num -> num % 2 != 0;
            case "IGUAL_KEY":
                if (key == null) throw new IllegalArgumentException("Predicado IGUAL_KEY requiere un valor de clave.");
                return num -> num == key;
            case "PAR":
                return num -> num % 2 == 0;
            case "SIEMPRE":
                return num -> true;
            default:
                throw new IllegalArgumentException("Predicado no reconocido: " + name);
        }
    }
}