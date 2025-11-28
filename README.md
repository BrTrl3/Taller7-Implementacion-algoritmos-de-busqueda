# Implementacion de Busqueda - Grupo D

##  1. Objetivo: 
> - Implementar correctamente las variantes canónicas de búsqueda secuencial y búsqueda binaria en Java.
> - Validar con casos borde, y justificar cuándo aplicar cada método según la estructura de datos (arreglo vs SLL).

##  2. Equipos y herramientas utilizadas
- **JDK OpenJDK** (obligatorio).  
- **IDE:** IntelliJ IDEA Community o Visual Studio Code (Extension Pack for Java).  
- **Sistema de control de versiones:** Git + repositorio GitHub.  
- **EVA/Moodle institucional** para entrega de evidencias.  
- **Herramientas de documentación:** README 

---

##  3. Estructura del Proyecto
```
src/
├── DatesCSV/
│   └── Casos.csv
└── unl/edu/ec/
    ├── busquedas/
    │   ├── BusquedaCentinela.java
    │   ├── BusquedaPredicados.java
    │   ├── BusquedaSLL.java
    │   └── BusquedaSecuencial.java
    ├── ordenacion/
    │   ├── ListaSimpleEnlazada.java
    │   └── NodoSLL.java
    └── pruebas/
        ├── CasoPrueba.java
        ├── CasosLoader.java
        └── SearchDemo.java
```
## 4. Requisitos previos

Antes de ejecutar el proyecto, asegúrate de contar con el siguiente entorno:

| Componente | Versión recomendada | Descripción |
|-------------|---------------------|--------------|
| **Java JDK** | **21 (OpenJDK 21)** | Requerido para compilar y ejecutar el proyecto. Puede descargarse desde [Open JDK]([https://jdk.java.net/25/](https://openjdk.org/projects/jdk/24/)). |
| **Maven** | 3.9.x o superior | Maneja dependencias y estructura del proyecto. |
| **IDE recomendado** | [Visual Studio Code](https://code.visualstudio.com/) con extensión *Extension Pack for Java* | Permite editar, compilar y ejecutar fácilmente. También puedes usar IntelliJ IDEA o Eclipse. |
| **Sistema operativo** | Windows / Linux / macOS | Compatible con cualquier entorno que soporte JDK 25. |

>  **Nota:** Asegúrate de tener configurada la variable de entorno `JAVA_HOME` apuntando al directorio donde está instalado el JDK 21, y de incluir `%JAVA_HOME%\bin` en el `PATH`.

---


### 5. Clonar el Repositorio

Abre tu terminal (o la consola integrada de tu IDE) y ejecuta el siguiente comando para clonar el proyecto desde GitHub:

```bash
git clone [https://github.com/BrTrl3/Taller7-Implementacion-algoritmos-de-busqueda.git](https://github.com/BrTrl3/Taller7-Implementacion-algoritmos-de-busqueda.git)
cd Taller7-implementacion-algoritmos-de-busqueda-main
```
---

### 6. Importar en el IDE

> Abre **IntelliJ IDEA** o **Visual Studio Code**.
>
> Importa el proyecto `Taller7-implementacion-algoritmos-de-busqueda-main` como un proyecto existente (ya sea como proyecto Maven, Gradle, o simplemente una carpeta de código fuente Java).

---

## 7. Guía de Ejecución

Sigue estos pasos para descargar, configurar y ejecutar el proyecto:

###  Configurar Ruta:

<img width="944" height="220" alt="image" src="https://github.com/user-attachments/assets/677197b5-1853-44b8-975d-446dba92cfaa" />

> Remplazar la siguiente linea de código : List<CasoPrueba> casos = unl.edu.ec.pruebas.CasosLoader.leerCSV("src/DatesCSV/Casos.csv");
> Modificar : src/DatesCSV/Casos.csv por la ruta en la que pusiste el directorio 


###  Ejecutar la Clase Principal

> * **Navega a la clase:** `unl/edu/ec/pruebas/SearchDemo.java`.
> * 
> * **Ejecuta la clase SearchDemo ** directamente desde tu IDE (usualmente haciendo clic derecho o usando el botón de "Run").

---

### 8. Salida Esperada:

Runner (compilador de codigo)

### 9. Validacion de casos borde y evidencias:

## Tabla Comparativa de Casos de Prueba

| **ID** | **Método**       | **Arreglo**         | **Clave/Predicado** | **Resultado Esperado** | **Resultado Obtenido** | **Estado** | **Tipo de Caso** |
|--------|------------------|---------------------|---------------------|-------------------------|-------------------------|------------|------------------|
| 16     | buscarPrimero    | [7, 8, 9, 10]      | 8                   | 1                       | 1                       | PASS       | Clásico          |
| 17     | buscarPrimero    | [1, 1, 1, 1]       | 1                   | 0                       | 0                       | PASS       | Clásico          |
| 18     | buscarPrimero    | [5, 6, 7, 8]       | 4                   | -1                      | -1                      | PASS       | Clásico          |
| 19     | buscarPrimero    | []                  | 3                   | -1                      | -1                      | PASS       | Clásico          |
| 20     | buscarPrimero    | null                | 2                   | -1                      | -1                      | PASS       | Clásico          |
| 21     | buscarUltimo     | [3, 3, 3, 3]       | 3                   | 3                       | 3                       | PASS       | Clásico          |
| 22     | buscarUltimo     | [10, 20, 30, 40]   | 25                  | -1                      | -1                      | PASS       | Clásico          |
| 23     | buscarUltimo     | [1, 2, 3, 4, 5]    | 5                   | 4                       | 4                       | PASS       | Clásico          |
| 24     | buscarUltimo     | []                  | 1                   | -1                      | -1                      | PASS       | Clásico          |
| 25     | buscarUltimo     | null                | 0                   | -1                      | -1                      | PASS       | Clásico          |
| 26     | buscarTodos      | [2, 4, 6, 8, 10]   | PAR                 | [0, 1, 2, 3, 4]         | [0, 1, 2, 3, 4]         | PASS       | Clásico          |
| 27     | buscarTodos      | [1, 3, 5, 7, 9]    | IMPAR               | [0, 1, 2, 3, 4]         | [0, 1, 2, 3, 4]         | PASS       | Clásico          |
| 28     | buscarTodos      | [10, 20, 30, 40]   | MAYOR_QUE_3         | [0, 1, 2, 3]            | [0, 1, 2, 3]            | PASS       | Clásico          |
| 30     | buscarTodos      | []                  | SIEMPRE             | []                      | []                      | PASS       | Clásico          |
| 31     | searchWithSentinel | [7, 8, 9, 10]    | 8                   | 1                       | 1                       | PASS       | Centinela        |
| 32     | searchWithSentinel | [1, 1, 1, 1]     | 1                   | 0                       | 0                       | PASS       | Centinela        |
| 33     | searchWithSentinel | [5, 6, 7, 8]     | 4                   | -1                      | -1                      | PASS       | Centinela        |
| 34     | searchWithSentinel | []               | 3                   | -1                      | -1                      | PASS       | Centinela        |
| 35     | searchWithSentinel | null             | 2                   | -1                      | -1                      | PASS       | Centinela        |

### Observaciones:
- **Método**: Nombre del método probado.
- **Arreglo**: Arreglo de entrada para el caso de prueba.
- **Clave/Predicado**: Clave o predicado utilizado en la búsqueda.
- **Resultado Esperado**: Resultado esperado según el caso de prueba.
- **Resultado Obtenido**: Resultado obtenido durante la ejecución.
- **Estado**: Indica si el caso pasó (`PASS`) o falló (`FAIL`).
- **Tipo de Caso**: Indica si el caso pertenece a una búsqueda clásica o con centinela.

  
### **A. Búsqueda Secuencial Clásica: Primera Ocurrencia (`indexOfFirst`)**


<img width="724" height="467" alt="image" src="https://github.com/user-attachments/assets/05b1b516-ac6f-45e9-9c13-0621e59ed86e" />



| ID  | Arreglo             | Clave/Predicado | Resultado Esperado | Resultado Obtenido | Estado |
|-----|---------------------|------------------|--------------------|--------------------|--------|
| 16  | [7, 8, 9, 10]       | 8                | 1                  | 1                  | PASS   |
| 17  | [1, 1, 1, 1]        | 1                | 0                  | 0                  | PASS   |
| 18  | [5, 6, 7, 8]        | 4                | -1                 | -1                 | PASS   |
| 19  | []                  | 3                | -1                 | -1                 | PASS   |
| 20  | null                | 2                | -1                 | -1                 | PASS   |

> La implementación de `indexOfFirst` cumple correctamente con los casos de prueba, identificando la primera ocurrencia de un elemento en el arreglo. Maneja adecuadamente casos especiales como arreglos vacíos o nulos, devolviendo `-1` en estos escenarios.


---

### **B. Búsqueda Secuencial Clásica: Última Ocurrencia (`indexOfLast`)**


<img width="755" height="479" alt="image" src="https://github.com/user-attachments/assets/20114c58-2b66-4969-9367-a1d388da37e9" />



| ID  | Arreglo             | Clave/Predicado | Resultado Esperado | Resultado Obtenido | Estado |
|-----|---------------------|------------------|--------------------|--------------------|--------|
| 21  | [3, 3, 3, 3]        | 3                | 3                  | 3                  | PASS   |
| 22  | [10, 20, 30, 40]    | 25               | -1                 | -1                 | PASS   |
| 23  | [1, 2, 3, 4, 5]     | 5                | 4                  | 4                  | PASS   |
| 24  | []                  | 1                | -1                 | -1                 | PASS   |
| 25  | null                | 0                | -1                 | -1                 | PASS   |

> El método `indexOfLast` funciona correctamente, localizando la última ocurrencia de un elemento en el arreglo. También maneja casos límite como arreglos vacíos o nulos, devolviendo `-1` cuando no se encuentra el elemento.

---

### **C. Búsqueda por Predicado (`findAll`)**

<img width="762" height="412" alt="image" src="https://github.com/user-attachments/assets/c1175f8a-f44d-461d-832f-79c18d554190" />


| ID  | Arreglo             | Predicado        | Resultado Esperado | Resultado Obtenido | Estado |
|-----|---------------------|------------------|--------------------|--------------------|--------|
| 26  | [2, 4, 6, 8, 10]    | PAR              | [0, 1, 2, 3, 4]    | [0, 1, 2, 3, 4]    | PASS   |
| 27  | [1, 3, 5, 7, 9]     | IMPAR            | [0, 1, 2, 3, 4]    | [0, 1, 2, 3, 4]    | PASS   |
| 28  | [10, 20, 30, 40]    | MAYOR\_QUE\_3    | [0, 1, 2, 3]       | [0, 1, 2, 3]       | PASS   |
| 30  | []                  | SIEMPRE          | []                 | []                 | PASS   |

> El método `findAll` demuestra ser robusto al identificar todos los índices que cumplen con un predicado. Responde correctamente a predicados específicos como números pares, impares o mayores que un valor, y maneja casos vacíos devolviendo una lista vacía.


### **D. Búsqueda Secuencial con Centinela (`searchWithSentinel`)**

<img width="1003" height="282" alt="image" src="https://github.com/user-attachments/assets/bdd62caf-6f3a-4518-92a8-77f17118a209" />


| Caso | Arreglo             | Clave | Índice Obtenido | Comparaciones |
|------|---------------------|-------|-----------------|---------------|
| 1    | [7, 8, 9, 10]       | 8     | 1               | 2             |
| 2    | [1, 1, 1, 1]        | 1     | 0               | 1             |
| 3    | [5, 6, 7, 8]        | 4     | -1              | 4             |
| 4    | []                  | 3     | -1              | 0             |
| 5    | null                | 2     | -1              | 0             |

> La búsqueda con centinela optimiza el número de comparaciones al agregar un valor centinela al final del arreglo. El método maneja correctamente arreglos vacíos o nulos, devolviendo `-1` y cero comparaciones en estos casos.


### **D. Pruebas en Listas Simplemente Enlazadas (SLL)**

<img width="718" height="226" alt="image" src="https://github.com/user-attachments/assets/cf917a1d-54f5-4134-b15a-b6a5f82e9252" />


## Tabla Comparativa de Casos de Prueba en Listas Simplemente Enlazadas

| **ID** | **Prueba**                  | **Entrada**         | **Clave/Predicado** | **Resultado Esperado**       | **Resultado Obtenido**       | **Estado** |
|--------|-----------------------------|---------------------|---------------------|------------------------------|------------------------------|------------|
| 1      | Buscar Primera Ocurrencia  | [1, 2, 3, 4, 5]    | 3                   | Nodo con valor 3            | Nodo con valor 3            | PASS       |
| 2      | Buscar Última Ocurrencia   | [1, 2, 3, 4, 5, 3] | 3                   | Nodo con valor 3 (último)   | Nodo con valor 3 (último)   | PASS       |
| 3      | Buscar Todos (Pares)       | [1, 2, 3, 4, 5]    | Pares               | [Nodo con valor 2, 4]       | [Nodo con valor 2, 4]       | PASS       |

### Observaciones:
- **Prueba**: Tipo de prueba realizada (primera ocurrencia, última ocurrencia, etc.).
- **Entrada**: Valores de la lista simplemente enlazada.
- **Clave/Predicado**: Clave o predicado utilizado en la búsqueda.
- **Resultado Esperado**: Resultado esperado según el caso de prueba.
- **Resultado Obtenido**: Resultado obtenido durante la ejecución.
- **Estado**: Indica si el caso pasó (`PASS`) o falló (`FAIL`).

> Los métodos aplicados a listas simplemente enlazadas funcionan correctamente:
> - Encuentran la primera y última ocurrencia de un valor.
> - Identifican nodos que cumplen con un predicado (como valores pares).
> Esto demuestra la flexibilidad y funcionalidad de las operaciones en estructuras enlazadas.


### **Resumen General**
En general, todos los métodos implementados cumplen con los resultados esperados en los casos de prueba, mostrando un comportamiento robusto y confiable incluso en escenarios límite como arreglos vacíos o nulos. Esto valida la correcta implementación de las búsquedas secuenciales y las operaciones en listas enlazadas.


## **Autores:**
### [Ismael Gonzalez](https://github.com/IsmaelGonz)
### [Juan Calopino](https://github.com/JuaaanCalopino)
### [Bryan Troya ](https://github.com/BrTrl3)
### [Darwin Jimbo]
