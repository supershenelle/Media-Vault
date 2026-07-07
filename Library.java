import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Media> entries = new ArrayList<>();

    public void addEntry(Media media)
    {
        entries.add(media);
    }

    public void removeEntry(Media media)
    {
        entries.remove(media);
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