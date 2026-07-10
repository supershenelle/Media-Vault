
public class Album {
    private String title;
    private String genre;
    private int trackCount;
    private int songsListened;
    private int year;

    public Album(String title, String genre, int year, int trackCount)
    {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.trackCount = trackCount;
        this.songsListened = 0;
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

    public int getSongsListened()
    {
        return songsListened;
    }

    public void setSongsListened(int songsListened)
    {
        if(songsListened <= trackCount)
            this.songsListened = songsListened;
        else
            System.out.printf("input must be less than or equal to" + trackCount);
    }


    public boolean isCompleted()
    {
        return trackCount == songsListened;
    }


    public String displayInfo()
    {
        String info = "";
        info += "Album: " + title + "\n";
        info += "Genre: " + genre + "\n";
        info += "Year: " + year + "\n";
        info += "Progress: " + songsListened + "/" + trackCount + " songs\n";
        return info;
    }
}
