-- Tao database
create database pp;

use pp;

-- Tạo bảng Account
CREATE TABLE Account (
    accountID VARCHAR(10) PRIMARY KEY NOT NULL,
    accountRole VARCHAR(10) NOT NULL,
	accountPass NVARCHAR(20) NOT NULL
);

-- Tạo bảng Product
CREATE TABLE Product (
    productID VARCHAR(10) PRIMARY KEY NOT NULL,
    productName NVARCHAR(50) NOT NULL,
    productPrice INT NOT NULL,
	productImage NVARCHAR(50),
    productStatus BIT NOT NULL
);

-- Tạo bảng Bill
CREATE TABLE Bill (
    billID VARCHAR(10) PRIMARY KEY NOT NULL,
    accountID VARCHAR(10) NOT NULL,
    billTotalAmount INT NULL,
    billNote NVARCHAR(255) NULL,
	billPayment BIT NOT NULL,
    createDate DATE NOT NULL,
	billStatus BIT NOT NULL
);

ALTER TABLE Bill
ALTER COLUMN createDate DateTime NOT NULL;

-- Tạo bảng BillDetail
CREATE TABLE BillDetail (
    billID VARCHAR(10) NOT NULL,
    productID VARCHAR(10) NOT NULL,
    quantity INT NOT NULL,
    totalPrice INT NOT NULL,
    PRIMARY KEY (billID, productID)
);


INSERT INTO Account (accountID, accountRole,accountPass) VALUES 
('CN01', 'Sale','CN1'),
('CN02', 'Sale','CN2'),
('CN03', 'Sale','CN3'),
('NTBP', 'Manage','0765295162');

-- Thêm dữ liệu mẫu vào bảng Product
INSERT INTO Product (productID, productName, productPrice, productStatus) VALUES 
('MC01', N'Bánh cuốn', 25000, 1),
('MC02', N'Bánh ướt', 25000, 1),
('MP01', N'Bánh tôm', 4000, 1),
('MP02', N'Nem chua', 15000, 1),
('MP03', N'Chả lụa', 3000, 1),
('MP04', N'Chả chiên', 5000, 1),
('MP05', N'Chả huế', 5000, 1),
('MP06', N'Bánh ướt thêm', 5000, 1),
('MP07', N'Bánh cuốn thêm', 5000, 1),
('NU01', N'Nước sâm', 7000, 1);

-- Thêm dữ liệu mẫu vào bảng Bill
INSERT INTO Bill (billID, accountID, billTotalAmount, billNote, billStatus, createDate, billPayment) VALUES 
('HDA001', 'CN01', 75000, NULL, 1, '2024-08-26', 0),
('HDA002', 'CN01', 60000, NULL, 1, '2024-08-27',0),
('HDA003', 'CN01', 56000, NULL, 1, '2024-08-26', 1),
('HDA004', 'CN01', 50000, 'Khách hàng VIP', 1, '2024-08-27', 0),
('HDA005', 'CN01', 88000, 'Khuyến mãi đặc biệt', 1, '2024-09-01', 1),
('HDA006', 'CN01', 83000, NULL, 1, '2024-09-05', 1),
('HDA007', 'CN01', 96000, NULL, 1, '2024-09-10', 0);

-- Thêm dữ liệu mẫu vào bảng BillDetail
INSERT INTO BillDetail (billID, productID, quantity, totalPrice) VALUES 
-- Chi tiết cho hóa đơn HDA001
('HDA001', 'MC01', 2, 50000),
('HDA001', 'MC02', 1, 25000),

-- Chi tiết cho hóa đơn HDA002
('HDA002', 'MC01', 2, 50000),
('HDA002', 'MP01', 3, 10000),

-- Chi tiết cho hóa đơn HDA003
('HDA003', 'MP01', 3, 12000),
('HDA003', 'MP02', 2, 30000),
('HDA003', 'NU01', 2, 14000),

-- Chi tiết cho hóa đơn HDA004
('HDA004', 'MC01', 1, 25000),
('HDA004', 'MP03', 5, 15000),
('HDA004', 'MP04', 2, 10000),

-- Chi tiết cho hóa đơn HDA005
('HDA005', 'MC02', 2, 50000),
('HDA005', 'MP06', 3, 15000),
('HDA005', 'NU01', 3, 21000),

-- Chi tiết cho hóa đơn HDA006
('HDA006', 'MP05', 4, 12000),
('HDA006', 'MC01', 2, 50000),
('HDA006', 'MP02', 1, 25000),

-- Chi tiết cho hóa đơn HDA007
('HDA007', 'MP01', 2, 8000),
('HDA007', 'MC02', 3, 75000),
('HDA007', 'NU01', 1, 7000);


-- Thêm các khóa ngoại sau khi tạo bảng
ALTER TABLE Bill
ADD CONSTRAINT fk_accountID FOREIGN KEY (accountID) REFERENCES Account(accountID);

ALTER TABLE BillDetail
ADD CONSTRAINT fk_billID FOREIGN KEY (billID) REFERENCES Bill(billID);

ALTER TABLE BillDetail
ADD CONSTRAINT fk_productID FOREIGN KEY (productID) REFERENCES Product(productID);
