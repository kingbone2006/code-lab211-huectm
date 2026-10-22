# J1.L.P0021 - Student Management System

## 1. Giới thiệu bài toán
Chương trình quản lý thông tin sinh viên bằng Java console, cho phép:
- Nhập thông tin sinh viên (yêu cầu nhập tối thiểu 10 sinh viên, sau đó hỏi người dùng có muốn tiếp tục hay không).
- Tìm kiếm sinh viên theo tên và sắp xếp kết quả hiển thị.
- Cập nhật hoặc xóa thông tin sinh viên theo mã sinh viên (ID).
- Báo cáo (Report) thống kê tổng số khóa học mà từng sinh viên đã đăng ký.

---

## 2. Cấu trúc bài toán
```
J1.L.P0021_StudentManagement/
├── src/
│   ├── entity/
│   │   └── Student.java          # Đối tượng lưu thông tin sinh viên
│   ├── management/
│   │   └── StudentManager.java   # Xử lý logic nghiệp vụ quản lý sinh viên
│   ├── utils/
│   │   └── Validator.java        # Kiểm tra tính hợp lệ dữ liệu nhập từ bàn phím
│   └── ui/
│       └── Main.java             # Giao diện menu và luồng tương tác console
├── nbproject/                    # Cấu hình dự án NetBeans
├── build.xml                     # File Ant build
└── README.md
```

---

## 3. Giải thích chi tiết các thành phần trong Code

### 3.1. `entity.Student`
- **Thuộc tính**:
  - `id` (String): Mã định danh sinh viên.
  - `studentName` (String): Tên sinh viên.
  - `semester` (String/int): Học kỳ học.
  - `courseName` (String): Tên khóa học (chỉ cho phép: `Java`, `.Net`, `C/C++`).
- **Chức năng**:
  - Kế thừa `Comparable<Student>` để hỗ trợ so sánh và sắp xếp danh sách theo tên sinh viên tăng dần (`compareTo`).
  - Cung cấp getter, setter và phương thức hiển thị định dạng thông tin sinh viên.

### 3.2. `management.StudentManager`
- Quản lý danh sách sinh viên nội bộ `List<Student>`.
- Các hàm nghiệp vụ chính:
  - `create(Student student)`: Thêm sinh viên vào danh sách. Nếu trùng ID thì tên sinh viên phải trùng khớp với tên đã có của ID đó.
  - `findAndSort(String namePart)`: Tìm kiếm sinh viên theo từ khóa trong tên (không phân biệt hoa thường) và trả về danh sách đã sắp xếp.
  - `getById(String id)`: Lấy danh sách các bản ghi học kỳ/khóa học của sinh viên theo ID.
  - `update(...)` / `delete(...)`: Cập nhật lại thông tin học kỳ/khóa học hoặc xóa bản ghi theo yêu cầu người dùng.
  - `report()`: Sử dụng `Map` hoặc gom nhóm để đếm tổng số lần đăng ký từng khóa học của mỗi sinh viên theo dạng: `StudentName | CourseName | TotalCourses`.

### 3.3. `utils.Validator`
- Đóng gói các hàm tiện ích nhập xuất console an toàn:
  - Nhập chuỗi không rỗng (`getString`).
  - Kiểm tra định dạng khóa học (`Java`, `.Net`, `C/C++`).
  - Lựa chọn Yes/No (`Y/N`) và Update/Delete (`U/D`).
  - Nhập số nguyên trong khoảng cho trước (phục vụ chọn menu).

### 3.4. `ui.Main`
- Chứa hàm `main()` điều hướng toàn bộ chương trình qua Menu:
  1. *Create*
  2. *Find and Sort*
  3. *Update/Delete*
  4. *Report*
  5. *Exit*

---

## 4. Hướng dẫn chạy chương trình
1. Mở dự án bằng **NetBeans IDE** hoặc bất kỳ Java IDE nào (IntelliJ IDEA, Eclipse, VS Code).
2. Chạy trực tiếp file `src/ui/Main.java`.
3. Hoặc biên dịch bằng terminal:
   ```bash
   cd J1.L.P0021_StudentManagement/src
   javac ui/Main.java
   java ui.Main
   ```
