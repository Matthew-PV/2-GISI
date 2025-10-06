package PlataformasMusica.AppleMusic;

public class AppleMusic implements AppleMusicInterface {
    private String song = "";
    private boolean playing;

    // Getters and Setters
    @Override
    public AppleMusicInterface setSong(String song) {
        System.out.println("Changing song to "+song+" on Apple Music.");
        this.song = song;
        return this;
    }
    @Override
    public String getSong() {
        return song;
    }


    // Methods
    @Override
    public void musicInfo() {
        System.out.println("You're listening to "+song+" on Apple Music.");
    }
    @Override
    public void stopSong() {
        if (playing) {
            System.out.println("Stopping song on Apple Music.");
            playing = false;
        }
        else
            System.out.println("There is no music playing on Apple Music.");
    }
    @Override
    public void playSong() {
        if (!playing) {
            System.out.println("Playing song on Apple Music.");
            playing = true;
        }
        else
            System.out.println("There is no music playing on Apple Music.");
    }
}
