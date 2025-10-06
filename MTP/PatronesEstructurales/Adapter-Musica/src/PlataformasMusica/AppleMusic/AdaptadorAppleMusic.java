package PlataformasMusica.AppleMusic;

import PlataformasMusica.AdaptadorPlataformas;

public class AdaptadorAppleMusic implements AdaptadorPlataformas {
    private final AppleMusic appleMusic = new AppleMusic();

    // Métodos
    @Override
    public AdaptadorAppleMusic parar() {
        appleMusic.stopSong();
        return this;
    }
    @Override
    public AdaptadorAppleMusic reproducir() {
        appleMusic.playSong();
        return this;
    }
    @Override
    public AdaptadorAppleMusic infoCancion() {
        appleMusic.musicInfo();
        return this;
    }
    @Override
    public AdaptadorAppleMusic cambiarCancion(String cancion) {
        appleMusic.setSong(cancion);
        return this;
    }
}