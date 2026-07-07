import java.time.Year;

public class Movie {
    private String title;
    private String director;
    private int year;
    private String description;

    public Movie(String title, String director, int year, String description)
    {
        this.title = title;
        this.director = director;
        this.year = year;
        this.description = description;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDirector()
    {
        return director;
    }

    public void setDirector(String director)
    {
        this.director = director;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String displayInfo()
    {
        return "Title: " + title +
                "\nDirector: " + director +
                "\nYear: " + String.valueOf(year) +
                "\nDescription: " + description;
    }
}
