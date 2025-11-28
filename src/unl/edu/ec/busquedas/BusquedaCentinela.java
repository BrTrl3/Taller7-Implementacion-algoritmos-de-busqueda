package unl.edu.ec.busquedas;

public class BusquedaCentinela {

    public static int[] searchWithSentinel(int[] array, int key) {
        if (array == null || array.length == 0) {
            return new int[]{-1, 0}; // Índice -1 y 0 comparaciones
        }

        int[] extendedArray = new int[array.length + 1];
        System.arraycopy(array, 0, extendedArray, 0, array.length);
        extendedArray[array.length] = key; // Agregar el centinela

        int i = 0;
        int comparisons = 0;

        while (true) {
            comparisons++;
            if (extendedArray[i] == key) {
                break;
            }
            i++;
        }

        // Si el índice es igual al tamaño original, no se encontró
        return new int[]{i < array.length ? i : -1, comparisons};
    }
}