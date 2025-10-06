package Distancias;

public class AdaptadorDistanciaCalifornia extends Distancia implements AvrgSpeed {
    private final CaliforniaDistance californiaDistance = new CaliforniaDistance();

    // Getters y Setters:
    @Override
    public AdaptadorDistanciaCalifornia setAvrgSpeed(double avrgSpeed) {
        californiaDistance.setAverageSpeed(avrgSpeed / 1.60934); //Aquí se controla la conversión a millas.
        return this;
    }
    @Override
    public double getAvrgSpeed() {
        return californiaDistance.getAverageSpeed() * 1.60934; //Aquí se controla la conversión a kilómetros.
    }

    // Métodos:
    @Override
    public double distanciaMaxima() {
        return californiaDistance.calculateMaxDistance();
    }
}