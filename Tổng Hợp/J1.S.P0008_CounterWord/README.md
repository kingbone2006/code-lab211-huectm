# J1.S.P0008 - Letter and Character Counter

## 1. Giới thiệu bài toán
Chương trình nhận vào một đoạn văn bản (chuỗi ký tự) từ người dùng và thực hiện thống kê:
1. **Đếm tần suất xuất hiện của từng từ (Word count)**.
2. **Đếm tần suất xuất hiện của từng chữ cái/ký tự (Character count)**.

Kết quả được in ra dưới dạng Map hiển thị dạng: `{word=count}` và `{char=count}`.

---

## 2. Cấu trúc bài toán
```
J1.S.P0008_CounterWord/
├── src/
│   ├── model/
│   │   └── ContentProcessor.java # Thuật toán tách từ và ký tự, đếm tần suất
│   ├── validate/
│   │   └── Validator.java        # Kiểm tra chuỗi nhập hợp lệ
│   └── ui/
│       └── Main.java             # Nhận dữ liệu nhập từ bàn phím và in kết quả
├── nbproject/                    # Cấu hình dự án NetBeans
├── build.xml                     # File Ant build
└── README.md
```

---

## 3. Giải thích chi tiết các thành phần trong Code

### 3.1. `model.ContentProcessor`
- Sử dụng cấu trúc dữ liệu `Map<String, Integer>` cho từ và `Map<Character, Integer>` cho ký tự (thường dùng `LinkedHashMap` hoặc `HashMap`).
- **`countWords(String content)`**:
  - Dùng `StringTokenizer` hoặc phương thức `split("\\s+")` để tách chuỗi thành các từ đơn.
  - Duyệt qua từng từ: nếu từ đã có trong Map thì tăng giá trị `count + 1`, ngược lại gán giá trị khởi tạo là `1`.
- **`countCharacters(String content)`**:
  - Duyệt qua từng ký tự trong chuỗi (bỏ qua khoảng trắng).
  - Tương tự, cộng dồn số lần xuất hiện của từng ký tự vào Map.

### 3.2. `validate.Validator`
- Đảm bảo người dùng nhập vào chuỗi không rỗng, loại trừ trường hợp người dùng chỉ bấm Enter hoặc khoảng trắng.

### 3.3. `ui.Main`
- Yêu cầu người dùng nhập chuỗi văn bản (ví dụ: `Hello World, this is a test`).
- Gọi `ContentProcessor` để xử lý.
- Xuất kết quả ra màn hình theo mẫu yêu cầu đề bài.

---

## 4. Hướng dẫn chạy chương trình
1. Mở dự án trong NetBeans hoặc IDE tương đương.
2. Chạy `src/ui/Main.java`.
3. Nhập đoạn văn bản bất kỳ và bấm Enter để xem thống kê.
