package data;

import entity.Account;
import java.util.ArrayList;
import java.util.List;

public class Data {

    public static final List<Account> listAccount = new ArrayList<Account>() {
        {
            add(new Account("1029817261", "tuan26062002"));
            add(new Account("1039817261", "minh12345677"));
            add(new Account("1049817261", "chung3245677"));
            add(new Account("1059817261", "dhdi129YIUQWIE"));
        }
    };

    private Data() {
    }
}
