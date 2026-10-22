# J1.S.P0010 - Linear Search Algorithm

## 1. Giới thiệu bài toán
Chương trình minh họa thuật toán tìm kiếm tuyến tính (Linear Search) trên mảng một chiều các số nguyên:
- Nhập vào kích thước mảng ($n > 0$).
- Sinh mảng ngẫu nhiên gồm $n$ số nguyên.
- Hiển thị mảng vừa tạo.
- Nhập giá trị cần tìm kiếm (`value`).
- Tìm kiếm tuần tự trong mảng và trả về chỉ số (index) đầu tiên tìm thấy hoặc thông báo không tìm thấy.

---

## 2. Cấu trúc bài toán
```
J1.S.P0010_LinearSearch/
├── src/
│   ├── array/
│   │   └── MyArray.java      # Lớp mảng số nguyên, sinh số ngẫu nhiên và thuật toán tìm kiếm
│   ├── validator/
│   │   └── Validator.java    # Kiểm tra số nguyên dương nhập từ bàn phím
│   └── ui/
│       └── Main.java         # Điều phối luồng chương trình
├── nbproject/                # Cấu hình dự án NetBeans
├── build.xml                 # File Ant build
└── README.md
```

---

## 3. Giải thích chi tiết các thành phần trong Code

### 3.1. `array.MyArray`
- **Thuộc tính**: `int[] array`.
- **Constructor `MyArray(int number)`**: Khởi tạo mảng có độ dài `number` (yêu cầu `number > 0`).
- **`genRandomArray()`**: Dùng `Random.nextInt(array.length)` để gán ngẫu nhiên các giá trị vào từng vị trí của mảng.
- **`searchIndex(int value)`**:
  - Duyệt tuần tự từ đầu đến cuối mảng: `for (int i = 0; i < array.length; i++)`.
  - Nếu `array[i] == value` thì trả về ngay vị trí `i`.
  - Nếu duyệt hết mảng mà không thấy thì trả về `-1`.
- **`toString()`**: Định dạng chuỗi hiển thị mảng dưới dạng `[x, y, z]`.

### 3.2. `validator.Validator`
- Kiểm tra nhập vào số nguyên dương hợp lệ cho độ dài mảng và số nguyên bất kỳ cho giá trị cần tìm.

### 3.3. `ui.Main`
- Nhập số lượng phần tử -> Sinh mảng ngẫu nhiên -> In mảng -> Nhập số cần tìm -> In vị trí tìm thấy.

---

## 4. Hướng dẫn chạy chương trình
1. Mở dự án trong NetBeans hoặc Java IDE.
2. Chạy `src/ui/Main.java`.
