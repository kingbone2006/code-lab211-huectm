package entity;

public class Account {
    private String account;
    private String password;

    public Account(String account, String password) {
        // Dùng luôn setter trong constructor để dữ liệu khởi tạo cũng phải chuẩn
        setAccount(account);
        setPassword(password);
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        // Kiểm tra ngoại lệ: Tài khoản phải là 10 chữ số
        if (account == null || !account.matches("^[0-9]{10}$")) {
            throw new IllegalArgumentException("Lỗi hệ thống: Số tài khoản phải bao gồm 10 chữ số!");
        }
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        // Kiểm tra ngoại lệ: Mật khẩu 8-31 ký tự, gồm cả chữ và số
        if (password == null || !password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,31}$")) {
            throw new IllegalArgumentException("Lỗi hệ thống: Mật khẩu phải từ 8-31 ký tự và chứa cả chữ lẫn số!");
        }
        this.password = password;
    }
}