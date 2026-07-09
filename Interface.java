public class Interface {

    public static void displayTitle()
    {
        System.out.println("\n\n");
        System.out.println("+====================================================================================+");
        System.out.println("  ███╗   ███╗███████╗██████╗ ██╗ █████╗    ██╗   ██╗ █████╗ ██╗   ██╗██╗  ████████╗");
        System.out.println("  ████╗ ████║██╔════╝██╔══██╗██║██╔══██╗   ██║   ██║██╔══██╗██║   ██║██║  ╚══██╔══╝");
        System.out.println("  ██╔████╔██║█████╗  ██║  ██║██║███████║   ██║   ██║███████║██║   ██║██║     ██║   ");
        System.out.println("  ██║╚██╔╝██║██╔══╝  ██║  ██║██║██╔══██║   ╚██╗ ██╔╝██╔══██║██║   ██║██║     ██║   ");
        System.out.println("  ██║ ╚═╝ ██║███████╗██████╔╝██║██║  ██║    ╚████╔╝ ██║  ██║╚██████╔╝███████╗██║   ");
        System.out.println("  ╚═╝     ╚═╝╚══════╝╚═════╝ ╚═╝╚═╝  ╚═╝     ╚═══╝  ╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝   ");
        System.out.println("+====================================================================================+\n");
    }
    public static void divider1()
    {
        System.out.println("+====================================================================================+");
    }

    public static void divider2()
    {
        System.out.println("+------------------------------------------------------------------------------------+");
    }

    public static void printCentered(String text)
    {
        int totalPad = 86 - text.length();
        int padLeft = totalPad / 2;
        int padRight = totalPad - padLeft;

        System.out.println(" ".repeat(Math.max(padLeft, 0)) + text + " ".repeat(Math.max(padRight, 0)));
    }
    public static void printBoxes(String[] films)
    {
        int width = 20;
        String border = "+" + "-".repeat(width + 4) + "+";

        String t1 = getTitle(films, 0);
        String t2 = getTitle(films, 1);
        String t3 = getTitle(films, 2);

        // if ever mag exceed yung title sa box
        if (t1.length() > width) t1 = t1.substring(0, width - 3) + "...";
        if (t2.length() > width) t2 = t2.substring(0, width - 3) + "...";
        if (t3.length() > width) t3 = t3.substring(0, width - 3) + "...";

        // para dun sa empty space heh
        String blank = " ".repeat(width);

        System.out.println(" " + border + "   " + border + "   " + border);
        System.out.println(" |  " + blank + "  |   |  " + blank + "  |   |  " + blank + "  |");
        System.out.printf(" |  %-" + width + "s  |   |  %-" + width + "s  |   |  %-" + width + "s  |%n", t1, t2, t3);
        System.out.println(" |  " + blank + "  |   |  " + blank + "  |   |  " + blank + "  |");
        System.out.println(" " + border + "   " + border + "   " + border);
        System.out.println("");
    }

    // if ever wala pa favorites so maging null muna sya
    private static String getTitle(String[] filmTitle, int index)
    {
        if (index >= filmTitle.length || filmTitle[index] == null) {
            return "";
        }
        return filmTitle[index];
    }
}
