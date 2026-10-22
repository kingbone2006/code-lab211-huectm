# J1.L.P0025 - Normalize Text

## 1. Giới thiệu bài toán
Chương trình chuẩn hóa văn bản đọc từ file đầu vào `input.txt` và ghi kết quả đã chuẩn hóa ra file `output.txt` theo các quy tắc chuẩn hóa văn bản tiếng Anh:
- Giữa các từ chỉ có đúng 1 dấu cách (khoảng trắng).
- Không có khoảng trắng trước các dấu câu (`.`, `,`, `:`, `;`, `!`, `?`).
- Sau dấu câu phải có đúng 1 khoảng trắng (nếu chưa phải cuối dòng hoặc cuối văn bản).
- Chữ cái đầu tiên của câu (sau dấu chấm, hỏi, than hoặc đầu đoạn văn) phải được viết hoa.
- Ký tự trong dấu ngoặc kép `""` không có khoảng cách thừa sát với dấu ngoặc.
- Không có dòng trống thừa giữa các dòng.
- Kết thúc văn bản phải có dấu chấm câu.

---

## 2. Cấu trúc bài toán
```
J1.L.P0025_NormalizeText/
├── input.txt                    # File dữ liệu văn bản thô đầu vào
├── output.txt                   # File dữ liệu văn bản sau khi chuẩn hóa
├── src/
│   ├── model/
│   │   └── TextNormalizer.java  # Các hàm xử lý thuật toán chuẩn hóa văn bản
│   └── ui/
│       └── Main.java            # Đọc file, gọi hàm chuẩn hóa và ghi ra file
├── nbproject/                   # Cấu hình dự án NetBeans
├── build.xml                    # File Ant build
└── README.md
```

---

## 3. Giải thích chi tiết các thành phần trong Code

### 3.1. `model.TextNormalizer`
Chứa các thuật toán xử lý chuỗi văn bản sử dụng `StringBuilder` và Regular Expressions (`Regex`):
- `normalizeSpacing(String line)`:
  - Thay thế nhiều khoảng trắng liên tiếp bằng đúng một khoảng trắng (`\\s+` -> `" "`).
  - Xóa khoảng trắng trước các dấu câu `,`, `.`, `:`, `;`.
  - Thêm khoảng trắng sau dấu câu nếu liền kề là một ký tự chữ cái.
- `capitalizeSentences(String text)`:
  - Viết hoa chữ cái đầu tiên của toàn bộ văn bản.
  - Sau các dấu chấm (`. `), dấu hỏi (`? `), dấu chấm than (`! `), tự động viết hoa chữ cái kế tiếp.
- `formatQuotes(String line)`:
  - Chuẩn hóa phần văn bản bên trong cặp dấu ngoặc kép `"` sao cho từ đầu và từ cuối trong ngoặc sát với dấu ngoặc.
- `ensureEndPeriod(String text)`:
  - Đảm bảo ký tự cuối cùng của văn bản luôn kết thúc bằng dấu chấm (`.`).

### 3.2. `ui.Main`
- Mở file `input.txt` thông qua `BufferedReader`.
- Đọc từng dòng, loại bỏ các dòng trống không cần thiết.
- Gọi chuỗi xử lý từ `TextNormalizer`.
- Ghi toàn bộ kết quả đã làm sạch vào file `output.txt` thông qua `BufferedWriter` / `PrintWriter`.

---

## 4. Hướng dẫn chạy chương trình
1. Đảm bảo file `input.txt` nằm tại thư mục gốc của project (hoặc đường dẫn được định cấu hình trong `Main.java`).
2. Chạy `Main.java`.
3. Kiểm tra kết quả chuẩn hóa tại file `output.txt`.
