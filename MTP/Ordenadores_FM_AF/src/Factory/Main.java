package Factory;

public class Main {
    public static void main(String[] args) {
        Tienda tienda = new TiendaOrdenadores();
        Ordenadores ordenador1 = tienda.createOrdenador("TipoA");
        ordenador1.pedido();
        Ordenadores ordenador2 = tienda.createOrdenador("TipoB");
        ordenador2.pedido();
        Ordenadores ordenador3 = tienda.createOrdenador("TipoC");
        ordenador3.pedido();
    }
}