import java.util.ArrayList;
import java.util.List;

public class Album {
    private String title;
    private String genre;
    //  private ArrayList<Song> songs; //IF ADD TAYO SONG CLASS
    private int trackCount;
    private int year;
    private int duration;

    public Album(String title, String genre, int year)
    {
        this.title = title;
        this.genre = genre;
        this.year = year;
        // songs = new ArrayList<>();
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public int getTrackCount()
    {
        return trackCount;
    }

    public void setTrackCount(int trackCount)
    {
        this.trackCount = trackCount;
    }

    public int getDuration()
    {
        return duration;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }

/*
    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void addSong(Song song) {
        songs.add(song);
        trackCount = songs.size();
    }

    public void removeSong(Song song) {
        songs.remove(song);
        trackCount = songs.size();
    }
*/
    public String displayInfo()
    {

        String info = "";

        info += "Album: " + title + "\n";
        info += "Genre: " + genre + "\n";
        info += "Year: " + year + "\n";
        info += "Tracks: " + trackCount + "\n";
        info += "Duration: " + duration + " mins\n";

        return info;
    }
}
