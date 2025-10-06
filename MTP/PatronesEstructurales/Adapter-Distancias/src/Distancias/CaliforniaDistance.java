package Distancias;

public class CaliforniaDistance {
    private final double maxSpeed = 55; //In mph
    private final double maxLaborTime = 8; //In hours
    private double avrgSpeed;

    // Getters and Setters:
    public CaliforniaDistance setAverageSpeed(double avrgSpeed) {
        if (avrgSpeed > maxSpeed) {
            System.out.println("Warning: Higher average speed ("+avrgSpeed+" mph) than the maximum ("
                    +maxSpeed+" mph)!");
        }
        else {
            System.out.println("Setting average speed to "+avrgSpeed+" mph.");
            this.avrgSpeed = avrgSpeed;
        }
        return this;
    }
    public double getAverageSpeed() {
        return avrgSpeed;
    }

    // Methods:
    public double calculateMaxDistance() {
        double distance = 0;
        System.out.println("Calculating maximum distance.");

        //Distance = velocity * time
        if (avrgSpeed != 0) {
            distance = avrgSpeed * maxLaborTime;
        }
        else {
            System.out.println("Average Speed set to 0.");
        }

        System.out.println("The maximum distance is of "+distance+" miles.");
        return distance;
    }
}