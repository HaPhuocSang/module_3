create database if not exists quan_ly_ban_hang;
use quan_ly_ban_hang;
create table customers(
	cID int auto_increment primary key,
    cName varchar(50),
    cAge int
);
create table orders(
	oID int auto_increment primary key,
    cID int,
    oDate date,
    oTotalPrice double,
    foreign key (cID) references customers(cID)
);
create table products(
	pID int auto_increment primary key,
    pName varchar(50),
    pPrice double
);
create table OrderDetail(
	oID int,
    pID int,
    primary key(oID,pID),
    odQTY int,
    foreign key (oID) references orders(oID),
    foreign key (pID) references products(pID)
);
