public class Helper {

    public static void divider1()
    {
        System.out.println("+======================================================+");
    }

    public static void divider2()
    {
        System.out.println("+------------------------------------------------------+");
    }
    public static void printBoxes(String[] films)
    {
        int width = 12;
        String border = "+" + "-".repeat(width + 4) + "+";

        String t1 = getTitle(films, 0);
        String t2 = getTitle(films, 1);
        String t3 = getTitle(films, 2);

        String[] b1 = formatTitle(t1, width);
        String[] b2 = formatTitle(t2, width);
        String[] b3 = formatTitle(t3, width);

        System.out.println(border + " " + border + " " + border);
        System.out.println("|  " + b1[0] + "  | |  " + b2[0] + "  | |  " + b3[0] + "  |");
        System.out.println("|  " + b1[1] + "  | |  " + b2[1] + "  | |  " + b3[1] + "  |");
        System.out.println("|  " + b1[2] + "  | |  " + b2[2] + "  | |  " + b3[2] + "  |");
        System.out.println(border + " " + border + " " + border);
        System.out.println("");
    }

    // Safely reads the array element; returns a blank string if index is missing or null
    private static String getTitle(String[] arr, int index)
    {
        if (arr == null || index >= arr.length || arr[index] == null) {
            return "";
        }
        return arr[index];
    }

    private static String[] formatTitle(String text, int w)
    {
        String[] lines = new String[3];
        lines[0] = "";
        lines[1] = "";
        lines[2] = "";

        // if text is empty, don't split it, just leave words empty
        String[] words;
        if (text.trim().equals(""))
            words = new String[0];
        else
            words = text.split(" ");

        for (int i = 0; i < 3; i++) {
            if (i < words.length)
            {
                String word = words[i];

                // last line, and there are more words we didn't show
                if (i == 2 && words.length > 3)
                {
                    if (word.length() > w - 3)
                        word = word.substring(0, w - 3);

                    lines[i] = word + "...";

                }

                else
                {
                    if (word.length() > w)
                        word = word.substring(0, w);

                    lines[i] = word;
                }
            }

            // pad the line with spaces until it reaches width w
            while (lines[i].length() < w)
            {
                lines[i] = lines[i] + " ";
            }
        }

        return lines;
    }
}
