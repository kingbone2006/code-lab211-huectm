package entity;

public class Person {

    private Wallet wallet;

    public Person() {
        this.wallet = new Wallet();
    }

    public Person(Wallet wallet) {
        setWallet(wallet);
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        if (wallet == null) {
            throw new IllegalArgumentException("Wallet cannot be null");
        }
        this.wallet = wallet;
    }

    public int calcTotal(int[] bills) {
        if (bills == null) {
            throw new IllegalArgumentException("Bills cannot be null");
        }
        int total = 0;
        for (int bill : bills) {
            if (bill < 0) {
                throw new IllegalArgumentException("Bill value must be >= 0");
            }
            total += bill;
        }
        return total;
    }
}
