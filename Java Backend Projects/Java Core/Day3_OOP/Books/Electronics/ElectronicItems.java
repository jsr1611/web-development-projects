package variables.Day3_OOP.Books.Electronics;

public class ElectronicItems {
    protected String name;
    protected int year;
    protected boolean hasSound;

    public ElectronicItems(String name, int year, boolean hasSound) {
        this.name = name;
        this.year = year;
        this.hasSound = hasSound;
    }
}
