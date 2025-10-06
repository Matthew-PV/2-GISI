public class OrdenadorTipoB implements OrdenadorBuilder {
    private Ordenador ordenador;

    public OrdenadorTipoB(){
        ordenador = new Ordenador();
    }

    @Override
    public void buildRAM() {
        ordenador.setRAM("16 GB DDR4");
    }

    @Override
    public void buildDiscoDuro() {
        ordenador.setDiscoDuro("1 TB HDD");
    }

    @Override
    public void buildPantalla() {
        ordenador.setPantalla("22' LED");
    }

    @Override
    public Ordenador getOrdenador() {
        return ordenador;
    }
}
