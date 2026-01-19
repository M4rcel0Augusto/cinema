create database cinema_application;

use cinema_application;

create table movie(
id int not null auto_increment,
movie_name varchar(100) not null,
duration_minutes int not null,
genre varchar(50) not null,

primary key(id)



);

create table screening(
id int not null auto_increment,
start_time datetime not null,
end_time datetime not null,
movie_id int not null,
primary key(id),
constraint fk_screening_movie
foreign key(movie_id) REFERENCES movie (id)

);




create table product(
id int not null auto_increment,
product_name varchar(256) not null,
product_type ENUM('FOOD', 'DRINK', 'TICKET', 'OTHER') NOT NULL,
size char(2), -- XL, L, M, S. Será usado um jCOmboBox.
				
quantity_in_stock int not null,                
unit_price decimal(10,2) not null,
unit_cost decimal(10,2) not null,
primary key(id)


);




-- o gerente receberá um alarta quando o estoque de algum produto estiver a baixo do mínimo definido. 
create table product_stock_alert(
id int auto_increment primary key,
product_id int not null,
minimum_quantity int,
below_minimum boolean default false,
constraint fk_alert_product
foreign key(product_id) references product(id)


);


-- será usada pera registrar as vendas
-- será útil para a realização de reembolso e para as pesquisar com filtros

create table sale( -- como uma lista. É útil para identificar quando foram feitos pedidos maiores de uma unidade.
id BIGINT not null auto_increment primary key,
sale_datetime datetime not null,

screening_id INT NOT NULL,
total_amount DECIMAL(10,2) NOT NULL,


CONSTRAINT fk_sale_screening
FOREIGN KEY (screening_id) REFERENCES screening (id)


);


create table item_sale (
id BIGINT not null auto_increment primary key,
sale_id BIGINT not null,
product_id INT null,
combo_id INT null,
quantity int not null,
refund_quantity int default 0,
unit_price decimal(10,2) not null,
unit_cost decimal(10,2) not null,

foreign key (sale_id) references sale(id),
foreign key (product_id) references product(id),
foreign key (combo_id) references combo(id)
);

create table combo(
id int not null auto_increment,
combo_name varchar(256) not null,
price decimal(10,2) not null,
primary key(id)
);

create table combo_item(
combo_id INT NOT NULL,
product_id INT NOT NULL,
quantity INT NOT NULL,

PRIMARY KEY (combo_id, product_id),

FOREIGN KEY (combo_id) REFERENCES combo(id),
FOREIGN KEY (product_id) REFERENCES product(id)



);


select * from product;
select * from sale;
select * from item_sale;
select * from movie;



