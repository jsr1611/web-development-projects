package variables.Day3_OOP.Books.Day4_OOP;

public class Account {
    private Double number;
    private String owner;
    private String bankName;
    private Double balance;
    private String password;
    private Boolean status;

    public Account(Double number, String owner, String bankName, Double balance, String password, Boolean status) {
        this.number = number;
        this.owner = owner;
        this.bankName = bankName;
        this.balance = balance;
        this.password = password;
        this.status = status;
    }


}
