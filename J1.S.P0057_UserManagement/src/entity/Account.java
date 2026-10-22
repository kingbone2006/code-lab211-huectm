package entity;

public class Account {

    private String username;
    private String password;

    public Account() {
    }

    public Account(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username == null || username.length() < 5 || username.contains(" ")) {
            throw new IllegalArgumentException(
                    "You must enter least at 5 character, and no space!");
        }
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.length() < 6 || password.contains(" ")) {
            throw new IllegalArgumentException(
                    "You must enter least at 6 character, and no space!");
        }
        this.password = password;
    }
}
