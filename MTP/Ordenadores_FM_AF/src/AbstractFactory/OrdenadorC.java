package AbstractFactory;

public class OrdenadorC implements TiendaOrdenadores {
    public RAM crearRAM() {
        return new DDR5();
    }
    public DiscoDuro crearDiscoDuro() {
        return new SSD512GB();
    }
    public Pantalla crearPantalla() {
        return new Pantalla24_OLED();
    }
}