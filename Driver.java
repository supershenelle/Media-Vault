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
        System.out.println("TOP SONGS: ");
        Helper.divider1();

        System.out.println("                     YOUR LIBRARY");
        System.out.println("   -->    (A) ADD MEDIA TO LIBRARY");
        System.out.println("   -->    (B) REMOVE MEDIA FROM LIBRARY");
        System.out.println("   -->    (C) SEARCH MEDIA ENTRY IN LIBRARY");
        System.out.println("   -->    (D) EXIT");
        System.out.print("Enter choice: ");
        String libChoice = scanner.nextLine();
        // handle libChoice here or return it
    }

    public static void main(String[] args) {
        System.out.println("1. CREATE PROFILE");
        System.out.println("2. EXIT PROGRAM");
        System.out.println("");
        System.out.print("Enter input: ");
        String input = scanner.nextLine();

        // initialize
        String[] films = {};
        String[] games = {};
        String[] music = {};

        switch(input)
        {
            case "1":
                Driver.displayProfile(scanner, films, games, music);
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
        }
    }
}