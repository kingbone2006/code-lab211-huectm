# J1.S.P0061 - Shape Area and Perimeter Calculator

## 1. Giới thiệu bài toán
Chương trình minh họa nguyên lý Lập trình hướng đối tượng (Tính kế thừa và Tính đa hình) trong Java thông qua bài toán tính diện tích và chu vi của các hình học cơ bản:
- **Hình chữ nhật (Rectangle)**: Nhập chiều rộng và chiều dài.
- **Hình tròn (Circle)**: Nhập bán kính.
- **Hình tam giác (Triangle)**: Nhập 3 cạnh $a, b, c$ (kiểm tra điều kiện hợp lệ của tam giác: $a+b>c$, $a+c>b$, $b+c>a$).

Sau khi nhập đủ 3 hình, chương trình in chi tiết thông số kích thước, diện tích và chu vi của từng hình.

---

## 2. Cấu trúc bài toán
```
J1.S.P0061_ManagerShape_FinalFixed/
├── src/
│   ├── entity/
│   │   ├── Shape.java       # Lớp trừu tượng (abstract class) định nghĩa khung hình học
│   │   ├── Rectangle.java   # Lớp con kế thừa Shape cho hình chữ nhật
│   │   ├── Circle.java      # Lớp con kế thừa Shape cho hình tròn
│   │   └── Triangle.java    # Lớp con kế thừa Shape cho hình tam giác
│   ├── utils/
│   │   └── Validator.java   # Kiểm tra số thực dương và bất đẳng thức tam giác
│   └── ui/
│       └── Main.java        # Khởi tạo đối tượng, gọi hàm tính toán và in kết quả
├── nbproject/               # Cấu hình dự án NetBeans
├── build.xml                # File Ant build
└── README.md
```

---

## 3. Giải thích chi tiết các thành phần trong Code

### 3.1. `entity.Shape` (Abstract Class)
- Khai báo 3 phương thức trừu tượng:
  - `abstract double getArea()`: Trả về diện tích hình học.
  - `abstract double getPerimeter()`: Trả về chu vi hình học.
  - `abstract void printResult()`: In kết quả chi tiết của hình học ra màn hình.

### 3.2. Các lớp con kế thừa `Shape`
- **`Rectangle`**:
  - Thuộc tính: `width`, `length`.
  - Công thức: $Perimeter = (width + length) \times 2$; $Area = width \times length$.
- **`Circle`**:
  - Thuộc tính: `radius`.
  - Công thức: $Perimeter = 2 \times \pi \times radius$; $Area = \pi \times radius^2$.
- **`Triangle`**:
  - Thuộc tính: `a`, `b`, `c`.
  - Kiểm tra bất đẳng thức tam giác trước khi khởi tạo.
  - Công thức Heron:
    $$p = \frac{a+b+c}{2}$$
    $$Area = \sqrt{p(p-a)(p-b)(p-c)}$$
    $$Perimeter = a + b + c$$

### 3.3. `utils.Validator`
- Đảm bảo các kích thước nhập vào là số thực $> 0$.
- Hàm kiểm tra tính hợp lệ của tam giác: tổng 2 cạnh bất kỳ phải luôn lớn hơn cạnh còn lại.

### 3.4. `ui.Main`
- Lần lượt yêu cầu người dùng nhập thông số hình chữ nhật, hình tròn, tam giác.
- Sử dụng tính đa hình duyệt và gọi `printResult()` để xuất kết quả.

---

## 4. Hướng dẫn chạy chương trình
1. Mở dự án trong NetBeans hoặc Java IDE.
2. Chạy `src/ui/Main.java`.
