package unl.edu.ec.pruebas;

// Es crucial que esta clase tenga 6 campos
public class CasoPrueba {
    public int id;
    public String metodo;
    public int[] arreglo;
    public Integer clave;
    public String predicadoNombre;
    public String resultadoEsperado;

    public CasoPrueba(int id, String metodo, int[] arreglo, Integer clave, String predicadoNombre, String resultadoEsperado) {
        this.id = id;
        this.metodo = metodo;
        this.arreglo = arreglo;
        this.clave = clave;
        this.predicadoNombre = predicadoNombre;
        this.resultadoEsperado = resultadoEsperado;
    }
}