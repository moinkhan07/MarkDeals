create table Admin{
    adminId int primary key auto_increment,
    city varchar(255) notNull,
	state varchar(255) notNull,
	country varchar(255) notNull,
	pincode varchar(255) notNull,
    adminName varchar(255),
    email varchar(255) UNIQUE,
    password varchar(255)
}
create table Users{
    userId int primary key auto_increment,
    city varchar(255) Not Null,
	state varchar(255) Not Null,
	country varchar(255) Not Null,
	pincode varchar(6) Not Null,
    firstName varchar(15) Not Null,
    lastName varchar(12) Not Null,
    userMobile varchar(10) Not Null,
    userEmail varchar(255) Not Null UNIQUE,
    password varchar(20) Not Null
}
create table Product{
    productId int primary key auto_increment,
    category varchar(255) Not Null,
    description varchar(255) Not Null,
    imageUrl varchar(255) Not Null,
    name varchar(255) Not Null,
    price int Not Null,
    quantity int Not Null,
    rating varchar(255) Not Null
}
create table Cart{
    cartId int primary key auto_increment,
    foreign key (cartId) references Users(userId)
}
create table Cart_Product{
    cartId int Not Null,
    productId int Not Null,
    foreign key (cartId) references Cart(cartId)
    foreign key (productId) references Product(productId) 
}
create table Orders{
    orderId int primary key auto_increment,
    deliveryDate date,
    placedDate date,
    status varchar(255),
    foreign key (orderId) references Users(userId)
}
create table Orders_Product{
    orderId int Not Null,
    productId int Not Null,
    foreign key (orderId) references Orders(orderId)
    foreign key (productId) references Product(productId) 
}










