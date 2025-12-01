import java.util.ArrayList;

public class Puerta implements Suscriptor {
    /*
    La puerta tendrá un contador de la cantidad de enemigos que aparecen,
    actualizándose mediante el patrón Observer para contabilizar el número de enemigos.
     */

    private final static ArrayList<Puerta> puertas = new ArrayList<>();

    //Atributos
    private int numEnemigos;
    private boolean abierto;
    private final int id;

    //Constructores:
    public Puerta() {
        numEnemigos = 0; //Primero se crea la puerta, antes de que haya ningún enemigo
        abierto = true;

        //Suscribimos la puerta al "Publisher"
        Publisher.getNotificador().agregar(this);

        //Indexación de puertas para el toString()
        id = puertas.size();
        puertas.add(this);
    }


    //Métodos:
    /**
     * Muestra por consola si la puerta está abierta o no.
     * @return La puerta se devuelve a si misma.
     */
    public Puerta showAbierto() {
        System.out.print("- - - ");
        if (abierto) System.out.println(this+" está abierta.");
        else System.out.println(this+" está cerrada.");
        return this;
    }
    /**
     * Crea una cadena de caracteres que representa de forma única al objeto.
     * @return Devuelve el tipo de objeto junto a una id.
     */
    @Override
    public String toString() {
        return "Puerta #"+id;
    }


    //Actualizaciones:
    /**
     * Método que nos viene dado por la interfaz del patrón Observer.
     * Maneja las notificaciones de la Puerta.
     * @param notificacion Notificación primitiva, conteniendo la información en forma de String.
     * <p>- generarEnemigo: Aumenta el contador de enemigos necesario para abrir la puerta.
     * <p>- muerteEnemigo: Reduce el contador de enemigos, revisando cuántos quedan para abrirla.
     */
    @Override
    public void update(String notificacion) {
        if (notificacion.equalsIgnoreCase("generarEnemigo")){
            numEnemigos ++;
            if (abierto) abierto = false; // Cerrar puerta
        }
        if (notificacion.equalsIgnoreCase("muerteEnemigo")) {
            numEnemigos --;
            if (numEnemigos <= 0) {
                abierto = true; // Abrir puerta
                System.out.println("Notifier: Enemigos eliminados. Abriendo "+this+".");
            }
            else if (numEnemigos == 1) {
                System.out.println("Notifier: Queda 1 enemigo para abrir "+this+".");
            }
            else {
                System.out.println("Notifier: Quedan "+numEnemigos+" enemigos para abrir "+this+".");
            }
        }
    }
}