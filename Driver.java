import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Driver {

    private static Scanner scanner = new Scanner(System.in);

    //display profile function
    public static void displayProfile(Scanner scanner, Profile profile, String[] films, String[] games, String[] music)
    {
        System.out.println("");
        Interface.divider1();
        Interface.printCentered("=== Y O U R   P R O F I L E ===");
        Interface.divider1();
        Interface.printCentered("USERNAME: @" + profile.getUsername());
        Interface.divider2();
        Interface.printCentered("DISPLAY NAME: " + profile.getDisplayName());
        Interface.printCentered("BIO: " + profile.getBio());
        Interface.divider1();
        System.out.println("");

        Interface.printCentered("MOST RECENT FILM ACTIVITY");
        Interface.printBoxes(films);

        Interface.printCentered("MOST RECENT VIDEO GAME ACTIVITY");
        Interface.printBoxes(games);

        Interface.printCentered("MOST RECENT ARTIST DISCOGRAPHY ACTIVITY");
        System.out.println("TOP ALBUM: ");
        System.out.println("TOP SONGS: \n");

        Interface.divider1();
    }

    // display library para di paulit ulit sa switch
    public static String libraryMenu(Scanner scanner)
    {
        Interface.printCentered("YOUR LIBRARY");
        System.out.println("                -->    (A) ADD MEDIA TO LIBRARY");
        System.out.println("                -->    (B) REMOVE MEDIA FROM LIBRARY");
        System.out.println("                -->    (C) DISPLAY/FILTER ENTRIES FROM LIBRARY");
        System.out.println("                -->    (D) RATE AND REVIEW COMPLETED ENTRIES");
        System.out.println("                -->    (E) EXIT");
        System.out.print("Enter choice: ");
        String libChoice = scanner.nextLine();
        while(!libChoice.equalsIgnoreCase("A") && !libChoice.equalsIgnoreCase("B") && !libChoice.equalsIgnoreCase("C") && !libChoice.equalsIgnoreCase("D") && !libChoice.equalsIgnoreCase("E"))
        {
            System.out.println("Please enter valid choice.");
            System.out.print("Enter choice: ");
            libChoice = scanner.nextLine();
        }
        System.out.println("");
        return libChoice.toUpperCase();
    }

    public static Status getInputStatus(Scanner scanner)
    {
        System.out.println("   -->    STATUS:\n      -- (1) Planning\n      -- (2) In Progress\n      -- (3) Finished");
        System.out.print("Enter status choice: ");
        String choice = scanner.nextLine();
        while(!choice.equals("1") && !choice.equals("2") && !choice.equals("3"))
        {
            System.out.println("Please enter valid choice.");
            System.out.print("Enter status choice: ");
            choice = scanner.nextLine();
        }
        return Status.fromChoice(choice);

    }

    public static String mediaTypeFromChoice(String choice)
    {
        switch(choice)
        {
            case "1":
                return "Movie";
            case "2":
                return "Videogame";
            case "3":
                return "Music Artist";
        }
        return null;
    }

    public static void displayFilteredResults(ArrayList<Media> results)
    {
        Interface.divider1();
        Interface.printCentered("=== RESULTS (" + results.size() + " FOUND) ===");
        Interface.divider2();

        if (results.isEmpty())
        {
            Interface.printCentered("[ No matching entries found ]");
        }
        else
        {
            for (Media media : results)
            {
                System.out.println(media.displayInfo());
                Interface.divider2();
            }
        }
        Interface.divider1();
        System.out.println("");
    }

    public static void main(String[] args) {
        boolean running = true;

        while (running)
        {
            Interface.displayTitle();
            Interface.printCentered("=== MAIN NAVIGATION: CHOOSE OPTION ===");
            Interface.printCentered("(1) CREATE PROFILE      (2) EXIT PROGRAM");
            System.out.println("");
            System.out.print("Enter input: ");
            String input = scanner.nextLine();

            switch(input)
            {
                case "1":
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter display name: ");
                    String displayName = scanner.nextLine();
                    System.out.print("Enter bio: ");
                    String bio = scanner.nextLine();

                    // set up everything for new profile
                    Profile profile = new Profile(username, displayName, bio);
                    Library library = new Library();
                    String[] films = library.getRecentTitles("Movie");
                    String[] games = library.getRecentTitles("Videogame");
                    String[] music = library.getRecentTitles("Music Artist");

                    Driver.displayProfile(scanner, profile, films, games, music);
                    boolean exitLibrary = false;

                    while (!exitLibrary)
                    {
                        String libChoice = Driver.libraryMenu(scanner);
                        switch(libChoice)
                        {
                            // add entry
                            case "A":
                                Interface.divider2();
                                Interface.printCentered("ENTER MEDIA TYPE");
                                Interface.printCentered("(1) FILMS           (2) GAMES              (3) DISCOGRAPHY");
                                System.out.print("Enter choice: ");
                                String mediaChoice = scanner.nextLine();
                                while(!mediaChoice.equals("1") && !mediaChoice.equals("2") && !mediaChoice.equals("3"))
                                {
                                    System.out.println("Please enter valid choice.");
                                    System.out.print("Enter choice: ");
                                    mediaChoice = scanner.nextLine();
                                }
                                System.out.println("");

                                switch(mediaChoice)
                                {
                                    case "1":
                                        System.out.println("");
                                        Interface.divider1();
                                        Interface.printCentered("=== ADDING FILM ENTRY ===");
                                        Interface.divider2();

                                        System.out.print("   -->    FILM TITLE: ");
                                        String filmTitle = scanner.nextLine();
                                        System.out.print("   -->    DIRECTOR: ");
                                        String director = scanner.nextLine();
                                        System.out.print("   -->    YEAR RELEASED: ");
                                        int filmYear = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.print("   -->    DESCRIPTION: ");
                                        String filmDescription = scanner.nextLine();
                                        Status statusFilm = Driver.getInputStatus(scanner);
                                        Movie movie = new Movie(filmTitle, director, filmYear, filmDescription);
                                        Media movieEntry = new Media(movie, statusFilm);
                                        library.addEntry(movieEntry);
                                        Interface.divider2();
                                        Interface.printCentered("=== FILM SUCCESFULLY ADDED! ===");
                                        Interface.divider1();
                                        System.out.println("");
                                        break;

                                    case "2":
                                        System.out.println("");
                                        Interface.divider1();
                                        Interface.printCentered("=== ADDING GAME ENTRY ===");
                                        Interface.divider2();

                                        System.out.print("   -->    GAME TITLE: ");
                                        String gameTitle = scanner.nextLine();
                                        System.out.print("   -->    DEVELOPER: ");
                                        String developer = scanner.nextLine();
                                        System.out.print("   -->    YEAR RELEASED: ");
                                        int gameYear = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.print("   -->    DESCRIPTION: ");
                                        String gameDescription = scanner.nextLine();
                                        System.out.print("   -->    HOURS PLAYED: ");
                                        int hoursPlayed = scanner.nextInt();
                                        scanner.nextLine();
                                        Status statusGame = Driver.getInputStatus(scanner);

                                        Videogame game = new Videogame(gameTitle, developer, gameYear, gameDescription, hoursPlayed);
                                        Media gameEntry = new Media(game, statusGame);
                                        library.addEntry(gameEntry);
                                        Interface.divider2();
                                        Interface.printCentered("=== GAME SUCCESFULLY ADDED! ===");
                                        Interface.divider1();
                                        System.out.println("");
                                        break;

                                    case "3":
                                        System.out.println("");
                                        Interface.divider1();
                                        Interface.printCentered("=== ADDING MUSIC ARTIST ENTRY ===");
                                        Interface.divider2();

                                        System.out.print("   -->    ARTIST NAME: ");
                                        String artistName = scanner.nextLine();
                                        System.out.print("   -->    DESCRIPTION: ");
                                        String artistDescription = scanner.nextLine();
                                        MusicArtist musicArtist = new MusicArtist(artistName, artistDescription);

                                        System.out.print("   -->    HOW MANY ALBUMS DOES THIS ARTIST HAVE: ");
                                        int albumCount = scanner.nextInt();
                                        scanner.nextLine();
                                        // create the albums (SHEN KAW NA BAHALA SA INTERFACE NETO)
                                        for(int i = 1; i <= albumCount; i++)
                                        {
                                            System.out.println("--- Input Album " + i + " --------------");

                                            System.out.print("   -->    Title: ");
                                            String title = scanner.nextLine();

                                            System.out.print("   -->    Genre: ");
                                            String genre = scanner.nextLine();

                                            System.out.print("   -->    Year: ");
                                            int year = scanner.nextInt();

                                            System.out.print("   -->    Number of tracks: ");
                                            int tracks = scanner.nextInt();
                                            scanner.nextLine();

                                            Album album = new Album(title, genre, year, tracks);

                                            musicArtist.addAlbum(album);
                                        }

                                        Status statusArtist = Driver.getInputStatus(scanner);
                                        Media artistEntry = new Media(musicArtist, statusArtist);
                                        library.addEntry(artistEntry);
                                        Interface.divider2();
                                        Interface.printCentered("=== MUSIC SUCCESFULLY ADDED! ===");
                                        Interface.divider1();
                                        System.out.println("");
                                        break;
                                } // switch mediaChoice
                                films = library.getRecentTitles("Movie");
                                games = library.getRecentTitles("Videogame");
                                music = library.getRecentTitles("Music Artist");
                                Driver.displayProfile(scanner, profile, films, games, music);
                                break;

                            // remove entry
                            case "B" :
                                Interface.divider2();
                                Interface.printCentered("REMOVE MEDIA TYPE");
                                Interface.printCentered("(1) FILMS           (2) GAMES              (3) DISCOGRAPHY");
                                System.out.print("Enter choice: ");
                                String removeChoice = scanner.nextLine();
                                while(!removeChoice.equals("1") && !removeChoice.equals("2") && !removeChoice.equals("3"))
                                {
                                    System.out.println("Please enter valid choice.");
                                    System.out.print("Enter choice: ");
                                    removeChoice = scanner.nextLine();
                                }
                                System.out.println("");

                                String removeType = Driver.mediaTypeFromChoice(removeChoice);
                                // cuz string is immutable, magagalaw remove type variable so we make anotha variable for displaying
                                String removeLabel;

                                if (removeType.equals("Movie"))
                                    removeLabel = "FILM";

                                else if (removeType.equals("Videogame"))
                                    removeLabel = "GAME";

                                else
                                    removeLabel = "MUSIC ARTIST";


                                System.out.println("");
                                Interface.divider1();
                                Interface.printCentered("=== REMOVING " + removeLabel + " ENTRY ===");
                                Interface.divider2();

                                if (removeType.equals("Movie"))
                                    library.displayMovies();
                                else if (removeType.equals("Videogame"))
                                    library.displayGames();
                                else
                                    library.displayArtists();
                                System.out.println("");

                                System.out.print("   -->    Enter " + removeLabel + " title to remove: ");
                                String removeTitle = scanner.nextLine();

                                Media entryToRemove = library.findEntry(removeType, removeTitle);
                                boolean isRemoved = library.removeEntry(entryToRemove);

                                Interface.divider2();
                                if (isRemoved) {
                                    Interface.printCentered("=== ENTRY SUCCESSFULLY REMOVED! ===");
                                } else {
                                    Interface.printCentered("!!! REMOVE FAILED: ENTRY NOT FOUND IN THIS CATEGORY !!!");
                                }
                                Interface.divider1();
                                System.out.println("");
                                films = library.getRecentTitles("Movie");
                                games = library.getRecentTitles("Videogame");
                                music = library.getRecentTitles("Music Artist");
                                Driver.displayProfile(scanner, profile, films, games, music);
                                break;

                            case "C" :
                                Interface.divider2();
                                Interface.printCentered("=== DISPLAYING ALL ENTRIES FROM LIBRARY ===\n");
                                library.displayMovies();
                                library.displayGames();
                                library.displayArtists();

                                //filter entry
                                Interface.divider2();
                                Interface.printCentered("FILTER MEDIA ENTRIES BY");
                                Interface.printCentered("(1) STATUS           (2) MEDIA TYPE");
                                System.out.print("Enter choice: ");
                                String filterChoice = scanner.nextLine();
                                while(!filterChoice.equals("1") && !filterChoice.equals("2"))
                                {
                                    System.out.println("Please enter valid choice.");
                                    System.out.print("Enter choice: ");
                                    filterChoice = scanner.nextLine();
                                }
                                System.out.println("");

                                ArrayList<Media> filteredResults;
                                if (filterChoice.equals("1"))
                                {
                                    Status filterStatus = Driver.getInputStatus(scanner);
                                    filteredResults = library.filterByStatus(filterStatus);
                                }

                                else
                                {
                                    Interface.printCentered("(1) FILMS           (2) GAMES              (3) DISCOGRAPHY");
                                    System.out.print("Enter choice: ");
                                    String filterTypeChoice = scanner.nextLine();
                                    while(!filterTypeChoice.equals("1") && !filterTypeChoice.equals("2") && !filterTypeChoice.equals("3"))
                                    {
                                        System.out.println("Please enter valid choice.");
                                        System.out.print("Enter choice: ");
                                        filterTypeChoice = scanner.nextLine();
                                    }
                                    String filterType = Driver.mediaTypeFromChoice(filterTypeChoice);
                                    filteredResults = library.filterByType(filterType);
                                }

                                Driver.displayFilteredResults(filteredResults);
                                break;

                            // rate review completed entries
                            case "D" :
                                Interface.divider2();
                                Interface.printCentered("=== RATE/REVIEW FROM COMPLETED LIBRARY ENTRIES ===");
                                ArrayList<Media> completedEntries = library.filterByStatus(Status.COMPLETED);
                                Driver.displayFilteredResults(completedEntries);

                                if(!completedEntries.isEmpty())
                                {
                                    System.out.print("   -->    Enter title of entry to rate/review: ");
                                    String rateTitle = scanner.nextLine();

                                    Media rateEntry = null;
                                    for (Media media : completedEntries)
                                    {
                                        if (media.getTitle().equalsIgnoreCase(rateTitle))
                                            rateEntry = media;
                                    }

                                    // not found
                                    while (rateEntry == null)
                                    {
                                        System.out.println("ERROR: Entry not found among completed entries list.");
                                        System.out.print("   -->    Enter title of entry to rate/review: ");
                                        rateTitle = scanner.nextLine();

                                        for (Media media : completedEntries)
                                        {
                                            if (media.getTitle().equalsIgnoreCase(rateTitle))
                                                rateEntry = media;
                                        }
                                    }

                                    System.out.println("");
                                    Interface.printCentered("MEDIA SUCCESFULLY FOUND");
                                    Interface.divider2();
                                    System.out.print("   -->    Enter rating (1-5): ");
                                    int rating = scanner.nextInt();
                                    scanner.nextLine();
                                    while (!rateEntry.setRating(rating))
                                    {
                                        System.out.print("   -->    Enter rating (1-5): ");
                                        rating = scanner.nextInt();
                                        scanner.nextLine();
                                    }

                                    System.out.print("   -->    Enter review: ");
                                    String review = scanner.nextLine();
                                    rateEntry.setReview(review);

                                    Interface.divider2();
                                    Interface.printCentered("=== RATING/REVIEW UPDATED! ===");
                                    Driver.displayFilteredResults(completedEntries);
                                }
                                break;


                            case "E" :
                                exitLibrary = true;
                                break;
                        } // switch libchoice
                    } // while
                    break;

                case "2":
                    System.exit(0);

                default:
                    while (!input.equals("1") && !input.equals("2"))
                    {
                        System.out.println("Please enter valid input.");
                        System.out.print("Enter input: ");
                        input = scanner.nextLine();
                    }
            } // switch input
        }// while running

        } // void
}