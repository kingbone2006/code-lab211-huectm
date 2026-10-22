# J1.S.P0057 - User Management System

## 1. Giới thiệu bài toán
Chương trình quản lý tài khoản người dùng với chức năng tạo mới tài khoản và đăng nhập, dữ liệu tài khoản được lưu trữ bền vững vào file `user.dat`:
- **Create a new account**:
  - Tên đăng nhập (Username): Tối thiểu 5 ký tự và không chứa khoảng trắng. Không được trùng với tài khoản đã tồn tại.
  - Mật khẩu (Password): Tối thiểu 6 ký tự và không chứa khoảng trắng.
- **Login system**:
  - Nhập username và password, kiểm tra đối chiếu với dữ liệu đã lưu trong file `user.dat`. Báo thành công nếu đúng hoặc thất bại nếu sai thông tin.

---

## 2. Cấu trúc bài toán
```
J1.S.P0057_UserManagement/
├── user.dat                   # File nhị phân/văn bản lưu trữ danh sách tài khoản
├── src/
│   ├── entity/
│   │   └── Account.java       # Đối tượng tài khoản (username, password)
│   ├── management/
│   │   └── UserManager.java   # Logic đọc/ghi file và xác thực đăng ký/đăng nhập
│   ├── utils/
│   │   └── Validator.java     # Kiểm tra quy tắc đặt tên đăng nhập và mật khẩu
│   └── ui/
│       └── Main.java          # Menu điều hướng chương trình
├── nbproject/                 # Cấu hình dự án NetBeans
├── build.xml                  # File Ant build
└── README.md
```

---

## 3. Giải thích chi tiết các thành phần trong Code

### 3.1. `entity.Account`
- Cài đặt `Serializable` (nếu dùng Object Stream) hoặc hỗ trợ chuyển đổi chuỗi định dạng (nếu dùng file text).
- Thuộc tính: `username` (String), `password` (String).

### 3.2. `management.UserManager`
- `loadUsers()`: Đọc danh sách tài khoản từ file `user.dat` khi khởi động chương trình.
- `saveUser(Account account)`: Ghi bổ sung hoặc lưu toàn bộ danh sách tài khoản vào `user.dat`.
- `createNewAccount(String username, String password)`: Kiểm tra tài khoản đã tồn tại hay chưa, nếu chưa thì thêm mới và lưu xuống file.
- `login(String username, String password)`: Duyệt danh sách tìm tài khoản khớp cả username và password.

### 3.3. `utils.Validator`
- `checkUsername(String username)`: Độ dài >= 5, không chứa ký tự khoảng cách (`\\S{5,}`).
- `checkPassword(String password)`: Độ dài >= 6, không chứa khoảng cách (`\\S{6,}`).

### 3.4. `ui.Main`
- Menu:
  1. *Create a new account*
  2. *Login system*
  3. *Exit*

---

## 4. Hướng dẫn chạy chương trình
1. Mở dự án trong NetBeans hoặc Java IDE.
2. Chạy `src/ui/Main.java`.
