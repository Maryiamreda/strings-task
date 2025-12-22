-- DROP TABLE Funifier ;
-- DROP TABLE operation ;
CREATE table if not exists Funifier(
                                       id int auto_increment primary key ,
                                       boring_string varchar(50) not null,
    funny_string varchar(50)  not null
    );
CREATE table if not exists Operation(
                                        id int auto_increment primary key ,
                                        operation_name varchar(50) not null,
    start_range int not null,
    end_range int not null,
    boring_string int,
    FOREIGN KEY (boring_string) REFERENCES Funifier(id)
    );
CREATE table if not exists FunRanges(
                                        id int auto_increment primary key ,
                                        boring_string varchar(50) not null,
    funny_string varchar(50)  not null
    );
CREATE table if not exists Ranges(
                                     id int auto_increment primary key ,
                                     start_range int not null,
                                     end_range int not null,
                                     boring_string int,
                                     FOREIGN KEY (boring_string) REFERENCES FunRanges(id)
    );
INSERT INTO Funifier (boring_string,funny_string) VALUES ("zootopia","tt(tt)tt") 
