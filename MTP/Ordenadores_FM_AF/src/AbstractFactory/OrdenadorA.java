package AbstractFactory;

public class OrdenadorA implements TiendaOrdenadores {
    public RAM crearRAM() {
        return new DDR4_8();
    }
    public DiscoDuro crearDiscoDuro() {
        return new HDD512GB();
    }
    public Pantalla crearPantalla() {
        return new Pantalla20LED();
    }
}