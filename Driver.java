import java.util.Scanner;

public class Driver {
    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. CREATE PROFILE");
        System.out.println("2. EXIT PROGRAM");
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
                Profile profile = new Profile(username, displayName, bio);
                System.out.println("");
                System.out.println("==========================================");
                System.out.println("             PROFILE CREATED!             ");
                System.out.println("==========================================");
                System.out.println("        USERNAME: " + profile.getUsername());
                System.out.println("------------------------------------------");
                System.out.println("        DISPLAY NAME: " + profile.getDisplayName());
                System.out.println("        BIO: " + profile.getBio());
                System.out.println("==========================================");
                System.out.println("               TOP 3 FILMS                ");
                System.out.println("");
                System.out.println("             TOP 3 VIDEO GAMES            ");
                System.out.println("");
                System.out.println("           FAVORITE MUSIC ARTIST          ");
                System.out.println("TOP ALBUM: ");
                System.out.println("TOP SONGS: ");
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
        } // switch

    } // main
} // driiver