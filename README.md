# Kho Lưu Trữ Bài Tập Thực Hành Java OOP - LAB211

Kho lưu trữ tổng hợp toàn bộ các bài thực hành và đề thi mẫu môn **LAB211 (Java OOP Lab)**. Mỗi bài đều được triển khai theo mô hình kiến trúc nhiều lớp (Entity - Management/Business Logic - Validation - UI), tối ưu hóa luồng dữ liệu, bẫy lỗi nhập xuất (Exception Handling) và đáp ứng đầy đủ yêu cầu nghiệp vụ từ cơ bản đến nâng cao.

---

## 📚 Danh Sách Các Bài Thực Hành (Table of Contents)

| STT | Mã Bài Lab | Tên Đề Tài | Thư Mục | Tóm Tắt Nghiệp Vụ | README Chi Tiết |
| :---: | :--- | :--- | :--- | :--- | :---: |
| 1 | **J1.L.P0021** | Quản lý sinh viên | [`J1.L.P0021_StudentManagement`](./J1.L.P0021_StudentManagement) | Nhập tối thiểu 10 SV, tìm kiếm sắp xếp theo tên, sửa/xóa theo ID, thống kê khóa học (Report). | [Xem README](./J1.L.P0021_StudentManagement/README.md) |
| 2 | **J1.L.P0022** | Quản lý ứng viên tuyển dụng | [`J1.L.P0022_CandidateManagement`](./J1.L.P0022_CandidateManagement) | Quản lý 3 nhóm ứng viên: Experience, Fresher, Internship; phân cấp kế thừa và tìm kiếm theo loại. | [Xem README](./J1.L.P0022_CandidateManagement/README.md) |
| 3 | **J1.L.P0023** | Cửa hàng hoa quả (Fruit Shop) | [`J1.L.P0023_FruitShop`](./J1.L.P0023_FruitShop) | Nhập kho trái cây, giỏ hàng mua sắm, cập nhật tồn kho và quản lý đơn hàng bằng Hashtable. | [Xem README](./J1.L.P0023_FruitShop/README.md) |
| 4 | **J1.L.P0025** | Chuẩn hóa văn bản | [`J1.L.P0025_NormalizeText`](./J1.L.P0025_NormalizeText) | Đọc file `input.txt`, chuẩn hóa dấu câu, khoảng cách, viết hoa đầu câu, ghi ra `output.txt`. | [Xem README](./J1.L.P0025_NormalizeText/README.md) |
| 5 | **J1.S.P0008** | Đếm từ và ký tự | [`J1.S.P0008_CounterWord`](./J1.S.P0008_CounterWord) | Thống kê tần suất xuất hiện của từng từ và từng ký tự trong chuỗi bằng cấu trúc dữ liệu Map. | [Xem README](./J1.S.P0008_CounterWord/README.md) |
| 6 | **J1.S.P0010** | Tìm kiếm tuyến tính | [`Tổng Hợp/J1.S.P0010_LinearSearch`](./Tổng%20Hợp/J1.S.P0010_LinearSearch) | Sinh mảng số nguyên ngẫu nhiên và tìm kiếm vị trí phần tử theo thuật toán Linear Search. | [Xem README](./Tổng%20Hợp/J1.S.P0010_LinearSearch/README.md) |
| 7 | **J1.S.P0051** | Máy tính số học & BMI | [`J1.S.P0051_Calculator`](./J1.S.P0051_Calculator) | Máy tính thực hiện chuỗi phép toán (+, -, *, /, ^) và tính chỉ số khối cơ thể BMI đánh giá thể trạng. | [Xem README](./J1.S.P0051_Calculator/README.md) |
| 8 | **J1.S.P0052** | Quản lý các quốc gia Đông Á | [`J1.S.P0052_ManagerContries_FinalUpdate`](./J1.S.P0052_ManagerContries_FinalUpdate) | Nhập thông tin 11 nước Đông Á, hiển thị nước vừa nhập, tìm kiếm theo tên và sắp xếp theo bảng chữ cái. | [Xem README](./J1.S.P0052_ManagerContries_FinalUpdate/README.md) |
| 9 | **J1.S.P0054** | Quản lý danh bạ liên lạc | [`J1.S.P0054_ContactManagement`](./J1.S.P0054_ContactManagement) | Thêm liên lạc với kiểm tra format số điện thoại, hiển thị dạng bảng và xóa liên lạc theo ID. | [Xem README](./J1.S.P0054_ContactManagement/README.md) |
| 10 | **J1.S.P0055** | Quản lý bác sĩ bệnh viện | [`J1.S.P0055_DoctorManagement`](./J1.S.P0055_DoctorManagement) | Quản lý thông tin bác sĩ và chuyên khoa bằng HashMap theo mã Code (Thêm, Sửa, Xóa, Tìm kiếm). | [Xem README](./J1.S.P0055_DoctorManagement/README.md) |
| 11 | **J1.S.P0056** | Quản lý lương công nhân | [`J1.S.P0056_WorkerManagement`](./J1.S.P0056_WorkerManagement) | Thêm công nhân, tăng lương, giảm lương và theo dõi lịch sử điều chỉnh lương theo ngày tháng. | [Xem README](./J1.S.P0056_WorkerManagement/README.md) |
| 12 | **J1.S.P0057** | Quản lý tài khoản người dùng | [`J1.S.P0057_UserManagement`](./J1.S.P0057_UserManagement) | Đăng ký tài khoản mới và đăng nhập hệ thống; lưu trữ và đọc dữ liệu người dùng từ file `user.dat`. | [Xem README](./J1.S.P0057_UserManagement/README.md) |
| 13 | **J1.S.P0060** | Kiểm tra ví tiền mua sắm | [`J1.S.P0060_ShoppingBills`](./J1.S.P0060_ShoppingBills) | Nhập danh sách hóa đơn mua sắm, tính tổng chi phí và đối chiếu với số dư trong ví người mua. | [Xem README](./J1.S.P0060_ShoppingBills/README.md) |
| 14 | **J1.S.P0061** | Tính diện tích & chu vi hình học | [`J1.S.P0061_ManagerShape_FinalFixed`](./J1.S.P0061_ManagerShape_FinalFixed) | Kế thừa và đa hình với lớp trừu tượng `Shape`, tính toán cho hình chữ nhật, hình tròn, tam giác. | [Xem README](./J1.S.P0061_ManagerShape_FinalFixed/README.md) |
| 15 | **J1.S.P0063** | Sắp xếp thông tin cá nhân | [`J1.S.P0063_PersonInfo`](./J1.S.P0063_PersonInfo) | Nhập thông tin của 3 người và sắp xếp tăng dần theo mức lương, hiển thị kết quả. | [Xem README](./J1.S.P0063_PersonInfo/README.md) |
| 16 | **J1.S.P0066** | Showroom bán xe hơi | [`J1.S.P0066_CarShowroom`](./J1.S.P0066_CarShowroom) | Thẩm định giao dịch bán xe theo 4 điều kiện: tồn tại xe, bảng màu, mức giá (giảm giá màu xe), ngày bán. | [Xem README](./J1.S.P0066_CarShowroom/README.md) |
| 17 | **J1.S.P0067** | Phân tích ký tự và chữ số | [`J1.S.P0067_AnalysisString`](./J1.S.P0067_AnalysisString) | Phân tích chuỗi chuỗi hỗn hợp: trích xuất số chẵn, lẻ, chính phương; ký tự hoa, thường, đặc biệt. | [Xem README](./J1.S.P0067_AnalysisString/README.md) |
| 18 | **J1.S.P0070** | Hệ thống Ebank TPBank (i18n) | [`J1.S.P0070_TPBank`](./J1.S.P0070_TPBank) | Đăng nhập Ebank hỗ trợ song ngữ (Tiếng Việt & Tiếng Anh qua `ResourceBundle`) và sinh mã Captcha. | [Xem README](./J1.S.P0070_TPBank/README.md) |
| 19 | **J1.S.P0071** | Quản lý tiến độ công việc | [`Tổng Hợp/J1.S.P0071_TaskManager`](./Tổng%20Hợp/J1.S.P0071_TaskManager) | Quản lý tác vụ phần mềm (Code, Test, Design, Review), kiểm tra khung giờ hợp lệ và chống trùng lặp. | [Xem README](./Tổng%20Hợp/J1.S.P0071_TaskManager/README.md) |
| 20 | **J1.S.P0074** | Máy tính ma trận OOP | [`Tổng Hợp/J1.S.P0074_MatrixOOP`](./Tổng%20Hợp/J1.S.P0074_MatrixOOP) | Đóng gói thực thể Matrix, thực hiện các phép cộng, trừ và nhân ma trận với kiểm tra kích thước chặt chẽ. | [Xem README](./Tổng%20Hợp/J1.S.P0074_MatrixOOP/README.md) |

---

## 🏗️ Kiến Trúc Chung của Mỗi Bài Lab

Hầu hết các bài Lab trong dự án được tổ chức theo chuẩn kiến trúc hướng đối tượng tách bạch các tầng:
```
<Tên_Bài_Lab>/
├── src/
│   ├── entity / model:       Chứa các lớp thực thể dữ liệu (POJO, Encapsulation, Inheritance)
│   ├── management / bo:      Chứa logic nghiệp vụ cốt lõi (Business Object, Controller)
│   ├── utils / validator:    Chứa các lớp tiện ích kiểm tra dữ liệu đầu vào (Validation, Regex)
│   └── ui / main:            Chứa hàm main(), menu console và xử lý tương tác người dùng
├── nbproject/                Cấu hình NetBeans IDE
├── build.xml                 Cấu hình Apache Ant build script
└── README.md                 Tài liệu mô tả chi tiết bài lab
```

---

## 🚀 Hướng Dẫn Cài Đặt & Chạy Chương Trình

### Yêu Cầu Môi Trường
- **JDK**: Java Development Kit phiên bản 8 trở lên (Khuyến nghị JDK 8, 11 hoặc 17).
- **IDE**: NetBeans IDE (8.2 / 12 / 17+), IntelliJ IDEA, Eclipse hoặc VS Code.

###Mở Bằng NetBeans IDE 
1. Khởi động **NetBeans IDE**.
2. Chọn `File` -> `Open Project...`.
3. Trỏ tới thư mục của bài lab cần mở 
4. Nhấn **F6** (hoặc `Run Project`) để thực thi chương trình.


## 📁 Tài Liệu Bổ Sung
- Thư mục [`de bai`](./de%20bai): Chứa file `.docx` và file trích xuất `.txt` đề bài gốc của từng lab.
- Thư mục [`Tổng Hợp`](./Tổng%20Hợp): Chứa các bài tổng hợp và bộ câu hỏi ôn tập, giải thích đoạn mã khi bảo vệ đồ án/lab (`REVIEW_MAU_VA_CAU_HOI.txt`, `CAU_HOI_CHI_DOAN_CODE.txt`).
- File nén [`pass lab.zip`](./pass%20lab.zip): Tài liệu lưu trữ bổ sung.
