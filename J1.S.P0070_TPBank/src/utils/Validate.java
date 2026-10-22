package utils;

import java.util.Scanner;

public class Validate {

    private static final Scanner SCANNER = new Scanner(System.in);

    private Validate() {
    }

    public static int getInt(
            String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorNumber,
            int min,
            int max) {
        do {
            try {
                System.out.print(messageInfo);
                int number = Integer.parseInt(SCANNER.nextLine().trim());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println(messageErrorOutOfRange);
            } catch (NumberFormatException e) {
                System.out.println(messageErrorNumber);
            }
        } while (true);
    }

    public static String getString(String messageInfo, String messageError, final String REGEX) {
        do {
            System.out.print(messageInfo);
            String str = SCANNER.nextLine().trim();
            if (str.matches(REGEX)) {
                return str;
            }
            System.out.println(messageError);
        } while (true);
    }

    public static boolean verifyCaptcha(
            String message,
            String messageError,
            String captchaGenerate) {
        while (true) {
            System.out.printf(message);
            String captchaInput = SCANNER.nextLine().trim();
            if (!captchaInput.isEmpty() && captchaGenerate.contains(captchaInput)) {
                return true;
            }
            System.out.println(messageError);
        }
    }
}
