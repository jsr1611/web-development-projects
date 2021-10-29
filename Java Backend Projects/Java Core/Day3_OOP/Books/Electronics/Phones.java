package variables.Day3_OOP.Books.Electronics;

public class Phones extends ElectronicItems{
    private boolean canCall;

    public Phones(String name, int year, boolean hasSound, boolean canCall) {
        super(name, year, hasSound);
        this.canCall = canCall;
    }
}
