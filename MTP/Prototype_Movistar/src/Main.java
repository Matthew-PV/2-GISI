public class Main {
    //Clase que aloja las simulaciones:
    public static void main(String[] args) {
        //Creamos manualmente una experiencia:
        System.out.println("Creando experiencia fusión de 0.");
        FusionExperience fusionDe0 = new FusionExperience();
        // Threads(2000) que hace esperar
        System.out.println(fusionDe0);

        //Ahora la creamos con la copia
        System.out.println("Creando experiencia de fusión mediante clonación.");
        FusionExperience fusion1 = PrototypeRegister.fusionExperiencePrototype.clone();
        System.out.println(fusion1);
    }
}