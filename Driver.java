import java.util.Scanner;

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

        Interface.printCentered("TOP 3 FILMS");
        Interface.printBoxes(films);

        Interface.printCentered("TOP 3 VIDEO GAMES");
        Interface.printBoxes(games);

        Interface.printCentered("FAVORITE MUSIC ARTIST");
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
        System.out.println("                -->    (C) SEARCH MEDIA ENTRY IN LIBRARY");
        System.out.println("                -->    (D) EXIT");
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
            Library library = new Library();

            // initialize
            String[] films = {};
            String[] games = {};
            String[] music = {};

            switch(input)
            {
                case "1":
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter display name: ");
                    String displayName = scanner.nextLine();
                    System.out.print("Enter bio: ");
                    String bio = scanner.nextLine();
                    Profile profile = new Profile(username, displayName, bio);
                    Driver.displayProfile(scanner, profile, films, games, music);
                    boolean exitLibrary = false;

                    while (!exitLibrary)
                    {
                        String libChoice = Driver.libraryMenu(scanner);
                        switch(libChoice)
                        {
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
                                } // switch media choice
                                Driver.displayProfile(scanner, profile, films, games, music);
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
        }// while running

        } // void
}