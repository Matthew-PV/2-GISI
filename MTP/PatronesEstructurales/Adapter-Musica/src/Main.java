import PlataformasMusica.AppleMusic.*;
import PlataformasMusica.Spotify.*;

public class Main {
    // Objetivo: Reproducir música desde dos plataformas distintas
    public static void main(String[] args) {
        // Reproducir en Spotify:
        AdaptadorSpotify spotify = new AdaptadorSpotify();
        spotify.cambiarCancion("Beautiful Things - Benson Boone")
                .reproducir()
                .infoCancion();

        System.out.println();

        // Reproducir en Apple Music:
        AdaptadorAppleMusic appleMusic = new AdaptadorAppleMusic();
        appleMusic.cambiarCancion("More Than Words - SHAUN")
                .reproducir()
                .infoCancion();
    }
}