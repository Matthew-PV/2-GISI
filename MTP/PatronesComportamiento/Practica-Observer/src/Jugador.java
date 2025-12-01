import java.util.ArrayList;

public class Jugador implements Suscriptor {
    /*
    La clase jugador se actualizará mediante el Observer únicamente cuando
    un enemigo muera, para aumentar su nivel de experiencia.
     */

    private final static ArrayList<Jugador> jugadores = new ArrayList<>();

    //Atributos:
    private int xp;
    private final int id;

    //Constructores
    public Jugador() {
        xp = 0;

        //Lo suscribimos a la lista de notificadores.
        Publisher.getNotificador().agregar(this);

        //Indexación de jugadores para el toString()
        id = jugadores.size();
        jugadores.add(this);
    }


    //Métodos:
    /**
     * Muestra por consola la experiencia del jugador.
     * @return El jugador se devuelve a si mismo.
     */
    public Jugador showXp() {
        System.out.println("- - - "+this+": "+xp+" de xp.");
        return this;
    }
    /**
     * Crea una cadena de caracteres que representa de forma única al objeto.
     * @return Devuelve el tipo de objeto junto a una id.
     */
    @Override
    public String toString() {
        return "Jugador #"+id;
    }


    //Actualizaciones:
    /**
     * Método que nos viene dado por la interfaz del patrón Observer.
     * Maneja las notificaciones del Jugador.
     * @param notificacion Notificación primitiva, conteniendo la información en forma de String.
     * <p>- muerteEnemigo: Da experiencia al jugador.
     */
    @Override
    public void update(String notificacion) {
        if (notificacion.equalsIgnoreCase("muerteEnemigo")) {
            xp += 5;
            System.out.println("Notifier: "+this+" gana 5 de experiencia. Tiene "+xp+".");
        }
    }
}