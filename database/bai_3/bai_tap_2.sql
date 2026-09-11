use quan_ly_ban_hang;
INSERT INTO customers (cID, cName, cAge)
VALUES
(1, 'Minh Quan', 10),
(2, 'Ngoc Oanh', 20),
(3, 'Hong Ha', 50);
INSERT INTO orders (oID, cID, oDate, oTotalPrice)
VALUES
(1, 1, '2006-03-21', NULL),
(2, 2, '2006-03-23', NULL),
(3, 1, '2006-03-16', NULL);
INSERT INTO products (pID, pName, pPrice)
VALUES
(1, 'May Giat', 3),
(2, 'Tu Lanh', 5),
(3, 'Dieu Hoa', 7),
(4, 'Quat', 1),
(5, 'Bep Dien', 2);
INSERT INTO OrderDetail (oID, pID, odQTY)
VALUES
(1, 1, 3),
(1, 3, 7),
(1, 4, 2),
(2, 1, 1),
(3, 1, 8),
(2, 5, 4),
(2, 3, 3);
select oID, oDate, oTotalPrice from orders;
select c.cName, p.pName
from customers c
join orders o on c.cID = o.cID
join OrderDetail od on o.oID = od.oID
join products p on od.pID = p.pID;
select c.cName
from customers c
left join orders o on c.cID = o.cID
left join OrderDetail od on o.oID = od.oID
where od.oId is null;
select o.oID, o.oDate, sum(od.odQTY * p.pPrice) as oPrice
from orders o
join OrderDetail od on o.oID = od.oID
join products p on od.pID = p.pID
group by o.oID, o.oDate;