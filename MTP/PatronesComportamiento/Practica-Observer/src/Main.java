public class Main {
    /*
    Este programa main contendrá un ejemplo de escenario:
        - Un único jugador se enfrentará a varias puerta.
        - Aparecerá un número de enemigos.
        - El jugador deberá reducir la vida de todos los enemigos a 0 para avanzar.
        - Las notificaciones serán automáticas, gracias al patrón Observer.
     */
    public static void main(String[] args) {
        // Crear elementos de la sala
        Jugador j1 = new Jugador();
        j1.showXp();
        Puerta p0 = new Puerta();
        Puerta p1 = new Puerta();
        // Las puertas están abiertas
        p0.showAbierto();
        p1.showAbierto();

        // Aparecen enemigos
        Enemigo e0 = new Enemigo(5,1);
        Enemigo e1 = new Enemigo(5,1);

        // Las puertas se cierran
        p0.showAbierto();
        p1.showAbierto();

        System.out.println();
        // El jugador se defiende
        e0.recibirDanno(3);
        e1.recibirDanno(5);

        System.out.println();
        // Reacción de e1 por sobrevivir
        e0.showVelocidad().recibirDanno(3);

        System.out.println();
        // Las puertas se abren
        p0.showAbierto();
        p1.showAbierto();
        j1.showXp();
    }
}