public class Main {
    // Clase Cliente que pedirá el Singleton y lo utilizará.
    public static void main(String[] args) {
        System.out.println("1º Creamos una primera consola:");
        ConsolaComandos consola1 = ConsolaComandos.getConsola("Consola 1");

        System.out.println("\n2º Usamos algún método de la consola:");
        consola1.ejecutarComando(1);

        System.out.println("\n3º Intentamos crear una segunda consola:");
        ConsolaComandos consola2 = ConsolaComandos.getConsola("Consola 2");

        System.out.println("\n4º Usamos otro método en la nueva consola:");
        consola2.ejecutarComando(3);

        System.out.println("\nCómo podemos ver, la \"nueva\" consola realmente solo hace referencia a la instancia " +
                "que intentamos crear originalmente, y no a otra consola nueva." +
                "\nPara cambiar un atributo de la consola ya creada, tiene que ser a través de métodos que nos " +
                "permita la clase Singleton.");
    }
}