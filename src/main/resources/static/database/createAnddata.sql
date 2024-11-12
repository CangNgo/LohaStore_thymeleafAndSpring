
CREATE TABLE Taikhoan (
    ID INT AUTO_INCREMENT PRIMARY KEY, 
    Taikhoan VARCHAR(30) NOT NULL, 
    MATKHAU VARCHAR(50) NOT NULL, 
    VAITRO TINYINT DEFAULT 1
);

-- Create Khachhang table
CREATE TABLE Khachhang (
    ID_Khachhang INT AUTO_INCREMENT PRIMARY KEY,
    ID_Taikhoan INT NOT NULL,
    HoTen VARCHAR(100) NOT NULL,
    Email VARCHAR(100) UNIQUE,
    SoDienThoai VARCHAR(20),
    DiaChi VARCHAR(255),
    NgaySinh DATE,
    NgayDangKy TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (ID_Taikhoan) REFERENCES Taikhoan (ID)
);

-- Create LoaiSanpham table
CREATE TABLE LoaiSanpham (
    ID_LoaiSanpham INT AUTO_INCREMENT PRIMARY KEY,
    TenLoai VARCHAR(100) NOT NULL,
    MoTa VARCHAR(255)
);

-- Create Sanpham table
CREATE TABLE Sanpham (
    ID_Sanpham INT AUTO_INCREMENT PRIMARY KEY,
    ID_LoaiSanpham INT,
    TenSanpham VARCHAR(100) NOT NULL,
    MoTa VARCHAR(255),
    Gia DECIMAL(10, 2) NOT NULL,
    SoLuongTonKho INT NOT NULL,
    HinhAnh VARCHAR(255),
    FOREIGN KEY (ID_LoaiSanpham) REFERENCES LoaiSanpham(ID_LoaiSanpham)
);

-- Create Giohang table
CREATE TABLE Giohang (
  ID_Giohang INT AUTO_INCREMENT PRIMARY KEY,
  ID_Khachhang INT,
  NgayTao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  TrangThai VARCHAR(50),
  FOREIGN KEY (ID_Khachhang) REFERENCES Khachhang(ID_Khachhang)
);

-- Create ChitietGiohang table
CREATE TABLE ChitietGiohang (
  ID_ChitietGiohang INT AUTO_INCREMENT PRIMARY KEY,
  ID_Giohang INT,
  ID_Sanpham INT,
  SoLuong INT NOT NULL,
  GiaTaiThoiDiemThem DECIMAL(10,2),
  FOREIGN KEY (ID_Giohang) REFERENCES Giohang(ID_Giohang),
  FOREIGN KEY (ID_Sanpham) REFERENCES Sanpham(ID_Sanpham)
);

-- Create Donhang table
CREATE TABLE Donhang (
    ID_Donhang INT AUTO_INCREMENT PRIMARY KEY,
    ID_Khachhang INT,
    NgayDatHang TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    TongTien DECIMAL(10, 2) NOT NULL,
    TrangThaiDonhang VARCHAR(50),
    DiaChiGiaoHang VARCHAR(255),
    PhuongThucThanhToan VARCHAR(100),
    FOREIGN KEY (ID_Khachhang) REFERENCES Khachhang(ID_Khachhang)
);

-- Create ChitietDonhang table
CREATE TABLE ChitietDonhang (
    ID_ChitietDonhang INT AUTO_INCREMENT PRIMARY KEY,
    ID_Donhang INT,
    ID_Sanpham INT,
    SoLuong INT NOT NULL,
    GiaTaiThoiDiemMua DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (ID_Donhang) REFERENCES Donhang(ID_Donhang),
    FOREIGN KEY (ID_Sanpham) REFERENCES Sanpham(ID_Sanpham)
);

-- Insert data into LoaiSanpham
INSERT INTO LoaiSanpham (TenLoai, MoTa)
VALUES 
('hoalen', 'Hoa làm từ len'),
('mockhoa', 'Móc khóa làm từ len');

-- Insert data into Sanpham



INSERT INTO Sanpham (ID_LoaiSanpham, TenSanpham, MoTa, Gia, SoLuongTonKho, HinhAnh)
VALUES 
-- Sản phẩm loại hoalen
(1, N'Cúc họa mi', N'Hoa cúc họa mi làm từ len', 50000, 100, 'cuchoami.jpg'),
(1, N'Hoa cúc', N'Hoa cúc làm từ len', 50000, 100, 'hoacuc.jpg'),
(1, N'Hoa đôi xanh', N'Hoa đôi xanh làm từ len', 50000, 100, 'hoadoixanh.png'),
(1, N'Hoa hồng', N'Hoa hồng làm từ len', 50000, 100, 'hoahong.jpg'),
(1, N'Hoa hồng nhỏ', N'Hoa hồng nhỏ làm từ len', 50000, 100, 'hoahongnho.jpg'),
(1, N'Hoa lưu ly', N'Hoa lưu ly làm từ len', 50000, 100, 'HOALUULY.jpg'),
(1, N'Hoa Tulip', N'Hoa Tulip làm từ len', 50000, 100, 'HOATLIPCANH.jpg'),
(1, N'Hoa hồng trắng', N'Hoa hồng trắng làm từ len', 50000, 100, 'hongtrang.jpg'),
(1, N'Hoa hướng dương', N'Hoa hướng dương làm từ len', 50000, 100, 'huongduong.webp'),
(1, N'Hoa Lavender', N'Hoa Lavender làm từ len', 50000, 100, 'lavender.jpg'),
(1, N'Hoa hồng ghép cạnh', N'Hoa hồng ghép cạnh làm từ len', 50000, 100, 'HOAHONGGHEPCANH.jpg'),
(1, N'Hoa Tulip có cánh', N'Hoa Tulip có cánh làm từ len', 50000, 100, 'HOATULIPCOCANH.jpg'),
(1, N'Cành hoa nhỏ', N'Cành hoa nhỏ làm từ len', 50000, 100, 'sg-11134201-23020-sf0x8fu25env02.jpg')
;
INSERT INTO Sanpham (ID_LoaiSanpham, TenSanpham, MoTa, Gia, SoLuongTonKho, HinhAnh)
VALUES 
-- Sản phẩm loại mockhoa
(2, N'Bơ len', N'Móc khóa hình bơ làm từ len', 50000, 100, 'bo.jpg'),
(2, N'Móc khóa cá heo', N'Móc khóa hình cá heo làm từ len', 50000, 100, 'dangnhap.jpg'),
(2, N'Dưa hấu len', N'Móc khóa hình dưa hấu làm từ len', 50000, 100, 'duahau.jpg'),
(2, N'Heo len', N'Móc khóa hình heo làm từ len', 50000, 100, 'heo.jpg'),
(2, N'Móc treo hình hoa', N'Móc treo hình hoa làm từ len', 50000, 100, 'images.jpg'),
(2, N'Hoa hồng', N'Móc khóa hình hoa hồng làm từ len', 50000, 100, 'hoahong.jpg'),
(2, N'Vịt len đội mũ', N'Móc khóa hình vịt đội mũ làm từ len', 50000, 100, 'VITLENDOIMU.jpg');
;
-- Insert data into Taikhoan
INSERT INTO Taikhoan (Taikhoan, MATKHAU, VAITRO)
VALUES 
('nguyenvana', 'password123', 1),
('tranthib', 'password456', 1),
('levanc', 'password789', 1);

-- Insert data into Khachhang
INSERT INTO Khachhang (ID_Taikhoan, HoTen, Email, SoDienThoai, DiaChi)
VALUES 
(1, 'Nguyễn Văn A', 'nguyenvana@email.com', '0123456789', 'Hà Nội'),
(2, 'Trần Thị B', 'tranthib@email.com', '0987654321', 'Hồ Chí Minh'),
(3, 'Lê Văn C', 'levanc@email.com', '0369852147', 'Đà Nẵng');

-- Insert sample data into Giohang
INSERT INTO Giohang (ID_Khachhang, TrangThai)
VALUES 
    (1, 'Chờ xử lý'),         -- Giỏ hàng của Nguyễn Văn A, đang chờ xử lý
    (2, 'Đã thanh toán'),      -- Giỏ hàng của Trần Thị B, đã thanh toán
    (3, 'Đã hủy');             -- Giỏ hàng của Lê Văn C, đã hủy

-- Insert sample data into ChitietGiohang
INSERT INTO ChitietGiohang (ID_Giohang, ID_Sanpham, SoLuong, GiaTaiThoiDiemThem)
VALUES 
    (1, 1, 2, 50000),          -- Nguyễn Văn A thêm 2 sản phẩm "Cúc họa mi" vào giỏ hàng với giá 50,000
    (1, 2, 1, 50000),          -- Nguyễn Văn A thêm 1 sản phẩm "Hoa cúc" vào giỏ hàng với giá 50,000
    (2, 3, 3, 50000),          -- Trần Thị B thêm 3 sản phẩm "Hoa đôi xanh" vào giỏ hàng với giá 50,000
    (2, 4, 1, 50000),          -- Trần Thị B thêm 1 sản phẩm "Hoa hồng" vào giỏ hàng với giá 50,000
    (3, 5, 2, 50000);          -- Lê Văn C thêm 2 sản phẩm "Hoa hồng nhỏ" vào giỏ hàng với giá 50,000

-- Insert sample data into Donhang
INSERT INTO Donhang (ID_Khachhang, TongTien, TrangThaiDonhang, DiaChiGiaoHang, PhuongThucThanhToan)
VALUES 
    (1, 150000, 'Đang xử lý', 'Hà Nội', 'COD'),                    -- Đơn hàng của Nguyễn Văn A, đang xử lý, thanh toán COD
    (2, 200000, 'Hoàn thành', 'Hồ Chí Minh', 'Chuyển khoản'),      -- Đơn hàng của Trần Thị B, hoàn thành, thanh toán chuyển khoản
    (3, 100000, 'Đã hủy', 'Đà Nẵng', 'Thẻ tín dụng');              -- Đơn hàng của Lê Văn C, đã hủy, thanh toán thẻ tín dụng

-- Insert sample data into ChitietDonhang
INSERT INTO ChitietDonhang (ID_Donhang, ID_Sanpham, SoLuong, GiaTaiThoiDiemMua)
VALUES 
    (1, 1, 2, 50000),          -- Nguyễn Văn A mua 2 sản phẩm "Cúc họa mi" với giá 50,000 mỗi sản phẩm
    (1, 2, 1, 50000),          -- Nguyễn Văn A mua 1 sản phẩm "Hoa cúc" với giá 50,000 mỗi sản phẩm
    (2, 3, 3, 50000),          -- Trần Thị B mua 3 sản phẩm "Hoa đôi xanh" với giá 50,000 mỗi sản phẩm
    (2, 4, 1, 50000),          -- Trần Thị B mua 1 sản phẩm "Hoa hồng" với giá 50,000 mỗi sản phẩm
    (3, 5, 2, 50000);          -- Lê Văn C mua 2 sản phẩm "Hoa hồng nhỏ" với giá 50,000 mỗi sản phẩm
