public interface Suscriptor {
    /*
    La interfaz se asegura de que todo objeto suscrito tenga un método que permita actualizarlo.
    Por la forma del método (un parámetro String), podemos customizar la reacción
    del objeto a una notificación, pudiendo ignorarla si no nos interesa.
     */
    void update(String notificacion); //Este parámetro se puede complicar en el futuro
}