# J1.S.P0052 - Geographic East Asia Countries Management

## 1. Giới thiệu bài toán
Chương trình quản lý thông tin các quốc gia thuộc khu vực Đông Á (East Asia), bao gồm:
- Thêm thông tin quốc gia (Mã quốc gia, Tên quốc gia, Diện tích tổng, Địa hình). Giới hạn tối đa 11 quốc gia Đông Á.
- Hiển thị thông tin quốc gia vừa nhập gần nhất.
- Tìm kiếm thông tin quốc gia theo tên.
- Sắp xếp thông tin các quốc gia theo thứ tự bảng chữ cái tên quốc gia tăng dần.

---

## 2. Cấu trúc bài toán
```
J1.S.P0052_ManagerContries_FinalUpdate/
├── src/
│   ├── model/
│   │   ├── Country.java                 # Lớp cha chứa thông tin quốc gia cơ bản
│   │   └── EastAsiaCountries.java       # Lớp con kế thừa Country bổ sung thuộc tính địa hình
│   ├── management/
│   │   └── ManageEastAsiaCountries.java # Nghiệp vụ thêm, tìm kiếm, sắp xếp quốc gia
│   ├── utils/
│   │   └── Validator.java               # Kiểm tra hợp lệ dữ liệu nhập
│   └── main/
│       └── Main.java                    # Menu điều hướng chương trình
├── nbproject/                           # Cấu hình dự án NetBeans
├── build.xml                            # File Ant build
└── README.md
```

---

## 3. Giải thích chi tiết các thành phần trong Code

### 3.1. `model.Country`
- Thuộc tính cơ sở:
  - `countryCode` (String)
  - `countryName` (String)
  - `totalArea` (float/double)
- Cung cấp getter, setter và phương thức hiển thị cơ bản `display()`.

### 3.2. `model.EastAsiaCountries`
- Kế thừa từ `Country`.
- Bổ sung thuộc tính `countryTerrain` (String) mô tả đặc điểm địa hình.
- Cài đặt phương thức `display()` hiển thị dạng bảng: Mã, Tên, Diện tích, Địa hình.

### 3.3. `management.ManageEastAsiaCountries`
- Lưu trữ danh sách `List<EastAsiaCountries>`.
- Các hàm nghiệp vụ chính:
  - `addCountryInformation(EastAsiaCountries country)`: Thêm quốc gia mới, kiểm tra trùng lặp mã quốc gia và giới hạn tối đa 11 nước.
  - `getRecentlyEnteredInformation()`: Trả về phần tử cuối cùng vừa được thêm vào.
  - `searchInformationByName(String name)`: Tìm kiếm quốc gia theo tên (chứa từ khóa tìm kiếm).
  - `sortInformationByAscendingOrder()`: Sắp xếp danh sách theo tên quốc gia tăng dần bằng `Collections.sort()` với `Comparator`.

### 3.4. `utils.Validator`
- Kiểm tra mã nước không rỗng, diện tích phải là số thực lớn hơn 0.
- Kiểm tra trùng mã quốc gia trước khi thêm.

### 3.5. `main.Main`
- Menu:
  1. *Input the information of 11 countries in East Asia*
  2. *Display the information of country you've just received*
  3. *Search the information of country by user-entered name*
  4. *Display the information of countries sorted name in ascending order*
  5. *Exit*

---

## 4. Hướng dẫn chạy chương trình
1. Mở dự án trong NetBeans hoặc Java IDE.
2. Chạy `src/main/Main.java`.
