public class Media {
    // if needed
    private String type;
    private Movie movie;
    private Videogame videogame;
    private MusicArtist musicArtist;
    private Status status;
    private int rating;
    private String review;

    public Media(Movie movie, Status status)
    {
        this.movie = movie;
        this.status = status;
        type = "Movie";
        rating = 0; // or change to null?
        review = "";
    }

    public Media(Videogame videogame, Status status)
    {
        this.videogame = videogame;
        this.status = status;
        type = "Videogame";
        rating = 0;
        review = "";
    }

    public Media(MusicArtist musicArtist, Status status)
    {
        this.musicArtist = musicArtist;
        this.status = status;
        type = "Music Artist";
        rating = 0;
        review = "";
    }

    public Movie getMovie()
    {
        return movie;
    }

    public Videogame getVideogame()
    {
        return videogame;
    }

    public MusicArtist getMusicArtist()
    {
        return musicArtist;
    }

    public String getType()
    {
        return type;
    }

    public Status getStatus()
    {
        return status;
    }

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

    public int getRating()
    {
        return rating;
    }


    public void setReview(String review)
    {
        this.review = review;
    }

    public String getTitle()
    {
        if (type.equals("Movie"))
            return movie.getTitle();

        else if (type.equals("Videogame"))
            return videogame.getTitle();

        else
            return musicArtist.getName();
    }

    public String getReview()
    {
        return review;
    }

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