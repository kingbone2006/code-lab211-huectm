package ui;

import entity.Person;
import entity.Wallet;
import utils.Validator;

public class Main {

    public static void main(String[] args) {
        System.out.println("======= Shopping program ==========");
        int n = Validator.getInt("input number of bill: ",
                "Number of bill must be > 0", "Invalid number!", 1, Integer.MAX_VALUE);
        int[] bills = new int[n];
        for (int i = 0; i < n; i++) {
            bills[i] = Validator.getInt("input value of bill " + (i + 1) + ": ",
                    "Bill must be >= 0", "Invalid number!", 0, Integer.MAX_VALUE);
        }
        int walletAmount = Validator.getInt("input value of wallet: ",
                "Wallet must be >= 0", "Invalid number!", 0, Integer.MAX_VALUE);

        Person person = new Person(new Wallet(walletAmount));
        int total = person.calcTotal(bills);
        System.out.println("this is total of bill:" + total);
        if (person.getWallet().payMoney(total)) {
            System.out.println("You can buy it.");
        } else {
            System.out.println("You can't buy it.");
        }
    }
}
