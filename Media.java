public class Media {
    // if needed
    private String type;
    private Movie movie;
    private Videogame videogame;
    private MusicArtist musicArtist;
    private String status;
    private int rating;
    private String review;

    public Media(Movie movie, String status)
    {
        this.movie = movie;
        this.status = status;
        type = "Movie";
        rating = 0; // or change to null?
        review = "";
    }

    public Media(Videogame videogame, String status)
    {
        this.videogame = videogame;
        this.status = status;
        type = "Videogame";
        rating = 0;
        review = "";
    }

    public Media(MusicArtist musicArtist, String status)
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

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status) {
        if (status.equalsIgnoreCase("Completed")
                && type.equals("Music Artist")
                && !musicArtist.isCompleted()) {
            System.out.println("You haven't finished all albums yet.");
            return;
        }
        this.status = status;
    }

    public void setRating(int rating)
    {
        if(status.equalsIgnoreCase("Completed"))
        {
            this.rating = rating; // DONT FORGET TO ADD LOWER/UPPER BOUND IF LIKE HANGGANG 1-5 STARS LNG PDE
        }
        else
        {
            System.out.println("you still havent completed this entry");
        }
    }

    public int getRating()
    {
        return rating;
    }


    public void setReview(String review)
    {
        if(status.equalsIgnoreCase("Completed"))
        {
            this.review = review;
        }
        else
        {
            System.out.println("you still havent completed this entry");
        }
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

        if(status.equals("Completed"))
        {
            info += "\nRating: " + rating;
            info += "\nReview: " + review;
        }
        return info;
    }
}