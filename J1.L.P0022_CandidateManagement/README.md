# J1.L.P0022 - Candidates Management System

## 1. Giới thiệu bài toán
Hệ thống quản lý ứng viên tuyển dụng cho phép quản lý 3 nhóm ứng viên khác nhau:
1. **Experience** (Ứng viên có kinh nghiệm)
2. **Fresher** (Ứng viên mới tốt nghiệp)
3. **Internship** (Ứng viên thực tập sinh)

Chương trình cho phép nhập hồ sơ cho từng loại ứng viên, sau đó tìm kiếm ứng viên theo tên hoặc loại ứng viên.

---

## 2. Cấu trúc bài toán
```
J1.L.P0022_CandidateManagement/
├── src/
│   ├── entity/
│   │   ├── Candidate.java       # Lớp cha trừu tượng/cơ sở chứa thông tin chung
│   │   ├── Experience.java      # Lớp con kế thừa Candidate cho ứng viên có kinh nghiệm
│   │   ├── Fresher.java         # Lớp con kế thừa Candidate cho ứng viên tốt nghiệp
│   │   └── Intern.java          # Lớp con kế thừa Candidate cho ứng viên thực tập
│   ├── management/
│   │   └── CandidateManager.java# Logic thêm mới và tìm kiếm ứng viên
│   ├── utils/
│   │   └── Validator.java       # Kiểm tra hợp lệ năm sinh, số điện thoại, email
│   └── ui/
│       └── Main.java            # Menu điều hướng chương trình
├── nbproject/                   # Cấu hình dự án NetBeans
├── build.xml                    # File Ant build
└── README.md
```

---

## 3. Giải thích chi tiết các thành phần trong Code

### 3.1. Phân cấp kế thừa (`entity`)
- **`Candidate` (Lớp cha)**:
  - Thuộc tính chung: `id`, `firstName`, `lastName`, `birthDate` (1900 đến năm hiện tại), `address`, `phone` (tối thiểu 10 chữ số), `email` (chuẩn format regex RFC), `candidateType` (0: Experience, 1: Fresher, 2: Intern).
- **`Experience`**:
  - Thuộc tính bổ sung: `expInYear` (kinh nghiệm từ 0 - 100 năm), `proSkill` (kỹ năng chuyên môn).
- **`Fresher`**:
  - Thuộc tính bổ sung: `graduationDate`, `graduationRank` (Excellence, Good, Fair, Poor), `education` (trường đào tạo).
- **`Intern`**:
  - Thuộc tính bổ sung: `majors` (ngành học), `semester` (học kỳ hiện tại), `universityName` (tên trường đại học).

### 3.2. `management.CandidateManager`
- Quản lý danh sách chung `List<Candidate>`.
- `create(Candidate candidate)`: Thêm một ứng viên mới vào hệ thống.
- `search(String namePart, int candidateType)`: Tìm kiếm ứng viên khi tên chứa chuỗi cần tìm và có đúng loại ứng viên yêu cầu.
- `printCandidatesByType()`: Gom nhóm và hiển thị toàn bộ họ tên các ứng viên theo 3 loại để người dùng dễ theo dõi trước khi tìm kiếm.

### 3.3. `utils.Validator`
- `getInt(int min, int max)`: Kiểm tra nhập số nguyên trong khoảng hợp lệ.
- `getBirthDate()`: Đảm bảo năm sinh từ 1900 đến năm hiện tại.
- `getPhone()`: Đảm bảo số điện thoại chứa ít nhất 10 số.
- `getEmail()`: Sử dụng Regular Expression để kiểm tra định dạng email hợp lệ (`^[A-Za-z0-9+_.-]+@(.+)$`).

### 3.4. `ui.Main`
- Cung cấp Menu 5 chức năng:
  1. *Experience* (Thêm ứng viên kinh nghiệm)
  2. *Fresher* (Thêm ứng viên tốt nghiệp)
  3. *Internship* (Thêm ứng viên thực tập)
  4. *Searching* (Tìm kiếm ứng viên)
  5. *Exit* (Thoát)

---

## 4. Hướng dẫn chạy chương trình
1. Mở dự án trong **NetBeans** hoặc IDE tương ứng.
2. Chạy file `src/ui/Main.java`.
3. Nhập dữ liệu theo luồng hướng dẫn trên màn hình console.
