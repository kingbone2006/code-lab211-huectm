package entity;

public class Wallet {

    private int amount;

    public Wallet() {
    }

    public Wallet(int amount) {
        setAmount(amount);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Wallet amount must be >= 0");
        }
        this.amount = amount;
    }

    public boolean payMoney(int total) {
        if (total < 0) {
            throw new IllegalArgumentException("Total must be >= 0");
        }
        return amount >= total;
    }
}
