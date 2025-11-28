package unl.edu.ec.busquedas;

public class BusquedaBinaria {

    public static int binarySearch(int[] array, int key) {
        if (array == null || array.length == 0) {
            return -1; // Retorna -1 si el arreglo es nulo o vacío
        }

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == key) {
                return mid; // Retorna el índice si se encuentra la clave
            } else if (array[mid] < key) {
                left = mid + 1; // Busca en la mitad derecha
            } else {
                right = mid - 1; // Busca en la mitad izquierda
            }
        }

        return -1; // Retorna -1 si no se encuentra la clave
    }
}