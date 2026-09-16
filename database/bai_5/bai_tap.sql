create database if not exists demo_1;
USE demo_1;
CREATE TABLE products (
    Id int auto_increment primary key,
    productCode varchar(50),
    productName varchar(100),
    productPrice double,
    productAmount int,
    productDescription varchar(255),
    productStatus varchar(50)
);
insert into products (productCode, productName, productPrice, productAmount, productDescription, productStatus)
value
('P001', 'Laptop Dell', 15000000, 10, 'Laptop Dell Core i5', 'Còn hàng'),
('P002', 'Laptop HP', 14000000, 15, 'Laptop HP Core i5', 'Còn hàng'),
('P003', 'Chuột Logitech', 500000, 50, 'Chuột không dây', 'Còn hàng'),
('P004', 'Bàn phím cơ', 1200000, 20, 'Bàn phím gaming', 'Còn hàng'),
('P005', 'Màn hình Samsung', 5000000, 8, 'Màn hình 24 inch', 'Hết hàng'),
('P006', 'Tai nghe Sony', 2000000, 25, 'Tai nghe Bluetooth', 'Còn hàng');
create index i_product_code on products(productCode);
create index i_product_name_product_price on products(productName, productPrice);
drop index i_product_name_product_price on products;
explain select * from products where productName = 'Laptop Dell' and productPrice = 15000000;
create view product_view as (select productCode, productName, productPrice, productStatus from products);
select * from product_view;
update product_view set productStatus = 'Hết hàng' WHERE productName = 'Tai nghe Sony';
drop view product_view;
DELIMITER //
CREATE PROCEDURE getAllProducts()
BEGIN
  select * from products;
END //
DELIMITER ;
CALL getAllProducts();
DELIMITER //

CREATE PROCEDURE addProduct(in p_productCode varchar(50), in p_productName varchar(100), in p_productPrice double, in p_productAmount int, in p_productDescription varchar(255), in p_productStatus varchar(50))
BEGIN
    insert into Products (productCode,  productName, productPrice, productAmount, productDescription, productStatus)
    value 
    (p_productCode, p_productName, p_productPrice, p_productAmount, p_productDescription, p_productStatus);
END //
DELIMITER ;
CALL addProduct( 'P007', 'Webcam Logitech', 1500000, 12, 'Webcam Full HD', 'Còn hàng');
DELIMITER //
CREATE PROCEDURE updateProduct(in p_id int, in p_productCode varchar(50), in p_productName varchar(100), in p_productPrice double, in p_productAmount int, in p_productDescription varchar(255), in p_productStatus varchar(50))
BEGIN
    update Products
    set
        productCode = p_productCode,
        productName = p_productName,
        productPrice = p_productPrice,
        productAmount = p_productAmount,
        productDescription = p_productDescription,
        productStatus = p_productStatus
    where Id = p_id;
END //
DELIMITER ;
CALL updateProduct(1, 'P001', 'Laptop Dell Updated', 16000000, 20, 'Laptop Dell Core i7', 'Còn hàng');
DELIMITER //
CREATE PROCEDURE deleteProduct(
    IN p_id INT
)
BEGIN
    delete from products where Id = p_id;
END //
DELIMITER ;
CALL deleteProduct(7);