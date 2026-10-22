package ui;

import bo.Ebank;
import java.util.Locale;
import java.util.Scanner;
import utils.Validate;

public class Main {

    public static void main(String[] args) {
        while (true) {
            Ebank ebank = new Ebank();
            int choice = Validate.getInt("------- Login Program -------\n"
                    + "1. Vietnamese\n"
                    + "2. English\n"
                    + "3. Exit\n"
                    + "Please choice one option: ", "Must 1 -> 3", "Invalid!", 1, 3);
            switch (choice) {
                case 1:
                    ebank.setLocate(new Locale("vi", "VN"));
                    break;
                case 2:
                    ebank.setLocate(new Locale("en", "EN"));
                    break;
                case 3:
                    System.exit(0);
                    break;
            }

            Scanner sc = new Scanner(System.in);
            String accountNumber, password = null, captchaInput;
            String result;

            // Nhap account
            do {
                System.out.print(ebank.getMessage("account"));
                accountNumber = sc.nextLine();
                result = ebank.checkAccountNumber(accountNumber);
                if (result == null) {
                    break;
                } else {
                    System.out.println(result);
                }
            } while (true);

            // Nhap password (đã sửa lỗi copy-paste nhầm accountNumber = sc.nextLine)
            do {
                System.out.print(ebank.getMessage("password"));
                password = sc.nextLine(); // <-- Đã sửa đúng biến password
                result = ebank.checkPassword(password);
                if (result == null) {
                    break;
                } else {
                    System.out.println(result);
                }
            } while (true);

            // Nhap captcha
            String captchaGenerate = ebank.generateCaptcha();
            System.out.println(ebank.getMessage("captcha") + captchaGenerate);
            do {
                System.out.print(ebank.getMessage("inputCaptcha"));
                captchaInput = sc.nextLine();
                result = ebank.checkCaptcha(captchaInput, captchaGenerate);
                if (result == null) {
                    break;
                } else {
                    System.out.println(result);
                }
            } while (true);

            // Xac thuc authen (đã sửa tên gọi hàm thành ebank.login)
            if (ebank.login(accountNumber, password)) {
                System.out.println(ebank.getMessage("loginSuccess"));
            } else {
                System.out.println(ebank.getMessage("loginFailed"));
            }
        }
    }
}