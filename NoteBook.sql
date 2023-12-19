create table if not exists user(
	id int auto_increment primary key,
    name varchar(10) not null,
    email varchar(100) not null,
    password varchar(20) not null
);

create table if not exists noteBook (
	book_id int auto_increment primary key,
    user_id int not null,
    subject varchar(1000) not null,
    context varchar(2000) not null,
    creat_time timestamp default CURRENT_TIMESTAMP,
    update_time timestamp ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY(user_id) REFERENCES user(id)
);

create table if not exists hashTag(
    user_id int not null,
	book_id int not null,
    tag_name varchar(100) not null,
	FOREIGN KEY(user_id) REFERENCES user(id),
    FOREIGN KEY(book_id) REFERENCES noteBook(book_id)
);

create table if not exists noteFile(
    file_id int auto_increment primary key,
	book_id int not null,
    type int, -- 1: 圖片; 2:其他(doc,xls,pdf...)
    location varchar(1000),
    upload_time timestamp default CURRENT_TIMESTAMP,
	FOREIGN KEY(book_id) REFERENCES noteBook(book_id)
);

