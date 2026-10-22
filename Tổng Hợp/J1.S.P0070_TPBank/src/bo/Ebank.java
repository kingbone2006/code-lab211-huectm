package bo;

import data.Data;
import entity.Account;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import utils.Constant; // Đảm bảo import Constant nếu dùng

public class Ebank {

    private ResourceBundle bundle;

    public Ebank() {
    }

    public void setLocate(Locale locale) {
        bundle = ResourceBundle.getBundle("resource/Language", locale); // Đảm bảo đúng tên thư mục của bạn
    }

    // Hàm này rất quan trọng để Main.java có thể lấy ngôn ngữ
    public String getMessage(String key) {
        return bundle.getString(key);
    }

    public String checkAccountNumber(String accountNumber) {
        if (accountNumber.matches(Constant.ACCOUNT_NUMBER)) {
            return null;
        } else {
            return bundle.getString("accountInvalid");
        }
    }

    public String checkPassword(String password) {
        if (password.matches(Constant.PASSWORD)) {
            return null;
        } else {
            return bundle.getString("passwordInvalid");
        }
    }

    public String generateCaptcha() {
        String character = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm123456789";
        StringBuilder captcha = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < Constant.CAPTCHA_LENGTH; i++) {
            captcha.append(character.charAt(random.nextInt(character.length())));
        }
        return captcha.toString();
    }

    public String checkCaptcha(String captchaInput, String captchaGenerate) {
        if (captchaGenerate.contains(captchaInput)) {
            return null;
        } else {
            return bundle.getString("captchaInvalid");
        }
    }

    // Đã đổi tên thành login giống trong ảnh của bạn
    public boolean login(String accountNumber, String password) {
        for (Account a : Data.listAccount) {
            if (accountNumber.equals(a.getAccount()) && password.equals(a.getPassword())) {
                return true;
            }
        }
        return false;
    }
}