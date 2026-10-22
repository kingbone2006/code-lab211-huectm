# J1.S.P0066 - Car Showroom Management System

## 1. Giới thiệu bài toán
Chương trình mô phỏng quy trình bán xe tại một Showroom ô tô với các điều kiện nghiệp vụ kiểm tra chặt chẽ:
- Kiểm tra xem xe yêu cầu có tồn tại trong showroom hay không (AUDI, MERCEDES, BMW,...).
- Kiểm tra màu sắc xe yêu cầu có phù hợp với danh sách màu của xe đó hay không (trường hợp chọn "NO COLOR" sẽ được giảm $100).
- Kiểm tra mức giá đưa ra có khớp với bảng giá niêm yết (hoặc giá đã trừ $100 cho xe không sơn).
- Kiểm tra ngày bán hiện tại (thứ trong tuần: Monday, Tuesday,...) có thuộc ngày showroom mở bán dòng xe đó hay không.

Nếu thỏa mãn tất cả các điều kiện, giao dịch bán xe thành công; nếu vi phạm điều kiện nào, chương trình sẽ thông báo chính xác lý do vi phạm.

---

## 2. Cấu trúc bài toán
```
J1.S.P0066_CarShowroom/
├── src/
│   ├── model/
│   │   ├── Car.java             # Thực thể xe với danh sách màu, mức giá và ngày bán cho phép
│   │   ├── CarRequest.java      # Yêu cầu mua xe từ khách hàng (tên xe, màu, giá, ngày mua)
│   │   └── ShowroomService.java # Dịch vụ kiểm tra và xác thực giao dịch bán xe
│   ├── utils/
│   │   └── Validator.java       # Kiểm tra hợp lệ dữ liệu nhập từ bàn phím
│   └── ui/
│       └── Main.java            # Khởi tạo dữ liệu showroom, nhận yêu cầu và xử lý bán xe
├── nbproject/                   # Cấu hình dự án NetBeans
├── build.xml                    # File Ant build
└── README.md
```

---

## 3. Giải thích chi tiết các thành phần trong Code

### 3.1. `model.Car`
- Thuộc tính:
  - `name` (String): Tên dòng xe (AUDI, MERCEDES, BMW...).
  - `prices` (List/Array int): Các mức giá niêm yết.
  - `colors` (List/Array String): Các màu sắc có sẵn (WHITE, YELLOW, ORANGE, NO COLOR...).
  - `soldDays` (List/Array String): Các thứ trong tuần được phép bán.

### 3.2. `model.CarRequest`
- Chứa các thông tin do khách hàng nhập vào:
  - `name`: Tên xe muốn mua.
  - `color`: Màu sắc lựa chọn.
  - `price`: Mức giá thỏa thuận.
  - `today`: Ngày mua xe trong tuần.

### 3.3. `model.ShowroomService`
- Phương thức trọng tâm `checkSell(CarRequest request)` kiểm tra theo 4 bước tuần tự:
  1. **Xe tồn tại**: Kiểm tra `name` có trong showroom không. Nếu không, trả về `"Car break"`.
  2. **Màu sắc**: Kiểm tra `color` có nằm trong danh mục màu của dòng xe đó không. Nếu không, trả về `"Color Car does not exist"`.
  3. **Mức giá**: Đối chiếu `price` với danh sách giá. Nếu khách chọn xe không sơn (`NO COLOR`), mức giá cho phép là `price - 100`. Nếu sai giá, trả về `"Price Car does not exist"`.
  4. **Ngày bán**: Kiểm tra `today` có nằm trong `soldDays` không. Nếu không, trả về `"Car can't sell today"`.
  5. Nếu vượt qua cả 4 bước, trả về `null` (thành công - `Sell Car Successful`).

### 3.4. `utils.Validator` & `ui.Main`
- Nhập thông tin xe từ console, gọi `ShowroomService.checkSell(...)` và hiển thị kết quả.

---

## 4. Hướng dẫn chạy chương trình
1. Mở dự án trong NetBeans hoặc Java IDE.
2. Chạy `src/ui/Main.java`.
