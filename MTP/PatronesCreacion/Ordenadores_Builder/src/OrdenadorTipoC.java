public class OrdenadorTipoC implements OrdenadorBuilder {
    private Ordenador ordenador;

    //Constructor:
    public OrdenadorTipoC() {
        ordenador = new Ordenador();
    }

    @Override
    public void buildRAM() {
        ordenador.setRAM("8 GB DDR5");
    }

    @Override
    public void buildDiscoDuro() {
        ordenador.setDiscoDuro("512 GB SSD");
    }

    @Override
    public void buildPantalla() {
        ordenador.setPantalla("24' OLED");
    }

    @Override
    public Ordenador getOrdenador() {
        return ordenador;
    }
}