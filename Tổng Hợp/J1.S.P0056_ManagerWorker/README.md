# J1.S.P0056 - Worker Salary Management Program

## 1. Giới thiệu bài toán
Chương trình quản lý công nhân và theo dõi lịch sử điều chỉnh lương của công nhân trong công ty:
- **Thêm công nhân**: Nhập ID, Tên, Tuổi (18-50), Mức lương (> 0), Nơi làm việc.
- **Tăng lương (Up salary)**: Tăng lương cho công nhân theo mã ID và lưu vết điều chỉnh kèm ngày tháng.
- **Giảm lương (Down salary)**: Giảm lương cho công nhân theo mã ID (đảm bảo lương sau khi giảm vẫn > 0) và lưu vết kèm ngày tháng.
- **Hiển thị lịch sử điều chỉnh lương**: Hiển thị bảng theo dõi thay đổi lương sắp xếp theo mã công nhân.

---

## 2. Cấu trúc bài toán
```
J1.S.P0056_WorkerManagement/
├── src/
│   ├── entity/
│   │   ├── Worker.java         # Thông tin cơ bản của công nhân
│   │   ├── SalaryHistory.java  # Bản ghi lịch sử thay đổi lương
│   │   └── SalaryStatus.java   # Trạng thái điều chỉnh lương (UP / DOWN)
│   ├── management/
│   │   └── Management.java     # Logic quản lý công nhân và lịch sử lương
│   ├── utils/
│   │   └── Validator.java      # Kiểm tra tuổi (18-50), lương (>0), chuỗi không rỗng
│   └── ui/
│       └── Main.java           # Menu giao diện console
├── nbproject/                  # Cấu hình dự án NetBeans
├── build.xml                   # File Ant build
└── README.md
```

---

## 3. Giải thích chi tiết các thành phần trong Code

### 3.1. Các lớp thực thể (`entity`)
- **`Worker`**: Lưu `id`, `name`, `age`, `salary`, `workLocation`. Cung cấp phương thức cập nhật lương khi có sự thay đổi.
- **`SalaryStatus`**: Enum biểu diễn 2 trạng thái `UP` (Tăng lương) hoặc `DOWN` (Giảm lương).
- **`SalaryHistory`**: Kế thừa hoặc liên kết với thông tin công nhân, lưu: `id`, `name`, `age`, `salary` (mức lương sau điều chỉnh), `status` (UP/DOWN), `date` (ngày điều chỉnh định dạng `dd/MM/yyyy`). Cài đặt `Comparable` để sắp xếp theo ID.

### 3.2. `management.Management`
- `List<Worker> listWorkers`: Danh sách các công nhân hiện có.
- `List<SalaryHistory> listHistories`: Danh sách ghi nhận tất cả các lần điều chỉnh lương.
- Phương thức:
  - `addWorker(Worker worker)`: Thêm công nhân (kiểm tra không trùng ID).
  - `changeSalary(SalaryStatus status, String id, double amount)`: Cập nhật mức lương mới của công nhân trong `listWorkers`, tạo một bản ghi `SalaryHistory` mới và thêm vào `listHistories`.
  - `getInformationSalary()`: Sắp xếp và in toàn bộ lịch sử thay đổi lương ra console.

### 3.3. `utils.Validator`
- Đảm bảo tuổi từ 18 đến 50.
- Lương và số tiền điều chỉnh phải là số thực lớn hơn 0.
- Ngày tự động lấy theo ngày hiện tại của hệ thống (`LocalDate.now()`).

### 3.4. `ui.Main`
- Menu:
  1. *Add Worker*
  2. *Up salary*
  3. *Down salary*
  4. *Display Information salary*
  5. *Exit*

---

## 4. Hướng dẫn chạy chương trình
1. Mở dự án trong NetBeans hoặc IDE tương đương.
2. Chạy `src/ui/Main.java`.
