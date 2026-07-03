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

    /*public Media searchEntry(String title)
    {
        return Media;
    }*/
}