package AbstractFactory;

// Fábrica abstracta (Padre)
public interface TiendaOrdenadores {
    RAM crearRAM();
    DiscoDuro crearDiscoDuro();
    Pantalla crearPantalla();
}