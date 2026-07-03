public class Videogame {
    private String title;
    private String developer;
    private int year;
    private String description;
    private int hoursPlayed;

    public Videogame(String title, String developer, int year, String description, int hoursPlayed)
    {
        this.title = title;
        this.developer = developer;
        this.year = year;
        this.description = description;
        this.hoursPlayed = hoursPlayed;
    }
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDeveloper()
    {
        return developer;
    }

    public void setDeveloper(String developer)
    {
        this.developer = developer;
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

    public int getHoursPlayed()
    {
        return hoursPlayed;
    }

    public void setHoursPlayed(int hoursPlayed)
    {
        this.hoursPlayed = hoursPlayed;
    }

    public String displayInfo()
    {
        return "Title: " + title +
                "\nDeveloper: " + developer +
                "\nYear: " + year +
                "\nDescription: " + description +
                "\nHours Played: " + hoursPlayed;
    }
}
