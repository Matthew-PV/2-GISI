package PlataformasMusica.Spotify;

public interface SpotifyInterface {
    // Getters y Setters
    SpotifyInterface setCancion(String cancion);
    String getCancion();
    SpotifyInterface setReproduciendo(boolean reproduciendo);
    boolean isReproduciendo();


    // Métodos
    void botonPlayPausa();
    void queEscucho();
}