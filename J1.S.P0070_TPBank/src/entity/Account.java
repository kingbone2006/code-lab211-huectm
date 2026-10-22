package entity;

import utils.IConstant;

public class Account {

    private String account;
    private String password;

    public Account() {
    }

    public Account(String account, String password) {
        setAccount(account);
        setPassword(password);
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        if (account == null || account.trim().isEmpty()
                || !account.matches(IConstant.ACCOUNT_NUMBER)) {
            throw new IllegalArgumentException(
                    "Account number must be a number and must have 10 digits");
        }
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.trim().isEmpty()
                || !password.matches(IConstant.PASSWORD)) {
            throw new IllegalArgumentException(
                    "Password must be between 8 and 31 characters and must be alphanumeric");
        }
        this.password = password;
    }
}
