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

### 9. Validacion de casos borde y evidencias

## Caso: Busqueda secuencial clasica

<img width="724" height="467" alt="image" src="https://github.com/user-attachments/assets/05b1b516-ac6f-45e9-9c13-0621e59ed86e" />



## **Autores:**
### [Ismael Gonzalez](https://github.com/IsmaelGonz)
### [Juan Calopino](https://github.com/JuaaanCalopino)
### [Bryan Troya ](https://github.com/BrTrl3)
