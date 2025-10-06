public class OrdenadorTipoA implements OrdenadorBuilder {
    private Ordenador ordenador;

    //Constructor:
    public OrdenadorTipoA() {
        ordenador = new Ordenador();
    }
    @Override
    public void buildRAM() {
        ordenador.setRAM("8 GB DDR4");
    }
    @Override
    public void buildDiscoDuro() {
        ordenador.setDiscoDuro("512 GB de HDD");
    }
    @Override
    public void buildPantalla() {
        ordenador.setPantalla("20' LED");
    }

    @Override
    public Ordenador getOrdenador() {
        return ordenador;
    }
}