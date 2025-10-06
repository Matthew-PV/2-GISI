package PlataformasMusica.Spotify;

import PlataformasMusica.AdaptadorPlataformas;

public class AdaptadorSpotify implements AdaptadorPlataformas {
    private final Spotify spotify = new Spotify();

    // Métodos:
    public AdaptadorSpotify parar() {
        if (spotify.isReproduciendo())
            spotify.botonPlayPausa();
        else
            System.out.println("No se está reproduciendo música en Spotify.");
        return this;
    }
    public AdaptadorSpotify reproducir() {
        if (spotify.isReproduciendo())
            System.out.println("Ya se está reproduciendo música en Spotify.");
        else
            spotify.botonPlayPausa();
        return this;
    }
    @Override
    public AdaptadorSpotify infoCancion() {
        spotify.queEscucho();
        return this;
    }
    @Override
    public AdaptadorSpotify cambiarCancion(String cancion) {
        spotify.setCancion(cancion);
        return this;
    }
}