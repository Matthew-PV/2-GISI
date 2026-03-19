public class FahrenheitToCelsiusAdapter implements TemperatureSensor {
    LegacyFahrenheitSensor legacySensor = new LegacyFahrenheitSensor();
    @Override
    public double getTemperatureCelsius() {
        return legacySensor.getTemperatureFahrenheit() * ;
    }
}
