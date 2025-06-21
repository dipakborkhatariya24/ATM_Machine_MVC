package model;

public class UserAccount {
    private String userId;
    private String pin;
    private int balance;

    public UserAccount(String userId, String pin, int balance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
    }

    public String getUserId() { return userId; }
    public String getPin() { return pin; }
    public int getBalance() { return balance; }
    public void setBalance(int balance) { this.balance = balance; }
}
