package OOP.Day4;

public class Account {
    protected Integer number;
    protected String owner;
    protected String bankName;
    protected double balance;
    protected String password;
    protected boolean status;
    protected String lastOperation;

    public Account(){}
    public Account(int number, String owner, String bankName){
        this.number = number;
        if(owner.isEmpty()){
            System.out.println("Account holder name cannot be empty!");
            return;
        }
        this.owner = owner;
        if(bankName.isEmpty()){
            System.out.println("Bank name cannot be empty!");
            return;
        }
        this.bankName = bankName;
        this.balance = 0d;
        this.status = true;
        this.password = String.valueOf(number).substring(0,3) + owner;
        lastOperation = "Account was created.";
    }

    public Account(int number, String owner, String bankName, int initialBalance, String password){
        this.number = number;
        if(owner.isEmpty()){
            System.out.println("Account holder name cannot be empty!");
            return;
        }
        this.owner = owner;
        if(bankName.isEmpty()){
            System.out.println("Bank name cannot be empty!");
            return;
        }
        this.bankName = bankName;

        if(password.length() < 8 || password.length() > 16){
            System.out.println("Password must be a combination of English letters, numbers and special symbols of between 8 to 16 characters inclusive.");
            return;
        }
        this.password = password;
        this.balance = initialBalance;
        this.status = true;
        lastOperation = "Account was created.";
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getLastOperation() {
        return lastOperation;
    }

    public void setLastOperation(String lastOperation) {
        this.lastOperation = lastOperation;
    }




}
