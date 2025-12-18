
public class ConsolaComandos {
    // Clase Singleton que manejará la existencia de una consola de comandos,
    // garantizando que sea una instancia única accesible por el programa.


    //              ATRIBUTOS
    private String nombre;
    // Instancia Singleton. No necesitamos crear un constructor porque siempre usaremos esta instancia.
    private static ConsolaComandos consola;


    //         OBTENCIÓN DEL SINGLETON
    // Constructor privado utilizado únicamente la primera vez que se usa la consola:
    private ConsolaComandos(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Métod_o de acceso controlado a la instancia única desde el exterior.
     * Si la consola no está creada, la inicializa y devuelve.
     * Si ya está creada, simplemente devuelve la instancia.
     * @return Devuelve la Consola de Comandos.
     */
    public static ConsolaComandos getConsola(String nombre) {
        if (consola == null) {
            System.out.println(amarillo+"Inicializando consola "+nombre+reset);
            consola = new ConsolaComandos(nombre);
        }
        else System.out.println(amarillo+"La consola ya está inicializada. " +
                "Proporcionando consola "+consola.nombre+reset);
        return consola;
    }


    //              MÉTODOS
    /**
     * Ejecuta un comando
     * @param comando El comando que se ejecutará.
     */
    public void ejecutarComando(int comando) {
        System.out.println(amarillo+"Ejecutando comando "+comando+" en consola "+nombre+reset);
    }
    @Override
    public String toString() {
        return amarillo+"Consola "+nombre+reset;
    }

















    private static final String amarillo = "\u001B[33m";
    private static final String reset = "\u001B[0m";
}