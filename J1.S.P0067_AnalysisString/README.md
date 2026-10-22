# J1.S.P0067 - String Analysis Program

## 1. Giới thiệu bài toán
Chương trình nhận vào một chuỗi văn bản hỗn hợp (gồm các chữ cái, chữ số và ký tự đặc biệt) từ người dùng và phân tích, trích xuất dữ liệu thành 2 nhóm chính:
1. **Phân tích số (Numbers)**:
   - Tất cả các số (`All Numbers`).
   - Các số chẵn (`Even Numbers`).
   - Các số lẻ (`Odd Numbers`).
   - Các số chính phương (`Perfect Square Numbers`).
2. **Phân tích ký tự chữ và ký hiệu (Characters)**:
   - Ký tự viết hoa (`Uppercase Characters`).
   - Ký tự viết thường (`Lowercase Characters`).
   - Ký tự đặc biệt (`Special Characters`).
   - Toàn bộ ký tự không phải số (`All Characters`).

---

## 2. Cấu trúc bài toán
```
J1.S.P0067_AnalysisString/
├── src/
│   ├── model/
│   │   └── AnalysisString.java # Thuật toán Regex trích xuất số và phân loại ký tự
│   ├── utils/
│   │   └── Validator.java      # Kiểm tra chuỗi nhập không rỗng
│   └── ui/
│       └── Main.java           # Giao diện nhận chuỗi và kích hoạt phân tích
├── nbproject/                  # Cấu hình dự án NetBeans
├── build.xml                   # File Ant build
└── README.md
```

---

## 3. Giải thích chi tiết các thành phần trong Code

### 3.1. `model.AnalysisString`
- **Thuộc tính**: `input` (String) - chuỗi văn bản cần phân tích.
- **Phương thức `getNumber(String input)`**:
  - Sử dụng biểu thức chính quy `Pattern.compile("\\d+")` và `Matcher` để tìm tất cả các chuỗi số nguyên xuất hiện trong chuỗi.
  - Phân loại số chẵn (`n % 2 == 0`) và số lẻ (`n % 2 != 0`).
  - Kiểm tra số chính phương bằng: `root = (int) Math.sqrt(n); if (root * root == n)`.
  - Trả về `HashMap<String, List<Integer>>` chứa 4 danh sách số đã phân loại.
- **Phương thức `getCharacter(String input)`**:
  - Duyệt qua từng ký tự của chuỗi `input.toCharArray()`.
  - Bỏ qua các ký tự là chữ số (`Character.isDigit(c)`).
  - Phân loại thành: `Character.isUpperCase(c)`, `Character.isLowerCase(c)` và ký tự đặc biệt còn lại.
  - Trả về `HashMap<String, StringBuilder>`.
- **Phương thức `printResult()`**: Định dạng và in kết quả đẹp mắt ra console.

### 3.2. `utils.Validator` & `ui.Main`
- `Validator.getString()`: Đảm bảo người dùng nhập vào một chuỗi không rỗng.
- `Main.java`: Tạo đối tượng `AnalysisString` với chuỗi vừa nhập và gọi `printResult()`.

---

## 4. Hướng dẫn chạy chương trình
1. Mở dự án trong NetBeans hoặc Java IDE.
2. Chạy `src/ui/Main.java`.
3. Nhập chuỗi kiểm thử, ví dụ: `3jh234jk&*%*#k4` và xem kết quả phân tích.
