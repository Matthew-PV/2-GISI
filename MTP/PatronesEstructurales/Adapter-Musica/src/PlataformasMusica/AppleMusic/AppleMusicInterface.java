package PlataformasMusica.AppleMusic;

public interface AppleMusicInterface {
    // Getters and Setters
    AppleMusicInterface setSong(String song);
    String getSong();

    // Methods
    void musicInfo();
    void stopSong();
    void playSong();
}