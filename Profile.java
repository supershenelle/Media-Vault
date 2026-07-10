import java.util.ArrayList;
import java.util.List;

public class Profile {
    private String username;
    private String displayName;
    private String bio;
    private Library library;
    private List<Media> favorites = new ArrayList<>();
    private List<Media> recentActivity = new ArrayList<>();

    public Profile(String username, String displayName, String bio)
    {
        this.username = username;
        this.displayName = displayName;
        this.bio = bio;
        this.library = new Library();
    }

    public String getUsername()
    {
        return username;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getBio()
    {
        return bio;
    }

    public Library getLibrary()
    {
        return library;
    }

    public void addFavorite(Media media)
    {
        favorites.add(media);
    }
}