import java.util.ArrayList;

public class Enemigo implements Suscriptor {
    /*
    El enemigo tendrá variables que se van a modificar, e implementará el método "update()"
    de la interfaz Suscriptor. Esto permitirá al notificador tener una lista de varios
    tipos de objetos distintos, entre ellos el enemigo.
     */

    private final static ArrayList<Enemigo> enemigos = new ArrayList<>();

    // Atributos:
    private int vida;
    private float velocidad;
    private final int id;
    private boolean vivo = true;


    // Constructores:
    public Enemigo(int vida, float velocidad) {
        this.vida = vida;
        this.velocidad = velocidad;

        // 1º) update()
        Publisher.getNotificador().notificar("generarEnemigo");
        //En este orden nos saltamos una notificación, pues no nos interesa avisar
        //a los enemigos de la aparición de otros.

        // 2º) agregar();
        Publisher.getNotificador().agregar(this);

        //Indexación de enemigos para el toString()
        id = enemigos.size();
        enemigos.add(this);

        System.out.println("- - - Aparece "+this);
    }


    //Métodos:
    /**
     * Este es un método prototipo de actualización del enemigo.
     * En este programa lo usamos como ejemplo para demostrar notificaciones
     * automáticas como consecuencia de la muerte de un enemigo.
     * @param danno Daño que se hace al enemigo.
     * @return El enemigo se devuelve a si mismo.
     */
    public Enemigo recibirDanno(int danno) {
        vida -= danno;
        System.out.println(this+" recibe "+danno+" de daño. Le queda "+vida+" de vida.");
        if (vida <= 0) {
            vivo = false;
            System.out.println("- - - "+this+" ha muerto.");
            Publisher.getNotificador().notificar("muerteEnemigo");
        }
        return this;
    }
    /**
     * Muestra por consola la velocidad del enemigo.
     * @return El enemigo se devuelve a si mismo.
     */
    public Enemigo showVelocidad() {
        System.out.println("- - - "+this+": "+velocidad + " de velocidad.");
        return this;
    }
    /**
     * Crea una cadena de caracteres que representa de forma única al objeto.
     * @return Devuelve el tipo de objeto junto a una id.
     */
    @Override
    public String toString() {
        return "Enemigo #"+id;
    }


    // Actualizaciones:
    /**
     * Método que nos viene dado por la interfaz del patrón Observer.
     * Maneja las notificaciones del Enemigo.
     * @param notificacion Notificación primitiva, conteniendo la información en forma de String.
     * <p>- muerteEnemigo: Aumenta la velocidad de este enemigo.
     */
    @Override
    public void update(String notificacion) {
        if (notificacion.equalsIgnoreCase("muerteEnemigo")) {
            if (vivo) {
                velocidad += 0.1F;
                System.out.println("Notifier: " + this + " aumenta su velocidad.");
            }
        }
    }
}