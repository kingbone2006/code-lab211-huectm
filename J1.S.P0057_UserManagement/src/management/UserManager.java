package management;

import entity.Account;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private final String fileName;
    private final List<Account> accounts = new ArrayList<>();

    public UserManager(String fileName) {
        this.fileName = fileName;
        load();
    }

    private void load() {
        File file = new File(fileName);
        if (!file.exists()) {
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    try {
                        accounts.add(new Account(parts[0], parts[1]));
                    } catch (IllegalArgumentException ignored) {
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Cannot load file: " + e.getMessage());
        }
    }

    public void addAccount(Account acc) throws Exception {
        if (acc == null) {
            throw new Exception("Account cannot be null");
        }
        for (Account a : accounts) {
            if (a.getUsername().equalsIgnoreCase(acc.getUsername())) {
                throw new Exception("Username already exists!");
            }
        }
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(acc.getUsername() + "|" + acc.getPassword());
            bw.newLine();
        }
        accounts.add(acc);
    }

    public Account find(Account acc) throws Exception {
        if (acc == null) {
            throw new Exception("Account cannot be null");
        }
        for (Account a : accounts) {
            if (a.getUsername().equals(acc.getUsername())
                    && a.getPassword().equals(acc.getPassword())) {
                return a;
            }
        }
        return null;
    }
}
