public enum Status {
    PLANNED("Planned"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed");

    private final String display;

    Status(String display)
    {
        this.display = display;
    }

    public String getDisplay()
    {
        return display;
    }

    public static Status fromChoice(String choice)
    {
        switch(choice)
        {
            case "1":
                return PLANNED;
            case "2":
                return IN_PROGRESS;
            case "3":
                return COMPLETED;
        }
    }
}
