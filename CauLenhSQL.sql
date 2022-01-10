CREATE DATABASE DoAn3
USE DoAn3

DROP database DoAn3

CREATE TABLE NhanVienCH1
(
	MaNV char(7) NOT NULL,
	HoTen nvarchar(20) NOT NULL, 
	Email nvarchar(40) NULL,
	SoDT int NULL,
	GioiTinh nchar(3) NOT NULL,
	DiaChi nvarchar(20) NULL,
	NgaySinh date NOT NULL,
	NgayVaoLam date NOT NULL,
	CONSTRAINT PK_NhanVienCH1 PRIMARY KEY(MaNV),
	Username varchar(20) null,   
	Password varchar(20) NULL,
)

CREATE TABLE NhanVienCH2
(
	MaNV char(7) NOT NULL,
	HoTen nvarchar(20) NOT NULL, 
	Email nvarchar(40) NULL,
	SoDT int NULL,
	GioiTinh nchar(3) NOT NULL,
	DiaChi nvarchar(20) NULL,
	NgaySinh date NOT NULL,
	NgayVaoLam date NOT NULL,
	CONSTRAINT PK_NhanVienCH2 PRIMARY KEY(MaNV),
	Username varchar(20) null,   
	Password varchar(20) NULL,
)
CREATE TABLE NhanVienTT
(
	MaNV char(7) NOT NULL,
	HoTen nvarchar(20) NOT NULL, 
	Email nvarchar(40) NULL,
	SoDT int NULL,
	GioiTinh nchar(3) NOT NULL,
	DiaChi nvarchar(20) NULL,
	NgaySinh date NOT NULL,
	NgayVaoLam date NOT NULL,
	CONSTRAINT PK_NhanVienTT PRIMARY KEY(MaNV),
	Username varchar(20) null,   
	Password varchar(20) NULL,
)

CREATE TABLE SanPhamCH1
(
	MaDT char(7) NOT NULL,
	TenDT nvarchar(20) NOT NULL, 
	NhaCungCap nvarchar(20) NOT NULL,
	NgayNhap date NOT NULL,
	SoLuong int NOT NULL,
	DonGia money NOT NULL,
	GiaBan money NOT NULL,

	CONSTRAINT PK_SanPham PRIMARY KEY(MaDT)
)

CREATE TABLE SanPhamCH2
(
	MaDT char(7) NOT NULL,
	TenDT nvarchar(20) NOT NULL, 
	NhaCungCap nvarchar(20) NOT NULL,
	NgayNhap date NOT NULL,
	SoLuong int NOT NULL,
	DonGia money NOT NULL,
	GiaBan money NOT NULL,

	CONSTRAINT PK_SanPhamCH2 PRIMARY KEY(MaDT)
)

CREATE TABLE SanPhamTT
(
	MaDT char(7) NOT NULL,
	TenDT nvarchar(20) NOT NULL, 
	NhaCungCap nvarchar(20) NOT NULL,
	NgayNhap date NOT NULL,
	SoLuong int NOT NULL,
	DonGia money NOT NULL,
	GiaBan money NOT NULL,

	CONSTRAINT PK_SanPhamTT PRIMARY KEY(MaDT)
)

CREATE TABLE KhachHang
(
	CMND char(9) NOT NULL,
	HoTen nvarchar(20) NOT NULL, 
	CONSTRAINT PK_KhachHang PRIMARY KEY(CMND),
)
DROP table donhangch1
CREATE TABLE DonHangCH1
(
	MaDH char(7) PRIMARY KEY,
	MaNV char(7),
	CMND char(9),  
	MaDT char(7),
	SoLuong int, 	
	Ngay date,
	ThanhTien money
)
CREATE TABLE DonHangCH2
(
	MaDH char(7) PRIMARY KEY,
	MaNV char(7),
	CMND char(9),  
	MaDT char(7),
	SoLuong int, 	
	Ngay date,
	ThanhTien money
)

CREATE TABLE DonHangTT
(
	MaDH char(7) PRIMARY KEY,
	MaNV char(7),
	CMND char(9),  
	MaDT char(7),
	SoLuong int, 	
	Ngay date,
	ThanhTien money
)
--Khoa ngoai Nhan vien
ALTER TABLE DonHangCH1 ADD CONSTRAINT FK_DH_NV FOREIGN KEY(MaNV)
REFERENCES NhanVienCH1(MaNV) ON DELETE SET NULL ON UPDATE CASCADE

ALTER TABLE DonHangCH2 ADD CONSTRAINT FK_DH_NV2 FOREIGN KEY(MaNV)
REFERENCES NhanVienCH2(MaNV) ON DELETE SET NULL ON UPDATE CASCADE

ALTER TABLE DonHangTT ADD CONSTRAINT FK_DH_NVTT FOREIGN KEY(MaNV)
REFERENCES NhanVienTT(MaNV) ON DELETE SET NULL ON UPDATE CASCADE

--Khoa ngoai San pham
ALTER TABLE DonHangCH1 ADD CONSTRAINT FK_DH_SP1 FOREIGN KEY(MaDT)
REFERENCES SanPhamCH1(MaDT) 
ON DELETE SET NULL ON UPDATE CASCADE

ALTER TABLE DonHangCH2 ADD CONSTRAINT FK_DH_SP2 FOREIGN KEY(MaDT)
REFERENCES SanPhamCH2(MaDT) 
ON DELETE SET NULL ON UPDATE CASCADE

ALTER TABLE DonHangTT ADD CONSTRAINT FK_DH_SPTT FOREIGN KEY(MaDT)
REFERENCES SanPhamTT(MaDT) ON DELETE SET NULL 
ON UPDATE CASCADE

--Khoa ngoai Khach hang
ALTER TABLE DonHangCH1 ADD CONSTRAINT FK_DH1_KH FOREIGN KEY(CMND)
REFERENCES KhachHang(CMND) 
ON DELETE SET NULL 
ON UPDATE CASCADE

ALTER TABLE DonHangCH2 ADD CONSTRAINT FK_DH2_KH FOREIGN KEY(CMND)
REFERENCES KhachHang(CMND) 
ON DELETE SET NULL 
ON UPDATE CASCADE

ALTER TABLE DonHangTT ADD CONSTRAINT FK_DHTT_KH FOREIGN KEY(CMND)
REFERENCES KhachHang(CMND) 
ON DELETE SET NULL 
ON UPDATE CASCADE

