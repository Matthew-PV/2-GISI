package AbstractFactory;

public class OrdenadorB implements TiendaOrdenadores {
    public RAM crearRAM() {
        return new DDR4_16();
    }
    public DiscoDuro crearDiscoDuro() {
        return new HDD1TB();
    }
    public Pantalla crearPantalla() {
        return new Pantalla22LED();
    }
}