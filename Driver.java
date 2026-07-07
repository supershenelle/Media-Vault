import java.util.Scanner;

public class Driver {

    private static Scanner scanner = new Scanner(System.in);

    public static void displayProfile(Scanner scanner, String[] films, String[] games, String[] music)
    {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter display name: ");
        String displayName = scanner.nextLine();
        System.out.print("Enter bio: ");
        String bio = scanner.nextLine();
        Profile profile = new Profile(username, displayName, bio);

        System.out.println("");
        Helper.divider1();
        System.out.println("                   PROFILE CREATED!");
        Helper.divider1();
        System.out.println("   -->    USERNAME: " + profile.getUsername());
        Helper.divider2();
        System.out.println("   -->    DISPLAY NAME: " + profile.getDisplayName());
        System.out.println("   -->    BIO: " + profile.getBio());
        Helper.divider1();

        System.out.println("                      TOP 3 FILMS");
        Helper.printBoxes(films);

        System.out.println("                   TOP 3 VIDEO GAMES");
        Helper.printBoxes(games);

        System.out.println("                 FAVORITE MUSIC ARTIST");
        System.out.println("TOP ALBUM: ");
        System.out.println("TOP SONGS: \n");

        Helper.divider1();
    }

    public static String libraryMenu(Scanner scanner)
    {
        System.out.println("                     YOUR LIBRARY");
        System.out.println("   -->    (A) ADD MEDIA TO LIBRARY");
        System.out.println("   -->    (B) REMOVE MEDIA FROM LIBRARY");
        System.out.println("   -->    (C) SEARCH MEDIA ENTRY IN LIBRARY");
        System.out.println("   -->    (D) EXIT");
        System.out.print("Enter choice: ");
        String libChoice = scanner.nextLine();
        while(!libChoice.equalsIgnoreCase("A") && !libChoice.equalsIgnoreCase("B") && !libChoice.equalsIgnoreCase("C") && !libChoice.equalsIgnoreCase("D"))
        {
            System.out.println("Please enter valid choice.");
            System.out.print("Enter choice: ");
            libChoice = scanner.nextLine();
        }
        System.out.println("");
        return libChoice.toUpperCase();
    }

    public static String getFilmStatus(String status)
    {
        if (status.equals("1"))
            return "Currently Watching";
        else if (status.equals("2"))
            return "In Watchlist";
        else
            return "Finished";
    }

    public static String getGameStatus(String status)
    {
        if (status.equals("1"))
            return "Currently Playing";
        else if (status.equals("2"))
            return "Want to Play";
        else
            return "Completed";
    }

    public static void main(String[] args) {
        System.out.println("1. CREATE PROFILE");
        System.out.println("2. EXIT PROGRAM");
        System.out.println("");
        System.out.print("Enter input: ");
        String input = scanner.nextLine();
        Library library = new Library();

        // initialize
        String[] films = {};
        String[] games = {};
        String[] music = {};

        switch(input)
        {
            case "1":
                Driver.displayProfile(scanner, films, games, music);
                boolean exitLibrary = false;

                while (!exitLibrary)
                {
                    String libChoice = Driver.libraryMenu(scanner);
                    switch(libChoice)
                    {
                        case "A":
                            Helper.divider2();
                            System.out.println("                   ENTER MEDIA TYPE");
                            System.out.println("   -->    (1) FILMS (2) GAMES (3) DISCOGRAPHY");
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
                                    Helper.divider1();
                                    System.out.println("                  ADDING FILM ENTRY...");
                                    Helper.divider2();

                                    System.out.print("   -->    FILM TITLE: ");
                                    String filmTitle = scanner.nextLine();
                                    System.out.print("   -->    DIRECTOR: ");
                                    String director = scanner.nextLine();
                                    System.out.print("   -->    YEAR RELEASED: ");
                                    int filmYear = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.print("   -->    DESCRIPTION: ");
                                    String filmDescription = scanner.nextLine();
                                    System.out.println("   -->    STATUS:\n -- (1) Currently Watching\n -- (2) In Watchlist\n -- (3) Finished");
                                    System.out.print("Enter status choice: ");
                                    String statusFilm = scanner.nextLine();
                                    while(!statusFilm.equals("1") && !statusFilm.equals("2") && !statusFilm.equals("3"))
                                    {
                                        System.out.println("Please enter valid choice.");
                                        System.out.print("Enter status choice: ");
                                        statusFilm = scanner.nextLine();
                                    }

                                    Movie movie = new Movie(filmTitle, director, filmYear, filmDescription);
                                    Media movieEntry = new Media(movie, Driver.getFilmStatus(statusFilm));
                                    library.addEntry(movieEntry);
                                    Helper.divider2();
                                    System.out.println("                FILM SUCCESFULLY ADDED!");
                                    Helper.divider1();
                                    System.out.println("");
                                    break;

                                case "2":
                                    System.out.println("");
                                    Helper.divider1();
                                    System.out.println("                  ADDING GAME ENTRY...");
                                    Helper.divider2();

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
                                    System.out.println("   -->    STATUS:\n -- (1) Currently Playing\n -- (2) Want to Play\n -- (3) Completed");
                                    System.out.print("Enter status choice: ");
                                    String statusGame = scanner.nextLine();
                                    while(!statusGame.equals("1") && !statusGame.equals("2") && !statusGame.equals("3"))
                                    {
                                        System.out.println("Please enter valid choice.");
                                        System.out.print("Enter status choice: ");
                                        statusGame = scanner.nextLine();
                                    }

                                    Videogame game = new Videogame(gameTitle, developer, gameYear, gameDescription, hoursPlayed);
                                    Media gameEntry = new Media(game, Driver.getGameStatus(statusGame));
                                    library.addEntry(gameEntry);
                                    Helper.divider2();
                                    System.out.println("                GAME SUCCESFULLY ADDED!");
                                    Helper.divider1();
                                    System.out.println("");
                                    break;
                            } // switch media choice
                            break;
                        case "B" :
                            //remove entry
                            break;

                        case "C" :
                            //search entry
                            break;

                        case "D" :
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
        } // void
}