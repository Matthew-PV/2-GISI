import java.util.ArrayList;

public class Publisher {
    /*
    La clase Publisher actúa como el Observer en este ejemplo, manejando la lista de suscriptores,
    y encargándose de que todos ellos reciban notificaciones.
     */

    //Contenedor que alojará la lista de suscriptores. En versiones más avanzadas del patrón
    //se suele almacenar en Mapas que clasifican el tipo de notificación en función del
    //tipo de objeto. Por ejemplo:
    //      (...) HashMap<TipoEvento, Suscriptor> suscriptores (...)
    private final ArrayList<Suscriptor> suscriptores = new ArrayList<>();

    //Todos los enemigos, puertas y jugadores se guardan en este publisher específico
    //siguiendo el patrón Singleton. Esto nos asegura acceso a un objeto único
    //de notificación, reduciendo redundancia.
    private static Publisher notificador;


    //Constructores:
    /**
     * Aunque de forma indirecta, este objeto es el "constructor" de la clase.
     * Es el método utilizado por el patrón del Singleton para construir la instancia
     * única de la clase.
     * En caso de querer diferenciar distintos notificadores, habría de cambiar la estructura.
     * @return Devuelve el objeto estático "notificador", que Observa este programa.
     */
    public static Publisher getNotificador() {
        if (notificador == null) {
            notificador = new Publisher();
        }
        return notificador;
    }


    //Métodos de actualización:
    /**
     * Permite añadir nuevos suscriptores a la lista.
     * Internamente, los añade a la lista del Singleton.
     * <p>
     * Además, revisa si el objeto esta agregado o no,
     * para evitar repeticiones.
     * @param suscriptor Objeto específico a suscribir.
     */
    public void agregar(Suscriptor suscriptor) {
        if (suscriptores.contains(suscriptor)) {
            System.out.println("Este objeto ya está suscrito.");
        } else {
            suscriptores.add(suscriptor);
        }
    }
    /**
     * Permite eliminar suscriptores de la lista.
     * Internamente, los elimina de la lista del Singleton.
     * <p>
     * Además revisa si el objeto está suscrito o no,
     * para evitar errores.
     * @param suscriptor Objeto específico a eliminar.
     */
    public void eliminar(Suscriptor suscriptor) {
        if (suscriptores.contains(suscriptor)){
            suscriptores.remove(suscriptor);
        } else {
            System.out.println("Ya está suscrito el objeto");
        }
    }
    /**
     * Permite enviar notificaciones a todos los objetos suscritos a la lista.
     * Internamente, envía una notificación a los objetos de la lista del Singleton.
     * @param notificacion Notificación primitiva, de tipo String. No nos interesa manejar
     *                     que notificación es ni a quién enviarla en este programa simple.
     */
    public void notificar(String notificacion) { // No nos preocupamos de la notificación, sólo de mandarla
        for (Suscriptor a : suscriptores){
            a.update(notificacion);
        }
    }
}