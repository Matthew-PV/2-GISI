public class Main {
    public static void main(String[] args) {
        //Creamos los Constructores y Directores tipo A:
        OrdenadorBuilder builderA = new OrdenadorTipoA();
        OrdenadorDirector directorA = new OrdenadorDirector(builderA);
        directorA.makeOrdenador();
        Ordenador ordenadorA = directorA.getOrdenador();
        System.out.println(ordenadorA);
        // Output: Ordenador con 8 GB DDR4 de RAM, 512 GB de HDD de almacenamiento y 20' LED de pantalla.

        //Creamos los Constructores y Directores tipo B:
        OrdenadorBuilder builderB = new OrdenadorTipoB();
        OrdenadorDirector directorB = new OrdenadorDirector(builderB);
        directorB.makeOrdenador();
        Ordenador ordenadorB = directorB.getOrdenador();
        System.out.println(ordenadorB);
        // Output: Ordenador con 16 GB DDR4 de RAM, 1 TB HDD de almacenamiento y 22' LED de pantalla.

        //Creamos los Constructores y Directores tipo C:
        OrdenadorBuilder builderC = new OrdenadorTipoC();
        OrdenadorDirector directorC = new OrdenadorDirector(builderC);
        directorC.makeOrdenador();
        Ordenador ordenadorC = directorC.getOrdenador();
        System.out.println(ordenadorC);
        // Output: Ordenador con 8 GB DDR5 de RAM, 512 GB SSD de almacenamiento y 24' OLED de pantalla.
    }
}