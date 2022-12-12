package Labs.L06DefiningClasses.BankAccount_3;

public class BankAccount {
    private int id;
    private double balance;
    private static double interestRate = 0.02;
    private static int counter = 0;

    public BankAccount() {
        counter++;
        this.id = counter;
        this.balance = 0;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        BankAccount.counter = counter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;

    }

    public double getInterest(int years) {
        return interestRate * this.balance * years;
    }

    public void deposit(double money) {
        this.balance += money;
    }


}
