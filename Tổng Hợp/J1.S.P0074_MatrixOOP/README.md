# J1.S.P0074 - Matrix Calculator (OOP)

## 1. Giới thiệu bài toán
Chương trình máy tính ma trận sử dụng mô hình Lập trình hướng đối tượng (OOP), hỗ trợ các phép toán cơ bản:
1. **Phép cộng ma trận (Addition Matrix)**: $C = A + B$ (yêu cầu 2 ma trận cùng kích thước dòng và cột).
2. **Phép trừ ma trận (Subtraction Matrix)**: $C = A - B$ (yêu cầu 2 ma trận cùng kích thước dòng và cột).
3. **Phép nhân ma trận (Multiplication Matrix)**: $C = A \times B$ (yêu cầu số cột của ma trận 1 bằng số dòng của ma trận 2).

---

## 2. Cấu trúc bài toán
```
J1.S.P0074_MatrixOOP/
├── src/
│   ├── entity/
│   │   └── Matrix.java       # Lớp ma trận đóng gói dữ liệu và các phép toán đại số ma trận
│   ├── utils/
│   │   └── Validator.java    # Kiểm tra kích thước dòng, cột và phần tử số nguyên
│   └── ui/
│       └── Main.java         # Menu chọn phép tính ma trận và in kết quả
├── nbproject/                # Cấu hình dự án NetBeans
├── build.xml                 # File Ant build
└── README.md
```

---

## 3. Giải thích chi tiết các thành phần trong Code

### 3.1. `entity.Matrix`
- **Thuộc tính**: `int[][] data` - mảng 2 chiều biểu diễn ma trận.
- **Phương thức kích thước**:
  - `getRows()`: Trả về số dòng của ma trận.
  - `getCols()`: Trả về số cột của ma trận.
- **Các phép toán nghiệp vụ**:
  - `additionMatrix(Matrix m2)`:
    - Kiểm tra điều kiện: `this.getRows() == m2.getRows() && this.getCols() == m2.getCols()`.
    - Tính $result[i][j] = this[i][j] + m2[i][j]$.
  - `subtractionMatrix(Matrix m2)`:
    - Kiểm tra điều kiện cùng kích thước.
    - Tính $result[i][j] = this[i][j] - m2[i][j]$.
  - `multiplicationMatrix(Matrix m2)`:
    - Kiểm tra điều kiện nhân ma trận: `this.getCols() == m2.getRows()`.
    - Kích thước kết quả là `this.getRows() x m2.getCols()`.
    - Tính tích vô hướng: $result[i][j] = \sum_{k} this[i][k] \times m2[k][j]$.
  - `display()`: In định dạng ma trận dạng lưới hàng/cột.

### 3.2. `utils.Validator`
- Kiểm tra số dòng, số cột $> 0$.
- Nhập từng phần tử ma trận là số nguyên hợp lệ.

### 3.3. `ui.Main`
- Menu:
  1. *Addition Matrix*
  2. *Subtraction Matrix*
  3. *Multiplication Matrix*
  4. *Exit*

---

## 4. Hướng dẫn chạy chương trình
1. Mở dự án trong NetBeans hoặc Java IDE.
2. Chạy `src/ui/Main.java`.
