import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Media> entries = new ArrayList<>();

    public void displayMovies()
    {
        System.out.println("--- CURRENT FILMS IN LIBRARY ---");
        boolean hasMovies = false;
        for (Media media : entriesList)
        {
            if (media.getType().equalsIgnoreCase("Movie") && media.getMovie() != null)
            {
                System.out.println("   -> " + media.getMovie().getFilmTitle());
                hasMovies = true;
            }
        }
        if (!hasMovies)
            System.out.println("   [ No films available to remove ]");

        System.out.println("--------------------------------");
    }

    // Display all games currently in the library
    public void displayGames() {
        System.out.println("--- CURRENT GAMES IN LIBRARY ---");
        boolean hasGames = false;
        for (Media media : entriesList)
        {
            if (media.getType().equalsIgnoreCase("Videogame") && media.getVideogame() != null)
            {
                System.out.println("   -> " + media.getVideogame().getGameTitle());
                hasGames = true;
            }
        }
        if (!hasGames)
            System.out.println("   [ No games available to remove ]");

        System.out.println("--------------------------------");
    }

    // Display all music artists currently in the library
    public void displayArtists()
    {
        System.out.println("--- CURRENT ARTISTS IN LIBRARY ---");
        boolean hasArtists = false;
        for (Media media : entriesList)
        {
            if (media.getType().equalsIgnoreCase("MusicArtist") && media.getMusicArtist() != null) {
                System.out.println("   -> " + media.getMusicArtist().getArtistName());
                hasArtists = true;
            }
        }
        if (!hasArtists)
            System.out.println("   [ No artists available to remove ]");

        System.out.println("--------------------------------");
    }

    public void addEntry(Media media)
    {
        entries.add(media);
    }

    // update on uml
    public boolean removeEntry(Media media)
    {
        if (media != null)
        {
            entries.remove(media);
            return true;
        }
        return false;
    }

    public List<Media> getEntries()
    {
        return entries;
    }

    public Media searchEntry(String title)
    {
        for (Media media : entries)
        {
            if (media.getType().equals("Movie") && media.getMovie().getTitle().equalsIgnoreCase(title))
                return media;
        }
        return null;
    }
}