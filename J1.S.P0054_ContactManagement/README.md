# J1.S.P0054 - Contact Management Program

## 1. Giới thiệu bài toán
Chương trình quản lý danh bạ liên lạc cá nhân bằng Java console, cung cấp các chức năng:
- Thêm liên lạc mới (Họ và tên, Nhóm, Địa chỉ, Số điện thoại).
- Hiển thị danh sách tất cả các liên lạc hiện có dưới dạng bảng.
- Xóa liên lạc theo ID.

---

## 2. Cấu trúc bài toán
```
J1.S.P0054_ContactManagement/
├── src/
│   ├── entity/
│   │   └── Contact.java            # Thực thể đại diện cho một liên lạc
│   ├── management/
│   │   └── ContactManagement.java  # Logic thêm, hiển thị, xóa danh bạ
│   ├── utils/
│   │   └── Validator.java          # Kiểm tra định dạng số điện thoại và chuỗi nhập
│   └── ui/
│       └── Main.java               # Menu giao diện console
├── nbproject/                      # Cấu hình dự án NetBeans
├── build.xml                       # File Ant build
└── README.md
```

---

## 3. Giải thích chi tiết các thành phần trong Code

### 3.1. `entity.Contact`
- Thuộc tính:
  - `id` (int): Tự động tăng khi thêm liên lạc mới.
  - `fullName` (String): Tên đầy đủ (tách thành `firstName` và `lastName`).
  - `group` (String): Nhóm liên lạc (gia đình, bạn bè, đồng nghiệp,...).
  - `address` (String): Địa chỉ.
  - `phone` (String): Số điện thoại liên hệ.

### 3.2. `management.ContactManagement`
- Quản lý danh sách `List<Contact>`.
- `addContact(...)`: Tạo ID tự tăng, tạo đối tượng `Contact` và thêm vào danh sách.
- `displayAll()`: In toàn bộ danh bạ theo cột: `ID | Name | First Name | Last Name | Group | Address | Phone`.
- `deleteContact(int id)`: Tìm kiếm liên lạc theo `id`, xóa khỏi danh sách nếu tồn tại hoặc thông báo lỗi nếu không tìm thấy.

### 3.3. `utils.Validator`
- Kiểm tra số điện thoại hợp lệ theo các mẫu quy chuẩn (cho phép các định dạng phổ biến như: `1234567890`, `123-456-7890`, `123-456-7890 x1234`, `(123)-456-7890`).
- Kiểm tra các chuỗi nhập không rỗng.

### 3.4. `ui.Main`
- Menu:
  1. *Add a Contact*
  2. *Display all Contacts*
  3. *Delete a Contact*
  4. *Exit*

---

## 4. Hướng dẫn chạy chương trình
1. Mở dự án trong NetBeans hoặc IDE tương đương.
2. Chạy `src/ui/Main.java`.
