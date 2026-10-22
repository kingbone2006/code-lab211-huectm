# J1.S.P0060 - Shopping Bills Calculator

## 1. Giới thiệu bài toán
Chương trình tính toán tổng số tiền hóa đơn mua sắm và kiểm tra khả năng chi trả của người mua:
- Nhập danh sách các hóa đơn mua sắm của một người.
- Tính tổng chi phí của tất cả các hóa đơn.
- Nhập số tiền hiện có trong ví (Wallet) của người đó.
- So sánh số tiền trong ví với tổng hóa đơn:
  - Nếu tiền trong ví $\ge$ tổng tiền hóa đơn: Thông báo thanh toán thành công (`This person can buy it`).
  - Ngược lại: Thông báo không đủ tiền thanh toán (`This person cannot buy it`).

---

## 2. Cấu trúc bài toán
```
J1.S.P0060_ShoppingBills/
├── src/
│   ├── entity/
│   │   ├── Person.java     # Đại diện cho người mua hàng, sở hữu ví và tính toán chi trả
│   │   └── Wallet.java     # Đại diện cho ví tiền của người mua
│   ├── utils/
│   │   └── Validator.java  # Kiểm tra số nguyên dương cho hóa đơn và số tiền ví
│   └── ui/
│       └── Main.java       # Điều phối nhập hóa đơn, số tiền ví và hiển thị kết quả
├── nbproject/              # Cấu hình dự án NetBeans
├── build.xml               # File Ant build
└── README.md
```

---

## 3. Giải thích chi tiết các thành phần trong Code

### 3.1. `entity.Wallet`
- Thuộc tính: `amount` (int).
- Cung cấp getter, setter để lưu trữ số dư tài chính hiện có của người mua hàng.

### 3.2. `entity.Person`
- Thuộc tính: `bills` (mảng `int[]` hoặc `List<Integer>` chứa giá trị các hóa đơn) và `wallet` (đối tượng `Wallet`).
- Phương thức `calcTotal(int[] bills)`: Cộng dồn toàn bộ giá trị các hóa đơn để ra tổng chi phí.
- Phương thức `payMoney(int total, int amount)`: Kiểm tra logic `amount >= total` và trả về `boolean`.

### 3.3. `utils.Validator`
- Nhập số lượng hóa đơn $> 0$.
- Nhập giá trị từng hóa đơn $> 0$.
- Nhập số tiền trong ví $> 0$.

### 3.4. `ui.Main`
- In tiêu đề chương trình: `======= Shopping program =========`.
- Lần lượt nhập số lượng hóa đơn, giá trị từng hóa đơn và số tiền trong ví.
- In ra tổng tiền hóa đơn và kết luận người đó có thể mua được hay không.

---

## 4. Hướng dẫn chạy chương trình
1. Mở dự án trong NetBeans hoặc Java IDE.
2. Chạy `src/ui/Main.java`.
