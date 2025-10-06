package Distancias;

public class DistanciaEU extends Distancia implements AvrgSpeed {
    private final double velMax = 100; //En kmh
    private final double tiempoJornadaMax = 7.5; //En horas
    private double velMedia;

    // Getters y Setters:
    @Override
    public DistanciaEU setAvrgSpeed(double velMedia) {
        if (velMedia > velMax) {
            System.out.println("Aviso: ¡Velocidad media ("+velMedia+
                    " kmh) superior a la máxima ("+velMax+" kmh)!");
        }
        else {
            System.out.println("Cambiando velocidad media a "+velMedia+" kmh.");
            this.velMedia = velMedia;
        }
        return this;
    }
    @Override
    public double getAvrgSpeed() {
        return velMedia;
    }

    // Métodos:
    @Override
    public double distanciaMaxima() {
        double distancia = 0;
        System.out.println("Calculando distancia máxima.");

        //Distancias.Distancia = velocidad * tiempo
        if (velMedia != 0) {
            distancia = velMedia * tiempoJornadaMax;
        }
        else {
            System.out.println("Velocidad media es 0.");
        }

        System.out.println("La distancia máxima es de "+distancia+" kilómetos.");
        return distancia;
    }
}