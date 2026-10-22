# J1.L.P0023 - Fruit Shop System

## 1. Giới thiệu bài toán
Chương trình mô phỏng hệ thống bán trái cây của cửa hàng:
- **Tạo trái cây (Create Fruit)**: Nhập thông tin các loại trái cây mới vào kho hàng (Fruit Id, Fruit Name, Price, Quantity, Origin).
- **Xem đơn hàng (View Orders)**: Xem danh sách các đơn hàng đã được khách hàng đặt (tên khách hàng và danh sách các sản phẩm đã mua kèm tổng giá trị).
- **Mua hàng (Shopping)**: Khách hàng xem danh sách trái cây còn trong kho, chọn loại trái cây và số lượng cần mua, kiểm tra giỏ hàng, nhập tên khách hàng và hoàn tất đơn hàng.

---

## 2. Cấu trúc bài toán
```
J1.L.P0023_FruitShop/
├── src/
│   ├── entity/
│   │   ├── Fruit.java           # Thông tin mặt hàng trái cây trong kho
│   │   └── OrderItem.java       # Thông tin một mặt hàng được chọn trong giỏ hàng
│   ├── management/
│   │   └── FruitShopManager.java# Logic quản lý kho hàng và xử lý đơn hàng
│   ├── utils/
│   │   └── Validator.java       # Kiểm tra hợp lệ dữ liệu nhập
│   └── ui/
│       └── Main.java            # Giao diện menu console
├── nbproject/                   # Cấu hình dự án NetBeans
├── build.xml                    # File Ant build
└── README.md
```

---

## 3. Giải thích chi tiết các thành phần trong Code

### 3.1. `entity.Fruit`
- Thuộc tính: `fruitId` (String), `fruitName` (String), `price` (double), `quantity` (int), `origin` (String).
- Đóng vai trò là thực thể lưu trữ tồn kho của từng loại trái cây trong cửa hàng.

### 3.2. `entity.OrderItem`
- Thuộc tính: `fruitId`, `fruitName`, `quantity`, `price`.
- Phương thức `getAmount()`: Tính tổng tiền của món hàng này bằng `price * quantity`.

### 3.3. `management.FruitShopManager`
- Quản lý danh sách tồn kho `List<Fruit>` và bảng lưu các đơn hàng `Hashtable<String, ArrayList<OrderItem>>` (Key là tên khách hàng).
- Các phương thức chính:
  - `addFruit(Fruit fruit)`: Thêm một loại trái cây mới vào kho.
  - `getAvailableFruits()`: Lấy danh sách trái cây có số lượng tồn kho `> 0`.
  - `updateStock(String fruitId, int quantityBought)`: Trừ số lượng tồn kho sau khi khách chốt đơn.
  - `addOrder(String customerName, ArrayList<OrderItem> order)`: Lưu đơn hàng mới vào hệ thống.
  - `viewOrders()`: Duyệt qua bảng băm đơn hàng và in hóa đơn chi tiết cho từng khách hàng.

### 3.4. `utils.Validator`
- Kiểm tra số nguyên dương cho số lượng, số thực dương cho giá trị sản phẩm, chuỗi không rỗng và lựa chọn xác nhận `Y/N`.

### 3.5. `ui.Main`
- Chứa luồng tương tác:
  1. *Create Fruit*
  2. *View orders*
  3. *Shopping (for buyer)*
  4. *Exit*

---

## 4. Hướng dẫn chạy chương trình
1. Mở dự án trong NetBeans hoặc Java IDE.
2. Chạy file `src/ui/Main.java`.
