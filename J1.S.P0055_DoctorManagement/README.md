# J1.S.P0055 - Doctor Management Program

## 1. Giới thiệu bài toán
Chương trình quản lý danh sách bác sĩ trong cơ sở y tế sử dụng cấu trúc dữ liệu bảng băm (`HashMap`):
- Thêm bác sĩ (Mã bác sĩ, Tên bác sĩ, Chuyên khoa, Giờ trực/tình trạng sẵn sàng).
- Cập nhật thông tin bác sĩ theo mã bác sĩ.
- Xóa bác sĩ theo mã.
- Tìm kiếm bác sĩ theo từ khóa (tên hoặc mã).

---

## 2. Cấu trúc bài toán
```
J1.S.P0055_DoctorManagement/
├── src/
│   ├── entity/
│   │   └── Doctor.java        # Thực thể lưu trữ thông tin bác sĩ
│   ├── management/
│   │   └── DoctorHash.java    # Xử lý nghiệp vụ quản lý bằng HashMap
│   ├── utils/
│   │   └── Validator.java     # Kiểm tra dữ liệu nhập hợp lệ
│   └── ui/
│       └── Main.java          # Menu giao diện điều khiển console
├── nbproject/                 # Cấu hình dự án NetBeans
├── build.xml                  # File Ant build
└── README.md
```

---

## 3. Giải thích chi tiết các thành phần trong Code

### 3.1. `entity.Doctor`
- Thuộc tính:
  - `code` (String): Mã duy nhất của bác sĩ (Khóa chính trong bảng băm).
  - `name` (String): Họ tên bác sĩ.
  - `specialization` (String): Chuyên khoa (Tim mạch, Nhi, Nội khoa,...).
  - `availability` (int): Số giờ hoặc ca trực sẵn sàng phục vụ.

### 3.2. `management.DoctorHash`
- Sử dụng `HashMap<String, Doctor>` với Key là `code`:
  - `addDoctor(Doctor doctor)`: Kiểm tra tính duy nhất của mã bác sĩ trước khi đưa vào Map; ném ngoại lệ hoặc thông báo nếu mã đã tồn tại hoặc dữ liệu null.
  - `updateDoctor(Doctor doctor)`: Tìm bác sĩ theo `code` và cập nhật lại thông tin mới.
  - `deleteDoctor(Doctor doctor)`: Xóa bác sĩ ra khỏi Map theo mã.
  - `searchDoctor(String input)`: Tìm kiếm tất cả bác sĩ có tên hoặc mã chứa chuỗi tìm kiếm và trả về `HashMap` kết quả.

### 3.3. `utils.Validator`
- Kiểm tra tính hợp lệ của mã bác sĩ, tên, chuyên khoa và số nguyên cho `availability` (phải lớn hơn 0).

### 3.4. `ui.Main`
- Menu:
  1. *Add Doctor*
  2. *Update Doctor*
  3. *Delete Doctor*
  4. *Search Doctor*
  5. *Exit*

---

## 4. Hướng dẫn chạy chương trình
1. Mở dự án trong NetBeans hoặc Java IDE.
2. Chạy `src/ui/Main.java`.
