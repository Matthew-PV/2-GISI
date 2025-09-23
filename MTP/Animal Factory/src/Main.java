// Clase principal para probar el patrón Factory
public class Main {
    public static void main(String[] args) {
        // Creamos una instancia de la fábrica de animales
        AnimalFactory animalFactory = new AnimalFactory();
        // Obtener un Perro y hacer que haga su sonido
        Animal animal1 = animalFactory.getAnimal("Perro");
        animal1.sonido();  // Salida: El perro hace: Guau Guau
        // Obtener un Gato y hacer que haga su sonido
        Animal animal2 = animalFactory.getAnimal("Gato");
        animal2.sonido();  // Salida: El gato hace: Miau Miau
        // Obtener una Vaca y hacer que haga su sonido
        Animal animal3 = animalFactory.getAnimal("Vaca");
        animal3.sonido();  // Salida: La vaca hace: Muuu Muuu
    }
}