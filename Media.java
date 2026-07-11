/**
 * represents all the media types and where ratings and reviews happen
 */
public class Media {
    // if needed
    private String type;
    private Movie movie;
    private Videogame videogame;
    private MusicArtist musicArtist;
    private Status status;
    private int rating;
    private String review;

    /**
     * constructs a movie media entry
     * @param movie is the movie info
     * @param status initial status
     */
    public Media(Movie movie, Status status)
    {
        this.movie = movie;
        this.status = status;
        type = "Movie";
        rating = 0; // or change to null?
        review = "";
    }

    /**
     * constructs a videogame media entry
     * @param videogame is the videogame info
     * @param status initial status
     */
    public Media(Videogame videogame, Status status)
    {
        this.videogame = videogame;
        this.status = status;
        type = "Videogame";
        rating = 0;
        review = "";
    }

    /**
     * constructs a music artist media entry
     * @param musicArtist is the musicArtist info
     * @param status initial status
     */
    public Media(MusicArtist musicArtist, Status status)
    {
        this.musicArtist = musicArtist;
        this.status = status;
        type = "Music Artist";
        rating = 0;
        review = "";
    }

    /**
     * get the movie object
     * @return the movie object
     */
    public Movie getMovie()
    {
        return movie;
    }

    /**
     * get the Videogame object
     * @return the Videogame object
     */
    public Videogame getVideogame()
    {
        return videogame;
    }

    /**
     * get the MusicArtist object
     * @return the MusicArtist object
     */
    public MusicArtist getMusicArtist()
    {
        return musicArtist;
    }

    /**
     * get Media type
     * @return Media type
     */
    public String getType()
    {
        return type;
    }

    /**
     * get media status
     * @return media status
     */
    public Status getStatus()
    {
        return status;
    }

    /**
     * set status of the media entry.
     * if media type is music artist, cant set to completed unless all albums in the artist's discography is completed
     * @param status is the new status
     * @return true if status is set, otherwise print error message and return false
     */
    public boolean setStatus(Status status) {
        // check if music artist, since pede mo lang sya marate if completed na albums
        if(type.equals("Music Artist"))
        {
            if(status == Status.COMPLETED && !musicArtist.isCompleted())
            {
                System.out.println("You haven't finished all albums yet.");
                musicArtist.getProgress();
                return false;
            }
        }
        this.status = status;
        return true;
    }

    /**
     * set rating for media entry
     * @param rating new rating
     * @return true if rating is set, otherwise return false and print error message
     */
    public boolean setRating(int rating)
    {
        if (rating < 1 || rating > 5)
        {
            System.out.println("ERROR: Input a number between 1 to 5 only");
            return false;
        }

        this.rating = rating;
        return true;
    }

    /**
     * get rating of media entry
     * @return rating of media entry
     */
    public int getRating()
    {
        return rating;
    }

    /**
     * set review of media entry
     * @param review is the new review of media entry
     */
    public void setReview(String review)
    {
        this.review = review;
    }

    /**
     * get the title/name of the movie, videogame, or music artist based on media type
     * @return title/name of the movie, videogame, or music artist
     */
    public String getTitle()
    {
        if (type.equals("Movie"))
            return movie.getTitle();

        else if (type.equals("Videogame"))
            return videogame.getTitle();

        else
            return musicArtist.getName();
    }

    /**
     * get review of the media entry
     * @return review of media entry
     */
    public String getReview()
    {
        return review;
    }

    /**
     * display a summary of media entry
     * @return summary of media entry
     */
    public String displayInfo()
    {
        String info = "";

        info += "Type: " + type + "\n";
        info += "Status: " + status + "\n";

        if(type.equals("Movie"))
            info += movie.displayInfo();
        else if(type.equals("Videogame"))
            info += videogame.displayInfo();
        else
            info += musicArtist.displayInfo();

        if(status == Status.COMPLETED)
        {
            info += "\nRating: " + rating;
            info += "\nReview: " + review;
        }
        return info;
    }
}