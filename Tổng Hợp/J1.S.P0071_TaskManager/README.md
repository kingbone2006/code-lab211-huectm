# J1.S.P0071 - Task Management Program

## 1. Giới thiệu bài toán
Chương trình quản lý danh sách công việc (Task Program) trong dự án phần mềm với các chức năng:
- **Thêm công việc (Add Task)**:
  - Task Type: 1 (Code), 2 (Test), 3 (Design), 4 (Review).
  - Tên yêu cầu (Requirement Name).
  - Ngày thực hiện (Date định dạng `dd-MM-yyyy`).
  - Thời gian bắt đầu và kết thúc (Plan From, Plan To nằm trong khung giờ làm việc: 8.0 đến 17.5 và Plan From < Plan To).
  - Người được giao (Assignee) và Người đánh giá (Reviewer).
  - Kiểm tra không trùng lặp công việc đã có.
- **Xóa công việc (Delete Task)**: Xóa theo ID công việc.
- **Hiển thị dữ liệu công việc (Get Task Data)**: Hiển thị bảng toàn bộ danh sách công việc.

---

## 2. Cấu trúc bài toán
```
J1.S.P0071_TaskManager/
├── src/
│   ├── entity/
│   │   ├── Task.java            # Thực thể đại diện cho một công việc
│   │   └── TaskType.java        # Enum/Class loại công việc (Code, Test, Design, Review)
│   ├── controller/
│   │   └── ManagerTask.java     # Quản lý danh sách, thêm, xóa và kiểm tra trùng lặp
│   ├── utils/
│   │   └── Validator.java       # Kiểm tra hợp lệ thời gian (8.0-17.5), định dạng ngày
│   └── ui/
│       └── Main.java            # Menu điều hướng chương trình
├── nbproject/                   # Cấu hình dự án NetBeans
├── build.xml                    # File Ant build
└── README.md
```

---

## 3. Giải thích chi tiết các thành phần trong Code

### 3.1. `entity.TaskType` & `entity.Task`
- `TaskType`: Có ID từ 1 đến 4 đại diện cho `Code`, `Test`, `Design`, `Review`.
- `Task`:
  - `id`: Tự động tăng.
  - `taskType`: Đối tượng `TaskType`.
  - `requirementName`: Tên tác vụ.
  - `date`: Ngày thực hiện.
  - `planFrom`, `planTo`: Khung giờ dự kiến (kiểu số thực, ví dụ: 8.5 tương ứng 8h30).
  - `assign`: Người thực hiện.
  - `reviewer`: Người kiểm tra.

### 3.2. `controller.ManagerTask`
- `ArrayList<Task> list`: Danh sách các công việc.
- `addTask(...)`: Tạo ID tự tăng, khởi tạo `Task`, kiểm tra hàm `isExisted()` để tránh trùng lặp trước khi thêm vào danh sách.
- `deleteTask(int id)`: Tìm kiếm công việc theo `id`, xóa khỏi danh sách nếu tìm thấy.
- `getList()`: Trả về bản sao danh sách công việc để hiển thị.

### 3.3. `utils.Validator`
- `checkDate()`: Kiểm tra định dạng ngày `dd-MM-yyyy` và ngày phải tồn tại trong thực tế.
- `checkPlanFromTo()`: Đảm bảo giờ nằm trong đoạn $[8.0, 17.5]$ và `planFrom < planTo`.

### 3.4. `ui.Main`
- Menu:
  1. *Add Task*
  2. *Delete Task*
  3. *Display Task*
  4. *Exit*

---

## 4. Hướng dẫn chạy chương trình
1. Mở dự án trong NetBeans hoặc Java IDE.
2. Chạy `src/ui/Main.java`.
