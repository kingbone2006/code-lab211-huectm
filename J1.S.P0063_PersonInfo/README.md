# J1.S.P0063 - Person Information Sorter

## 1. Giới thiệu bài toán
Chương trình quản lý và sắp xếp thông tin cá nhân:
- Nhập thông tin của 3 người bao gồm: Họ tên (`name`), Địa chỉ (`address`), Mức lương (`salary`).
- Sắp xếp danh sách 3 người theo thứ tự mức lương tăng dần (Ascending order).
- Hiển thị toàn bộ thông tin của từng người sau khi đã sắp xếp.

---

## 2. Cấu trúc bài toán
```
J1.S.P0063_PersonInfo/
├── src/
│   ├── entity/
│   │   └── Person.java     # Thực thể lưu thông tin Person và logic hiển thị
│   ├── utils/
│   │   └── Validator.java  # Kiểm tra lương là số thực dương, chuỗi không rỗng
│   └── ui/
│       └── Main.java       # Nhập 3 Person, sắp xếp thuật toán Bubble Sort/Arrays.sort và in kết quả
├── nbproject/              # Cấu hình dự án NetBeans
├── build.xml               # File Ant build
└── README.md
```

---

## 3. Giải thích chi tiết các thành phần trong Code

### 3.1. `entity.Person`
- Thuộc tính:
  - `name` (String): Tên người.
  - `address` (String): Địa chỉ.
  - `salary` (double): Lương (phải $> 0$).
- Cài đặt `displayPersonInfo()`: In các thông tin theo từng dòng `Name: ...`, `Address: ...`, `Salary: ...`.

### 3.2. `utils.Validator`
- `checkInputSalary()`: Kiểm tra nhập số thực, nếu nhỏ hơn hoặc bằng 0 thì yêu cầu nhập lại với thông báo lỗi rõ ràng.
- `checkInputString()`: Đảm bảo chuỗi không chứa toàn khoảng trắng.

### 3.3. `ui.Main`
- `inputPersonInfo()`: Khởi tạo mảng `Person[3]`, nhập lần lượt 3 người.
- `sortBySalary(Person[] persons)`: Sử dụng thuật toán đổi chỗ (Bubble Sort hoặc so sánh trực tiếp) để sắp xếp mảng theo thứ tự `persons[i].salary < persons[j].salary`.
- In kết quả ra màn hình.

---

## 4. Hướng dẫn chạy chương trình
1. Mở dự án trong NetBeans hoặc Java IDE.
2. Chạy `src/ui/Main.java`.
