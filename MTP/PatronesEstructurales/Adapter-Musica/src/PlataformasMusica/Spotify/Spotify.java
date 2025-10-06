package PlataformasMusica.Spotify;

public class Spotify implements SpotifyInterface {
    private String cancion = "";
    private boolean reproduciendo = false;

    // Getters y Setters
    @Override
    public Spotify setCancion(String cancion) {
        System.out.println("Cambiando a canción "+cancion+" en Spotify.");
        this.cancion = cancion;
        return this;
    }
    @Override
    public String getCancion() {
        return cancion;
    }

    @Override
    public Spotify setReproduciendo(boolean reproduciendo) {
        this.reproduciendo = reproduciendo;
        return this;
    }
    @Override
    public boolean isReproduciendo() {
        return reproduciendo;
    }


    // Métodos
    @Override
    public void botonPlayPausa() {
        if (reproduciendo) {
            reproduciendo = false;
            System.out.println("Parando canción en Spotify.");
        }
        else {
            reproduciendo = true;
            System.out.println("Reproduciendo canción en Spotify.");
        }
    }
    @Override
    public void queEscucho() {
        System.out.println("Estás escuchando la canción "+cancion+" en Spotify.");
    }
}