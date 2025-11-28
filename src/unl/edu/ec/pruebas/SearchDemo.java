package unl.edu.ec.pruebas;

import unl.edu.ec.busquedas.BusquedaCentinela;
import unl.edu.ec.busquedas.BusquedaPredicados;
import unl.edu.ec.busquedas.BusquedaSecuencial;
import unl.edu.ec.busquedas.BusquedaSLL;
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

        // 1. Ordenar para agrupar visualmente por método (Primero, Último, Todos)
        casos.sort(Comparator.comparing(c -> c.metodo));


        int passed = 0;
        int total = casos.size();
        String currentMethodGroup = "";

        for (CasoPrueba caso : casos) {
            String resultadoObtenido;
            boolean isPassed;
            String header = "";

            // --- GESTIÓN DE ENCABEZADOS Y AGRUPACIÓN ---
            if (!caso.metodo.equals(currentMethodGroup)) {
                currentMethodGroup = caso.metodo;
                System.out.println("\n" + "=".repeat(70));
                switch (currentMethodGroup) {
                    case "buscarPrimero":
                        header = "A. BÚSQUEDA SECUENCIAL CLÁSICA: PRIMERA OCURRENCIA [indexOfFirst]";
                        break;
                    case "buscarUltimo":
                        header = "B. BÚSQUEDA SECUENCIAL CLÁSICA: ÚLTIMA OCURRENCIA [indexOfLast]";
                        break;
                    case "buscarTodos":
                        header = "C. BÚSQUEDA POR PREDICADO [findAll]";
                        break;
                    default:
                        header = "GRUPO NO RECONOCIDO";
                }
                System.out.println(header);
                System.out.println("=".repeat(70));
            }

            // --- EJECUCIÓN DEL CASO ---
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
                        break;
                }
            }

            // --- REPORTE ---
            isPassed = resultadoObtenido.equals(caso.resultadoEsperado);
            if (isPassed) {
                passed++;
            }

            String inputDetail = caso.metodo.startsWith("buscarTodo")
                    ? caso.predicadoNombre : String.valueOf(caso.clave);

            String arrayDisplay = caso.arreglo != null
                    ? Arrays.toString(caso.arreglo)
                    : "null";

            System.out.printf("   ID %-2d: Arreglo: %-25s | Clave/Predicado: %-15s\n",
                    caso.id, arrayDisplay, inputDetail);
            System.out.printf("       -> Resultado: Esperado %-10s | Obtenido: %-10s | %s\n",
                    caso.resultadoEsperado, resultadoObtenido, isPassed ? " PASS" : " FAIL");
        }


        // --- PRUEBAS DE BÚSQUEDA CON CENTINELA ---
        ejecutarPruebasConCentinela();
        // --- RESUMEN FINAL ---
        System.out.println("\n" + "=".repeat(70));
        System.out.println("--- Resumen: " + passed + " de " + total + " pruebas pasadas. ---");
        System.out.println("=".repeat(70));
        // --- PRUEBAS EN LISTAS SIMPLEMENTE ENLAZADAS ---
        System.out.println("\n--- PRUEBAS EN LISTAS SIMPLEMENTE ENLAZADAS (SLL) ---");
        ejecutarPruebasEnSLL();

    }

    private static void ejecutarPruebasConCentinela() {

        System.out.println("\n" + "=".repeat(70));
        System.out.println("D. BÚSQUEDA SECUENCIAL CON CENTINELA [searchWithSentinel]");

        System.out.println("=".repeat(70));

        int[][] casos = {
                {7, 8, 9, 10}, // Caso 1
                {1, 1, 1, 1},  // Caso 2
                {5, 6, 7, 8},  // Caso 3
                {},            // Caso 4
                null           // Caso 5
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

    private static void ejecutarPruebasEnSLL() {
        // Crear una lista simplemente enlazada
        ListaSimpleEnlazada lista = new ListaSimpleEnlazada();
        lista.insert(1);
        lista.insert(2);
        lista.insert(3);
        lista.insert(4);
        lista.insert(5);

        // Prueba 1: Buscar la primera ocurrencia
        NodoSLL resultadoPrimero = BusquedaSLL.findFirst(lista.head, 3);
        System.out.println("Primera ocurrencia de 3: " + (resultadoPrimero != null ? resultadoPrimero.valor : "No encontrado"));

        // Prueba 2: Buscar la última ocurrencia
        lista.insert(3); // Agregar un duplicado para probar
        NodoSLL resultadoUltimo = BusquedaSLL.findLast(lista.head, 3);
        System.out.println("Última ocurrencia de 3: " + (resultadoUltimo != null ? resultadoUltimo.valor : "No encontrado"));

        // Prueba 3: Buscar todos los nodos que cumplen un predicado
        Predicate<NodoSLL> predicado = nodo -> nodo.valor % 2 == 0; // Números pares
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