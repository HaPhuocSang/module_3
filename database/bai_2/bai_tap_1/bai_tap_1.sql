create database if not exists product_management;
use product_management;
create table suppliers(
	MaNCC int auto_increment primary key,
    TenNCC varchar(50),
    DiaChi varchar (100)
);
create table phonenumbers(
	SDT varchar(10) primary key,
    MaNCC int,
    foreign key(MaNCC) references suppliers(MaNCC)
);
create table numerous_orders(
	SoDH int auto_increment primary key,
    NgayDH date,
    MaNCC int,
    foreign key(MaNCC) references suppliers(MaNCC)
);
create table supplies(
	MaVTU int auto_increment primary key,
    TenVTU varchar(50)
);
create table numerous_orders_supplies(
	SoDH int,
    MaVTU int,
    primary key(SoDH,MaVTU),
    foreign key(SoDH) references numerous_orders(SoDH),
    foreign key(MaVTU) references supplies(MaVTU)    
);
create table delivery_notes(
	SoPX int auto_increment primary key,
    NgayXuat date
);
create table supplies_delivery_notes(
	MaVTU int,
	SoPX int,
    primary key(MaVTU,SoPX),
    DGXuat double,
    SLXuat int,
    foreign key(MaVTU) references supplies(MaVTU),
    foreign key(SoPX) references delivery_notes(SoPX)    
);
create table receipt_notes(
	SoPN int auto_increment primary key,
    NgayNhap date
);
create table supplies_receipt_notes(
	MaVTU int,
	SoPN int,
    primary key(MaVTU,SoPN),
    DGNhap double,
    SLNhap int,
    foreign key(MaVTU) references supplies(MaVTU),
    foreign key(SoPN) references receipt_notes(SoPN)    
);