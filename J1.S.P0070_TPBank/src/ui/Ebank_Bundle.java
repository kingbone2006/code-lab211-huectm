package ui;

import bo.Ebank;
import java.util.Locale;
import utils.Validate;

public class Ebank_Bundle {

    public static void start() {
        while (true) {
            Ebank ebank = new Ebank();
            int choice = Validate.getInt(
                    "-------Login Program-------\n"
                    + "1. Vietnamese\n"
                    + "2. English\n"
                    + "3. Exit\n"
                    + "Please choice one option:",
                    "Must be 1->3",
                    "Invalid!",
                    1,
                    3);
            switch (choice) {
                case 1:
                    ebank.setLocate(new Locale("vi", "VN"));
                    break;
                case 2:
                    ebank.setLocate(new Locale("en", "US"));
                    break;
                case 3:
                    return;
            }
            ebank.login();
        }
    }
}
