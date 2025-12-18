CREATE table if not exist fun_ranges{
    id int auto_increment primary key ,
    boring_string varchar(50) not null,
    funny_string varchar(50)  not null,
}
CREATE table if not exist stringfunifier{
    id int auto_increment primary key ,
    boring_string varchar(50) not null,
    funny_string varchar(50)  not null,
}

CREATE table if not exist ranges{
  id int auto_increment primary key ,
  start_range int not null,
  end_range int not null,
  boring_string int,
  FOREIGN KEY (boring_string) REFERENCES fun_ranges(id)
}


CREATE table if not exist operation{
  id int auto_increment primary key ,
  name varchar(50) not null,
  start_range int not null,
  end_range int not null,
  boring_string int,
  FOREIGN KEY (boring_string) REFERENCES stringfunifier(id)
}