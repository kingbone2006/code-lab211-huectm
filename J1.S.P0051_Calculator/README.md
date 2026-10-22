# J1.S.P0051 - Computer and BMI Calculator Program

## 1. Giới thiệu bài toán
Chương trình cung cấp 2 chế độ máy tính toán học:
1. **Normal Calculator**: Máy tính cơ bản hỗ trợ các toán tử `+`, `-`, `*`, `/`, `^`, `=`. Người dùng nhập số thứ nhất, chọn toán tử, nhập số kế tiếp và liên tục thực hiện đến khi nhập dấu `=`, hiển thị kết quả cuối cùng.
2. **BMI Calculator**: Máy tính chỉ số khối cơ thể (BMI) dựa trên cân nặng (kg) và chiều cao (cm), sau đó đưa ra kết luận về tình trạng cơ thể (Understandard, Standard, Overweight, Fat, Very fat).

---

## 2. Cấu trúc bài toán
```
J1.S.P0051_Calculator/
├── src/
│   ├── model/
│   │   ├── BMIStatus.java       # Enum định nghĩa các trạng thái sức khỏe theo BMI
│   │   ├── Operator.java        # Enum biểu diễn các toán tử (+, -, *, /, ^, =)
│   │   └── Calculator.java      # Logic tính toán biểu thức và công thức BMI
│   ├── utils/
│   │   └── Validator.java       # Kiểm tra số thực hợp lệ, kiểm tra toán tử
│   └── ui/
│       └── Main.java            # Menu lựa chọn chế độ và tương tác người dùng
├── nbproject/                   # Cấu hình dự án NetBeans
├── build.xml                    # File Ant build
└── README.md
```

---

## 3. Giải thích chi tiết các thành phần trong Code

### 3.1. `model.Operator` & `model.BMIStatus`
- `Operator`: Liệt kê các toán tử hợp lệ `ADD (+)` , `SUBTRACT (-)` , `MULTIPLY (*)` , `DIVIDE (/)` , `EXPONENT (^)` , `EQUAL (=)`.
- `BMIStatus`:
  - `UNDER_STANDARD` (< 19)
  - `STANDARD` (19 - 25)
  - `OVERWEIGHT` (25 - 30)
  - `FAT` (30 - 40)
  - `VERY_FAT` (> 40)

### 3.2. `model.Calculator`
- `calculate(double a, Operator operator, double b)`: Thực hiện phép toán tương ứng giữa 2 số. Xử lý ngoại lệ chia cho 0.
- `calculateBMI(double weightKg, double heightCm)`:
  - Chuyển đổi chiều cao sang mét (`heightM = heightCm / 100`).
  - Áp dụng công thức: $BMI = \frac{weight}{(heightM)^2}$.
  - Xác định và trả về `BMIStatus`.

### 3.3. `utils.Validator`
- Kiểm tra số thực hợp lệ nhập từ bàn phím.
- Kiểm tra toán tử nhập vào có thuộc các ký tự cho phép `[+-*/^=]` hay không.

### 3.4. `ui.Main`
- Menu:
  1. *Normal Calculator*
  2. *BMI Calculator*
  3. *Exit*

---

## 4. Hướng dẫn chạy chương trình
1. Mở dự án trong NetBeans / IDE Java.
2. Chạy `src/ui/Main.java`.
