package variables.Day2_OOP;

public class Pen {

    private boolean mode;     // true - tugma bosilgan bo'ladi, false - tugama bosilmagan bo'ladi
    private double inkAmount;   // siyoh miqdori
    private double inkSpent;    // 1ta harf uchun sarflanadigan siyoh miqdori
    private String inkColor;    // siyoh rangi

    // default
    public Pen() {
    }

    public Pen(boolean mode, double inkAmount, double inkSpent) {
        this.mode = mode;
        this.inkAmount = inkAmount;
        this.inkSpent = inkSpent;
    }

    public Pen(boolean mode, double inkAmount, double inkSpent, String inkColor) {
        this.mode = mode;
        this.inkAmount = inkAmount;
        this.inkSpent = inkSpent;
        this.inkColor = inkColor;
    }

    public void pushButton() {
        this.mode = !mode;
    }

    public void write(String sentence) {
        if (mode) {
            if (inkAmount > 0) {
                //System.out.println(sentence);
                for(int i=0; i < sentence.length(); i++){
                    if(!Character.isWhitespace(sentence.charAt(i))){
                        if(Character.isUpperCase(sentence.charAt(i))){
                            if(inkAmount < inkSpent * 2){
                                System.out.println("\nRuchkada siyoh qolmadi. Iltimos, ruchka siyohini qayta to'ldiring!");
                                break;
                            }
                            inkAmount -= inkSpent * 2;
                        }
                        else {
                            if(inkAmount < inkSpent){
                                System.out.println("\nRuchkada siyoh qolmadi. Iltimos, ruchka siyohini qayta to'ldiring!");
                                break;
                            }
                            inkAmount -= inkSpent;
                        }
                    }
                    System.out.print(sentence.charAt(i));
                }
                //inkAmount -= sentence.length() * inkSpent; // yozilgan harflar uchun siyohning sarflanishi
            } else {
                System.out.println("Ruchkada siyoh qolmagan, iltimos siyohni almashtiring!");
            }
        } else {
            System.out.println("Yozishdan oldin tugmani bosing!");
        }
    }

    public void refill(double inkAmount) {
        if(inkAmount > 0) {
            this.inkAmount = inkAmount;
        } else {
            System.out.println("0 dan katta son kiriting");
        }
    }

    public double getInkAmount() {
        return inkAmount;
    }
}