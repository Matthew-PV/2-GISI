import static java.lang.System.nanoTime;

public class Main {
    //Clase que aloja las simulaciones:
    public static void main(String[] args) {
        //Creamos manualmente una experiencia:
        System.out.println("Cargando experiencia fusión de 0.");
        long start = nanoTime();
        FusionExperience fusionDe0 = new FusionExperience();
        fusionDe0.setUsername("Juan Perez");
        fusionDe0.setPlanType("Fusion Experience");
        fusionDe0.setLanguage("es");
        fusionDe0.setMenu("Fusion Menu");
        fusionDe0.setOffers("+10 GB gratis");
        fusionDe0.setBanners("Fusion Banners");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long timeDe0 = nanoTime()-start;
        System.out.println(fusionDe0.toString());
        System.out.println("Tiempo de ejecución: "+timeDe0+" ns, en milisegundos: "+timeDe0/1000000+" ms\n");

        //Ahora la creamos con la copia
        System.out.println("Creando experiencia de fibra mediante clonación.");
        start = nanoTime();
        FibraExperience fibra1 = PrototypeRegister.fibraPrototype.clone();
        fibra1.setUsername("Fernando Alonso");
        fibra1.setLanguage("es");
        fibra1.setOffers("+5 GB gratis");
        System.out.println(fibra1);
        long timePrototype = nanoTime() - start;
        System.out.println("Tiempo de ejecución: "+timePrototype+" ns, en milisegundos: "+timePrototype/1000000+" ms");
    }
}