package PlataformasMusica;

import PlataformasMusica.Spotify.AdaptadorSpotify;

public interface AdaptadorPlataformas {
    AdaptadorPlataformas parar();
    AdaptadorPlataformas reproducir();
    AdaptadorPlataformas infoCancion();
    AdaptadorPlataformas cambiarCancion(String cancion);
}