package unl.edu.ec.pruebas;

import unl.edu.ec.busquedas.BusquedaCentinela;
import unl.edu.ec.busquedas.BusquedaPredicados;
import unl.edu.ec.busquedas.BusquedaSecuencial;
import unl.edu.ec.busquedas.BusquedaSLL;
import unl.edu.ec.busquedas.BusquedaBinaria;   // <<--- IMPORTANTE
import unl.edu.ec.ordenacion.ListaSimpleEnlazada;
import unl.edu.ec.ordenacion.NodoSLL;

import java.util.List;
import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.Comparator;

public class SearchDemo {

    public static void main(String[] args) {

        System.out.println("--- EJECUCIÓN AUTOMATIZADA DE CASOS DE PRUEBA (TALLER 7) ---");
        System.out.println("Cargando casos desde el CSV interno...\n");

        List<CasoPrueba> casos = unl.edu.ec.pruebas.CasosLoader.leerCSV("src/DatesCSV/Casos.csv");

        int passed = 0;
        int total = casos.size();
        String currentMethodGroup = "";

        for (CasoPrueba caso : casos) {
            String resultadoObtenido;
            boolean isPassed;
            String header = "";

            // ENCABEZADOS ORDENADOS
            if (!caso.metodo.equals(currentMethodGroup)) {
                currentMethodGroup = caso.metodo;
                System.out.println("\n" + "=".repeat(70));

                switch (currentMethodGroup) {
                    case "buscarPrimero":
                        header = "BÚSQUEDA SECUENCIAL CLÁSICA: PRIMERA OCURRENCIA [indexOfFirst]";
                        break;
                    case "buscarUltimo":
                        header = "BÚSQUEDA SECUENCIAL CLÁSICA: ÚLTIMA OCURRENCIA [indexOfLast]";
                        break;
                    case "buscarTodos":
                        header = "BÚSQUEDA POR PREDICADO [findAll]";
                        break;
                    default:
                        header = "GRUPO NO RECONOCIDO";
                }

                System.out.println(header);
                System.out.println("=".repeat(70));
            }

            // EJECUCIÓN DE LOS CASOS
            if (caso.arreglo == null || caso.arreglo.length == 0) {
                if (caso.metodo.equals("buscarPrimero") || caso.metodo.equals("buscarUltimo")) {
                    resultadoObtenido = "-1";
                } else {
                    resultadoObtenido = "[]";
                }
            } else {
                switch (caso.metodo) {
                    case "buscarPrimero":
                        resultadoObtenido = String.valueOf(BusquedaSecuencial.indexOfFirst(caso.arreglo, caso.clave));
                        break;
                    case "buscarUltimo":
                        resultadoObtenido = String.valueOf(BusquedaSecuencial.indexOfLast(caso.arreglo, caso.clave));
                        break;
                    case "buscarTodos":
                        try {
                            IntPredicate p = BusquedaPredicados.getPredicate(caso.predicadoNombre, caso.clave);
                            List<Integer> indices = BusquedaSecuencial.findAll(caso.arreglo, p);
                            resultadoObtenido = indices.toString().replace(" ", "");
                        } catch (IllegalArgumentException e) {
                            resultadoObtenido = "ERROR_PREDICADO";
                        }
                        break;
                    default:
                        resultadoObtenido = "METODO_NO_ENCONTRADO";
                }
            }

            isPassed = resultadoObtenido.equals(caso.resultadoEsperado);
            if (isPassed) passed++;

            String inputDetail = caso.metodo.startsWith("buscarTodo")
                    ? caso.predicadoNombre : String.valueOf(caso.clave);

            String arrayDisplay = caso.arreglo != null ? Arrays.toString(caso.arreglo) : "null";

            System.out.printf("   ID %-2d: Arreglo: %-25s | Clave/Predicado: %-15s\n",
                    caso.id, arrayDisplay, inputDetail);
            System.out.printf("       -> Resultado: Esperado %-10s | Obtenido: %-10s | %s\n",
                    caso.resultadoEsperado, resultadoObtenido, isPassed ? " PASS" : " FAIL");
        }

        // ORDEN CORRECTO DE INFORMES:
        // A, B, C ya se imprimen arriba
        ejecutarPruebasConCentinela();  // D
        ejecutarPruebasBinarias();      // E  <<--- AGREGADO
        System.out.println("\n" + "=".repeat(70));
        System.out.println("--- Resumen: " + passed + " de " + total + " pruebas pasadas. ---");
        System.out.println("=".repeat(70));

        // PRUEBAS EN LISTAS
        System.out.println("\n--- PRUEBAS EN LISTAS SIMPLEMENTE ENLAZADAS (SLL) ---");
        ejecutarPruebasEnSLL();
    }


    // -------------------------------------------------------
    // MÉTODO D: BÚSQUEDA CON CENTINELA
    // -------------------------------------------------------
    private static void ejecutarPruebasConCentinela() {

        System.out.println("\n" + "=".repeat(70));
        System.out.println("BÚSQUEDA SECUENCIAL CON CENTINELA [searchWithSentinel]");
        System.out.println("=".repeat(70));

        int[][] casos = {
                {7, 8, 9, 10},
                {1, 1, 1, 1},
                {5, 6, 7, 8},
                {},
                null
        };

        int[] claves = {8, 1, 4, 3, 2};

        for (int i = 0; i < casos.length; i++) {
            int[] arreglo = casos[i];
            int clave = claves[i];

            int[] resultado = BusquedaCentinela.searchWithSentinel(arreglo, clave);
            int indice = resultado[0];
            int comparaciones = resultado[1];

            System.out.printf("   Caso %-2d: Arreglo: %-25s | Clave: %-5d -> Índice: %-5d | Comparaciones: %-5d\n",
                    i + 1,
                    arreglo != null ? Arrays.toString(arreglo) : "null",
                    clave,
                    indice,
                    comparaciones
            );
        }

        System.out.println("=".repeat(70));
    }


    // -------------------------------------------------------
    // MÉTODO E: BÚSQUEDA BINARIA
    // -------------------------------------------------------
    private static void ejecutarPruebasBinarias() {

        System.out.println("\n" + "=".repeat(70));
        System.out.println("BÚSQUEDA BINARIA [binarySearch]");
        System.out.println("=".repeat(70));

        int[][] casos = {
                {1, 2, 3, 4, 5},
                {10, 20, 30, 40},
                {5, 6, 7, 8, 9},
                {},
                null
        };

        int[] claves = {3, 25, 7, 1, 2};

        for (int i = 0; i < casos.length; i++) {

            int[] arreglo = casos[i];
            int clave = claves[i];
            int resultado = BusquedaBinaria.binarySearch(arreglo, clave);

            System.out.printf("   Caso %-2d: Arreglo: %-25s | Clave: %-5d -> Índice: %-5d\n",
                    i + 1,
                    arreglo != null ? Arrays.toString(arreglo) : "null",
                    clave,
                    resultado
            );
        }

        System.out.println("=".repeat(70));
    }


    // -------------------------------------------------------
    // PRUEBAS EN LISTAS SIMPLEMENTE ENLAZADAS
    // -------------------------------------------------------
    private static void ejecutarPruebasEnSLL() {

        ListaSimpleEnlazada lista = new ListaSimpleEnlazada();
        lista.insert(1);
        lista.insert(2);
        lista.insert(3);
        lista.insert(4);
        lista.insert(5);

        NodoSLL resultadoPrimero = BusquedaSLL.findFirst(lista.head, 3);
        System.out.println("Primera ocurrencia de 3: " +
                (resultadoPrimero != null ? resultadoPrimero.valor : "No encontrado"));

        lista.insert(3);
        NodoSLL resultadoUltimo = BusquedaSLL.findLast(lista.head, 3);
        System.out.println("Última ocurrencia de 3: " +
                (resultadoUltimo != null ? resultadoUltimo.valor : "No encontrado"));

        Predicate<NodoSLL> predicado = nodo -> nodo.valor % 2 == 0;
        List<NodoSLL> resultadosTodos = BusquedaSLL.findAll(lista.head, predicado);

        System.out.print("Nodos con valores pares: ");
        if (resultadosTodos.isEmpty()) {
            System.out.println("[]");
        } else {
            resultadosTodos.forEach(nodo -> System.out.print(nodo.valor + " "));
            System.out.println();
        }
    }
}
