import java.util.ArrayList;
import java.util.List;

public class Album {
    private String title;
    private String genre;
    private int trackCount;
    private int songsListened;
    private int year;
    private int rating;
    private String review;

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

    public void setSongsListened()
    {
        if (songsListened < trackCount)
            songsListened++;
    }

    // para di paisa-isa/increment yung songs listened
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

    public void setRating(int rating) {
        if (isCompleted())
        {
            if (rating >= 1 && rating <= 10) {
                this.rating = rating;
            }
            else {
                System.out.println("Rating must be between 1 and 10.");
            }
        }
        else
        {
            System.out.println("You haven't finished this album yet.");
        }
    }

    public int getRating()
    {
        return rating;
    }


    public void setReview(String review) {
        if (isCompleted())
            this.review = review;
         else
            System.out.println("You haven't finished this album yet.");

    }

    public String getReview()
    {
        return review;
    }

    public String displayInfo()
    {
        String info = "";
        info += "Album: " + title + "\n";
        info += "Genre: " + genre + "\n";
        info += "Year: " + year + "\n";
        info += "Progress: " + songsListened + "/" + trackCount + " songs\n";
        if (isCompleted()) {
            info += "Rating: " + rating + "\n";
            info += "Review: " + review + "\n";
        }
        return info;
    }
}
