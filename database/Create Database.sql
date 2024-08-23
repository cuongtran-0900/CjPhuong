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
    productStatus BIT NOT NULL
);

-- Tạo bảng Bill
CREATE TABLE Bill (
    billID VARCHAR(10) PRIMARY KEY NOT NULL,
    accountID VARCHAR(10) NOT NULL,
    billTotalAmount INT NULL,
    billNote NVARCHAR(255) NULL,
    billStatus BIT NOT NULL,
	billPayment BIT NOT NULL
    createDate DATE NOT NULL
);

-- Tạo bảng BillDetail
CREATE TABLE BillDetail (
    billID VARCHAR(10) NOT NULL,
    productID VARCHAR(10) NOT NULL,
    quantity INT NOT NULL,
    totalPrice INT NOT NULL,
    PRIMARY KEY (billID, productID)
);

-- Thêm các khóa ngoại sau khi tạo bảng
ALTER TABLE Bill
ADD CONSTRAINT fk_accountID FOREIGN KEY (accountID) REFERENCES Account(accountID);

ALTER TABLE BillDetail
ADD CONSTRAINT fk_billID FOREIGN KEY (billID) REFERENCES Bill(billID);

ALTER TABLE BillDetail
ADD CONSTRAINT fk_productID FOREIGN KEY (productID) REFERENCES Product(productID);

INSERT INTO Account (accountID, accountRole,accountPass) VALUES 
('CN01', 'Sales','0123456789'),
('CN02', 'Sales','0123456789'),
('CN03', 'Sales','0123456789'),
('admin', 'Manager','0123456789');

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
INSERT INTO Bill (billID, accountID, billTotalAmount, billNote, billStatus, createDate) VALUES 
('HDA001', 'CN01', 75000, NULL, 1, '2023-08-17'),
('HDA002', 'CN01', 60000, NULL, 1, '2023-08-18');

-- Thêm dữ liệu mẫu vào bảng BillDetail
INSERT INTO BillDetail (billID, productID, quantity, totalPrice) VALUES 
('HDA001', 'MC01', 2, 50000),
('HDA001', 'MC02', 1, 25000),
('HDA002', 'MC01', 2, 50000),
('HDA002', 'MP01', 3, 10000);