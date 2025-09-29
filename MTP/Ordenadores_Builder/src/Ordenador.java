public class Ordenador {
    private String memoria, discoDuro, pantalla;

    //Getters y Setters:
    public void setRAM(String memoria) {
        this.memoria = memoria;
    }
    public void setDiscoDuro(String discoDuro) {
        this.discoDuro = discoDuro;
    }
    public void setPantalla(String pantalla) {
        this.pantalla = pantalla;
    }


    public String toString() {
        return "Ordenador con "+memoria+" de RAM, "
                +discoDuro+" de almacenamiento y "+pantalla+" de pantalla.";
    }
}