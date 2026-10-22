package bo;

import data.Data;
import entity.Account;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import utils.IConstant;

public class Ebank {

    private ResourceBundle bundle;

    public Ebank() {
    }

    public void setLocate(Locale locale) {
        if (locale == null) {
            throw new IllegalArgumentException("Locale cannot be null");
        }
        bundle = ResourceBundle.getBundle("resources/Language", locale);
    }

    public String checkAccountNumber(String accountNumber) {
        if (accountNumber != null && accountNumber.matches(IConstant.ACCOUNT_NUMBER)) {
            return null;
        }
        return bundle.getString("accountInvalid");
    }

    public String checkPassword(String password) {
        if (password != null && password.matches(IConstant.PASSWORD)) {
            return null;
        }
        return bundle.getString("passwordInvalid");
    }

    public String generateCaptcha() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder captcha = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < IConstant.CAPTCHA_LENGTH; i++) {
            captcha.append(characters.charAt(random.nextInt(characters.length())));
        }
        return captcha.toString();
    }

    public String checkCaptcha(String captchaInput, String captchaGenerate) {
        // Empty input must fail: String.contains("") is always true in Java
        if (captchaInput == null || captchaInput.trim().isEmpty()
                || captchaGenerate == null
                || !captchaGenerate.contains(captchaInput)) {
            return bundle.getString("captchaInvalid");
        }
        return null;
    }

    public void login() {
        Scanner sc = new Scanner(System.in);
        String accountNumber;
        String password;
        String captchaInput;
        String result;

        do {
            System.out.print(bundle.getString("account"));
            accountNumber = sc.nextLine();
            result = checkAccountNumber(accountNumber);
            if (result == null) {
                break;
            }
            System.out.println(result);
        } while (true);

        do {
            System.out.print(bundle.getString("password"));
            password = sc.nextLine();
            result = checkPassword(password);
            if (result == null) {
                break;
            }
            System.out.println(result);
        } while (true);

        String captchaGenerate = generateCaptcha();
        System.out.println(bundle.getString("captcha") + captchaGenerate);
        do {
            System.out.print(bundle.getString("inputCaptcha"));
            captchaInput = sc.nextLine();
            result = checkCaptcha(captchaInput, captchaGenerate);
            if (result == null) {
                break;
            }
            System.out.println(result);
        } while (true);

        if (authentication(accountNumber, password)) {
            System.out.println(bundle.getString("loginSuccess"));
        } else {
            System.out.println(bundle.getString("loginFailed"));
        }
    }

    private boolean authentication(String account, String password) {
        for (Account a : Data.listAccount) {
            if (account.equals(a.getAccount()) && password.equals(a.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
