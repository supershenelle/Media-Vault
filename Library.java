import java.util.ArrayList;
import java.util.List;

public class Library {
    private ArrayList<Media> entries = new ArrayList<>();

    public void displayMovies()
    {
        System.out.println("--- CURRENT FILMS IN LIBRARY ---");
        boolean hasMovies = false;
        for (Media media : entries)
        {
            if (media.getType().equalsIgnoreCase("Movie") && media.getMovie() != null)
            {
                System.out.println("   -> " + media.getMovie().getTitle());
                hasMovies = true;
            }
        }
        if (!hasMovies)
            System.out.println("   [ No films logged ]");

        System.out.println("--------------------------------");
    }

    // Display all games currently in the library
    public void displayGames() {
        System.out.println("--- CURRENT GAMES IN LIBRARY ---");
        boolean hasGames = false;
        for (Media media : entries)
        {
            if (media.getType().equalsIgnoreCase("Videogame") && media.getVideogame() != null)
            {
                System.out.println("   -> " + media.getVideogame().getTitle());
                hasGames = true;
            }
        }
        if (!hasGames)
            System.out.println("   [ No games logged ]");

        System.out.println("--------------------------------");
    }

    // Display all music artists currently in the library
    public void displayArtists()
    {
        System.out.println("--- CURRENT ARTISTS IN LIBRARY ---");
        boolean hasArtists = false;
        for (Media media : entries)
        {
            if (media.getType().equalsIgnoreCase("Music Artist") && media.getMusicArtist() != null) {
                System.out.println("   -> " + media.getMusicArtist().getName());
                hasArtists = true;
            }
        }
        if (!hasArtists)
            System.out.println("   [ No artist activity logged ]");

        System.out.println("--------------------------------");
    }

    // para sa recent activity
    public String[] getRecentTitles(String type)
    {
        // arraylist since pwede na wala munang naka-log or pwedeng isa lang rin etc etc.
        List<String> titles = new ArrayList<>();

        // pabackward tas top 3 lang
        for (int i = entries.size() - 1; i >= 0 && titles.size() < 3; i--)
        {
            // get ung media na pinaka recent
            Media media = entries.get(i);

            if (media.getType().equals(type))
            {
                if (type.equals("Movie"))
                    titles.add(media.getTitle());

                else if (type.equals("Videogame"))
                    titles.add(media.getTitle());

                else if (type.equals("Music Artist"))
                    titles.add(media.getTitle());
            }
        }

        return titles.toArray(new String[0]);
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

    public ArrayList<Media> getEntries()
    {
        return entries;
    }


    public Media findEntry(String type, String title)
    {
        for (Media media : entries)
        {
            if (media.getType().equalsIgnoreCase(type) && media.getTitle().equalsIgnoreCase(title))
                return media;
        }
        return null;
    }

    public ArrayList<Media> filterByStatus(Status status)
    {
        ArrayList<Media> filtered = new ArrayList<>();
        for (Media media : entries)
        {
            if (media.getStatus() == status)
                filtered.add(media);
        }
        return filtered;
    }

    public ArrayList<Media> filterByType(String type)
    {
        ArrayList<Media> filtered = new ArrayList<>();
        for (Media media : entries)
        {
            if (media.getType().equalsIgnoreCase(type))
                filtered.add(media);
        }
        return filtered;
    }
}