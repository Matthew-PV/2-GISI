// Clase Fábrica que crea objetos de tipo Animal
class AnimalFactory {
    // Método de la fábrica que crea el tipo de Animal adecuado
    public Animal getAnimal(String tipoDeAnimal) {
        if (tipoDeAnimal == null) {
            return null;
        }
        if (tipoDeAnimal.equalsIgnoreCase("Perro")) {
            return new Perrro();
        } else if (tipoDeAnimal.equalsIgnoreCase("Gato")) {
            return new Gato();
        } else if (tipoDeAnimal.equalsIgnoreCase("Vaca")) {
            return new Vaca();
        }
        return null;
    }
}