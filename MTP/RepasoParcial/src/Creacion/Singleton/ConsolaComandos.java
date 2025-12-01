package Creacion.Singleton;

public class ConsolaComandos {
    // Clase Singleton que manejará la existencia de una consola de comandos,
    // garantizando que sea una instancia única accesible por el programa.

    // No es necesario crear el constructor, sino que manejaremos una instancia estática:
    private static ConsolaComandos consola;

    /**
     * Método de acceso a la instancia única desde el exterior.
     * Si la consola no está creada, la inicializa y devuelve.
     * Si ya está creada, simplemente devuelve la instancia.
     * @return Devuelve una Consola de Comandos.
     */
    public static ConsolaComandos getConsola() {
        if (consola == null) {
            consola = new ConsolaComandos();
        }
        return consola;
    }
}