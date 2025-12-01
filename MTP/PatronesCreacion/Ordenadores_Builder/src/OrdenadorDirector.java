public class OrdenadorDirector {
    private final OrdenadorBuilder builder;

    //Constructor:
    public OrdenadorDirector(OrdenadorBuilder builder) {
        this.builder = builder;
    }

    //Construcción:
    public void makeOrdenador() {
        builder.buildRAM();
        builder.buildDiscoDuro();
        builder.buildPantalla();
    }

    public Ordenador getOrdenador() {
        return builder.getOrdenador();
    }
}