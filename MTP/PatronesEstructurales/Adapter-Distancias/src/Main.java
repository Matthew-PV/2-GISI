import Distancias.*;

public class Main {
    public static void main(String[] args) {
        double velEjemplo = 85;
        // Objetivo: Calcular una distancia máxima en la UE y la equivalente en California

        System.out.println("Distancia en EU - - - - - -");
        DistanciaEU dEU = new DistanciaEU();
        dEU.setAvrgSpeed(velEjemplo); //En kmh
        dEU.distanciaMaxima();

        System.out.println();

        System.out.println("Distancia en California - -");
        AdaptadorDistanciaCalifornia dCalifornia = new AdaptadorDistanciaCalifornia();
        dCalifornia.setAvrgSpeed(velEjemplo);
        dCalifornia.distanciaMaxima();
    }
}