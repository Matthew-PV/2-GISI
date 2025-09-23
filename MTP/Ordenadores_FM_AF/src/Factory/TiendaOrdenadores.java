package Factory;

class TiendaOrdenadores extends Tienda {
    public Ordenadores createOrdenador(String tipo) {
        if (tipo.equals("TipoA")) {
            return new OrdenadorTipoA();
        } else if (tipo.equals("TipoB")) {
            return new OrdenadorTipoB();
        } else if (tipo.equals("TipoC")) {
            return new OrdenadorTipoC();
        }
        return null;
    }
}