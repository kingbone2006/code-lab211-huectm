# J1.S.P0070 - TPBank Ebank Login System (i18n & Captcha)

## 1. Giới thiệu bài toán
Chương trình mô phỏng hệ thống đăng nhập điện tử ngân hàng số (Ebank) của TPBank với 2 tính năng nổi bật:
1. **Đa ngôn ngữ (Internationalization - i18n)**: Hỗ trợ chuyển đổi giao diện và thông báo lỗi bằng 2 ngôn ngữ: Tiếng Việt (`vi`) và Tiếng Anh (`en`) sử dụng `ResourceBundle` và `Locale`.
2. **Kiểm tra đăng nhập an toàn & sinh mã Captcha**:
   - Số tài khoản (Account number): Phải là chuỗi gồm đúng 10 chữ số.
   - Mật khẩu (Password): Độ dài từ 8 đến 31 ký tự, bao gồm cả chữ cái và chữ số.
   - Mã Captcha: Sinh ngẫu nhiên chuỗi 5 ký tự (chữ hoa, chữ thường, số). Người dùng phải nhập chính xác mã này trước khi đăng nhập.

---

## 2. Cấu trúc bài toán
```
J1.S.P0070_TPBank/
├── src/
│   ├── bo/
│   │   └── Ebank.java                  # Logic nghiệp vụ xác thực tài khoản, mật khẩu, sinh Captcha
│   ├── data/
│   │   └── Data.java                   # Dữ liệu tài khoản mẫu
│   ├── entity/
│   │   └── Account.java                # Thực thể lưu số tài khoản và mật khẩu
│   ├── resources/
│   │   ├── Language_en.properties      # File thông điệp ngôn ngữ Tiếng Anh
│   │   └── Language_vi.properties      # File thông điệp ngôn ngữ Tiếng Việt
│   ├── utils/
│   │   ├── IConstant.java              # Chứa các biểu thức chính quy (Regex) và hằng số
│   │   └── Validate.java               # Tiện ích nhập liệu console
│   └── ui/
│       ├── Ebank_Bundle.java           # Điều phối luồng giao diện theo ngôn ngữ
│       └── Main.java                   # Điểm khởi chạy chương trình (Menu chọn ngôn ngữ)
├── nbproject/                          # Cấu hình dự án NetBeans
├── build.xml                           # File Ant build
└── README.md
```

---

## 3. Giải thích chi tiết các thành phần trong Code

### 3.1. `resources/Language_*.properties`
- Lưu trữ các thông báo theo cặp Key-Value tương ứng với từng ngôn ngữ:
  - `accountPrompt`: Lời nhắc nhập số tài khoản.
  - `accountInvalid`: Thông báo số tài khoản không hợp lệ.
  - `passwordPrompt`: Lời nhắc nhập mật khẩu.
  - `passwordInvalid`: Thông báo mật khẩu không đúng định dạng.
  - `captchaPrompt`: Lời nhắc nhập Captcha.
  - `captchaIncorrect`: Thông báo nhập sai Captcha.

### 3.2. `bo.Ebank`
- `setLocate(Locale locale)`: Tải gói ngôn ngữ tương ứng (`ResourceBundle.getBundle(...)`).
- `checkAccountNumber(String accountNumber)`: Kiểm tra chuỗi 10 chữ số theo Regex `^[0-9]{10}$`. Trả về lỗi nếu sai.
- `checkPassword(String password)`: Kiểm tra độ dài 8-31 ký tự, có cả chữ và số: `^(?=.*[0-9])(?=.*[a-zA-Z])[a-zA-Z0-9]{8,31}$`.
- `generateCaptcha()`: Sinh ngẫu nhiên chuỗi 5 ký tự từ tập hợp chữ hoa, chữ thường và chữ số bằng `Random`.
- `checkCaptcha(String captchaInput, String captchaGenerated)`: Kiểm tra mã Captcha nhập vào có khớp với mã được sinh ra hay không.

### 3.3. `ui.Main` & `ui.Ebank_Bundle`
- Menu:
  1. *Vietnamese* (`new Locale("vi")`)
  2. *English* (`new Locale("en")`)
  3. *Exit*
- Sau khi chọn ngôn ngữ, chương trình chuyển sang giao diện đăng nhập với ngôn ngữ đã chọn và yêu cầu nhập số tài khoản, mật khẩu, và mã xác thực Captcha.

---

## 4. Hướng dẫn chạy chương trình
1. Mở dự án trong NetBeans hoặc Java IDE.
2. Chạy `src/ui/Main.java`.
3. Chọn ngôn ngữ (1 hoặc 2) và thực hiện các bước đăng nhập kiểm thử.
