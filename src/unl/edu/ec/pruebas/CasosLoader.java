package unl.edu.ec.pruebas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class CasosLoader {

    private static final String DEFAULT_CSV_PATH = "Casos.csv";

    public static List<CasoPrueba> leerCSV(String ruta) {
        if (ruta == null || ruta.isEmpty()) {
            ruta = DEFAULT_CSV_PATH;
        }

        List<CasoPrueba> lista = new ArrayList<>();
        int lineNumber = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            br.readLine(); // Saltar la línea del encabezado
            lineNumber++;

            String linea;
            while ((linea = br.readLine()) != null) {
                lineNumber++;

                // CRÍTICO: Usar -1 para capturar 6 campos, incluso si clave/predicado están vacíos.
                String[] partes = linea.split(";", -1);

                if (partes.length < 6) {
                    System.err.println(" ERROR CSV (Línea " + lineNumber + "): Se esperaban 6 campos. Línea ignorada: " + linea);
                    continue;
                }

                try {
                    int id = Integer.parseInt(partes[0].trim());
                    String metodo = partes[1].trim();

                    int[] arreglo = parseArreglo(partes[2].trim()); // Parseo con limpieza de comillas

                    String claveStr = partes[3].trim();
                    String predicadoNombre = partes[4].trim();
                    String resultadoEsperado = partes[5].trim();

                    Integer clave = claveStr.isEmpty() ? null : Integer.parseInt(claveStr);

                    lista.add(new CasoPrueba(id, metodo, arreglo, clave, predicadoNombre, resultadoEsperado));

                } catch (NumberFormatException e) {
                    System.err.println(" ERROR DE PARSEO (Línea " + lineNumber + "): Valor numérico incorrecto. Ignorando caso: " + linea);
                }
            }

        } catch (Exception e) {
            // Este error se lanza si el archivo no existe o no se puede leer
            System.err.println(" ERROR: No se pudo leer el archivo CSV en la ruta: " + ruta + ". Asegúrese de que existe y la ruta es correcta.");
        }

        return lista;
    }

    public static List<CasoPrueba> leerCSV() {
        return leerCSV(DEFAULT_CSV_PATH);
    }

    /**
     * Resuelve los arrays de String a int[]. Maneja null, [], y arrays con comillas.
     */
    private static int[] parseArreglo(String txt) {
        if (txt == null || txt.equalsIgnoreCase("null") || txt.isBlank()) {
            return null;
        }

        //  FIX CRÍTICO: Si el CSV usa comillas ("...") para envolver el arreglo, las eliminamos aquí.
        txt = txt.replace("\"", "").trim();

        // Eliminar corchetes
        txt = txt.replace("[", "").replace("]", "").trim();

        if (txt.isBlank()) return new int[0];

        String[] partes = txt.split(",");
        int[] arr = new int[partes.length];
        for (int i = 0; i < partes.length; i++) {
            // Manejo de posibles espacios en blanco si el CSV es "1, 2, 3"
            String val = partes[i].trim();
            if (!val.isEmpty()) {
                arr[i] = Integer.parseInt(val);
            }
        }
        return arr;
    }
}