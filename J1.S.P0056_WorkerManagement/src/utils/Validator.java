package utils;

import java.util.Scanner;

public class Validator {

    private static final Scanner SCANNER = new Scanner(System.in);

    private Validator() {
    }

    public static int getInt(String messageInfo, String messageErrorOutOfRange,
            String messageErrorInvalidNumber, int min, int max) {
        do {
            try {
                System.out.print(messageInfo);
                int number = Integer.parseInt(SCANNER.nextLine().trim());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println(messageErrorOutOfRange);
            } catch (NumberFormatException e) {
                System.out.println(messageErrorInvalidNumber);
            }
        } while (true);
    }

    public static double getDouble(String messageInfo, String messageErrorOutOfRange,
            String messageErrorInvalidNumber, double min, double max) {
        do {
            try {
                System.out.print(messageInfo);
                double number = Double.parseDouble(SCANNER.nextLine().trim());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println(messageErrorOutOfRange);
            } catch (NumberFormatException e) {
                System.out.println(messageErrorInvalidNumber);
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

    public static String getStringAllowEmpty(String messageInfo) {
        System.out.print(messageInfo);
        return SCANNER.nextLine().trim();
    }

    public static boolean getYesNo(String messageInfo) {
        do {
            System.out.print(messageInfo);
            String str = SCANNER.nextLine().trim();
            if (str.equalsIgnoreCase("Y")) {
                return true;
            }
            if (str.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please enter Y or N!");
        } while (true);
    }
}
