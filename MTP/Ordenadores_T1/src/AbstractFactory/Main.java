package AbstractFactory;

/*
Crear un programa que permita crear un ordenador personal, seleccionando las piezas
y elementos necesarios para su ensamblaje. El programa deberá permitir crear el
ORDENADOR TIPO A, ORDENADOR TIPO B y ORDENADOR TIPO C. Estos 3 TIPOS de ordenadores
se diferencian en el tipo de memoria AbstractFactory.RAM y su capacidad, el tipo de disco duro y su
capacidad, y las dimensiones de su pantalla y calidad. Hacer el programa de dos
formas distintas.
 */
public class Main {
    public static void main(String[] args) {
        //Escogemos el tipo de ordenador en el propio código
        TiendaOrdenadores ordenador = new OrdenadorB();

        RAM ram = ordenador.crearRAM();
        DiscoDuro disco = ordenador.crearDiscoDuro();
        Pantalla pantalla = ordenador.crearPantalla();

        //Esto devuelve texto de consola
        ram.montarRAM();
        disco.montarDisco();
        pantalla.montarPantalla();
    }
}