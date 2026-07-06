import java.util.ArrayList;
import java.util.List;

public class MusicArtist {
    private String name;
    private ArrayList<String> genres;
    private ArrayList<Album> albums;
    private String description;

    public MusicArtist(String name, String description)
    {
        this.name = name;
        this.description = description;
        genres = new ArrayList<>();
        albums = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public ArrayList<String> getGenres()
    {
        return genres;
    }

    public void addGenre(String genre)
    {
        genres.add(genre);
    }

    public void removeGenre(String genre)
    {
        genres.remove(genre);
    }

    public ArrayList<Album> getAlbums()
    {
        return albums;
    }

    public void addAlbum(Album album)
    {
        albums.add(album);
    }

    public void removeAlbum(Album album)
    {
        albums.remove(album);
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public boolean isCompleted()
    {
        // if no albums, then false
        if(albums.isEmpty())
            return false;

        // if all albums not complete, then false
        for(Album album : albums)
        {
            if(!album.isCompleted())
                return false;
        }

        return true;
    }

    public String getProgress()
    {
        int completed = 0;

        for(Album album : albums)
        {
            if(album.isCompleted())
                completed++;
        }

        return completed + "/" + albums.size();
    }
    
    public String displayInfo()
    {

        String info = "";

        info += "Artist: " + name + "\n";
        info += "Genres: " + genres + "\n";
        info += "Description: " + description + "\n";
        info += "Albums:\n";

        for (Album album : albums) {
            info += "- " + album.getTitle() + "\n";
        }

        return info;
    }
}
